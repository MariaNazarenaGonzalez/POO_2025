package ar.edu.unlu.ng190217.tp1.punto7;

import static java.lang.Math.sqrt;

public class EcSegundoGrado {
    //***ATRIBUTOS***
    private double a;
    private double b;
    private double c;

    //***METODOS PRIVADOS***
    private double discriminante () {return ( (b*b) - (4*a*c) );}
    private double calcularRaizPositiva () {return ( ((-1)*b) + sqrt(this.discriminante()) );}
    private double calcularRaizNegativa () {return ( ((-1)*b) - sqrt(this.discriminante()) );}

    //***METODOS PUBLICOS***
    public EcSegundoGrado(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    //retorna la|las raices de la ecuacion
    public double[] obtenerRaices () {
        double[] raices = new double[2];
        if (this.discriminante() < 0) {System.out.println("\nLa ecuación no tiene raíces.\n");
        } else if (this.discriminante() == 0) {
            double raizUnica = this.calcularRaizPositiva();
            raices[0] = raizUnica;
            raices[1] = raizUnica;
            System.out.println("\nRaíz única.");
        } else {
            raices[0] = this.calcularRaizNegativa();
            raices[1] = this.calcularRaizPositiva();
        }
        return raices;
    }
    //retorna un Y dado un X
    public double obtenerY (double x) {return ( (a*(x+x)) + (b*x) + c );}
}
