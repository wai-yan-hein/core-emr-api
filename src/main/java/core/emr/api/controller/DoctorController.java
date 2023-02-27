package core.emr.api.controller;

import core.emr.api.document.Doctor;
import core.emr.api.repo.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorRepo doctorRepo;

    @GetMapping(path = "/get-number")
    public Flux<Integer> getNumber() {
        return Flux.range(0, 100);
    }

    @PostMapping(path = "/save-doctor")
    public Mono<Doctor> saveDoctor(@RequestBody Doctor d) {
        return doctorRepo.save(d);
    }

    @GetMapping(path = "/get-doctor")
    public Flux<Doctor> findAll() {
        return doctorRepo.findAll();
    }

    @GetMapping(path = "/find-doctor")
    public Mono<Doctor> findById(@RequestParam String doctorId) {
        return doctorRepo.findById(doctorId);
    }
}
