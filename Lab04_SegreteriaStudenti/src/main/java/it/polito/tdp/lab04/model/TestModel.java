package it.polito.tdp.lab04.model;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();
		
		/*
		 * 	Write here your test model
		 */

		System.out.println("\n \n ***** STAMPO IL CODINS DI TUTTI I CORSI *****");
		
		for(Corso c : model.getTuttiICorsi())
			System.out.println(c.getCodins());
		
		
		System.out.println("\n \n ***** STAMPO IL COGNOME DELLO STUDENTE 146101 *****");
		
		System.out.println(model.getCognomeStudente("146101"));
		
		
		System.out.println("\n \n ***** STAMPO TUTTI I CORSI *****");
		
		for(String corso : model.getTuttiICorsiString())
			System.out.println(corso);
		
		
		System.out.println("\n \n ***** CERCO IL CORSO : 01KSUPG *****");
		
		System.out.println(model.getCorso("01KSUPG"));
		
		
		System.out.println("\n \n ***** STAMPO GLI STUDENTI ISCRITTI AL CORSO : 01KSUPG *****");
		
		for(Studente s : model.getStudentiIscrittiAlCorso("01KSUPG"))
			System.out.println(s);
		
		System.out.println("\n \n ***** STAMPO I CORSI A CUI E' ISCRITTO UNO STUDENTE *****");
		System.out.println("\n 170277");
		for(Corso c : model.getCorsiDelloStudente("170277"))
			System.out.println(c);
		System.out.println("\n 146101");
		for(Corso c : model.getCorsiDelloStudente("146101"))
			System.out.println(c);
		
	}
	

}
