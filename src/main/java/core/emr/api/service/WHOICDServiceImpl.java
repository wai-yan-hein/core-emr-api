package core.emr.api.service;

import core.emr.api.document.MedTerms;
import core.emr.api.document.WHOICDData;
import core.emr.api.repo.WHOICDRepo;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WHOICDServiceImpl implements WHOICDService {
    @Autowired
    WHOICDRepo whoicdRepo;
    @Autowired
    private Environment env;
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

    @Override
    public boolean saveAllWHOICDData() {
        parseCSV();
        return true;
    }

    public void parseCSV(){
        CSVParser parser = null;
        try {
            String path = env.getProperty("whoIcdFilePath");
            parser = new CSVParser(new FileReader(path), CSVFormat.DEFAULT.withHeader());
            for (CSVRecord record : parser)
            {
                String code = record.get("ICD9Code").toString();
                String desc_eng = record.get("Description").toString();
                WHOICDData whoicdData = new WHOICDData();
                whoicdData.setCode(code);
                whoicdData.setDescEng(desc_eng);
                whoicdData.setDescMyan("");
                save(whoicdData).log().subscribe();
//                System.out.println(record.get("Description").toString() + record.get("ICD9Code").toString());
            }
            parser.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public void readCSV() {
        List<WHOICDData> whoIcdDataList = new ArrayList<>();
        BufferedReader br = null;
        try {
            String path = env.getProperty("whoIcdFilePath");
            br = new BufferedReader( new FileReader(path));
            String line = br.readLine(); // Reading header, Ignoring

            while ((line = br.readLine()) != null && !line.isEmpty())
            {
                String[] fields = line.split(",");
                String code = fields[1];
                String desc_eng = fields[0];
                WHOICDData whoicdData = new WHOICDData();
                whoicdData.setCode(code);
                whoicdData.setDescEng(desc_eng);
                whoicdData.setDescMyan("");
                save(whoicdData).log().subscribe();
            }
            br.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
