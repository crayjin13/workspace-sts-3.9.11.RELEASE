package com.itwill.guest.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

/**
 * Servlet implementation class GuestViewServlet
 */
@WebServlet("/guest_view.do")
public class GuestViewServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forwardPath = "";
		/*
		   http://182.237.126.19/guest_model1/guest_view.do?guest_no=2
			1 . 파라메타받기
			2 . Service객체 메쏘드호출(업무처리)
			3 . 요청객체에 데이타넣기(request)
			4 . JSP forward,redierct 
		*/
			String guest_noStr = request.getParameter("guest_no");
			if(guest_noStr==null||guest_noStr.equals("")){
				//response.sendRedirect("guest_main.jsp");
				forwardPath="redirect:guest_main.do";
			}else {
				try {
					GuestService guestService=new GuestService();
					Guest guest = guestService.selectByNo(Integer.parseInt(guest_noStr));
					if(guest==null){
					/*
						<script>
							alert('존재하지않는 게시물입니다.');
							location.href='guest_list.jsp';
						</script>	
					*/	
						forwardPath="redirect:guest_list.do";
						//forwardPath="forward:guest_list.do";
					}else {
						request.setAttribute("guest", guest);
						forwardPath="forward:/WEB-INF/views/guest_view.jsp";
					}
				}catch (Exception e) {
					e.printStackTrace();
					forwardPath="forward:/WEB-INF/views/guest_error.jsp";
				}
			}
		
	
		
		
		String[] pathArray = forwardPath.split(":");
		String isRedirect = pathArray[0];
		forwardPath = pathArray[1];
		if (isRedirect.equals("redirect")) {
			response.sendRedirect(forwardPath);
		} else if (isRedirect.equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher(forwardPath);
			rd.forward(request, response);
		}

	}

}
