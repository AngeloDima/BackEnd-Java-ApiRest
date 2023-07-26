package com.ciao.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/felpe")
public class felpeController {

    @Autowired
    private felpeRepository felpeRepository;

    @GetMapping
    public List<felpeModel> index() {
        return felpeRepository.findAll();
    }

    @PostMapping("/create")
    public felpeModel createFelpe(@RequestBody felpeModel felpe) {
        return felpeRepository.save(felpe);
    }

}
