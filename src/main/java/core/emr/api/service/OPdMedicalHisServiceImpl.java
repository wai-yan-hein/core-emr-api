package core.emr.api.service;

import core.emr.api.document.OPDMedicalHis;
import core.emr.api.document.OPDMedicalHisCashier;
import core.emr.api.document.Treatment;
import core.emr.api.document.TreatmentCashier;
import core.emr.api.util.CVUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

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

    public Mono<OPDMedicalHis> medicalFindByVisitId(String id){
        Query query = new Query((Criteria.where("visitId").is(id)));
        return template.find(query,OPDMedicalHis.class).single();
    }

    @Override
    public Mono<OPDMedicalHisCashier> findByVisitId(String id){
        Query query = new Query((Criteria.where("visitId").is(id)));
        return template.find(query, OPDMedicalHis.class).single()
                .map(his -> {
                    OPDMedicalHisCashier chis = OPDMedicalHisCashier.builder()
                            .visitId(his.getVisitId())
                            .visitDate(CVUtil.convertToLocalDateTime(his.getVisitDate()))
                            .regNo(his.getRegNo())
                            .admissionNo(CVUtil.getStrValue(his.getAdmissionNo(), null))
                            .patientName(his.getPatientName())
                            .drId(his.getDrId())
                            .drName(his.getDrName())
                            .reVisitDate(CVUtil.convertToLocalDate(his.getReVisitDate()))
                            .drNotes(CVUtil.getStrValue(his.getDrNotes(), null))
                            .treatments(getCashierData(his.getTreatments()))
                            .kvDrNotes(his.getKvDrNotes())
                            .build();
                    return chis;
                }).single();
    }

    private List<TreatmentCashier> getCashierData(List<Treatment> list){
        List<TreatmentCashier> listTC = list.stream().map(t -> {
            TreatmentCashier tc = new TreatmentCashier();
            tc.setAmount(CVUtil.doubleNullZero(t.getFees())*CVUtil.floatNullZero(t.getQty()));
            BeanUtils.copyProperties(t, tc);
            return tc;
        }).collect(Collectors.toList());

        TreatmentCashier tc = new TreatmentCashier();

        return listTC;
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

    @Override
    public Mono<OPDMedicalHisCashier> saveCashier(OPDMedicalHisCashier cashierHis){
        return template.save(cashierHis);
    }
}
