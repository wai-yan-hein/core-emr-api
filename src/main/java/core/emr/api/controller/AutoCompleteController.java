package core.emr.api.controller;

import core.emr.api.document.MedTerms;
import core.emr.api.document.WHOICDData;
import core.emr.api.repo.MedTermsRepo;
import core.emr.api.repo.WHOICDRepo;
import core.emr.api.service.MedTermsService;
import core.emr.api.service.WHOICDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.io.IOException;

@RestController
@RequestMapping("autoComplete")
public class AutoCompleteController {
    @Autowired
    private MedTermsService medTermsService;
    private final MedTermsRepo medTermsRepo;

    public AutoCompleteController(MedTermsRepo medTermsRepo, WHOICDRepo whoicdRepo) {
        this.medTermsRepo = medTermsRepo;
        this.whoicdRepo = whoicdRepo;
    }
    @Autowired
    WHOICDService whoicdService;
    private final WHOICDRepo whoicdRepo;

    @GetMapping(path = "/saveMedTerms")
    public boolean saveMedTerms() {
        try {
            return medTermsService.saveAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/medTermsAutoComplete")
    public Flux<String> medTermsAutoComplete(@RequestParam String input) {
        return medTermsRepo.findByDescStartingWithIgnoreCase(input)
                .map(MedTerms::getDesc)
                .log();
    }
    @GetMapping(path = "/saveWHOICDData")
    public boolean saveWHOICDData()
    {

        return whoicdService.saveAllWHOICDData();
    }

    @GetMapping("/whoIcdAutoComplete")
    public Flux<String> whoIcdAutoComplete(@RequestParam String input) {
        return whoicdRepo.findByCodeOrDescEngStartingWithIgnoreCase(input, input)
                .map(WHOICDData::getDescEng)
                .log();
    }
}
