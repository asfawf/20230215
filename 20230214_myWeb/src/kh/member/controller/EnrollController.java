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
@WebServlet("/enroll")
public class EnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/member/enroll.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//0. 방출할거
		int result = 0;
		//req.setCharacterEncoding("UTF-8");
		//1. 전달받은 데이터 읽어 변수에 저장
		String id= req.getParameter("id");
		String passwd= req.getParameter("passwd");
		String name= req.getParameter("name");
		String email= req.getParameter("email");
		MemberVo vo = new MemberVo();
		//4개 뭉텅이로 넣기
		vo.setEmail(email);
		vo.setId(id);
		vo.setName(name);
		vo.setPasswd(passwd);
		System.out.println("Ctrl : " + vo);
		//2. DB 다녀오기
		result = new MemberService().enroll(vo);
		
		if(result< 1 ) {
			System.out.println("회원가입 실패");
		}	else {
			System.out.println("회원가입 성공");
			resp.sendRedirect(req.getContextPath()+"/");
		}
		
		
	}
}
