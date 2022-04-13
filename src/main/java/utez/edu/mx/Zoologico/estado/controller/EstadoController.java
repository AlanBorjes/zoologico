package utez.edu.mx.Zoologico.estado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.Zoologico.Utils.Message;
import utez.edu.mx.Zoologico.estado.model.Estado;
import utez.edu.mx.Zoologico.pais.controller.PaisDTO;
import utez.edu.mx.Zoologico.pais.model.Pais;

@RestController
@RequestMapping("/api/estado")
@CrossOrigin(origins = {"*"})
public class EstadoController {
    @Autowired
    EstadoService estadoService;

    @GetMapping("/")
    public ResponseEntity<Message> getAll(){
        return estadoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getById(@PathVariable("id") long id){
        return estadoService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Message> save(@RequestBody EstadoDTO estadoDTO){
        return estadoService.save(new Estado(estadoDTO.getDescription(),estadoDTO.getPais()));
    }

    @PutMapping("/")
    public ResponseEntity<Message> update(@RequestBody EstadoDTO estadoDTO){
        return estadoService.update(new Estado(estadoDTO.getId(), estadoDTO.getDescription(),estadoDTO.getPais()));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Message> deleteById(@PathVariable("id") long id){
        return  estadoService.deletebyid(id);
    }

}
