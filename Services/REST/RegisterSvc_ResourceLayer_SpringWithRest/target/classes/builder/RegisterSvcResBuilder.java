package org.o2.registersvc.resource.builder;

import org.o2.registersvc.process.beans.RegisterSvcProcessVBRes;
import org.o2.registersvc.schema.res.CreditCheckType;
import org.o2.registersvc.schema.res.RegisterServiceResType;
import org.o2.registersvc.schema.res.StatusBlockType;

public class RegisterSvcResBuilder {
	public RegisterServiceResType buildWsResp(RegisterSvcProcessVBRes vbResp) {
		RegisterServiceResType wsResp = new RegisterServiceResType();
		// Prepare the StatusBlock
		StatusBlockType stBlock = new StatusBlockType();
		stBlock.setRespCode(vbResp.getRespCode());
		stBlock.setRespMsg(vbResp.getRespMsg());

		// Prepare the CreditCheckType Obj//
		CreditCheckType creditCheck = new CreditCheckType();
		creditCheck.setCreditStatus(vbResp.getStatus());
		creditCheck.setRateOfPer(vbResp.getScore());
		return wsResp;

	}
}
