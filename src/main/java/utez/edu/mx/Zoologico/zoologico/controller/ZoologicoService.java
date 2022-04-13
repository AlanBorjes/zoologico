package utez.edu.mx.Zoologico.zoologico.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.Zoologico.Utils.Message;
import utez.edu.mx.Zoologico.cuidad.model.Ciudad;
import utez.edu.mx.Zoologico.zoologico.model.Zoologico;
import utez.edu.mx.Zoologico.zoologico.model.ZoologicoRepository;

import java.sql.SQLException;
import java.util.Optional;

@Service
@Transactional
public class ZoologicoService {
    @Autowired
    ZoologicoRepository zoologicoRepository;


    @Transactional(readOnly = true)
    public ResponseEntity<Message> findAll(){
        return new ResponseEntity<>(new Message("Ok", false, zoologicoRepository.findAll()), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findById(long id){
        if(zoologicoRepository.existsById(id)){
            return new ResponseEntity<>(new Message("Ok", false, zoologicoRepository.findById(id)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("El zoologico no existe", true, null), HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> save(Zoologico zoologico){
        Optional<Zoologico> existZoologico= zoologicoRepository.findByName(zoologico.getName());
        if(existZoologico.isPresent()){
            return new ResponseEntity<>(new Message("el zoologico ya existe", true, null), HttpStatus.BAD_REQUEST);
        }
        Zoologico savedZoologico = zoologicoRepository.saveAndFlush(zoologico);
        return new ResponseEntity<>(new Message("zoologico registrado correctamente", false, savedZoologico), HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> update(Zoologico zoologico){
        if(zoologicoRepository.existsById((zoologico.getId()))){
            return new ResponseEntity<>(new Message("Ok", false, zoologicoRepository.saveAndFlush(zoologico)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("El zoologico no existe", true, null), HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> deletebyid(long id){
        if( zoologicoRepository.existsById(id)){
            System.out.println(id);
            zoologicoRepository.deleteById(id);
            return new ResponseEntity<>(new Message("zoologico eliminado", false,null), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("El zoologico no existe", true, null), HttpStatus.BAD_REQUEST);
    }
}
