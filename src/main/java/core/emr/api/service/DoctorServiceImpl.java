package core.emr.api.service;

import core.emr.api.document.Doctor;
import core.emr.api.repo.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorRepo repo;

    @Override
    public Mono<Doctor> save(Doctor doctor) {
        return repo.save(doctor);
    }

    @Override
    public Mono<Doctor> findById(String id) {
        return repo.findById(id);
    }

    @Override
    public Flux<Doctor> findAll() {
        return repo.findAll();
    }
}
