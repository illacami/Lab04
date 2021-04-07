package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	private CorsoDAO corsoDao;
	private StudenteDAO studenteDao;
	
	
	public Model() {
		super();
		this.corsoDao = corsoDao;
		this.studenteDao = studenteDao;
	}
	
	public List<Corso> getTuttiICorsi(){
		return corsoDao.getTuttiICorsi();
	}
	
	public Studente getNomeECogmome(Integer matricola) {
		return studenteDao.completamentoStudente(matricola);
	}

}
