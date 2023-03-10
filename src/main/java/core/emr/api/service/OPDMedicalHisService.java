package core.emr.api.service;

import core.emr.api.document.Doctor;
import core.emr.api.document.OPDMedicalHis;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OPDMedicalHisService {
    Mono<OPDMedicalHis> save(OPDMedicalHis opdMedicalHis);
    Mono<OPDMedicalHis> findById(String id);
    Flux<OPDMedicalHis> findAll();

    Mono<Void> deleteById(String id);
    Mono<Void> deleteAll();
}
