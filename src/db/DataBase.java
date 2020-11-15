package src.db;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import src.domain.Usuario;

/**
 * Gestiona todos los datos de los pacientes y de los medicos
 */

public class DataBase {

    String url = "jdbc:sqlite:."+File.separator+"resources"+File.separator+"DataBase.db";
    Connection conn = null;
    boolean comp;
    /**
    *Metodo para obtener el numero de pacientes totales de la bd
    *@return res valor que se va a devolver con el numero de pacientes totales
    */
    
    public int numeroPacientes(){
        String sql = "SELECT * FROM pacientes ";
        int res=0;
        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                res=res+1;
            }
            return res;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return 0;
    }
    /**
    *Metodo para validar la clave de los usuarios del programa
    *@param nombreusuario nombre del usuario que se desea validar
    *@param contra contraseña que se desea validar 
    *@return comp verdadero si coincide, falso sino
    */
    public boolean validarClave(String correo, String contra) { //INCIO DE SESIÓN
        //busco el nombre de usuario u establezco la conexion y luego comprueblo que la contraseña coincide con la introducida 
        String sql = "SELECT * FROM usuarios where Correo like ?";
        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1,correo);
			ResultSet rs = stmt.executeQuery();
            if(contra.equals(rs.getString("Contra"))){
                    comp=true;
                    return comp;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        comp=false;
		return comp;
    }

    public boolean validarCorreo(String correo) { //Validar que el correo esta en la bd
        //busco el nombre de usuario u establezco la conexion y luego comprueblo que la contraseña coincide con la introducida 
        String sql = "SELECT * FROM usuarios where Correo like ?";
        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1,correo);
			ResultSet rs = stmt.executeQuery();
            if(rs.getString("Contra")!=null){
                comp=true;
                return comp;
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            comp = false;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return comp;
    }

    
	public Usuario getInfo(String correo, String contraseña) {
        String sql = "SELECT * FROM '"+correo+"' ";
        HashMap<String,ArrayList<String>> matres = new HashMap<>();
        Usuario u = new Usuario("", "", "", "");

        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            String nombre=rs.getString("Nombre");
            String apellido=rs.getString("Apellido");
            String fecha=rs.getString("FechaNac");
            String dni=rs.getString("DNI");
            String direccion=rs.getString("Direccion");
            String sexo=rs.getString("Sexo");
            String telefono=rs.getString("Telefono");
            //ImageIcon foto = (ImageIcon) rs.getBlob("Foto");
            u = new Usuario(nombre, apellido, correo, contraseña);


            if(fecha.equals("null")){
                u.setFechaNac("dd/mm/aaaaa");
            }else{
                u.setFechaNac(fecha);
            }

            if(dni == null){
                u.setDni("XXXXXXXXA");
            }else{
                u.setDni(dni);
            }

            if(direccion == null){
                u.setDireccion("Direccion");
            }else{
                u.setDireccion(direccion);
            }

            if(sexo == null){
                u.setSexo("sexo");
            }else{
                u.setSexo(sexo);
            }

            if(telefono == null){
                u.setTelefono("+YY XXXXXXXXX");
            }else{
                u.setTelefono(telefono);
            }
            u.setFoto(new ImageIcon("resources"+ File.separator+"perfil.jpeg"));

            /*if(foto == null){
                                u.setFoto(new ImageIcon("resources"+ File.separator+"perfil.jpeg"));
            }else{
                u.setFoto(foto);
            }
            */


        } catch (SQLException e) {
            System.out.println("ola");
            System.out.println("fallo");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return u;
	}

    /**
    *Metodo para añadir un usuario a la bd
    *@param nombre nombre del nuevo usuario
    *@param clave clave del nuevo usuario
    */
    public boolean anadirUsuario(String correo, String clave, String nombre, String apellido){  //TABLA CON CORREO Y CONTRASEÑA
        String sql = "INSERT INTO usuarios (Correo,Contra) VALUES (?,?)";
        //no hace falta qu valide si existe o no un usuario con ese nombre, ya que me lo valida internamente     
        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,correo);
            stmt.setString(2,clave);
            int res = stmt.executeUpdate();
            if(res>0){
                JOptionPane.showMessageDialog(null,"Usuario creado correctamente.");
                //crear tabal de usuario
                String a = "CREATE TABLE '"+correo+"' (Nombre TEXT NOT NULL, Apellido TEXT NOT NULL, FechaNac TEXT, DNI TEXT, Direccion TEXT, Sexo TEXT, Telefono TEXT, Foto BLOB)";
                System.out.println(a);
                PreparedStatement stmtI = conn.prepareStatement(a);
                stmtI.executeUpdate();
                //insertar valores
                String sqlII= "INSERT INTO '"+correo+"' (nombre, apellido) VALUES (?,?)";
                PreparedStatement stmtII = conn.prepareStatement(sqlII);
                stmtII.setString(1,nombre);
                stmtII.setString(2,apellido);
                stmtII.executeUpdate();
                return true;
            }else{
                JOptionPane.showMessageDialog(null,"Fallo al crear usuario. Intente otra vez.");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Este nombre de usuario ya existe.Elija otro.");
            return false;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
    *Metodo para añadir pacientes a la bd
    *@param nombre nombre del paciente
    *@param edad edad del paciente
    *@param dni dni del paciente
    *@param peso peso del pacientes
    //HOlda
    */

    public void actualizarPrivado(String correo, String dni, String direccion, String sexo, String telefono) {

        String sql= "UPDATE '"+correo+"' SET DNI=?, Direccion=?, Sexo=?, Telefono=?"; //  WHERE Dni=?
        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,dni);
            stmt.setString(2,direccion);
            stmt.setString(3,sexo);
            stmt.setString(4,telefono);
            int res = stmt.executeUpdate();
            }catch (SQLException e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null,"ERROR 2");
            }finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }  
            }
    }
    
    public void actualizarBasico(String correo, String nombre, String apellido, String fecha, String correo2) {
        //RENAME nombre_tabla TO nuevo_nombre
        String sql= "UPDATE '"+correo+"' SET Nombre=?, Apellido=?, FechaNac=?"; //  WHERE Dni=?
        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,nombre);
            stmt.setString(2,apellido);
            stmt.setString(3,fecha);
            int res = stmt.executeUpdate();
            }catch (SQLException e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null,"ERROR 2");
            }finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }  
            }
	}


    public void anadirPaciente(String nombre, int edad, String dni, int peso){
        String busqueda = this.buscarPaciente(dni);
        if(busqueda==null){
            String sql= "INSERT INTO pacientes (Nombre,Dni) VALUES (?,?)";
            try {
                conn = DriverManager.getConnection(url);
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1,nombre);
                stmt.setString(2,dni);
                int res = stmt.executeUpdate();
                if(res>0){
                    String sqlI= "CREATE TABLE '"+dni+"' (Edad INTEGER NOT NULL UNIQUE, Peso INTEGER NOT NULL)";
                    System.out.println(sqlI);
                    PreparedStatement stmtI = conn.prepareStatement(sqlI);
                    stmtI.executeUpdate();

                    String sqlII= "INSERT INTO '"+dni+"' (Edad, Peso) VALUES (?,?)";
                    PreparedStatement stmtII = conn.prepareStatement(sqlII);
                    stmtII.setInt(1,edad);
                    stmtII.setInt(2,peso);
                    stmtII.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Paciente añadido correctamente a la base de datos");
        
                }else{
                        JOptionPane.showMessageDialog(null,"ERROR 1");
                    }
                }catch (SQLException e) {
                    System.out.println(e.getMessage());
                    JOptionPane.showMessageDialog(null,"ERROR 2");
                }finally {
                    try {
                        if (conn != null) {
                            conn.close();
                        }
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }  
                } 
        
        }else{
            String nombrecomp = this.getNombre(dni);
            if(nombrecomp.compareTo(nombre)==0){
                try{
                conn = DriverManager.getConnection(url);
                String sql= "INSERT INTO '"+dni+"' (Edad, Peso) VALUES (?,?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1,edad);
                stmt.setInt(2,peso);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"Se ha asignado al paciente el peso indicado para la edad indicada");
                }catch (SQLException e) {
                    System.out.println(e.getMessage());
                    JOptionPane.showMessageDialog(null,"Este paciente ya tiene un peso correspondiente a la edad indicada.\nSi desea modificarlo vaya a la ventana de Actualizar");
                }finally {
                    try {
                        if (conn != null) {
                            conn.close();
                        }
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }  
                } 
            }else{
                JOptionPane.showMessageDialog(null,"El DNI no corresponde al paciente");
            }
        }
    }

    /**
    *Metodo para eliminar pacientes de la bd
    *@param dni dni del paciente que se desea eliminar
    */

    public void eliminarPaciente(String dni){
        String sql = "DELETE FROM pacientes where Dni like ?";
        String sqlI = "DROP TABLE '"+dni+"' ";
        try {
            String url = "jdbc:sqlite:."+File.separator+"resources"+File.separator+"DataBase.db";
            conn = DriverManager.getConnection(url);
            PreparedStatement stmt = conn.prepareStatement(sql);
            PreparedStatement stmtI = conn.prepareStatement(sqlI);
            stmt.setString(1,dni);
            //me devuelve el numero de filas afectadas
            int res = stmt.executeUpdate();
            if(res>0){
                JOptionPane.showMessageDialog(null,"Paciente ha sido eliminado de la base de datos");
                int resI = stmtI.executeUpdate();
                if(resI<0){
                    JOptionPane.showMessageDialog(null,"Fallo al eliminar el paciente");
                }
            }else{
                JOptionPane.showMessageDialog(null,"Fallo al eliminar la tabla");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,"Este paciente ya ha sido eliminado");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
    *Metodo para bucar un pacientes en la bd
    *@param dni dni del paciente que se desea buscar
    *@return res devuelve una lista de elementos en los que el dni es igual al indicado
     */
    public String buscarPaciente(String dni){  //se puede trasformar para buscar una anuncio
        String res;
        String sql = "SELECT * FROM pacientes where Dni like ?";
        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1,dni);
			ResultSet rs = stmt.executeQuery();
            res = rs.getString("Nombre") + " \t" +rs.getString("Dni");
            return res;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return null;
    }

    /**
    *Metodo para obtener el nombre de un paciente
    *@param dni dni del paciente del que se desea obtener el nombre
    *@return res devuelve una lista de elementos en los que el dni es igual al indicado
    */
    public String getNombre(String dni){
        String res;
        String sql = "SELECT * FROM pacientes where Dni like ?";
        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1,dni);
			ResultSet rs = stmt.executeQuery();
            res =rs.getString("Nombre");
            return res;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return null;
    }

    /**
    *Metodo para mostrar todos los pacientes de la bd
    *@return matres devuelve una matriz con todos los nombres asignados a el dni correspondiente
    */
    public HashMap<String, ArrayList<String>> mostrarPacientes(){
        String sql = "SELECT * FROM pacientes ";
        HashMap<String,ArrayList<String>> matres = new HashMap<>();
        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String dni = rs.getString("Dni");
                matres.put(dni, new ArrayList<String>()); 
                matres.get(dni).add(rs.getString("Nombre"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return matres;
    }	

    /**
    *Metodo para obtener todos los pesos correspondientes a las edades del dni indicado
    *@param dni dni del paciente que se ha seleccionado
    *@return matres matriz con todas las edades y pesos asignados a esas edades del dni indicado
    */
    public HashMap<String, ArrayList<String>> getEdadesPesos(String dni){
        String sql = "SELECT * FROM '"+dni+"' ";
        HashMap<String,ArrayList<String>> matres = new HashMap<>();
        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String edad = rs.getString("Edad");
                matres.put(edad, new ArrayList<String>()); 
                matres.get(edad).add(Integer.toString(rs.getInt("Peso")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return matres;
    }	

    /**
    *Metodo para verificar que el paciente existe
    *@param nombrepaciente nombre del paciente que se quiere actualizar
    *@param dni dni del paciente que se desea actualizar
    *@return comp true si verdadero false sino
    */
    public boolean verificarActualizacion(String nombrepaciente, String dni) {
       String sql = "SELECT * FROM pacientes where Dni like ?";
        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1,dni);
			ResultSet rs = stmt.executeQuery();
            if(nombrepaciente.equals(rs.getString("Nombre"))){
                comp=true;
                return comp;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        comp=false;
		return comp;
    }

    /**
    *Metodo para actualizar la informacion del pacientes
    *@param nombre nombre del paciente a actualizar
    *@param edad edad del paciente a actualizar
    *@param dni dni del paciete a actualizar
    *@param peso peso del paciente a actualizar
    */
    public void actualizarPaciente(String nombre, int edad, String dni, int peso){
        if (this.buscarPeso(dni, edad)){
            String sql= "UPDATE pacientes SET Nombre=? WHERE Dni=?";
            try {
                conn = DriverManager.getConnection(url);
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1,nombre);
                stmt.setString(2,dni);
                int res = stmt.executeUpdate();
                if(res>0){
                    String sqlI= "UPDATE '"+dni+"' SET Peso=? WHERE Edad=?";
                    PreparedStatement stmtI = conn.prepareStatement(sqlI);
                    stmtI.setInt(1,peso);
                    stmtI.setInt(2,edad);
                    int resI=stmtI.executeUpdate();
                    if(resI>0){
                        JOptionPane.showMessageDialog(null,"La informacion del paciente ha sido actualizada");
                    }
                    }else{
                            JOptionPane.showMessageDialog(null,"ERROR 1");
                        }
                }catch (SQLException e) {
                    System.out.println(e.getMessage());
                    JOptionPane.showMessageDialog(null,"ERROR 2");
                }finally {
                    try {
                        if (conn != null) {
                            conn.close();
                        }
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }  
                } 
        }else{
            JOptionPane.showMessageDialog(null, "No existe ningun peso asignado a esta edad. \nDirijase a la ventana de Insercion de pacientes e introduzca \n ahi la informacion deseada");
        }
        
        }

    /**
    *Metodo para comprobar si hay un peso asignado a la edad indicada
    *@param dni dni que se esta buscando 
    *@param edad edad que se esta buscando
    *@return comp true si existe false sino
    */
        public boolean buscarPeso(String dni, int edad){
            String sql = "SELECT * FROM '"+dni+"' where Edad like ?";
            try {
                conn = DriverManager.getConnection(url);
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1,edad);
                ResultSet rs = stmt.executeQuery();
                
                if (rs.getInt("Edad")==edad){
                    comp=true;
                    return comp;
                }
                
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            comp=false;
            return comp;
        }
	
	
}