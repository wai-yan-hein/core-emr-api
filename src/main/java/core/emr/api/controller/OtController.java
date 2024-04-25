package core.emr.api.controller;

import core.emr.api.document.OTHis;
import core.emr.api.dto.VoucherDto;
import core.emr.api.service.OTService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ot")
public class OtController {
    private final OTService otService;

    @GetMapping("/getOtVoucher")
    public Flux<VoucherDto> getOtVoucher(@RequestParam String from, @RequestParam String to) {
        return otService.getOtVoucher(from, to, "");
    }

    @PostMapping("/saveOtVoucher")
    public Mono<OTHis> saveOtVoucher(@RequestBody OTHis model) {
        return otService.saveOtVoucher(model);
    }

}
