import java.awt.*;
import java.io.File;
import javax.swing.*;


public class PantallaUsuario extends JFrame
{
    public JPanel pnlSur;
    public JPanel pnlCentral;
    public JPanel pnlNorte;


    public PantallaUsuario()
    {
        this.setLayout(new BorderLayout());
        this.setMaximumSize(new Dimension(300,500));
        this.setMinimumSize(new Dimension(300,500));


        this.iniPanelSur();
        this.iniPanelCentro();
        this.iniPanelNorte();

        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlSur, BorderLayout.SOUTH);
        this.add(pnlNorte, BorderLayout.NORTH);

        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

    public void iniPanelSur()
    {
        pnlSur = new JPanel(new FlowLayout());
        pnlSur.setBackground(Color.RED);
        JLabel lblMensaje1 = new JLabel("NeedUServices");
        JLabel lblMensaje2 = new JLabel("COPYRIGHT 2020");
        JLabel lblMensaje3 = new JLabel("ICAI MADRID");

        pnlSur.add(lblMensaje1);
        pnlSur.add(lblMensaje2);
        pnlSur.add(lblMensaje3);

        pnlSur.setVisible(true);
    }

    public void iniPanelCentro()
    {
        pnlCentral= new JPanel();

        ImageIcon iconoWalla= new ImageIcon("resources"+ File.separator+"wallapop.jpeg");
        var etiqueta1 = new JLabel(iconoWalla);
        pnlCentral.add(etiqueta1);

        pnlCentral.setBackground(Color.WHITE);
        pnlCentral.setVisible(true);

    }

    public void iniPanelNorte()
    {
        pnlNorte = new JPanel();
        pnlNorte.setLayout(new GridLayout(1,8));

        ImageIcon icono1= new ImageIcon("resources"+ File.separator+"logo.jpeg");
        var etiqueta1 = new JLabel(icono1);
        pnlNorte.add(etiqueta1);

        pnlNorte.setBackground(Color.BLACK);

        JTextField buscarTextfield = new JTextField("Bucar");
        ImageIcon iconoLupa= new ImageIcon("resources"+ File.separator+"lupa.png");
        JButton botonBuscar = new JButton(iconoLupa);
        botonBuscar.setBackground(Color.BLACK);

        pnlNorte.add(buscarTextfield);
        pnlNorte.add(botonBuscar);


        ImageIcon iconoPerfil= new ImageIcon("resources"+ File.separator+"perfil.jpeg");
        JButton boton1 = new JButton(iconoPerfil);
        pnlNorte.add(boton1);
        boton1.setBackground(Color.BLACK);

        ImageIcon iconoAjustes= new ImageIcon("resources"+ File.separator+"ajustes.jpeg");
        JButton boton2 = new JButton(iconoAjustes);
        pnlNorte.add(boton2);
        boton2.setBackground(Color.BLACK);




    }
}