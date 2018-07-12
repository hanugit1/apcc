package org.o2.registersvc.service.impl;

import org.o2.registersvc.process.RegisterServiceProcess;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBReq;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBRes;
import org.o2.registersvc.schema.req.RegisterServiceReqType;
import org.o2.registersvc.schema.res.RegisterServiceResType;
import org.o2.registersvc.service.builder.RegisterServiceReqBuilder;
import org.o2.registersvc.service.validator.RegisterServiceValidator;

public class RegisterServiceImpl {
	RegisterServiceResType wsResp = null;
	public RegisterServiceResType enrollment(RegisterServiceReqType wsReq) {
		
		try {
			//1.Get the Req from Consumer/Client
			//2.Validate the Req
			RegisterServiceValidator validator = new RegisterServiceValidator();
			validator.validateWsReq(wsReq);
			//3.Prepare the Process Req
			RegisterServiceReqBuilder reqBuilder = new RegisterServiceReqBuilder();
			RegisterSvcProcessVBReq vbReq = reqBuilder.buildProcessReq(wsReq);
			
			//4.Call the Process
			RegisterServiceProcess process = new RegisterServiceImpl();
			RegisterSvcProcessVBRes vbResp = process.enrollment(vbReq);
		} catch (Exception e) {
			
		}
		return wsResp;
		
		
	}
}
