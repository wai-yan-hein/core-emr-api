package core.emr.api.service;

import core.emr.api.document.WHOICDData;
import core.emr.api.repo.WHOICDRepo;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Service
public class WHOICDServiceImpl implements WHOICDService {
    @Autowired
    WHOICDRepo whoicdRepo;
    @Override
    public Mono<WHOICDData> save(WHOICDData whoicdData) {
        return whoicdRepo.save(whoicdData);
    }

    @Override
    public Mono<WHOICDData> findById(String id) {
        return null;
    }

    @Override
    public Flux<WHOICDData> findByCodeAndDesceng(String desc) {
        Flux<WHOICDData> whoicdDataFlux = findAll();
        return whoicdDataFlux.filter(
                des-> des.getDescEng().startsWith(desc) || des.getCode().startsWith(desc));
    }

    @Override
    public Flux<WHOICDData> findAll() {
        return whoicdRepo.findAll();
    }

    @Override
    public Mono<WHOICDData> delete() {
        return null;
    }

    public void saveWHOICDData(InputStream is) {
            try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                 CSVParser csvParser = new CSVParser(fileReader,
                         CSVFormat.DEFAULT.withHeader());) {

                Iterable<CSVRecord> csvRecords = csvParser.getRecords();

                for (CSVRecord csvRecord : csvRecords) {
                    WHOICDData whoicdData = new WHOICDData();
                    whoicdData.setCode(csvRecord.get("ICD9Code"));
                    whoicdData.setDescEng(csvRecord.get("Description"));
                    whoicdData.setDescMyan("");
                    save(whoicdData).log().subscribe();
                }
            } catch (IOException e) {
                throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
            }
        }
}
