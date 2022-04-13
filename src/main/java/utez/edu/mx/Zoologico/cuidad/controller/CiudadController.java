package utez.edu.mx.Zoologico.cuidad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.Zoologico.Utils.Message;
import utez.edu.mx.Zoologico.cuidad.model.Ciudad;


@RestController
@RequestMapping("/api/ciudad")
@CrossOrigin(origins = {"*"})
public class CiudadController {
    @Autowired
    CiudadService ciudadService;

    @GetMapping("/")
    public ResponseEntity<Message> getAll(){
        return ciudadService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getById(@PathVariable("id") long id){
        return ciudadService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Message> save(@RequestBody CiudadDTO ciudadDTO){
        return ciudadService.save(new Ciudad(ciudadDTO.getDescription(),ciudadDTO.getEstado()));
    }

    @PutMapping("/")
    public ResponseEntity<Message> update(@RequestBody CiudadDTO ciudadDTO){
        return ciudadService.update(new Ciudad(ciudadDTO.getId(), ciudadDTO.getDescription(),ciudadDTO.getEstado()));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Message> deleteById(@PathVariable("id") long id){
        return  ciudadService.deletebyid(id);
    }

}
