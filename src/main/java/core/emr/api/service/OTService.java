package core.emr.api.service;

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
public class OTService {

    private final ReactiveMongoTemplate template;

    public Flux<VoucherDto> getOtVoucher(String from, String to, String vouNo) {
        Query query = new Query(Criteria.where("otDate").gte(CVUtil.toISODate(from)).lte(CVUtil.toISODate(to)));
        log.info("query :"+query);
        return template.find(query, OTHis.class)
                .map(his->{
                    OTHis ot=new OTHis();
                    return ot.toVouDto(his);
                });
    }

    public Mono<OTHis> getOtVoucherByVouNo(String vouNo) {
        Query query = new Query((Criteria.where("vouNo").is(vouNo)));
        return template.findOne(query, OTHis.class);
    }

    public Mono<OTHis> saveOtVoucher(OTHis model) {
        model.setCreatedDate(LocalDateTime.now());
        model.setUpdatedDate(LocalDateTime.now());
        return template.save(model);
    }

    public Mono<?> removeOtVoucher(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return template.remove(query, OTHis.class);
    }

}
