package fr.yodamad.bc.data;

import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "beer")
public interface BeerRepository extends ReactiveCouchbaseRepository<Beer, String> {
}
