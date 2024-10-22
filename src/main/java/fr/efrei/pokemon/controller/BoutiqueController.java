package fr.efrei.pokemon.controller;

import fr.efrei.pokemon.models.Boutique;
import fr.efrei.pokemon.repositories.BoutiqueRepositery;
import fr.efrei.pokemon.services.BoutiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/boutiques")
public class BoutiqueController {

    private final BoutiqueService service;

    @Autowired
    public BoutiqueController(BoutiqueService service) {
        this.service = service;
}
    // GET
    @GetMapping
    public ResponseEntity<List<Boutique>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boutique> findById(@PathVariable String id) {
        Boutique boutique = service.findById(id);
        if (boutique == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(boutique, HttpStatus.OK);
    }
    // POST
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Boutique boutique) {
        service.save(boutique);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Boutique boutique) {
        Boutique boutiqueAModifier = service.findById(id);
        if (boutiqueAModifier == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.update(id, boutique);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Boutique boutique = service.findById(id);
        if (boutique == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // PATCH
    @PatchMapping("/{id}")
    public ResponseEntity<?> partialUpdate(@PathVariable String id, @RequestBody Boutique boutiqueBody) {
        Boutique boutique = service.findById(id);
        if (boutique == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.partialUpdate(id, boutiqueBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}