package com.TrabalhoBancoDeDados.repository;

import com.TrabalhoBancoDeDados.model.Sala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class SalaRepository {


    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Sala> getAllSalas(){
        String query ="SELECT  * FROM sala";
        List<Sala> empList = new ArrayList<>();
        List<Map<String,Object>> empRows = jdbcTemplate.queryForList(query);
        for(Map<String,Object> empRow : empRows){
            Sala emp = new Sala();
            emp.setCodSala(String.valueOf(empRow.get("cod_sala")));
            emp.setNomeSala(String.valueOf(empRow.get("nome_sala")));
            emp.setLetraPredio(String.valueOf(empRow.get("letra_predio")));
            empList.add(emp);
        }
        return empList;
    }

    public Sala getSalaByCodSala(String codSala){
        String query ="select * from sala where cod_sala =?";
        Sala sala= jdbcTemplate.queryForObject("select * from sala where cod_sala =?", BeanPropertyRowMapper.newInstance(Sala.class),codSala);
        return sala;
    }
}
