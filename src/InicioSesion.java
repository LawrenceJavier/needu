import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;

import static javax.swing.JOptionPane.showMessageDialog;

public class InicioSesion extends JFrame {

    JFrame ventana;
    JTextField correoField;
    JLabel iniciarSesionLabel,correoLabel,contraseñaLabel,vacio1Label,vacio2Label,vacio3Label;
    JButton entrarBoton,olvidarContraseñaBoton;
    JPanel centroPanel,centroPanelRegistro,superiorPanel,centroPanelOlvidar,centroPanelOk,inferiorPanel;
    JPasswordField contraseñaField;

    JLabel introLabel,vacio4Label,vacio5Label,vacio6Label,vacio7Label,vacio8Label,vacio9Label,vacio10Label;
    JTextField introText;
    JButton enviarBoton;

    JLabel revisarLabel;
    JButton revisarBoton;

    JLabel descripcionLabel1,descripcionLabel2,descripcionLabel3;

    public InicioSesion(){

        ventana = new JFrame();

        this.setLayout(new BorderLayout());
        this.setResizable(true);
        this.setMinimumSize(new Dimension(300,500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        centroPanel = new JPanel();
        centroPanelRegistro = new JPanel();
        superiorPanel = new JPanel();
        centroPanelOlvidar =  new JPanel();
        centroPanelOk = new JPanel();
        inferiorPanel = new JPanel();

        inferiorPanel.setLayout(new FlowLayout());
        centroPanelRegistro.setLayout(new GridLayout(10,1));
        superiorPanel.setLayout(new GridLayout(1,5));
        centroPanelOlvidar.setLayout(new GridLayout(10,1));
        centroPanel.setLayout(new CardLayout());;

        correoField = new JTextField();
        contraseñaField = new JPasswordField();

        iniciarSesionLabel = new JLabel("INICIAR SESION");
        iniciarSesionLabel.setHorizontalAlignment(JLabel.CENTER);
        correoLabel = new JLabel("CORREO ELECTRONICO");
        correoLabel.setHorizontalAlignment(JLabel.CENTER);
        contraseñaLabel = new JLabel("CONTRASEÑA");
        contraseñaLabel.setHorizontalAlignment(JLabel.CENTER);
        vacio1Label = new JLabel();
        vacio2Label = new JLabel();
        vacio3Label = new JLabel();
        vacio4Label = new JLabel();
        vacio5Label = new JLabel();
        vacio6Label = new JLabel();
        vacio7Label = new JLabel();
        vacio8Label = new JLabel();
        vacio9Label = new JLabel();
        vacio10Label = new JLabel();
        revisarLabel = new JLabel("Revise su correo electronico");

        descripcionLabel1 = new JLabel();
        descripcionLabel2 = new JLabel();
        descripcionLabel3 = new JLabel();


        entrarBoton = new JButton("ENTRAR");
        olvidarContraseñaBoton = new JButton("OLVIDE MI CONTRASEÑA");
        revisarBoton = new JButton("VOLVER");

        introLabel = new JLabel("Introduzca Correo Electronico");
        introText = new JTextField();
        enviarBoton = new JButton("Reestablecer Contraseña");



        ImageIcon logo = new ImageIcon("resources"+ File.separator+"logo.jpeg");
        JLabel logoLabel = new JLabel(logo);
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);




        revisarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) centroPanel.getLayout();
                cardLayout.show(centroPanel, "Registro");
            }
        });

        enviarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) centroPanel.getLayout();
                cardLayout.show(centroPanel, "Revisar");
            }
        });

        olvidarContraseñaBoton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                CardLayout cardLayout = (CardLayout) centroPanel.getLayout();
                cardLayout.show(centroPanel, "Olvidar");
            }

        });

        //try catch
        entrarBoton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                comprobarCorreoContraseña();

            }

        });

        correoField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String texto = correoField.getText();

                if (texto.equals("")) {

                    correoField.setBackground(Color.WHITE);

                }
            }
        });

        contraseñaField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String textoContraseña = new String(contraseñaField.getPassword());

                if(textoContraseña.equals("")){

                    contraseñaField.setBackground(Color.WHITE);

                }
            }
        });

        centroPanelRegistro.add(iniciarSesionLabel);
        centroPanelRegistro.add(vacio1Label);
        centroPanelRegistro.add(correoLabel);
        centroPanelRegistro.add(correoField);
        centroPanelRegistro.add(contraseñaLabel);
        centroPanelRegistro.add(contraseñaField);
        centroPanelRegistro.add(vacio2Label);
        centroPanelRegistro.add(entrarBoton);
        centroPanelRegistro.add(olvidarContraseñaBoton);
        centroPanelRegistro.add(vacio3Label);

        centroPanelOlvidar.add(vacio4Label);
        centroPanelOlvidar.add(vacio4Label);
        centroPanelOlvidar.add(vacio4Label);
        centroPanelOlvidar.add(introLabel);
        centroPanelOlvidar.add(introText);
        centroPanelOlvidar.add(vacio4Label);
        centroPanelOlvidar.add(enviarBoton);
        centroPanelOlvidar.add(vacio4Label);
        centroPanelOlvidar.add(vacio4Label);
        centroPanelOlvidar.add(vacio4Label);

        centroPanelOk.add(revisarLabel);
        centroPanelOk.add(revisarBoton);

        superiorPanel.add(logoLabel);
        superiorPanel.add(new JLabel());
        superiorPanel.add(new JLabel());
        superiorPanel.add(new JLabel());
        superiorPanel.add(new JLabel());



        centroPanel.add(centroPanelRegistro,"Registro");
        centroPanel.add(centroPanelOlvidar,"Olvidar");
        centroPanel.add(centroPanelOk,"Revisar");

        CardLayout cardLayout = (CardLayout) centroPanel.getLayout();
        cardLayout.show(centroPanel, "Registro");



        this.add(centroPanel, BorderLayout.CENTER);
        this.add(superiorPanel,BorderLayout.NORTH);

        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);

    }

    private void comprobarCorreoContraseña() {

        String correo = correoField.getText();
        String contraseña = new String(contraseñaField.getPassword());

        if (correo.equals("afernandezpacheco@icai.comillas.edu")) {

            if (contraseña.equals("comandante")) {

                showMessageDialog(InicioSesion.this, "INICIO CORRECTO", "PASAR", JOptionPane.OK_OPTION);

            } else {

                showMessageDialog(InicioSesion.this, "CONTRASEÑA ERRONEA", "NO PASAR", JOptionPane.ERROR_MESSAGE);
                contraseñaField.setBackground(Color.RED);
                contraseñaField.selectAll();
                contraseñaField.requestFocus();

            }

        } else {

            if (contraseña.equals("comandante")) {

                showMessageDialog(InicioSesion.this, "CORREO NO ESTA EN BASE DE DATOS", "NO PASAR", JOptionPane.ERROR_MESSAGE);
                correoField.requestFocus();
                correoField.selectAll();
                correoField.setBackground(Color.RED);

            } else {

                showMessageDialog(InicioSesion.this, "CONTRASEÑA Y CORREO ERRONEOS", "NO PASAR", JOptionPane.ERROR_MESSAGE);
                contraseñaField.setBackground(Color.RED);
                correoField.setBackground(Color.RED);
                correoField.selectAll();
                correoField.requestFocus();

            }

        }

    }

}
