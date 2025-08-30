package ar.edu.unlu.ng190217.tp1.punto1;

public class NodoListaSimple {
    //***ATRIBUTOS***
    private Object data;
    private NodoListaSimple proximo = null;

    //***METODOS PUBLICOS***
    public void setData (Object data) {this.data = data;}
    public void setProximo (NodoListaSimple proximo) {this.proximo = proximo;}

    public Object getData () {return data;}
    public NodoListaSimple getProximo () {return proximo;}

    public boolean haysiguente(){return this.getProximo() != null;}
}
