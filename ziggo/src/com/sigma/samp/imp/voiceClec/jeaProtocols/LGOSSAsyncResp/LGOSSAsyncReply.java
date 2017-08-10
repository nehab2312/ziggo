package com.sigma.samp.imp.voiceClec.jeaProtocols.LGOSSAsyncResp;

import java.io.ByteArrayOutputStream;
import java.util.Properties;

import javax.jws.WebService;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.ws.BindingType;

import com.sigma.hframe.jlog.Log;
import com.sigma.jea.adpttask.AdptTask;
import com.sigma.jea.cfgdata.AdptGlobals;
import com.sigma.jea.flow.AsyncFlow;
import com.sigma.jea.flow.AsyncReplyException;
import com.sigma.jea.util.PropUtil;
import com.sigma.vframe.sbsmp.jea.TaskExecException;

//import com.sigma.hframe.jlog.Log;

@WebService(portName = "PS_NL_Provisioning_ASAPVoice_SOAP", targetNamespace = "http://www.sigma.com/provisioning_ASAPVoice/Schema", serviceName = "provisioning_ASAPVoice", endpointInterface = "com.sigma.samp.imp.voiceClec.jeaProtocols.LGOSSAsyncResp.PSNLProvisioningASAPVoiceWS", wsdlLocation = "WEB-INF/Provisioning_ASAPVoiceAsyn.wsdl")
@BindingType(javax.xml.ws.soap.SOAPBinding.SOAP11HTTP_BINDING)
public class LGOSSAsyncReply implements PSNLProvisioningASAPVoiceWS {

	private static Log LOG = new Log(LGOSSAsyncReply.class);

	public ProvisioningASAPVoiceResultResponseType invoke(
			ProvisioningASAPVoiceResult provAsapVoicResult) {
		
		ByteArrayOutputStream ouputStream = new ByteArrayOutputStream();
		Marshaller marshaller;
		try {
			marshaller = JAXBContext.newInstance(
					ProvisioningASAPVoiceResult.class).createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
					Boolean.TRUE);
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
			LOG.log("LGOSSAsyncReply 1");
            flow = (AsyncFlow) AdptGlobals.getFlowFactory().getFlow();
            try {
            	LOG.log("LGOSSAsyncReply 2");
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
		LOG.log("LGOSSAsyncReply 67");
		ProvisioningASAPVoiceResultResponseType response = new ProvisioningASAPVoiceResultResponseType();
		response.setStatus("SUCCESS");

		return response;
	}

}
