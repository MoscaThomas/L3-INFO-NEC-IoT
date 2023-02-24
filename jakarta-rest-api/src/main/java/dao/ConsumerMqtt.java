import javax.servlet.annotation.WebListener;
import javax.servlet.ServletContextListener;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import dao.FluctuationDao;
import dao.Message;

@WebListener
public class ConsumerMqtt implements ServletContextListener {

    private static final String EXCHANGE_NAME = "logs";

    public ConsumerMqtt() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("java-mqtt-pubsub-broker");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, EXCHANGE_NAME, "");

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + delivery.getEnvelope().getRoutingKey() + "':'" + message + "'");

            Message objMessage = new Message(message);

			System.out.println(" [x] Received '" + message + "'\n");

			Double prix = objMessage.getPrix();
			Double pourcentage = objMessage.getPourcentage();

			System.out.println(" Prix : "+ prix + "\n");
			System.out.println(" Pourcentage : "+ pourcentage + " %\n");

            FluctuationDao.addFluctuation(prix, pourcentage);
        };

        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
        });
    }

}