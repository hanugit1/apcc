package org.o2.registersvc.creditcheck;

import org.o2.registersvc.creditcheck.beans.CreditCheckReq;
import org.o2.registersvc.creditcheck.beans.CreditCheckRes;

public interface CreditCheckSvcClient {
	public CreditCheckRes getCreditScore(CreditCheckReq creditCheckReq);
}
