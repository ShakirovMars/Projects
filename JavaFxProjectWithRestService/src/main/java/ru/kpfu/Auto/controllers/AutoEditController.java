package ru.kpfu.Auto.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.kpfu.AutoFx.application.MainApp;
import ru.kpfu.AutoFx.models.Auto;

public class AutoEditController {
	@FXML
    private TextField modelField;
    @FXML
    private TextField costField;
    @FXML
    private TextField yearField;
    @FXML
    private TextField typeField;
    
   

	

    private Stage dialogStage;
    private Auto auto;
    private boolean okClicked = false;
    
 // ������ �� ������� ����������.
 		private MainApp mainApp;

 		// ���������� ������� �����������, ������� ��� �� ���� ������.

 		public void setMainApp(MainApp mainApp) {
 			this.mainApp = mainApp;
 		}

  
//     �������������� �����-����������. ���� ����� ���������� �������������
//    ����� ����, ��� fxml-���� ����� ��������.
    
    @FXML
    private void initialize() {
    }

    
//      ������������� ����� ��� ����� ����.
     
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

//    ����� ����������, ���������� � ������� ����� ������.
    
    public void setAuto(Auto auto) {
        this.auto = auto;

        modelField.setText(auto.getModel());
        costField.setText(Integer.toString(auto.getCost()));
        yearField.setText(Integer.toString(auto.getYearAuto()));
        typeField.setText(auto.getTypeAuto());
        
    }

//     Returns true, ���� ������������ ������� OK, � ������ ������ false.
     
    public boolean isOkClicked() {
        return okClicked;
    }

    
//      ����������, ����� ������������ ������� �� ������ OK.
     
    @FXML
    private void handleOk() throws Exception {
        if (isInputValid()) {
        	auto.setModel(modelField.getText());
            auto.setCost(Integer.parseInt(costField.getText()));
            auto.setTypeAuto(typeField.getText());
            auto.setYearAuto(Integer.parseInt(yearField.getText()));
            mainApp.getAutoService().update(auto);
            okClicked = true;
            dialogStage.close();
        }
    }

    
//     ����������, ����� ������������ ������� �� ������ Cancel.
     
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

   
//      ��������� ���������������� ���� � ��������� �����.
   
    private boolean isInputValid() {
        String errorMessage = "";

        if (modelField.getText() == null || modelField.getText().length() == 0) {
            errorMessage += "�� ������� �������� ������\n"; 
        }
        if (costField.getText() == null || costField.getText().length() == 0) {
            errorMessage += "�� ������� ���� ����������\n"; 
        }else {
            try {
                Integer.parseInt(costField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "������� ���������� ����!\n"; 
            }
        }
        if (typeField.getText() == null || typeField.getText().length() == 0) {
            errorMessage += "�� ������ ��� ����������\n"; 
        }

        if (yearField.getText() == null || yearField.getText().length() == 0) {
            errorMessage += "�� ������ ��� ����������\n"; 
        } else {
        	
            try {
                Integer.parseInt(yearField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "������� ���������� ���!\n"; 
            }
        }

     
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // ���������� ��������� �� ������.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("������������ ����");
            alert.setHeaderText("���������� ��������� ����");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

}
