package src.domain;

import javax.swing.*;
import java.awt.*;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;

public class Anuncio {

    Usuario user;
    Double valoracion = 0.0;
    String descripcion;
    String direccion;
    ImageIcon foto;
    Double precio;
    String tipo;//"Anuncio" o "Trabajo"
    String titulo;

    public Anuncio(Usuario user,String descripcion,String direccion,ImageIcon foto,Double precio,String tipo,String titulo){
        this.setDescripcion(descripcion);
        this.setDireccion(direccion);
        this.setFotos(foto);
        this.setPrecio(precio);
        this.setUser(user);
        this.setTipo(tipo);
        this.setTitulo(titulo);
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setTipo(String tipo){
        this.tipo=tipo;
    }

    public void setUser(Usuario user){

        this.user=user;

    }

    public void setValoracion(Double valoracion){

        Double valor = (valoracion + this.valoracion)/2;
        this.valoracion=valor;

    }

    public void setDireccion(String direccion){

        this.direccion=direccion;

    }

    public void setDescripcion(String descripcion){

        this.descripcion=descripcion;

    }

    public void setFotos(ImageIcon imagenes){

        this.foto=imagenes;

    }

    public void setPrecio(Double precio){

        this.precio=precio;

    }

    public String toString(){
        return descripcion;
    }


    public String getTipo() {

        return tipo;

    }

    public String getPrecio() {
        return String.valueOf(precio);
    }

    public String getPuntuacion() {

        return valoracion + " *";
    }

    public ImageIcon getImage() {

        return foto;

    }

    public String getTitulo() {
        return titulo;
    }

    public String getDir(){
        return direccion;
    }

    public void setFoto(ImageIcon imagen) {

        this.foto=imagen;
    }
}
