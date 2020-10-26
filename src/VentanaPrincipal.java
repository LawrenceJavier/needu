import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import static javax.swing.JOptionPane.showMessageDialog;

public class VentanaPrincipal extends JFrame{

    JPanel panelCentral = new JPanel();
    JPanel panelsur = new JPanel();
    JPanel panelNorte = new JPanel();
    CardLayout cardLayout1,cardLayout2;
    JTextField correoField;
    JPasswordField contraseñaField;

    public VentanaPrincipal(){

        super.setTitle("NeedU");
        this.setMaximumSize(new Dimension(300,500));
        this.setMinimumSize(new Dimension(300,500));

        panelNorte.setLayout(new CardLayout());
        panelCentral.setLayout(new CardLayout());

        cardLayout2 = (CardLayout) panelNorte.getLayout();
        cardLayout1 = (CardLayout) panelCentral.getLayout();

        panelsur.add(new JLabel("NeedU"));
        JLabel y = new JLabel("2020");
        panelsur.add(y);
        JLabel z = new JLabel("I.S.");
        panelsur.add(z);

        this.ventanaInicio();
        this.inicarSesion();
        this.resgistro();
        this.usuario();

        cardLayout1.show(panelCentral, "Inicio");
        cardLayout2.show(panelNorte, "Vacio");

        this.add(panelCentral,BorderLayout.CENTER);
        this.add(panelsur,BorderLayout.SOUTH);
        this.add(panelNorte,BorderLayout.NORTH);

        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

    }

    private void ventanaInicio() {

        JPanel pcentral = new JPanel();
        pcentral.setLayout(new BoxLayout(pcentral, BoxLayout.Y_AXIS));

        JPanel vacio = new JPanel();

        JPanel pcentral1 = new JPanel();
        pcentral1.setLayout(new BoxLayout(pcentral1, BoxLayout.X_AXIS));

        JButton inicio = new JButton("INICIAR SESION");
        inicio.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton registro = new JButton("REGISTRATE");
        registro.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel frase = new JLabel("EL TRABAJO TE BUSCA");
        frase.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel o=new JLabel(" ó ");
        o.setAlignmentX(Component.CENTER_ALIGNMENT);

        ImageIcon needu=new ImageIcon("resources"+File.separator+"logo2.jpeg");
        JLabel logo = new JLabel(needu);
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);

        pcentral.add(logo);
        pcentral.add(frase);
        pcentral1.add(inicio);
        pcentral1.add(o);
        pcentral1.add(registro);
        pcentral.add( new JLabel(" "));
        pcentral.add( new JLabel(" "));
        pcentral.add(pcentral1);

        pcentral.setBackground(new Color(201,16,16));
        pcentral1.setBackground(new Color(201,16,16));

        panelCentral.add(pcentral,"Inicio");

        panelNorte.add(vacio,"Vacio");

        inicio.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                cardLayout1.show(panelCentral, "Iniciar");
                cardLayout2.show(panelNorte,"Simple");
            }
        });

        registro.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                cardLayout1.show(panelCentral, "Registro");
                cardLayout2.show(panelNorte,"Simple");
            }
        });

    }

    private void resgistro() {

        JTextField txtNombre;
        JTextField txtApellidos;
        JTextField txtCorreoElectronico;
        JPasswordField txtContrasena;
        JPasswordField txtConfirmarContrasena;
        JLabel lblRegistrarse;
        JLabel lblNombre;
        JLabel lblApellidos;
        JLabel lblCorreoElectronico;
        JLabel lblContrasena;
        JLabel lblConfirmarContrasena;
        JButton btnRegistrarse;
        JPanel pnlCentral = new JPanel();

        pnlCentral.setLayout(new GridLayout(13,1));

        lblRegistrarse = new JLabel("REGISTRARSE");
        lblRegistrarse.setHorizontalAlignment(JLabel.CENTER);
        lblNombre = new JLabel("NOMBRE: ");
        lblNombre.setHorizontalAlignment(JLabel.CENTER);
        lblApellidos = new JLabel("APELLIDOS: ");
        lblApellidos.setHorizontalAlignment(JLabel.CENTER);
        lblCorreoElectronico = new JLabel("DIRECCION CORREO ELECTRONICO: ");
        lblCorreoElectronico.setHorizontalAlignment(JLabel.CENTER);
        lblContrasena = new JLabel("CONTRASENA: ");
        lblContrasena.setHorizontalAlignment(JLabel.CENTER);
        lblConfirmarContrasena = new JLabel("CONFIRMAR CONTRASENA: ");
        lblConfirmarContrasena.setHorizontalAlignment(JLabel.CENTER);
        JLabel lblVacio = new JLabel();

        txtNombre = new JTextField("NOMBRE");
        txtApellidos = new JTextField("APELLIDOS");
        txtCorreoElectronico = new JTextField("CORREO ELECTRONICO");
        txtContrasena = new JPasswordField();
        txtConfirmarContrasena = new JPasswordField();

        btnRegistrarse = new JButton("REGISTRARSE");

        btnRegistrarse.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                String nombre = txtNombre.getText();
                String apellidos = txtApellidos.getText();
                String correoElectronico = txtCorreoElectronico.getText();
                String contrasena = new String(txtContrasena.getPassword());
                String confirmarContrasena = new String(txtConfirmarContrasena.getPassword());

                if(contrasena.equals(confirmarContrasena)){
                    JOptionPane.showMessageDialog(VentanaPrincipal.this,"REGISTRADO CON EXITO");
                    cardLayout1.show(panelCentral, "Usuario");
                    cardLayout2.show(panelNorte,"Usuario");

                }else{
                    JOptionPane.showMessageDialog(VentanaPrincipal.this,"Contrasena y Confirmar Contrasena NO coinciden");

                }
            }
        });

        pnlCentral.add(lblRegistrarse);
        pnlCentral.add(lblNombre);
        pnlCentral.add(txtNombre);
        pnlCentral.add(lblApellidos);
        pnlCentral.add(txtApellidos);
        pnlCentral.add(lblCorreoElectronico);
        pnlCentral.add(txtCorreoElectronico);
        pnlCentral.add(lblContrasena);
        pnlCentral.add(txtContrasena);
        pnlCentral.add(lblConfirmarContrasena);
        pnlCentral.add(txtConfirmarContrasena);
        pnlCentral.add(btnRegistrarse);
        pnlCentral.add(lblVacio);

        panelCentral.add(pnlCentral,"Registro");

    }


    private void inicarSesion() {

        JPanel centroPanelRegistro = new JPanel();
        JPanel centroPanelOlvidar =  new JPanel();
        JPanel centroPanelOk = new JPanel();
        JPanel superiorPanel = new JPanel();

        centroPanelRegistro.setLayout(new GridLayout(10,1));
        centroPanelOlvidar.setLayout(new GridLayout(10,1));

        JTextField correoField = new JTextField();
        JPasswordField contraseñaField = new JPasswordField();

        JLabel iniciarSesionLabel = new JLabel("INICIAR SESION");
        iniciarSesionLabel.setHorizontalAlignment(JLabel.CENTER);

        JLabel correoLabel = new JLabel("CORREO ELECTRONICO");
        correoLabel.setHorizontalAlignment(JLabel.CENTER);

        JLabel contraseñaLabel = new JLabel("CONTRASENA");
        contraseñaLabel.setHorizontalAlignment(JLabel.CENTER);

        JLabel vacio1Label = new JLabel();
        JLabel vacio2Label = new JLabel();
        JLabel vacio3Label = new JLabel();
        JLabel vacio4Label = new JLabel();
        JLabel revisarLabel = new JLabel("REVISE SU CORREO ELECTRONICO");

        JButton entrarBoton = new JButton("ENTRAR");
        JButton olvidarContraseñaBoton = new JButton("OLVIDE MI CONTRASEÑA");
        JButton revisarBoton = new JButton("VOLVER");

        JLabel introLabel = new JLabel("INTRODUZCA CORREO ELECTRONICO");
        JTextField introText = new JTextField();
        JButton enviarBoton = new JButton("REESTABLECER CONTRASEÑA");

        ImageIcon logo = new ImageIcon("resources"+ File.separator+"logo.jpeg");
        JLabel logoLabel = new JLabel(logo);
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);


        revisarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cardLayout1.show(panelCentral, "Iniciar");
            }
        });

        enviarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cardLayout1.show(panelCentral, "Revisar");
            }
        });

        olvidarContraseñaBoton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                cardLayout1.show(panelCentral, "Olvidar");
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

        panelNorte.add(superiorPanel,"Simple");

        panelCentral.add(centroPanelRegistro,"Iniciar");
        panelCentral.add(centroPanelOlvidar,"Olvidar");
        panelCentral.add(centroPanelOk,"Revisar");

    }

    private void comprobarCorreoContraseña() {

        String correo = correoField.getText();
        String contraseña = new String(contraseñaField.getPassword());

        if (correo.equals("afernandezpacheco@icai.comillas.edu")) {

            if (contraseña.equals("camarada")) {

                showMessageDialog(VentanaPrincipal.this, "INICIO CORRECTO", "PASAR", JOptionPane.OK_OPTION);
                cardLayout1.show(panelCentral, "Usuario");
                cardLayout2.show(panelNorte,"Usuario");

            } else {

                showMessageDialog(VentanaPrincipal.this, "CONTRASEÑA ERRONEA", "NO PASAR", JOptionPane.ERROR_MESSAGE);
                contraseñaField.setBackground(Color.RED);
                contraseñaField.selectAll();
                contraseñaField.requestFocus();

            }

        } else {

            if (contraseña.equals("camarada")) {

                showMessageDialog(VentanaPrincipal.this, "CORREO NO ESTA EN BASE DE DATOS", "NO PASAR", JOptionPane.ERROR_MESSAGE);
                correoField.requestFocus();
                correoField.selectAll();
                correoField.setBackground(Color.RED);

            } else {

                showMessageDialog(VentanaPrincipal.this, "CONTRASEÑA Y CORREO ERRONEOS", "NO PASAR", JOptionPane.ERROR_MESSAGE);
                contraseñaField.setBackground(Color.RED);
                correoField.setBackground(Color.RED);
                correoField.selectAll();
                correoField.requestFocus();

            }

        }

    }

    private void usuario() {

        JPanel pnlCentral;
        JPanel pnlNorte;

        pnlCentral= new JPanel();

        ImageIcon iconoWalla= new ImageIcon("resources"+ File.separator+"wallapop.jpeg");
        JLabel etiqueta1 = new JLabel(iconoWalla);
        pnlCentral.add(etiqueta1);

        pnlCentral.setBackground(Color.WHITE);
        pnlCentral.setVisible(true);

        pnlNorte = new JPanel();
        pnlNorte.setLayout(new GridLayout(1,8));
        ImageIcon icono1= new ImageIcon("resources"+ File.separator+"logo.jpeg");
        JLabel etiqueta2 = new JLabel(icono1);
        pnlNorte.add(etiqueta2);

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

        panelNorte.add(pnlNorte,"Usuario");

        panelCentral.add(pnlCentral,"Usuario");

        configuracion();
        perfil();

        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });





    }

    private void perfil() {
    }

    private void configuracion() {
    }

}