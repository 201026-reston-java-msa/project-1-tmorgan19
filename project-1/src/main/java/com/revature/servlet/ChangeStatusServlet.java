package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.service.ReimbService;

public class ChangeStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ChangeStatusServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		String username = session.getAttribute("username").toString();
		int reimbId = Integer.parseInt(request.getParameter("reimbId"));
		String newStatus = request.getParameter("newStatus");
		
		ReimbService.updateStatus(username, reimbId, newStatus);
		response.sendRedirect("ManagerReimbView.html");
		
	}

}
