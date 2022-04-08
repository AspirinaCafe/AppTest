/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptest.view;

import apptest.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author DAM-2
 */
public class QuizViewController {

    private Main mainApp;		// Reference to the main application
    @FXML
    private Label question;	// The question
    @FXML
    private RadioButton rbA;
    @FXML
    private RadioButton rbB;
    @FXML
    private RadioButton rbC;
    @FXML
    private RadioButton rbD;

    @FXML
    private ToggleGroup rbGroup;

    private RadioButton[] rB;		
    @FXML
    private ProgressBar pB;
    @FXML
    private Button bNext;

    public QuizViewController() {
        question = new Label("");
        rbGroup = new ToggleGroup();
        pB = new ProgressBar(0);
    }

    @FXML
    private void initialize() {
        rB = new RadioButton[4];
        rB[0] = rbA;
        rB[1] = rbB;
        rB[2] = rbC;	
        rB[3] = rbD;
        rbA.setToggleGroup(rbGroup);
        rbB.setToggleGroup(rbGroup);
        rbC.setToggleGroup(rbGroup);
        rbD.setToggleGroup(rbGroup);
    }

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;	// Talk later but keep your number, Nanoo, Nanoo
    }

    private void keyPressed(KeyEvent ke) {

        switch (ke.getText()) {
            case "1":
                rb(rbA);
                break;
            case "2":
                rb(rbB);
                break;
            case "3":
                rb(rbC);
                break;
            case "4":
                rb(rbD);
                break;

            default:
                switch (ke.getCode().toString()) {
                    case "ENTER":
                        getNextQuiz();
                        break;
                    case "RIGHT_ARROW":
                        getNextQuiz();
                        break;
                    default:
                        break;
                }
        }
    }

    private void rb(RadioButton pressed) {
        if (pressed.isVisible()) {
            pressed.setSelected(true);
            bNext.setDisable(false);

        }

    }

    @FXML
    private void rbClicked() {
        bNext.setDisable(false);
    }

    @FXML
    private void bNext() {
        getNextQuiz();
    }

    private void getNextQuiz() {
        String picked = ((Labeled) rbGroup.getSelectedToggle()).getText();
        //mainApp.stepQuiz(picked);
    }
}
