package main.java;

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
			Double prix = 45000.0;
			while(true){
				Random random = new Random();
				Double n = random.nextDouble(21) - 10;
				prix = prix * n / 100;
				String message = "% modif : " + n + " prix : " + prix;
				
				System.out.println("Routing key : " + ROUTING_KEY + " ; message : " + message);

				channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, null, message.getBytes("UTF-8"));
				System.out.println(" [x] Sent '" + message + "'");

				Thread.sleep(5);
			}



		}
	}

}
