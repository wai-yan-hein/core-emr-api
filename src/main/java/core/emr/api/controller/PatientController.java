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
        if(vitalSign.getId() == null){
            vitalSign.setCreatedDate(new Date());
        }
        return vitalSignService.save(vitalSign);
    }

    @PostMapping(path = "/findVitalSign")
    public Mono<VitalSign> findVitalSign(@RequestParam String id) {
        return vitalSignService.findById(id);
    }

    @GetMapping(path = "getVitalSign")
    public Flux<VitalSign> getVitalSign() {
        return vitalSignService.findAll();
    }

    @PostMapping(path = "deleteVitalSign")
    public Mono<?> deleteVitalSignById(@RequestParam String id) {
        return vitalSignService.deleteVitalSignById(id);
    }
}
