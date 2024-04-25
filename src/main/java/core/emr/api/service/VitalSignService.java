package core.emr.api.service;

import core.emr.api.document.VitalSign;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface VitalSignService {
    Mono<VitalSign> save(VitalSign vitalSign);
    Mono<VitalSign> findById(String id);
    Mono<VitalSign> findByBookingId(String bid);
    Flux<VitalSign> findAll();
    Mono<?> deleteVitalSignById(String id);
    Mono<VitalSign> findByRegNo(String regNo);
    Flux<VitalSign> findByFilter(String from,String to,String regNo);
}
