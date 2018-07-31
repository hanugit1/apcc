package org.o2.registersvc.restclient.impl;

import org.o2.registersvc.restclient.beans.RegisterSvcWebRes;
import org.o2.registersvc.restclient.beans.RegisterSvcWebReq;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.ClientResponse;
import javax.ws.rs.core.MediaType;

public class RegisterSvcRestClientImpl {
	public RegisterSvcWebRes enrollment(RegisterSvcWebReq wsReq) {
		System.out.println("Client Impl: " + wsReq);

		// Set URI
		String url = "http://localhost:8080/RegisterSvcResourceWeb/rest/service/getEnrollment?" + "accNum="
				+ wsReq.getAccountNum() + "&" + "mobNum=" + wsReq.getMobileNum() + "&" + "cvv=" + wsReq.getCvv() + "&"
				+ "expDate=" + wsReq.getExpDate() + "&" + "nameOnCard=" + wsReq.getCardNum();

		// Create the Client object
		Client client = Client.create();

		// Using Client object get the WebResource object
		WebResource webResource = client.resource(url);

		// invoke the service using resource object
		ClientResponse clientResp = webResource.accept(MediaType.APPLICATION_JSON)
				.header("x-client-id", wsReq.getClientId()).header("x-channel-id", wsReq.getChannelId())
				.header("x-req-id", wsReq.getReqId()).get(ClientResponse.class);

		ClientResponse clientResp2 = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

		// Get Response in String
		String Resp = clientResp2.getEntity(String.class);
		System.out.println(Resp);

		RegisterSvcWebRes webResp = new RegisterSvcWebRes();
		webResp.setScore(63.5f);
		webResp.setStatus("Good");
		webResp.setRespCode("0000");
		webResp.setRespMsg("Success");
		return webResp;

	}
}
