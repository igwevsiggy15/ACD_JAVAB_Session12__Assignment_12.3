package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBConnection;
import db.DBUtility;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String query;
		Connection con = DBConnection.getDBInstance();
		DBUtility.useDB(con, "employee");

		String idemployee = (String) request.getParameter("idemployee");
		String firstName = (String) request.getParameter("firstName");
		String lastName = (String) request.getParameter("lastName");
		String number = (String) request.getParameter("number");
		String salary = (String) request.getParameter("salary");

		response.setContentType("text/html");

		query = "INSERT INTO `employee`.`employee` (`idemployee`, `firstName`, `lastName`, `number`, `salary`) VALUES ('"
				+ idemployee + "', '" + firstName + "', '" + lastName + "', '" + number + "', '" + salary + "');";
		if (DBUtility.executeUpdate(con, query)) {
			response.getWriter().append(
					"<meta http-equiv='refresh' content='3;URL=EmployeeList'><p style='color:red;'>Employee saved successfully</p>");
		} else
			response.getWriter().append(
					"<meta http-equiv='refresh' content='3;URL=index.html'><p style='color:red;'>Employee saved unsuccessfully</p>");

		doGet(request, response);
	}

}
