package core.emr.api.service;

import core.emr.api.document.MedTerms;
import core.emr.api.repo.MedTermsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

    @Override
    public boolean saveAll() {
        List<MedTerms> list = new ArrayList<>();
        BufferedReader reader;

        try {
            String path = env.getProperty("medTermsFilePath");
            reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();

            while (line != null) {
                // read next line
                line = reader.readLine();
                MedTerms medTermsTemp = new MedTerms();
                medTermsTemp.setDesc(line);
                save(medTermsTemp).log().subscribe();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }
}
