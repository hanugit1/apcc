package org.o2.registersvc.springclient.impl;

import java.util.HashMap;
import java.util.Map;

import org.o2.registersvc.schema.res.RegisterServiceResType;
import org.o2.registersvc.springclient.beans.RegisterSvcWebReq;
import org.o2.registersvc.springclient.beans.RegisterSvcWebRes;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RegisterSvcSpringClientImpl {
	public RegisterSvcWebRes enrollment(RegisterSvcWebReq webReq) {

		// Set URI
		String url = "http://localhost:8080/RegisterSvc_ResourceWeb/rest/service/getEnrollment";

		// Set headers
		HttpHeaders headers = new HttpHeaders();
		headers.set("content-type", "application/xml");
		headers.set("Accept", "application/xml");
		headers.set("x-client-id", webReq.getClientId());
		headers.set("x-channel-id", webReq.getChannelId());
		headers.set("x-req-id", webReq.getReqId());

		// Set params
		Map<String, String> params = new HashMap<String, String>();
		params.put("accNum", webReq.getAccountNum());
		params.put("mobNum", Long.toString(webReq.getMobileNum()));
		params.put("cvv", webReq.getCvv());
		params.put("expDate", webReq.getExpDate());
		params.put("nameOnCard", webReq.getNameOnCard());
		params.put("cardNum", webReq.getCardNum());

		// Create http entity object
		HttpEntity httpEntity = new HttpEntity(headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> respEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class,
				params);
		System.out.println("Http Resopone: " + respEntity);

		// RegisterServiceResType wsResp = respEntity.getBody();
		System.out.println("wsResp :" + respEntity);

		// para

		return null;

	}
}
