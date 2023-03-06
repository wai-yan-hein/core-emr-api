package core.emr.api.repo;

import core.emr.api.document.WHOICDData;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface WHOICDRepo extends ReactiveMongoRepository<WHOICDData,String> {
}
