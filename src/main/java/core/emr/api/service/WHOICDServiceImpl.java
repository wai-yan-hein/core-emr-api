package core.emr.api.service;

import com.mongodb.client.model.CollationStrength;
import core.emr.api.document.WHOICDData;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Collation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.scheduling.support.CronExpression;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@Slf4j
public class WHOICDServiceImpl implements WHOICDService {
    @Autowired
    ReactiveMongoTemplate template;
    @Override
    public Mono<WHOICDData> save(WHOICDData whoicdData) {
        return template.save(whoicdData);
    }

    @Override
    public Mono<WHOICDData> findById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return template.findById(query, WHOICDData.class);
    }

    @Override
    public Flux<WHOICDData> findByCodeAndDesceng(String desc) {
        Query query = new Query(
                new Criteria().orOperator(
                        Criteria.where("code").regex("^" + desc, "i"),
                        Criteria.where("descEng").regex("^" + desc, "i")));
        return template.find(query, WHOICDData.class, "wHOICDData");
    }

    @Override
    public Flux<WHOICDData> findAll() {
        return template.findAll(WHOICDData.class);
    }

    @Override
    public Mono<?> deleteWHOICDDataById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return template.findById(query, WHOICDData.class);
    }

    public void saveWHOICDData(InputStream is) {
            try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                 CSVParser csvParser = new CSVParser(fileReader,
                         CSVFormat.DEFAULT.withHeader());) {
//                String split="\t";
                Iterable<CSVRecord> csvRecords = csvParser.getRecords();
                List<WHOICDData> list = new ArrayList<>();
                for (CSVRecord csvRecord : csvRecords) {
                    WHOICDData whoicdData = new WHOICDData();
                    whoicdData.setCode(csvRecord.get("ICD9Code"));
                    whoicdData.setDescEng(csvRecord.get("Description"));
                    list.add(whoicdData);
//                    whoicdData.setDescMyan(null);
                }
                template.insertAll(list).subscribe();
                log.info("completed.");
            } catch (IOException e) {
                throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
            }
        }
}
