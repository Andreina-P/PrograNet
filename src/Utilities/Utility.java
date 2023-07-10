package Utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Utility {
    static Scanner sc = new Scanner(System.in);

    /**
     * @description: Verifica que un valor sea postivo y que sea numerico
     * @param mensaje: Lo que se muestra antes del ingreso del valor
     * @return numero: valor que esta verificado y que es correcto
     */
    public static int verifNumPosit(String mensaje) {
        int numero = 0;
        boolean valorvalido = true;
        while (valorvalido == true) {
            do {
                try {
                    System.out.print(mensaje);
                    numero = Integer.parseInt(sc.nextLine());
                    valorvalido = false;
                } catch (Exception numberFormatException) {
                    System.out.println("Valor ingresado incorrecto\n");
                }
            } while (numero <= 0);
        }
        return numero;
    }

    /**
     * @description: Verifica que una opcion de menu se encuentre sobre el rango de
     *               opciones dadas
     * @param mensaje:        Lo que se muestra antes del ingreso del valor
     * @param valorInicio:    Valor inical de las opciones del menu
     * @param valorFinalMenu: Valor final de las opciones del menu
     * @return opcion: valor verficado y que es correcto
     */
    public static int verifOpcionMenu(String mensaje, int valorInicio, int valorFinal) {
        int opcion = 0;
        boolean valorvalido = true;
        while (valorvalido == true) {
            do {
                try {
                    System.out.print(mensaje);
                    opcion = Integer.parseInt(sc.nextLine());
                    valorvalido = false;
                } catch (Exception numberFormatException) {
                    System.out.println("Valor ingresado incorrecto \n");
                }
            } while (opcion < valorInicio || opcion > valorFinal);
        }
        return opcion;
    }

    /**
     * @descripitIon: Valida el ingreso solo de F o M
     * @param mensaje: Lo que se muestra antes del ingreso del valor
     * @return genero: valor validado y en mayuscula
     */
    public static char validarIngresoSexo(String mensaje) {
        String sexo = "";
        char genero;
        do {
            System.out.print(mensaje);
            sexo = sc.nextLine().toUpperCase();

            if (sexo.length() == 1) {
                genero = sexo.charAt(0);
                if (genero == 'F' || genero == 'M') {
                    break;
                }
            }
            System.out.println("Ingreso inválido. \n ");
        } while (true);

        return genero;
    }

    /**
     * @description: Valida que una cadena solo tenga caracteres
     * @param mensaje: Lo que se muestra antes del ingreso del valor
     * @return texto: valor validado y correcto
     */
    public static String verifCadenas(String mensaje) {
        String texto = " ";

        do {
            System.out.print(mensaje);
            texto = sc.nextLine();

            if (texto.matches("[a-zA-Z\\s]+") == true) {
                break;
            } else {
                System.out.println("\nError: Solo debe ingresar letras \n ");
            }
        } while (true);

        return texto;
    }

    /**
     * @description: Validar el ingreso de solo String, convertir primera letra en
     *               mayus y juntar toda la cadena
     * @param mensaje: Lo que se muestra antes del ingreso del valor
     * @return texto: Valor validado y correcto nickname
     */
    public static String validarNickname(String mensaje) {
        String texto = "";
        texto = verifCadenas(mensaje).replaceAll("\\s+", "");
        texto = texto.substring(0, 1).toUpperCase() + texto.substring(1).toLowerCase();
        return texto;
    }

    /**
     * @description:Verifica que un valor sea positivo y que no se repitan, mediante
     *                       la interfaz set
     * @param mensaje:           Lo que se muestra antes del ingreso del valor
     * @param codigosExistentes: los codigos unicos que contiene set
     * @return codigo: valor validado para que no sea repetido y solo numerico
     */
    public static int obtenerCodigoValidado(String mensaje, Set<Integer> codigosExistentes) {
        int codigo = 0;

        do {
            codigo = verifNumPosit(mensaje);

            if (!codigosExistentes.contains(codigo)) {
                codigosExistentes.add(codigo);
                break;
            } else {
                System.out.println("Error: Código no válido. \n");
            }
        } while (true);

        return codigo;
    }

    public static String validarExistenciaCodigo(int apIDAmigo, Set<Integer> codigosExistentes) {
        if (!codigosExistentes.contains(apIDAmigo)) {
            codigosExistentes.remove(apIDAmigo);
            return (":( Lo sentimos... No se ha encontrado a tu amigo");
        }
        return ("Se agrego al amigo de tu amigo");

    }

    public static List<Integer> crearListaEdades() {
        List<Integer> edades = new ArrayList<>();
        edades.add(20);
        edades.add(25);
        edades.add(30);
        edades.add(35);
        edades.add(40);
        edades.add(45);
        edades.add(50);
        edades.add(55);
        edades.add(60);
        edades.add(65);
        edades.add(70);
        edades.add(75);
        edades.add(80);
        edades.add(85);
        edades.add(90);
        Collections.sort(edades);
        return edades;
    }

    public static void imprimirFigura(List<Integer> edades, int edadAnfitrion) {
        for (int i = edades.size() - 1; i >= 0; i--) {
            int edad = edades.get(i);
            if (edad > edadAnfitrion) {
                System.out.print("\t");
            } else if (edad == edadAnfitrion) {
                System.out.print("|");
            } else {
                System.out.print("\t\t");
            }
            System.out.println(edad);
        }
    }
}
