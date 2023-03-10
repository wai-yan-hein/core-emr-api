package core.emr.api.service;

import core.emr.api.document.Doctor;
import core.emr.api.document.OPDMedicalHis;
import core.emr.api.repo.DoctorRepo;
import core.emr.api.repo.OPDMedicalHisRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OPdMedicalHisServiceImpl implements OPDMedicalHisService {
    @Autowired
    private OPDMedicalHisRepo repo;

    @Override
    public Mono<OPDMedicalHis> save(OPDMedicalHis opdMedicalHis) {
        return repo.save(opdMedicalHis);
    }

    @Override
    public Mono<OPDMedicalHis> findById(String id) {
        return repo.findById(id);
    }

    @Override
    public Flux<OPDMedicalHis> findAll() {
        return repo.findAll();
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return repo.deleteById(id);
    }

    @Override
    public Mono<Void> deleteAll() {
        return repo.deleteAll();
    }
}
