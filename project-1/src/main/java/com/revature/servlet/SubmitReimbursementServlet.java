package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.service.ReimbService;

public class SubmitReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SubmitReimbursementServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		String username = session.getAttribute("username").toString();

		double amount = Double.parseDouble(request.getParameter("amount"));
		String type = request.getParameter("type");
		String description = request.getParameter("description");
		
		ReimbService.generateReimbursement(username, amount, type, description);
		response.sendRedirect("NewReimbursement.html");
	}

}
