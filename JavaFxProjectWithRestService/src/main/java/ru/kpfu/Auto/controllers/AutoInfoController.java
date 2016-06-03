package ru.kpfu.Auto.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.kpfu.AutoFx.models.Auto;

public class AutoInfoController {

	    @FXML
	    private TextField idLabel;
	    @FXML
	    private TextField costLabel;
	    @FXML
	    private TextField yearLabel;
	    @FXML
	    private TextField typeLabel;
	    @FXML
	    private TextField modelLabel;
	    


	    private Stage dialogStage;
	    private boolean okClicked = false;

	    
//	      Инициализирует класс-контроллер. Этот метод вызывается автоматически
//	      после того, как fxml-файл будет загружен.
	     
	    @FXML
	    private void initialize() {
	    }

//	     Устанавливает сцену для этого окна.
	    
	    public void setDialogStage(Stage dialogStage) {
	        this.dialogStage = dialogStage;
	    }

	    
	    public void setPerson(Auto auto) {
	        idLabel.setText(Integer.toString(auto.getId()));
	        costLabel.setText(Integer.toString(auto.getCost()));
	        yearLabel.setText(Integer.toString(auto.getYearAuto()));
	        typeLabel.setText(auto.getTypeAuto());
	        modelLabel.setText(auto.getModel());
	    
	    }

	
	    public boolean isOkClicked() {
	        return okClicked;
	    }

	  
	    @FXML
	    private void handleOk() {
	    

	            okClicked = true;
	            dialogStage.close();
	        }
	}