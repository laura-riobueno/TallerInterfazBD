package Interfaz;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.TitlePaneLayout;
import javax.swing.text.AttributeSet.ColorAttribute;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class Interfaz extends JFrame implements ActionListener{
    private JLabel cedula,nombre,apellido,correo,telefono;
    private JTextField ced,nom,ape,cor,tel;
    private JButton Limpiar,Volver,Enviar;


    public Interfaz(){
        
        setTitle("Inicio de usuario");
        setLayout(null);
        getContentPane().setBackground(new Color(237, 187, 153));
        cedula = new JLabel("Cedula");
        cedula.setBounds(50,20,200,35);
        add(cedula);

        nombre = new JLabel("Nombre");
        nombre.setBounds(50,60,200,35);
        add(nombre);

        apellido = new JLabel("Apellido");
        apellido.setBounds(50,100,200,35);
        add(apellido);

        correo = new JLabel("Correo");
        correo.setBounds(50,140,200,35);
        add(correo);

        telefono = new JLabel("Telefono");
        telefono.setBounds(50,180,200,35);
        add(telefono);

        ced = new JTextField("");
        ced.setBounds(150,20,300,35);
        add(ced);

        nom = new JTextField("");
        nom.setBounds(150,60,300,35);
        add(nom);

        ape = new JTextField("");
        ape.setBounds(150,100,300,35);
        add(ape);

        cor = new JTextField("");
        cor.setBounds(150,140,300,35);
        add(cor);

        tel = new JTextField("");
        tel.setBounds(150,180,300,35);
        add(tel);

        Limpiar = new JButton("Borrar Datos");
        Limpiar.setBounds(150,220,150,40);
        add(Limpiar);
        Limpiar.addActionListener(this);

        Enviar = new JButton("Enviar Datos");
        Enviar.setBounds(300,220,150,40);
        add(Enviar);
        Enviar.addActionListener(this);

        Volver = new JButton("Volver");
        Volver.setBounds(150,270,150,40);
        add(Volver);
        Volver.addActionListener(this);
    }

    public void actionPerformed(ActionEvent L){
        if(L.getSource()==Limpiar){

            ced.setText("");
            nom.setText("");
            ape.setText("");
            cor.setText("");
            tel.setText("");

        }
    }
    /**
     * @param args
     */
    public static void main(String[]args){

        Interfaz interfaz = new Interfaz();
        interfaz.setBounds(0,0,500,500);
        interfaz.setVisible(true);
        interfaz.setLocationRelativeTo(null);

    }
}
