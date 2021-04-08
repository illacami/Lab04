package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {

	public Studente completamentoStudente(String matricola) {
		
		String sql = "SELECT matricola, nome, cognome, CDS "
				+ "FROM studente "
				+ "WHERE matricola = ?";
		
		Studente result = null;
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, matricola);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				result = new Studente(rs.getInt("matricola"), rs.getString("nome"), rs.getString("cognome"), rs.getString("CDS"));
			}
			
			rs.close();
			st.close();
			conn.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return result;
	}
	
	public List<Corso> getCorsiDelloStudente(String matricola) {
		
		String sql =  "SELECT * "
				+ "FROM corso c, iscrizione i "
				+ "WHERE c.codins = i.codins AND i.matricola = ?";
		 
		List<Corso> corsi = new LinkedList<Corso>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, matricola);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Corso c = new Corso(rs.getString("codins"), rs.getInt("crediti"), rs.getString("nome"), rs.getInt("pd"));
				corsi.add(c);
			}
			
			rs.close();
			st.close();
			conn.close();
			
			}catch(SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		
		return corsi;

	}
}
