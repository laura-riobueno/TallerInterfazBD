package Logica;
import Interfaz.Interfaz;
import modelo.Persona;

public class Main {
    public static void main(String[] arg) {
		//objeto para testeo
		Persona persona = new Persona();
		Interfaz interfaz = new Interfaz();

		Controlador control= new Controlador(persona, interfaz); // Se instancia Controlador
		interfaz.setVisible(true);
 	}
}