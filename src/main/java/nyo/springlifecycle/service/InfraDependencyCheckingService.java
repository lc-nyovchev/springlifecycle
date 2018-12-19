package nyo.springlifecycle.service;

import lombok.NonNull;
import nyo.springlifecycle.service.infra.InfraInitializingBeanService;
import nyo.springlifecycle.service.infra.InfraLifecycleService;
import org.springframework.stereotype.Service;


@Service
public class InfraDependencyCheckingService {

	@NonNull private final InfraLifecycleService infraLifecycleService;
	@NonNull private final InfraInitializingBeanService infraInitializingBeanService;

	public InfraDependencyCheckingService(InfraLifecycleService infraLifecycleService, InfraInitializingBeanService infraInitializingBeanService) {
		this.infraLifecycleService = infraLifecycleService;
		this.infraInitializingBeanService = infraInitializingBeanService;

		check();
	}

	private void check() {
		// check that the lifecycle's start method was actually not called
		assert (!infraLifecycleService.getInfraInstantiated());

		// however, the initializingBean's afterPropertiesSet was actually called
		assert (infraInitializingBeanService.getInfraInstantiated());
	}

}
