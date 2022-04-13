package utez.edu.mx.Zoologico.estado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.Zoologico.Utils.Message;
import utez.edu.mx.Zoologico.estado.model.Estado;
import utez.edu.mx.Zoologico.estado.model.EstadoRepository;
import utez.edu.mx.Zoologico.pais.model.Pais;

import java.sql.SQLException;
import java.util.Optional;

@Service
@Transactional
public class EstadoService {
    @Autowired
    EstadoRepository estadoRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findAll(){
        return new ResponseEntity<>(new Message("Ok", false, estadoRepository.findAll()), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findById(long id){
        if(estadoRepository.existsById(id)){
            return new ResponseEntity<>(new Message("Ok", false, estadoRepository.findById(id)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("El Estado no existe", true, null), HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> save(Estado estado){
        Optional<Estado> existPais= estadoRepository.findByDescription(estado.getDescription());
        if(existPais.isPresent()){
            return new ResponseEntity<>(new Message("el Estado ya existe", true, null), HttpStatus.BAD_REQUEST);
        }
        Estado savedPais= estadoRepository.saveAndFlush(estado);
        return new ResponseEntity<>(new Message("pais registrado correctamente", false, savedPais), HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> update(Estado estado){
        if(estadoRepository.existsById((estado.getId()))){
            return new ResponseEntity<>(new Message("Ok", false, estadoRepository.saveAndFlush(estado)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("El Estado no existe", true, null), HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> deletebyid(long id){
        if( estadoRepository.existsById(id)){
            System.out.println(id);
            estadoRepository.deleteById(id);
            return new ResponseEntity<>(new Message("Estado eliminado", false,null), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("El Estado no existe", true, null), HttpStatus.BAD_REQUEST);
    }
}
