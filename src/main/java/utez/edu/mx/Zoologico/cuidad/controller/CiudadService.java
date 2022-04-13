package utez.edu.mx.Zoologico.cuidad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.Zoologico.Utils.Message;
import utez.edu.mx.Zoologico.cuidad.model.Ciudad;
import utez.edu.mx.Zoologico.cuidad.model.CiudadRepository;
import utez.edu.mx.Zoologico.estado.model.Estado;

import java.sql.SQLException;
import java.util.Optional;

@Service
@Transactional
public class CiudadService {
    @Autowired
    CiudadRepository ciudadRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findAll(){
        return new ResponseEntity<>(new Message("Ok", false, ciudadRepository.findAll()), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findById(long id){
        if(ciudadRepository.existsById(id)){
            return new ResponseEntity<>(new Message("Ok", false, ciudadRepository.findById(id)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("El Ciudad no existe", true, null), HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> save(Ciudad ciudad){
        Optional<Ciudad> existCiudad= ciudadRepository.findByDescription(ciudad.getDescription());
        if(existCiudad.isPresent()){
            return new ResponseEntity<>(new Message("el Ciudad ya existe", true, null), HttpStatus.BAD_REQUEST);
        }
        Ciudad savedCiudad= ciudadRepository.saveAndFlush(ciudad);
        return new ResponseEntity<>(new Message("Ciudad registrado correctamente", false, savedCiudad), HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> update(Ciudad ciudad){
        if(ciudadRepository.existsById((ciudad.getId()))){
            return new ResponseEntity<>(new Message("Ok", false, ciudadRepository.saveAndFlush(ciudad)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("El Ciudad no existe", true, null), HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> deletebyid(long id){
        if( ciudadRepository.existsById(id)){
            System.out.println(id);
            ciudadRepository.deleteById(id);
            return new ResponseEntity<>(new Message("Ciudad eliminado", false,null), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("El Estado no existe", true, null), HttpStatus.BAD_REQUEST);
    }
}
