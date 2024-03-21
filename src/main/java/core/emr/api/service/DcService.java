package core.emr.api.service;

import core.emr.api.document.DcHis;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class DcService {
    private final ReactiveMongoTemplate template;

    public Mono<DcHis> saveDcVoucher(DcHis model){
        model.setCreatedDate(LocalDateTime.now());
        model.setUpdatedDate(LocalDateTime.now());
        return template.insert(model);
    }
}
