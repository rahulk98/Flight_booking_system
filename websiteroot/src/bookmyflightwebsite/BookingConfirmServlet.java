package bookmyflightwebsite;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BookingConfirmServlet
 */
@WebServlet(
		name = "BookingConfirmServlet",
		urlPatterns = "\book"
		)
public class BookingConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession s = request.getSession(false);
		if(s==null || s.getAttribute("user")==null) {
			response.sendRedirect("login.jsp");
		}
		String temp = (String)request.getParameter("flight");
		String arr[] = temp.split("_");
		dbConnector db = new dbConnector();
		db.connect();
		int price = Integer.parseInt(arr[1]) * db.getPrice(arr[0]);
		request.setAttribute("price", price);
		request.setAttribute("count", Integer.parseInt(arr[1]));
		request.setAttribute("wallet", db.getBalance((String)s.getAttribute("user")));
		RequestDispatcher view = request.getRequestDispatcher("BookingConfirmation.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
