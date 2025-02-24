package com.operacion_con_conjuntos;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nIntroducir los elementos del primer conjunto (Seperado por espacios): " );
        Set<Integer> conj1 = leerConjunto(sc);

        System.out.print("Introducir los elementos del Segundo conjunto (Seperado por espacios): " );
        Set<Integer> conj2 = leerConjunto(sc);

        int opcion;
        do {
            String menu = """
            =============================
            ===   ¿QUE DESEA HACER?   ===
            =============================
            1. Ver Unión de los conjuntos
            2. Ver Intersecciones de los conjuntos
            3. Ver diferencia en los conjuntos
            4. Salir
            """;
            System.out.println(menu);
            System.out.println("Seleccione una opción: ");
            while (!sc.hasNextInt()) {
                System.out.println("Error: Debe ingresar un número");
                sc.next();
                System.out.print("Seleccione una opción: ");
            }
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    Set<Integer> union = new HashSet<>(conj1);
                    union.addAll(conj2);
                    System.out.println("Unión de los Conjuntos " + union);
                    break;

                case 2:
                    Set<Integer> interseccion = new HashSet<>(conj1);
                    interseccion.retainAll(conj2);
                    System.out.println("Intersección de los Conjuntos " + interseccion);
                    break;

                case 3:
                    Set<Integer> diferencia = new HashSet<>(conj1);
                    diferencia.removeAll(conj2);
                    System.out.println("Diferencias entre los Conjuntos " + diferencia);
                    break;

                case 4:
                    System.out.println("¡¡Gracias Por Usar Este Programa!!");
                    break;
            
                default:
                    System.out.println("Esta opción no es valida...");
                    break;
            }
        } while (opcion != 4);

        sc.close();
    }

    private static Set<Integer> leerConjunto(Scanner sc) {
        Set<Integer> conjunto = new HashSet<>();
        String entrada = sc.nextLine();
        String [] numeros = entrada.split(" ");
        for (String numero : numeros) {
            try {
                conjunto.add(Integer.parseInt(numero));
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida " + numero + " no es un número válido");
            }
        }

        return conjunto;
    }
}