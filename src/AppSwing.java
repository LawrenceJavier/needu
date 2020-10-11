import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class AppSwing extends JFrame{

    VentanaRegistrarse ventanaregistro;
    InicioSesion inicioSesion;

    static public void main(String[] args){
        new AppSwing();
    }

    public AppSwing(){
        super.setTitle("NeedU");
        this.setMaximumSize(new Dimension(300,500));
        this.setMinimumSize(new Dimension(300,500));

        JPanel pc = new JPanel();
        JPanel ps = new JPanel(new GridLayout(1,3));
        pc.setLayout(new BoxLayout(pc, BoxLayout.Y_AXIS));
        JPanel pc1 = new JPanel();
        pc1.setLayout(new BoxLayout(pc1, BoxLayout.X_AXIS));

        JButton inicio = new JButton("Iniciar sesión");
        inicio.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton registro = new JButton("Registrate");
        registro.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel frase = new JLabel("El trabajo te busca");
        frase.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel o=new JLabel(" ó ");
        o.setAlignmentX(Component.CENTER_ALIGNMENT);

        ImageIcon needu=new ImageIcon("resources"+File.separator+"logo2.jpeg");
        JLabel logo = new JLabel(needu);
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        pc.add(logo);
        pc.add(frase);
        pc1.add(inicio);
        pc1.add(o);
        pc1.add(registro);
        pc.add( new JLabel(" "));
        pc.add( new JLabel(" "));
        pc.add(pc1);

        pc.setBackground(new Color(201,16,16));
        pc1.setBackground(new Color(201,16,16));
        this.add(pc,BorderLayout.CENTER);


        ps.add(new JLabel("NeedU"));
        JLabel y = new JLabel("2020");
        ps.add(y);
        JLabel z = new JLabel("I.S.");
        ps.add(z);
        this.add(ps,BorderLayout.SOUTH);

        inicio.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("HOLA");
                //importar clases y permitir saltar a ellas
                inicioSesion = new InicioSesion();
                setVisible(false);
            }
        });

        registro.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("HOLA 2");
                //importar clases y permitir saltar a ellas
                ventanaregistro = new VentanaRegistrarse();
                setVisible(false);
            }
        });


        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

    }
}