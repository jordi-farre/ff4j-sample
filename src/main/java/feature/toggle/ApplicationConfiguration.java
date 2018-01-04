package feature.toggle;

import org.ff4j.FF4j;
import org.ff4j.redis.RedisConnection;
import org.ff4j.store.EventRepositoryRedis;
import org.ff4j.store.FeatureStoreRedis;
import org.ff4j.store.PropertyStoreRedis;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public FF4j getFF4j() {
        RedisConnection redisConnection = new RedisConnection("localhost", 6379);
        FF4j ff4j = new FF4j();
        ff4j.setFeatureStore(new FeatureStoreRedis(redisConnection));
        ff4j.setPropertiesStore(new PropertyStoreRedis(redisConnection));
        ff4j.setEventRepository(new EventRepositoryRedis(redisConnection));
        ff4j.setAutocreate(true);
        return ff4j;
    }

}
