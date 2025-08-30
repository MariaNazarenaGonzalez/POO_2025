package ar.edu.unlu.ng190217.tp1.punto1;

public class ListaSimpleEnlace {
    //***ATRIBUTOS***
    private NodoListaSimple inicio;
    private int cantNodos;

    //***METODOS PRIVADOS***

    //Retorna el último elemento de la lista.
    private NodoListaSimple último() {
        NodoListaSimple nIterador = inicio;
        while (nIterador.haysiguente()) {nIterador = nIterador.getProximo();}
        return nIterador;
    }

    //retorna el nodo de la posición n
    private NodoListaSimple getNodoN (int n) {
        NodoListaSimple nodoN = null;
        if ( !(this.es_vacia()) && !(this.longitud() < n) ) {
            nodoN = inicio;
            for (int i = 1; i < n; i++) {nodoN = nodoN.getProximo(); }
        }
        return nodoN;
    }

    //***METODOS PUBLICOS***

    //Metodo constructor
    public ListaSimpleEnlace() {
        inicio = null;
        cantNodos = 0;
    }

    public boolean es_vacia() {return (inicio == null);}

    public int longitud () {return cantNodos;}

    //Agrega un objeto al final de la lista
    public void agregar (Object data) {
        NodoListaSimple nuevoNodo = new NodoListaSimple();
        nuevoNodo.setData(data);
        if (this.es_vacia()) {inicio = nuevoNodo;
        } else {this.último().setProximo(nuevoNodo);
        }
        cantNodos++;
    }

    //Borra todad las apariciones de un objeto dado
    public void borrar (Object data) {
        if (this.es_vacia()) { System.out.println("Sin elementos eliminables.");
        } else if (cantNodos == 1) {
            //Sólo un nodo en la lista
            if (inicio.getData().equals(data)) { inicio = null; }
        } else {
            while (inicio.getData().equals(data)) {
                //Borra inicio siempre que contenga datos eliminiables
                inicio = inicio.getProximo();
                cantNodos--;
            }
            if (cantNodos > 1) {
                //no entre si el while previo vacio la lista
                NodoListaSimple nActual = inicio;
                NodoListaSimple nAnterior = inicio;
                while (nActual != null) {
                    if (nActual.getData().equals(data)) {
                        nAnterior.setProximo(nActual.getProximo());
                        nActual = nActual.getProximo();
                        cantNodos--;
                    } else {
                        nAnterior = nActual;
                        nActual = nActual.getProximo();
                    }
                }
            }
        }
    }

    //recupera un objeto de una posicion solicitada
    public Object recuperar (int posicion) {
        Object data = null;
        if (this.es_vacia()) { return data;
        } else if (posicion > cantNodos) { System.out.println("Posición inválida");
        } else {
            NodoListaSimple nodoN = this.getNodoN(posicion);
            data = nodoN.getData();
        }
        return data;
    }

    //Agregar un objeto en una posicion determinada de la lista
    public void agregarEnPosicion (Object data, int posicion) {
        if ( (this.es_vacia()) || (posicion == cantNodos + 1) ) {this.agregar(data);
        } else if ( (posicion < 1) || (posicion > cantNodos+1) ) {
            System.out.println("Posicion no valida.");
        } else if (posicion == 1) {
            NodoListaSimple nuevoNodo = new NodoListaSimple();
            nuevoNodo.setData(data);
            nuevoNodo.setProximo(inicio);
            inicio = nuevoNodo;
            cantNodos++;
        } else {
            NodoListaSimple nAnterior = this.getNodoN(posicion - 1);
            NodoListaSimple nPosterior = nAnterior.getProximo();
            NodoListaSimple nuevoNodo = new NodoListaSimple();
            nuevoNodo.setData(data);
            nuevoNodo.setProximo(nPosterior);
            nAnterior.setProximo(nuevoNodo);
            cantNodos++;
        }
    }

    public String toString () {
        String cadenaLista = new String("Lista: ");
        NodoListaSimple nIterador = inicio;
        for (int i = 0; i < cantNodos; i++) {
            cadenaLista = cadenaLista.concat(nIterador.getData().toString()+" ");
            nIterador = nIterador.getProximo();
        }
        return cadenaLista;
    }
}
