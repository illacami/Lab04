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
	
	public String getNomeStudente(String matricola) {
		
		if(studenteDao.completamentoStudente(matricola) != null)
			return studenteDao.completamentoStudente(matricola).getNome();
		
		return null;
	}

	public String getCognomeStudente(String matricola) {
		
		if(studenteDao.completamentoStudente(matricola) != null)
			return studenteDao.completamentoStudente(matricola).getCognome();
		
		return null;
	}
	
	public Corso getCorso(String codins) {
		return corsoDao.getCorso(codins);
	}
	
	public List<Studente> getStudentiIscrittiAlCorso(String codins){
		return corsoDao.getStudentiIscrittiAlCorso(codins);
	}
	
	public List<Corso> getCorsiDelloStudente(String matricola){
		return studenteDao.getCorsiDelloStudente(matricola);
	}
}
