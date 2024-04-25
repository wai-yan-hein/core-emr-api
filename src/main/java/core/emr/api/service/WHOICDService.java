package core.emr.api.service;

import core.emr.api.document.WHOICDData;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.InputStream;

public interface WHOICDService {
    Mono<WHOICDData> save(WHOICDData doctor);
    Mono<WHOICDData> findById(String id);

    Flux<WHOICDData> findByCodeAndDesceng(String desc);
    Flux<WHOICDData> findAll();

    Mono<?> deleteWHOICDDataById(String id);

    void saveWHOICDData(InputStream file);
}
