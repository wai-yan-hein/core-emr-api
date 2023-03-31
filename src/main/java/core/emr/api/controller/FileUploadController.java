package core.emr.api.controller;

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
import java.io.InputStream;

@RestController
@RequestMapping("/uploadController")
@CrossOrigin
public class FileUploadController {
    @Autowired
    private MedTermsService medTermsService;
    @Autowired
    private WHOICDService whoicdService;
    @PostMapping("/uploadCSV")
    public Mono<String> uploadCsvFile(@RequestPart("file") FilePart filePart) {
        Flux<DataBuffer> dataBufferFlux = filePart.content();
        return DataBufferUtils.join(dataBufferFlux)
                .flatMap(dataBuffer -> {
                    byte[] bytes = new byte[dataBuffer.readableByteCount()];
                    dataBuffer.read(bytes);
                    DataBufferUtils.release(dataBuffer);
                    return Mono.just(bytes);
                })
                .flatMap(bytes -> {
                    InputStream inputStream = new ByteArrayInputStream(bytes);
                    whoicdService.saveWHOICDData(inputStream);
                    // Do something with the inputStream
                    return Mono.just("Upload Successfully");
                });
    }

    @PostMapping("/uploadTXT")
    public Mono<String> uploadTxtFile(@RequestPart("file") FilePart filePart) {
        Flux<DataBuffer> dataBufferFlux = filePart.content();
        return DataBufferUtils.join(dataBufferFlux)
                .flatMap(dataBuffer -> {
                    byte[] bytes = new byte[dataBuffer.readableByteCount()];
                    dataBuffer.read(bytes);
                    DataBufferUtils.release(dataBuffer);
                    return Mono.just(bytes);
                })
                .flatMap(bytes -> {
                    InputStream inputStream = new ByteArrayInputStream(bytes);
                    medTermsService.saveMedTerms(inputStream);
                    // Do something with the inputStream
                    return Mono.just("Upload Successfully");
                });
    }
}
