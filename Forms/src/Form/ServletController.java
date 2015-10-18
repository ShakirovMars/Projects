package Form;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletController")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String email = request.getParameter("email").trim();
	
		String pass = request.getParameter("pass");
		String sex = request.getParameter("sex");
		
		String subscription = request.getParameter("subscription");
		String remember = request.getParameter("remember");
		String inf=request.getParameter("text1").trim();
		if (subscription != null) {
			subscription = "signed";
		} else
			subscription = "no signed";

		if (email != null && pass != null && sex != null) {
			PersonModel person = new PersonModel(email, pass, sex, subscription,inf);

			if (person.addPerson() == true) {
				if (remember != null) {
					Cookie cookieEmail = new Cookie("email", email);
					response.addCookie(cookieEmail);
					Cookie cookiePass = new Cookie("password", pass);
					response.addCookie(cookiePass);

				}
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Main.jsp");
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/RepeatReg.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/RepeatReg.jsp");
			dispatcher.forward(request, response);
		}
	}

}
