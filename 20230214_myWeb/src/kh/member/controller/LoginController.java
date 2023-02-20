package kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.member.model.service.MemberService;
import kh.member.model.vo.MemberVo;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/member/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("login post");
		MemberVo vo = new MemberVo();
		
		vo.setId(req.getParameter("id"));
		vo.setPasswd(req.getParameter("passwd"));
		
		//String id = req.getParameter("id");
		//String passwd = req.getParameter("passwd");
		
		//2
		MemberVo result = new MemberService().login(vo);
		if(result != null) {
			System.out.println("로그인성공");
			req.getSession().setAttribute("lgnss", result);
		}else {
			System.out.println("로그인실패");
		}
		
		resp.sendRedirect(req.getContextPath()+"/");
		
		//3-1. 페이지 이동 마지막에는 resp.sendRedirect
		//3-2. request.setAttribute("name1", "값")
		//3-2. 페이지 이동 및 데이터 전달 + 마지막에는 resp.getRequestDispatcher(path).forward(req,resp);
		//3-3. out.println(값); out.flush(); out.close();
				
		
	}
}
