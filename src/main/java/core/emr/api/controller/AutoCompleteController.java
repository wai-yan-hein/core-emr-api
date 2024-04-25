package core.emr.api.controller;


import core.emr.api.document.MedTerms;
import core.emr.api.service.MedTermsServiceImpl;
import core.emr.api.service.WHOICDServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/autoComplete")
@CrossOrigin
@Slf4j
public class AutoCompleteController {
    @Autowired
    MedTermsServiceImpl medTermsService;
    @Autowired
    WHOICDServiceImpl whoicdService;

    @GetMapping("/medTermsAutoComplete")
    public Flux<?> medTermsAutoComplete(@RequestParam String medDesc) {
        log.info("/medTermsAutoComplete : medDesc : " + medDesc);
        return medTermsService.findByDesc(medDesc).take(20);
    }

    @GetMapping("/whoICDAutoComplete")
    public Flux<?> whoIcdAutoComplete(@RequestParam String icdCodeOrDesc) {
        log.info("/whoICDAutoComplete : icdCodeOrDesc : " + icdCodeOrDesc);
        return whoicdService.findByCodeAndDesceng(icdCodeOrDesc).take(20);
    }

    @PostMapping("/savemed")
    public Mono<?> save(@RequestBody MedTerms term) {
        log.info("/whoICDAutoComplete : icdCodeOrDesc : " + term);
        return medTermsService.save(term);
    }

}
