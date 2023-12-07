package com.TrabalhoBancoDeDados.repository;


import com.TrabalhoBancoDeDados.model.Ocorrencia;
import com.TrabalhoBancoDeDados.model.OcorrenciaSalaVW;
import com.TrabalhoBancoDeDados.model.Sala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.management.Query;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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
            emp.setSolucionado((Boolean) empRow.get("solucionado"));
            emp.setDescricao(String.valueOf(empRow.get("descricao")));
            empList.add(emp);
            System.out.println((empRow.get("solucionado")));
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

    public int numOcorrenciaPorCodSala(String cod_sala){
        String query="select ocorrencias_por_sala('"+cod_sala+"')";
        List<Map<String,Object>> empRows = jdbcTemplate.queryForList(query);
        int retorno=0;
        for(Map<String,Object> empRow : empRows){
             retorno =Integer.parseInt(String.valueOf(empRow.get("ocorrencias_por_sala")));
        }
        return retorno;
    }

    public List<OcorrenciaSalaVW> getOcorrenciaSalaVw(){
        String query ="SELECT  * FROM ocorrencia_Sala_VW";
        List<OcorrenciaSalaVW> empList = new ArrayList<>();
        List<Map<String,Object>> empRows = jdbcTemplate.queryForList(query);
        for(Map<String,Object> empRow : empRows){
            OcorrenciaSalaVW emp = new OcorrenciaSalaVW();
            emp.setCodOcorrencia(Integer.parseInt(String.valueOf(empRow.get("cod_ocorrencia"))));
            emp.setCodSala(String.valueOf(empRow.get("cod_sala")));
            emp.setDescricao(String.valueOf(empRow.get("descricao")));
            emp.setNomeSala(String.valueOf(empRow.get("nome_sala")));
            empList.add(emp);
        }
        return empList;
    }

    public void deleteOcorrenciaByCodOcorrencia(String codOcorrencia){
        jdbcTemplate.update("delete from ocorrencia where cod_ocorrencia=?",Integer.parseInt(codOcorrencia));
    }
}
