package com.phonesbook.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.phonesbook.dao.ContactsDAO;
import com.phonesbook.model.Contacts;

@WebServlet("/contacts")
public class ContactsServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Contacts> contacts;
		ContactsDAO contactsDao = new ContactsDAO();
		String id = req.getParameter("id");			

		/*
		 * Valida se tem parametro ID;
		 * Se existir, valida se é inteiro;
		 * Se for valor valido, busca contato pelo id;
		 * Se campo for não existir ou possuir valor invalido, lista todos contatos.
		 */
		if (id == null || id.isEmpty()) {
			contacts = contactsDao.listAll();
			req.setAttribute("contacts", contacts);
			RequestDispatcher rd = req.getRequestDispatcher("contacts.jsp");
			rd.forward(req, resp);
		} else {
			try {
				Integer idInteger = Integer.parseInt(id);
				Contacts contact = contactsDao.getContactById(idInteger);
				
				System.out.println(contact.getName());
				
				RequestDispatcher rd = req.getRequestDispatcher("editContact.jsp");
				rd.forward(req, resp);
				
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
	}
}
