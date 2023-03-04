package core.emr.api.repo;

import core.emr.api.document.MedTerms;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface MedTermsRepo extends ReactiveMongoRepository<MedTerms, String> {
    Flux<MedTerms> findByDescStartingWithIgnoreCase(String desc);
}
