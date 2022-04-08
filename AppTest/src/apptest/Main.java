/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptest;


import apptest.view.VentanaPrincipalController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *
 * @author DAM-2
 */
public class Main extends Application {

    private Stage stagePrincipal;
    @Override
    public void start(Stage stagePrincipal) throws Exception {
        this.stagePrincipal = stagePrincipal;
        mostrarPantallaPrincipal();
        //Admin();
       
    }

    public void mostrarPantallaPrincipal(){
        try {
            
            //Parent root = FXMLLoader.load(getClass().getResource("view/InicioFXML.fxml"));
            FXMLLoader loader = new FXMLLoader();                
            loader.setLocation(getClass().getResource("view/InicioFXML.fxml"));
            HBox page = (HBox) loader.load();
            stagePrincipal.setTitle("Menu principal");
            VentanaPrincipalController controller = loader.getController();
            controller.setMainApp(this);
            Scene scene = new Scene(page);
            //Scene scene = new Scene(root);
            stagePrincipal.setScene(scene);
            stagePrincipal.setResizable(false);
            //VentanaPrincipalController controller = loader.getController();
            //controller.setStagePrincipal(this);
            stagePrincipal.show();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void mostrarTestPrincipal(){
        try {
            
            //Parent root = FXMLLoader.load(getClass().getResource("view/InicioFXML.fxml"));
            FXMLLoader loader = new FXMLLoader();                
            loader.setLocation(getClass().getResource("view/UserTestFXML.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Scene scene = new Scene(page);
             Stage stageTestPrincipal = new Stage();
            stageTestPrincipal.setTitle("Menu Test Principal");
            stageTestPrincipal.setScene(scene);
            stageTestPrincipal.show();
            stageTestPrincipal.setResizable(false);
           
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void mostrarLoginAdmin(){
         try {
            
            FXMLLoader loader = new FXMLLoader();                
            loader.setLocation(getClass().getResource("view/AdminFXML.fxml"));
            HBox page = (HBox) loader.load();

         
             Scene scene = new Scene(page);
            Stage stageLoginAdmin = new Stage();
            stageLoginAdmin.setTitle("Menu Login Admin");
            stageLoginAdmin.setScene(scene);
            stageLoginAdmin.showAndWait();
            stageLoginAdmin.setResizable(false);
            
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
  

  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
