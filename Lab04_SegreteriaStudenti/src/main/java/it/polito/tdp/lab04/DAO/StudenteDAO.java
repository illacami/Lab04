package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {

	public Studente completamentoStudente(Integer matricola) {
		
		String sql = "SELECT nome, cognome, CDS "
				+ "FROM studente "
				+ "WHERE matricola = ?";
		
		Studente result = null;
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				result = new Studente(matricola, rs.getString("nome"), rs.getString("cognome"), rs.getString("CDS"));
			}
			
			rs.close();
			st.close();
			conn.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return result;
	}
	
	public void getCorsiDelloStudente() {
		/** SELECT
		 * FROM corso c, iscrizione s
		 * WHERE c.codins = i.codins AND i.matricola = "170227"
		 */

	}
}
