package com.ciao.data;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/felpe")
public class felpeController {

    @Autowired
    private felpeRepository felpeRepository;

    // GET
    @GetMapping
    public List<felpeModel> index() {
        return felpeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<felpeModel> detail(@PathVariable("id") Integer id) {
        Optional<felpeModel> optionalFelpe = felpeRepository.findById(id);

        if (optionalFelpe.isPresent()) {
            felpeModel felpe = optionalFelpe.get();
            return ResponseEntity.ok(felpe);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/find/{titolo}")
    public ResponseEntity<List<felpeModel>> getFelpeByTitolo(@PathVariable("titolo") String titolo) {
        List<felpeModel> felpeList = felpeRepository.findByTitolo(titolo);

        if (!felpeList.isEmpty()) {
            return ResponseEntity.ok(felpeList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST
    @PostMapping("/create")
    public felpeModel createFelpe(@RequestBody felpeModel felpe) {
        return felpeRepository.save(felpe);
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<felpeModel> updateFelpe(@RequestBody felpeModel updatedFelpe,
            @PathVariable("id") Integer id) {
        Optional<felpeModel> optionalFelpe = felpeRepository.findById(id);

        if (optionalFelpe.isPresent()) {
            felpeModel existingFelpe = optionalFelpe.get();
            existingFelpe.setTitolo(updatedFelpe.getTitolo());

            felpeModel updated = felpeRepository.save(existingFelpe);
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        felpeRepository.deleteById(id);
    }
}
