package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import context.UserDTO;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String SUCCESS = "ListSignUpController";
	public static final String ERROR = "invalid.jsp";

	public LoginController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession(true);
		UserDAO dao = new UserDAO();
		String url = ERROR;
		try {
			String StudentID = request.getParameter("studentid");
			String Password = request.getParameter("password");
			
			UserDTO user = dao.checkLogin(StudentID, Password);
			
			if (user != null) {
                session.setAttribute("USER", user);
                String previousUrl = (String) session.getAttribute("previousUrl");
                
                if (previousUrl != null && !previousUrl.isEmpty()) {
                    session.removeAttribute("previousUrl");
                    url = previousUrl;
                } else {
                	url = SUCCESS;
                }
            }
		} catch (Exception e) {
			log("error at login servlet: " + e.toString());
		} finally {
			response.sendRedirect(url);
		}
	}
}
