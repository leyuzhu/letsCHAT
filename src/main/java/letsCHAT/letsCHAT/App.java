package letsCHAT.letsCHAT;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.bitlet.weupnp.GatewayDevice;
import org.bitlet.weupnp.GatewayDiscover;
import org.xml.sax.SAXException;

/**
 * Hello world!
 *
 */
public class App {

	final static Logger logger = Logger.getLogger(App.class.getSimpleName());

	public static void main(String[] args) {
		System.out.println("Hello World!");

		logger.info("Starting weupnp");

		GatewayDiscover discover = new GatewayDiscover();
		logger.info("Looking for Gateway Devices");
		try {
			discover.discover();
			GatewayDevice d = discover.getValidGateway();
			if (null != d) {
				logger.info("Found gateway device. " +  d.getModelName() + " " + d.getModelDescription() + "\n");
			} else {
				logger.info("No valid gateway device found.");
				return;
			}

		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// // Start the server service
		// (new Thread(new ServerService())).start();

		// Start the client service
		// (new Thread(new ClientService())).start();
	}
}
