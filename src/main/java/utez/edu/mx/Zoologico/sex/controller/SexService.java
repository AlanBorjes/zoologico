package utez.edu.mx.Zoologico.sex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.Zoologico.Utils.Message;
import utez.edu.mx.Zoologico.sex.modelo.Sex;
import utez.edu.mx.Zoologico.sex.modelo.SexRepository;

import java.sql.SQLException;
import java.util.Optional;

@Service
@Transactional
public class SexService {
    @Autowired
    SexRepository sexRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findAll(){
        return new ResponseEntity<>(new Message("Ok", false, sexRepository.findAll()), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findById(long id){
        if(sexRepository.existsById(id)){
            return new ResponseEntity<>(new Message("Ok", false, sexRepository.findById(id)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("El sexo no existe", true, null), HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> save(Sex sex){
        Optional<Sex> existSex = sexRepository.findByDescription(sex.getDescription());
        if(existSex.isPresent()){
            return new ResponseEntity<>(new Message("el sexo ya existe", true, null), HttpStatus.BAD_REQUEST);
        }
        Sex savedSex= sexRepository.saveAndFlush(sex);
        return new ResponseEntity<>(new Message("Sexo registrado correctamente", false, savedSex), HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> update(Sex sex){
        if(sexRepository.existsById((sex.getId()))){
            return new ResponseEntity<>(new Message("Ok", false, sexRepository.saveAndFlush(sex)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("El sexo no existe", true, null), HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> deletebyid(long id){
        if( sexRepository.existsById(id)){
            System.out.println(id);
            sexRepository.deleteById(id);
            return new ResponseEntity<>(new Message("sexo eliminado", false,null), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("El sexo no existe", true, null), HttpStatus.BAD_REQUEST);
    }
}