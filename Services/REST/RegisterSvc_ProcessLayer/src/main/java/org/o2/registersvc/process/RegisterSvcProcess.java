package org.o2.registersvc.process;

import java.io.FileNotFoundException;

import org.o2.registersvc.process.beans.RegisterSvcProcessVBReq;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBRes;

public interface RegisterSvcProcess {

	RegisterSvcProcessVBRes enrollment(RegisterSvcProcessVBReq vbReq);

}
