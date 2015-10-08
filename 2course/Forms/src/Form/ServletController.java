package Form;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
		PersonModel person = new PersonModel();
		person.setEmail(request.getParameter("email"));
		person.setPassword(request.getParameter("pass"));
		person.setSex(request.getParameter("sex"));
		person.setSubscription(request.getParameter("subscription"));
		if(person.addPerson()==true){
			String[][] inf=person.giveData();
			request.setAttribute("result", inf);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/View2.jsp"); 
            dispatcher.forward(request,response); 
		}else{
			 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/View3.jsp"); 
	            dispatcher.forward(request,response); 
		}
	}

}
