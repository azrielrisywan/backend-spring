package com.examplebootcamp.backend.service;

import com.examplebootcamp.backend.dao.ProdukDAO;
import com.examplebootcamp.backend.dao.TransaksiDAO;
import com.examplebootcamp.backend.dto.ProdukDTO;
import com.examplebootcamp.backend.dto.TransaksiDTO;
import com.examplebootcamp.backend.entity.Produk;
import com.examplebootcamp.backend.entity.Transaksi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class TransaksiService {

    @Autowired
    private TransaksiDAO dao;

    public List<Transaksi> findAll(){
        return dao.findAll();
    }

    public Optional<Transaksi> findById(Integer id){
        return dao.findById(id);
    }

    public Optional<TransaksiDTO.Detail> detail(Integer id) {
        return dao.detail(id);
    }

    public TransaksiDTO.New save(TransaksiDTO.New transaksi) {
        return dao.save(transaksi);
    }

    public TransaksiDTO.Update update(TransaksiDTO.Update transaksi) {
        return dao.update(transaksi);
    }

    public void delete(Integer id) {
        dao.delete(id);
    }
}
