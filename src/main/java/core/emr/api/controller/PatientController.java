package core.emr.api.controller;

import core.emr.api.document.VitalSign;
import core.emr.api.service.VitalSignService;
import core.emr.api.service.VitalSignServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/patient")
@CrossOrigin
public class PatientController {

    @Autowired
    VitalSignService vitalSignService;

    @PostMapping(path = "/saveVitalSign")
    public Mono<VitalSign> saveVitalSign(@RequestBody VitalSign vitalSign) {
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
