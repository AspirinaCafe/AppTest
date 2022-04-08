/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptest.view;

import apptest.Main;
import apptest.model.UserDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

/**
 *
 * @author DAM-2
 */
public class VentanaPrincipalController implements Initializable {

    private Main main;
    
    private UserDAO model;
    /**
     * EL USUARIO LOGIN
     */
    @FXML
    private TextField txtFUserL;

    @FXML
    private PasswordField txtFPassL;

    /**
     * EL USUARIO REGISTRO
     */
    @FXML
    private TextField txtFUserR;

    @FXML
    private PasswordField txtFPassR;

    /**
     * LOS BOTONES
     *
     */
    @FXML
    private Button buttonLogin;
    @FXML
    private Button buttonRegistro;
    @FXML
    private Button buttonAdmin;

    
     public void setMainApp(Main mainTest) {
        this.main = mainTest;

    }
    @FXML
    private void eventKey(KeyEvent event) {
        Object evt = event.getSource();
        /**
         * VALIDAR LOGIN INICIO SESION QUE NO LO DEJE EN BLANCO
         */
        if (evt.equals(txtFUserL)) {
            if (event.getCharacter().equals(" ")) {
                event.consume();
            }
        }
        if (evt.equals(txtFPassL)) {
            if (event.getCharacter().equals(" ")) {
                event.consume();
            }
        }

        /**
         * VALIDAR REGISTRO LOGIN QUE NO LO DEJE EN BLANCO
         */
        if (evt.equals(txtFUserR)) {
            if (event.getCharacter().equals(" ")) {
                event.consume();
            }
        }
        if (evt.equals(txtFPassR)) {
            if (event.getCharacter().equals(" ")) {
                event.consume();
            }
        }
    }

    @FXML
    private void eventAction(ActionEvent event) {

        Object evt = event.getSource();

        if (evt.equals(buttonLogin)) {

            if (!txtFUserL.getText().isEmpty() && !txtFPassL.getText().isEmpty()) {

                String user = txtFUserL.getText();
                String pass = txtFPassL.getText();

                int state = model.login(user, pass);

                if (state != -1) {

                    if (state == 1) {

                        mostrarMensajeInfo("Conectado ", "Datos correctos puede ingresar al sistema");
                        main.mostrarTestPrincipal();
                        //loadStage(event);

                    } else {
                        mostrarMensajeError("Error al iniciar sesión ", "Error al iniciar sesión datos de acceso incorrectos ADVERTENCIA");

                    }

                }

            } else {
                mostrarMensajeError("Error al conectar con la BD ", "Error al iniciar sesión datos de acceso incorrectos ADVERTENCIA");

            }

        }
        
        

    }

    @FXML
    public void ventanaLoginAdmin(ActionEvent event) {

        Object evt = event.getSource();

        if (evt.equals(buttonAdmin)) {

            main.mostrarLoginAdmin();
        }
       

    }

 

    private void mostrarMensajeInfo(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(mensaje);
        alerta.setContentText(null);
        alerta.showAndWait();
    }

    private void mostrarMensajeError(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(mensaje);
        alerta.setContentText(null);
        alerta.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
