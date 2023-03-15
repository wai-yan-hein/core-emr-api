package core.emr.api.service;

import core.emr.api.document.Doctor;
import core.emr.api.document.MedTerms;
import core.emr.api.document.WHOICDData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
public class MedTermsServiceImpl implements MedTermsService {

    @Autowired
    private ReactiveMongoTemplate template;
    @Autowired
    private Environment env;
    @Override
    public Mono<MedTerms> save(MedTerms medTerms) {
        return template.save(medTerms);
    }

    @Override
    public Mono<MedTerms> findById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return template.findOne(query, MedTerms.class);
    }

    @Override
    public Flux<MedTerms> findByDesc(String desc) {
        Criteria criteria = Criteria.where("desc").regex("^" + desc);
        Query query = new Query(criteria);
        return template.find(query, MedTerms.class);
//        Query query = new Query();
//        query.addCriteria(Criteria.where("desc").regex("^" + desc)); // Create a query that finds all documents where the "name" field starts with the prefix
//
//        return template.find(query, MedTerms.class, "medTerms");
    }

    @Override
    public Flux<MedTerms> findAll() {
        return template.findAll(MedTerms.class);
    }

    @Override
    public Mono<?> deleteMedTermsById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return template.remove(query, MedTerms.class);
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
            template.insertAll(medTermsList).subscribe();
            log.info("Med Terms save completed.");
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
