package core.emr.api.service;

import core.emr.api.document.OPD;
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
public class OPDServiceImpl implements OPDService{
    @Autowired
    private ReactiveMongoTemplate template;
    @Override
    public Mono<OPD> save(OPD opd) {
        log.info("saved.");
        return template.save(opd);
    }

    @Override
    public Mono<OPD> findOPDById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return template.findById(query, OPD.class);
    }

    @Override
    public Flux<OPD> findAll() {
        return template.findAll(OPD.class);
    }


}
