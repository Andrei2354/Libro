package com.mycompany.libro;

public class Libro {
    private final String isbn;
    private final String nombreLibro;
    private boolean utilizando;

    public Libro(String isbn, String nombreLibro) {
        this.isbn = isbn;
        this.nombreLibro = nombreLibro;
        this.utilizando = false;
    }

    public String obtenerIsbn() {
        return isbn;
    }

    public String obtenerNombreLibro() {
        return nombreLibro;
    }

    public synchronized boolean Estaocupado() {
        return utilizando;
    }

    public synchronized void setPrestado(boolean prestado) {
        this.utilizando = prestado;
        if (prestado) {
            System.out.println("Libro " + nombreLibro + ", ISBN: " + isbn +" se esta prestando.");
        } else {
            System.out.println("Libro " + nombreLibro + ", ISBN: " + isbn +" se a devuelto.");
        }
    }
}
