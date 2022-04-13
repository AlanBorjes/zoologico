package utez.edu.mx.Zoologico.pais.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.Zoologico.Utils.Message;
import utez.edu.mx.Zoologico.pais.model.Pais;
import utez.edu.mx.Zoologico.pais.model.PaisRepository;
import utez.edu.mx.Zoologico.sex.modelo.Sex;

import java.sql.SQLException;
import java.util.Optional;

@Service
@Transactional
public class PaisService {
    @Autowired
    PaisRepository paisRepository;


    @Transactional(readOnly = true)
    public ResponseEntity<Message> findAll(){
        return new ResponseEntity<>(new Message("Ok", false, paisRepository.findAll()), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findById(long id){
        if(paisRepository.existsById(id)){
            return new ResponseEntity<>(new Message("Ok", false, paisRepository.findById(id)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("El pais no existe", true, null), HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> save(Pais pais){
        Optional<Pais> existPais= paisRepository.findByDescription(pais.getDescription());
        if(existPais.isPresent()){
            return new ResponseEntity<>(new Message("el pais ya existe", true, null), HttpStatus.BAD_REQUEST);
        }
        Pais savedPais= paisRepository.saveAndFlush(pais);
        return new ResponseEntity<>(new Message("pais registrado correctamente", false, savedPais), HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> update(Pais pais){
        if(paisRepository.existsById((pais.getId()))){
            return new ResponseEntity<>(new Message("Ok", false, paisRepository.saveAndFlush(pais)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("El pais no existe", true, null), HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> deletebyid(long id){
        if( paisRepository.existsById(id)){
            System.out.println(id);
            paisRepository.deleteById(id);
            return new ResponseEntity<>(new Message("pais eliminado", false,null), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("El pais no existe", true, null), HttpStatus.BAD_REQUEST);
    }
}
