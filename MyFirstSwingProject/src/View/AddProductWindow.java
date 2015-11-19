package View;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;

import Controller.Check;
import Controller.Repository;
import Model.MyTableModel;
import Model.Product;

public class AddProductWindow {
	public final static String TITLE = "Form for product ";
	private JFrame myWindow;
	private JPanel mainPanel;
	private JPanel formPanel;
	private Font myFont;
	private JLabel nameLabel;
	private JLabel manufactorerLabel;
	private JLabel weightLabel;
	private JLabel categoryLabel;
	private JTextField nameField;
	private JTextField weightField;
	private JTextField categoryField;
	private JComboBox manufactorerBox;
	// private JComboBox categotyBox;
	// private JFrame addCategory;
	private JButton save;
	private JDialog dialog;
	private JLabel dialogLabel;
	private JTable table;
	private JFrame view;

	public void CreateWindow() {

		myWindow = new JFrame(AddProductWindow.TITLE);
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myWindow.setSize(500, 400);
		myWindow.setLocationRelativeTo(null);
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

		nameLabel = new JLabel("Введите название вашего продукта:");
		nameLabel.setFont(myFont);
		nameLabel.setAlignmentX(JComponent.RIGHT_ALIGNMENT);

		nameLabel.setMaximumSize(new Dimension(400, 20));
		formPanel.add(nameLabel);

		nameField = new JTextField();
		nameField.setAlignmentX(JComponent.RIGHT_ALIGNMENT);
		nameField.setMaximumSize(new Dimension(400, 20));
		formPanel.add(nameField);

		manufactorerLabel = new JLabel("Выберите производителя:");
		manufactorerLabel.setAlignmentX(JComponent.RIGHT_ALIGNMENT);
		manufactorerLabel.setMaximumSize(new Dimension(400, 20));
		manufactorerLabel.setFont(myFont);
		formPanel.add(manufactorerLabel);

		String[] contries = { "Выбрать", "Абхазия", " Австралия", "Австрия", "Азербайджан", "Албания", "Алжир",
				"Ангола", "Андорра", "Антигуа и Барбуда", "Аргентина", "Армения", "Афганистан", "Багамские Острова",
				"Бангладеш", "Барбадос", "Бахрейн", "Белиз", "Белоруссия", "Бельгия", "Бенин", "Болгария", "Боливия",
				"Босния и Герцеговина", "Ботсвана", "Бразилия", "Бруней", "Буркина-Фасо", "Бурунди", "Бутан", "Вануату",
				"Ватикан", "Великобритания", "Венгрия", "Венесуэла", "Восточный Тимор", " Вьетнам", "Габон", "Гаити",
				"Гайана", "Гамбия", "Гана", "Гватемала", "Гвинея", "Гвинея-Бисау", "Германия", " Гондурас",
				"Государство", "Палестина", "Гренада", "Греция", "Грузия", "Дания", "Джибути", "Доминика",
				"Доминиканская Республика", "ДР Конго", "Египет", "Замбия", "Зимбабве", "Израиль", "Индия", "Индонезия",
				"Иордания", "Ирак", "Иран", "Ирландия", "Исландия", " Испания", "Италия", "Йемен", "Кабо-Верде",
				"Казахстан", "Камбоджа", "Камерун", "Канада", "Катар", "Кения", "Кипр", "Киргизия", "Кирибати", "Китай",
				"КНДР", "Колумбия", "Коморские Острова", " Коста-Рика", "Кот-дИвуар", "Куба", "Кувейт", "Лаос",
				"Латвия", "Лесото", "Либерия", "Ливан", "Ливия", "Литва", "Лихтенштейн", "Люксембург", "Маврикий",
				"Мавритания", "Мадагаскар", "Македония", "Малави", " Малайзия", "Мали", "Мальдивские Острова", "Мальта",
				"Марокко", "Маршалловы Острова", "Мексика", "Мозамбик", "Молдавия", "Монако", "Монголия", "Мьянма",
				"Намибия", "Науру", "Непал", "Нигер", "Нигерия", "Нидерланды", "Никарагуа", "Новая Зеландия",
				"Норвегия", "ОАЭ", "Оман", "Пакистан", "Палау", "Панама", "Папуа - Новая Гвинея", "Парагвай", "Перу",
				"Польша", " Португалия", "Республика Конго", "Республика Корея", "Россия", "Руанда", "Румыния",
				"Сальвадор", "Самоа", "Сан-Марино", "Сан-Томе и Принсипи", "Саудовская Аравия", "Свазиленд",
				"Сейшельские Острова", "Сенегал", "Сент-Винсент и Гренадины", "Сент-Китс и Невис", "Сент-Люсия",
				"Сербия", "Сингапур", "Сирия", "Словакия", "Словения", " Соломоновы Острова", "Сомали", "Судан",
				"Суринам", "США", "Сьерра-Леоне", "Таджикистан", " Таиланд", " Танзания", "Того", "Тонга",
				"Тринидад и Тобаго", "Тувалу", "Тунис", "Туркмения", "Турция", "Уганда", "Узбекистан", "Украина",
				"Уругвай", "Федеративные Штаты Микронезии", "Фиджи", "Филиппины", "Финляндия", "Франция", "Хорватия",
				"ЦАР", "Чад", "Черногория", "Чехия", "Чили", "Швейцария", "Швеция", "Шри-Ланка", "Эквадор",
				"Экваториальная Гвинея", "Эритрея", "Эстония", "Эфиопия", " ЮАР", "Южная Осетия", "Южный Судан",
				"Ямайка", "Япония" };

		manufactorerBox = new JComboBox(contries);
		manufactorerBox.setAlignmentX(JComponent.RIGHT_ALIGNMENT);
		manufactorerBox.setMaximumSize(new Dimension(400, 20));
		formPanel.add(manufactorerBox);

		weightLabel = new JLabel("Вес продукта:");
		weightLabel.setFont(myFont);
		weightLabel.setAlignmentX(JComponent.RIGHT_ALIGNMENT);
		weightLabel.setMaximumSize(new Dimension(400, 20));
		formPanel.add(weightLabel);

		weightField = new JTextField();
		weightField.setAlignmentX(JComponent.RIGHT_ALIGNMENT);
		weightField.setMaximumSize(new Dimension(400, 20));
		formPanel.add(weightField);

		categoryLabel = new JLabel("Напишите категорию:");
		categoryLabel.setFont(myFont);
		categoryLabel.setAlignmentX(JComponent.RIGHT_ALIGNMENT);
		categoryLabel.setMaximumSize(new Dimension(400, 20));
		formPanel.add(categoryLabel);

		categoryField = new JTextField();
		categoryField.setAlignmentX(JComponent.RIGHT_ALIGNMENT);
		categoryField.setMaximumSize(new Dimension(400, 20));
		formPanel.add(categoryField);

		// category =getCategory();
		// categotyBox=new JComboBox(category);
		// categotyBox.setAlignmentX(JComponent.RIGHT_ALIGNMENT);
		// categotyBox.setMaximumSize(new Dimension(400, 20));
		// formPanel.add(categotyBox);

		save = new JButton("Save");
		save.setAlignmentX(JComponent.RIGHT_ALIGNMENT);
		save.setMaximumSize(new Dimension(100, 20));
		formPanel.add(save);

		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addProduct();
				dialog = new JDialog(myWindow, "Сообщение");
				dialog.setLayout(new FlowLayout());

				dialog.add(dialogLabel);
				JButton dialogButton = new JButton("OK");
				dialogButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dialog.setVisible(false);

					}
				});
				dialog.add(dialogButton);
				dialog.setBounds(100, 100, 200, 80);
				dialog.setResizable(false);
				dialog.setVisible(true);
			}
		});

		mainPanel.add(formPanel);
		mainPanel.setBorder(new TitledBorder("Add product"));
		myWindow.getContentPane().add(mainPanel);

		myWindow.setResizable(false);
		myWindow.setVisible(true);

	}

	public void addProduct() {
		Check check = new Check();
		Repository repository = new Repository();

		if (check.checkFill(nameField.getText(), manufactorerBox.getSelectedItem().toString(), weightField.getText(),
				categoryField.getText())) {
			if (check.checkValidation(weightField.getText())) {
				Product product = new Product(nameField.getText(), manufactorerBox.getSelectedItem().toString(),
						Integer.valueOf(weightField.getText()), categoryField.getText());
				if (check.checkProizvoditel(product)) {
					if (!check.checkUniqueness(product)) {
						repository.add(product);
						dialogLabel = new JLabel("Сохранено", JLabel.CENTER);

						createView();
					} else
						dialogLabel = new JLabel("Такой продукт уже есть", JLabel.CENTER);
				} else
					dialogLabel = new JLabel("Не выбран производитель", JLabel.CENTER);
			} else
				dialogLabel = new JLabel("Проверьте правильность данных", JLabel.CENTER);
		} else
			dialogLabel = new JLabel("Имеются пустые поля", JLabel.CENTER);

	}

	public void createView() {
		Repository repository = new Repository();
		ArrayList<Product> products = repository.getProducts();
		view = new JFrame(AddProductWindow.TITLE);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setSize(500, 400);
		view.setLocationRelativeTo(null);
		TableModel model = new MyTableModel(products);
		table = new JTable(model);

		view.getContentPane().add(new JScrollPane(table));
		view.pack();
		view.setResizable(false);
		view.setVisible(true);

	}

}