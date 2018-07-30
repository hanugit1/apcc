package org.o2.registersvc.client;

import org.o2.registersvc.client.beans.RegisterSvcWebReq;
import org.o2.registersvc.client.beans.RegisterSvcWebRes;
import org.o2.registersvc.client.exception.ApplicationExceptions;

public interface RegisterSvcClient {
	RegisterSvcWebRes enrollment(RegisterSvcWebReq webReq) throws ApplicationExceptions;
}
