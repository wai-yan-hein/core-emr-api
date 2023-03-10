package core.emr.api.service;

import core.emr.api.document.OPD;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OPDService {
    Mono<OPD> save(OPD doctor);
    Mono<OPD> findById(String id);
    Flux<OPD> findAll();
}
