package src.ui;

import javax.imageio.ImageIO;
import javax.swing.*;

import src.db.DataBase;
import src.domain.Anuncio;
import src.domain.Usuario;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

import static javax.swing.JOptionPane.showMessageDialog;

public class VentanaPrincipal extends JFrame{

    DataBase db = new DataBase();

    JPanel panelCentral = new JPanel();
    JPanel panelsur = new JPanel();
    JPanel panelNorte = new JPanel();
    CardLayout cardLayout1,cardLayout2;
    Anuncio anuncio1,anuncio2,anuncio3,anuncio4,anuncio11,anuncio111,anuncio1111,anuncio22,anuncio222,anuncio2222,anuncio121,anuncio212,anuncio112,anuncio221;
    Usuario user1,user2,user3,user4;
    ArrayList<Usuario> usuarios =new ArrayList<Usuario>();
    Usuario actual = new Usuario("","","","");

    public VentanaPrincipal(){

        super.setTitle("NeedU");
        this.setMaximumSize(new Dimension(300,500));
        this.setMinimumSize(new Dimension(300,500));

        crearUsuarios();
        crearAnuncios();

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

    private void crearAnuncios() {
        anuncio1 = new Anuncio(user1,"Arreglos de puertas de coche","Clara del rey 36",new ImageIcon("resources"+File.separator+"trabajo1.jpg"),120.5,"Trabajo","COCHE");
        user1.nuevoAnuncio(anuncio1);
        anuncio2 = new Anuncio(user1,"Busco persona que arregle circuitos de una casa","Padre damian 34", new ImageIcon("resources"+File.separator+"trabajo1.jpg"),0.0,"Anuncio","CIRCUITOS");
        user1.nuevoAnuncio(anuncio2);
        anuncio11 = new Anuncio(user1,"Arreglos de puertas de coche","Clara del rey 36",new ImageIcon("resources"+File.separator+"trabajo1.jpg"),120.5,"Trabajo","COCHE");
        user1.nuevoAnuncio(anuncio11);
        anuncio22 = new Anuncio(user1,"Busco persona que arregle circuitos de una casa","Padre damian 34", new ImageIcon("resources"+File.separator+"trabajo1.jpg"),0.0,"Anuncio","CIRCUITOS");
        user1.nuevoAnuncio(anuncio22);
        anuncio111 = new Anuncio(user1,"Arreglos de puertas de coche","Clara del rey 36",new ImageIcon("resources"+File.separator+"trabajo1.jpg"),120.5,"Trabajo","COCHE");
        user1.nuevoAnuncio(anuncio111);
        anuncio222 = new Anuncio(user1,"Busco persona que arregle circuitos de una casa","Padre damian 34", new ImageIcon("resources"+File.separator+"trabajo1.jpg"),0.0,"Anuncio","CIRCUITOS");
        user1.nuevoAnuncio(anuncio222);
        anuncio1111 = new Anuncio(user1,"Arreglos de puertas de coche","Clara del rey 36",new ImageIcon("resources"+File.separator+"trabajo1.jpg"),120.5,"Trabajo","COCHE");
        user1.nuevoAnuncio(anuncio1111);
        anuncio2222 = new Anuncio(user1,"Busco persona que arregle circuitos de una casa","Padre damian 34", new ImageIcon("resources"+File.separator+"trabajo1.jpg"),0.0,"Anuncio","CIRCUITOS");
        user1.nuevoAnuncio(anuncio2222);
        anuncio121 = new Anuncio(user1,"Arreglos de puertas de coche","Clara del rey 36",new ImageIcon("resources"+File.separator+"trabajo1.jpg"),120.5,"Trabajo","COCHE");
        user1.nuevoAnuncio(anuncio121);
        anuncio212 = new Anuncio(user1,"Busco persona que arregle circuitos de una casa","Padre damian 34", new ImageIcon("resources"+File.separator+"trabajo1.jpg"),0.0,"Anuncio","CIRCUITOS");
        user1.nuevoAnuncio(anuncio212);
        anuncio112 = new Anuncio(user1,"Arreglos de puertas de coche","Clara del rey 36",new ImageIcon("resources"+File.separator+"trabajo1.jpg"),120.5,"Trabajo","COCHE");
        user1.nuevoAnuncio(anuncio112);
        anuncio221 = new Anuncio(user1,"Busco persona que arregle circuitos de una casa","Padre damian 34", new ImageIcon("resources"+File.separator+"trabajo1.jpg"),0.0,"Anuncio","CIRCUITOS");
        user1.nuevoAnuncio(anuncio221);
        anuncio3 = new Anuncio(user2,"Arreglo cisternas","Concha espina 23",new ImageIcon("resources"+File.separator+"trabajo1.jpg"),null,"Trabajo","CISTERNAS");
        user2.nuevoAnuncio(anuncio3);
        anuncio4 = new Anuncio(user2,"Busco persona que arregle vitroceramicas","Silvano 32",new ImageIcon("resources"+File.separator+"trabajo1.jpg"),0.0,"Anuncio","VITROCERAMICAS");
        user2.nuevoAnuncio(anuncio4);
    }

    private void crearUsuarios() {

        user1 = new Usuario("Rafa","Martin Torre","rafa@gmail.com","rafa99");
        user2 = new Usuario("Lawrence","Minguillan Vankapel","lawrence@gmail.com","lawrence99");
        user3 = new Usuario("Alberto","Sanchez Bonastre","camacho@gmail.com","alber99");
        user4 = new Usuario("Camacho","Magdanela Camacho","alberto@gmail.com","camacho99");

        usuarios.add(user1);
        usuarios.add(user2);
        usuarios.add(user3);
        usuarios.add(user4);

    }

    private void ventanaInicio() {

        JPanel pcentral = new JPanel();
        pcentral.setLayout(new BoxLayout(pcentral, BoxLayout.Y_AXIS));

        JPanel vacio = new JPanel();

        JPanel pcentral1 = new JPanel();
        pcentral1.setLayout(new BoxLayout(pcentral1, BoxLayout.X_AXIS));

        JButton inicio = new JButton("INICIAR SESION");
        inicio.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton registro = new JButton("REGISTRARSE");
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
        JButton iniciarSesion = new JButton("INICIAR SESION");
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

        txtNombre = new JTextField();
        txtApellidos = new JTextField();
        txtCorreoElectronico = new JTextField();
        txtContrasena = new JPasswordField();
        txtConfirmarContrasena = new JPasswordField();

        btnRegistrarse = new JButton("REGISTRARSE");

        btnRegistrarse.addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent e){
                    int aux = 0;
                    String nombre = txtNombre.getText();
                    String apellidos = txtApellidos.getText();
                    String correoElectronico = txtCorreoElectronico.getText();
                    String contrasena = new String(txtContrasena.getPassword());
                    String confirmarContrasena = new String(txtConfirmarContrasena.getPassword());
                    System.out.println(confirmarContrasena);
                    Usuario usuario;

                    if(nombre.equals("")){
                        JOptionPane.showMessageDialog(VentanaPrincipal.this,"NOMBRE VACIO");
                        txtNombre.setBackground(Color.RED);
                        txtNombre.selectAll();
                        txtNombre.requestFocus();
                        aux = 1;

                    }

                    if(apellidos.equals("")){
                        JOptionPane.showMessageDialog(VentanaPrincipal.this,"APELLLIDOS VACIO");
                        txtApellidos.setBackground(Color.RED);
                        txtApellidos.selectAll();
                        txtApellidos.requestFocus();
                        aux = 1;
                    }

                    if(correoElectronico.equals("")){
                        JOptionPane.showMessageDialog(VentanaPrincipal.this,"CORREO ELECTRONICO VACIO");
                        txtCorreoElectronico.setBackground(Color.RED);
                        txtCorreoElectronico.selectAll();
                        txtCorreoElectronico.requestFocus();
                        aux = 1;
                    }else if(correoElectronico.contains("@")==false && correoElectronico.contains(".com") == false){
                        JOptionPane.showMessageDialog(VentanaPrincipal.this,"CORREO ELECTRONICO VACIO");
                        txtCorreoElectronico.setBackground(Color.RED);
                        txtCorreoElectronico.selectAll();
                        txtCorreoElectronico.requestFocus();
                        aux = 1;
                    }

                    if(contrasena.equals("")){
                        JOptionPane.showMessageDialog(VentanaPrincipal.this,"CONTRASEÑA VACIA");
                        txtContrasena.setBackground(Color.RED);
                        txtContrasena.selectAll();
                        txtContrasena.requestFocus();
                        aux = 1;
                    }

                    if(confirmarContrasena.equals("")){
                        JOptionPane.showMessageDialog(VentanaPrincipal.this,"CONTRASEÑA CONFIRMADA VACIA");
                        txtConfirmarContrasena.setBackground(Color.RED);
                        txtConfirmarContrasena.selectAll();
                        txtConfirmarContrasena.requestFocus();
                        aux = 1;
                    }

                    if(confirmarContrasena.equals("") == false && contrasena.equals("") == false) {

                        //comprobar correo electronico no existe en la base de datos y si no existe hacer lo siguiente, si existe warning correo existente y no hace lo siguiente

                        if (contrasena.equals(confirmarContrasena) && contrasena.equals("") == false) {
                            if (aux == 1) {
                                JOptionPane.showMessageDialog(VentanaPrincipal.this, "RELLENE TODOS LOS CAMPOS");
                            } else {
                                usuario = new Usuario(nombre, apellidos, correoElectronico, contrasena);
                                actual = usuario;

                                Boolean aceptar = db.anadirUsuario(correoElectronico, contrasena, nombre, apellidos);

                                //añadir usuario a la base de datos
                                if(aceptar == true){
                                    cardLayout1.show(panelCentral, "Usuario");
                                    cardLayout2.show(panelNorte, "Usuario");
                                    txtApellidos.setText("");
                                    txtCorreoElectronico.setText("");
                                    txtContrasena.setText("");
                                    txtConfirmarContrasena.setText("");
                                    txtNombre.setText("");
                                    txtContrasena.setBackground(Color.WHITE);
                                    txtApellidos.setBackground(Color.WHITE);
                                    txtConfirmarContrasena.setBackground(Color.WHITE);
                                    txtCorreoElectronico.setBackground(Color.WHITE);
                                    txtNombre.setBackground(Color.WHITE);
                                }
                            }

                        } else {
                            JOptionPane.showMessageDialog(VentanaPrincipal.this, "LAS CONTRASEÑAS NO COINCIDEN");
                            txtContrasena.setBackground(Color.RED);
                            txtContrasena.selectAll();
                            txtContrasena.requestFocus();
                            txtConfirmarContrasena.setBackground(Color.RED);

                        }
                    }

                }
        });

        txtNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped (KeyEvent e){
                String textoNombre = txtNombre.getText();

                if (textoNombre.equals("")) {

                    txtNombre.setBackground(Color.WHITE);

                }
            }
        });

        txtApellidos.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped (KeyEvent e){
                String textoApellidos = txtApellidos.getText();

                if (textoApellidos.equals("")) {

                    txtApellidos.setBackground(Color.WHITE);

                }
            }
        });

        txtCorreoElectronico.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped (KeyEvent e){
                String textoCorreo = txtCorreoElectronico.getText();

                if (textoCorreo.equals("")) {

                    txtCorreoElectronico.setBackground(Color.WHITE);

                }
            }
        });

        txtContrasena.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped (KeyEvent e){
                String textoContrasena = new String(txtContrasena.getPassword());

                if (textoContrasena.equals("")) {

                    txtContrasena.setBackground(Color.WHITE);

                }
            }
        });

        txtConfirmarContrasena.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped (KeyEvent e){
                String textoContrasenaConf = new String(txtConfirmarContrasena.getPassword());

                if (textoContrasenaConf.equals("")) {

                    txtConfirmarContrasena.setBackground(Color.WHITE);

                }
            }
        });

        iniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout1.show(panelCentral,"Iniciar");
                txtApellidos.setText("");
                txtCorreoElectronico.setText("");
                txtContrasena.setText("");
                txtConfirmarContrasena.setText("");
                txtNombre.setText("");
                txtContrasena.setBackground(Color.WHITE);
                txtApellidos.setBackground(Color.WHITE);
                txtConfirmarContrasena.setBackground(Color.WHITE);
                txtCorreoElectronico.setBackground(Color.WHITE);
                txtNombre.setBackground(Color.WHITE);

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
        pnlCentral.add(iniciarSesion);

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
        JLabel vacio4Label = new JLabel();
        JLabel revisarLabel = new JLabel("REVISE SU CORREO ELECTRONICO");

        JButton entrarBoton = new JButton("ENTRAR");
        JButton olvidarContraseñaBoton = new JButton("OLVIDE MI CONTRASEÑA");
        JButton revisarBoton = new JButton("VOLVER");
        JButton registrarse = new JButton("REGISTRASE");

        JLabel introLabel = new JLabel("INTRODUZCA CORREO ELECTRONICO");
        JTextField introText = new JTextField();
        JButton enviarBoton = new JButton("REESTABLECER CONTRASEÑA");

        ImageIcon logo = new ImageIcon("resources"+ File.separator+"logo.jpeg");
        JLabel logoLabel = new JLabel(logo);
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        registrarse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout1.show(panelCentral,"Registro");
                correoField.setText("");
                contraseñaField.setText("");
                correoField.setBackground(Color.WHITE);
                contraseñaField.setBackground(Color.WHITE);
            }
        });

        revisarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cardLayout1.show(panelCentral, "Iniciar");
            }
        });

        enviarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                comprobarCorreo(introText);

            }
        });

        olvidarContraseñaBoton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                cardLayout1.show(panelCentral, "Olvidar");
                correoField.setText("");
                contraseñaField.setText("");
                correoField.setBackground(Color.WHITE);
                contraseñaField.setBackground(Color.WHITE);
            }

        });

        entrarBoton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                comprobarCorreoContraseña(correoField,contraseñaField);

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

        introText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String textoContraseña = introText.getText();

                if(textoContraseña.equals("")){

                    introText.setBackground(Color.WHITE);

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
        centroPanelRegistro.add(registrarse);

        JButton atras = new JButton("ATRAS");

        atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout1.show(panelCentral, "Iniciar");
                introText.setText("");
            }
        });

        JPanel panelAtras = new JPanel();
        panelAtras.setLayout(new GridLayout(1,3));
        panelAtras.add(atras);
        panelAtras.add(new JLabel());
        panelAtras.add(new JLabel());

        centroPanelOlvidar.add(vacio4Label);
        centroPanelOlvidar.add(vacio4Label);
        centroPanelOlvidar.add(vacio4Label);
        centroPanelOlvidar.add(introLabel);
        centroPanelOlvidar.add(introText);
        centroPanelOlvidar.add(vacio4Label);
        centroPanelOlvidar.add(enviarBoton);
        centroPanelOlvidar.add(vacio4Label);
        centroPanelOlvidar.add(vacio4Label);
        centroPanelOlvidar.add(panelAtras);

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

    private void comprobarCorreo(JTextField introText) {

        String correo = introText.getText();

        //Comprobar que el correo existe en la base de datos
        Boolean comp = db.validarCorreo(correo);
        System.out.println(comp);

        if(comp){
            cardLayout1.show(panelCentral, "Revisar");
            introText.setText("");
            introText.setBackground(Color.WHITE);
        }else{
            showMessageDialog(VentanaPrincipal.this, "EL CORREO NO ESTA EN LA BASE DE DATOS");
            introText.setBackground(Color.RED);
            introText.selectAll();
            introText.requestFocus();

        }

    }

    private void comprobarCorreoContraseña(JTextField correoField,JPasswordField contraseñaField) {

        String correo = correoField.getText();
        String contraseña = new String(contraseñaField.getPassword());

        //Comprobar que existe un usuario con estos datos en la base de datos

        
        
        Boolean comp = db.validarClave(correo, contraseña);
        if(comp){
            showMessageDialog(VentanaPrincipal.this, "INICIO CORRECTO", "PASAR", JOptionPane.OK_OPTION);
            cardLayout1.show(panelCentral, "Usuario");
            cardLayout2.show(panelNorte,"Usuario");
            //sacar info de base de datos para el usuario
            correoField.setText("");
            contraseñaField.setText("");
            correoField.setBackground(Color.WHITE);
            contraseñaField.setBackground(Color.WHITE);
            actual=db.getInfo(correo, contraseña);

        }else{
            showMessageDialog(VentanaPrincipal.this, "CONTRASEÑA o CORREO ERRONEOS", "NO PASAR", JOptionPane.ERROR_MESSAGE);
            contraseñaField.setBackground(Color.RED);
            correoField.setBackground(Color.RED);
            correoField.selectAll();
            correoField.requestFocus();
        }
    }

    private void usuario() {

        JPanel pnlCentral;
        JPanel pnlNorte;

        pnlCentral= new JPanel();

        ImageIcon iconoWalla= new ImageIcon("resources"+ File.separator+"wallapop.jpeg");
        JLabel etiqueta1 = new JLabel(iconoWalla);
        pnlCentral.add(etiqueta1);

        pnlNorte = new JPanel();
        pnlNorte.setLayout(new GridLayout(1,6));
        ImageIcon icono1= new ImageIcon("resources"+ File.separator+"logo.jpeg");
        JLabel etiqueta2 = new JLabel(icono1);
        pnlNorte.add(etiqueta2);

        JComboBox tipoAnuncio = new JComboBox();
        tipoAnuncio.addItem("Anuncios");
        tipoAnuncio.addItem("Trabajos");

        tipoAnuncio.setRenderer(new DefaultListCellRenderer() {
            @Override
            public void paint(Graphics g) {
                setBackground(Color.BLACK);
                setForeground(Color.WHITE);
                super.paint(g);
            }
        });

        pnlNorte.add(tipoAnuncio);

        pnlNorte.setBackground(Color.BLACK);

        JTextField buscarTextfield = new JTextField("Bucar");
        ImageIcon iconoLupa= new ImageIcon("resources"+ File.separator+"lupa.png");
        JButton botonBuscar = new JButton(iconoLupa);
        botonBuscar.setBackground(Color.BLACK);

        pnlNorte.add(buscarTextfield);
        pnlNorte.add(botonBuscar);

        ImageIcon iconoPerfil= actual.getIcono();
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

                String tipoDeAnuncio = "";

                int selec = tipoAnuncio.getSelectedIndex();
                if (selec == 0){
                    tipoDeAnuncio = "Anuncio";
                }else if(selec == 1){
                    tipoDeAnuncio = "Trabajo";
                }

                String desc = buscarTextfield.getText();

                if(desc.equals("")){
                    showMessageDialog(VentanaPrincipal.this, "BUSQUEDA VACIA", "ERROR", JOptionPane.ERROR_MESSAGE);
                }else{
                    //Buscar en la base de dates anuncios del tipo anuncio o trabajo que contengan en la descripcion el string desc
                    //Mostrar los anuncios que se han sacado de la base de datos

                    ArrayList<Anuncio> encontrados = new ArrayList<Anuncio>();

                    Iterator it = usuarios.iterator();
                    while(it.hasNext()) {
                        Object o = it.next();
                        Usuario user = (Usuario) o;

                        Iterator it2 = user.getAnuncios().iterator();
                        while(it2.hasNext()) {
                            Object o2 = it2.next();
                            Anuncio anuncioAux = (Anuncio) o2;

                            if(anuncioAux.getTipo().equals(tipoDeAnuncio)) {

                                if (anuncioAux.getDescripcion().contains(desc)) {
                                    encontrados.add(anuncioAux);
                                }
                            }
                        }
                    }

                    mostrarAnunciosPrincipal(encontrados);

                }

            }
        });

        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cardLayout1.show(panelCentral, "ConfUser");

            }
        });

        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cardLayout1.show(panelCentral, "Conf");

            }
        });

    }

    private void mostrarAnunciosPrincipal(ArrayList<Anuncio> encontrados) {

        Iterator it3 = encontrados.iterator();
        while(it3.hasNext()){
            Object o3 = it3.next();
            Anuncio anunEnc = (Anuncio) o3;

        }

    }

    private void perfil() {

        JPanel panelCentralPerfil = new JPanel();
        JPanel panelaux = new JPanel();
        JButton botonInfoBasica,botonInfoPrivada,botonFotoPerfil,botonAnunciosPublicados,botonAtras,botonPerfil;
        panelCentralPerfil.setLayout(new GridLayout(5,1));
        panelaux.setLayout(new GridLayout(1,3));

        botonAnunciosPublicados = new JButton("Ver Anuncios Publicados");
        botonInfoBasica = new JButton("Informacion Basica");
        botonInfoPrivada = new JButton("Informacion Privada");
        botonFotoPerfil = new JButton("Foto de perfil");
        botonAtras = new JButton("Atras");

        botonAnunciosPublicados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarAnuncios();
                cardLayout1.show(panelCentral, "Anuncios");
            }
        });

        botonAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cardLayout1.show(panelCentral, "Usuario");

            }
        });

        botonFotoPerfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fotoPerfil();
                cardLayout1.show(panelCentral,"MostrarFoto");
            }
        });

        botonInfoBasica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoBasica();
                cardLayout1.show(panelCentral,"InfoBasica");
            }
        });

        botonInfoPrivada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoPrivada();
                cardLayout1.show(panelCentral,"InfoPrivada");
            }
        });

        panelCentralPerfil.add(botonInfoBasica);
        panelCentralPerfil.add(botonInfoPrivada);
        panelCentralPerfil.add(botonFotoPerfil);
        panelCentralPerfil.add(botonAnunciosPublicados);

        panelaux.add(botonAtras);
        panelaux.add(new JLabel());
        panelaux.add(new JLabel());
        panelCentralPerfil.add(panelaux);

        panelCentral.add(panelCentralPerfil,"ConfUser");

    }

    private void infoPrivada() {

        JPanel panelCen = new JPanel();
        panelCen.setLayout(new GridLayout(12,1));
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1,3));
        JPanel panelBotones2 = new JPanel();
        panelBotones2.setLayout(new GridLayout(1,3));

        JButton editar = new JButton("EDITAR");
        JButton guardar = new JButton("GUARDAR");
        JButton atras = new JButton("ATRAS");
        JButton cambiarPassword = new JButton("CAMBIAR CONTRASEÑA");

        passwordPanel();

        JLabel dni = new JLabel("DNI");
        JLabel direccion = new JLabel("DIRECCION");
        JLabel sexo = new JLabel("SEXO");
        JLabel telefono = new JLabel("TELEFONO");

        JTextField dniText = new JTextField();
        JTextField direccionText = new JTextField();
        JComboBox sexoText = new JComboBox();
        sexoText.addItem("MASCULINO");
        sexoText.addItem("FEMENINO");
        JTextField telefonoText = new JTextField();

        dniText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String textoContraseña = dniText.getText();

                if(textoContraseña.equals("")){

                    dniText.setBackground(Color.WHITE);

                }
            }
        });

        direccionText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String textoContraseña = direccionText.getText();

                if(textoContraseña.equals("")){

                    direccionText.setBackground(Color.WHITE);

                }
            }
        });

        telefonoText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String textoContraseña = telefonoText.getText();

                if(textoContraseña.equals("")){

                    telefonoText.setBackground(Color.WHITE);

                }
            }
        });

        dniText.setEnabled(false);
        direccionText.setEnabled(false);
        sexoText.setEnabled(false);
        telefonoText.setEnabled(false);

        //sacar info basica del usuario y meterla en los textfields

        dniText.setText(actual.getDni()); //dni del usuario iria
        direccionText.setText(actual.getDireccion()); //direccion del usuario iria
        telefonoText.setText(actual.getTelefono());

        atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout1.show(panelCentral,"ConfUser");
            }
        });

        editar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dniText.setEnabled(true);
                direccionText.setEnabled(true);
                sexoText.setEnabled(true);
                telefonoText.setEnabled(true);
            }
        });

        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comprobarCambios2(dniText,direccionText,sexoText,telefonoText);
            }
        });

        cambiarPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout1.show(panelCentral,"Password");
            }
        });

        panelBotones.add(atras);
        panelBotones.add(editar);
        panelBotones.add(guardar);

        panelBotones2.add(new JLabel());
        panelBotones2.add(cambiarPassword);
        panelBotones2.add(new JLabel());

        panelCen.add(dni);
        panelCen.add(dniText);
        panelCen.add(direccion);
        panelCen.add(direccionText);
        panelCen.add(sexo);
        panelCen.add(sexoText);
        panelCen.add(telefono);
        panelCen.add(telefonoText);
        panelCen.add(new JLabel());
        panelCen.add(panelBotones2);
        panelCen.add(new JLabel());
        panelCen.add(panelBotones);

        panelCentral.add(panelCen,"InfoPrivada");

    }

    private void passwordPanel() {

        JPanel panelCen = new JPanel();
        panelCen.setLayout(new GridLayout(9,1));

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1,2));

        JTextField actu = new JTextField("");
        JTextField nueva = new JTextField("");
        JTextField conf = new JTextField("");

        actu.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String textoContraseña = actu.getText();

                if(textoContraseña.equals("")){

                    actu.setBackground(Color.WHITE);

                }
            }
        });

        nueva.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String textoContraseña = nueva.getText();

                if(textoContraseña.equals("")){

                    nueva.setBackground(Color.WHITE);

                }
            }
        });

        conf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String textoContraseña = conf.getText();

                if(textoContraseña.equals("")){

                    conf.setBackground(Color.WHITE);

                }
            }
        });

        JLabel actualLbl = new JLabel("CONTRASEÑA ACTUAL");
        JLabel nuevaLbl = new JLabel("CONTRASEÑA NUEVA");
        JLabel confLbl = new JLabel("CONFIRME CONTRASEÑA");

        JButton guardar = new JButton("GUARDAR");
        JButton atras = new JButton("ATRAS");

        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comprobarContraseñas(actu,nueva,conf);
            }
        });

        atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout1.show(panelCentral,"InfoPrivada");
            }
        });

        panelBotones.add(atras);
        panelBotones.add(new JLabel());
        panelBotones.add(guardar);

        panelCen.add(actualLbl);
        panelCen.add(actu);
        panelCen.add(nuevaLbl);
        panelCen.add(nueva);
        panelCen.add(confLbl);
        panelCen.add(conf);
        panelCen.add(new JLabel());
        panelCen.add(new JLabel());
        panelCen.add(panelBotones);

        panelCentral.add(panelCen,"Password");

    }

    private void comprobarContraseñas(JTextField actu, JTextField nueva, JTextField conf) {

        if(actu.getText().equals(actual.getContraseña())){
            if(nueva.getText().equals(conf.getText()) && nueva.getText().equals("") == false && conf.equals("") == false){
                actual.setContraseña(nueva.getText());
                cardLayout1.show(panelCentral,"InfoPrivada");
                nueva.setBackground(Color.WHITE);
                conf.setBackground(Color.WHITE);
                actu.setBackground(Color.WHITE);
                nueva.setText("");
                conf.setText("");
                actu.setText("");
            }else{
                showMessageDialog(VentanaPrincipal.this, "CONTRASEÑAS ERRONEAS", "ERROR", JOptionPane.ERROR_MESSAGE);
                nueva.setBackground(Color.RED);
                conf.setBackground(Color.RED);
            }
        }else{
            showMessageDialog(VentanaPrincipal.this, "CONRASEÑA ACTUAL ERRONEA", "ERROR", JOptionPane.ERROR_MESSAGE);
            actu.setBackground(Color.RED);
        }

    }

    private void comprobarCambios2(JTextField dniText, JTextField direccionText, JComboBox sexoText, JTextField telefonoText) {

        int aux = 0;

        //Despues de hacer comprobaciones si es cprrecto
        if(dniText.getText().equals("")){
            showMessageDialog(VentanaPrincipal.this, "DNI VACIO", "ERROR", JOptionPane.ERROR_MESSAGE);
            aux = aux +1;
            dniText.setBackground(Color.RED);
        }else if(dniText.getText().length()<9){
            showMessageDialog(VentanaPrincipal.this, "DNI INCORRECTO", "ERROR", JOptionPane.ERROR_MESSAGE);
            dniText.setBackground(Color.RED);
        }

        if(direccionText.getText().equals("")){
            showMessageDialog(VentanaPrincipal.this, "DIRECCION VACIA", "ERROR", JOptionPane.ERROR_MESSAGE);
            aux = aux +1;
            direccionText.setBackground(Color.RED);
        }

        if(telefonoText.getText().equals("")){
            showMessageDialog(VentanaPrincipal.this, "TELEFONO VACIO", "ERROR", JOptionPane.ERROR_MESSAGE);
            aux = aux +1;
            telefonoText.setBackground(Color.RED);
        }else if(telefonoText.getText().length()<9){
            showMessageDialog(VentanaPrincipal.this, "TELEFONO INCORRECTO", "ERROR", JOptionPane.ERROR_MESSAGE);
            aux = aux +1;
            telefonoText.setBackground(Color.RED);

        }

        if(aux == 0){
            actual.setDni(dniText.getText());
            actual.setDireccion(direccionText.getText());
            String sexo;
            if(sexoText.getSelectedIndex() == 0){
                sexo = "Masculino";
            }else{
                sexo = "Femenino";
            }
            actual.setSexo(sexo);
            actual.setTelefono(telefonoText.getText());

            db.actualizarPrivado(actual.getCorreo(),dniText.getText(), direccionText.getText(),sexo,telefonoText.getText());

            dniText.setEnabled(false);
            direccionText.setEnabled(false);
            sexoText.setEnabled(false);
            telefonoText.setEnabled(false);
            dniText.setBackground(Color.WHITE);
            direccionText.setBackground(Color.WHITE);
            sexoText.setBackground(Color.WHITE);
            telefonoText.setBackground(Color.WHITE);
        }

        
    }

    private void infoBasica() {

        JPanel panelCen = new JPanel();
        panelCen.setLayout(new GridLayout(11,1));
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1,3));

        JButton editar = new JButton("EDITAR");
        JButton guardar = new JButton("GUARDAR");
        JButton atras = new JButton("ATRAS");

        JLabel nombre = new JLabel("NOMBRE");
        JLabel apellidos = new JLabel("APELLIDOS");
        JLabel fechaNac = new JLabel("FECHA DE NACIMIENTO");
        JLabel correo = new JLabel("CORREO ELECTRONICO");

        JTextField nombreText = new JTextField();
        JTextField apellidosText = new JTextField();
        JTextField fechaNacText = new JTextField("dd/mm/aaaa");
        JTextField correoTxt = new JTextField();

        nombreText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String textoContraseña = nombreText.getText();

                if(textoContraseña.equals("")){

                    nombreText.setBackground(Color.WHITE);

                }
            }
        });

        apellidosText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String textoContraseña = apellidosText.getText();

                if(textoContraseña.equals("")){

                    apellidosText.setBackground(Color.WHITE);

                }
            }
        });

        fechaNacText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String textoContraseña = fechaNacText.getText();

                if(textoContraseña.equals("")){

                    fechaNacText.setBackground(Color.WHITE);

                }
            }
        });

        correoTxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String textoContraseña = correoTxt.getText();

                if(textoContraseña.equals("")){

                    correoTxt.setBackground(Color.WHITE);

                }
            }
        });

        nombreText.setEnabled(false);
        apellidosText.setEnabled(false);
        fechaNacText.setEnabled(false);
        correoTxt.setEnabled(false);

        //sacar info basica del usuario y meterla en los textfields
        //hola
        
        System.out.println(actual.getNombre());
        nombreText.setText(actual.getNombre()); //nombre del usuario iria
        apellidosText.setText(actual.getApellidos()); //apellidos del usuario iria
        if(actual.getFecha().equals("")){
            fechaNacText.setText("dd/mm/aaaa");
        }else{
            fechaNacText.setText(actual.getFecha());
        }
        correoTxt.setText(actual.getCorreo());

        atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout1.show(panelCentral,"ConfUser");
            }
        });

        editar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombreText.setEnabled(true);
                apellidosText.setEnabled(true);
                fechaNacText.setEnabled(true);
                correoTxt.setEnabled(true);
            }
        });

        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comprobarCambios(nombreText,apellidosText,fechaNacText,correoTxt);
            }
        });

        panelBotones.add(atras);
        panelBotones.add(editar);
        panelBotones.add(guardar);

        panelCen.add(nombre);
        panelCen.add(nombreText);
        panelCen.add(apellidos);
        panelCen.add(apellidosText);
        panelCen.add(fechaNac);
        panelCen.add(fechaNacText);
        panelCen.add(correo);
        panelCen.add(correoTxt);
        panelCen.add(new JLabel());
        panelCen.add(new JLabel());
        panelCen.add(panelBotones);

        panelCentral.add(panelCen,"InfoBasica");


    }

    private void comprobarCambios(JTextField nombreText, JTextField apellidosText, JTextField fechaNacText,JTextField correoText) {

        String nombre = nombreText.getText();
        String apellidos = apellidosText.getText();
        String fecha = fechaNacText.getText();
        String correo = correoText.getText();
        int aux = 0;


        //Comprobacion textfields vacios
        if(nombre.equals("")){
            showMessageDialog(VentanaPrincipal.this, "NOMBRE VACIO", "ERROR", JOptionPane.ERROR_MESSAGE);
            aux = aux +1;
            nombreText.setBackground(Color.RED);
        }

        if(apellidos.equals("")){
            showMessageDialog(VentanaPrincipal.this, "APELLIDOS VACIOS", "ERROR", JOptionPane.ERROR_MESSAGE);
            aux = aux +1;
            apellidosText.setBackground(Color.RED);
        }

        if(fecha.equals("")){
            showMessageDialog(VentanaPrincipal.this, "FECHA VACIA", "ERROR", JOptionPane.ERROR_MESSAGE);
            aux = aux +1;
            fechaNacText.setBackground(Color.RED);
        }

        if(correo.equals("")){
            showMessageDialog(VentanaPrincipal.this, "CORREO VACIO", "ERROR", JOptionPane.ERROR_MESSAGE);
            aux = aux +1;
            correoText.setBackground(Color.RED);

        }else if(correo.contains("@") && correo.contains(".com")){
                aux = aux + 0;
        }else{
                aux = aux +1;
                showMessageDialog(VentanaPrincipal.this, "CORREO INCORRECTO", "ERROR", JOptionPane.ERROR_MESSAGE);
                correoText.setBackground(Color.RED);
        }


        if(aux == 0){
            db.actualizarBasico(actual.getCorreo(), nombre, apellidos, fecha, correo);
            //No hay nada mal por lo que se guarda el usuario en la base de datos
            actual.setNombre(nombre);
            actual.setApellidos(apellidos);
            actual.setCorreoElec(correo);
            actual.setFechaNac(fecha);
            nombreText.setEnabled(false);
            apellidosText.setEnabled(false);
            fechaNacText.setEnabled(false);
            correoText.setEnabled(false);
            nombreText.setBackground(Color.WHITE);
            apellidosText.setBackground(Color.WHITE);
            fechaNacText.setBackground(Color.WHITE);
            correoText.setBackground(Color.WHITE);

        }

    }

    private void fotoPerfil() {

        JPanel panelFoto = new JPanel();
        panelFoto.setLayout(new GridLayout(4,3));

        JButton cambiar = new JButton("CAMBIAR FOTO");
        JButton eliminar = new JButton("ELIMINAR FOTO");
        JButton atras = new JButton("ATRAS");
        JLabel foto = new JLabel(actual.getIcono());

        eliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon imagen = new ImageIcon("resources"+ File.separator+"perfil.jpeg");
                actual.setFoto(imagen);
                cardLayout1.show(panelCentral, "ConfUser");

            }
        });

        cambiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser selec = new JFileChooser();
                selec.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                int res = selec.showOpenDialog(panelCentral);
                File archivo = selec.getSelectedFile();

                if((archivo == null)){
                    JOptionPane.showMessageDialog(panelCentral,"NOMBRE ARCHIVO INVALIDO","NOMBRE ARCHIVO INVALIDO",JOptionPane.ERROR_MESSAGE);

                }else{
                    ImageIcon imagen = new ImageIcon(archivo.getPath());
                    actual.setFoto(imagen);
                }

                cardLayout1.show(panelCentral, "ConfUser");

            }
        });

        atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout1.show(panelCentral, "ConfUser");
            }
        });

        panelFoto.add(new JLabel());
        panelFoto.add(foto);
        panelFoto.add(new JLabel());
        panelFoto.add(cambiar);
        panelFoto.add(new JLabel());
        panelFoto.add(eliminar);
        panelFoto.add(atras);
        panelFoto.add(new JLabel());
        panelFoto.add(new JLabel());

        panelCentral.add(panelFoto,"MostrarFoto");

    }

    private void mostrarAnuncios() {

        ArrayList<Anuncio> anunciosuser = actual.getAnuncios();

        JPanel panelAnuncios = new JPanel();
        panelAnuncios.setLayout(new BoxLayout(panelAnuncios,BoxLayout.Y_AXIS));
        JScrollPane panelScr = new JScrollPane();


        Iterator it2 = anunciosuser.iterator();
        while(it2.hasNext()){
            Object o2 = it2.next(); 
            Anuncio anuncio = (Anuncio) o2;
            JPanel panel = crearForma(anuncio);
            panelAnuncios.add(panel);
        }


        panelAnuncios.add(panelScr);
        panelCentral.add(panelAnuncios,"Anuncios");

    }

    private JPanel crearForma(Anuncio anuncio) {

        JPanel panelForma = new JPanel();
        JButton editar = new JButton("EDITAR ANUNCIO");
        panelForma.setLayout(new GridBagLayout());
        JLabel titulo = new JLabel(anuncio.getTitulo());
        JLabel precio = new JLabel(anuncio.getPrecio());
        JLabel puntuacion = new JLabel(anuncio.getPuntuacion());
        ImageIcon iconoImagen = anuncio.getImage();
        JLabel labelFoto = new JLabel(iconoImagen);

        editar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarInfoAnuncio(anuncio);
                cardLayout1.show(panelCentral,"EditAnuncio");
            }
        });

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridwidth = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;

        constraints.gridx = 0;
        constraints.gridy = 0;
        panelForma.add(labelFoto,constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        panelForma.add(titulo,constraints);

        constraints.gridx = 3;
        constraints.gridy = 0;
        panelForma.add(precio,constraints);

        constraints.gridx = 4;
        constraints.gridy = 0;

        panelForma.add(puntuacion,constraints);

        constraints.gridx = 5;
        constraints.gridy = 0;
        panelForma.add(editar,constraints);

        return panelForma;

    }

    private void cambiarInfoAnuncio(Anuncio anuncio) {

        JPanel panelChange = new JPanel();
        panelChange.setLayout(new GridBagLayout());

        JLabel descr = new JLabel("DESCRIPCION");
        JLabel dir = new JLabel("DIRECCION");
        JLabel imag = new JLabel("IMAGEN");
        JLabel precioAn = new JLabel("PRECIO");
        JLabel tit = new JLabel("TITULO");
        JLabel tipoAn = new JLabel("TIPO");
        ImageIcon imagenAuc = anuncio.getImage();

        JButton guardar = new JButton("GUARDAR CAMBIOS");

        JTextField direccion = new JTextField(anuncio.getDir());
        JTextArea desc = new JTextArea(anuncio.getDescripcion());

        JLabel foto = new JLabel(anuncio.getImage());
        JButton cambiar = new JButton("CAMBIAR FOTO");
        JTextField precio = new JTextField(anuncio.getPrecio());
        JTextField titulo = new JTextField(anuncio.getTitulo());
        JComboBox tipo = new JComboBox();
        tipo.addItem("Anuncio");
        tipo.addItem("Trabajo");

        direccion.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String textoContraseña = direccion.getText();

                if(textoContraseña.equals("")){

                    direccion.setBackground(Color.WHITE);

                }
            }
        });

        desc.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String textoContraseña = desc.getText();

                if(textoContraseña.equals("")){

                    desc.setBackground(Color.WHITE);

                }
            }
        });

        precio.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String textoContraseña = precio.getText();

                if(textoContraseña.equals("")){

                    precio.setBackground(Color.WHITE);

                }
            }
        });

        titulo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String textoContraseña = titulo.getText();

                if(textoContraseña.equals("")){

                    titulo.setBackground(Color.WHITE);

                }
            }
        });



        cambiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser select = new JFileChooser();
                select.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                int res = select.showOpenDialog(panelCentral);
                File archivoo = select.getSelectedFile();

                if((archivoo == null)){
                    JOptionPane.showMessageDialog(panelCentral,"NOMBRE ARCHIVO INVALIDO","NOMBRE ARCHIVO INVALIDO",JOptionPane.ERROR_MESSAGE);

                }else{
                    ImageIcon imagen = new ImageIcon(archivoo.getPath());
                    anuncio.setFoto(imagen);
                    JOptionPane.showMessageDialog(panelCentral,"FOTO CAMBIADA","OK",JOptionPane.ERROR_MESSAGE);

                }

            }

        });

        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String auxdir = direccion.getText();
                String auxdesc = desc.getText();
                Double prec = Double.parseDouble(precio.getText());

                int error = 0;

                String auxtit = titulo.getText();
                String auxtipo="";
                int aux = tipo.getSelectedIndex();

                if(aux == 0){
                    auxtipo = "Anuncio";

                    if(auxdir.equals("")){

                        direccion.setBackground(Color.RED);
                        showMessageDialog(VentanaPrincipal.this, "DIRECCION VACIA", "ERROR", JOptionPane.ERROR_MESSAGE);
                        error = error+1;
                    }

                    if(auxdesc.equals("")){

                        desc.setBackground(Color.RED);
                        showMessageDialog(VentanaPrincipal.this, "DESCRIPCION VACIA", "ERROR", JOptionPane.ERROR_MESSAGE);
                        error = error+1;

                    }

                    if(auxtit.equals("")){

                        titulo.setBackground(Color.RED);
                        showMessageDialog(VentanaPrincipal.this, "TITULO VACIO", "ERROR", JOptionPane.ERROR_MESSAGE);
                        error = error+1;

                    }else {
                        StringTokenizer st = new StringTokenizer(auxtit);
                        if(st.countTokens() > 1){
                            titulo.setBackground(Color.RED);
                            showMessageDialog(VentanaPrincipal.this, "MAS DE UNA PALABRA PARA EL TITULO", "ERROR", JOptionPane.ERROR_MESSAGE);
                            error = error+1;

                        }

                    }

                }else if(aux ==1){
                    auxtipo = "Trabajo";

                    if(auxdir.equals("")){

                        direccion.setBackground(Color.RED);
                        showMessageDialog(VentanaPrincipal.this, "DIRECCION VACIA", "ERROR", JOptionPane.ERROR_MESSAGE);
                        error = error+1;
                    }

                    if(auxdesc.equals("")){

                        desc.setBackground(Color.RED);
                        showMessageDialog(VentanaPrincipal.this, "DESCRIPCION VACIA", "ERROR", JOptionPane.ERROR_MESSAGE);
                        error = error+1;

                    }

                    if(prec <= 0.0){

                        precio.setBackground(Color.RED);
                        showMessageDialog(VentanaPrincipal.this, "VALOR INCORRECTO DE PRECIO", "ERROR", JOptionPane.ERROR_MESSAGE);
                        error = error+1;

                    }

                    if(auxtit.equals("")){

                        titulo.setBackground(Color.RED);
                        showMessageDialog(VentanaPrincipal.this, "TITULO VACIO", "ERROR", JOptionPane.ERROR_MESSAGE);
                        error = error+1;

                    }else {
                        StringTokenizer st = new StringTokenizer(auxtit);
                        if(st.countTokens() > 1){
                            titulo.setBackground(Color.RED);
                            showMessageDialog(VentanaPrincipal.this, "MAS DE UNA PALABRA PARA EL TITULO", "ERROR", JOptionPane.ERROR_MESSAGE);
                            error = error+1;

                        }

                    }
                }

                if(error == 0){
                    anuncio.setDireccion(auxdir);
                    anuncio.setDescripcion(auxdesc);
                    anuncio.setTitulo(auxtit);
                    anuncio.setTipo(auxtipo);
                    anuncio.setPrecio(prec);
                    cardLayout1.show(panelCentral, "ConfUser");

                }

            }
        });


        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridwidth = 1;
        constraints.weightx = 1;
        constraints.weighty = 1;

        constraints.gridx = 0;
        constraints.gridy = 0;
        panelChange.add(descr,constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panelChange.add(desc,constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        panelChange.add(tit,constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        panelChange.add(titulo,constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;

        panelChange.add(precioAn,constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        panelChange.add(precio,constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        panelChange.add(dir,constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        panelChange.add(direccion,constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        panelChange.add(imag,constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        panelChange.add(foto,constraints);

        constraints.gridx = 1;
        constraints.gridy = 4;
        panelChange.add(tipoAn,constraints);

        constraints.gridx = 1;
        constraints.gridy = 5;
        panelChange.add(tipo,constraints);

        constraints.gridx = 0;
        constraints.gridy = 6;
        panelChange.add(cambiar,constraints);


        constraints.gridx = 1;
        constraints.gridy = 6;
        panelChange.add(guardar,constraints);

        panelCentral.add(panelChange,"EditAnuncio");

    }

    private void configuracion() {

        JPanel panelCentralConf = new JPanel();
        JPanel panelaux = new JPanel();
        JButton botonAyuda,botonMetodoPago,botonCerrarSesion,botonEliminarCuenta,botonAtras;

        panelCentralConf.setLayout(new GridLayout(5,1));
        panelaux.setLayout(new GridLayout(1,3));

        botonCerrarSesion = new JButton("Cerrar Sesion");
        botonAtras = new JButton("Atras");
        botonEliminarCuenta = new JButton("Eliminar Cuenta");
        botonMetodoPago = new JButton("Metodos de Pago");
        botonAyuda = new JButton("Ayuda");

        botonCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout1.show(panelCentral, "Inicio");
                cardLayout2.show(panelNorte,"Vacio");
            }
        });

        botonAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cardLayout1.show(panelCentral, "Usuario");

            }
        });

        botonEliminarCuenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //eliminar usuario de base de datos
                cardLayout1.show(panelCentral, "Inicio");
                cardLayout2.show(panelNorte,"Vacio");
            }
        });

        botonMetodoPago.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                metodoPago();
                cardLayout1.show(panelCentral,"MetodoPago");
            }
        });

        botonAyuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JDIALOG CON LA AYUDA
            }
        });

        panelCentralConf.add(botonMetodoPago);
        panelCentralConf.add(botonAyuda);
        panelCentralConf.add(botonCerrarSesion);
        panelCentralConf.add(botonEliminarCuenta);

        panelaux.add(botonAtras);
        panelaux.add(new JLabel());
        panelaux.add(new JLabel());
        panelCentralConf.add(panelaux);

        panelCentral.add(panelCentralConf,"Conf");

    }

    private void metodoPago() {

        JPanel panelCentMet = new JPanel();


    }

}