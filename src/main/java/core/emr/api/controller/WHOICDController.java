package core.emr.api.controller;

import core.emr.api.service.WHOICDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("WHOICDController")
public class WHOICDController {
    @Autowired
    WHOICDService whoicdService;
    @GetMapping(path = "/saveWHOICDData")
    public boolean saveWHOICDData() {
        return whoicdService.saveAllWHOICDData();
    }
}
