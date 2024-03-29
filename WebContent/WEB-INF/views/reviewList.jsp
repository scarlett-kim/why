<%@page import="kr.or.bit.dto.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Mobile Specific Meta -->
<meta name="viewport"
   content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Favicon-->
<link rel="shortcut icon" href="img/fav.png">
<!-- Author Meta -->
<meta name="author" content="codepixer">
<!-- Meta Description -->
<meta name="description" content="">
<!-- Meta Keyword -->
<meta name="keywords" content="">

<!-- Favicon -->
<link rel="icon" href="img/core-img/favicon.ico">

<!-- Core Stylesheet -->
<link href="style.css" rel="stylesheet">

<!-- Responsive CSS -->
<link href="css/responsive/responsive.css" rel="stylesheet">

<link
   href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700"
   rel="stylesheet">

<!-- fontAwesome -->
<link rel="stylesheet"
   href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />

<!--
         CSS
         ============================================= -->
<link rel="stylesheet" href="css/linearicons.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/magnific-popup.css">
<link rel="stylesheet" href="css/nice-select.css">
<link rel="stylesheet" href="css/animate.min.css">
<link rel="stylesheet" href="css/owl.carousel.css">
<link rel="stylesheet" href="css/main.css">

<!-- jquery 추가함 iy -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


<style type="text/css">
#titlehover:hover {
 background-color: #E6E6E6;
 color: red;
 
}

#titlehover:visited {
 background-color: #E6E6E6;

 color : red;
}

</style>

</head>

<jsp:include page="/common/top.jsp"></jsp:include>
<body>


   <c:set var="totalcount" value="${requestScope.totalcount}"></c:set>
   <c:set var="cp" value="${requestScope.cp}"></c:set>
   <c:set var="ps" value="${requestScope.ps}"></c:set>
   <c:set var="pagecount" value="${requestScope.pagecount}"></c:set>



   <div class="breadcumb-area bg-img bg-overlay" style="background-image: url(img/bg-img/hero.jpg)">
      <!-- Start post Area -->



      <section class="post-area section-gap" style="padding-top: 200px;">

         <div class="section-heading text-center animated fadeInDown">
            <h2 class="h-bold">
               <i class="far fa-list-alt"></i>&nbsp;&nbsp;Review List
            </h2>
         </div>

         <div style="text-align: center;">
            <a href="ShowReviewWrite.do?bcode=202&tcode=0" class="btn mini blue">
               <button type="submit" id="reviewbtn" class="btn dorne-btn"
                  style="width: 200px; " onclick="check()">
                  <i class="fas fa-pencil-alt"></i>&nbsp;&nbsp;WRITE
               </button>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </a>
               <input type= "text" name="campgnm" id="campgnm" placeholder="검색어를 입력하세요" style ="width:15%; height:52px;">
                    <button type="submit" id="button" name="button" class="btn dorne-btn" style ="width: 200px; background-color:#125448;"><i class="fa fa-search pr-2" aria-hidden="true"></i> Search</button>




<br>
<br>
<hr>

<!--             <div class="single-widget search-widget">
               <form class="example" style="margin: auto; max-width: 500px">
         
                  <input type="text" placeholder="Search Posts" name="search2">
                  <button type="submit">
                     <i class="fa fa-search" style="color: #6b8e23"></i>
                  </button>
               </form>
            </div> -->
            <div class="container" style="margin-bottom: 5%">
               <div class="row">
                  <div class="col-sm ">PageSize설정:</div>
                  <div class="col-sm">
                  <form name="list">
                  <input type="hidden" name="cp" value="1">
                  <input type="hidden" name="bcode" value="202">
                     <select name="ps" onchange="submit()">
                        <c:forEach var="i" begin="5" end="20" step="5">
                           <c:choose>
                              <c:when test="${ps == i}">
                                 <option value='${i}' selected>${i}건</option>
                              </c:when>
                              <c:otherwise>
                                 <option value='${i}'>${i}건</option>
                              </c:otherwise>
                           </c:choose>
                        </c:forEach>
                     </select>
                     </form>
                  </div>
                  <div class="col-sm">&nbsp;&nbsp;&nbsp;&nbsp;총 게시물수 : ${totalcount}</div>
               </div>
            </div>
            
            <br>
            <div class="container">
               <div class="row">
                  <div class="col-sm ">
                     <!--이전 링크 -->
                     <c:if test="${cp>1}">
                        <a href="ReviewList.do?cp=${cp-1}&ps=${ps}&bcode=202"><i class="fas fa-chevron-circle-left"></i></a>
                        <!--페이지 리스트 구현  -->
                     </c:if>
                     <c:forEach var="i" begin="1" end="${pagecount}" step="1">
                        <c:choose>
                           <c:when test="${cp==i}">
                              <a><u><font color='red'>${i}</font></u></a>
                           </c:when>
                           <c:otherwise>
                              <a href="ReviewList.do?cp=${i}&ps=${ps}&bcode=202">&nbsp;${i}&nbsp;</a>
                           </c:otherwise>
                        </c:choose>
                     </c:forEach>
                     <!--다음 링크 -->
                     <c:if test="${cp<pagecount}">
                        <a href="ReviewList.do?cp=${cp+1}&ps=${ps}&bcode=202"><i class="fas fa-chevron-circle-right"></i></a>
                     </c:if>
                  </div>
               </div>
            </div>




<br>
<br>
   <div id="reviewbox">
   
            <c:forEach var="list" items="${requestScope.reviewlist}"  varStatus="status">
            
               <div class="container"  id="inyoung">
                  <div class="row justify-content-center d-flex"></div>
                  <div class="col-lg-12 post-list" id="reviewdiv">

                     <div class="single-post d-flex flex-row">
                        <div class="thumb" style="margin-right:5%">
                           <img src="upload/${list.savename}" alt="후기사진입니다." style="width: 250px" onerror="this.src='./img/bg-img/noimage.gif'">
                        </div>
                        <div class="details" style="margin-top: 1%">
                           <div class="title d-flex flex-row justify-content-between">
                              <div class="titles" id="titlehover" style="font-size: 13px;">
                                 <!-- 제목 -->
                                 <a href="ShowReviewDetail.do?idx=${list.idx}&cp=${cp}&ps=${ps}">
                                    <h4>&nbsp;&nbsp;${list.title}</h4>
                                 </a>
                              </div>
                           </div>
                           
                           <p class="address" style="text-align: left">
                              &nbsp;&nbsp;&nbsp;<i class="fas fa-user"></i>&nbsp;&nbsp;
                              ${list.id}
                           </p>
                           <p class="address" style="text-align: left">
                              <!-- 작성일 -->
                              &nbsp;&nbsp;&nbsp;<i class="far fa-calendar-check"></i>&nbsp;&nbsp;
                              ${list.writedate}
                           </p>
                           <p class="address" style="text-align: left">
                              <!-- 조회수 -->
                              &nbsp;&nbsp;&nbsp;<i class="far fa-eye"></i>&nbsp;&nbsp;
                              ${list.readnum}
                           </p>

                        </div>
                     </div>

                  </div>

               </div>
            </c:forEach>
</div>
         </div>
      </section>
      
      <script type="text/javascript">
      $(function() {


          $('#searchbtn').click(function(){
             var paramdata = {
                     "bcode" : 202,
                      "cp" : '${requestScope.cp}',
                      "ps" : '${requestScope.ps}',
                      "searchword" : $('#campgnm').val()
                    }
             
                if($('#campgnm').val() == ""){
                 alert("검색어를 입력하세요.");
                 $('#campgnm').focus();
              }else{
                console.log("여보세요? " + $('#campgnm').val());
                console.log("여기오니33?");

                 var control ="";
             $.ajax({
                url : "ReviewSearch.do",
                dataType:"JSON",
               data: paramdata,
               type:"get",
               success: function(data){
                  console.log(data);
                 //console.log(data.idx);
                  $('#reviewbox').empty();
                   $.each(data, function(index, object) {
                      console.log(object);
                      //console.log(object.title);
                      
                       control =
                          '<div class="container"><div class="row justify-content-center d-flex"></div><div class="col-lg-12 post-list" id="reviewdiv">'
                          //
                        +'<div class="single-post d-flex flex-row">'
                             + '<div class="thumb" style="margin-right:5%; ">'
                             + '<img style="width: 250px" src="upload/'+object.savename+'" onerror="this.src='+'\'./img/bg-img/noimage.gif\''+'">'
                             + '</div><div class="details" style="margin-top: 1%">'
                             + '<div class="title d-flex flex-row justify-content-between">'
                             + '<div class="titles" id="titlehover" style="font-size: 13px;">'
                             + '<a href="ShowReviewDetail.do?idx=${list.idx}&cp=${requestScope.cp}&ps=${requestScope.ps}">'
                             + '<h4>&nbsp;&nbsp;'+object.title+'</h4></a></div></div>'
                             + '<p style="text-align: left; font-size: 13px;">'
                             //+ object.content
                             + '<p class="address" style="text-align: left">'
                             + '&nbsp;&nbsp;&nbsp;<i class="fas fa-user"></i>&nbsp;&nbsp;'
                             + object.id
                             + '</p><p class="address" style="text-align: left">'
                             + '&nbsp;&nbsp;&nbsp;<i class="far fa-calendar-check"></i>&nbsp;&nbsp;'
                             + object.writedate
                             + '</p><p class="address" style="text-align: left">&nbsp;&nbsp;&nbsp;<i class="far fa-eye"></i>&nbsp;&nbsp;'
                                  + object.readnum
                                  + '</p></div></div></div></div>';
                                  
                                  //console.log(control);
                                  
                                  $('#reviewbox').append(control);
                                  
                   })
               }
             })
            }
          })

      })



      
       

      </script>


      <!-- End footer Area -->

      <script src="js/vendor/jquery-2.2.4.min.js"></script>
      <script
         src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
         integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
         crossorigin="anonymous"></script>
      <script src="js/vendor/bootstrap.min.js"></script>
      <!--    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script> -->
      <script src="js/easing.min.js"></script>
      <script src="js/hoverIntent.js"></script>
      <script src="js/superfish.min.js"></script>
      <script src="js/jquery.ajaxchimp.min.js"></script>
      <script src="js/jquery.magnific-popup.min.js"></script>
      <script src="js/owl.carousel.min.js"></script>
      <script src="js/jquery.sticky.js"></script>
      <script src="js/jquery.nice-select.min.js"></script>
      <script src="js/parallax.min.js"></script>
      <script src="js/mail-script.js"></script>
      <script src="js/main.js"></script>
      <jsp:include page="/common/bottom.jsp"></jsp:include>
</body>

</html>
