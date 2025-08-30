package ar.edu.unlu.ng190217.tp1.punto6;

public class Libro {
    //***ATRUBUTOS***
    private String titulo;
    private String autor;
    private int isbn;
    private int paginas;
    private int totalEjemplares;
    private int totalDisponibles;
    private static int totalPrestamos;

    //***METODOS PUBLICOS***
    public Libro (String titulo, String autor, int isbn, int paginas, int totalEjemplares, int totalDisponibles) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.paginas = paginas;
        this.totalEjemplares = totalEjemplares;
        this.totalDisponibles = totalDisponibles;
        totalPrestamos += (totalEjemplares - totalDisponibles);
    }

    public void setTotalDisponibles (int totalDisponibles) { this.totalDisponibles = totalDisponibles; }

    public String getTitulo () {return titulo; }
    public String getAutor () {return autor; }
    public int getIsbn () {return isbn; }
    public int getPaginas () {return paginas; }
    public int getTotalEjemplares () {return totalEjemplares; }
    public int getTotalDisponibles () {return totalDisponibles; }
    public int totalPrestadosLibro () {return (totalEjemplares - totalDisponibles); }

    public void devolver () {
        if (totalDisponibles == totalEjemplares) {
            System.out.println("Devolución no habilitada.");
            System.out.println("Todos los ejemplares del libro están disponibles.");
        } else { totalDisponibles++;}
    }

    public void prestar () {
        if (totalDisponibles == 1) {
            System.out.println("Libro no habilitado para préstamo.");
            System.out.println("Sólo 1 ejemplar disponible.");
        } else {totalDisponibles--; }
    }

    public static void totalPrestados() {System.out.println("El total de libros prestados es: " + totalPrestamos); }

    public boolean tieneMasPaginasQue (Libro libro) {return (paginas > libro.getPaginas()); }

    public String toString() {
        return ("El libro " + titulo + " creado por el autor " + autor + " tiene " + paginas
                + " páginas,\nquedan " + totalDisponibles + " disponibles y se prestaron "
                + this.totalPrestadosLibro());
    }
}
