
package examen20240523Colecciones;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author jvegbel <jvegbel@canariaseducacion.es>
 */
public class ConjuntoOrdenado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Set<String> conjunto = new LinkedHashSet<>();
        Scanner scanner = new Scanner(System.in);
        String texto = "";
        for (int i = 0; i <12; i++) {
            System.out.println("Introduce un caracter: ");
            char caracter = scanner.next().charAt(0);
            texto += caracter;
            if ((i+1) %3 == 0) {
                conjunto.add(texto);
                texto = "";
            }
        }
        
        System.out.println("Conjunto por orden de inserción: " + conjunto);
        
        
        Set<String> ordenNatural  = new TreeSet<>(conjunto);
        System.out.println("Conjunto por orden Alfabetico: " + ordenNatural);
        
        //Comparator<String> comparadorInverso = Comparator.comparing(String::);
        Comparator<String> comparadorInverso = new Comparator<>() {
            public int compare(String s1, String s2) {
                return s2.compareTo(s1);
            }
        };
        // usando el reversed order        
        // Comparator<String> comparadorInverso = Comparator.reverseOrder();
        // Usando la función Lambda
//        Comparator<String> comparadorInverso  = Comparator.comparing(s->s, reverseOrder());
        
        
         Set<String> conjuntoOrdenInverso  =  new TreeSet<>(comparadorInverso);
         conjuntoOrdenInverso.addAll(conjunto);
         System.out.println("Conjunto por orden Alfabetico: " + conjuntoOrdenInverso);
        
        
    } // end Main
    
} // end Class
