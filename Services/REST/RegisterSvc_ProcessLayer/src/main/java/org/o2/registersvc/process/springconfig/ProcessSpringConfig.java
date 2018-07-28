package org.o2.registersvc.process.springconfig;

import org.o2.registersvc.creditcheck.springconfig.CreditCheckSpringConfig;
import org.o2.registersvc.intg.springconfig.IntgSpringConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "org.o2.registersvc.process.impl", "org.o2.registersvc.process.builder",
		"org.o2.registersvc.process.beans" })
@Import(value = { CreditCheckSpringConfig.class, IntgSpringConfig.class })
public class ProcessSpringConfig {

}
