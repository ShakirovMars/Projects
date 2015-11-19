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

		nameLabel = new JLabel("������� �������� ������ ��������:");
		nameLabel.setFont(myFont);
		nameLabel.setAlignmentX(JComponent.RIGHT_ALIGNMENT);

		nameLabel.setMaximumSize(new Dimension(400, 20));
		formPanel.add(nameLabel);

		nameField = new JTextField();
		nameField.setAlignmentX(JComponent.RIGHT_ALIGNMENT);
		nameField.setMaximumSize(new Dimension(400, 20));
		formPanel.add(nameField);

		manufactorerLabel = new JLabel("�������� �������������:");
		manufactorerLabel.setAlignmentX(JComponent.RIGHT_ALIGNMENT);
		manufactorerLabel.setMaximumSize(new Dimension(400, 20));
		manufactorerLabel.setFont(myFont);
		formPanel.add(manufactorerLabel);

		String[] contries = { "�������", "�������", " ���������", "�������", "�����������", "�������", "�����",
				"������", "�������", "������� � �������", "���������", "�������", "����������", "��������� �������",
				"���������", "��������", "�������", "�����", "����������", "�������", "�����", "��������", "�������",
				"������ � �����������", "��������", "��������", "������", "�������-����", "�������", "�����", "�������",
				"�������", "��������������", "�������", "���������", "��������� �����", " �������", "�����", "�����",
				"������", "������", "����", "���������", "������", "������-�����", "��������", " ��������",
				"�����������", "���������", "�������", "������", "������", "�����", "�������", "��������",
				"������������� ����������", "�� �����", "������", "������", "��������", "�������", "�����", "���������",
				"��������", "����", "����", "��������", "��������", " �������", "������", "�����", "����-�����",
				"���������", "��������", "�������", "������", "�����", "�����", "����", "��������", "��������", "�����",
				"����", "��������", "��������� �������", " �����-����", "���-������", "����", "������", "����",
				"������", "������", "�������", "�����", "�����", "�����", "�����������", "����������", "��������",
				"����������", "����������", "���������", "������", " ��������", "����", "����������� �������", "������",
				"�������", "���������� �������", "�������", "��������", "��������", "������", "��������", "������",
				"�������", "�����", "�����", "�����", "�������", "����������", "���������", "����� ��������",
				"��������", "���", "����", "��������", "�����", "������", "����� - ����� ������", "��������", "����",
				"������", " ����������", "���������� �����", "���������� �����", "������", "������", "�������",
				"���������", "�����", "���-������", "���-���� � ��������", "���������� ������", "���������",
				"����������� �������", "�������", "����-������� � ���������", "����-���� � �����", "����-�����",
				"������", "��������", "�����", "��������", "��������", " ���������� �������", "������", "�����",
				"�������", "���", "������-�����", "�����������", " �������", " ��������", "����", "�����",
				"�������� � ������", "������", "�����", "���������", "������", "������", "����������", "�������",
				"�������", "������������ ����� ����������", "�����", "���������", "���������", "�������", "��������",
				"���", "���", "����������", "�����", "����", "���������", "������", "���-�����", "�������",
				"�������������� ������", "�������", "�������", "�������", " ���", "����� ������", "����� �����",
				"������", "������" };

		manufactorerBox = new JComboBox(contries);
		manufactorerBox.setAlignmentX(JComponent.RIGHT_ALIGNMENT);
		manufactorerBox.setMaximumSize(new Dimension(400, 20));
		formPanel.add(manufactorerBox);

		weightLabel = new JLabel("��� ��������:");
		weightLabel.setFont(myFont);
		weightLabel.setAlignmentX(JComponent.RIGHT_ALIGNMENT);
		weightLabel.setMaximumSize(new Dimension(400, 20));
		formPanel.add(weightLabel);

		weightField = new JTextField();
		weightField.setAlignmentX(JComponent.RIGHT_ALIGNMENT);
		weightField.setMaximumSize(new Dimension(400, 20));
		formPanel.add(weightField);

		categoryLabel = new JLabel("�������� ���������:");
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
				dialog = new JDialog(myWindow, "���������");
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
						dialogLabel = new JLabel("���������", JLabel.CENTER);

						createView();
					} else
						dialogLabel = new JLabel("����� ������� ��� ����", JLabel.CENTER);
				} else
					dialogLabel = new JLabel("�� ������ �������������", JLabel.CENTER);
			} else
				dialogLabel = new JLabel("��������� ������������ ������", JLabel.CENTER);
		} else
			dialogLabel = new JLabel("������� ������ ����", JLabel.CENTER);

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