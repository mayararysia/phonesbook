package com.phonesbook.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.phonesbook.dao.ContactsDAO;
import com.phonesbook.model.Contacts;

@WebServlet("/edit-contacts")
public class ContactsEditServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		try {
			Contacts contact = new Contacts();
			ContactsDAO contactsDao = new ContactsDAO();
			
			String id = req.getParameter("id");
			Integer idInteger = Integer.parseInt(id);
			String name = req.getParameter("name");
			String phone_number = req.getParameter("phone_number");
			String mobile_number = req.getParameter("mobile_number");
			String email_address = req.getParameter("email_address");
			
			contact.setId(idInteger);
			contact.setName(name);
			contact.setPhone_number(phone_number);
			contact.setMobile_number(mobile_number);
			contact.setEmail_address(email_address);
		
			Boolean ret = contactsDao.editContact(contact);
			if(ret) resp.sendRedirect("/phonesBook/");
			else {
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<script>alert('Nao foi possivel realizar a alteração!');window.location='/phonesBook/'</script>");
				out.println("</head>");
				out.println("</html>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
