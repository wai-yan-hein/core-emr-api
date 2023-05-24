package core.emr.api.service;

import core.emr.api.document.OPDMedicalHis;
import core.emr.api.document.OPDMedicalHisCashier;
import reactor.core.publisher.Mono;

public interface OPDMedicalHisService {
    Mono<OPDMedicalHis> save(OPDMedicalHis opdMedicalHis);
    Mono<OPDMedicalHis> findByVisitIdMH(String visitId);
    Mono<OPDMedicalHisCashier> findByVisitIdMHC(String visitId);
    Mono<?> deleteOPDMedicalHisById(String id);
    Mono<Void> deleteAll();
    Mono<OPDMedicalHisCashier> saveCashier(OPDMedicalHisCashier cashierHis);
}
