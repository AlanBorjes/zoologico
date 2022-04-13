package utez.edu.mx.Zoologico.continent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utez.edu.mx.Zoologico.Utils.Message;
import utez.edu.mx.Zoologico.continent.model.Continent;
import utez.edu.mx.Zoologico.continent.model.ContinentRepository;
import utez.edu.mx.Zoologico.sex.modelo.Sex;

import java.sql.SQLException;
import java.util.Optional;

@Service
@Transactional
public class ContinentService {
    @Autowired
    ContinentRepository continentRepository;


    @Transactional(readOnly = true)
    public ResponseEntity<Message> findAll(){
        return new ResponseEntity<>(new Message("Ok", false, continentRepository.findAll()), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findById(long id){
        if(continentRepository.existsById(id)){
            return new ResponseEntity<>(new Message("Ok", false, continentRepository.findById(id)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("El continente no existe", true, null), HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> save(Continent continent){
        Optional<Continent> existcontinent = continentRepository.findByDescription(continent.getDescription());
        if(existcontinent.isPresent()){
            return new ResponseEntity<>(new Message("el continente ya existe", true, null), HttpStatus.BAD_REQUEST);
        }
        Continent savedcontinent= continentRepository.saveAndFlush(continent);
        return new ResponseEntity<>(new Message("continente registrado correctamente", false, savedcontinent), HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> update(Continent continent){
        if(continentRepository.existsById((continent.getId()))){
            return new ResponseEntity<>(new Message("Ok", false, continentRepository.saveAndFlush(continent)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("El continente no existe", true, null), HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> deletebyid(long id){
        if( continentRepository.existsById(id)){
            System.out.println(id);
            continentRepository.deleteById(id);
            return new ResponseEntity<>(new Message("continente eliminado", false,null), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("El continente no existe", true, null), HttpStatus.BAD_REQUEST);
    }
}