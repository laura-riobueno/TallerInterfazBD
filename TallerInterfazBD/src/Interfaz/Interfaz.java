package Interfaz;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.TitlePaneLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz extends JFrame{

    public Interfaz(){
        setTitle("Inicio de usuario");
    }

    /**
     * @param args
     */
    public static void main(String[]args){

        Interfaz interfaz = new Interfaz();
        interfaz.setBounds(0,0,500,700);
        interfaz.setVisible(true);
        interfaz.setLocationRelativeTo(null);

    }
}
