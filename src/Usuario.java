import javax.swing.*;
import java.util.ArrayList;

public class Usuario {

    String nombre,apellidos,dni,direccion,sexo,fechaNac,correoElec,contraseña;
    ArrayList anuncios;
    ImageIcon fotoPerfil;
    String telefono;

    public Usuario(String nombre, String apellidos, String correoElectr, String contraseña) {

        this.setApellidos(apellidos);
        this.setNombre(nombre);
        this.setContraseña(contraseña);
        this.setCorreoElec(correoElectr);

    }



    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setApellidos(String apellidos){
        this.apellidos=apellidos;
    }

    public void setDni(String dni){
        this.dni=dni;
    }

    public void setDireccion(String direccion){
        this.direccion=direccion;
    }

    public void setSexo(String sexo){
        this.sexo=sexo;
    }

    public void setFechaNac(String fechaNac){
        this.fechaNac=fechaNac;
    }

    public void setCorreoElec(String correoElec){
        this.correoElec=correoElec;
    }

    public void setContraseña(String contraseña){
        this.contraseña=contraseña;
    }

    public void setAnuncios(ArrayList anuncios){
        this.anuncios=anuncios;
    }

    public void setFotoPerfil(ImageIcon fotoPerfil){
        this.fotoPerfil=fotoPerfil;
    }

    public void setTelefono(String telefono){ this.telefono=telefono;}


}
