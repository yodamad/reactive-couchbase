package fr.yodamad.bc;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
import org.springframework.data.couchbase.repository.config.EnableReactiveCouchbaseRepositories;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableReactiveCouchbaseRepositories
public class BeerConfiguration extends AbstractCouchbaseConfiguration {
    @Override
    protected List<String> getBootstrapHosts() {
        return Collections.singletonList("127.0.0.1");
    }

    @Override
    protected String getBucketName() {
        return "beer";
    }

    @Override
    protected String getBucketPassword() {
        return "beerbeerbeer";
    }
}
