package it.polito.tdp.lab04.DAO;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class TestDB {

	public static void main(String[] args) {

		/*
		 * 	This is a main to check the DB connection
		 */
		StudenteDAO sdao = new StudenteDAO();
		CorsoDAO cdao = new CorsoDAO();
		
		cdao.getTuttiICorsi();
		cdao.getTuttiICorsiString();
		
		System.out.println("\n \n ***** STAMPO TUTTI I CORSI *****");
		for(String corso : cdao.getTuttiICorsiString())
			System.out.println(corso);
		
		
		System.out.println("\n \n ***** STAMPO IL NOME DELLO STUDENTE 146101 *****");
		System.out.println(sdao.completamentoStudente("146101").getNome());
		
		
		System.out.println("\n \n ***** CERCO IL CORSO : 01KSUPG *****");
		System.out.println(cdao.getCorso("01KSUPG"));
		
		
		System.out.println("\n \n ***** STAMPO GLI STUDENTI ISCRITTI AL CORSO : 01KSUPG *****");
		for(Studente s : cdao.getStudentiIscrittiAlCorso("01KSUPG"))
			System.out.println(s);
		
		
		System.out.println("\n \n ***** STAMPO I CORSI A CUI E' ISCRITTO UNO STUDENTE *****");
		System.out.println("\n 170277");
		for(Corso c : sdao.getCorsiDelloStudente("170277"))
			System.out.println(c);
		System.out.println("\n 146101");
		for(Corso c : sdao.getCorsiDelloStudente("146101"))
			System.out.println(c);
	}

}
