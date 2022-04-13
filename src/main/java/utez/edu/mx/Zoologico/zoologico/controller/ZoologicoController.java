package utez.edu.mx.Zoologico.zoologico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.Zoologico.Utils.Message;
import utez.edu.mx.Zoologico.cuidad.controller.CiudadDTO;
import utez.edu.mx.Zoologico.cuidad.model.Ciudad;
import utez.edu.mx.Zoologico.zoologico.model.Zoologico;

@RestController
@RequestMapping("/api/zoo")
@CrossOrigin(origins = {"*"})
public class ZoologicoController {
    @Autowired
    ZoologicoService zoologicoService;


    @GetMapping("/")
    public ResponseEntity<Message> getAll(){
        return zoologicoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getById(@PathVariable("id") long id){
        return zoologicoService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Message> save(@RequestBody ZoologicoDTO zoologicoDTO){
        return zoologicoService.save(new Zoologico(zoologicoDTO.getName(),zoologicoDTO.getCiudad(),zoologicoDTO.getPais(),zoologicoDTO.getTamano(),zoologicoDTO.getPresupuesto(),zoologicoDTO.getCiudadId()));
    }

    @PutMapping("/")
    public ResponseEntity<Message> update(@RequestBody ZoologicoDTO zoologicoDTO){
        return zoologicoService.update(new Zoologico(zoologicoDTO.getId(),zoologicoDTO.getName(),zoologicoDTO.getCiudad(),zoologicoDTO.getPais(),zoologicoDTO.getTamano(),zoologicoDTO.getPresupuesto(),zoologicoDTO.getCiudadId()));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Message> deleteById(@PathVariable("id") long id){
        return  zoologicoService.deletebyid(id);
    }

}

