package com.phonesbook.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.phonesbook.dao.CompromisesDAO;
import com.phonesbook.model.Compromise;
import com.phonesbook.util.DateConverter;

@WebServlet("/add-compromises")
public class CompromiseAddServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		Compromise compromise = new Compromise();
		
		String title = req.getParameter("title");
		String desc = req.getParameter("desc");
		String type = req.getParameter("type");
		String date = req.getParameter("date");
		String time = req.getParameter("time");
		
		
		compromise.setTitle(title);
		compromise.setDesc(desc);
		compromise.setType(type.toUpperCase());
		compromise.setDate(DateConverter.stringTypeToDate(date));
		compromise.setTime(DateConverter.stringTypeToTime(time));
		
		try {
			CompromisesDAO compromisesDAO = new CompromisesDAO();
			Boolean added = compromisesDAO.addCompromise(compromise);
			
			if (added) {
				resp.sendRedirect("/phonesBook/");
			} else {
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<script>alert('Nao foi possivel cadastrar o compromisso!');window.location='/phonesBook/'</script>");
				out.println("</head>");
				out.println("</html>");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("compromise.jsp");
		rd.forward(req, resp);
	}
	
}
