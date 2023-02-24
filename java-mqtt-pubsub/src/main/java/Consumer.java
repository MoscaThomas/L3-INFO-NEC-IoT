import main.java.Message;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import main.java.DatabaseManagement;

public class Consumer {

	private static final String EXCHANGE_NAME = "logs";

	public static void main(String[] argv) throws Exception {

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
			Message objMessage = new Message(message);

			System.out.println(" [x] Received '" + message + "'\n");

			Double prix = objMessage.getPrix();
			Double pourcentage = objMessage.getPourcentage();

			System.out.println(" Prix : "+ prix + "\n");
			System.out.println(" Pourcentage : "+ pourcentage + " %\n");

			System.out.println("resultat de l'insertion: " + DatabaseManagement.insert(pourcentage, prix));


			//System.out.println(" [x] Received '" + prix + "'\n");
			//System.out.println(" [x] Received '" + pourcentage +"'\n");
		};


		channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
		});
	}

}
