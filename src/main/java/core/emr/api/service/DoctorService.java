package core.emr.api.service;

import core.emr.api.document.Doctor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.print.Doc;

public interface DoctorService {
    Mono<Doctor> save(Doctor doctor);
    Mono<Doctor> findById(String id);
    Flux<Doctor> findAll();

}
