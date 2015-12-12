package Game;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Server_Window {
	public final static String TITLE = "Server";
	private JFrame ServerWindow;
	private JButton start;
	
	public void createWindow() {
	
		ServerWindow = new JFrame(Server_Window.TITLE);
		ServerWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ServerWindow.setSize(300, 100);
		ServerWindow.setLocationRelativeTo(null);
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
			@Override
			public boolean dispatchKeyEvent(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					System.exit(0);
				}
				return false;
			}
		});
		start = new JButton("Старт");
		
		
		

		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			Server server= new Server();
				(new Thread(server)).start();
				start.setEnabled(false);
			}
		});

		ServerWindow.add(start);

		ServerWindow.setResizable(false);
		ServerWindow.setVisible(true);
	
	
	}	
	
	
	
}
