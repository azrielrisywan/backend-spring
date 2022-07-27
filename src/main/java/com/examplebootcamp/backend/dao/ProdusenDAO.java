package com.examplebootcamp.backend.dao;

import com.examplebootcamp.backend.dto.ProdusenDTO;
import com.examplebootcamp.backend.entity.Produsen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProdusenDAO {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<Produsen> findAll(){
        String query = "select\n" +
                "\tid,\n" +
                "\tnama,\n" +
                "\tkode,\n" +
                "\talamat\n" +
                "from\n" +
                "\tprodusen";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Produsen.class));
    }

    public ProdusenDTO.New save(ProdusenDTO.New produsen) {
        String query = "INSERT INTO public.produsen\n" +
                "(nama, kode, alamat)\n" +
                "VALUES(:nama, :kode, :alamat);\n";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("nama", produsen.getNama());
        map.addValue("kode", produsen.getKode());
        map.addValue("alamat", produsen.getAlamat());
        jdbcTemplate.update(query, map);
        return produsen;
    }

    public ProdusenDTO.Update update(ProdusenDTO.Update produsen) {
        String query = "UPDATE public.produsen\n" +
                "SET nama=:nama, kode=:kode, alamat=:alamat\n" +
                "WHERE id=:id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", produsen.getId());
        map.addValue("nama", produsen.getNama());
        map.addValue("kode", produsen.getKode());
        map.addValue("alamat", produsen.getAlamat());
        jdbcTemplate.update(query, map);
        return produsen;
    }

//    public ProdusenDTO.Delete delete(ProdusenDTO.Delete produsen) {
//        String query = "delete from produsen where id = :id";
//        MapSqlParameterSource map = new MapSqlParameterSource();
//        map.addValue("id", produsen.getId());
//        jdbcTemplate.update(query, map);
//        return produsen;
//    }

    public void delete(Integer id) {
        String query = "delete from produsen where id = :id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        jdbcTemplate.update(query, map);
    }

}
