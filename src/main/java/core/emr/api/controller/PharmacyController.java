package core.emr.api.controller;

import core.emr.api.document.PharmacyPattern;
import core.emr.api.service.PharmacyPatternService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/pharmacy")
@CrossOrigin
@Slf4j
public class PharmacyController {
    @Autowired
    private PharmacyPatternService ppService;

    @PostMapping(path = "/save-pharmacy-pattern")
    public Mono<PharmacyPattern> savePharmacyPattern(@RequestBody PharmacyPattern pp){
        log.info("/save-pharmacy-pattern");
        return ppService.save(pp);
    }

    @GetMapping(path = "/get-pharmacy-pattern")
    public Flux<PharmacyPattern> findAllPharmacyPattern(){
        log.info("/get-pharmacy-pattern");
        return ppService.findAll();
    }
}
