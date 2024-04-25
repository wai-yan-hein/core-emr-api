package core.emr.api.service;

import core.emr.api.document.Doctor;
import core.emr.api.document.OPD;
import core.emr.api.document.OPDLabResult;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OPDLabResultService {
    Mono<OPDLabResult> save(OPDLabResult opdLabResult);
    Mono<OPDLabResult> findById(String id);
    Flux<OPDLabResult> findAll();
    Mono<?> deleteOPDLabResultById(String id);
}
