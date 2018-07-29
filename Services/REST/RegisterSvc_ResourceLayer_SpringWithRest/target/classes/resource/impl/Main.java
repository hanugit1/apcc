package org.o2.registersvc.resource.impl;

import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.o2.registersvc.schema.req.AccountDetailsType;
import org.o2.registersvc.schema.req.CardDetailsType;
import org.o2.registersvc.schema.req.RegisterServiceReqType;

public class Main {
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException, JAXBException {

		/*JAXBContext jaxbContext = JAXBContext.newInstance(RegisterServiceReqType.class);
		Marshaller marshaller = jaxbContext.createMarshaller();*/
		
		RegisterServiceReqType wsReq = new RegisterServiceReqType();

		// Set CardDetails
		CardDetailsType cardDetails = new CardDetailsType();
		cardDetails.setCardNum("45432");
		cardDetails.setCvv("323");
		cardDetails.setExpDate("02/04/29");
		cardDetails.setNameOnCard("Raghu");
		wsReq.setCardDetails(cardDetails);

		// Set AccountDetails
		AccountDetailsType accDetailsType = new AccountDetailsType();
		accDetailsType.setAccountNum("88888");
		accDetailsType.setMobileNum(9988776655l);

		wsReq.setAccountDetails(accDetailsType);
		wsReq.setCardDetails(cardDetails);

		ObjectMapper mapper = new ObjectMapper();
		String jsonString;
		jsonString = mapper.defaultPrettyPrintingWriter().writeValueAsString(wsReq);
		System.out.println(jsonString);
		
		//marshaller.marshal(wsReq, System.out);
	}
}
