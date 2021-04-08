package it.polito.tdp.lab04.DAO;

public class TestDB {

	public static void main(String[] args) {

		/*
		 * 	This is a main to check the DB connection
		 */
		
		CorsoDAO cdao = new CorsoDAO();
		cdao.getTuttiICorsi();
		cdao.getTuttiICorsiString();
		
		for(String corso : cdao.getTuttiICorsiString())
			System.out.println(corso);
		
		StudenteDAO sdao = new StudenteDAO();
		System.out.println(sdao.completamentoStudente(146101).getNome());
		
	}

}
