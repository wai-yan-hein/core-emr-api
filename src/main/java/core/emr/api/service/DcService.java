package core.emr.api.service;

import core.emr.api.document.DcHis;
import core.emr.api.document.OTHis;
import core.emr.api.dto.VoucherDto;
import core.emr.api.util.CVUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class DcService {
    private final ReactiveMongoTemplate template;

    public Mono<DcHis> saveDcVoucher(DcHis model) {
        model.setCreatedDate(LocalDateTime.now());
        model.setUpdatedDate(LocalDateTime.now());
        return template.insert(model);
    }

    public Flux<VoucherDto> getDcVoucher(String from, String to, String vouNo) {
        Query query = new Query(Criteria.where("dcDate").gte(CVUtil.toISODate(from)).lte(CVUtil.toISODate(to)));
        log.info("query :" + query);
        return template.find(query, DcHis.class)
                .map(his -> {
                    DcHis ot = new DcHis();
                    return ot.toVouDto(his);
                });
    }

    public Flux<VoucherDto> getDcVoucherByRegNo(String from, String to, String regNo) {
        Query query = new Query(Criteria
                .where("dcDate").gte(CVUtil.toISODate(from)).lte(CVUtil.toISODate(to))
                .and("patientId").is(regNo)
        );
//        Query query = new Query(Criteria
//                .where("patientId").is(regNo)
//        );
        log.info("query :" + query);
        return template.find(query, DcHis.class)
                .map(his -> {
                    DcHis ot = new DcHis();
                    return ot.toVouDto(his);
                });
    }

}
