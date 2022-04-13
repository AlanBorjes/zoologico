package utez.edu.mx.Zoologico.especie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.Zoologico.Utils.Message;
import utez.edu.mx.Zoologico.especie.model.Especie;
import utez.edu.mx.Zoologico.especie.model.EspecieRepository;
import utez.edu.mx.Zoologico.pais.model.Pais;

import java.sql.SQLException;
import java.util.Optional;

@Service
@Transactional
public class EspecieService {
    @Autowired
    EspecieRepository especieRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findAll(){
        return new ResponseEntity<>(new Message("Ok", false, especieRepository.findAll()), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findById(long id){
        if(especieRepository.existsById(id)){
            return new ResponseEntity<>(new Message("Ok", false, especieRepository.findById(id)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("El especie no existe", true, null), HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> save(Especie especie){
        Optional<Especie> existespecie= especieRepository.findByNombreCientifico(especie.getNombreCientifico());
        if(existespecie.isPresent()){
            return new ResponseEntity<>(new Message("el especie ya existe", true, null), HttpStatus.BAD_REQUEST);
        }
        Especie savedspecie = especieRepository.saveAndFlush(especie);
        return new ResponseEntity<>(new Message("especie registrado correctamente", false, savedspecie), HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> update(Especie especie){
        if(especieRepository.existsById((especie.getId()))){
            return new ResponseEntity<>(new Message("Ok", false, especieRepository.saveAndFlush(especie)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("El especie no existe", true, null), HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> deletebyid(long id){
        if( especieRepository.existsById(id)){
            System.out.println(id);
            especieRepository.deleteById(id);
            return new ResponseEntity<>(new Message("especie eliminado", false,null), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("El especie no existe", true, null), HttpStatus.BAD_REQUEST);
    }
}
