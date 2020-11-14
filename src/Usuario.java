import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class Usuario {

    String nombre,apellidos,correoElec,contraseña;
    ArrayList<Anuncio> anuncios = new ArrayList<Anuncio>();
    ImageIcon fotoPerfil = new ImageIcon("resources"+ File.separator+"perfil.jpeg");
    String telefono = "";
    String metododepago ="";
    String dni = "";
    String direccion = "";
    String sexo = "";
    String fechaNac = "";

    public ArrayList<Anuncio> getAnuncios(){
        return anuncios;
    }

    public void nuevoAnuncio(Anuncio anuncio){
        anuncios.add(anuncio);
    }

    public String getCorreo(){
        return correoElec;
    }

    public Usuario(String nombre, String apellidos, String correoElectr, String contraseña) {

        this.setApellidos(apellidos);
        this.setNombre(nombre);
        this.setContraseña(contraseña);
        this.setCorreoElec(correoElectr);

    }

    public String toString(){
        return this.nombre + ", " + this.apellidos;
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

    public void setTelefono(String telefono){ this.telefono=telefono; }

    public void setMetododepago(String metododepago){ this.metododepago= metododepago; }


    public String getContraseña() {
        return contraseña;
    }

    public String getDni() {

        return dni;
    }

    public String getDireccion() {

        return direccion;
    }

    public String getTelefono() {

        return telefono;
    }

    public String getNombre() {

        return nombre;
    }

    public String getFecha() {

        return fechaNac;
    }

    public String getApellidos() {

        return apellidos;
    }

    public ImageIcon getIcono() {
        return fotoPerfil;
    }

    public void setFoto(ImageIcon imagen) {
        this.fotoPerfil = imagen;
    }


}
