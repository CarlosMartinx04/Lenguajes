package org.example.lenguajes;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class HelloController implements Initializable {
    private ResourceBundle bundle;
    @FXML
    private Menu menuArchivo = new Menu();
    @FXML
    private Menu menuEditar = new Menu();
    @FXML
    private Menu menuAyuda = new Menu();
    @FXML
    private TreeItem treeItemPRINCIPAL = new TreeItem<>();
    @FXML
    private TreeItem treeItemMANAGEMENT = new TreeItem<>();
    @FXML
    private TreeItem treeItemUSERS = new TreeItem<>();
    @FXML
    private TreeItem treeItemPERMITS = new TreeItem<>();
    @FXML
    private TreeItem treeItemROLES = new TreeItem<>();

    @FXML
    private TableView table = new TableView();
    @FXML
    private Button btnADDuser = new Button();
    @FXML
    private Button btnEDITuser = new Button();
    @FXML
    private Button btnDELETEuser = new Button();
    @FXML
    private Button btnUPDATEuser = new Button();

    @FXML
    private Label labelDetails = new Label();
    @FXML
    private Label labelInformationDetails = new Label();
    @FXML
    private ComboBox cbBoxLenguaje = new ComboBox<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setLanguage(Locale.getDefault());
        SetLanguageNames();
        cbBoxLenguaje.setValue(bundle.getString("cb.language.spanish"));
        cbBoxLenguaje.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals(bundle.getString("cb.language.spanish"))) {
                setLanguage(Locale.forLanguageTag("es_ES"));
                cbBoxLenguaje.setValue(bundle.getString("cb.language.spanish"));
            } else if (newValue.equals(bundle.getString("cb.language.english"))) {
                setLanguage(Locale.forLanguageTag("en"));
                cbBoxLenguaje.setValue(bundle.getString("cb.language.english"));
            }
            SetLanguageNames();
        });

    }



    private void SetLanguageNames() {
        cbBoxLenguaje.getItems().clear();
        cbBoxLenguaje.getItems().addAll(
                bundle.getString("cb.language.spanish"),
                bundle.getString("cb.language.english")
        );
    }
    private void setLanguage(Locale locale) {
        // Cambiar el ResourceBundle según el idioma seleccionado
        bundle = ResourceBundle.getBundle("i18n/Messages", locale);
        // Actualizar los textos de los Labels
        menuArchivo.setText(bundle.getString("menu.archiveText"));
        menuEditar.setText(bundle.getString("menu.editText"));
        menuAyuda.setText(bundle.getString("menu.helpText"));
        treeItemPRINCIPAL.setValue(bundle.getString("tree.itemPrincipalText"));
        treeItemMANAGEMENT.setValue(bundle.getString("tree.itemManagementText"));
        treeItemUSERS.setValue(bundle.getString("tree.itemUsersText"));
        treeItemPERMITS.setValue(bundle.getString("tree.itemPermitsText"));
        treeItemROLES.setValue(bundle.getString("tree.itemRolesText"));

        table.setAccessibleText(bundle.getString("table.tableText"));
        btnADDuser.setText(bundle.getString("btn.addText"));
        btnDELETEuser.setText(bundle.getString("btn.deleteText"));
        btnEDITuser.setText(bundle.getString("btn.editText"));
        btnUPDATEuser.setText(bundle.getString("btn.updateText"));



        labelDetails.setText(bundle.getString("lbl.labelDetails"));
        labelInformationDetails.setText(bundle.getString("lbl.labelInformationDetails"));
//        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, locale);
//        dateLabel.setText(dateFormat.format(now));
//        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
//        currencyLabel.setText(currencyFormat.format(currency));
    }


}
