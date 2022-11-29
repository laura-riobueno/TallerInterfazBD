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
    private ArrayList<Persona> aPersonaMostrar = new ArrayList<>();
    private int posArr;


    public Controlador(Persona persona, Interfaz interfaz){
        this.persona = persona;
        this.interfaz = interfaz;
        //Listeners de los botónes
        this.interfaz.btnAgregar.addActionListener(this);
        this.interfaz.btnModificar.addActionListener(this);
        this.interfaz.btnGuardarC.addActionListener(this);
        this.interfaz.btnGuardarI.addActionListener(this);
        this.interfaz.btnSalir.addActionListener(this);
        this.interfaz.btnAnterior.addActionListener(this);
        this.interfaz.btnSiguiente.addActionListener(this);
        actualizarVista();
    }

    public void actualizarVista(){ //Método para cargar en arraylist los datos en BD
        personaDao = new PersonaDao();//Inicializo el objeto persona dao para poder llamar al método de inserción
        aPersonaMostrar = personaDao.listaPersona();//Asigno al arraylist los datos obtenidos de la consulta
        mostrarVista();//Convoco a método para mostrar en controles los datos
    }

    public void mostrarVista(){
        Persona per=new Persona(); //Instancio objeto animal
        per=aPersonaMostrar.get(posArr); //Asigno al objeto el animal de la posición escogida
        this.interfaz.txtCedula.setText(per.getCedula());
        this.interfaz.txtNombre.setText(per.getNombre());
        this.interfaz.txtApellido.setText(per.getApellido());
        this.interfaz.txtCorreo.setText(per.getCorreo());
        this.interfaz.txtTelefono.setText(per.getTelefono());
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
            this.interfaz.btnAnterior.setEnabled(false);
            this.interfaz.btnSiguiente.setEnabled(false);
            this.interfaz.btnModificar.setEnabled(false);
            this.interfaz.btnGuardarC.setEnabled(false);
            
        }
        if(e.getSource()== this.interfaz.btnGuardarI){//PUlSACIÓN DEL BOTÓN GUARDAR MODIFICACIONES
            PersonaDao perAct = new PersonaDao();//Crea objeto animales dao para llamar al método de modificar 
            Persona personaAct = new Persona();//Creo objeto de animales para guardar info a modificar
            personaAct.setCedula(this.interfaz.txtCedula.getText());//Seteo en objeto los datos a modificar desde los textbox
            personaAct.setNombre(this.interfaz.txtNombre.getText());
            personaAct.setApellido(this.interfaz.txtApellido.getText());
            personaAct.setCorreo(this.interfaz.txtCorreo.getText());
            personaAct.setTelefono(this.interfaz.txtTelefono.getText());
            perAct.ingresarPersona(personaAct);
            actualizarVista();
            this.interfaz.txtCedula.setEditable(false);//Seteo a editables las cajas de texto
            this.interfaz.txtNombre.setEditable(false);
            this.interfaz.txtApellido.setEditable(false);
            this.interfaz.txtCorreo.setEditable(false);
            this.interfaz.txtTelefono.setEditable(false);//Oculto botón guardar cambios
            this.interfaz.btnAnterior.setEnabled(true);
            this.interfaz.btnSiguiente.setEnabled(true);
            this.interfaz.btnModificar.setEnabled(true);
            this.interfaz.btnAgregar.setEnabled(true);
            this.interfaz.btnGuardarC.setEnabled(true);
            this.interfaz.btnGuardarI.setEnabled(true);
            
        }

        if(e.getSource()== this.interfaz.btnModificar){//PUlSACIÓN DEL BOTÓN MODIFICAR
            this.interfaz.txtNombre.setEditable(true);//Seteo a editables las cajas de texto
            this.interfaz.txtApellido.setEditable(true);
            this.interfaz.txtCorreo.setEditable(true);
            this.interfaz.txtTelefono.setEditable(true);
            this.interfaz.btnAnterior.setEnabled(false);
            this.interfaz.btnSiguiente.setEnabled(false);
            this.interfaz.btnAgregar.setEnabled(false);
            this.interfaz.btnGuardarI.setEnabled(false);
        }
    
        if(e.getSource()== this.interfaz.btnGuardarC){//PUlSACIÓN DEL BOTÓN GUARDAR MODIFICACIONES
            PersonaDao perAct = new PersonaDao();//Crea objeto animales dao para llamar al método de modificar 
            Persona personaAct = new Persona();//Creo objeto de animales para guardar info a modificar
            personaAct.setCedula(this.interfaz.txtCedula.getText());//Seteo en objeto los datos a modificar desde los textbox
            personaAct.setNombre(this.interfaz.txtNombre.getText());
            personaAct.setApellido(this.interfaz.txtApellido.getText());
            personaAct.setCorreo(this.interfaz.txtCorreo.getText());
            personaAct.setTelefono(this.interfaz.txtTelefono.getText());
            perAct.actualizarPersona(personaAct);
            actualizarVista();
            this.interfaz.txtCedula.setEditable(false);//Seteo a editables las cajas de texto
            this.interfaz.txtNombre.setEditable(false);
            this.interfaz.txtApellido.setEditable(false);
            this.interfaz.txtCorreo.setEditable(false);
            this.interfaz.txtTelefono.setEditable(false);//Oculto botón guardar cambios
            this.interfaz.btnAnterior.setEnabled(true);
            this.interfaz.btnSiguiente.setEnabled(true);
            this.interfaz.btnModificar.setEnabled(true);
            this.interfaz.btnAgregar.setEnabled(true);
            this.interfaz.btnGuardarC.setEnabled(true);
            this.interfaz.btnGuardarI.setEnabled(true);
            
        }
        if(e.getSource()== this.interfaz.btnSalir){
            this.interfaz.setVisible(false);//Cierro el aplicativo ocultando la ventana y cerrando el proceso
            this.interfaz.dispose();
            System.exit(0);//Mato el proceso
        }
        if(e.getSource()== this.interfaz.btnAnterior){ //PUlSACIÓN DEL BOTÓN ANTERIOR
            if(posArr!=0){//Si la posición del array es diferente a la primera
                posArr--;//Le resta uno a la posición del array
                mostrarVista();//Llama a método para mostrar datos en pantalla
            }
        }
        if(e.getSource()== this.interfaz.btnSiguiente){//PUlSACIÓN DEL BOTÓN SIGUIENTE
            if(posArr!=aPersonaMostrar.size()-1){//Si la posición del array es diferente a la ultima posición
                posArr++;//Si la posición del array es diferente a la primera
                mostrarVista();//Llama a método para mostrar datos en pantalla
            }
        }
    }
}