package core.emr.api.service;

import core.emr.api.document.Doctor;
import core.emr.api.document.PharmacyPattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PharmacyPatternServiceImpl implements PharmacyPatternService {

    @Autowired
    private ReactiveMongoTemplate template;

    @Override
    public Mono<PharmacyPattern> save(PharmacyPattern pp){
        return template.save(pp);
    }
    @Override
    public Mono<PharmacyPattern> findById(String id){
        Query query = new Query(Criteria.where("_id").is(id));
        return template.findOne(query, PharmacyPattern.class);
    }
    @Override
    public Flux<PharmacyPattern> findAll(){
        return template.findAll(PharmacyPattern.class);
    }
    @Override
    public Mono<?> deleteById(String id){
        Query query = new Query(Criteria.where("_id").is(id));
        return template.remove(query, PharmacyPattern.class);
    }
}
