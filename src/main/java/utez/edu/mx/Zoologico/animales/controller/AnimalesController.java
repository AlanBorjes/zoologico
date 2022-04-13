package utez.edu.mx.Zoologico.animales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utez.edu.mx.Zoologico.Utils.Message;
import utez.edu.mx.Zoologico.animales.model.Animales;
import utez.edu.mx.Zoologico.especie.controller.EspecieDTO;
import utez.edu.mx.Zoologico.especie.model.Especie;

@RestController
@RequestMapping("/api/animales")
@CrossOrigin(origins = {"*"})
public class AnimalesController {
    @Autowired
    AnimalesService animalesService;

    @GetMapping("/")
    public ResponseEntity<Message> getAll(){
        return animalesService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getById(@PathVariable("id") long id){
        return animalesService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Message> saveCategory(@RequestBody AnimaleDTO animaleDTO){
        return animalesService.save(new Animales(animaleDTO.getClaveAnimal(),animaleDTO.getFechaNac(),animaleDTO.getEspecie(),animaleDTO.getZoologico(),animaleDTO.getSex()));
    }

    @PutMapping("/")
    public ResponseEntity<Message> updateCategory(@RequestBody AnimaleDTO animaleDTO){
        return animalesService.update(new Animales(animaleDTO.getId(),animaleDTO.getClaveAnimal(),animaleDTO.getFechaNac(),animaleDTO.getEspecie(),animaleDTO.getZoologico(),animaleDTO.getSex()));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Message> deleteById(@PathVariable("id") long id){
        return  animalesService.deletebyid(id);
    }

}
