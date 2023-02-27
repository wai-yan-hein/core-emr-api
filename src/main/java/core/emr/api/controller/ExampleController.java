package core.emr.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ExampleController {

    @GetMapping("/numbers")
    public Flux<Integer> getNumbers() {
        return Flux.range(1, 100);
    }
}