package com.smalik.gemfirecaching;

import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.gemfire.config.annotation.EnableCachingDefinedRegions;
import org.springframework.data.gemfire.config.annotation.EnableEviction;
import org.springframework.data.gemfire.config.annotation.EnableExpiration;
import org.springframework.data.gemfire.config.annotation.EnableStatistics;
import org.springframework.data.gemfire.eviction.EvictionActionType;
import org.springframework.data.gemfire.expiration.ExpirationActionType;

@SpringBootApplication
@EnableStatistics
public class GemfireCachingApplication {

	public static void main(String[] args) {
		SpringApplication.run(GemfireCachingApplication.class, args);
	}

	@Profile("!cloud")
	@Configuration
	@EnableCachingDefinedRegions(clientRegionShortcut = ClientRegionShortcut.LOCAL)
	public static class CachingForLocal {}

	@Profile("cloud")
	@Configuration
	@EnableCachingDefinedRegions(clientRegionShortcut = ClientRegionShortcut.PROXY)
	public static class CachingForCloud {}
}
