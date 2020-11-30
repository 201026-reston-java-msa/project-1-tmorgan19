package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.revature.model.Reimbursement;
import com.revature.service.ReimbService;
import com.revature.util.LocalDateTimeSerializer;


public class ReimbViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ReimbViewServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession(false);
//		
//		// add logic to change statusId depending on if accessed by pending link or resolved link
//		
//		String username = session.getAttribute("username").toString();
//		List<Reimbursement> reimbursements = ReimbService.filterStatusByUser(username, statusId);
//		PrintWriter pw = response.getWriter();
//		for (Reimbursement r : reimbursements) {
//
//		}
		String username = request.getSession(false).getAttribute("username").toString();
//		String username = "example";
		int statusId = 1;
		List<Reimbursement> reimbs = ReimbService.filterStatusByUser(username, statusId);
		if (reimbs != null) {

//			ObjectMapper om = new ObjectMapper();
//			String json = om.writeValueAsString(reimbs);
			
			//this section works for printing json to screen when /ReimbursementView accessed
//			Gson gson = new Gson();
//			gson.toJson(reimbs,
//		            new TypeToken<ArrayList<Reimbursement>>() {}.getType(),
//		            response.getWriter());
//			response.setStatus(200);
			//section goes with above
			
			//this section added 11:56AM as test
			Gson gson = new GsonBuilder()
					.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
					.create();
			String json = gson.toJson(reimbs);
			PrintWriter pw = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			pw.print(json);
			pw.flush();
			//section ending
			
			
			
//			PrintWriter pw = response.getWriter();
//			pw.println(json);
//			System.out.println(json);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.getParameter("typeOfReimbursements") // either pending or resolved
//		request.getParameter("employeeScope") // either request specific employee or all
		
		//currently set up just to access pending by specific user
		String username = request.getSession(false).getAttribute("username").toString();
		int statusId = 1;
		List<Reimbursement> reimbs = ReimbService.filterStatusByUser(username, statusId);
		if (reimbs != null) {
			response.setContentType("application/json");
			ObjectMapper om = new ObjectMapper();
			String json = om.writeValueAsString(reimbs);
			PrintWriter pw = response.getWriter();
			pw.println(json);
		}
	}
}
