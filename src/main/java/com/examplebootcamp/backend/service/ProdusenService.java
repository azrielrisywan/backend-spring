package com.examplebootcamp.backend.service;

import com.examplebootcamp.backend.dao.ProdusenDAO;
import com.examplebootcamp.backend.dto.ProdusenDTO;
import com.examplebootcamp.backend.entity.Produsen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ProdusenService {

    @Autowired
    private ProdusenDAO dao;

    public List<Produsen> findAll(){
        return dao.findAll();
    }

    public Optional<Produsen> findById(Integer id){
        return dao.findById(id);
    }

    public ProdusenDTO.New save(ProdusenDTO.New produsen) {
        return dao.save(produsen);
    }

    public ProdusenDTO.Update update(ProdusenDTO.Update produsen) {
        return dao.update(produsen);
    }

    public void delete(Integer id) {
        dao.delete(id);
    }
}
