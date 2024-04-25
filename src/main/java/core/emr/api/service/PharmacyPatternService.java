package core.emr.api.service;

import core.emr.api.document.PharmacyPattern;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PharmacyPatternService {
    Mono<PharmacyPattern> save(PharmacyPattern pp);
    Mono<PharmacyPattern> findById(String id);
    Flux<PharmacyPattern> findAll();
    Mono<?> deleteById(String id);
}
