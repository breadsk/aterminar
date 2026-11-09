package cl.nicolas.clasefinal.controller;

import cl.nicolas.clasefinal.model.*;
import cl.nicolas.clasefinal.dao.PokemonDAO;
import cl.nicolas.clasefinal.dao.PokemonDAOFileImpl;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.scene.control.*;


public class PokemonController {

    @FXML private ComboBox<String> cmbTipo;
    @FXML private TextField txtNombre;
    @FXML private TextField txtNivel;
    @FXML private TextField txtPeso;
    @FXML private TextField txtEspecie;
    @FXML private CheckBox chkEspecifico;
    @FXML private CheckBox chkIntercambio;

    @FXML private TableView<Pokemon> tblPokemones;
    @FXML private TableColumn<Pokemon, String> colTipo;
    @FXML private TableColumn<Pokemon, String> colNombre;
    @FXML private TableColumn<Pokemon, Integer> colNivel;
    @FXML private TableColumn<Pokemon, Double> colPeso;
    @FXML private TableColumn<Pokemon, String> colCosto;


    private final PokemonDAO pokemonDAO = new PokemonDAOFileImpl();
    private final ObservableList<Pokemon> listaPokemones = FXCollections.observableArrayList();


    @FXML void initialize(){
        cmbTipo.setItems(FXCollections.observableArrayList("PokemonAgua","PokemonFuego"));
        cmbTipo.getSelectionModel().selectFirst();

        colTipo.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getClass().getSimpleName()));
        colNombre.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getNombre()));
        colNivel.setCellValueFactory(cell -> new SimpleIntegerProperty(cell.getValue().getNivel()).asObject());
        colPeso.setCellValueFactory(cell -> new SimpleDoubleProperty(cell.getValue().getPeso()).asObject());

        // muestro el costo con formato de moneda
        colCosto.setCellValueFactory(cell ->
                new SimpleStringProperty(String.format("$%,.0f",cell.getValue().calcularCostoCuracion())));



    }

    @FXML
    private void handleRegistrar(){

    }

}
