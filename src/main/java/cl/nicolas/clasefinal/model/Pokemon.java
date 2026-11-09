package cl.nicolas.clasefinal.model;

public abstract class Pokemon {

    private String nombre;
    private int nivel;
    private double peso;


    public Pokemon() {
    }

    public Pokemon(String nombre, int nivel, double peso) {
        setNombre(nombre);
        setNivel(nivel);
        setPeso(peso);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public abstract double calcularCostoCuracion();

    public abstract String getTipo();

    @Override
    public String toString() {
        return "Pokemon{" +
                "nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", peso=" + peso +
                '}';
    }
}
