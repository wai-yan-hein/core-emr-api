package core.emr.api.controller;

import core.emr.api.document.OPDLabResult;
import core.emr.api.document.OPDMedicalHis;
import core.emr.api.document.OPDMedicalHisCashier;
import core.emr.api.document.OpdReVisitDate;
import core.emr.api.service.OPDLabResultService;
import core.emr.api.service.OPDMedicalHisService;
import core.emr.api.service.OpdReVisitDateServcie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/opdMedical")
@CrossOrigin
@Slf4j
public class OPDMedicalController {

    @Autowired 
    OPDMedicalHisService opdMedicalHisService;

    @Autowired
    OPDLabResultService opdLabResultService;
    @Autowired
    OpdReVisitDateServcie opdReVisitService;

    @PostMapping(path = "/save-opdMedicalHis")
    public Mono<OPDMedicalHis> saveOPDMedicalHis(@RequestBody OPDMedicalHis d) {
        log.info("/save-opdMedicalHis : d : " + d);
        return opdMedicalHisService.save(d);
    }

    @GetMapping(path = "/get-opdMedicalHis")
    public Flux<OPDMedicalHis> findAll() {
        log.info("/get-opdMedicalHis");
        return opdMedicalHisService.findAll();
    }

    @GetMapping(path = "/find-opdMedicalHis")
    public Mono<OPDMedicalHis> findById(@RequestParam String opdMedicalHisId) {
        log.info("/find-opdMedicalHis : opdMedicalHisId : " + opdMedicalHisId);
        return opdMedicalHisService.findById(opdMedicalHisId);
    }

    @GetMapping(path = "/deleteAll-opdMedicalHis")
    public Mono<Void> deleteAll() {
        log.info("/deleteAll-opdMedicalHis");
        return opdMedicalHisService.deleteAll();
    }

    @GetMapping(path = "/delete-opdMedicalHis")
    public Mono<?> deleteById(@RequestParam String opdMedicalHisId) {
        log.info("/delete-opdMedicalHis : opdMedicalHisId : " + opdMedicalHisId);
        return opdMedicalHisService.deleteOPDMedicalHisById(opdMedicalHisId);
    }

    @PostMapping(path = "/save-opdlabresult")
    public Mono<OPDLabResult> saveOPDLabResult(@RequestBody OPDLabResult d) {
        log.info("/save-opdlabresult : d : " + d);
        return opdLabResultService.save(d);
    }

    @GetMapping(path = "/get-opdlabresult")
    public Flux<OPDLabResult> findAllOPDLabResult() {
        log.info("/get-opdlabresult");
        return opdLabResultService.findAll();
    }

    @GetMapping(path = "/find-opdlabresult")
    public Mono<OPDLabResult> findOPDLabResultById(@RequestParam String opdLabResultId) {
        log.info("/find-opdlabresult : opdLabResultId : " + opdLabResultId);
        return opdLabResultService.findById(opdLabResultId);
    }

    @GetMapping(path = "/delete-opdlabresult")
    public Mono<?> deleteOPDLabResultById(@RequestParam String opdLabResultId) {
        log.info("/delete-opdlabresult : opdLabResultId : " + opdLabResultId);
        return opdLabResultService.deleteOPDLabResultById(opdLabResultId);
    }

    @GetMapping(path = "/getOPDMedicalHisCashier")
    public Mono<OPDMedicalHisCashier> getOPDMedicalHisCashier(@RequestParam String visitId){
        log.info("/getOPDMedicalHisCashier : visitId : " + visitId);
        return opdMedicalHisService.findByVisitId(visitId);
    }

    @PostMapping(path = "/save-opdMedicalHisCashier")
    public Mono<OPDMedicalHisCashier> saveOPDMedHIsCashier(@RequestBody OPDMedicalHisCashier ohc){
        log.info("/save-opdMedicalHisCashier");
        return opdMedicalHisService.saveCashier(ohc);
    }


    @PostMapping(path = "/save-opdReVisitDate")
    public Mono<OpdReVisitDate> saveOPDRevisitDate(@RequestBody OpdReVisitDate d) {
        log.info("/save-opdReVisitDate : d : " + d);
        return opdReVisitService.save(d);
    }

    @GetMapping(path = "/get-opdReVisitDate")
    public Flux<OpdReVisitDate> findAllRevisitDate() {
        log.info("/get-opdReVisitDate");
        return opdReVisitService.findAll();
    }

    @GetMapping(path = "/find-opdReVisitDate")
    public Mono<OpdReVisitDate> findRevisitDateById(@RequestParam String RevisitDateId) {
        log.info("/find-opdReVisitDate : opdReVisitDateId : " + RevisitDateId);
        return opdReVisitService.findById(RevisitDateId);
    }

    @GetMapping(path = "/delete-opdReVisitDate")
    public Mono<?> deleteRevisitDateById(@RequestParam String RevisitDateId) {
        log.info("/delete-opdReVisitDate : opdReVisitDateId : " + RevisitDateId);
        return opdReVisitService.deleteById(RevisitDateId);
    }



    
}
