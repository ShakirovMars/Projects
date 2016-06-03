package ru.kpfu.AutoFx.application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.kpfu.Auto.controllers.AutoEditController;
import ru.kpfu.Auto.controllers.AutoInfoController;
import ru.kpfu.Auto.controllers.MainController;
import ru.kpfu.Auto.services.AutoService;
import ru.kpfu.Auto.services.HttpService;
import ru.kpfu.AutoFx.models.Auto;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	private HttpService httpService;
	private AutoService autoService;

	public MainApp() {
		this.autoService = new AutoService();
		this.httpService = new HttpService();
		this.autoService.setMainApp(this);
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Cars");
		this.primaryStage.setResizable(false);

		// Устанавливаем иконку приложения.
		this.primaryStage.getIcons().add(new Image("/images/muscle_car.png"));

		initRootLayout();

		showAutoOverview();
	}

	public HttpService getHttpService() {
		return httpService;
	}

	public AutoService getAutoService() {
		return autoService;
	}
	// Инициализирует корневой макет.

	public void initRootLayout() {
		try {
			// Загружаем корневой макет из fxml файла.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/views/Main.fxml"));
			rootLayout = (BorderPane) loader.load();

			// Отображаем сцену, содержащую корневой макет.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Показывает в корневом макете сведения об автомобилях.

	public void showAutoOverview() {
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/views/Auto.fxml"));
			AnchorPane autoOverview = (AnchorPane) loader.load();

			// Даём контроллеру доступ к главному приложению.
			MainController controller = loader.getController();
			controller.setMainApp(this);

			rootLayout.setCenter(autoOverview);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Возвращает главную сцену.

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}

	// Открывает диалоговое окно для изменения деталей указанного автомобиля.
	// Если пользователь кликнул OK, то изменения сохраняются в предоставленном
	// объекте адресата и возвращается значение true.

	// возвращает true, если пользователь кликнул OK, в противном случае false.

	public boolean showAutoEditDialog(Auto auto) {
		try {
			// Загружаем fxml-файл и создаём новую сцену
			// для всплывающего диалогового окна.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/views/AutoEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Создаём диалоговое окно Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Auto");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Передаём авто в контроллер.
			AutoEditController controller = loader.getController();
			controller.setMainApp(this);
			controller.setDialogStage(dialogStage);
			controller.setAuto(auto);

			// Отображаем диалоговое окно и ждём, пока пользователь его не
			// закроет
			dialogStage.setResizable(false);
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean showAutoInfoDialog(Auto auto) {
		try {
			// Загружаем fxml-файл и создаём новую сцену
			// для всплывающего диалогового окна.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/views/InfoDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Создаём диалоговое окно Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Auto Info");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			AutoInfoController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setPerson(auto);

			// Отображаем диалоговое окно и ждём, пока пользователь его не
			// закроет
			dialogStage.setResizable(false);
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
