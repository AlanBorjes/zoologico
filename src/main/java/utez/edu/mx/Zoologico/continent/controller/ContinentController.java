package utez.edu.mx.Zoologico.continent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.Zoologico.Utils.Message;
import utez.edu.mx.Zoologico.continent.model.Continent;
import utez.edu.mx.Zoologico.sex.controller.SexDTO;
import utez.edu.mx.Zoologico.sex.modelo.Sex;

@RestController
@RequestMapping("/api/continent")
@CrossOrigin(origins = {"*"})
public class ContinentController {
    @Autowired
    ContinentService continentService;

    @GetMapping("/")
    public ResponseEntity<Message> getAll(){
        return continentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getById(@PathVariable("id") long id){
        return continentService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Message> saveCategory(@RequestBody ContinentDTO continentDTO){
        return continentService.save(new Continent(continentDTO.getDescription()));
    }

    @PutMapping("/")
    public ResponseEntity<Message> updateCategory(@RequestBody ContinentDTO continentDTO){
        return continentService.update(new Continent(continentDTO.getId(), continentDTO.getDescription()));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Message> deleteById(@PathVariable("id") long id){
        return  continentService.deletebyid(id);
    }

}
