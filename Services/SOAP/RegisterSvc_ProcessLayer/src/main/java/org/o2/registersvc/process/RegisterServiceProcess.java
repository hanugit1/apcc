package org.o2.registersvc.process;

import org.o2.registersvc.process.beans.RegisterSvcProcessVBReq;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBRes;

public interface RegisterServiceProcess {

	RegisterSvcProcessVBRes enrollment(RegisterSvcProcessVBReq vbReq);

}
