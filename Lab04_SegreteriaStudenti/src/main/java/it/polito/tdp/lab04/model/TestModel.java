package it.polito.tdp.lab04.model;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();
		
		/*
		 * 	Write here your test model
		 */

		for(Corso c : model.getTuttiICorsi())
			System.out.println(c.getCodins());
		
		
		System.out.println(model.getCognomeStudente(146101));
		
		for(String corso :model.getTuttiICorsiString())
			System.out.println(corso);
	}
	

}
