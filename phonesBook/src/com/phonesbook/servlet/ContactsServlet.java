package com.phonesbook.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Documented;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.DomainManagerOperations;

import com.phonesbook.dao.ContactsDAO;
import com.phonesbook.model.Contacts;

@WebServlet("/contacts")
public class ContactsServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Contacts> contacts;
		ContactsDAO contactsDao = new ContactsDAO();
		String id = req.getParameter("id");
		String action = req.getParameter("action");
		
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
				
				/*Editar Contato: */				
				if (action.toUpperCase().equals("EDIT")) {
					req.setAttribute("contact", contact);
					RequestDispatcher rd = req.getRequestDispatcher("editContact.jsp");
					rd.forward(req, resp);
				}
				
				/*Excluir Contato: */
				if (action.toUpperCase().equals("DELETE")) {
					Boolean deleted = contactsDao.delContact(contact);
					if(deleted) resp.sendRedirect("/phonesBook/");
					else {
					
						PrintWriter out = resp.getWriter();
						out.println("<html>");
						out.println("<head>");
						out.println("<script>alert('Nao foi possivel excluir!');window.location='/phonesBook/'</script>");
						out.println("</head>");
						out.println("</html>");
					}
				}
				
				/*Alterar Favorito*/
				
				if(action.toUpperCase().equals("EDITFAV")) {
					
					if(contact.getIs_favorite()) {
						contact.setIs_favorite(false);
					}
					else{
						contact.setIs_favorite(true);
					}
					Boolean changed = contactsDao.changeFavorite(contact);
					if(changed) resp.sendRedirect("/phonesBook/");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
	}
	
}
