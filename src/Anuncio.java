import javax.swing.*;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;

public class Anuncio {

    Usuario user;
    Float valoracion;
    String descripcion;
    String direccion;
    ArrayList<ImageIcon> fotos;
    Float precio;

    public Anuncio(Usuario user,Float valoracion,String descripcion,String direccion,ArrayList<ImageIcon> fotos,Float precio){
        this.setDescripcion(descripcion);
        this.setDireccion(direccion);
        this.setFotos(fotos);
        this.setPrecio(precio);
        this.setUser(user);
        this.setValoracion(valoracion);
    }



    public void setUser(Usuario user){

        this.user=user;

    }

    public void setValoracion(Float valoracion){

        this.valoracion=valoracion;

    }

    public void setDireccion(String direccion){

        this.direccion=direccion;

    }

    public void setDescripcion(String descripcion){

        this.descripcion=descripcion;

    }

    public void setFotos(ArrayList<ImageIcon> imagenes){

        this.fotos=imagenes;

    }

    public void setPrecio(Float precio){

        this.precio=precio;

    }


}
