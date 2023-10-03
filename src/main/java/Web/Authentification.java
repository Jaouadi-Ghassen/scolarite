package Web;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GestionStudentImp;
import dao.GestionUserlmp;
import dao.IGestionStudent;
import dao.IGestionUser;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Auth")
public class Authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authentification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    IGestionStudent gestion;
    IGestionUser gesU;
	public void init(ServletConfig config) throws ServletException {
		gestion = new GestionStudentImp();
		
		gesU = new GestionUserlmp();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action == null ) {
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	
		}else {
			HttpSession session= request.getSession(false);
			if(session != null) {
				session.invalidate();
				//request.getRequestDispatcher(request.getContextPath()+"/").forward(request, response);
				response.sendRedirect(request.getContextPath()+"/");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password =request.getParameter("password");
		String username = gesU.getUserName(email, password);
		System.out.println(username);
		if(username == null) {
			request.setAttribute("erreur", "email ou password est incorrect");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("username" , username);
			request.getRequestDispatcher("Controlleur").forward(request, response);
		}
	}

}
