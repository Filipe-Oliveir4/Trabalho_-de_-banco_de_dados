package com.Trabalho.de.banco.de.dados.repository;

import com.Trabalho.de.banco.de.dados.model.Ocorrencia;
import com.Trabalho.de.banco.de.dados.model.Sala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class OcorrenciaRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Sala> getAllOcorrencias(){
        String query ="SELECT  * FROM sala";
        List<Sala> empList = new ArrayList<>();
        List<Map<String,Object>> empRows = jdbcTemplate.queryForList(query);
        for(Map<String,Object> empRow : empRows){
            Sala emp = new Sala();
            emp.setCodSala(String.valueOf(empRow.get("cod_sala")));
            emp.setNomeSala(String.valueOf(empRow.get("nome_sala")));
            emp.setLetraPredio(String.valueOf(empRow.get("letra_predio")));
            empList.add(emp);
            System.out.println(emp.getCodSala()+" - "+emp.getNomeSala());
        }
        return empList;
    }

    public void insertOcorrencia(Ocorrencia oc){
        jdbcTemplate.update("insert into ocorrencia(cod_sala,cod_equipamento,descricao) values(?,?,?)",oc.getCodSala(),oc.getCodEquipamento(),oc.getDescricao());
    }
}
