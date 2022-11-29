package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import conexion.ConexionBD;
import modelo.Persona;
import java.util.ArrayList;

public class PersonaDao {
    private Connection con;//Crea objeto de tipo conexion
    private Statement st;//Crea objeto de tipo Statement
    private ResultSet rs;//Crea objeto de tipo ResulSet

    public PersonaDao() {
        con = null;
        st = null;
        rs = null;
    }

    public void ingresarAnimales(Persona objPersona){ //Método que inserta en BD las personas que se le envíen en forma de objeto
        //AQUI ASIGNA A UN STRING EL QUERY DE INSERCIÓN CON LOS DATOS EXTRAIDOS DEL OBJETO RECIBIDO DE CONTROL
        String consulta = "insert into PERSONAS(CEDULA,NOMBRE,APELLIDO,CORREO,TELEFONO) values ("+ objPersona.getCedula() + "','" + 
                objPersona.getNombre() + "','" + objPersona.getApellido() + "','" + objPersona.getCorreo() + "','" + objPersona.getTelefono() + "','" + "')";
        try{
            con = (Connection) ConexionBD.getConnection();//SE LLAMA A LA CONEXIÓN
            st = con.createStatement();//SE ASIGNA AL OBJETO STATEMENT LA CONEXION A BD
            st.executeUpdate(consulta);// SE EJECUTA LA INSECIÓN
            st.close();//SE CIERRA EL OBJETO STATEMENT
            ConexionBD.dissconect();// SE CIERRA LA CONEXION

        }catch(SQLException e){
            System.out.println("Consulta imposible");
            System.out.println(e);
        }
        
    }

    public void actualizarAnimal(Persona objPersona, int id){//Método para modificar registros de las personas
        String consulta= "UPDATE PERSONAS SET NOMBRE='"+objPersona.getNombre()+"',APELLIDO='"+objPersona.getApellido()
        +"',CORREO='"+objPersona.getCorreo()+"',TELEFONO='"+objPersona.getTelefono()+"' WHERE CEDULA="+objPersona.getCedula(); //Establezco consulta BD
        try{
                con = (Connection) ConexionBD.getConnection();//SE LLAMA A LA CONEXIÓN
                st = con.createStatement();//SE ASIGNA AL OBJETO STATEMENT LA CONEXION A BD
                st.executeUpdate(consulta);// SE EJECUTA LA INSECIÓN Y GUARDO EL RESULTADO EN RS
                st.close();//SE CIERRA EL OBJETO STATEMENT
                ConexionBD.dissconect();// SE CIERRA LA CONEXION

            }catch(SQLException e){//Captura excepción de SQL
                System.out.println("Consulta imposible");
                System.out.println(e);
            }
        
    }
    
    public ArrayList<Persona> listaPersona(){ //Método que obtiene, guarda y devuelve un arraylist con las personas en BD
        ArrayList<Persona> aPersonaTemp=new ArrayList<>();//Creo ArrayList temporal
        String consulta = "SELECT * FROM ANIMALES";//Establezco consulta BD
        try {
            con = ConexionBD.getConnection();//Obtengo la conexión
            st = con.createStatement();//SE ASIGNA AL OBJETO STATEMENT LA CONEXION A BD
            rs = st.executeQuery(consulta);//Ejecuto la consulta y la guardo en el objeto rs
            while (rs.next()) {
                Persona persona = new Persona(); //Creo un nuevo objeto de persona
                persona.setCedula(rs.getString("CEDULA")); //Seteo los datos de la iteración
                persona.setNombre(rs.getString("NOMBRE"));
                persona.setApellido(rs.getString("APELLIDO"));
                persona.setCorreo(rs.getString("CORREO"));
                persona.setTelefono(rs.getString("TELEFONO"));
                aPersonaTemp.add(persona);//Añado a arraylist el objeto
            }
            st.close();// cierro la conexión
            ConexionBD.dissconect(); //me desconecto de la base de datos
        } catch (SQLException e) {//Si captura algún error lo muestra
            System.out.println("Consulta imposible");
            System.out.println(e);
        }
        return aPersonaTemp;//Retorno arraylist
    }
}
