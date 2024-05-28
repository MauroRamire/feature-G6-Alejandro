package co.edu.ucatolica.controlador;

import co.edu.ucatolica.modelo.Cliente;
import co.edu.ucatolica.modelo.ClienteService;
import co.edu.ucatolica.vista.PanelDosCliente;
import co.edu.ucatolica.vista.PanelTresCliente;

import java.util.List;

public class ClienteController {
    private ClienteService clienteService;
    private PanelDosCliente panelDosCliente;
    private PanelTresCliente panelTresCliente;

    public ClienteController(ClienteService clienteService, PanelDosCliente panelDosCliente, PanelTresCliente panelTresCliente) {
        this.clienteService = clienteService;
        this.panelDosCliente = panelDosCliente;
        this.panelTresCliente = panelTresCliente;

        panelDosCliente.getBtnBuscar().addActionListener(e -> buscarCliente());
        panelTresCliente.getBtnAgregar().addActionListener(e -> agregarCliente());
        panelTresCliente.getBtnModificarFinal().addActionListener(e -> modificarCliente());
    }

    private void buscarCliente() {
        String cedula = ((PanelTresCliente) panelTresCliente).getTxtCedula().getText();
        Cliente cliente = clienteService.buscarCliente(cedula);
        if (cliente != null) {
            panelDosCliente.mostrarCliente(cliente);
        } else {
            panelDosCliente.mostrarMensaje("Cliente no encontrado.");
        }
    }

    private void agregarCliente() {
        String cedula = panelTresCliente.getTxtCedula().getText();
        String nombre = panelTresCliente.getTxtNombre().getText();
        String direccion = panelTresCliente.getTxtDireccion().getText();
        String telefono = panelTresCliente.getTxtTelefono().getText();
        String correo = panelTresCliente.getTxtCorreo().getText();

        Cliente cliente = new Cliente(cedula, nombre, direccion, telefono, correo);
        clienteService.crearCliente(cliente);

        limpiarCampos(panelTresCliente);
    }

    private void modificarCliente() {
        String cedula = panelTresCliente.getTxtCedula().getText();
        String nombre = panelTresCliente.getTxtNombre().getText();
        String direccion = panelTresCliente.getTxtDireccion().getText();
        String telefono = panelTresCliente.getTxtTelefono().getText();
        String correo = panelTresCliente.getTxtCorreo().getText();

        Cliente cliente = new Cliente(cedula, nombre, direccion, telefono, correo);
        clienteService.actualizarCliente(cedula, cliente);

        limpiarCampos(panelTresCliente);
    }

    private void limpiarCampos(PanelTresCliente panel) {
        panel.getTxtCedula().setText("");
        panel.getTxtNombre().setText("");
        panel.getTxtDireccion().setText("");
        panel.getTxtTelefono().setText("");
        panel.getTxtCorreo().setText("");
    }
}
