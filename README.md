# Spring Lifecycle vs Initializing Bean
A small project to demonstrate the difference between `InitializingBean` and `Lifecycle`


# Related

Often you'd want some context to be started before you move on to higher level contexts.
Example: when you have an **Infrastructure** layer which needs to be initialized **before**
a **Service** layer in your unit tests: database before repository tests, cloud config before cloud tests, etc.


In this repo we have defined two services defined in an **InfraConfig**:

- InfraInitializingBeanService (implements InitializingBean)
- InfraLifecycleService (implements Lifecycle)

And we have, defined in a **ServiceConfig** (which imports **InfraConfig**)

- InfraDependencyCheckingService

```java
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
```

As you can see by the assertions, the service which implements Lifecycle is actually **NOT fully instantiated** (start() not called) when needed in
the **ServiceConfig** context, while the service implementing InitializingBean is **fully instantiated** and ready to go.
