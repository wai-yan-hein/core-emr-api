package core.emr.api.service;

import core.emr.api.document.OPDMedicalHis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OPdMedicalHisServiceImpl implements OPDMedicalHisService {
    @Autowired
    private ReactiveMongoTemplate template;

    @Override
    public Mono<OPDMedicalHis> save(OPDMedicalHis opdMedicalHis) {
        return template.save(opdMedicalHis);
    }

    @Override
    public Mono<OPDMedicalHis> findById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return template.findById(query, OPDMedicalHis.class);
    }

    @Override
    public Flux<OPDMedicalHis> findAll() {
        return template.findAll(OPDMedicalHis.class);
    }

    @Override
    public Mono<?> deleteOPDMedicalHisById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return template.remove(query, OPDMedicalHis.class);
    }

    @Override
    public Mono<Void> deleteAll() {
        return null;
    }
}
