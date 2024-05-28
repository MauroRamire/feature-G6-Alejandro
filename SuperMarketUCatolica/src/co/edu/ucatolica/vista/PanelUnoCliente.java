package co.edu.ucatolica.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelUnoCliente extends JPanel {
    private JLabel labEntrada1;
    private JTextField txtNumero;
    private JButton butBuscarLeer;
    private JButton butEliminar;
    private JButton butSalir;

    public PanelUnoCliente() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        labEntrada1 = new JLabel("INGRESE Cedula A MODIFICAR");
        labEntrada1.setForeground(Color.GREEN);
        labEntrada1.setHorizontalAlignment(JLabel.CENTER);

        txtNumero = new JTextField(20);
        txtNumero.setForeground(Color.BLACK);
        txtNumero.setBackground(Color.WHITE);

        butBuscarLeer = new JButton("Buscar/Leer");
        butBuscarLeer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para buscar/leer cliente
            }
        });

        butEliminar = new JButton("Eliminar");
        butEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para eliminar cliente
            }
        });

        butSalir = new JButton("Salir");
        butSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para salir
            }
        });
        butSalir.setBackground(new Color(255, 102, 102));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(labEntrada1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(txtNumero, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        add(butBuscarLeer, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(butEliminar, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(butSalir, gbc);
    }

    public JTextField getTxtNumero() {
        return txtNumero;
    }

    public JButton getButBuscarLeer() {
        return butBuscarLeer;
    }

    public JButton getButEliminar() {
        return butEliminar;
    }

    public JButton getButSalir() {
        return butSalir;
    }
}
