import java.util.*;

public class GrafoClientes {

    private Map<Integer, Cliente> clientes;
    private Map<Integer, Set<Integer>> conexiones;

    public GrafoClientes() {
        clientes = new HashMap<>();
        conexiones = new HashMap<>();
    }

    // Agregar un cliente (vertice)
    public void agregarCliente(Cliente cliente) {

        if (clientes.containsKey(cliente.getId())) {
            System.out.println("El cliente ya existe.");
            return;
        }

        clientes.put(cliente.getId(), cliente);
        conexiones.put(cliente.getId(), new HashSet<>());

        System.out.println("Cliente agregado correctamente.");
    }

    // Crear relacion entre dos clientes (arista)
    public void conectarClientes(int id1, int id2) {

        if (!clientes.containsKey(id1) ||
                !clientes.containsKey(id2)) {
            System.out.println("Uno de los clientes no existe.");
            return;
        }

        if (id1 == id2) {
            System.out.println("No se puede conectar un cliente consigo mismo.");
            return;
        }

        conexiones.get(id1).add(id2);
        conexiones.get(id2).add(id1);

        System.out.println("Clientes conectados correctamente.");
    }

    // Mostrar todos los clientes
    public void mostrarClientes() {

        for (Cliente cliente : clientes.values()) {
            System.out.println(cliente);
        }
    }

    // Mostrar las conexiones del grafo
    public void mostrarGrafo() {

        for (int id : conexiones.keySet()) {

            System.out.print(
                    clientes.get(id).getNombre() + " -> "
            );

            for (int conectado : conexiones.get(id)) {
                System.out.print(
                        clientes.get(conectado).getNombre() + " | "
                );
            }

            System.out.println();
        }
    }

    // Buscar un cliente
    public void buscarCliente(int id) {

        Cliente cliente = clientes.get(id);

        if (cliente != null) {
            System.out.println(cliente);
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    // Eliminar un cliente y sus conexiones
    public void eliminarCliente(int id) {

        if (!clientes.containsKey(id)) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        conexiones.remove(id);

        for (Set<Integer> vecinos : conexiones.values()) {
            vecinos.remove(id);
        }

        clientes.remove(id);

        System.out.println("Cliente eliminado correctamente.");
    }
}