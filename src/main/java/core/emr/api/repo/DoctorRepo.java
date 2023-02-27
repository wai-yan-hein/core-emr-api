package core.emr.api.repo;

import core.emr.api.document.Doctor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepo extends ReactiveMongoRepository<Doctor, String> {
}
