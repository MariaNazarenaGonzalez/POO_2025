package ar.edu.unlu.ng190217.tp1.punto3;

public class Pila {
    //***ATRIBUTOS***
    private int cantNodos = 0;
    private NodoPila tope = null;

    //***METODOS PUBLICOS***

    public boolean es_vacia () {return (tope == null); }

    public int longitud () { return cantNodos; }

    //Agrega un elemento en el tope de la pila
    public void apilar (Object data) {
        NodoPila nuevoNodo = new NodoPila();
        nuevoNodo.setData(data);
        if (this.es_vacia()) {tope = nuevoNodo;
        } else {
            nuevoNodo.setProximo(tope);
            tope = nuevoNodo;
        }
        cantNodos++;
    }
    //Quita un elemento del tope de la pila
    public Object desapilar () {
        Object data = null;
        if (this.es_vacia()) { System.out.println("No hay elementos para desapilar.");
        } else {
            data = tope.getData();
            tope = tope.getProximo();
            cantNodos--;
        }
        return data;
    }
    //Retorna el objeto del tope de la pila
    public Object recuperarTope () {return tope.getData(); }

    public String toString () {
        String pila = new String();
        NodoPila pIterador = tope;
        while (pIterador != null) {
            pila = pila.concat(pIterador.getData() + " ");
            pIterador = pIterador.getProximo();
        }
        return pila;
    }
}
