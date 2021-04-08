package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	private CorsoDAO corsoDao;
	private StudenteDAO studenteDao;
	
	
	public Model() {
		corsoDao = new CorsoDAO();
		studenteDao = new StudenteDAO();
	}
	
	public List<Corso> getTuttiICorsi(){
		return corsoDao.getTuttiICorsi();
	}
	
	public List<String> getTuttiICorsiString(){
		return corsoDao.getTuttiICorsiString();
	}
	
	public String getNomeStudente(Integer matricola) {
		
		if(studenteDao.completamentoStudente(matricola) != null)
			return studenteDao.completamentoStudente(matricola).getNome();
		
		return null;
	}

	public String getCognomeStudente(Integer matricola) {
		
		if(studenteDao.completamentoStudente(matricola) != null)
			return studenteDao.completamentoStudente(matricola).getCognome();
		
		return null;
	}
}
