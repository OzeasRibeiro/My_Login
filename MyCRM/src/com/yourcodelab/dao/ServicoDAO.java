package com.yourcodelab.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yourcodelab.model.Cliente;
import com.yourcodelab.model.Servico;

public class ServicoDAO extends GenericDAO{
	private PreparedStatement ps;
	private String SQL_INSERT = "INSERT INTO TBSERVICO(CATEGORIA,STATUS) VALUES (?,?);";
	private String SQL_SELECT = "SELECT id, categoria, status FROM TBSERVICO;";
	
	public void inserirServico(Servico s){
		
		
		try {
			// Abrir conex�o
			openConnection();
			// Preparar o comando SQL a ser enviado ao BD
			ps = connect.prepareStatement(SQL_INSERT);
			ps.setString(1, s.getCategoria());
			ps.setString(2, s.getStatus());
			// Executar o comando de INSERT, logo n�o se espera retorno
			ps.executeUpdate();
			// Fechar conex�o
			
		} catch (ClassNotFoundException e) {
			System.out.println("Class not Found");
		} catch (IOException e) {
			System.out.println("File not Found");
		} catch (SQLException e) {
			System.out.println("Error on Connecting  \n"+e);
		}
		closeConnection();
	}
	
	public List<Servico> listarTodos(){
		List<Servico> lista = new ArrayList<Servico>();
		
		try {
			// Abrir conex�o
			openConnection();
			
			// Preparar comando de SELECT
			ps = connect.prepareStatement(SQL_SELECT);
			
			// Retorno da consulta com os dados no ResultSet
			ResultSet rs = ps.executeQuery();
			
			// Se houve retorno
			if(rs != null){
				while(rs.next()){
					// Para cada registro do ResultSet, instanciar um objeto Servico
					Servico s = new Servico(rs.getInt("id"),rs.getString("categoria"),rs.getString("status"));
					
					// Adicionar na lista de Clientes
					lista.add(s);
				}
			}
			
			// Fechar conex�o
			closeConnection();
		} catch (ClassNotFoundException e) {
			System.out.println("Class not Found");
		} catch (IOException e) {
			System.out.println("File not Found");
		} catch (SQLException e) {
			System.out.println("Error on Connecting");
		}
		
		// Se por acado n�o houve retorno do banco de dados, retorna
		return lista;
	}
	}

