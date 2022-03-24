package models;

public class Ordenador {


	/*
	 * ATRIBUTOS
	 */
	private String name;
	private int numSerie;
	
	
	/*
	 * CONSTRUCTOR
	 */
	public Ordenador(String name, int numSerie) {
		super();
		this.name = name;
		this.numSerie = numSerie;
	}
	
	
	/*
	 * G & S
	 */
	public String getName() {
		return name;
	}


	public void setName(String modelo) {
		this.name = modelo;
	}


	public int getNumSerie() {
		return numSerie;
	}


	public void setNumSerie(int numSerie) {
		this.numSerie = numSerie;
	}
	
	
	/*
	 * TO STRING
	 */
	@Override
	public String toString() {
		return "Número Serie: " + numSerie + "\nOrdenador: " + name +  "\n";
	}

}
