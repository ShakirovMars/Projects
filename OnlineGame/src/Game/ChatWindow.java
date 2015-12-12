package Game;

import java.awt.BorderLayout;

import java.awt.Font;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ChatWindow {
	public final static String TITLE = "Game- Cities";
	private JFrame chatWindow;
	private JPanel formPanel;
	private List<JLabel> labels = new ArrayList<JLabel>();
	private JScrollPane scrollPane;
	private Font myFont;

	public void CreateWindow() {
		chatWindow = new JFrame(ApplicationWindow.TITLE);
		chatWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chatWindow.setSize(500, 400);
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

		formPanel = new JPanel();
		scrollPane = new JScrollPane(formPanel);
		formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));

		chatWindow.getContentPane().setLayout(new BorderLayout());
		chatWindow.getContentPane().add(scrollPane, BorderLayout.CENTER);
		chatWindow.setResizable(false);
		chatWindow.setVisible(true);

	}

	public void creatLabel(String text) {
		if (labels.size() < 7) {
			JLabel chat = new JLabel(text);
			labels.add(chat);
			chat.setAlignmentX(JLabel.CENTER_ALIGNMENT);

			chat.setFont(myFont);
			formPanel.add(chat);
			scrollPane.revalidate();
		} else {
			int index = 0;
			JLabel label = labels.remove(index);
			formPanel.remove(label);
			JLabel chat = new JLabel(text);
			labels.add(chat);
			chat.setAlignmentX(JLabel.CENTER_ALIGNMENT);

			chat.setFont(myFont);
			formPanel.add(chat);

			formPanel.repaint();
			scrollPane.revalidate();

		}
	}

}
