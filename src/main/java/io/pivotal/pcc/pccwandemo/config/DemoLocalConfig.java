package io.pivotal.pcc.pccwandemo.config;


import io.pivotal.pcc.pccwandemo.domain.Customer;
import io.pivotal.pcc.pccwandemo.listener.CustomerListener;
import org.apache.geode.cache.CacheListener;
import org.apache.geode.cache.GemFireCache;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.apache.geode.pdx.ReflectionBasedAutoSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.gemfire.client.ClientCacheFactoryBean;
import org.springframework.data.gemfire.client.ClientRegionFactoryBean;
import org.springframework.data.gemfire.support.ConnectionEndpoint;

@Configuration
@Profile("local")
public class DemoLocalConfig {
	
	@Autowired 
	GemFireCache clientCache;
	
	@Bean(name = "gemfireCache")
	public ClientCacheFactoryBean clientCache() {
		ClientCacheFactoryBean ccf = new ClientCacheFactoryBean();
		ccf.addLocators(new ConnectionEndpoint("localhost", 10334));
		ccf.setPdxSerializer(new ReflectionBasedAutoSerializer(".*"));
		ccf.setPdxReadSerialized(false);
		ccf.setSubscriptionEnabled(true);

		return ccf;
	}
	
	@SuppressWarnings("unchecked")
	@Bean(name = "customer")
	public ClientRegionFactoryBean<String, Customer> customerRegion(@Autowired CustomerListener customerListener) throws Exception {
		ClientRegionFactoryBean<String, Customer> customerRegionFactory = new ClientRegionFactoryBean<>();
		customerRegionFactory.setCache(clientCache);
		customerRegionFactory.setShortcut(ClientRegionShortcut.PROXY);
		customerRegionFactory.setName("customer");
		
		CacheListener<String, Customer>[] cacheListeners = new CacheListener[]{customerListener};
		customerRegionFactory.setCacheListeners(cacheListeners);
		
		return customerRegionFactory;
	}
	
}
