package core.emr.api.repo;

import core.emr.api.document.MedTerms;
import core.emr.api.document.WHOICDData;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface WHOICDRepo extends ReactiveMongoRepository<WHOICDData,String> {

    Flux<WHOICDData> findByCodeOrDescEngStartingWithIgnoreCase(String code, String descEng);
}
