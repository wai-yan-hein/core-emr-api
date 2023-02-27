package core.emr.api.service;

import core.emr.api.document.Doctor;
import core.emr.api.document.OPD;
import core.emr.api.repo.OPDRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Slf4j
@Service
public class OPDServiceImpl implements OPDService{
    @Autowired
    private OPDRepo repo;
    @Override
    public Mono<OPD> save(OPD opd) {
        log.info("saved.");
        return repo.save(opd);
    }

    @Override
    public Mono<OPD> findById(String id) {
        return repo.findById(id);
    }

    @Override
    public Flux<OPD> findAll() {
        return repo.findAll();
    }


}
