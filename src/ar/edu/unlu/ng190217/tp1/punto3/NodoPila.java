package ar.edu.unlu.ng190217.tp1.punto3;

public class NodoPila {
    //***ATRIBUTOS***
    private Object data;
    private NodoPila proximo = null;

    //***METODOS PUBLICOS***
    public void setData (Object data) { this.data = data; }
    public void setProximo (NodoPila proximo) { this.proximo = proximo; }

    public Object getData () { return data; }
    public NodoPila getProximo () { return proximo; }
}
