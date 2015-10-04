package HomeWork;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<body>");
		out.println("<div align = \"center\">");
		out.println("<form action=http://localhost:8080/TestingServlets/Servlet2 method=\"GET\">");
		out.println("<fieldset title=\"Ввод данных\"><legend>Заполните форму</legend>" );
		out.println("<br>Введите свой e-mail:*");
		out.println("<br><input  type=\"text\" name=\"e-mail\" style=\"width:400px\"required pattern=\"^[\\w]{1}[\\w-\\.]*@[\\w-]+\\.[a-z]{2,4}$\">");
		out.println("<br>Введите пароль:*");
		out.println("<br><input type=\"password\" name=\"pass\" size=\"10\" maxlength=\"5\" required>");
		out.println("<br>Укажите пол:*");
		out.println("<br><input name=\"gender\" required type=\"radio\" value=\"male\">м");
		out.println("<input name=\"gender\"required type=\"radio\" value=\"female\"> ж");
		out.println("<br>Желаете подписаться?");
		out.println("<br><input name=\"subscription\" type=\"checkbox\" value=\"signed\">" );
		out.println("<br><input type=\"submit\" name=\"shipping\" value=\"Отправить\">");
		out.println("<input type=\"reset\" name=\"Reset\" value=\"Очистить форму\">");
		out.println("<br>* - поля обязательные для заполнения!");
		out.println( "</fieldset>");
		out.println("</form>");
		out.println("</div>");
		out.println("</body>");
	    out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
