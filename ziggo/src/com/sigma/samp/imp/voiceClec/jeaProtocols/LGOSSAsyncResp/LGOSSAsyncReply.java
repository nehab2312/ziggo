package com.sigma.samp.imp.voiceClec.jeaProtocols.LGOSSAsyncResp;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.ws.BindingType;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import com.sigma.hframe.jlog.Log;
import com.sigma.jea.adpttask.AdptTask;
import com.sigma.jea.cfgdata.AdptGlobals;
import com.sigma.jea.flow.AsyncFlow;
import com.sigma.jea.flow.AsyncReplyException;
import com.sigma.jea.shelfProtocol.basicsoap.BasicSoapCallProtocol;
import com.sigma.jea.util.PropUtil;
import com.sigma.vframe.sbsmp.jea.AdptConfigError;
import com.sigma.vframe.sbsmp.jea.TaskExecException;

//import com.sigma.hframe.jlog.Log;

@WebService(portName = "PS_NL_Provisioning_ASAPVoice_SOAP", targetNamespace = "http://www.sigma.com/provisioning_ASAPVoice/Schema", serviceName = "provisioning_ASAPVoice", endpointInterface = "com.sigma.samp.imp.voiceClec.jeaProtocols.LGOSSAsyncResp.PSNLProvisioningASAPVoiceWS", wsdlLocation = "WEB-INF/Provisioning_ASAPVoiceAsyn.wsdl")
@BindingType(javax.xml.ws.soap.SOAPBinding.SOAP11HTTP_BINDING)
public class LGOSSAsyncReply extends BasicSoapCallProtocol implements PSNLProvisioningASAPVoiceWS {

	private static Log LOG = new Log(LGOSSAsyncReply.class);
	@Resource
	WebServiceContext wsctx;

	public ProvisioningASAPVoiceResultResponseType invoke(ProvisioningASAPVoiceResult provAsapVoicResult) {
		String authenticationParms = null;
		try {
			authenticationParms = super.getNEStrParm(HTTP_AUTHENTICATION);
		} catch (AdptConfigError eAC) {
			LOG.log("No init parm defined for http basic authentication (expected parm is " + HTTP_AUTHENTICATION + "),"
					+ " basic authentication support will be disabled");
		}
		String [] authParm=authenticationParms.split(":");
		LOG.log("username {}",authParm[0] );
		LOG.log("password {}",authParm[1] );
		MessageContext mctx = wsctx.getMessageContext();
		Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
		List userList = (List) http_headers.get("Username");
		List passList = (List) http_headers.get("Password");

		String username = "";
		String password = "";

		if (userList != null) {
			// get username
			username = userList.get(0).toString();
		}

		if (passList != null) {
			// get password
			password = passList.get(0).toString();
		}

		// Should validate username and password with database
		if (username.equals(authParm[0]) && password.equals(authParm[1])) {
			ByteArrayOutputStream ouputStream = new ByteArrayOutputStream();
			Marshaller marshaller;
			try {
				marshaller = JAXBContext.newInstance(ProvisioningASAPVoiceResult.class).createMarshaller();
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
				marshaller.marshal(provAsapVoicResult, ouputStream);
				LOG.log("Marshalling the service response object {}", ouputStream.toString());

			} catch (JAXBException e) {
				LOG.log("JAXBException {}", e);
			}
			Properties replyParms = new Properties();
			replyParms.put("adapter_status", "completed");
			replyParms.put("async_response", ouputStream.toString());

			AsyncFlow flow = null;
			try {

				flow = (AsyncFlow) AdptGlobals.getFlowFactory().getFlow();
				try {
					if (flow != null) {
						AdptTask adptTask = flow.processAsyncReplyTask(provAsapVoicResult.getHeader().getRequestID(),
								PropUtil.properties2HashMap(replyParms));
						LOG.log("Task updated sucessfully..");
					}
				} catch (AsyncReplyException e) {
					LOG.log("AsyncReplyException occured:: {}", e);
				} catch (TaskExecException e) {
					LOG.log("TaskExecException occured:: {}", e);
				}

			} catch (Exception e) {
				LOG.log("Exception occured::", e);
			}

			ProvisioningASAPVoiceResultResponseType response = new ProvisioningASAPVoiceResultResponseType();
			response.setStatus("SUCCESS");

			return response;
		} else {
			return null;
		}

	}

}
