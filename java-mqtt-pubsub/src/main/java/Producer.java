import java.util.Random;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Producer {

	private static final String EXCHANGE_NAME = "logs";
	private static final String ROUTING_KEY = "#my_route";

	public static void main(String[] argv) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
			channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

			while(1){
				Random random = new Random();
				Int randomNumber = random.nextInt(101) + 50;
				String message = randomNumber;
				System.out.println("Routing key : " + ROUTING_KEY + " ; message : " + message);

				channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, null, message.getBytes("UTF-8"));
				System.out.println(" [x] Sent '" + message + "'");

				sleep(5);
			}



		}
	}

}
