import java.text.DecimalFormat;
import java.util.Random;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Producer {

	private static final String EXCHANGE_NAME = "logs";
	private static final String ROUTING_KEY = "#my_route";

	public static void main(String[] argv) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("52.47.79.56");
		try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
			channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
			Double prix = 45000.0;
			while(true){
				Random random = new Random();
				double n = (random.nextDouble() * 20.0) - 10.0;
				prix = prix * (1 + n / 100);
				DecimalFormat decimalFormat = new DecimalFormat("#0.0");
				// On prépare le message que l'on envoie
				String message = "% modif : " + decimalFormat.format(n) + "||| prix : " + decimalFormat.format(prix) + "\n";

				channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, null, message.getBytes("UTF-8"));
				
				// Confirmation de l'envoi
				System.out.println(" [x] Sent '" + message + "'");

				Thread.sleep(5000);
			}



		}
	}

}
