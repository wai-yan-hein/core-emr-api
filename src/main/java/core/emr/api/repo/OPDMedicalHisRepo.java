package core.emr.api.repo;

import core.emr.api.document.OPDMedicalHis;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface OPDMedicalHisRepo extends ReactiveMongoRepository<OPDMedicalHis, String> {
}
