package core.emr.api.service;

import core.emr.api.document.Doctor;
import core.emr.api.document.OPDLabResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Slf4j
@Service
public class OPDLabResultServiceImpl implements OPDLabResultService{

    @Autowired
    ReactiveMongoTemplate template;
    @Override
    public Mono<OPDLabResult> save(OPDLabResult opdLabResult) {
        return template.save(opdLabResult);
    }

    @Override
    public Mono<OPDLabResult> findById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return template.findOne(query, OPDLabResult.class);
    }

    @Override
    public Flux<OPDLabResult> findAll() {
        return template.findAll(OPDLabResult.class);
    }

    @Override
    public Mono<?> deleteOPDLabResultById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return template.remove(query, OPDLabResult.class);
    }
}
