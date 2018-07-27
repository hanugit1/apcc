package org.o2.registersvc.creditcheck.springconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "org.o2.registersvc.creditcheck.impl", "org.o2.registersvc.creditcheck.beans",
		"org.o2.registersvc.creditcheck.builders" })
public class CreditCheckSpringConfig {

}
