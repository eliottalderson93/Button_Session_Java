package com.button.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ButtonClick
 */
@WebServlet("/ButtonClick")
public class ButtonClick extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ButtonClick() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/Button.jsp");
		HttpSession session = request.getSession();
		if(session.getAttribute("clicks") == null) {
			session.setAttribute("clicks",0);
			System.out.println("reset");
		}
		//int clicks = (int) session.getAttribute("clicks");
		//request.setAttribute("clicks", clicks);
		System.out.println("Get");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/Button.jsp");
		HttpSession session = request.getSession();
		int clicks = ((int) session.getAttribute("clicks"));
		System.out.println("POST");
		System.out.println(clicks);
		session.setAttribute("clicks", ++clicks);
		System.out.println(clicks);
		//request.setAttribute("clicks", clicks);
		System.out.println("-----------");
		view.forward(request, response);
	}

}
