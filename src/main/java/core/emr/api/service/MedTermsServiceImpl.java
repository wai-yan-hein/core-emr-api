package core.emr.api.service;

import core.emr.api.common.Util1;
import core.emr.api.document.MedTerms;
import core.emr.api.document.WHOICDData;
import core.emr.api.repo.MedTermsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class MedTermsServiceImpl implements MedTermsService {
    @Autowired
    MedTermsRepo medTermsRepo;
    @Autowired
    private Environment env;
    @Override
    public Mono<MedTerms> save(MedTerms medTerms) {
        return medTermsRepo.save(medTerms);
    }

    @Override
    public Mono<MedTerms> findById(String id) {
        return medTermsRepo.findById(id);
    }

    @Override
    public Flux<MedTerms> findByDesc(String desc) {
        Flux<MedTerms> medTermsList = findAll();
        return medTermsList.filter(des-> des.getDesc().startsWith(desc));
    }

    @Override
    public Flux<MedTerms> findAll() {
        return medTermsRepo.findAll();
    }

    @Override
    public Mono<MedTerms> delete() {
        return null;
    }

    public void saveMedTerms(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        ) {

            String line = fileReader.readLine();
            List<MedTerms> medTermsList = new ArrayList<>();
            while (line != null) {
                // read next line
                line = fileReader.readLine();
                MedTerms medTerms = new MedTerms();
                medTerms.setDesc(line);
                save(medTerms).log().subscribe();
//                medTermsList.add(medTerms);
            }
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
