package ar.edu.unlu.ng190217.tp1.punto2;

public class ListaDobleEnlace {
    //***ATRIBUTOS***
    private NodoListaDoble inicio;
    private int cantNodos;

    //***METODOS PRIVADOS***

    //Retorna el último elemento de la lista.
    private NodoListaDoble último() {
        NodoListaDoble nIterador = inicio;
        while (nIterador.getProximo() != null) { nIterador = nIterador.getProximo(); }
        return nIterador;
    }

    //retorna el nodo de la posición n
    private NodoListaDoble getNodoN (int n) {
        NodoListaDoble nodoN = null;
        if ( !(this.es_vacia()) && !(this.longitud() < n) ) {
            nodoN = inicio;
            for (int i = 1; i < n; i++) { nodoN = nodoN.getProximo();}
        }
        return nodoN;
    }

    //***METODOS PUBLICOS***

    //Metodo constructor
    public ListaDobleEnlace () {
        inicio = null;
        cantNodos = 0;
    }


    public boolean es_vacia() {return (inicio == null); }

    public int longitud () { return cantNodos; }

    //Agrega un objeto al final de la lista
    public void agregar (Object data) {
        NodoListaDoble nuevoNodo = new NodoListaDoble();
        nuevoNodo.setData(data);
        if (this.es_vacia()) { inicio = nuevoNodo;
        } else {
            NodoListaDoble ultimo = this.último();
            ultimo.setProximo(nuevoNodo);
            nuevoNodo.setAnterior(ultimo);
        }
        cantNodos++;
    }

    //Borra todad las apariciones de un objeto dado
    public void borrar (Object data) {
        if (this.es_vacia()) {
            System.out.println("Sin elementos eliminables.");
        } else if (cantNodos == 1) {
            //Sólo un nodo en lista
            if (inicio.getData().equals(data)) {
                inicio = null;
            }
        } else {
            while (inicio.getData().equals(data)) {
                //Borra inicio siempre que contenga datos eliminiables
                inicio = inicio.getProximo();
                inicio.setAnterior(null);
                cantNodos--;
            }
            if (cantNodos > 1) {
                //no entre si el while previo vacio la lista
                NodoListaDoble nActual = inicio;
                NodoListaDoble nAnterior = inicio;
                while (nActual != null) {
                    if (nActual.getData().equals(data)) {
                        nAnterior.setProximo(nActual.getProximo());
                        nActual = nActual.getProximo();
                        if(nActual != null) {
                            nActual.setAnterior(nAnterior);
                        }
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
            NodoListaDoble nodoN = this.getNodoN(posicion);
            data = nodoN.getData();
        }
        return data;
    }

    //Agregar un objeto en una posicion determinada de la lista
    public void agregarEnPosicion (Object data, int posicion) {
        if ( (this.es_vacia()) || (posicion == cantNodos + 1) ) { this.agregar(data);
        } else if ( (posicion < 1) || (posicion > cantNodos+1) ) {
            System.out.println("Posicion no valida.");
        } else if (posicion == 1) {
            NodoListaDoble nuevoNodo = new NodoListaDoble();
            nuevoNodo.setData(data);
            nuevoNodo.setProximo(inicio);
            inicio.setAnterior(nuevoNodo);
            inicio = nuevoNodo;
            cantNodos++;
        } else {
            NodoListaDoble nAnterior = this.getNodoN(posicion - 1);
            NodoListaDoble nPosterior = nAnterior.getProximo();
            NodoListaDoble nuevoNodo = new NodoListaDoble();
            nuevoNodo.setData(data);
            nuevoNodo.setProximo(nPosterior);
            nuevoNodo.setAnterior(nAnterior);
            nPosterior.setAnterior(nuevoNodo);
            nAnterior.setProximo(nuevoNodo);
            cantNodos++;
        }
    }

    public String toString () {
        String cadenaLista = new String("Lista: ");
        NodoListaDoble nIterador = inicio;
        for (int i = 0; i < cantNodos; i++) {
            cadenaLista = cadenaLista.concat(nIterador.getData().toString()+" ");
            nIterador = nIterador.getProximo();
        }
        return cadenaLista;
    }

}
