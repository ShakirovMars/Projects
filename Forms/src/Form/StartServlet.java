package Form;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StartServlet")
public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StartServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		boolean check = false;
		if (cookies != null) {
			for (int i = 0; i < cookies.length && check == false; i++) {
				if (cookies[i].getName().equals("email") && cookies[i + 1].getName().equals("password")) {

					PersonModel person = new PersonModel(cookies[i].getValue(), cookies[i + 1].getValue());
					if (person.checkEmail() && person.checkPassword() && person.checkPerson()) {

						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Main.jsp");
						dispatcher.forward(request, response);
						check = true;
					}

				}
			}
		}
		if (check == false) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Start.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email").trim();
		String pass = request.getParameter("pass");
		String remember = request.getParameter("remember");

		if (email != null && pass != null) {
			PersonModel person = new PersonModel(email, pass);
			if (person.checkEmail() && person.checkPassword() && person.checkPerson()) {
				if (remember != null) {

					Cookie cookieEmail = new Cookie("email", email);
					response.addCookie(cookieEmail);

					Cookie cookiePass = new Cookie("password", pass);
					response.addCookie(cookiePass);

				}
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Main.jsp");
				dispatcher.forward(request, response);
			}

		}

	}

}
