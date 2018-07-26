package org.o2.registersvc.resource;

import org.o2.registersvc.schema.req.RegisterServiceReqType;
import org.o2.registersvc.schema.res.RegisterServiceResType;

public interface RegisterSvcResource {
	public RegisterServiceResType getEnrollment(RegisterServiceReqType wsReq);
}
