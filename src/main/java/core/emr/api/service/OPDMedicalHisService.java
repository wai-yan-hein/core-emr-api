package core.emr.api.service;

import core.emr.api.document.OPDMedicalHis;
import core.emr.api.document.OPDMedicalHisCashier;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OPDMedicalHisService {
    Mono<OPDMedicalHis> save(OPDMedicalHis opdMedicalHis);
    Mono<OPDMedicalHis> findById(String id);
    Mono<OPDMedicalHis> medicalFindByVisitId(String id);
    Mono<OPDMedicalHisCashier> findByVisitId(String id);
    Flux<OPDMedicalHis> findAll();
    Mono<?> deleteOPDMedicalHisById(String id);
    Mono<Void> deleteAll();

    Mono<OPDMedicalHisCashier> saveCashier(OPDMedicalHisCashier cashierHis);
}
