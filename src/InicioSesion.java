import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import static javax.swing.JOptionPane.showMessageDialog;

public class InicioSesion extends JFrame {

    JFrame ventana;
    JTextField correoField;
    JLabel iniciarSesionLabel,correoLabel,contraseñaLabel,vacio1Label,vacio2Label,vacio3Label;
    JButton entrarBoton,olvidarContraseñaBoton;
    JPanel centroPanel,superiorPanel,imagenPanel;
    Image logoImagen;
    URL dirLogo;
    JPasswordField contraseñaField;

    public InicioSesion(){

        ventana = new JFrame();

        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(300,500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        centroPanel = new JPanel();
        superiorPanel = new JPanel();
        imagenPanel = new JPanel();

        centroPanel.setLayout(new GridLayout(10,1));
        superiorPanel.setLayout(new GridLayout(1,5));

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

        entrarBoton = new JButton("ENTRAR");
        olvidarContraseñaBoton = new JButton("OLVIDE MI CONTRASEÑA");



        entrarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String correo = correoField.getText();
                String contraseña = new String(contraseñaField.getPassword());

                if (correo.equals("afernandezpacheco@icai.comillas.edu")) {
                    if (contraseña.equals("comandante")) {
                        showMessageDialog(InicioSesion.this, "INICIO CORRECTO", "PASAR", JOptionPane.OK_OPTION);
                        contraseñaField.setBackground(Color.WHITE);
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
        });

        centroPanel.add(iniciarSesionLabel);
        centroPanel.add(vacio1Label);
        centroPanel.add(correoLabel);
        centroPanel.add(correoField);
        centroPanel.add(contraseñaLabel);
        centroPanel.add(contraseñaField);
        centroPanel.add(vacio2Label);
        centroPanel.add(entrarBoton);
        centroPanel.add(olvidarContraseñaBoton);
        centroPanel.add(vacio3Label);

        superiorPanel.add(imagenPanel);

        //superiorPanel.add();//FIGURA

        this.add(centroPanel, BorderLayout.CENTER);
        this.add(superiorPanel,BorderLayout.NORTH);

        this.pack();
        this.setVisible(true);

    }


}
