package utez.edu.mx.Zoologico.animales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.Zoologico.Utils.Message;
import utez.edu.mx.Zoologico.animales.model.Animales;
import utez.edu.mx.Zoologico.animales.model.AnimalesRepository;
import utez.edu.mx.Zoologico.especie.model.Especie;

import java.sql.SQLException;
import java.util.Optional;

@Service
@Transactional
public class AnimalesService {
    @Autowired
    AnimalesRepository animalesRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findAll(){
        return new ResponseEntity<>(new Message("Ok", false, animalesRepository.findAll()), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findById(long id){
        if(animalesRepository.existsById(id)){
            return new ResponseEntity<>(new Message("Ok", false, animalesRepository.findById(id)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("El animal no existe", true, null), HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> save(Animales animales){
        Optional<Animales> existanimales= animalesRepository.findByClaveAnimal(animales.getClaveAnimal());
        if(existanimales.isPresent()){
            return new ResponseEntity<>(new Message("el animal ya existe", true, null), HttpStatus.BAD_REQUEST);
        }
        Animales savedAnimales = animalesRepository.saveAndFlush(animales);
        return new ResponseEntity<>(new Message("animal registrado correctamente", false, savedAnimales), HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> update(Animales animales){
        if(animalesRepository.existsById((animales.getId()))){
            return new ResponseEntity<>(new Message("Ok", false, animalesRepository.saveAndFlush(animales)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("El animal no existe", true, null), HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> deletebyid(long id){
        if( animalesRepository.existsById(id)){
            System.out.println(id);
            animalesRepository.deleteById(id);
            return new ResponseEntity<>(new Message("animal eliminado", false,null), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("El animal no existe", true, null), HttpStatus.BAD_REQUEST);
    }
}

