package com.TrabalhoBancoDeDados.repository;


import com.TrabalhoBancoDeDados.model.Ocorrencia;
import com.TrabalhoBancoDeDados.model.Sala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class OcorrenciaRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insertOcorrencia(Ocorrencia oc){
        jdbcTemplate.update("insert into ocorrencia(cod_sala,cod_equipamento,descricao) values(?,?,?)",oc.getCodSala(),oc.getCodEquipamento(),oc.getDescricao());
    }

    public List<Ocorrencia> getAllOcorrencias(){
        String query ="SELECT  * FROM ocorrencia";
        List<Ocorrencia> empList = new ArrayList<>();
        List<Map<String,Object>> empRows = jdbcTemplate.queryForList(query);
        for(Map<String,Object> empRow : empRows){
            Ocorrencia emp = new Ocorrencia();
            emp.setCodOcorrencia(Integer.parseInt(String.valueOf(empRow.get("cod_ocorrencia"))));
            emp.setCodSala(String.valueOf(empRow.get("cod_sala")));
            emp.setCodEquipamento(!String.valueOf(empRow.get("cod_equipamento")).equals(null)?Integer.parseInt(String.valueOf(empRow.get("cod_equipamento"))):null);
            emp.setDataOcorrencia((Timestamp) empRow.get("data_ocorrencia"));
            emp.setSolucionado(String.valueOf(empRow.get("cod_ocorrencia")).equals("1")?true:false);
            emp.setDescricao(String.valueOf(empRow.get("descricao")));
            empList.add(emp);
            System.out.println(emp.isSolucionado());
        }
        return empList;
    }

    public Ocorrencia getOcorrenciaByCodOcorrencia(String codOcorrencia){
        Ocorrencia ocorrencia= jdbcTemplate.queryForObject("select * from ocorrencia where cod_ocorrencia =?", BeanPropertyRowMapper.newInstance(Ocorrencia.class),codOcorrencia);
        return ocorrencia;
    }

    public void solucionarOcorrencia(String codOcorrencia){
        jdbcTemplate.update("update ocorrencia set solucionado = '1' where cod_ocorrencia=?",Integer.parseInt(codOcorrencia));

    }
}
