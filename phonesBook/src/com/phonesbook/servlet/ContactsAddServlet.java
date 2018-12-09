package com.phonesbook.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.phonesbook.dao.ContactsDAO;
import com.phonesbook.model.Contacts;


@WebServlet("/add-contacts")
public class ContactsAddServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Contacts contact = new Contacts();
		
		String name = req.getParameter("name");
		String phone_number = req.getParameter("phone_number");
		String mobile_number = req.getParameter("mobile_number");
		String email_address = req.getParameter("email_address");

		contact.setName(name);
		contact.setPhone_number(phone_number);
		contact.setMobile_number(mobile_number);
		contact.setEmail_address(email_address);
		
		try {
			ContactsDAO contactsDao = new ContactsDAO();
			Boolean ret = contactsDao.addContact(contact);
			
			if (ret) {
				resp.sendRedirect("/phonesBook/");
			} else {
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<script>alert('Nao foi possivel realizar a operacao!');window.location='./contact.jsp'</script>");
				out.println("</head>");
				out.println("</html>");
				RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
				rd.forward(req, resp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("contact.jsp");
		rd.forward(req, resp);
	}
}
