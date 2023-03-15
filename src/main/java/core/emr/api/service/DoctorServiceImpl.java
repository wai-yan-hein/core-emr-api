package core.emr.api.service;

import core.emr.api.document.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private ReactiveMongoTemplate template;

    @Override
    public Mono<Doctor> save(Doctor doctor) {
        return template.save(doctor);
    }

    @Override
    public Mono<Doctor> findById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return template.findOne(query, Doctor.class);
    }

    @Override
    public Flux<Doctor> findAll() {
        return template.findAll(Doctor.class);
    }

    @Override
    public Mono<?> deleteDoctorById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return template.remove(query, Doctor.class);
    }

}
