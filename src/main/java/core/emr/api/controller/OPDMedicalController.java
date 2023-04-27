package core.emr.api.controller;

import core.emr.api.document.OPDLabResult;
import core.emr.api.document.OPDMedicalHis;
import core.emr.api.service.OPDLabResultService;
import core.emr.api.service.OPDMedicalHisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/opdMedical")
@CrossOrigin
public class OPDMedicalController {

    @Autowired
    OPDMedicalHisService opdMedicalHisService;

    @Autowired
    OPDLabResultService opdLabResultService;
    @PostMapping(path = "/save-opdMedicalHis")
    public Mono<OPDMedicalHis> saveOPDMedicalHis(@RequestBody OPDMedicalHis d) {
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
    public Mono<?> deleteById(@RequestParam String opdMedicalHisId) {
        return opdMedicalHisService.deleteOPDMedicalHisById(opdMedicalHisId);
    }

    @PostMapping(path = "/save-opdlabresult")
    public Mono<OPDLabResult> saveOPDLabResult(@RequestBody OPDLabResult d) {
        return opdLabResultService.save(d);
    }

    @GetMapping(path = "/get-opdlabresult")
    public Flux<OPDLabResult> findAllOPDLabResult() {
        return opdLabResultService.findAll();
    }

    @GetMapping(path = "/find-opdlabresult")
    public Mono<OPDLabResult> findOPDLabResultById(@RequestParam String opdLabResultId) {
        return opdLabResultService.findById(opdLabResultId);
    }

    @GetMapping(path = "/delete-opdlabresult")
    public Mono<?> deleteOPDLabResultById(@RequestParam String opdLabResultId) {
        return opdLabResultService.deleteOPDLabResultById(opdLabResultId);
    }
}
