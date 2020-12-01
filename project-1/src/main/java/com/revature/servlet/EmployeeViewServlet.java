package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.revature.model.User;
import com.revature.service.UserService;
import com.revature.util.LocalDateTimeSerializer;

public class EmployeeViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmployeeViewServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getSession(false).getAttribute("username").toString();
//		String username = "example";
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
