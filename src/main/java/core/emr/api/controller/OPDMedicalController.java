package core.emr.api.controller;

import core.emr.api.document.OPDLabResult;
import core.emr.api.document.OPDMedicalHis;
import core.emr.api.document.OPDMedicalHisCashier;
import core.emr.api.dto.VoucherDto;
import core.emr.api.service.DcService;
import core.emr.api.service.OPDLabResultService;
import core.emr.api.service.OPDMedicalHisService;
import core.emr.api.service.OTService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/opdMedical")
@CrossOrigin
@Slf4j
@RequiredArgsConstructor
public class OPDMedicalController {

    @Autowired
    OPDMedicalHisService opdMedicalHisService;

    @Autowired
    OPDLabResultService opdLabResultService;

    private final OTService otService;

    private final DcService dcService;

    @PostMapping(path = "/save-opdMedicalHis")
    public Mono<OPDMedicalHis> saveOPDMedicalHis(@RequestBody OPDMedicalHis d) {
        log.info("/save-opdMedicalHis : d : " + d);
        return opdMedicalHisService.save(d);
    }

    //from htut
    @PutMapping(path = "/updateOpdMedicalHisTreatItem")
    public Mono<OPDMedicalHisCashier> updateOPDMedicalHisTreatItem(@RequestBody OPDMedicalHisCashier model) {
        log.info("/update-opdMedicalHis trate item : d : " + model);
        return opdMedicalHisService.updateCashierTreatment(model);
    }

    @GetMapping(path = "/searchOpdMedicalHis")
    public Flux<OPDMedicalHisCashier> findOpdHisByFilter(@RequestParam String from, @RequestParam String to) {
        log.info("/find-opdMedicalHis : opdMedicalHisFilter : " + from + "::" + to);
        return opdMedicalHisService.findByFilterMHC(from, to);
    }

    @GetMapping(path = "/find-opdMedicalHis")
    public Mono<OPDMedicalHis> findById(@RequestParam String visitId) {
        log.info("/find-opdMedicalHis : opdMedicalHisId : " + visitId);
        return opdMedicalHisService.findByVisitIdMH(visitId);
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

    @GetMapping(path = "/findOPDMedicalHisCashier")
    public Flux<OPDMedicalHisCashier> getOPDMedicalHisCashier(@RequestParam String from, @RequestParam String to) {
        //  log.info("/getOPDMedicalHisCashier : visitId : " + visitId);
        return opdMedicalHisService.findByFilterMHC(from, to);
    }

    @GetMapping(path = "/getOPDMedicalHisCashier")
    public Mono<OPDMedicalHisCashier> getOPDMedicalHisCashier(@RequestParam String visitId) {
        log.info("/getOPDMedicalHisCashier : visitId : " + visitId);
        return opdMedicalHisService.findByVisitIdMHC(visitId);
    }

    @PostMapping(path = "/save-opdMedicalHisCashier")
    public Mono<OPDMedicalHisCashier> saveOPDMedHIsCashier(@RequestBody OPDMedicalHisCashier ohc) {
        log.info("/save-opdMedicalHisCashier");
        return opdMedicalHisService.saveCashier(ohc);
    }

    @GetMapping(path = "/getOPDVoucher")
    public Flux<VoucherDto> getOPDVoucher(@RequestParam String from, @RequestParam String to) {
        log.info("/getOPDVoucher : visitId : ");
        return opdMedicalHisService.getOpdVoucherByFilter(from, to);
    }

    @GetMapping(path = "/getVouchers")
    public Flux<VoucherDto> getVouchers(@RequestParam String from, @RequestParam String to, @RequestParam String regNo) {
//        Flux<Integer> flux1 = Flux.just(1, 2, 3, 4, 5);
//        Flux<Integer> flux2 = Flux.just(6, 7, 8, 9, 10);
//        return Flux.concat(flux1, flux2);
        Flux<VoucherDto> opdVoucher = opdMedicalHisService.getOpdVoucherByRegNo(from, to, regNo);
        Flux<VoucherDto> otVoucher = otService.getOtVoucherByRegNo(from, to, regNo);
        Flux<VoucherDto> dcVoucher = dcService.getDcVoucherByRegNo(from, to, regNo);
        return Flux.concat( opdVoucher,otVoucher,dcVoucher);
    }
}
