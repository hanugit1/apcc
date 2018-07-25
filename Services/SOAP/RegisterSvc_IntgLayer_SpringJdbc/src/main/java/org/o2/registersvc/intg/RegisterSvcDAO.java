package org.o2.registersvc.intg;

import java.io.FileNotFoundException;

import org.o2.registersvc.intg.beans.RegisterSvcDAOReq;
import org.o2.registersvc.intg.beans.RegisterSvcDAORes;
import org.o2.registersvc.intg.util.BusinessException;
import org.o2.registersvc.intg.util.SystemException;
import org.o2.registersvc.intg.util.UnknownException;

public interface RegisterSvcDAO {//
	public RegisterSvcDAORes enrollment(RegisterSvcDAOReq daoReq)
			throws FileNotFoundException, BusinessException, SystemException, UnknownException;
}
