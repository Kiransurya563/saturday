package servletm1_crud.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servletm1_crud.dao.StudentDao;

@WebServlet("/deletebyid")
public class DeleteById extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("pk");
		int cid=Integer.parseInt(id);
		
		StudentDao dao=new StudentDao();
		String msg=dao.deleteById(cid);
		resp.getWriter().print(msg);
	}
}
