/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import util.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import Model.Projetos;



/**
 *
 * @author mulle
 */
public class ProjetosDAO {
    
    public void cadastrar(Projetos projetos) throws ClassNotFoundException, SQLException{
        Connection con = ConexaoBanco.getConexaoMySQL();
        PreparedStatement comando = con.prepareStatement("insert into projetos (nome, descricao, cliente, datainicio, datafimprevista, responsavel, status, orcamento, prioridade) values (?,?,?,?,?,?,?,?,?)" );
        comando.setString(1, projetos.getNome());
        comando.setString(2, projetos.getDescricao());
        comando.setString(3, projetos.getCliente());
        comando.setDate(4, new java.sql.Date(projetos.getDatainicio().getTime()));
        comando.setDate(5, new java.sql.Date(projetos.getDatafimprevista().getTime()));
//        comando.setDate(4, (java.sql.Date)projetos.getDatainicio());;;
//        comando.setDate(5, (java.sql.Date)projetos.getDatafimprevista());
        comando.setString(6, projetos.getResponsavel());
        comando.setString(7, projetos.getStatus());
        comando.setDouble(8, projetos.getOrcamento());
        comando.setString(9, projetos.getPrioridade());
        comando.execute();
        con.close();     
    }
    
    public void deletar(Projetos projetos) throws ClassNotFoundException, SQLException{
        Connection con = ConexaoBanco.getConexaoMySQL();
        PreparedStatement comando = con.prepareStatement("delete from projetos where id = ?");
        comando.setInt(1, projetos.getId());
        comando.execute();
        con.close();
    }
    
    public void atualizar(Projetos projetos) throws ClassNotFoundException, SQLException{
        Connection con = ConexaoBanco.getConexaoMySQL();
        PreparedStatement comando = con.prepareStatement("update projetos set nome = ?, descricao = ?, cliente = ?, datainicio = ?, datafimprevista = ?, responsavel = ?, status = ?, orcamento = ?, prioridade = ? where id = ?");
        comando.setString(1, projetos.getNome());
        comando.setString(2, projetos.getDescricao());
        comando.setString(3, projetos.getCliente());
        comando.setDate(4, new java.sql.Date(projetos.getDatainicio().getTime()));
        comando.setDate(5, new java.sql.Date(projetos.getDatafimprevista().getTime()));
//        comando.setDate(4, (java.sql.Date)projetos.getDatainicio());
//        comando.setDate(5, (java.sql.Date)projetos.getDatafimprevista());
        comando.setString(6, projetos.getResponsavel());
        comando.setString(7, projetos.getStatus());
        comando.setDouble(8, projetos.getOrcamento());
        comando.setString(9, projetos.getPrioridade());
        comando.setInt(10, projetos.getId());
        comando.execute();
        con.close();
    }
    
    public Projetos consultarByID(Projetos projetos) throws ClassNotFoundException, SQLException{
        Connection con = ConexaoBanco.getConexaoMySQL();
        PreparedStatement comando = con.prepareStatement("select * from projetos where id = ?");
        comando.setInt(1, projetos.getId());
        ResultSet rs = comando.executeQuery();
        Projetos proj = new Projetos();
        if(rs.next()){
            proj.setId(rs.getInt("id"));
            proj.setNome(rs.getString("nome"));
            proj.setDescricao(rs.getString("descricao"));
            proj.setCliente(rs.getString("cliente"));
            proj.setDatainicio(rs.getDate("datainicio"));
            proj.setDatafimprevista(rs.getDate("datafimprevista"));
            proj.setResponsavel(rs.getString("responsavel"));
            proj.setStatus(rs.getString("status"));
            proj.setOrcamento(rs.getDouble("orcamento"));
            proj.setPrioridade(rs.getString("prioridade"));
        }
        return proj;
    }
    
    public List<Projetos> consultarTodos() throws ClassNotFoundException, SQLException{
        Connection con = ConexaoBanco.getConexaoMySQL();
        PreparedStatement comando = con.prepareStatement("select * from projetos");
        ResultSet rs = comando.executeQuery();
        
        List<Projetos> listProjetos = new ArrayList<Projetos>();
        while (rs.next()) {
            Projetos proj = new Projetos();
            proj.setId(rs.getInt("id"));
            proj.setNome(rs.getString("nome"));
            proj.setDescricao(rs.getString("descricao"));
            proj.setCliente(rs.getString("cliente"));
            proj.setDatainicio(rs.getDate("datainicio"));
            proj.setDatafimprevista(rs.getDate("datafimprevista"));
            proj.setResponsavel(rs.getString("responsavel"));
            proj.setStatus(rs.getString("status"));
            proj.setOrcamento(rs.getDouble("orcamento"));
            proj.setPrioridade(rs.getString("prioridade"));
            listProjetos.add(proj);   
        }
        return listProjetos;
    }
}
