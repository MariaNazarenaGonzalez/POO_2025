
package ar.edu.unlu.ng190217.tp1;

import ar.edu.unlu.ng190217.tp1.punto1.ListaSimpleEnlace;
import ar.edu.unlu.ng190217.tp1.punto2.ListaDobleEnlace;
import ar.edu.unlu.ng190217.tp1.punto3.Pila;
import ar.edu.unlu.ng190217.tp1.punto4.Cola;
import ar.edu.unlu.ng190217.tp1.punto5.*;
import ar.edu.unlu.ng190217.tp1.punto6.*;
import ar.edu.unlu.ng190217.tp1.punto7.*;
import ar.edu.unlu.ng190217.tp1.punto8.*;
import ar.edu.unlu.ng190217.tp1.punto9.*;
import ar.edu.unlu.ng190217.tp1.punto10.*;
import ar.edu.unlu.ng190217.tp1.punto11.*;
import ar.edu.unlu.ng190217.tp1.punto12.*;
import ar.edu.unlu.ng190217.tp1.punto13.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        int opcion = 0;
        do {
            mostrarMenu();
            opcion = recibirOpcion();
            if (opcion != 0) {
                procesarOpcion(opcion);
            }
        } while (opcion != 0);
        System.out.println("\n\nEl programa ha terminado.\nTenga un buen día.");
    }
    //***MENú***
    private static void mostrarMenu () {
        System.out.println("\n+++++++++  MENU TP1  +++++++++");
        System.out.println("1.ej_1   6.ej_6   11.ej_11");
        System.out.println("2.ej_2   7.ej_7   12.ej_12");
        System.out.println("3.ej_3   8.ej_8   13.ej_13");
        System.out.println("4.ej_4   9.ej_9");
        System.out.println("5.ej_5   10.ej_10");
        System.out.println("0.EXIT");
    }
    private static int recibirOpcion () {
        int opcion = -1;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\nIngrese la opcion: ");
            opcion = sc.nextInt();
        } while( (opcion < 0) | (opcion > 13) );
        return opcion;
    }
    private static void procesarOpcion (int opcion) {
        switch (opcion) {
            case 1: punto1(); break;
            case 2: punto2(); break;
            case 3: punto3(); break;
            case 4: punto4(); break;
            case 5: punto5(); break;
            case 6: punto6(); break;
            case 7: punto7(); break;
            case 8: punto8(); break;
            case 9: punto9(); break;
            case 10: punto10(); break;
            case 11: punto11(); break;
            case 12: punto12(); break;
            case 13: punto13(); break;
            default: System.out.println("No deberías poder acceder aquí por el menú.");
        }
    }

    //***TESTING TP1***
    private static void punto1 () {

        //Testing punto 1 (probar llenar sólo con strings para mostrar la lista con println,
        //                 o con objeto que tenga toString redefinida).

        ListaSimpleEnlace lista = new ListaSimpleEnlace();
        System.out.println("Se muestra la longitud de la lista.");
        System.out.println(lista.longitud());
        if (lista.es_vacia()) {
            System.out.println("La lista está vacía");
        }
        lista.agregar("1");
        lista.agregar("2");
        lista.agregar("1");
        lista.agregar("3");
        System.out.println(lista);
        System.out.println("Se muestra la longitud de la lista.");
        System.out.println(lista.longitud());
        System.out.println("Se elimina el elemento '3'.");
        lista.borrar("3");
        System.out.println(lista);
        System.out.println("Se muestra el elemento en posicion 2.");
        System.out.println(lista.recuperar(2));
        System.out.println("Se agrega el elemento '3' en posicion 2.");
        lista.agregarEnPosicion(3, 2);
        System.out.println(lista);
    }
    private static void punto2 () {
        //Testing Punto 2 (probar llenar sólo con strings para mostrar la lista con println)

        ListaDobleEnlace lista = new ListaDobleEnlace();
        lista.agregar("1");
        lista.agregar("2");
        lista.agregar("3");
        lista.agregar("4");
        System.out.println(lista);
        System.out.println("Se borra elemento '4'.");
        lista.borrar("4");
        System.out.println(lista);
        System.out.println("Se agrega elemento '1' en posicion 1.");
        lista.agregarEnPosicion("1", 1);
        System.out.println(lista);
        System.out.println("Se agrega elemento '4' en posicion 2.");
        lista.agregarEnPosicion("4", 2);
        System.out.println(lista);
    }
    private static void punto3 () {
        //Testing Punto 3 Pila

        Pila pila = new Pila();
        pila.apilar("1");
        pila.apilar("2");
        pila.apilar("3");
        pila.apilar("4");
        System.out.println("Tras apilar 4 elementos, la pila queda:");
        System.out.println(pila);
        pila.desapilar();
        pila.desapilar();
        System.out.println("Desapila dos elementos. Muestra tope, luego pila.");
        System.out.println(pila.recuperarTope());
        System.out.println(pila);
        pila.desapilar();
        System.out.println("Desapila un elemento.");
        System.out.println(pila);
        pila.apilar("5");
        pila.apilar("6");
        System.out.println("Apila dos elementos.");
        System.out.println(pila);
    }
    private static void punto4 () {

        //Testing punto 4

        Cola cola = new Cola();
        cola.encolar("1");
        cola.encolar("3");
        cola.encolar("2");
        cola.encolar("4");
        System.out.println("Se apilan cuatro elementos.");
        System.out.println(cola);
        cola.desencolar();
        System.out.println("Se desencola un elemento.");
        System.out.println(cola);
        cola.encolar("6");
        cola.encolar("7");
        cola.encolar("5");
        cola.encolar("8");
        System.out.println("Se apilan cuatro elementos.");
        System.out.println(cola);
    }
    private static void punto5 () {

        //TESTING PUNTO 5

        LocalDate hoy = LocalDate.now();

        Tarea supermercado = new Tarea(hoy.plusDays(1));
        supermercado.setDescripcion("ir al supermercado mañana");
        supermercado.setPrioridad(2);

        Tarea repuesto = new Tarea("Consultar repuesto del auto", 5,
                hoy.minusDays(1));
        repuesto.completar();

        Tarea cine = new Tarea("Ir al cine a ver la nueva película de Marvel",
                15, hoy.minusDays(1));

        System.out.println(supermercado);
        System.out.println("Esta completa: " + supermercado.estaCompleta());
        System.out.println("Esta vencida: " + supermercado.vencida() + "\n");

        System.out.println(repuesto);
        System.out.println("Esta completa: " + repuesto.estaCompleta());
        System.out.println("Esta vencida: " + repuesto.vencida() + "\n");

        System.out.println(cine);
        System.out.println("Esta completa: " + cine.estaCompleta());
        System.out.println("Esta vencida: " + cine.vencida() + "\n");

    }
    private static void punto6 () {

        //TESTING PUNTO 6

        Libro elQuijote = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes",
                9788, 1424, 10, 3);

        Libro elMundoPerdido = new Libro ("El Mundo Perdido", "A. C. Doyle", 9783,
                480, 5, 4);

        System.out.println("Se crean dos libros y se los muestra.\n");
        System.out.println(elQuijote + "\n");
        System.out.println(elMundoPerdido + "\n" );

        if(elQuijote.tieneMasPaginasQue(elMundoPerdido)){System.out.println(elQuijote + "\n TIENE MAS PAGINAS QUE\n" + elMundoPerdido + "\n" );}
        else if(elMundoPerdido.tieneMasPaginasQue(elQuijote)){System.out.println(elMundoPerdido + "\n TIENE MAS PAGINAS QUE\n" + elQuijote + "\n");}
        else {System.out.println(elMundoPerdido + "\n TIENE LA MISMA CANTIDAD DE PAGINAS QUE\n" + elQuijote + "\n");}

        Libro elLibroDeLaSelva = new Libro ("El Libro de la Selva", "Rudyard Kipling",
                9780, 320, 20, 10);

        Libro elMisterioDelCuartoAmarillo = new Libro ("El Misterio del Cuarto Amarillo",
                "Gaston Leroux", 97884,
                306, 4, 1);

        System.out.println("Se crean dos libros más y se utilizan para probar prestar.\n");
        System.out.println(elLibroDeLaSelva + "\n");
        System.out.println("Se presta un ejemplar de El Libro de la Selva.\n");
        elLibroDeLaSelva.prestar();
        System.out.println(elLibroDeLaSelva + "\n");

        System.out.println(elMisterioDelCuartoAmarillo + "\n");
        System.out.println("Se intenta prestar un ejemplar de El Misterio del Cuarto Amarillo.\n");
        elMisterioDelCuartoAmarillo.prestar();
        System.out.println(elMisterioDelCuartoAmarillo+"\n");

        Libro.totalPrestados();

    }
    private static void punto7 () {

        //TESTING PUNTO 7

        EcSegundoGrado ec1 = new EcSegundoGrado(1, 2, -1);
        EcSegundoGrado ec2 = new EcSegundoGrado(-2, 4, -1);
        EcSegundoGrado ec3 = new EcSegundoGrado(2, 0, 1);
        EcSegundoGrado ec4 = new EcSegundoGrado(2, 0, 0);

        System.out.println("Se crean cuatro ecuaciones de segundo grado.");
        System.out.println("Sus coeficientes son:");
        System.out.println("a   b   c");
        System.out.println("1   2   -1");
        System.out.println("-2   4   -1");
        System.out.println("2   0   1");
        System.out.println("2   0   0");

        System.out.println("\nSe obtienen y se muestran las raíces de las 4 ecuaciones.\n");

        double[] raices1 = ec1.obtenerRaices();
        for (double raiz : raices1) {System.out.println("Raiz de ec1: " + (int)raiz);}

        double[] raices2 = ec2.obtenerRaices();
        for (double raiz : raices2) {System.out.println("Raiz de ec2: " + (int)raiz);}

        System.out.println("Se buscan raices de ec3.");
        double[] raices3 = ec3.obtenerRaices();

        double[] raices4 = ec4.obtenerRaices();
        System.out.println("Raiz de ec4: " + (int)raices4[0]);

        System.out.println("\nCon x = 2, y de ec1 resulta: " + (int)ec1.obtenerY(2));
        System.out.println("\nCon x = 3, y de ec1 resulta: " + (int)ec1.obtenerY(3));
        System.out.println("\nCon x = 2, y de ec2 resulta: " + (int)ec2.obtenerY(2));
        System.out.println("\nCon x = 2, y de ec3 resulta: " + (int)ec3.obtenerY(2));
        System.out.println("\nCon x = 2, y de ec4 resulta: " + (int)ec4.obtenerY(2));
        System.out.println("\nCon x = 7, y de ec4 resulta: " + (int)ec4.obtenerY(7));

    }
    private static void punto8 () {

        //TESTING PUNTO 8


        ArrayList<Contrasenia> contrasenias = new ArrayList<Contrasenia>();
        Scanner sc = new Scanner(System.in);
        int long1,long2, long3, long4;
        System.out.println("Introduzca 4 longtudad validas ");
        System.out.println("Introduzca una longitud válida: ");
        long1 = sc.nextInt();
        contrasenias.add(new Contrasenia(long1));
        System.out.println("Introduzca una longitud válida: ");
        long2 = sc.nextInt();
        contrasenias.add(new Contrasenia(long2));
        System.out.println("Introduzca una longitud válida: ");
        long3 = sc.nextInt();
        contrasenias.add(new Contrasenia(long3));
        System.out.println("Introduzca una longitud válida: ");
        long4 = sc.nextInt();
        contrasenias.add(new Contrasenia(long4));

        for (Contrasenia contrasenia : contrasenias) {System.out.println(contrasenia);}

        System.out.println("Se fortalecerán las contraseñas débiles.");

        for (Contrasenia aux : contrasenias) {
            if (!aux.esFuerte()) {
                System.out.print("La contraseña:");
                System.out.println(aux);
                aux.regenerarContrasenia();
                System.out.print("Ahora es:");
                System.out.println(aux);
            }
        }
    }
    private static void punto9 () {

        //TESTING Punto 9

        String fechaCadena1 = "24-04-2025";
        String fechaCadena2 = "05-25-2025";

        OperacionesFecha operaciones = new OperacionesFecha();

        LocalDate fechaFormat1 = operaciones.unaFecha(fechaCadena1, 1);
        LocalDate fechaFormat2 = operaciones.unaFecha(fechaCadena2, 2);

        LocalDate fecha1 = LocalDate.of(2025, 1, 1);
        LocalDate fecha2 = LocalDate.of(2025, 2, 2);
        LocalDate fecha3 = LocalDate.of(2025, 3, 3);

        System.out.println("fc1: " + fechaCadena1);
        System.out.println("fc2: " + fechaCadena2);

        System.out.println("fecha fc1 (formato 1) resulta: " + fechaFormat1);
        System.out.println("fecha fc2 (formato 2) resulta: " + fechaFormat2);

        System.out.println("fecha 1: " + fecha1);
        System.out.println("fecha 2: " + fecha2);
        System.out.println("fecha 3: " + fecha3);

        System.out.println("fecha2 es mayor que fecha1: " +
                OperacionesFecha.esMayor(fecha1, fecha2));
        System.out.println("fecha2 es mayor que fecha3: " +
                OperacionesFecha.esMayor(fecha3, fecha2));
        System.out.println("fecha2 es menor que fecha1: " +
                OperacionesFecha.esMenor(fecha1, fecha2));
        System.out.println("fecha2 es menor que fecha3: " +
                OperacionesFecha.esMenor(fecha3, fecha2));
        System.out.println("fecha2 es mayor a fecha1 y menor que fecha3: " +
                OperacionesFecha.estaEntreDos(fecha1, fecha3, fecha2));
        System.out.println("fecha3 es mayor a fecha1 y menor que fecha2: " +
                OperacionesFecha.estaEntreDos(fecha1, fecha2, fecha3));

    }
    private static void punto10 () {

        //TESTING PUNTO 10

        LocalDate hoy = LocalDate.now();

        Tarea2 repuesto = new Tarea2("Consultar repuesto del auto", 5,
                hoy.plusDays(4), hoy.plusDays(2), 1);
        repuesto.completar();

        Tarea2 cine = new Tarea2("Ir al cine a ver la nueva película de Marvel",
                15, hoy.plusDays(3), hoy.plusDays(1), 2);

        System.out.println(repuesto);
        System.out.println("Prioridad repuesto: " + repuesto.getPrioridad());
        System.out.println("\n"+cine);
        System.out.println("Prioridad cine: " + cine.getPrioridad());

        System.out.println("\nSe modifica fecha recordatorio de repuesto para que cambie la prioridad.");

        repuesto.setFechaRecordatorio(repuesto.getFechaLimite().minusDays(1));

        System.out.println("\n" + repuesto);
        System.out.println("Prioridad repuesto: " + repuesto.getPrioridad());

    }
    private static void punto11 () {

        //TESTING PUNTO 11

        ScrabbleAcotado scrabble = new ScrabbleAcotado();

        scrabble.aniadirPalabraDiccionario("acrobacia");
        scrabble.aniadirPalabraDiccionario("danza");
        scrabble.aniadirPalabraDiccionario("azafran");
        scrabble.aniadirPalabraDiccionario("fierro");

        Jugador jugador1 = new Jugador("J1");
        Jugador jugador2 = new Jugador("J2");

        scrabble.aniadirJugador(jugador1);
        scrabble.aniadirJugador(jugador2);

        System.out.println(scrabble);

        System.out.println("\nSe intenta cargar palabra 'acrobatia' a J1.");
        scrabble.aniadirPalabraJugadorN("acrobatia", 1);

        System.out.println("\nSe carga palabra 'acrobacia' a J2.");
        scrabble.aniadirPalabraJugadorN("acrobacia", 2);

        System.out.println("\nSe intenta cargar palabra 'fierro' a un jugador que no existe.");
        scrabble.aniadirPalabraJugadorN("fierro", 3);

        System.out.println("\nSe carga palabra 'azafran' a J1.");
        scrabble.aniadirPalabraJugadorN("azafran", 1);

        System.out.println(scrabble);

        System.out.println("\nEl jugador con mayor puntaje es: " + scrabble.getJugadorMayorPuntaje());

    }
    private static void punto12 () {

        //TESTING PUNTO 12

        AdminTarea admintarea = new AdminTarea();

        LocalDate hoy = LocalDate.now();

        admintarea.crearTarea("Hacer ejercicio", 15, hoy.plusDays(3),
                hoy.plusDays(1));
        admintarea.crearTarea("Limpiar platos", 8, hoy.minusDays(3),
                hoy.minusDays(4));
        admintarea.crearTarea("Ir al cine", 45, hoy.plusDays(7),
                hoy.plusDays(5));
        admintarea.marcarTareaNCompletada(1);
        admintarea.crearTarea("Cocinar", 3, hoy.plusDays(4),
                hoy.plusDays(2));
        admintarea.crearTarea("Poner lavarropas", 5, hoy.plusDays(5),
                hoy.plusDays(2));
        admintarea.crearTarea("Estudiar", 3, hoy.plusDays(3),
                hoy);
        admintarea.crearTarea("Dormir", 1, hoy,
                hoy);
        admintarea.crearTarea("Ordenar dormitorio", 1, hoy.plusDays(1),
                hoy);

        System.out.println("\nTras cargar tareas en el administrador de tareas" +
                "\nSe muestran las tareas no vencidas, ordenadas según lo estipulado.");
        ArrayList<Tarea2> tareasRestantes = admintarea.tareasOrdenadas();

        for (Tarea2 tarea : tareasRestantes) {
            System.out.println("\n" + tarea);
            System.out.println("Prioridad: " + tarea.getPrioridad());
            System.out.println("Fecha de vencimiento: " + tarea.getFechaLimite());
        }
    }
    private static void punto13 () {

        //TESTING PUNTO 13

        AdminTarea2 admintarea = new AdminTarea2();

        LocalDate hoy = LocalDate.now();

        admintarea.crearTarea("Ordenar dormitorio", 3, hoy.plusDays(4),
                hoy.plusDays(2));
        admintarea.crearTarea("Limpiar platos", 5, hoy.plusDays(5),
                hoy.plusDays(2));
        admintarea.crearTarea("Estudiar", 3, hoy.plusDays(3),
                hoy);
        admintarea.crearTarea("Cocinar", 1, hoy,
                hoy);
        admintarea.crearTarea("Poner lavarropas", 1, hoy.plusDays(1),
                hoy);
        admintarea.crearTarea("Ir al cine", 15, hoy.plusDays(3),
                hoy.plusDays(1));
        admintarea.crearTarea("Dormir", 45, hoy.plusDays(7),
                hoy.plusDays(5));

        admintarea.crearTarea("Hacer ejercicio", 1, hoy.plusDays(1),
                hoy);
        admintarea.crearTarea("Trabajar", 3,
                hoy.plusDays(7), hoy.plusDays(4));

        admintarea.agregarColaborador(new Colaborador("Nazarena Gonzalez"));
        admintarea.agregarColaborador(new Colaborador("Jose Leon"));

        admintarea.marcarTareaNCompletada(1, 1, hoy);
        admintarea.marcarTareaNCompletada(2, 1, hoy);
        admintarea.marcarTareaNCompletada(3, 1, hoy);
        admintarea.marcarTareaNCompletada(4, 1, hoy);
        admintarea.marcarTareaNCompletada(5, 1, hoy);
        admintarea.marcarTareaNCompletada(6, 1, hoy);
        admintarea.marcarTareaNCompletada(7, 1, hoy);

        admintarea.marcarTareaNCompletada(8, 2, hoy);
        admintarea.marcarTareaNCompletada(9, 2, hoy);

        ArrayList<Tarea3> tareasCompletadasPorColaborador1 = admintarea.getTareasCompletadasPorM(1);

        System.out.println("\nEl colaborador: " + admintarea.getColaboradorM(1));
        System.out.println("Ha completado las siguientes tareas: ");

        for (Tarea3 tarea : tareasCompletadasPorColaborador1) {System.out.println("\n-"+tarea.getDescripcion());}

        ArrayList<Tarea3> tareasCompletadasPorColaborador2 = admintarea.getTareasCompletadasPorM(2);

        System.out.println("\nEl colaborador: " + admintarea.getColaboradorM(2));
        System.out.println("Ha completado las siguientes tareas: ");
        for (Tarea3 tarea : tareasCompletadasPorColaborador2) {System.out.println("\n-"+tarea.getDescripcion());}
    }
}
