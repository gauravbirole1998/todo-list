package com.todo_app.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;
import com.todo_app.jpa.*;
import com.todo_app.Userdao.Userdao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/task")
public class TaskServlet extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
    private Userdao userDao;

    public void init() {
        userDao = new Userdao();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
    	final String[] allowedOrigins = { 
    			"http://localhost:3000", "http://localhost:5500", "http://localhost:5501"
    			};
    	
    	String clientOrigin = request.getHeader("Origin");
    	response.setHeader("Access-Control-Allow-Origin", clientOrigin);
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Access-Control-Allow-Origin,CopyStreamException,Access-Control-Allow Methods,Access-Control-Max-Age");
        
    	
    	
    	response.setContentType("text/html");
    	PrintWriter writer=response.getWriter();
        writer.println("Hello world");
        
        
        
        
        
        
        
        
        
        
        
//    	BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
//        
//        todo_task tasks = new todo_task();
//        String json = "";
//        
//         if (br!=null) {
//        	 json=br.readLine();
//        	 System.out.print("Dtaa"+br);
//        	 todo_task data1 = new Gson().fromJson(json , todo_task.class);
//    		 System.out.println("Data41 : " + data1.getTask());
//        	 
////             tasks.setId(104);
//             tasks.setTask(data1.getTask());
//             userDao.saveTask(tasks);
//             
//             response.setContentType("text/xml");
//             PrintWriter writer=response.getWriter();
//             writer.append("this is 200");
//         }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
//    	PrintWriter out = response.getWriter();
//    	out.println();
//    	retrieve(request , response);
//        response.sendRedirect("register.jsp");
    	
//    	addTask(request , response);
    	String clientOrigin = request.getHeader("origin");
        response.setHeader("Access-Control-Allow-Origin", clientOrigin);
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Access-Control-Allow-Origin,CopyStreamException,Access-Control-Allow-Methods,Access-Control-Max-Age");
        
        String action = request.getServletPath();
    	
    	try {
            switch (action) {
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    	
//    	response.setContentType("text/html");
//        PrintWriter writer=response.getWriter();
//        writer.append("this is 400");

    	
    }
    
    private void listUser(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException, ServletException {
    	
    	        List < todo_task > listUser = userDao.getAllUser();
    	        request.setAttribute("listUser", listUser);
//    	        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
//    	        dispatcher.forward(request, response);
    	        response.setContentType("text/html");
    	        PrintWriter out = response.getWriter();
    	        
    	        List<todo_task> userdetails = listUser;
    	        
    	    	out.println(new Gson().toJson(listUser));

    	    }

    protected void addTask(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
    	
    	System.out.println("working..........");
    	String clientOrigin = request.getHeader("origin");
    	
    	
    	response.setHeader("Access-Control-Allow-Origin", clientOrigin);
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Access-Control-Allow-Origin,CopyStreamException,Access-Control-Allow Methods,Access-Control-Max-Age");
        
//    	int id = Integer.parseInt(request.getParameter("id"));
//        String task_desc = request.getParameter("task_desc");
//        System.out.println(task_desc);
         
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        
        todo_task tasks = new todo_task();
        String json = "";
        
         if (br!=null) {
        	 json=br.readLine();
        	 
        	 todo_task data1 = new Gson().fromJson(json , todo_task.class);
    		 System.out.println("Data41 : " + data1.getTask());
        	 
             tasks.setId(10);
             tasks.setTask(data1.getTask());
             userDao.saveTask(tasks);
        	 
         }
        	 
//        	 try {
//        		 todo_task data1 = new Gson().fromJson(json , todo_task.class);
//        		 System.out.println("Data41 : " + data1.getTask());
//            	 
////                 tasks.setId(1000);
//                 tasks.setTask(data1.getTask());
//        	 }
//        	 catch(Exception e){
//        		 
//        		 BufferedReader data1 = br;
//        		 System.out.println("Data41 : " + data1.readLine());
//            	 
////                 tasks.setId(1000);
//                 tasks.setTask(data1.readLine());
//        	 }
             
          
         
         
         
         
         

        
//        response.setContentType("text/xml");
//        PrintWriter writer=response.getWriter();
//        writer.append("this is 404");

//        RequestDispatcher dispatcher = request.getRequestDispatcher("register-success.jsp");
//        dispatcher.forward(request, response);
    }
    
//    private void retrieve(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//    	
//    	todo_task todo_Task = new todo_task();
////    	stud.getId();
//    	System.out.println(todo_Task.getTask());
//    	PrintWriter out = response.getWriter();
//    	out.println(todo_Task.getId());
//    	
//    	
//    	
//    }
 

}
