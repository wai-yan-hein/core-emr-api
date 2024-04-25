package core.emr.api.service;

import core.emr.api.document.*;
import core.emr.api.dto.VoucherDto;
import core.emr.api.util.CVUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OPdMedicalHisServiceImpl implements OPDMedicalHisService {
    @Autowired
    private ReactiveMongoTemplate template;

    @Override
    public Mono<OPDMedicalHis> save(OPDMedicalHis opdMedicalHis) {
        return template.save(opdMedicalHis);
    }

    @Override
    public Mono<OPDMedicalHis> findByVisitIdMH(String visitId) {
        Query query = new Query(Criteria.where("visitId").is(visitId));
        return template.find(query, OPDMedicalHis.class).single().onErrorComplete();
    }

    public Mono<OPDMedicalHis> medicalFindByVisitId(String id) {
        Query query = new Query((Criteria.where("visitId").is(id)));
        return template.findOne(query, OPDMedicalHis.class);
    }

    //from htut
    @Override
    public Flux<OPDMedicalHisCashier> findByFilterMHC(String from, String to) {
        Query query = new Query(Criteria.where("visitDate").gte(CVUtil.toISODate(from)).lte(CVUtil.toISODate(to)));
        log.info("Query : " + query);
        return template.find(query, OPDMedicalHisCashier.class)
                .map(his -> OPDMedicalHisCashier.builder()
                        .id(his.getId())
                        .visitId(his.getVisitId())
                        .visitDate(his.getVisitDate())
                        .regNo(his.getRegNo())
                        .admissionNo(CVUtil.getStrValue(his.getAdmissionNo(), null))
                        .patientName(his.getPatientName())
                        .drId(his.getDrId())
                        .drName(his.getDrName())
                        .reVisitDate(his.getReVisitDate())
                        .drNotes(CVUtil.getStrValue(his.getDrNotes(), null))
                        .treatments(his.getTreatments())
                        .kvDrNotes(his.getKvDrNotes())
                        .build());
    }

    @Override
    public Mono<OPDMedicalHisCashier> findByVisitIdMHC(String visitId) {
        Query query = new Query((Criteria.where("visitId").is(visitId)));
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
                            .reVisitDate(CVUtil.convertToLocalDateTime(his.getReVisitDate()))
                            .drNotes(CVUtil.getStrValue(his.getDrNotes(), null))
                            .treatments(getCashierData(his.getTreatments(), his.getCfType(), his.getCfFees(), his.getIsFoc()))
                            .kvDrNotes(his.getKvDrNotes())
                            .build();
                    return chis;
                });
    }

    private List<TreatmentCashier> getCashierData(List<Treatment> list, OPDCFFeeService cfType, Double cfFees, Boolean isFoc) {
        List<TreatmentCashier> listTC = list.stream().map(t -> {
            TreatmentCashier tc = new TreatmentCashier();
            //  tc.setAmount(CVUtil.doubleNullZero(t.getFees()) * CVUtil.floatNullZero(t.getQty()));
            BeanUtils.copyProperties(t, tc);
            log.info("treatment data old : " + t);
            log.info("treatment data new : " + tc);
            return tc;
        }).collect(Collectors.toList());

        Double amt = 0d;
        amt = cfFees;
        if (!isFoc) {
            amt = cfFees;
        }
        TreatmentCashier tc = TreatmentCashier.builder()
                .group(cfType.getGroupName()).subGroup(cfType.getSubGroupName()).code(cfType.getServiceId())
                .desc(cfType.getServiceName()).pattern(null).days(null).qty(1f).remark(null).relStr(null)
                .expDate(null).fees(cfFees).fees1(0d).fees2(0d).fees3(0d).fees4(0d).fees5(0d).fees6(0d)
                .isPercent(Boolean.FALSE).isFOC(isFoc).serviceCost(0d).itemUnit(null).amount(amt)
                .uniqueId(null).build();
        listTC.add(tc);
        return listTC;
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
    public Mono<OPDMedicalHisCashier> saveCashier(OPDMedicalHisCashier cashierHis) {
        return template.save(cashierHis);
    }


    //from htut
    //save treatment of opd cashier
    @Override
    public Mono<OPDMedicalHisCashier> updateCashierTreatment(OPDMedicalHisCashier model) {
        Query query = new Query(Criteria.where("_id").is(model.getId())); // Assuming "_id" is your document's identifier field
        Update update = new Update().set("treatments", model.getTreatments());
        log.info("query :" + query);
        log.info("update :" + update);
        return template.updateFirst(query, update, OPDMedicalHisCashier.class)
                .flatMap(result -> Mono.just(model));
    }

    @Override
    public Flux<VoucherDto> getOpdVoucherByFilter(String from, String to) {
        Query query = new Query(Criteria.where("visitDate").gte(CVUtil.toISODate(from)).lte(CVUtil.toISODate(to)));
        log.info("Query : " + query);
        return template.find(query, OPDMedicalHisCashier.class)
                .map(his -> {
                    OPDMedicalHisCashier OHC = new OPDMedicalHisCashier();
                    return OHC.toVouDto(his);
                });
    }

    @Override
    public Flux<VoucherDto> getOpdVoucherByRegNo(String from, String to, String regNo) {
        Query query = new Query(Criteria
                .where("visitDate").gte(CVUtil.toISODate(from)).lte(CVUtil.toISODate(to))
                .and("regNo").is(regNo)
        );
//        Query query = new Query(Criteria
//                .where("regNo").is(regNo)
//        );
        log.info("Query : " + query);
        return template.find(query, OPDMedicalHisCashier.class)
                .map(his -> {
                    OPDMedicalHisCashier OHC = new OPDMedicalHisCashier();
                    return OHC.toVouDto(his);
                });
    }


}
