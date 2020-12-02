package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.revature.model.User;
import com.revature.service.UserService;

public class EmployeeViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmployeeViewServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getSession(false).getAttribute("username").toString();
		String reqScope = request.getParameter("scope");
		if (reqScope != null) {
			if (reqScope.equals("all")) {
				List<User> users = UserService.getAllUsers();
				if (users != null) {
					Gson gson = new GsonBuilder()
							.serializeNulls()
							.create();
					String json = gson.toJson(users);
					PrintWriter pw = response.getWriter();
					response.setContentType("application/json");
					response.setCharacterEncoding("UTF-8");
					pw.print(json);
					pw.flush();
				}
			}
		}
		else {
			User u = UserService.getUserInfo(username);
			if (u !=null) {
				Gson gson = new GsonBuilder()
						.serializeNulls()
						.create();
				String json = gson.toJson(u);
				PrintWriter pw = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				pw.print(json);
				pw.flush();
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
