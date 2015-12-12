package Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Player {
	private static String server_host = "127.0.0.1";
	private static int server_port = 6735;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private boolean stopedResender;

	public boolean isStopedResender() {
		return stopedResender;
	}

	public void setStopedResender(boolean stopedResender) {
		this.stopedResender = stopedResender;
	}

	public boolean Connection() {
		boolean connection;
		try {
			this.socket = new Socket(Player.server_host, Player.server_port);
			this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.out = new PrintWriter(socket.getOutputStream(), true);
			connection = true;

		} catch (Exception e) {
			connection = false;
		}
		return connection;
	}

	protected void sendRequest(String request) {
		this.out.println(request);
    	this.out.println();
	}

	protected String getResponse() {
		String s;
		try {

			s = this.in.readLine();
		} catch (IOException e) {
			s = "Ошибка сервера";
			setStopedResender(true);
		}

		return s;
	}

	protected void ResenderStart(String FirstLabel) {
		Resender resend = new Resender(FirstLabel);
		resend.start();

	}

	private class Resender extends Thread {
		ChatWindow chatWindow = new ChatWindow();

		private Resender(String FirstLabel) {

			chatWindow.CreateWindow();
			chatWindow.creatLabel(FirstLabel);
		}

		@Override
		public void run() {

			while (!stopedResender) {
				chatWindow.creatLabel(getResponse());
			}
		}
	}

}
