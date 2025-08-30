package ar.edu.unlu.ng190217.tp1.punto2;

public class NodoListaDoble {
    //***ATRIBUTOS***
    private Object data;
    private NodoListaDoble anterior = null;
    private NodoListaDoble proximo = null;

    //***METODOS PUBLICOS***
    public void setData (Object data) {  this.data = data; }
    public void setAnterior (NodoListaDoble anterior) { this.anterior = anterior; }
    public void setProximo (NodoListaDoble proximo) { this.proximo = proximo; }

    public Object getData () { return data; }
    public NodoListaDoble getAnterior () { return anterior; }
    public NodoListaDoble getProximo () { return proximo; }
}
