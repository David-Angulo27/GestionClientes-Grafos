public class Main {

    public static void main(String[] args) {

        // Crear el grafo
        GrafoClientes grafo = new GrafoClientes();

        // Crear clientes
        Cliente c1 = new Cliente(1, "Carlos", "carlos@gmail.com");
        Cliente c2 = new Cliente(2, "Maria", "maria@gmail.com");
        Cliente c3 = new Cliente(3, "Pedro", "pedro@gmail.com");
        Cliente c4 = new Cliente(4, "Laura", "laura@gmail.com");

        // Agregar clientes
        grafo.agregarCliente(c1);
        grafo.agregarCliente(c2);
        grafo.agregarCliente(c3);
        grafo.agregarCliente(c4);

        // Crear conexiones
        grafo.conectarClientes(1, 2);
        grafo.conectarClientes(1, 3);
        grafo.conectarClientes(2, 4);
        grafo.conectarClientes(3, 4);

        // Mostrar clientes
        System.out.println("\n--- LISTA DE CLIENTES ---");
        grafo.mostrarClientes();

        // Mostrar grafo
        System.out.println("\n--- RELACIONES DEL GRAFO ---");
        grafo.mostrarGrafo();

        // Buscar cliente
        System.out.println("\n--- BUSCAR CLIENTE ---");
        grafo.buscarCliente(2);

        // Eliminar cliente
        System.out.println("\n--- ELIMINAR CLIENTE ---");
        grafo.eliminarCliente(3);

        // Mostrar grafo actualizado
        System.out.println("\n--- GRAFO ACTUALIZADO ---");
        grafo.mostrarGrafo();
    }
}