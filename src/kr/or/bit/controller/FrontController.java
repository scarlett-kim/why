package kr.or.bit.controller;

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.service.DetailCrossService;
import kr.or.bit.service.ListCrossService;
import kr.or.bit.service.LoginService;
import kr.or.bit.service.LogoutService;
import kr.or.bit.service.RecentReviewService;
import kr.or.bit.service.ReplyDeleteService;
import kr.or.bit.service.ReplyListService;
import kr.or.bit.service.ReplyWriteService;
import kr.or.bit.service.ReviewDeleteService;
import kr.or.bit.service.ReviewDetailService;
import kr.or.bit.service.ReviewEditOkService;
import kr.or.bit.service.ReviewEditService;
import kr.or.bit.service.ReviewListService;
import kr.or.bit.service.ReviewWriteService;
import kr.or.bit.service.SignUpService;
import kr.or.bit.service.ZzimListService;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public FrontController() {
      super();

   }

   private void doProcess(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      Action action = null;
      ActionForward forward = null;

      String requestURI = request.getRequestURI();
      String contextPath = request.getContextPath();
      String url_Command = requestURI.substring(contextPath.length());

      if (url_Command.equals("/MainCampingview.do")) { // Camping 검색 : main > list
         // UI처리
         forward = new ActionForward();
         forward.setPath("/searchresult.jsp");
      } else if (url_Command.equals("/CampinglistCrossCK.do")) { // 캠핑 API list cross체크 처리
         // UI처리 + 로직처리
         action = new ListCrossService();
         try {
            forward = action.execute(request, response);
         } catch (NamingException e) {
            e.printStackTrace();
         }
         //System.out.println("캠핑API 서비스 갔다왔어요. 지금은 CONTROLLER ");
      } else if (url_Command.equals("/CampingListview.do")) {
         // UI처리
         forward = new ActionForward();
         forward.setPath("/Test2.jsp");
      } else if (url_Command.equals("/CampingDetailCrossCK.do")) { // 캠핑 API detail cross체크 처리
         // UI처리 + 로직처리
         action = new DetailCrossService();
         try {
            forward = action.execute(request, response);
         } catch (NamingException e) {
            e.printStackTrace();
         }
         System.out.println("캠핑API 서비스 갔다왔어요. 지금은 CONTROLLER ");
      } else if (url_Command.equals("/SignUp.do")) { // 양찬식 함수에 else if문 추가
         forward = new ActionForward();
         forward.setPath("/signUp.jsp");
      } else if (url_Command.equals("/SingUpOk.do")) {
         action = new SignUpService();
         try {
            forward = action.execute(request, response);
         } catch (NamingException e) {
            e.printStackTrace();
         }
      } else if (url_Command.equals("/LogIn.do")) {
         forward = new ActionForward();
         forward.setPath("/logIn.jsp");
      } else if (url_Command.equals("/LoginOk.do")) {
         action = new LoginService();
         try {
            forward = action.execute(request, response);
         } catch (NamingException e) {
            e.printStackTrace();
         }
      } else if (url_Command.equals("/LogOut.do")) {
         action = new LogoutService();
         try {
            forward = action.execute(request, response);
         } catch (NamingException e) {
            e.printStackTrace();
         }
      } else if (url_Command.equals("/ZzimListSearch.do")) { // 캠핑 API detail cross체크 처리
         // UI처리 + 로직처리
         action = new ZzimListService();
         try {
            forward = action.execute(request, response);
         } catch (NamingException e) {
            e.printStackTrace();
         }
         System.out.println("찜리스트 검색중");
      } else if (url_Command.equals("/ReviewAdd.do")) { // @function : 후기글쓰기 @Date : 2019-11-24 @Author : 배인영
         // UI처리 + 로직처리
         System.out.println("여기오나요?");
         action = new ReviewWriteService();
         try {
            forward = action.execute(request, response);
         } catch (NamingException e) {
            e.printStackTrace();
         }
      } else if (url_Command.equals("/ReviewList.do")) { // @function : 후기리스트 @Date : 2019-11-24 @Author : 배인영
         // UI처리 + 로직처리
         action = new ReviewListService();
         try {
            forward = action.execute(request, response);
         } catch (NamingException e) {
            e.printStackTrace();
         }
      } else if (url_Command.equals("/ShowReviewWrite.do")) { // @function : 후기 글쓰기 페이지 view단 @Date : 2019-11-24 @Author : 배인영
         // UI처리
         forward = new ActionForward();
         forward.setPath("/review_write.jsp");
      } else if (url_Command.equals("/ShowReviewDetail.do")) {// @function : 후기 글쓰기 페이지 view단 @Date : 2019-11-24 @Author : 배인영
         // UI처리 + 로직처리
         action = new ReviewDetailService();
          try {
			forward = action.execute(request, response);
		} catch (NamingException e) {
			e.printStackTrace();
		}
      }else if(url_Command.equals("/ReviewReplyAdd.do")) {// @function : 후기 댓글 추가  @Date : 2019-11-26 @Author : 배인영
    	  //UI처리 + 로직처리 
    	  action = new ReplyWriteService();
    	  try {
			forward = action.execute(request, response);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		}else if(url_Command.equals("/ShowReviewReply.do")) {// @function : 후기 댓글 보여주세요 @Date : 2019-11-26 @Author : 배인영
			//UI처리 + 로직처리
	    	  action = new ReplyListService();
	    	  try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}else if(url_Command.equals("/DeleteReviewReply.do")) { // @function : 후기 댓글 삭제 @Date : 2019-11-27 @Author : 배인영
			System.out.println("DeleteReviewReply컨트롤러오니?");
	    	  action = new ReplyDeleteService();
			try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}else if(url_Command.equals("/ReviewEdit.do")) { // @function : 후기 수정(보여주는부분select)  @Date : 2019-11-27 @Author : 배인영
			 action = new ReviewEditService();
			 try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}else if(url_Command.equals("/ReviewEditOk.do")) { // @function : 후기 수정(처리하는부분update)  @Date : 2019-11-27 @Author : 배인영
			 action = new ReviewEditOkService();
			 try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}else if(url_Command.equals("/ReviewDelete.do")) { // @function : 후기 삭제  @Date : 2019-11-27 @Author : 배인영
			 action = new ReviewDeleteService();
			 try {
				forward = action.execute(request, response);
				System.out.println("여기오니? ");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}else if(url_Command.equals("/RecentReview.do")) { // @function : 최근후기 5개 (메인에뿌릴것)  @Date : 2019-11-27 @Author : 배인영
			System.out.println("여기오니?최근후기");
			 action = new RecentReviewService();
			 try {
				forward = action.execute(request, response);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
			
         
      

      if (forward != null) {

         RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
         dis.forward(request, response);

      }

   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      doProcess(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      doProcess(request, response);
   }

}