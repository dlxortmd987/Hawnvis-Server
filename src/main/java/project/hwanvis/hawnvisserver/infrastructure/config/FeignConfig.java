package project.hwanvis.hawnvisserver.infrastructure.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("project.hwanvis.hawnvisserver.infrastructure")
public class FeignConfig {
}
