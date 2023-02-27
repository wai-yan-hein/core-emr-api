package core.emr.api.controller;

import core.emr.api.document.Doctor;
import core.emr.api.repo.DoctorRepo;
import core.emr.api.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping(path = "/get-number")
    public Flux<Integer> getNumber() {
        return Flux.range(0, 100);
    }

    @PostMapping(path = "/save-doctor")
    public Mono<Doctor> saveDoctor(@RequestBody Doctor d) {
        return doctorService.save(d);
    }

    @GetMapping(path = "/get-doctor")
    public Flux<Doctor> findAll() {
        return doctorService.findAll();
    }

    @GetMapping(path = "/find-doctor")
    public Mono<Doctor> findById(@RequestParam String doctorId) {
        return doctorService.findById(doctorId);
    }
}
