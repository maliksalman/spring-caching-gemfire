package com.smalik.gemfirecaching;

import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.gemfire.config.annotation.EnableCachingDefinedRegions;
import org.springframework.data.gemfire.config.annotation.EnableExpiration;
import org.springframework.data.gemfire.expiration.ExpirationActionType;

@SpringBootApplication
@EnableExpiration(policies = {
		@EnableExpiration.ExpirationPolicy(
				timeout=15,
				action=ExpirationActionType.INVALIDATE,
				regionNames="my-beans",
				types=EnableExpiration.ExpirationType.TIME_TO_LIVE)
})
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
