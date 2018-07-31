package org.o2.registersvc.restclient.springclientconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.o2.registersvc.restclient.beans.RegisterSvcWebReq;
import org.o2.registersvc.restclient.beans.RegisterSvcWebRes;
import org.o2.registersvc.restclient.impl.RegisterSvcRestClientImpl;
import org.springframework.context.annotation.Bean;

@Configuration
@ComponentScan(value = { "org.o2.registersvc.restclient.impl", "org.o2.registersvc.restclient.impl" })
@Import(value = {})
public class SpringRestClientConfig {

	@Bean
	public RegisterSvcWebReq getRegSvcWebReq() {
		return new RegisterSvcWebReq();
	}

	@Bean
	public RegisterSvcWebRes getRegSvcWebRes() {
		return new RegisterSvcWebRes();
	}

	@Bean
	public RegisterSvcRestClientImpl getRegSvcRestClientImpl() {
		return new RegisterSvcRestClientImpl();
	}
}
