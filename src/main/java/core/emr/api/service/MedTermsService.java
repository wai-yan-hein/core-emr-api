package core.emr.api.service;

import core.emr.api.document.MedTerms;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.InputStream;

public interface MedTermsService {
    Mono<MedTerms> save(MedTerms doctor);
    Mono<MedTerms> findById(String id);

    Flux<MedTerms> findByDesc(String desc);
    Flux<MedTerms> findAll();

    Mono<?> deleteMedTermsById(String id);

    void saveMedTerms(InputStream file);
}
