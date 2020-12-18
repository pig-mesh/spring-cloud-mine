package com.pig4cloud.cloud.mesh.config.client;

import com.pig4cloud.cloud.mesh.config.client.manage.ConfigLoad;
import com.pig4cloud.cloud.mesh.config.client.manage.HttpConfigLoad;
import com.pig4cloud.cloud.mesh.config.client.properties.MeshConfigServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lengleng
 * @date 2020/12/18
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(MeshConfigServerProperties.class)
public class MeshConfigBootstrapConfiguration {

	@Bean
	public ConfigLoad configLoad(MeshConfigServerProperties properties) {
		return new HttpConfigLoad(properties);
	}

	@Bean
	public PropertySourceLocator propertySourceLocator(ConfigLoad configLoad) {
		return new MeshPropertySourceLocator(configLoad);
	}

}
