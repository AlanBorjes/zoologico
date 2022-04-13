package utez.edu.mx.Zoologico.pais.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.Zoologico.Utils.Message;
import utez.edu.mx.Zoologico.pais.model.Pais;
import utez.edu.mx.Zoologico.sex.controller.SexDTO;
import utez.edu.mx.Zoologico.sex.modelo.Sex;

@RestController
@RequestMapping("/api/pais")
@CrossOrigin(origins = {"*"})
public class PaisController {
    @Autowired
    PaisService paisService;

    @GetMapping("/")
    public ResponseEntity<Message> getAll(){
        return paisService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getById(@PathVariable("id") long id){
        return paisService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Message> saveCategory(@RequestBody PaisDTO paisDTO){
        return paisService.save(new Pais(paisDTO.getDescription(),paisDTO.getContinent()));
    }

    @PutMapping("/")
    public ResponseEntity<Message> updateCategory(@RequestBody PaisDTO paisDTO){
        return paisService.update(new Pais(paisDTO.getId(), paisDTO.getDescription(),paisDTO.getContinent()));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Message> deleteById(@PathVariable("id") long id){
        return  paisService.deletebyid(id);
    }

}
