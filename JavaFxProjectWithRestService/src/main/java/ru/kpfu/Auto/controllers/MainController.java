package ru.kpfu.Auto.controllers;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import ru.kpfu.AutoFx.application.MainApp;
import ru.kpfu.AutoFx.models.Auto;

public class MainController {
	@FXML
	private TableView<Auto> autoTable;

	@FXML
	private TableColumn<Auto, String> modelColumn;
	@FXML
	private TableColumn<Auto, Integer> costColumn;
	@FXML
	private TableColumn deleteColumn;
	@FXML
	private TableColumn updateColumn;

	@FXML
	private TableColumn infoColumn;

	// Fields
	@FXML
	private TextField modelField;
	@FXML
	private TextField costField;
	@FXML
	private TextField yearField;
	@FXML
	private TextField typeField;

	@FXML
	private Label logging;

	

	private ObservableList data = FXCollections.observableArrayList();

	// Ссылка на главное приложение.
	private MainApp mainApp;

	// Вызывается главным приложением, которое даёт на себя ссылку.

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	@FXML
	public void initialize() {
		createTable();
	}

	public void createTable() {

		modelColumn.setCellValueFactory(new PropertyValueFactory("model"));

		costColumn.setCellValueFactory(new PropertyValueFactory("cost"));
		
	}

	
	@FXML
	public void showHandler(ActionEvent event) throws Exception {
		List<Auto> cars = mainApp.getAutoService().getCars();
		addAllCars(cars);
		logging.setText("Список автомобилей");

	}

	@FXML
	public void addHandler(ActionEvent event) throws Exception {
		String model = modelField.getText();
		String costStr = costField.getText();
		String yearStr = yearField.getText();
		String type = typeField.getText();

		
		if (isInputValid(model,costStr,yearStr,type)) {
			
			int	cost = Integer.parseInt(costStr);
			int	year = Integer.parseInt(yearStr);
			

			Auto auto = new Auto(model, year, cost, type);

			logging.setText(mainApp.getAutoService().add(auto));
			modelField.clear();
			costField.clear();
			yearField.clear();
			typeField.clear();
			List<Auto> cars = mainApp.getAutoService().getCars();
			addAllCars(cars);
		

		}

	}
	
	private boolean isInputValid(String model,String costStr,String yearStr,String typeField) {
        String errorMessage = "";

        if (model.isEmpty()) {
            errorMessage += "Не введено название модели\n"; 
        }
        if (costStr.isEmpty()) {
            errorMessage += "Не введена цена автомобиля\n"; 
        }else {
            try {
                Integer.parseInt(costStr);
            } catch (NumberFormatException e) {
                errorMessage += "Укажите корректную цену!\n"; 
            }
        }
        if (typeField.isEmpty()) {
            errorMessage += "Не введен тип автомобиля\n"; 
        }

        if (yearStr.isEmpty()) {
            errorMessage += "Не введен год автомобиля\n"; 
        } else {
        	
            try {
                Integer.parseInt(yearStr);
            } catch (NumberFormatException e) {
                errorMessage += "Укажите корректный год!\n"; 
            }
        }

     
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Показываем сообщение об ошибке.
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Некорректные поля");
            alert.setHeaderText("Пожалуйста исправьте поля");
            alert.setContentText(errorMessage);
            alert.showAndWait();

            return false;
        }
    }

	@SuppressWarnings("unchecked")
	private void addAllCars(List<Auto> cars) {
		if (cars != null) {
			data = FXCollections.observableArrayList(cars);
			autoTable.setItems(data);
		}
		// Insert Delete Button
		deleteColumn.setCellFactory(new Callback<TableColumn<Auto, Boolean>, TableCell<Auto, Boolean>>() {
			public TableCell<Auto, Boolean> call(TableColumn<Auto, Boolean> p) {
				return new DeleteButton();
			}

		});

		/// Insert Update Button

		updateColumn.setCellFactory(new Callback<TableColumn<Auto, Boolean>, TableCell<Auto, Boolean>>() {
			public TableCell<Auto, Boolean> call(TableColumn<Auto, Boolean> p) {
				return new UpdateButton();
			}

		});

		// Insert Info Button
		infoColumn.setCellFactory(new Callback<TableColumn<Auto, Boolean>, TableCell<Auto, Boolean>>() {
			public TableCell<Auto, Boolean> call(TableColumn<Auto, Boolean> p) {
				return new InfoButton();
			}

		});

	}

	// delete
	private class DeleteButton extends TableCell<Auto, Boolean> {
		final Button deleteButton = new Button();
		final ImageView buttonGraphic = new ImageView();

		DeleteButton() {
			buttonGraphic.setImage(new Image("/images/delete.png"));
			deleteButton.setGraphic(buttonGraphic);
			deleteButton.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent t) {
					int selectedIndex = getTableRow().getIndex();
					Auto selectedAuto = (Auto) autoTable.getItems().get(selectedIndex);
					try {
						logging.setText(mainApp.getAutoService().delete(selectedAuto));

						List<Auto> cars = mainApp.getAutoService().getCars();
						addAllCars(cars);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		// Display button if the row is not empty
		@Override
		protected void updateItem(Boolean t, boolean empty) {
			super.updateItem(t, empty);
			if (!empty) {

				setGraphic(deleteButton);
			}
		}
	}

	// update
	private class UpdateButton extends TableCell<Auto, Boolean> {
		final Button updateButton = new Button();
		final ImageView buttonGraphic = new ImageView();

		UpdateButton() {
			buttonGraphic.setImage(new Image("/images/edit.png"));
			updateButton.setGraphic(buttonGraphic);
			updateButton.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent t) {
					int selectdIndex = getTableRow().getIndex();

					// Create a new table show details of the selected item
					Auto selectedAuto = (Auto) autoTable.getItems().get(selectdIndex);
					if (selectedAuto != null) {
						boolean okClicked = mainApp.showAutoEditDialog(selectedAuto);
						if (okClicked) {
							List<Auto> cars = mainApp.getAutoService().getCars();
							addAllCars(cars);
							logging.setText("Автомобиль успешно обновлен");
						}

					}
				}
			});
		}

		// Display button if the row is not empty
		@Override
		protected void updateItem(Boolean t, boolean empty) {
			super.updateItem(t, empty);
			if (!empty) {
				setGraphic(updateButton);
			}
		}
	}

	// info
	private class InfoButton extends TableCell<Auto, Boolean> {
		final Button infoButton = new Button();
		final ImageView buttonGraphic = new ImageView();

		InfoButton() {
			buttonGraphic.setImage(new Image("/images/info.png"));
			infoButton.setGraphic(buttonGraphic);
			infoButton.setOnAction(new EventHandler<ActionEvent>() {

				public void handle(ActionEvent t) {
					int selectdIndex = getTableRow().getIndex();

					// Create a new table show details of the selected item
					Auto selectedAuto = (Auto) autoTable.getItems().get(selectdIndex);
					if (selectedAuto != null) {
						boolean okClicked = mainApp.showAutoInfoDialog(selectedAuto);
						if (okClicked) {
							logging.setText("");

						}

					}
				}
			});
		}

		// Display button if the row is not empty
		@Override
		protected void updateItem(Boolean t, boolean empty) {
			super.updateItem(t, empty);
			if (!empty) {
				setGraphic(infoButton);
			}
		}
	}

}
