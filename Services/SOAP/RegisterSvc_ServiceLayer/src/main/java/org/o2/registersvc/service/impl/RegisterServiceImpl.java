package org.o2.registersvc.service.impl;

import org.o2.registersvc.process.RegisterServiceProcess;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBReq;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBRes;
import org.o2.registersvc.schema.req.RegisterServiceReqType;
import org.o2.registersvc.schema.res.RegisterServiceResType;
import org.o2.registersvc.schema.res.StatusBlockType;
import org.o2.registersvc.service.builder.RegisterServiceReqBuilder;
import org.o2.registersvc.service.builder.RegisterServiceResBuilder;
import org.o2.registersvc.service.util.BusinessException;
import org.o2.registersvc.service.util.RegisterSvcReqInvalidException;
import org.o2.registersvc.service.util.SystemException;
import org.o2.registersvc.service.util.UnknownException;
import org.o2.registersvc.service.validator.RegisterServiceValidator;

public class RegisterServiceImpl {
	RegisterServiceResType wsResp = null;

	public RegisterServiceResType enrollment(RegisterServiceReqType wsReq) {

		try {
			// 1.Get the Req from Consumer/Client
			// 2.Validate the Req
			RegisterServiceValidator validator = new RegisterServiceValidator();
			validator.validateWsReq(wsReq);

			// 3.Prepare the Process Req
			RegisterServiceReqBuilder reqBuilder = new RegisterServiceReqBuilder();
			RegisterSvcProcessVBReq vbReq = reqBuilder.buildProcessReq(wsReq);

			// 4.Call the Process
			RegisterServiceProcess process = new RegisterServiceImpl();
			RegisterSvcProcessVBRes vbResp = process.enrollment(vbReq);

			// 5.Prepare the Service Response
			RegisterServiceResBuilder respBuilder = new RegisterServiceResBuilder();
			wsResp = respBuilder.buildWsResp(vbResp);

		} catch (RegisterSvcReqInvalidException e) {
			e.printStackTrace();
			StatusBlockType status = new StatusBlockType();
			status.setRespCode(e.getRespCode());
			status.setRespMsg(e.getRespMsg());
			wsResp.setStatusBlock(status);
		} catch (BusinessException e) {
			e.printStackTrace();
			StatusBlockType status = new StatusBlockType();
			status.setRespCode(e.getRespCode());
			status.setRespMsg(e.getRespMsg());
			wsResp.setStatusBlock(status);
		} catch (SystemException e) {
			e.printStackTrace();
			StatusBlockType status = new StatusBlockType();
			status.setRespCode(e.getRespCode());
			status.setRespMsg(e.getRespMsg());
			wsResp.setStatusBlock(status);
		} catch (UnknownException e) {
			e.printStackTrace();
			StatusBlockType status = new StatusBlockType();
			status.setRespCode(e.getRespCode());
			status.setRespMsg(e.getRespMsg());
			wsResp.setStatusBlock(status);
		} catch (Exception e) {
			e.printStackTrace();
			StatusBlockType status = new StatusBlockType();
			status.setRespCode("reg111");
			status.setRespMsg("Generic Error Message");
		}
		return wsResp;

	}
}
