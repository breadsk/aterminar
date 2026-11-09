package cl.nicolas.clasefinal.dao;

import com.google.gson.*;
import cl.nicolas.clasefinal.model.Pokemon;
import cl.nicolas.clasefinal.model.PokemonAgua;
import cl.nicolas.clasefinal.model.PokemonFuego;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PokemonDAOFileImpl implements PokemonDAO {

    private static final String ARCHIVO_AGUA = "pokemonAgua.json";
    private static final String ARCHIVO_FUEGO = "pokemonFuego.json";

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();


    @Override
    public List<Pokemon> obtenerTodos() {
        List<Pokemon> lista = new ArrayList<>();
        lista.addAll(leerLista(ARCHIVO_AGUA,PokemonAgua[].class));
        lista.addAll(leerLista(ARCHIVO_FUEGO,PokemonFuego[].class));
        return lista;
    }

    private <T> List<T> leerLista(String archivo,Class<T[]> clazz){
        File file = new File(archivo);
        if(!file.exists()){
            return new ArrayList<>();
        }
        try(Reader reader = new FileReader(file)){
            T[] array = gson.fromJson(reader,clazz);
            return array != null ? new ArrayList<>(List.of(array)) : new ArrayList<>();
        }catch(IOException ex){
            return new ArrayList<>();
        }
    }

    public boolean guardar(Pokemon pokemon) {
        if(pokemon instanceof PokemonAgua){
            List<PokemonAgua> aguas = leerLista(ARCHIVO_AGUA,PokemonAgua[].class);
            aguas.add((PokemonAgua) pokemon);
            return escribir(ARCHIVO_AGUA,aguas);
        }else if(pokemon instanceof PokemonFuego){
            List<PokemonFuego> fuegos = leerLista(ARCHIVO_FUEGO,PokemonFuego[].class);
            fuegos.add((PokemonFuego) pokemon);
            return escribir(ARCHIVO_FUEGO,fuegos);
        }
        return false;
    }

    @Override
    public boolean eliminar(Pokemon pokemon){
        if(pokemon == null || pokemon.getNombre() == null){
            return false;
        }

        String nombreBusqueda = pokemon.getNombre();

        List<PokemonAgua> aguas = leerLista(ARCHIVO_AGUA,PokemonAgua[].class);
        boolean aguaEliminada = aguas.removeIf(a -> a.getNombre().equalsIgnoreCase(nombreBusqueda));
        if(aguaEliminada){
            escribir(ARCHIVO_AGUA,aguas);
        }

        List<PokemonFuego> fuegos = leerLista(ARCHIVO_FUEGO,PokemonFuego[].class);
        boolean fuegoEliminado = fuegos.removeIf(f -> f.getNombre().equalsIgnoreCase(nombreBusqueda));
        if(fuegoEliminado){
            escribir(ARCHIVO_FUEGO,fuegos);
        }

        return aguaEliminada || fuegoEliminado;

    }

    private boolean escribir(String archivo,Object objeto){
        try(Writer writer = new FileWriter(archivo)){
            gson.toJson(objeto,writer);
            return true;
        }catch(IOException ex){
            return false;
        }
    }
}
