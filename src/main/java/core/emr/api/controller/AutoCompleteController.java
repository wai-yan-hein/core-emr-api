package core.emr.api.controller;

import core.emr.api.document.MedTerms;
import core.emr.api.document.WHOICDData;
import core.emr.api.repo.MedTermsRepo;
import core.emr.api.repo.WHOICDRepo;
import core.emr.api.service.MedTermsService;
import core.emr.api.service.WHOICDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/autoComplete")
public class AutoCompleteController {
    private final MedTermsRepo medTermsRepo;
    private final WHOICDRepo whoicdRepo;
    public AutoCompleteController(MedTermsRepo medTermsRepo, WHOICDRepo whoicdRepo) {
        this.medTermsRepo = medTermsRepo;
        this.whoicdRepo = whoicdRepo;
    }

    @GetMapping("/medTermsAutoComplete")
    public Flux<String> medTermsAutoComplete(@RequestParam String input) {
        return medTermsRepo.findByDescStartingWithIgnoreCase(input)
                .map(MedTerms::getDesc)
                .log();
    }

    @GetMapping("/whoIcdAutoComplete")
    public Flux<String> whoIcdAutoComplete(@RequestParam String input) {
        return whoicdRepo.findByCodeOrDescEngStartingWithIgnoreCase(input, input)
                .map(WHOICDData::getDescEng)
                .log();
    }
}
