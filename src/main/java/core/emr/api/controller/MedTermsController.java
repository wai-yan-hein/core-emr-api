package core.emr.api.controller;

import core.emr.api.document.Doctor;
import core.emr.api.document.MedTerms;
import core.emr.api.repo.MedTermsRepo;
import core.emr.api.service.MedTermsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

@RestController
@RequestMapping("medTerms")
public class MedTermsController {

    @Autowired
    private MedTermsService medTermsService;
    private final MedTermsRepo medTermsRepo;

    public MedTermsController(MedTermsRepo medTermsRepo) {
        this.medTermsRepo = medTermsRepo;
    }
    @GetMapping(path = "/saveMedTerms")
    public boolean saveMedTerms() {
        try {
            return medTermsService.saveAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(path = "/find-medTerms-withfilter")
    public Flux<MedTerms> findByDesc(@RequestParam String medTermsDesc) {
        return medTermsService.findByDesc(medTermsDesc);
    }

    @GetMapping("/autocomplete")
    public Flux<String> autocomplete(@RequestParam String input) {
        return medTermsRepo.findByDescStartingWithIgnoreCase(input)
                .map(MedTerms::getDesc)
                .log();
    }
}
