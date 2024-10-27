package com.mycompany.libro;

public class Libro {
    private final int isbn;
    private final String nombreLibro;
    private boolean utilizando;

    public Libro(int isbn, String nombreLibro) {
        this.isbn = isbn;
        this.nombreLibro = nombreLibro;
        this.utilizando = false;
    }

    public int obtenerIsbn() {
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
            System.out.println("Libro " + nombreLibro + ", (ISBN: " + isbn + ") se esta prestando.");
        } else {
            System.out.println("Libro " + nombreLibro + ", (ISBN: " + isbn + ") se a devuelto.");
        }
    }
}