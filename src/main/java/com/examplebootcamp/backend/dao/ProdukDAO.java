package com.examplebootcamp.backend.dao;

import com.examplebootcamp.backend.dto.ProdukDTO;
import com.examplebootcamp.backend.entity.Produk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class ProdukDAO {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<Produk> findAll(){
        String query = "select\n" +
                "\tid,\n" +
                "\tnama,\n" +
                "\tjenis,\n" +
                "\tberat\n" +
                "from\n" +
                "\tproduk";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Produk.class));
    }

    public ProdukDTO.New save(ProdukDTO.New produk) {
        String query = "INSERT INTO public.produk\n" +
                "(nama, jenis, berat)\n" +
                "VALUES(:nama, :jenis, :berat);\n";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("nama", produk.getNama());
        map.addValue("jenis", produk.getJenis());
        map.addValue("berat", produk.getBerat());
        jdbcTemplate.update(query, map);
        return produk;
    }

    public ProdukDTO.Update update(ProdukDTO.Update produk) {
        String query = "UPDATE public.produk\n" +
                "SET nama=:nama, jenis=:jenis, berat=:berat\n" +
                "WHERE id=:id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", produk.getId());
        map.addValue("nama", produk.getNama());
        map.addValue("jenis", produk.getJenis());
        map.addValue("berat", produk.getBerat());
        jdbcTemplate.update(query, map);
        return produk;
    }

    public void delete(Integer id) {
        String query = "delete from produk where id = :id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        jdbcTemplate.update(query, map);
    }

    public Optional<Produk> findById(Integer id){
        String query = "select\n" +
                "\tid ,\n" +
                "\tnama ,\n" +
                "\tjenis ,\n" +
                "\tberat\n" +
                "from\n" +
                "\tproduk where id = :id";
        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("id", id);
        return jdbcTemplate.queryForObject(query, map, new RowMapper<Optional<Produk>>() {
            @Override
            public Optional<Produk> mapRow(ResultSet rs, int rowNum) throws SQLException {
                Produk produk = new Produk();
                produk.setId(rs.getInt("id"));
                produk.setNama(rs.getString("nama"));
                produk.setJenis(rs.getString("jenis"));
                produk.setBerat(rs.getInt("berat"));
                return Optional.of(produk);
            }
        });
    }

}
