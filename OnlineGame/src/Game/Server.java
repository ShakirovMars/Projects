package Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;

import java.util.Iterator;
import java.util.List;

public class Server implements Runnable {
	private static final int PORT = 6735;

	private ServerSocket serverSocket;

	private char letter;
	private ArrayList<String> CitiesPlayers = new ArrayList<String>();
	private ArrayList<String> PlayersNames = new ArrayList<String>();
	private ArrayList<String> Surrendered = new ArrayList<String>();

	// Специальная "обёртка" для ArrayList, которая обеспечивает доступ к
	// массиву из разных нитей

	private List<ServerProcessor> connections = Collections.synchronizedList(new ArrayList<ServerProcessor>());

	@Override
	public void run() {
		try {

			this.serverSocket = new ServerSocket(Server.PORT);

			while (true) {
				Socket socket = this.serverSocket.accept();

				ServerProcessor sp = new ServerProcessor(socket);

				this.connections.add(sp);
				(new Thread(sp)).start();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Закрывает все потоки всех соединений а также серверный сокет

	private void closeAll() {
		try {
			serverSocket.close();

			// Перебор всех Connection и вызов метода close() для каждого. Блок
			// synchronized {} необходим для правильного доступа к одним данным
			// их разных нитей
			synchronized (connections) {
				Iterator<ServerProcessor> iter = connections.iterator();
				while (iter.hasNext()) {
					((ServerProcessor) iter.next()).close();
				}
			}
		} catch (Exception e) {
			System.err.println("Потоки не были закрыты!");
		}
	}

	public class ServerProcessor implements Runnable {

		private Socket socket;

		private BufferedReader in;

		private PrintWriter out;
		private String name;
		private boolean first = true;

		public ServerProcessor(Socket socket) {
			this.socket = socket;
			try {

				this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				this.out = new PrintWriter(socket.getOutputStream(), true);
			} catch (IOException e) {
				e.printStackTrace();
				close();
			}
		}

		@Override
		public void run() {
			try {
				GeneratorRandomlLetter random = new GeneratorRandomlLetter();
				Check check = new Check();

				while (!this.socket.isClosed()) {
					String request = this.getRequest();

					if (request == null) {
						System.out.println("Connection has been closed by client.");
						socket.close();
					}

					else {
						if (!request.isEmpty()) {

							if (first && !checkName(request)) {
								out.println("Пожалуйста, поменяйте свой ник");

							} else {
								if (first && connections.size() == 1) {

									letter = random.randomLetter();
									this.name = request;

									this.sendResponse(" Угадайте город на букву: " + letter);
									PlayersNames.add(name);
									first = false;

								}

								else {
									if (first) {
										this.name = request;
										PlayersNames.add(name);
										out.println(name + " Угадайте город на букву: " + letter);
										first = false;

									}

									else {
										if (connections.size() == 1 && request.equals("Сдаюсь")) {
											
											char newLetter;
											do {
												newLetter = random.randomLetter();
											} while (newLetter == letter);
											letter = newLetter;
											out.println(" Угадайте город на букву: " + letter);

										} else {
											if (connections.size() > 1 && request.equals("Сдаюсь")
													&& !checkSurrendered(name)) {
												Surrendered.add(name);
												this.sendResponse(" Сдался");

												if (Surrendered.size() == connections.size()) {
													Surrendered.clear();
													char newLetter;
													do {
														newLetter = random.randomLetter();
													} while (newLetter == letter);
													letter = newLetter;
													this.sendResponse(" Угадайте город на букву: " + letter);
												}

											} else {

												char ch = check.mainCheck(letter, request, CitiesPlayers);
												switch (ch) {
												case '*':
													this.sendResponse(" Указал неправильный город");
													break;

												case '-':

													letter = random.randomLetter();

													CitiesPlayers.add(request);
													this.sendResponse(" Угадал город.Cледующая буква: " + letter);
													break;
												case '#':
													this.sendResponse(" Указал повотряющийся город: " + letter);
													break;
												default:
													letter = ch;
													CitiesPlayers.add(request);
													this.sendResponse(" Угадал город.Cледующая буква: " + letter);

													break;
												}

											}
										}
									}

								}
							}
						} else {
							out.println("Пустые запросы не обрабатываются");
						}
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void close() {
			try {
				this.in.close();
				this.out.close();
				this.socket.close();

				// Если больше не осталось соединений, закрываем всё, что есть и
				// завершаем работу сервера
				connections.remove(this);
				if (connections.size() == 0) {
					Server.this.closeAll();
					System.exit(0);
				}
			} catch (Exception e) {
				System.err.println("Потоки не были закрыты!");
			}
		}

		protected void sendResponse(String response) {
			synchronized (connections) {
				Iterator<ServerProcessor> iter = connections.iterator();
				while (iter.hasNext()) {
					((ServerProcessor) iter.next()).out.println(name + response);

				}
			}
		}

		protected String getRequest() {
			try {
				StringBuffer request = new StringBuffer();
				while (true) {
					String s = this.in.readLine();

					if (s == null) {
						return null;
					}

					else if (s.trim().length() == 0) {
						break;
					}

					request.append(s);
				}

				return request.toString();
			} catch (IOException ex) {
				System.err.println("Can't read request: " + ex.getMessage());
			}
			return null;
		}

		protected boolean checkName(String name) {

			boolean checkName = true;
			if (!PlayersNames.isEmpty()) {
				for (int i = 0; i < PlayersNames.size() && checkName; i++) {
					if (PlayersNames.get(i).equalsIgnoreCase(name)) {
						checkName = false;
					}
				}

			}

			return checkName;
		}

		protected boolean checkSurrendered(String name) {
			boolean checkSurrendered = false;
			if (!Surrendered.isEmpty()) {
				for (int i = 0; i < Surrendered.size() && !checkSurrendered; i++) {
					if (Surrendered.get(i).equalsIgnoreCase(name)) {
						checkSurrendered = true;
					}
				}

			}
			return checkSurrendered;
		}

	}
}
