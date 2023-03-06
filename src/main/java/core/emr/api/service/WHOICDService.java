package core.emr.api.service;

import core.emr.api.document.WHOICDData;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WHOICDService {
    Mono<WHOICDData> save(WHOICDData doctor);
    Mono<WHOICDData> findById(String id);

    Flux<WHOICDData> findByDesc(String desc);
    Flux<WHOICDData> findAll();

    Mono<WHOICDData> delete();

    boolean saveAllWHOICDData();
}
