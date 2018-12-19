package nyo.springlifecycle.config.infra;

import nyo.springlifecycle.service.infra.InfraInitializingBeanService;
import nyo.springlifecycle.service.infra.InfraLifecycleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfraConfig {

	@Bean
	public InfraLifecycleService infraLifecycleService() {
		return new InfraLifecycleService();
	}

	@Bean
	public InfraInitializingBeanService infraInitializingBeanService() {
		return new InfraInitializingBeanService();
	}

}
