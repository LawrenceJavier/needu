import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class VentanaRegistrarse extends JFrame
{


    private JLabel lblRegistrarse;
    private JLabel lblNombre;
    private JLabel lblApellidos;
    private JLabel lblCorreoElectronico;
    private JLabel lblContrasena;
    private JLabel lblConfirmarContrasena;

    private JTextField txtNombre;
    private JTextField txtApellidos;
    private JTextField txtCorreoElectronico;
    private JPasswordField txtContrasena;
    private JPasswordField txtConfirmarContrasena;

    private JButton btnRegistrarse;


    public VentanaRegistrarse(){

        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.setMinimumSize(new Dimension(300,500));

        JPanel pnlNorte = new JPanel();
        JPanel pnlCentral = new JPanel();
        JPanel pnlSur = new JPanel(new FlowLayout());

        pnlCentral.setLayout(new GridLayout(13,1));
        pnlNorte.setLayout(new GridLayout(1,5));

        ImageIcon logoImagen = new ImageIcon("resources"+File.separator+"logo.jpeg");
        JLabel logo = new JLabel(logoImagen);
        logo.setAlignmentX(Component.LEFT_ALIGNMENT);

        lblRegistrarse = new JLabel("REGISTRARSE");
        lblRegistrarse.setHorizontalAlignment(JLabel.CENTER);
        lblNombre = new JLabel("Nombre: ");
        lblNombre.setHorizontalAlignment(JLabel.CENTER);
        lblApellidos = new JLabel("Apellidos: ");
        lblApellidos.setHorizontalAlignment(JLabel.CENTER);
        lblCorreoElectronico = new JLabel("Direccion Correo electronico: ");
        lblCorreoElectronico.setHorizontalAlignment(JLabel.CENTER);
        lblContrasena = new JLabel("Contrasena: ");
        lblContrasena.setHorizontalAlignment(JLabel.CENTER);
        lblConfirmarContrasena = new JLabel("Confirmar Contrasena: ");
        lblConfirmarContrasena.setHorizontalAlignment(JLabel.CENTER);
        JLabel lblVacio = new JLabel();

        txtNombre = new JTextField("Nombre");
        txtApellidos = new JTextField("Apellidos");
        txtCorreoElectronico = new JTextField("Correo electronico");
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
                    JOptionPane.showMessageDialog(VentanaRegistrarse.this,"REGISTRADO CON EXITO");
                    new PantallaUsuario();
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(VentanaRegistrarse.this,"Contrasena y Confirmar Contrasena NO coinciden");

                }
            }
        });


        pnlNorte.add(logo);
        pnlNorte.add(new JLabel());
        pnlNorte.add(new JLabel());
        pnlNorte.add(new JLabel());
        pnlNorte.add(new JLabel());

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

        pnlSur.add(new JLabel("NeedU"));

        this.add(pnlNorte, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlSur, BorderLayout.SOUTH);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
} 