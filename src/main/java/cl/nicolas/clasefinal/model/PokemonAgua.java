package cl.nicolas.clasefinal.model;

/**
 * Pokemon de tipo agua atendido en el centro
 * participa en el programa de intercambio entre entrenadores
 * Costo de curacion: base $15.000 y si no esta entrenado , el recargo
 * será de un 30%
 */

public class PokemonAgua extends Pokemon implements Intercambiable {


    private static final double COSTO_BASE = 15000;
    private static final double RECARDO_NO_ENTRENADO = 0.30;

    private String especie;
    private boolean entrenado;
    private boolean disponibleIntercambio;

    public PokemonAgua() {
    }

    public PokemonAgua(String nombre, int nivel, double peso, String especie, boolean entrenado) {
        super(nombre, nivel, peso);
        this.especie = especie;
        this.entrenado = entrenado;
        this.disponibleIntercambio = false;
    }

    public String getEspecia(){
        return especie;
    }

    public void setEspecia(String especie){
        if(especie == null){
            throw new IllegalArgumentException("El especie no puede ser nulo");
        }
    }

    public boolean isEntrenado(){
        return entrenado;
    }

    public void setEntrenado(boolean entrenado){
        this.entrenado = entrenado;
    }

    @Override
    public boolean estaDisponibleParaIntercambio(){
        return disponibleIntercambio;
    }

    @Override
    public void marcarDisponibleParaIntercambio(){
        this.disponibleIntercambio = true;
    }

    @Override
    public double calcularCostoCuracion(){
        if(entrenado){
            return COSTO_BASE;
        }
        return COSTO_BASE + COSTO_BASE * RECARDO_NO_ENTRENADO;
    }

    @Override
    public String getTipo(){
        return "PokemonAgua";
    }

}
