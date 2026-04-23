
package examen20240523Colecciones;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author jvegbel <jvegbel@canariaseducacion.es>
 */
public class Agenda {
    private List<Contacto> contactos;
    private Set<String> eliminados;
    
    public Agenda() {
        this.contactos = new ArrayList<>();
        Set<String> LinkedHashSet;
        this.eliminados = new LinkedHashSet<>();
        
    }
    
    
    public void añadir() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el nombre del contacto: ");
        String nombre = scanner.nextLine();
        
        Contacto contactoExistente = buscarContactoPornombre(nombre);
        
        
        
        if (contactoExistente != null) {
            System.out.println("El contacto ya existe, ¿quieres modificar el telefono? (s/n)");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                System.out.println("Llamamos a metodo para modificar el telefono del contacto");
            }
            
        } else  {
            System.out.print("Introduce el telefono: ");
            Integer telefono = Integer.parseInt(scanner.nextLine());
            contactos.add(new Contacto(nombre, telefono));
        }
        
       
       
    }
    
    private Contacto buscarContactoPornombre(String nombre) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null; // retorna null si no encuentra el nombre en ninguno de los contactos
    }
    
    public void eliminar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el nombre del contacto a eliminar: ");
        String nombre = scanner.nextLine();
        Contacto contactoExistente = buscarContactoPornombre(nombre);
         if (contactoExistente == null) {
             System.out.println("No existe el contacto");
         } else {
             contactos.remove(contactoExistente);
             eliminados.add(contactoExistente.getNombre());
         }
        
        
    }
            
    
    
    
}
