package kr.or.bit.service;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.MemberDao;
import kr.or.bit.dto.Member;

public class memberListService implements Action{

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws NamingException {
      ActionForward forward = new ActionForward();
      try {
            String psStr = request.getParameter("ps");    //pagesize
             String cpStr = request.getParameter("cp");    //currentpage
         
            MemberDao memberdao = new MemberDao();
                ArrayList<Member> getmemberlist = memberdao.memberList();
                int totalboardCount = memberdao.totalboardCount();
         /* System.out.print("totalboardCount" + totalboardCount);  26*/    
               if(psStr == null || psStr.trim().equals("")){
                 //default 값
                 psStr = "5"; // default 5건씩 
             }
             
             if(cpStr == null || cpStr.trim().equals("")){
                 cpStr= "1";        //default 1 page
             }
                
              int pagesize = Integer.parseInt(psStr);  //5
             int cpage = Integer.parseInt(cpStr);     //1
             int pagecount = 0;                       
                
             if(totalboardCount % pagesize==0){        //전체 건수 , pagesize > 
                 pagecount = totalboardCount/pagesize;
             }else{
                 pagecount = (totalboardCount/pagesize) + 1;
             }
             //페이지 갯수 : 102 건 , pagesize :5   pagecount: 21

             List<Member> list= memberdao.getMemberList2(cpage, pagesize);
             System.out.println("너 몇키로냐"+list.size());
                request.setAttribute("getmemberlist",getmemberlist);
                request.setAttribute("cpage", cpage);
                request.setAttribute("pagesize", pagesize);
                request.setAttribute("pagecount", pagecount);
                request.setAttribute("list2", list);
                request.setAttribute("totalboardCount", totalboardCount);
                
                forward.setPath("/WEB-INF/views/memberList.jsp");
                System.out.println("서비스 " + getmemberlist);
                
                
           }catch(Exception e){
        	   System.out.println("여긴가????");
              System.out.println(e.getMessage());
           }
      return forward;
   }
}
