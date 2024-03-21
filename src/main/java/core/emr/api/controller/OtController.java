package core.emr.api.controller;

import core.emr.api.document.OTHis;
import core.emr.api.service.OTService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ot")
public class OtController {
    private final OTService otService;

    @PostMapping("/saveOtVoucher")
    public Mono<OTHis> saveOtVoucher(@RequestBody OTHis model){
        return otService.saveOtVoucher(model);
    }

}
