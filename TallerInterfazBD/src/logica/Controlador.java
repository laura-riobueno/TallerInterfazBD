package Logica;

import dao.PersonaDao;
import Interfaz.Interfaz;
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
        this.persona = persona;
        this.interfaz = interfaz;
        //Listeners de los botónes
        this.interfaz.btnAnterior.addActionListener(this);
        this.interfaz.btnSiguiente.addActionListener(this);
        this.interfaz.btnReproducir.addActionListener(this);
        this.interfaz.btnDetener.addActionListener(this);
        this.interfaz.btnAgregar.addActionListener(this);
        this.interfaz.btnModificar.addActionListener(this);
        this.interfaz.btnEliminar.addActionListener(this);
        this.interfaz.btnGuardarC.addActionListener(this);
        this.interfaz.btnSalir.addActionListener(this);
        this.interfaz.btnCargarAnimal.addActionListener(this);

    }

    public void actualizarVista(){ //Método para cargar en arraylist los datos en BD
        personaDao = new PersonaDao();//Inicializo el objeto persona dao para poder llamar al método de inserción
        aPersona = personaDao.listaPersona();//Asigno al arraylist los datos obtenidos de la consulta
        mostrarVista();//Convoco a método para mostrar en controles los datos
    }

    public void mostrarVista(){
        Persona an=new Persona(); //Instancio objeto animal
        an=aPersona .get(posArr); //Asigno al objeto el animal de la posición escogida
        this.interfaz.txtCedula.setText(an.getCedula());
        this.interfaz.txtNombre.setText(an.getNombre());
        this.interfaz.txtApellido.setText(an.getApellido());
        this.interfaz.txtCorreo.setText(an.getCorreo());
        this.interfaz.txtTelefono.setText(an.getTelefono());
        
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== this.interfaz.btnAgregar){//PUlSACIÓN DEL BOTÓN AGREGAR
            this.interfaz.txtCedula.setText("");
            this.interfaz.txtNombre.setText("");
            this.interfaz.txtApellido.setText("");
            this.interfaz.txtCorreo.setText("");
            this.interfaz.txtTelefono.setText("");
            this.interfaz.txtCedula.setEditable(true);//Seteo a editables las cajas de texto
            this.interfaz.txtNombre.setEditable(true);
            this.interfaz.txtApellido.setEditable(true);
            this.interfaz.txtCorreo.setEditable(true);
            this.interfaz.txtTelefono.setEditable(true);
            this.interfaz.btnCargarAnimal.setVisible(true);//Muestro botón Adicionar animal 
            this.interfaz.lbImg.setIcon(null);//Quito la imagen de la pantalla
        
        }else{}
    }

}