package core.emr.api.controller;

import core.emr.api.document.OPDMedicalHis;
import core.emr.api.service.OPDMedicalHisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/opdMedical")
public class OPDMedicalController {

    @Autowired
    OPDMedicalHisService opdMedicalHisService;
    @PostMapping(path = "/save-opdMedicalHis")
    public Mono<OPDMedicalHis> saveDoctor(@RequestBody OPDMedicalHis d) {
        return opdMedicalHisService.save(d);
    }

    @GetMapping(path = "/get-opdMedicalHis")
    public Flux<OPDMedicalHis> findAll() {
        return opdMedicalHisService.findAll();
    }

    @GetMapping(path = "/find-opdMedicalHis")
    public Mono<OPDMedicalHis> findById(@RequestParam String opdMedicalHisId) {
        return opdMedicalHisService.findById(opdMedicalHisId);
    }

    @GetMapping(path = "/deleteAll-opdMedicalHis")
    public Mono<Void> deleteAll() {
        return opdMedicalHisService.deleteAll();
    }

    @GetMapping(path = "/delete-opdMedicalHis")
    public Mono<Void> deleteById(@RequestParam String opdMedicalHisId) {
        return opdMedicalHisService.deleteById(opdMedicalHisId);
    }
}
