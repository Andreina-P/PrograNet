import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

import Utilities.Utility;
import pkRedSocial.Menu;
import pkRedSocial.Persona;

public class App extends Menu {
    static final String APUSER1 = "2450670985";
    static final String APCLAVE_USER1 = "andreina.pallo@epn.edu.ec";
    static final String APUSER2 = "profe";
    static final String APCLAVE_USER2 = "1234";
    public static String apUser;
    public static String apTema = "FRIENDS";
    static Set<Integer> apCodigos = new HashSet<>();
    static Scanner sc = new Scanner(System.in);
    static Set<Persona> apDatosNetwork  = new LinkedHashSet<>();
    static Set<String> apNetworkPresent  = new HashSet<>();
    static Set<String> apDatosNetwMujer  = new HashSet<>();
    static Set<String> apDatosNetwHombre  = new HashSet<>();

    public static void main(String[] args) throws Exception {
        boolean login = apLogin();
        if (login == false) {
            System.exit(0);
        }

        apRegistro();
        // limpiar pantalla

        apVisualizarTema();

        int apOpcionMenu = apMenu();
        switch (apOpcionMenu) {
            case 1:
                apVisualizarTema();
                System.out.println("AGREGAR AMIGO");
                apRegistro();
                break;
            case 2:
                apVisualizarTema();
                System.out.println("AGREGAR AMIGO DE AMIGO");
                System.out.println("\n<+> Agrega un amigo a tu amigo: ");
                int apIDAmigo = Utility.obtenerCodigoValidado("+ Cual es el ID de tu amigo: ", apCodigos);
                apRegistro();
                Utility.validarExistenciaCodigo(apIDAmigo, apCodigos);

                break;

            case 3:
                apVisualizarTema();
                System.out.println("\nNETWORK ");

                break;
            case 4:
                break;
            case 5:
                break;
            case 0:
                System.out.println("Regresa pronto " + apUser);
                System.exit(0);
                break;
        }

    }

    private static void apVisualizarTema() {
        System.out.println("-------------------------------");
        System.out.println("        NETWORKIN DE " + apTema);
        System.out.println("-------------------------------");
        System.out.println("usuario: " + apUser);
    }

    public static void apRegistro() {
        System.out.println("<+> Por favor registra");
        int apID = Utility.obtenerCodigoValidado("\n+ Codigo (ID): ", apCodigos);
        String apNick = Utility.validarNickname("\n+ Nombre o nick: ");
        int apEdad = Utility.verifNumPosit("\n+ Edad: ");
        char apSexo = Utility.validarIngresoSexo("\n+ Sexo: (F/M) ");

        Persona persona = new Persona(apID, apNick, apEdad, apSexo);
        apDatosNetwork.add(persona);
        apNetworkPresent.add("("+apID+"-"+apSexo+") "+apNick);
        if (apSexo=='F') {
            apDatosNetwMujer.add("("+apID+"-"+apSexo+") "+apNick);
        } else {
            apDatosNetwHombre.add("("+apID+"-"+apSexo+") "+apNick);
        }        
    }

    public static int apMenu() {
        System.out.println("1 AGREGAR AMIGO");
        System.out.println("2 AGREGAR AMIGO DE AMIGO");
        System.out.println("3 MOSTRAR NETWORK");
        System.out.println("4 MOSTRAR NETWORK AMIGOS");
        System.out.println("5 MOSTRAR NETWORK AMIGAS");
        System.out.println("0 SALIR");
        int apOpcionMenu = Utility.verifOpcionMenu("\n<+> Ingresa opc", 0, 5);
        return apOpcionMenu;
    }

    public static boolean apLogin() {
        int paIntentos = 0;
        String paUsuaIngr = " ", paClaveIng = " ", paGuiones = "--------------------\n";
        while (paIntentos < 3) {
            System.out.print("\nIngrese el usuario para logearse: ");
            paUsuaIngr = sc.nextLine();
            System.out.print("Ingrese la clave para el login: ");
            paClaveIng = sc.nextLine();
            String datos = "\n" + paGuiones + "NETRWORKIN DE " + apTema + "\n" + paGuiones + "\n" + paGuiones
                    + "+ Usuario: " + paUsuaIngr + "\n+ Clave: "
                    + paClaveIng.replaceAll("\\d", "*");

            if ((paUsuaIngr.equals(APUSER2) && paClaveIng.equals(APCLAVE_USER2))
                    || (paUsuaIngr.equals(APUSER1) && paClaveIng.equals(APCLAVE_USER1))) {
                System.out.println(datos + "\n" + paGuiones + "\n::Bienvenido " + paUsuaIngr.toUpperCase() + "\n");
                apUser = paUsuaIngr;
                paIntentos = 3;
                return true;
            } else {
                paIntentos++;
                System.out.println(datos + "\n" + paGuiones + "\n* Nro de intentos: " + paIntentos);
            }
        }

        System.out.println("Lo sentimos tu usuario y clave son incorrectos...! \n Gracias");
        return false;
    }
}
