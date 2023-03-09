package core.emr.api.repo;

import core.emr.api.document.Doctor;
import core.emr.api.document.OPD;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OPDRepo extends ReactiveMongoRepository<OPD, String> {
}
