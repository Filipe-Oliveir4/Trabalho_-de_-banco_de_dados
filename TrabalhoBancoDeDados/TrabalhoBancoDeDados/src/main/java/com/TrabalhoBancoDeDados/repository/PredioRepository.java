package com.TrabalhoBancoDeDados.repository;

import com.TrabalhoBancoDeDados.model.Predio;
import com.TrabalhoBancoDeDados.model.Sala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class PredioRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Predio> getAllPredios(){
        String query ="select * from predio";
        List<Predio> empList = new ArrayList<>();
        List<Map<String,Object>> empRows = jdbcTemplate.queryForList(query);
        for(Map<String,Object> empRow : empRows){
            Predio predio = new Predio(String.valueOf(empRow.get("letra_predio")));
            empList.add(predio);
        }
        return empList;
    }

}
