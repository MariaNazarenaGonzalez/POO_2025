package ar.edu.unlu.ng190217.tp1.punto4;

public class NodoCola {
    //***ATRIBUTOS***
    private Object data;
    private NodoCola proximo = null;

    //***METODOS PUBLICOS***
    public void setData (Object data) {this.data = data; }
    public void setProximo (NodoCola proximo) { this.proximo = proximo; }

    public Object getData () {return data; }
    public NodoCola getProximo () {return proximo; }
}
