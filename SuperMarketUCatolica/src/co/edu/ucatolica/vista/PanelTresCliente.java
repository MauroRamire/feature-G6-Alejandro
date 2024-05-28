package co.edu.ucatolica.vista;

import javax.swing.*;
import java.awt.*;

public class PanelTresCliente extends JPanel {

    private JTextField txtCedula, txtNombre, txtDireccion, txtTelefono, txtCorreo;
    private JButton btnAgregar, btnModificarFinal;

    public PanelTresCliente() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtCedula = new JTextField(20);
        txtNombre = new JTextField(20);
        txtDireccion = new JTextField(20);
        txtTelefono = new JTextField(20);
        txtCorreo = new JTextField(20);
        btnAgregar = new JButton("Agregar");
        btnModificarFinal = new JButton("Modificar");

        JLabel lblTitulo = new JLabel("CLIENTES", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setForeground(Color.GREEN);
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 0);
        add(lblTitulo, gbc);

        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Cédula:"), gbc);
        gbc.gridx = 1;
        add(txtCedula, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Nombre Completo:"), gbc);
        gbc.gridx = 1;
        add(txtNombre, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Dirección:"), gbc);
        gbc.gridx = 1;
        add(txtDireccion, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Teléfono:"), gbc);
        gbc.gridx = 1;
        add(txtTelefono, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(new JLabel("Correo Electrónico:"), gbc);
        gbc.gridx = 1;
        add(txtCorreo, gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(btnAgregar, gbc);

        gbc.gridx = 1;
        add(btnModificarFinal, gbc);
    }

    public JTextField getTxtCedula() {
        return txtCedula;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JTextField getTxtDireccion() {
        return txtDireccion;
    }

    public JTextField getTxtTelefono() {
        return txtTelefono;
    }

    public JTextField getTxtCorreo() {
        return txtCorreo;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JButton getBtnModificarFinal() {
        return btnModificarFinal;
    }
}
