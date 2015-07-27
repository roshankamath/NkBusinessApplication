package com.nkba.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nkba.dao.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String userName =request.getParameter("email");
		String userPass =request.getParameter("password");
		
		if(LoginDao.validate(userName, userPass)){
			Cookie loginCookie = new Cookie("user",userName);
            //setting cookie to expiry in 30 mins
            loginCookie.setMaxAge(1);//30*60);
            response.addCookie(loginCookie);
			response.sendRedirect("/NkBusinessApplication/index.html");
		}
		else{
			out.print("Sorry username or password error");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request,response);
		}
		
		out.close();
		}

}
