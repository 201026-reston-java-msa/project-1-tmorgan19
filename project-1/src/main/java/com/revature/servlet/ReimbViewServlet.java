package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.revature.model.Reimbursement;
import com.revature.service.ReimbService;
import com.revature.service.UserService;
import com.revature.util.LocalDateTimeSerializer;


public class ReimbViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ReimbViewServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Reimbursement> reimbs = null;
		List<Reimbursement> reimbsA;
		List<Reimbursement> reimbsD;


		String username = request.getSession(false).getAttribute("username").toString();
		
		if (UserService.isManager(username)) {
			String reqStatus = request.getParameter("status");
			String reqAuthor = request.getParameter("author");
			if (reqStatus != null) {
				if (reqStatus.equals("all")) {
					reimbs = ReimbService.filterStatusByAll(1);
					reimbsA = ReimbService.filterStatusByAll(2);
					reimbsD = ReimbService.filterStatusByAll(3);
					for (Reimbursement r : reimbsA) {
						reimbs.add(r);
					}
					for (Reimbursement r : reimbsD) {
						reimbs.add(r);
					}
				} 
				else if (reqStatus.equals("pending")) {
					reimbs = ReimbService.filterStatusByAll(1);
				}
				else if (reqStatus.equals("resolved")) {
					reimbs = ReimbService.filterStatusByAll(2);
					reimbsD = ReimbService.filterStatusByAll(3);
					for (Reimbursement r : reimbsD) {
						reimbs.add(r);
					}
				}
			} else if (reqAuthor != null){
				reimbs = ReimbService.filterAllByUser(reqAuthor);
				
			}
		}
		else {
			String reqStatus = request.getParameter("status");
			if (reqStatus != null) {
				if (reqStatus.equals("all")) {
					reimbs = ReimbService.filterAllByUser(username);
				} 
				else if (reqStatus.equals("pending")) {
					reimbs = ReimbService.filterStatusByUser(username, 1);
				}
				else if (reqStatus.equals("resolved")) {
					reimbs = ReimbService.filterStatusByUser(username, 2);
					reimbsD = ReimbService.filterStatusByUser(username, 3);
					for (Reimbursement r : reimbsD) {
						reimbs.add(r);
					}
				}
			}
		}
		
		if (reimbs != null) {
			Gson gson = new GsonBuilder()
					.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
					.serializeNulls()
					.create();
			String json = gson.toJson(reimbs);
			PrintWriter pw = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			pw.print(json);
			pw.flush();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
