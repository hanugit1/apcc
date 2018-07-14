package org.o2.registersvc.service.validator;

import org.o2.registersvc.schema.req.AccountDetailsType;
import org.o2.registersvc.schema.req.CardDetailsType;
import org.o2.registersvc.schema.req.ClientDetailsType;
import org.o2.registersvc.schema.req.RegisterServiceReqType;
import org.o2.registersvc.service.util.RegisterSvcReqInvalidException;

public class RegisterServiceValidator {

	public void validateWsReq(RegisterServiceReqType wsReq) throws RegisterSvcReqInvalidException {
		if(wsReq == null || wsReq.getAccountDetails() == null || wsReq.getCardDetails() == null 
				|| wsReq.getClientDetails() == null) {
			throw new RegisterSvcReqInvalidException("reg001", "Req Object is null");
		}
		
		ClientDetailsType clientDetails = new ClientDetailsType();
		if(clientDetails.getClientId() == null || " ".equals(clientDetails.getClientId())) {
			throw new RegisterSvcReqInvalidException("reg002", "ClientId is invalid");
		}
		if(clientDetails.getChannelId() == null || " ".equals(clientDetails.getChannelId())) {
			throw new RegisterSvcReqInvalidException("reg003", "ChennelId is invalid");
		}
		if(clientDetails.getReqId() == null || " ".equals(clientDetails.getReqId())) {
			throw new RegisterSvcReqInvalidException("reg004", "ReqId is invalid");
		}
		
		AccountDetailsType accDetails = new AccountDetailsType();
		if(accDetails.getAccountNum() == null || " ".equals(accDetails.getAccountNum())) {
			throw new RegisterSvcReqInvalidException("reg005", "AccountNum is invalid");
		}
		/*ir(accDetails.getMobileNum() == null || " ".equals(accDetails.getMobileNum())){
			throw new RegisterSvcReqInvalidException("reg006", "MobileNum is invalid");
		}*/
		
		CardDetailsType cardDetails = new CardDetailsType();
		if(cardDetails.getCardNum() == null || " ".equals(cardDetails.getCardNum())) {
			throw new RegisterSvcReqInvalidException("reg007", "CardNum is invalid");
		}
		if(cardDetails.getCvv() == null || " ".equals(cardDetails.getCvv())) {
			throw new RegisterSvcReqInvalidException("reg008", "CvvNum is invalid");
		}
		if(cardDetails.getExpDate() == null || " ".equals(cardDetails.getExpDate())) {
			throw new RegisterSvcReqInvalidException("reg009", "ExpDate is invalid");
		}
		if(cardDetails.getNameOnCard() == null || " ".equals(cardDetails.getNameOnCard())) {
			throw new RegisterSvcReqInvalidException("reg010", "NameOnCard is invalid");
		}
	}

}
//