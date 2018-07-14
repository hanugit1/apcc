package org.o2.registersvc.intg;

import java.io.FileNotFoundException;

import org.o2.registersvc.intg.beans.RegisterServiceDAOReq;
import org.o2.registersvc.intg.beans.RegisterServiceDAORes;
import org.o2.registersvc.intg.util.BusinessException;
import org.o2.registersvc.intg.util.SystemException;
import org.o2.registersvc.intg.util.UnknownException;

public interface RegisterServiceDAO {//
	public RegisterServiceDAORes enrollment(RegisterServiceDAOReq daoReq) throws FileNotFoundException, BusinessException, SystemException, UnknownException;
}
