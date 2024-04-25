package core.emr.api.controller;

import core.emr.api.document.VitalSign;
import core.emr.api.service.VitalSignService;
import core.emr.api.service.VitalSignServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping("/patient")
@CrossOrigin
@Slf4j
public class PatientController {

    @Autowired
    VitalSignService vitalSignService;

    @PostMapping(path = "/saveVitalSign")
    public Mono<VitalSign> saveVitalSign(@RequestBody VitalSign vitalSign) {
        log.info("saveVitalSign : " + vitalSign);
        if (vitalSign.getId() == null) {
            vitalSign.setCreatedDate(new Date());
        }
        return vitalSignService.save(vitalSign);
    }

    @GetMapping(path = "/findVitalSign")
    public Mono<VitalSign> findVitalSign(@RequestParam String id) {
        log.info("/findVitalSign : id : " + id);
        return vitalSignService.findById(id);
    }

    @GetMapping(path = "/findVitalByBookingId")
    public Mono<VitalSign> findByBookingId(@RequestParam String bid) {
        log.info("/findByBookingId : bid : " + bid);
        return vitalSignService.findByBookingId(bid);
    }

    @GetMapping(path = "/findVitalByFilter")
    public Flux<VitalSign> findByFilter(@RequestParam String from, @RequestParam String to, @RequestParam String regNo) {
        log.info("/findByFilter : regNo : " + regNo);
        return vitalSignService.findByFilter(from,to,regNo);
    }

    @GetMapping(path = "/findVitalByRegNo")
    public Mono<VitalSign> findByRegNo(@RequestParam String regNo) {
        log.info("/findByregNo : regNo : " + regNo);
        return vitalSignService.findByRegNo(regNo);
    }

    @GetMapping(path = "/getVitalSign")
    public Flux<VitalSign> getVitalSign() {
        log.info("/getVitalSign");
        return vitalSignService.findAll();
    }

    @GetMapping(path = "/deleteVitalSign")
    public Mono<?> deleteVitalSignById(@RequestParam String id) {
        log.info("/deleteVitalSign : id : " + id);
        return vitalSignService.deleteVitalSignById(id);
    }
}
