package HomeWork;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		String email = request.getParameter("e-mail");
		String pass = request.getParameter("pass");
		String gender = request.getParameter("gender");
		String subscription;
		if (request.getParameter("subscription") != null) {
			subscription = request.getParameter("subscription");
		} else
			subscription = "nosigned";
		String data = null;
		StringBuffer data1 = new StringBuffer();

		// write
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter("C:\\Users\\Марсель\\workspace\\TestingServlets\\data.txt", true);
			try {

				fileWriter.write(email + "&" + pass + "&" + gender + "&" + subscription + "\r\n");
			} finally {

				fileWriter.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// read

		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Марсель\\workspace\\TestingServlets\\data.txt"));
		String form;
		ArrayList<String> forms = new ArrayList<String>();
		while ((form = reader.readLine()) != null) {
			forms.add(form);
		}

		// processing
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<body>");
		out.println("<div>");
		out.println("<table border=2 bordercolor=red align=center>");
		out.println("<tr>");
		out.println("<td>E-mail</td>");
		out.println("<td>Пароль</td>");
		out.println("<td>Пол</td>");
		out.println("<td>Подписка</td>");
		out.println("</tr>");
		for (int i = 0; i < forms.size(); i++) {
			data = forms.get(i).toString();
			data1.append(data);
			String s;
			String p;
			String g;
			String e;
			int t;
			int u;
			t = data1.lastIndexOf("&");
			u = data1.length();
			s = data1.substring(t + 1, u);
			data1.delete(t, u);
			t = data1.lastIndexOf("&");
			u = data1.length();
			g = data1.substring(t + 1, u);
			data1.delete(t, u);
			t = data1.indexOf("&");
			u = data1.length();
			p = data1.substring(t + 1, u);
			data1.delete(t, u);
			t = 0;
			u = data1.length();
			e = data1.substring(t, u);
			data1.delete(t, u);
			out.println("<tr>");
			out.println(" <td>" + e + "</td> ");
			out.println("<td>" + p + "</td>");
			out.println(" <td>" + g + "</td> ");
			out.println(" <td>" + s + "</td> ");
			out.println("</tr>");
		}

		out.println("</table>");
		out.println("</div>");

		out.println("</body>");
		out.println("</html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
