package core.emr.api.service;

import core.emr.api.document.OpdReVisitDate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OpdReVisitDateServcie {
    Mono<OpdReVisitDate> save(OpdReVisitDate pp);

    Mono<OpdReVisitDate> findById(String id);

    Flux<OpdReVisitDate> findAll();

    Mono<?> deleteById(String id);
}
