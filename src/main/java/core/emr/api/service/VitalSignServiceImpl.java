package core.emr.api.service;

import core.emr.api.document.VitalSign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class VitalSignServiceImpl implements VitalSignService{

    @Autowired
    ReactiveMongoTemplate template;
    @Override
    public Mono<VitalSign> save(VitalSign vitalSign) {
        return template.insert(vitalSign);
    }

    @Override
    public Mono<VitalSign> findById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return template.findOne(query, VitalSign.class);
    }

    @Override
    public Mono<VitalSign> findByBookingId(String bid) {
        Query query = new Query(Criteria.where("bookingId").is(bid));
        return template.findOne(query, VitalSign.class);
    }

    @Override
    public Flux<VitalSign> findAll() {
        return template.findAll(VitalSign.class);
    }

    @Override
    public Mono<?> deleteVitalSignById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return template.remove(query, VitalSign.class);
    }
}
