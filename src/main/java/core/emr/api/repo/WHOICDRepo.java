package core.emr.api.repo;

import core.emr.api.document.WHOICDData;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
@Repository
public interface WHOICDRepo extends ReactiveMongoRepository<WHOICDData,String> {

    Flux<WHOICDData> findByCodeOrDescEngStartingWithIgnoreCase(String code, String descEng);
}
