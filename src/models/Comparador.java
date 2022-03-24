package models;

import java.util.Comparator;

public class Comparador implements Comparator <Ordenador> {

	@Override
	public int compare(Ordenador o1, Ordenador o2) {
		
		int num1 = o1.getNumSerie();
		int num2 = o2.getNumSerie();

		return num1 - num2;
	}

	
}
