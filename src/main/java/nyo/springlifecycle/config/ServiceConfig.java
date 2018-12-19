package nyo.springlifecycle.config;

import nyo.springlifecycle.config.infra.InfraConfig;
import nyo.springlifecycle.service.InfraDependencyCheckingService;
import nyo.springlifecycle.service.infra.InfraInitializingBeanService;
import nyo.springlifecycle.service.infra.InfraLifecycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(InfraConfig.class)
public class ServiceConfig {

	@Autowired private InfraInitializingBeanService infraInitializingBeanService;
	@Autowired private InfraLifecycleService infraLifecycleService;

	@Bean
	public InfraDependencyCheckingService dependingOnInfraBeingInstantiatedService() {
		return new InfraDependencyCheckingService(infraLifecycleService, infraInitializingBeanService);
	}
}
