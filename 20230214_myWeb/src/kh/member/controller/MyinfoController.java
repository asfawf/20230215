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
 * Servlet implementation class MyinfoController
 */
@WebServlet("/myinfo")
public class MyinfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyinfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//DB 가기 + 내 ID 에 관한거
		String id=  null;
		
		if(req.getSession().getAttribute("lgnss") != null) {
			id = ((MemberVo)(req.getSession().getAttribute("lgnss"))).getId();
		} 
		
		if(id != null) {
			req.setAttribute("myinfo", new MemberService().myInfo(id));
			req.getRequestDispatcher("/WEB-INF/view/member/myinfo.jsp").forward(req, resp);
		}else {
			req.setAttribute("errorMsg", "로그인 되지 않아 확인불가");
			req.getRequestDispatcher("/WEB-INF/view/error/errorLogin.jsp").forward(req, resp);
			
		} 
		
		
	}



}
