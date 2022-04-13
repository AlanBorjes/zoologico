package utez.edu.mx.Zoologico.especie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.Zoologico.Utils.Message;
import utez.edu.mx.Zoologico.especie.model.Especie;
import utez.edu.mx.Zoologico.pais.controller.PaisDTO;
import utez.edu.mx.Zoologico.pais.model.Pais;

@RestController
@RequestMapping("/api/especie")
@CrossOrigin(origins = {"*"})
public class EspecieController {
    @Autowired
    EspecieService especieService;

    @GetMapping("/")
    public ResponseEntity<Message> getAll(){
        return especieService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getById(@PathVariable("id") long id){
        return especieService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Message> saveCategory(@RequestBody EspecieDTO especieDTO){
        return especieService.save(new Especie(especieDTO.getNombreComun(),especieDTO.getNombreCientifico(),especieDTO.getFamilia(),especieDTO.getPreligroExtincion(),especieDTO.getPais()));
    }

    @PutMapping("/")
    public ResponseEntity<Message> updateCategory(@RequestBody EspecieDTO especieDTO){
        return especieService.update(new Especie(especieDTO.getId(),especieDTO.getNombreComun(),especieDTO.getNombreCientifico(),especieDTO.getFamilia(),especieDTO.getPreligroExtincion(),especieDTO.getPais()));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Message> deleteById(@PathVariable("id") long id){
        return  especieService.deletebyid(id);
    }

}
