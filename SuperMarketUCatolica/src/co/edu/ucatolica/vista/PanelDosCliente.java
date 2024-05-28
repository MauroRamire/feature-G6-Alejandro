package co.edu.ucatolica.vista;

import javax.swing.*;

import co.edu.ucatolica.modelo.Cliente;

import java.awt.*;

public class PanelDosCliente extends JPanel {

    private JLabel labResultado;
    private JTextField txtMonto;

    public PanelDosCliente() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;

        labResultado = new JLabel("Los Datos del Cliente Solicitado son:");
        txtMonto = new JTextField("");
        txtMonto.setFont(txtMonto.getFont().deriveFont(14f));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 10, 0, 10);
        add(labResultado, gbc);

        gbc.gridy = 1;
        gbc.weighty = 0.9;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 10, 10, 10);
        add(txtMonto, gbc);
    }

    public JLabel getLabResultado() {
        return labResultado;
    }

    public void setLabResultado(JLabel labResultado) {
        this.labResultado = labResultado;
    }

    public JTextField getTxtMonto() {
        return txtMonto;
    }

    public void setTxtMonto(JTextField txtMonto) {
        this.txtMonto = txtMonto;
    }

	public AbstractButton getBtnBuscar() {
		// TODO Auto-generated method stub
		return null;
	}

	public AbstractButton getTxtCedula() {
		// TODO Auto-generated method stub
		return null;
	}

	public void mostrarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	public void mostrarMensaje(String string) {
		// TODO Auto-generated method stub
		
	}
}
