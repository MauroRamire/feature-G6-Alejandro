package co.edu.ucatolica.modelo;

import java.util.List;

public interface IClienteService {
    void crearCliente(Cliente cliente);
    List<Cliente> leerClientes();
    void actualizarCliente(String cedula, Cliente clienteActualizado);
    void borrarCliente(String cedula);
}