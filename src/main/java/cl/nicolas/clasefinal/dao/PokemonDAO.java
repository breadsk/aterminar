package cl.nicolas.clasefinal.dao;

import cl.nicolas.clasefinal.model.Pokemon;
import java.util.List;

public interface PokemonDAO {
    List<Pokemon> obtenerTodos();
    boolean guardar(Pokemon pokemon);
    boolean eliminar(Pokemon pokemon);
}
