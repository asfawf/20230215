package kh.home.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.board.model.service.BoardService;

/**
 * Servlet implementation class HomeController
 */
@WebServlet({"/", "/main", "/index", "/home"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String aaa= req.getParameter("aaa");
		
		//2. index. jsp를 뿌리기 전에 테이블을 먼저 가서 가져온다 댓글 + DB 갔다오기
			// dto dao service controller view +페이지 불러오기 전에 boardList 읽고 정보 입력해 놓기
			//req.setAttribute("boardlist", new BoardService().getBoardList());
		
			// 1) 총 글 개수 알아오기 -->DB
				int cnt= 0;
				cnt= new BoardService().getCountBoard();
				System.out.println("글 개수 From HomeController: "+cnt);
				
			// 2) 한 페이지당 나타낼 글 수 정하기
				int pageSize= 2; // 보통 10개
			// 3) 페이지 수 정하기 이전 << >> 이후
				int pageBlock= 3; // 보통 5개 --> 1 2 3 4 ==> 5 6 7 8 
			// 4) 현재 페이지
				int currentPage= 1; // default 1 , 페이지 클릭시 변경
				
				try {
					currentPage = Integer.parseInt(aaa);
				}catch (Exception e) {
					// TODO: handle exception
				}
				
			// 5) row num 범위 정하기
				int startRnum = 0;
				int endRnum = 0;
				startRnum = ((currentPage- 1)* pageSize)+ 1 ; // 1-1 , 2-4
				endRnum = (startRnum + pageSize-1 > cnt) ? cnt : startRnum + pageSize-1 ;
				
				System.out.println("startRnum: "+startRnum);
				System.out.println("endRnum: "+endRnum);
				req.setAttribute("boardlist", new BoardService().getBoardList(startRnum, endRnum));
			// 6) 페이지 범위 정하기
				int startPageNum= 0;
				int endPageNum= 0;
				// A ? B : C --> A 가 참이면 B 그게 아니면 C
				/* currentPage % pageBlock == 0 의 경우는 pageBlock이 4일 경우 4의 배수이면 ? 다음의 것 바로 나옴*/
				startPageNum= (currentPage % pageBlock == 0) 
						? ((currentPage/pageBlock -1) * pageBlock + 1) 
						: ((currentPage/pageBlock) * pageBlock + 1);
				// 총 글이 8 개이면 한 페이지 당 3개의 글 씩 보일 경우 3페이지가 필요하다	, 총 글이 8 개이면 한 페이지 당 4개의 글 씩 보일 경우 2페이지가 필요하다	
				int pageCnt = (cnt / pageSize) + (cnt % pageSize==0 ? 0:1);
				/***
				 * 위의 문항을 if 문으로
				 * int pageCnt = (cnt / pageSize);
				 * if(cnt % pageSize != 0){
				 * 	pageCnt++;
				 * }
				 */
				endPageNum = (startPageNum + pageBlock - 1 > pageCnt) ? pageCnt : startPageNum + pageBlock-1 ;
				
				req.setAttribute("startPageNum", startPageNum);
				req.setAttribute("endPageNum", endPageNum);
				req.setAttribute("currentPage", currentPage);
				req.setAttribute("pageCnt", pageCnt);
				
		// 3. 페이지 불러오기
		req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
