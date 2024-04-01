package core.emr.api.controller;

import core.emr.api.document.DcHis;
import core.emr.api.dto.VoucherDto;
import core.emr.api.service.DcService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/ward")
@CrossOrigin
@RequiredArgsConstructor
public class WardController {
    private final DcService dcService;

    @GetMapping("/getDcVoucher")
    public Flux<VoucherDto> getDcVoucher(@RequestParam String from, @RequestParam String to) {
        return dcService.getDcVoucher(from, to, "");
    }

    @PostMapping("/saveDcVoucher")
    public Mono<DcHis> saveDcVoucher(@RequestBody DcHis model) {
        return dcService.saveDcVoucher(model);
    }

}
