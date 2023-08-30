package control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SignUpDAO;

/**
 * Servlet implementation class SignupController
 */
@WebServlet("/SignupController")
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String REGISTER = "successful.jsp";
	private static final String ERROR = "invalid.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String studentID = request.getParameter("studentid");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String department = request.getParameter("selectedKhoa");
		String phoneNumber = request.getParameter("phonenumber");
		String dateOfBirth = request.getParameter("dateofbirth");
		String sex = request.getParameter("sex");
		String nation = request.getParameter("nation");
		String religion = request.getParameter("religion");
		if (religion == null || religion.trim().isEmpty()) {
			religion = "Không";
		}
		String permanentAddress = request.getParameter("permanentaddress");
		String address = request.getParameter("address");
		
		String unionDayJoining = request.getParameter("uniondayjoining");
		if (unionDayJoining == null || unionDayJoining.trim().isEmpty()) {
			unionDayJoining = "Không";
		}
		String dangDayJoiningRe = request.getParameter("dangdayjoiningre");
		if (dangDayJoiningRe == null || dangDayJoiningRe.trim().isEmpty()) {
			dangDayJoiningRe ="Không";
		}
		String dangDayJoining = request.getParameter("dangdayjoining");
		if (dangDayJoining == null || dangDayJoining.trim().isEmpty()) {
			dangDayJoining = "Không";
		}
		String title = request.getParameter("selectedDanhHieu");
		Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("yyyy");
        String year = simpleDateFormat.format(date);
        String profileType = "Chưa đạt";
        String confirm = "0";
        String theEditing = "0";
        String confirmLevelDepartment = "0";
		
        SignUpDAO signUpDAO = new SignUpDAO();

        boolean signUpSuccess = false;
        try {
            signUpDAO.insertUser(studentID, userName, password, email);
            signUpDAO.insertProfile(studentID, userName, phoneNumber, dateOfBirth, sex, nation, religion, permanentAddress, address, unionDayJoining, dangDayJoiningRe, dangDayJoining);
            signUpDAO.insertListSignUp(studentID, userName, year, department, profileType, title, confirm, theEditing, confirmLevelDepartment);
            signUpDAO.insertContentOfStudentID(studentID);
            signUpDAO.insertAttachmentsOfStudentID(studentID);
            signUpDAO.insertComment(studentID);
            signUpDAO.insertAssess(studentID);
            signUpSuccess = true;
        } catch (Exception e) {
            signUpSuccess = false;
        }

        if (!signUpSuccess) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(ERROR);
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher(REGISTER);
            dispatcher.forward(request, response);
        }
	}

}
