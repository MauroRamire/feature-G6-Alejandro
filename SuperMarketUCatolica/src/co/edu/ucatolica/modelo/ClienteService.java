package co.edu.ucatolica.modelo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ClienteService implements IClienteService {
    private List<Cliente> clientes;

    public ClienteService() {
        clientes = new ArrayList<>();
    }

    @Override
    public void crearCliente(Cliente cliente) {
        clientes.add(cliente);
        guardarClientes();
    }

    @Override
    public List<Cliente> leerClientes() {
        return clientes;
    }

    @Override
    public void actualizarCliente(String cedula, Cliente clienteActualizado) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCedula().equals(cedula)) {
                clientes.set(i, clienteActualizado);
                break;
            }
        }
        guardarClientes();
    }

    @Override
    public void borrarCliente(String cedula) {
        clientes.removeIf(cliente -> cliente.getCedula().equals(cedula));
        guardarClientes();
    }

    private void guardarClientes() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("clientes.dat"))) {
            out.writeObject(clientes);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

	public Cliente buscarCliente(String cedula) {
		// TODO Auto-generated method stub
		return null;
	}
}

