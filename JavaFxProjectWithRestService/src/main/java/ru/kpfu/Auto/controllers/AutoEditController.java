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
    
 // Ссылка на главное приложение.
 		private MainApp mainApp;

 		// Вызывается главным приложением, которое даёт на себя ссылку.

 		public void setMainApp(MainApp mainApp) {
 			this.mainApp = mainApp;
 		}

  
//     Инициализирует класс-контроллер. Этот метод вызывается автоматически
//    после того, как fxml-файл будет загружен.
    
    @FXML
    private void initialize() {
    }

    
//      Устанавливает сцену для этого окна.
     
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

//    Задаёт автомобиль, информацию о котором будем менять.
    
    public void setAuto(Auto auto) {
        this.auto = auto;

        modelField.setText(auto.getModel());
        costField.setText(Integer.toString(auto.getCost()));
        yearField.setText(Integer.toString(auto.getYearAuto()));
        typeField.setText(auto.getTypeAuto());
        
    }

//     Returns true, если пользователь кликнул OK, в другом случае false.
     
    public boolean isOkClicked() {
        return okClicked;
    }

    
//      Вызывается, когда пользователь кликнул по кнопке OK.
     
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

    
//     Вызывается, когда пользователь кликнул по кнопке Cancel.
     
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

   
//      Проверяет пользовательский ввод в текстовых полях.
   
    private boolean isInputValid() {
        String errorMessage = "";

        if (modelField.getText() == null || modelField.getText().length() == 0) {
            errorMessage += "Не введено название модели\n"; 
        }
        if (costField.getText() == null || costField.getText().length() == 0) {
            errorMessage += "Не введена цена автомобиля\n"; 
        }else {
            try {
                Integer.parseInt(costField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Укажите корректную цену!\n"; 
            }
        }
        if (typeField.getText() == null || typeField.getText().length() == 0) {
            errorMessage += "Не введен тип автомобиля\n"; 
        }

        if (yearField.getText() == null || yearField.getText().length() == 0) {
            errorMessage += "Не введен год автомобиля\n"; 
        } else {
        	
            try {
                Integer.parseInt(yearField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Укажите корректный год!\n"; 
            }
        }

     
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Показываем сообщение об ошибке.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Некорректные поля");
            alert.setHeaderText("Пожалуйста исправьте поля");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

}
