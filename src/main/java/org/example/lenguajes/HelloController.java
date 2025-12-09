package org.example.lenguajes;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private ResourceBundle bundle;
    @FXML
    private Label labelDetails = new Label();
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
        labelDetails.setText(bundle.getString("lbl.labelDetails"));
//        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, locale);
//        dateLabel.setText(dateFormat.format(now));
//        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
//        currencyLabel.setText(currencyFormat.format(currency));
    }


}
