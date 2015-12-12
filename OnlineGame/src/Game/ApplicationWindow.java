package Game;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class ApplicationWindow {
	public final static String TITLE = "Game- Cities";
	private JFrame nameWindow;
	private JFrame gameWindow;
	private JPanel mainPanel;
	private JPanel formPanel;
	private Font myFont;
	private JLabel nameLabel;
	private JLabel playerLabel;
	private JTextField nameField;
	private JTextField cityField;
	private JButton sendName;
	private JButton sendRespose;
	private JButton Surrender;
	private String PlayerResponse;
	private Player player = new Player();;
	private JDialog dialog;
	private JLabel dialogLabel;
	private JButton dialogButton;
	private String message;
	private JPanel buttonPanel;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPlayerResponse() {
		return PlayerResponse;
	}

	public void setPlayerResponse(String playerResponse) {
		PlayerResponse = playerResponse;
	}

	public void createWindow() {
		nameWindow = new JFrame(ApplicationWindow.TITLE);
		nameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		nameWindow.setSize(500, 400);
		nameWindow.setLocationRelativeTo(null);
		myFont = new Font("Verdana", 0, 18);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
			@Override
			public boolean dispatchKeyEvent(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					System.exit(0);
				}
				return false;
			}
		});

		mainPanel = new JPanel();
		formPanel = new JPanel();

		formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));

		nameLabel = new JLabel("Введите ваше имя:");
		nameLabel.setFont(myFont);
		nameLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		nameLabel.setMaximumSize(new Dimension(400, 20));
		formPanel.add(nameLabel);

		nameField = new JTextField();
		nameField.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		nameField.setMaximumSize(new Dimension(400, 20));
		formPanel.add(nameField);

		sendName = new JButton("Отправить");
		sendName.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		sendName.setMaximumSize(new Dimension(100, 20));
		formPanel.add(sendName);

		sendName.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (player.Connection()) {
					setPlayerResponse(nameField.getText().trim());
					if (PlayerResponse.isEmpty()) {
						setMessage("Вы не ввели имя");

					} else {

						player.sendRequest(PlayerResponse);
						String ServerRespons = player.getResponse();
						if (ServerRespons.equals("Пустые запросы не обрабатываются")) {
							setMessage(ServerRespons);
						} else {
							if (ServerRespons.equals("Ошибка сервера")) {
								setMessage(ServerRespons);
							} else {
								if (ServerRespons.equals("Пожалуйста, поменяйте свой ник")) {
									setMessage(ServerRespons);

								} else {

									player.ResenderStart(ServerRespons);
									clientStartGame();

									setMessage("Вы успешно зашли в игру");
								}
							}
						}
					}
				} else {
					setMessage("Ошибка сервера");
				}
				addDialog(message);

			}
		});

		mainPanel.add(formPanel);
		mainPanel.setBorder(new TitledBorder("Имя игрока"));
		nameWindow.getContentPane().add(mainPanel);

		nameWindow.setResizable(false);
		nameWindow.setVisible(true);

	}

	public void clientStartGame() {
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		nameWindow.setVisible(false);
		gameWindow = new JFrame(ApplicationWindow.TITLE);
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameWindow.setSize(500, 400);
		gameWindow.setLocationRelativeTo(null);
		mainPanel = new JPanel();
		formPanel = new JPanel();
		formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));

		playerLabel = new JLabel("Ваш ответ:");
		playerLabel.setFont(myFont);
		playerLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		playerLabel.setMaximumSize(new Dimension(400, 20));
		formPanel.add(playerLabel);

		cityField = new JTextField();
		cityField.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		cityField.setMaximumSize(new Dimension(400, 20));
		formPanel.add(cityField);

		sendRespose = new JButton("Отправить");
		sendRespose.setAlignmentX(JComponent.LEFT_ALIGNMENT);

		sendRespose.setMaximumSize(new Dimension(100, 20));
		buttonPanel.add(sendRespose);

		Surrender = new JButton("Сдаюсь");
		Surrender.setAlignmentX(JComponent.RIGHT_ALIGNMENT);

		Surrender.setMaximumSize(new Dimension(100, 20));
		buttonPanel.add(Surrender);

		Surrender.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setPlayerResponse("Сдаюсь");
				player.sendRequest(PlayerResponse);
			}
		});

		sendRespose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setPlayerResponse(cityField.getText());
				if (!PlayerResponse.isEmpty()) {

					if (!player.isStopedResender()) {

						player.sendRequest(PlayerResponse);
					} else {
						setMessage("Связь с сервером потеряна");
						addDialog(message);

					}
				} else {
					setMessage("Вы ввели пустое значение");
					addDialog("Вы ввели пустое значение");

				}

			}
		});
		formPanel.add(buttonPanel);
		mainPanel.add(formPanel);
		mainPanel.setBorder(new TitledBorder(nameField.getText()));
		gameWindow.getContentPane().add(mainPanel);

		gameWindow.setResizable(false);
		gameWindow.setVisible(true);

	}

	public void addDialog(String message) {
		dialogLabel = new JLabel(message, JLabel.CENTER);
		dialog = new JDialog(nameWindow, "Сообщение");
		dialog.setLayout(new FlowLayout());
		dialog.add(dialogLabel);
		dialogButton = new JButton("OK");

		dialogButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(false);

			}
		});
		dialog.add(dialogButton);
		dialog.setBounds(100, 100, 300, 80);
		dialog.setResizable(false);
		dialog.setVisible(true);

	}

}
