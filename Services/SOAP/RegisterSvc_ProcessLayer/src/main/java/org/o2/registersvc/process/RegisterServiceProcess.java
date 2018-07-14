package org.o2.registersvc.process;

import java.io.FileNotFoundException;

import org.o2.registersvc.intg.util.BusinessException;
import org.o2.registersvc.intg.util.SystemException;
import org.o2.registersvc.intg.util.UnknownException;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBReq;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBRes;

public interface RegisterServiceProcess {

	RegisterSvcProcessVBRes enrollment(RegisterSvcProcessVBReq vbReq) throws FileNotFoundException, BusinessException, SystemException, UnknownException;

}
