
package examen20240423ColeccionesModificado;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author jvega
 */
// --- CLASE AGENDA DE CONTACTOS ---
public class AgendaContactos {

    // Se sustituye el Map por una List de objetos Contacto
    private List<Contacto> contactos;
    private Set<String> eliminados;
    private Scanner scanner;

    public AgendaContactos() {
        this.contactos = new ArrayList<>();
        this.eliminados = new LinkedHashSet<>();
        this.scanner = new Scanner(System.in);
    }

    // Método auxiliar para buscar un contacto en la lista por su nombre
    private Contacto buscarContactoPorNombre(String nombre) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null; // Retorna null si no lo encuentra
    }

    public void a�adir() {
        System.out.print("Introduce el nombre del contacto: ");
        String nombre = scanner.nextLine();

        Contacto contactoExistente = buscarContactoPorNombre(nombre);

        if (contactoExistente != null) {
            System.out.print("El contacto ya existe. ¿Deseas modificar su teléfono? (s/n): ");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                modificar(nombre); 
            }
        } else {
            Integer telefono = pedirTelefono();
            contactos.add(new Contacto(nombre, telefono)); // Se añade el objeto a la lista
            System.out.println("✅ Contacto añadido correctamente.");
        }
    }

    public void eliminar() {
        System.out.print("Introduce el nombre del contacto a eliminar: ");
        String nombre = scanner.nextLine();

        Contacto contactoExistente = buscarContactoPorNombre(nombre);

        if (contactoExistente != null) {
            contactos.remove(contactoExistente); // Se borra de la lista
            eliminados.add(contactoExistente.getNombre()); // Se añade al set de eliminados
            System.out.println("🗑�? Contacto eliminado correctamente.");
        } else {
            System.out.println("�?� El contacto no existe en la agenda.");
        }
    }

    public void modificar() {
        System.out.print("Introduce el nombre del contacto a modificar: ");
        String nombre = scanner.nextLine();
        modificar(nombre);
    }

    private void modificar(String nombre) {
        Contacto contactoExistente = buscarContactoPorNombre(nombre);

        if (contactoExistente == null) {
            System.out.println("�?� El contacto no existe en la agenda.");
        } else {
            Integer telefonoAntiguo = contactoExistente.getTelefono();
            System.out.println("Introduce el nuevo número para " + contactoExistente.getNombre() + ".");
            Integer telefonoNuevo = pedirTelefono();
            
            contactoExistente.setTelefono(telefonoNuevo); // Se actualiza el objeto
            System.out.println("✅ El teléfono del contacto se ha modificado correctamente.");
            System.out.println("Teléfono antiguo: " + telefonoAntiguo + " -> Nuevo teléfono: " + telefonoNuevo);
        }
    }

    public void buscarContactos() {
        System.out.print("Introduce el nombre del contacto a buscar: ");
        String nombre = scanner.nextLine();

        Contacto contactoExistente = buscarContactoPorNombre(nombre);

        if (contactoExistente != null) {
            System.out.println("👤 Nombre: " + contactoExistente.getNombre() + " | 📞 Teléfono: " + contactoExistente.getTelefono());
        } else {
            System.out.println("�?� El contacto no está en la agenda.");
        }
    }

    public void mostrarAgenda() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.");
        } else {
            System.out.println("\n--- 📖 AGENDA DE CONTACTOS ---");
            // Ordenamos la lista alfabéticamente comparando el atributo nombre de cada objeto
            contactos.sort(Comparator.comparing(Contacto::getNombre));
            
            for (Contacto c : contactos) {
                System.out.println("- " + c.getNombre() + ": " + c.getTelefono());
            }
        }
    }

//    public void mostrarContactosEliminados() {
//        if (eliminados.isEmpty()) {
//            System.out.println("No hay contactos eliminados.");
//        } else {
//            System.out.println("\n--- 🗑�? CONTACTOS ELIMINADOS ---");
//            for (String nombre : eliminados) {
//                System.out.println("- " + nombre);
//            }
//        }
//    }
    
    // ---  Uso de Iterator ---
    public void mostrarContactosEliminados() {
        if (eliminados.isEmpty()) {
            System.out.println("No hay contactos eliminados.");
        } else {
            System.out.println("\n--- 🗑�? CONTACTOS ELIMINADOS ---");
            
            // Creamos el iterador asociado a nuestro Set de eliminados
            Iterator<String> iterador = eliminados.iterator();
            
            // Mientras haya un elemento siguiente, avanzamos y lo imprimimos
            while (iterador.hasNext()) {
                String nombreEliminado = iterador.next();
                System.out.println("- " + nombreEliminado);
            }
        }
    }

    private Integer pedirTelefono() {
        while (true) {
            System.out.print("Introduce el teléfono (9 dígitos): ");
            String input = scanner.nextLine();
            if (input.matches("\\d{9}")) {
                return Integer.parseInt(input);
            } else {
                System.out.println("⚠�? Error: El teléfono debe ser un número entero de exactamente 9 dígitos.");
            }
        }
    }

    public void iniciar() {
        int opcion = 0;
        do {
            System.out.println("\n====== MENÚ AGENDA ======");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Eliminar contacto");
            System.out.println("3. Modificar contacto");
            System.out.println("4. Buscar contacto");
            System.out.println("5. Mostrar agenda");
            System.out.println("6. Mostrar contactos eliminados");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1: a�adir(); break;
                    case 2: eliminar(); break;
                    case 3: modificar(); break;
                    case 4: buscarContactos(); break;
                    case 5: mostrarAgenda(); break;
                    case 6: mostrarContactosEliminados(); break;
                    case 7: System.out.println("Saliendo de la agenda... ¡Hasta pronto!"); break;
                    default: System.out.println("⚠�? Opción no válida. Inténtalo de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠�? Por favor, introduce un número válido.");
            }
        } while (opcion != 7);
    }

}
