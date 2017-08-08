

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.commons.io.IOUtils;
import org.apache.cxf.binding.BindingFactoryManager;
import org.apache.cxf.jaxrs.JAXRSBindingFactory;
import org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean;
import org.apache.cxf.jaxrs.client.WebClient;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

import com.libertyglobal.provisioning_asapvoice.schema.ProvisioningASAPVoice;


public class LgOssStub extends AbstractHandler {

	protected static int PORT = 8181;
	protected static String URL;

	public static void main(String[] args) throws Exception {
		if (args.length < 2) {
			System.out.println("Usage: \"LgOssStub\"  Port providerUrl ");
			System.exit(1);
		}

		PORT = Integer.parseInt(args[0]);
		URL = args[1];
		try {
			Server server = new Server(PORT);
			server.setHandler(new LgOssStub());
			server.start();
			server.join();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void handle(String arg0, Request baseRequest, HttpServletRequest arg2, HttpServletResponse response)
			throws IOException, ServletException {
		InputStream in = baseRequest.getInputStream();
		String str = IOUtils.toString(in);
		try {
			System.out.println("Sync request"+str);
			ProvisioningASAPVoice serviceRequestAsync = (ProvisioningASAPVoice) getCreateUpdateWorkOrderRequestObject(str);
			response.setContentType("text/xml");
			
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			PrintWriter outToClient = response.getWriter();
			String responseString = getServiceResponseSync(serviceRequestAsync);
			outToClient.println(responseString);
			String serviceRespnseAsync = getServiceResponseAsyn(serviceRequestAsync);
			System.out.println("response sent");
			sendAsync(serviceRespnseAsync);
		} catch (XMLStreamException | JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void sendAsync(final String serviceRespnseAsync) {
		new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					JAXRSClientFactoryBean clientFactory = new JAXRSClientFactoryBean();
					// clientFactory.setResourceClass(Resegmentation.class);
					clientFactory.setAddress(URL);
					BindingFactoryManager manager = clientFactory.getBus().getExtension(BindingFactoryManager.class);
					JAXRSBindingFactory factory = new JAXRSBindingFactory();
					factory.setBus(clientFactory.getBus());
					manager.registerBindingFactory(JAXRSBindingFactory.JAXRS_BINDING_ID, factory);
					WebClient client = clientFactory.createWebClient();

					/*HTTPConduit conduit = WebClient.getConfig(client).getHttpConduit();

					String trustStoreFile = System.getProperty("user.dir") + "/ssl/smp_ca_key_store.jks";

					TLSClientParameters tlsCP = new TLSClientParameters();
					tlsCP.setDisableCNCheck(false);
					String keyPassword = "kspass";
					KeyStore trustStore = KeyStore.getInstance("JKS");
					trustStore.load(new FileInputStream(trustStoreFile), keyPassword.toCharArray());

					TrustManagerFactory fac = TrustManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
					fac.init(trustStore);
					TrustManager[] myTrustStoreKeyManagers = fac.getTrustManagers();
					tlsCP.setTrustManagers(myTrustStoreKeyManagers);
					FiltersType filter = new FiltersType();
					filter.getInclude().add(".*_EXPORT_.*");
					filter.getInclude().add(".*_EXPORT1024_.*");
					filter.getInclude().add(".*_WITH_DES_.*");
					filter.getInclude().add(".*_WITH_NULL_.*");
					filter.getExclude().add(".*_DH_anon_.*");
					tlsCP.setCipherSuitesFilter(filter);

					String[] str = new String[] { "SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", "SSL_DH_anon_WITH_RC4_128_MD5",
							"SSL_RSA_EXPORT_WITH_RC4_40_MD5", "SSL_RSA_WITH_RC4_128_MD5", "SSL_RSA_WITH_RC4_128_SHA",
							"TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", "TLS_ECDHE_RSA_WITH_RC4_128_SHA",
							"TLS_ECDH_ECDSA_WITH_RC4_128_SHA", "TLS_ECDH_RSA_WITH_RC4_128_SHA",
							"TLS_ECDH_anon_WITH_RC4_128_SHA", "TLS_KRB5_EXPORT_WITH_RC4_40_MD5",
							"TLS_KRB5_EXPORT_WITH_RC4_40_SHA", "TLS_KRB5_WITH_RC4_128_MD5",
							"TLS_KRB5_WITH_RC4_128_SHA" };

					tlsCP.setCipherSuites(Arrays.asList(str));
					conduit.setTlsClientParameters(tlsCP);
*/
					// *****************************
					client.path("LGOSSreply/provisioning_ASAPVoice?wsdl");
					client.type("text/xml").accept("text/xml");
					System.out.println("URL" + client.getCurrentURI());
					System.out.println("Async response"+serviceRespnseAsync);
					Response r = client.post(serviceRespnseAsync);
					String res = IOUtils.toString((InputStream) r.getEntity());
					System.out.println(res);
				} catch (FileNotFoundException e) {

					e.printStackTrace();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		}).start();
		;
	}

	private Object getCreateUpdateWorkOrderRequestObject(String str) throws XMLStreamException, JAXBException {
		XMLInputFactory xif = XMLInputFactory.newFactory();
		XMLStreamReader xsr = xif.createXMLStreamReader(new StringReader(str));
		while (xsr.hasNext()) {
			if (xsr.isStartElement() && xsr.getLocalName().equals("provisioning_ASAPVoice")) {
				break;
			}
			xsr.next();
		}
		JAXBContext jc = JAXBContext.newInstance(ProvisioningASAPVoice.class);
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		JAXBElement<ProvisioningASAPVoice> je = unmarshaller.unmarshal(xsr, ProvisioningASAPVoice.class);
		ProvisioningASAPVoice serviceRequestAsync = je.getValue();
		return serviceRequestAsync;
	}

	private String getServiceResponseAsyn(ProvisioningASAPVoice notificationRequest) throws IOException {

		String str = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/response/async.xml")));
		// return str;
		return str.replace("${requestId}", notificationRequest.getHeader().getRequestId());

	}

	private String getServiceResponseSync(ProvisioningASAPVoice notificationRequest) throws IOException {

		String str = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/response/sync.xml")));
		return str.replace("${TransactionId}", notificationRequest.getHeader().getRequestId());

	}

}
