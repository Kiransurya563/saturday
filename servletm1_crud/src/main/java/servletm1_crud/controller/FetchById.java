package servletm1_crud.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servletm1_crud.dao.StudentDao;

@WebServlet("/fetchbyid")
public class FetchById extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("pk");
		int cid=Integer.parseInt(id);
		System.out.println(cid);
		
		
		StudentDao dao=new StudentDao();
		Object o=dao.fetchById(cid);
		resp.getWriter().print(o);
	}
}
