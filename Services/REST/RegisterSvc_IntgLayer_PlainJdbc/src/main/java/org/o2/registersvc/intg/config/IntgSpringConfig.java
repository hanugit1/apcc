package org.o2.registersvc.intg.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = { "org.o2.registersvc.intg.beans", "org.o2.registersvc.intg.impl" })
public class IntgSpringConfig {

}
