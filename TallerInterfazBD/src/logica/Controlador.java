package logica;

import dao.PersonaDao;
import interfaz.Interfaz;
import modelo.Persona;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controlador implements ActionListener{

    private Persona persona;
    private PersonaDao personaDao;
    private Interfaz interfaz;
    private ArrayList<Persona> aPersona = new ArrayList<>();
    private int posArr;


    public Controlador(Persona persona, Interfaz interfaz){


    }

    public void actualizarVista(){ //Método para cargar en arraylist los datos en BD
        personaDao = new PersonaDao();//Inicializo el objeto persona dao para poder llamar al método de inserción
        aPersona = personaDao.listaPersona();//Asigno al arraylist los datos obtenidos de la consulta
        mostrarVista();//Convoco a método para mostrar en controles los datos
    }

    public void mostrarVista(){
        
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

}