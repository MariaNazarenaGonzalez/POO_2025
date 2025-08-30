package ar.edu.unlu.ng190217.tp1.punto8;

import java.util.Scanner;

public class Contrasenia {
    //***ATRIBUTOS***
    private int longitud;
    private String cuerpo;

    //***METODOS PRIVADOS***
    private void agregarNumero () {
        int nuevoNumero = (int) (Math.random() * 10);
        cuerpo = cuerpo.concat("" + nuevoNumero);
    }

    private void agregarLetra (int tipo) {
        char nuevaLetra = ' ';
        char selectorLetra = (char) ( Math.random() * 25);
        nuevaLetra = (char)(selectorLetra + tipo);
        cuerpo = cuerpo.concat(""+nuevaLetra);
    }

    private void agregarAlfabetico () {
        int determinanteMinoMay = (int) (Math.random() * 50);
        if (determinanteMinoMay <= 25) {
            agregarLetra(97); //valor ascii de la primer minuscula
        } else {
            agregarLetra(65); //valor ascii de la primer mayuscula
        }
    }

    private void generarCuerpo (int longitud) {
        int determinanteLoN = 0; //Determina aleatoriamente si el caracter a generar es alfabetico o numérico
        for (int i = 0; i < longitud; i++) {
            determinanteLoN = (int) (Math.random() * 201);
            if (determinanteLoN <= 100) {agregarNumero();
            } else {agregarAlfabetico();}
        }
    }

    private void generarContraseniaFuerte () {
        cuerpo = "";
        if (longitud < 7) { longitud = 7;}
        for (int i = 0; i < 3; i++) {agregarLetra(65);}
        for (int j = 0; j < 2; j++) {agregarLetra(97);}
        for (int k = 0; k < 2; k++) {agregarNumero();}
        if (longitud > 7) {
            int resto = longitud - 7;
            for (int l = 0; l < resto; l++) {generarCuerpo(1);}
        }
    }

    //***CONSTRUCTORES***
    public Contrasenia () {
        longitud = 8;
        cuerpo = "";
        generarCuerpo(8);
    }

    public Contrasenia (int longitud) {
        cuerpo = "";
        this.setLongitud(longitud);
    }

    //***METODOS PUBLICOS***

    public String getContrasenia () {return cuerpo;}
    public int getLongitud () {return longitud;}

    public void setLongitud (int longitud) {
        Scanner sc = new Scanner(System.in);
        while (longitud < 1) {
            System.out.println("La longitud de la contrasenia debe ser positiva.");
            System.out.println("Introduzca una longitud válida: ");
            longitud = sc.nextInt();
        }
        this.longitud = longitud;
        generarCuerpo(this.longitud);
        System.out.println("Se ha generado la contraseña acorde a la longitud solicitada.");
    }

    public void regenerarContrasenia () {generarContraseniaFuerte();}

    public boolean esFuerte () {
        int contNum = 0;
        int contMin = 0;
        int contMay = 0;
        char aux = ' ';
        for (int i = 0; i < longitud; i++) {
            aux = cuerpo.charAt(i);
            if( (aux > 47) & (aux < 58) ) { contNum++;
            } else if ( (aux > 64) & (aux <  91) ) {contMay++;
            } else if ( (aux > 96) & (aux <  123) ) {contMin++;}
        }
        return ( (contNum >= 2) & (contMay > 2) & (contMin > 1) );
    }

    public String toString () {
        String aMostrar = cuerpo;
        if (esFuerte()) {aMostrar = aMostrar.concat(" - Fuerte\n");
        } else {aMostrar = aMostrar.concat(" - Débil\n");}
        return aMostrar;
    }
}
