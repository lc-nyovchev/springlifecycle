package nyo.springlifecycle.service.infra;

import lombok.Getter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@Service
@Getter
public class InfraInitializingBeanService implements InitializingBean {

	private Boolean infraInstantiated = FALSE;

	@Override
	public void afterPropertiesSet() {
		infraInstantiated = TRUE;
	}
}
