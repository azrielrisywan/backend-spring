package com.examplebootcamp.backend.service;

import com.examplebootcamp.backend.dao.ProdukDAO;
import com.examplebootcamp.backend.dto.ProdukDTO;
import com.examplebootcamp.backend.entity.Produk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ProdukService {

    @Autowired
    private ProdukDAO dao;

    public List<Produk> findAll(){
        return dao.findAll();
    }

    public Optional<Produk> findById(Integer id){
        return dao.findById(id);
    }

    public ProdukDTO.New save(ProdukDTO.New produk) {
        return dao.save(produk);
    }

    public ProdukDTO.Update update(ProdukDTO.Update produk) {
        return dao.update(produk);
    }

    public void delete(Integer id) {
        dao.delete(id);
    }
}
