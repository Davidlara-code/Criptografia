package coches;

import java.io.Serializable;

public class Coche implements Serializable {

	
	private static final long serialVersionUID = 1L;
	public String Matricula;
	public String Marca;
	public String Modelo;
	public String Precio;
	
	
	public Coche() {
		super();
	
	}


	public Coche(String matricula, String marca, String modelo, String precio) {
		super();
		Matricula = matricula;
		Marca = marca;
		Modelo = modelo;
		Precio = precio;
	}


	public String toString() {
		return "Coche [Matricula=" + Matricula + ", Marca=" + Marca + ", Modelo=" + Modelo + ", Precio=" + Precio + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
