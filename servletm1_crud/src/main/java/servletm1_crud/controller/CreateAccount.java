package servletm1_crud.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servletm1_crud.dao.StudentDao;
import servletm1_crud.dto.StudentDto;

//servlet class or controller class
@WebServlet("/insert")
public class CreateAccount extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("sid");
		int cid=Integer.parseInt(id);//to convert String into int
		String name = req.getParameter("sname");
		//System.out.println(id+" "+name);
		
		StudentDto dto=new StudentDto();
		dto.setId(cid);
		dto.setName(name);
		System.out.println(dto);
		
		 
		StudentDao dao=new StudentDao();
		String msg=dao.insert(dto);
		resp.getWriter().print(msg);
	}
}
