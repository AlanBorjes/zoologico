package utez.edu.mx.Zoologico.sex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.Zoologico.Utils.Message;
import utez.edu.mx.Zoologico.sex.modelo.Sex;

@RestController
@RequestMapping("/api/sex")
@CrossOrigin(origins = {"*"})
public class SexController {
    @Autowired
    SexService sexService;

    @GetMapping("/")
    public ResponseEntity<Message> getAll(){
        return sexService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getById(@PathVariable("id") long id){
        return sexService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Message> saveCategory(@RequestBody SexDTO sexDTO){
        return sexService.save(new Sex(sexDTO.getDescription()));
    }

    @PutMapping("/")
    public ResponseEntity<Message> updateCategory(@RequestBody SexDTO sexDTO){
        return sexService.update(new Sex(sexDTO.getId(), sexDTO.getDescription()));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Message> deleteById(@PathVariable("id") long id){
        return  sexService.deletebyid(id);
    }

}
