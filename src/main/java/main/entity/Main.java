package main.entity;

public class Main {
    public static void main(String[] args) {
        Consultas con = new Consultas();

        con.personajes("Sinistra");

        con.masPuntos();

        con.puntosEntregados();

        con.close();
    }
}
