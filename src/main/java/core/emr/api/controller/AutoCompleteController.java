package core.emr.api.controller;

import core.emr.api.document.MedTerms;
import core.emr.api.document.WHOICDData;
import core.emr.api.service.MedTermsServiceImpl;
import core.emr.api.service.WHOICDServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

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
}
