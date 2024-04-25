package core.emr.api.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import core.emr.api.document.OpdReVisitDate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OpdReVisitDateServieImpl implements OpdReVisitDateServcie {

    @Autowired
    private ReactiveMongoTemplate template;

    public Mono<OpdReVisitDate> save(OpdReVisitDate visitDate) {
        return template.save(visitDate);
    }

    public Mono<OpdReVisitDate> findById(String id) {
        return template.findById(id,OpdReVisitDate.class);
    }

    public Flux<OpdReVisitDate> findAll() {
        return template.findAll(OpdReVisitDate.class);
    }

    public Mono<?> deleteById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return template.remove(query, OpdReVisitDate.class);
    }

}
