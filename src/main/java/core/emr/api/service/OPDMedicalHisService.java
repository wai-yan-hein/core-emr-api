package core.emr.api.service;

import core.emr.api.document.OPDMedicalHis;
import core.emr.api.document.OPDMedicalHisCashier;
import core.emr.api.dto.VoucherDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OPDMedicalHisService {
    Mono<OPDMedicalHis> save(OPDMedicalHis opdMedicalHis);

    Mono<OPDMedicalHisCashier> updateCashierTreatment(OPDMedicalHisCashier cashierHis);

    Mono<OPDMedicalHis> findByVisitIdMH(String visitId);

    Flux<OPDMedicalHisCashier> findByFilterMHC(String from, String to);

    Mono<OPDMedicalHisCashier> findByVisitIdMHC(String visitId);
    Mono<?> deleteOPDMedicalHisById(String id);
    Mono<Void> deleteAll();
    Mono<OPDMedicalHisCashier> saveCashier(OPDMedicalHisCashier cashierHis);

    Flux<VoucherDto> getOpdVoucherByFilter(String from, String to);

    Flux<VoucherDto> getOpdVoucherByRegNo(String from, String to,String regNo);
}
