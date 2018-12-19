package nyo.springlifecycle.service.infra;

import lombok.Getter;
import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Service;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@Service
@Getter
public class InfraLifecycleService implements Lifecycle {

	private Boolean infraInstantiated = FALSE;

	@Override
	public void start() {
		infraInstantiated = TRUE;
	}

	@Override
	public void stop() {
		// do nothing
	}

	public boolean isRunning() {
		return false;
	}
}
