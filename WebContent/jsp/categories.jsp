<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>



<jsp:include page="header.jsp"></jsp:include>

    

    <div class="site-section">
      <div class="container">
        <div class="row">
          <div class="col-lg-9">
            <div class="section-title">
              <h2>${categoryname}</h2>
            </div>
            
            	<c:forEach items="${listNews}" var="news">
            <div class="post-entry-2 d-flex">
              <div class="thumbnail order-md-2"><img src="${pageContext.request.contextPath}/images_news/${news.image}" alt="Image" class="img-fluid"></div>
              <div class="contents order-md-1 pl-0">
                <h2 style="word-wrap: break-word;"><a href="blog-single.html"><c:out value="${news.newsName}" /></a></h2>
                <p class="mb-3" style="word-wrap: break-word;"><c:out value="${news.description}" /></p>
                <div class="post-meta">
                  <span class="d-block"><c:out value="${news.userName}" /></span>
                  <span class="date-read"><c:out value="${news.datePost}" /> <span class="mx-1">&bullet;</span> 3 min read <span class="icon-star2"></span></span>
                </div>
              </div>
            </div>
			</c:forEach>

          </div>
          <div class="col-lg-3">
            <div class="section-title">
              <h2>Popular Posts</h2>
            </div>

            <div class="trend-entry d-flex">
              <div class="number align-self-start">01</div>
              <div class="trend-contents">
                <h2><a href="blog-single.html">News Needs to Meet Its Audiences Where They Are</a></h2>
                <div class="post-meta">
                  <span class="d-block"><a href="#">Dave Rogers</a> in <a href="#">News</a></span>
                  <span class="date-read">Jun 14 <span class="mx-1">&bullet;</span> 3 min read <span class="icon-star2"></span></span>
                </div>
              </div>
            </div>

            <div class="trend-entry d-flex">
              <div class="number align-self-start">02</div>
              <div class="trend-contents">
                <h2><a href="blog-single.html">News Needs to Meet Its Audiences Where They Are</a></h2>
                <div class="post-meta">
                  <span class="d-block"><a href="#">Dave Rogers</a> in <a href="#">News</a></span>
                  <span class="date-read">Jun 14 <span class="mx-1">&bullet;</span> 3 min read <span class="icon-star2"></span></span>
                </div>
              </div>
            </div>

            <div class="trend-entry d-flex">
              <div class="number align-self-start">03</div>
              <div class="trend-contents">
                <h2><a href="blog-single.html">News Needs to Meet Its Audiences Where They Are</a></h2>
                <div class="post-meta">
                  <span class="d-block"><a href="#">Dave Rogers</a> in <a href="#">News</a></span>
                  <span class="date-read">Jun 14 <span class="mx-1">&bullet;</span> 3 min read <span class="icon-star2"></span></span>
                </div>
              </div>
            </div>

            <div class="trend-entry d-flex pl-0">
              <div class="number align-self-start">04</div>
              <div class="trend-contents">
                <h2><a href="blog-single.html">News Needs to Meet Its Audiences Where They Are</a></h2>
                <div class="post-meta">
                  <span class="d-block"><a href="#">Dave Rogers</a> in <a href="#">News</a></span>
                  <span class="date-read">Jun 14 <span class="mx-1">&bullet;</span> 3 min read <span class="icon-star2"></span></span>
                </div>
              </div>
            </div>
            
            <p>
              <a href="#" class="more">See All Popular <span class="icon-keyboard_arrow_right"></span></a>
            </p>
          </div>
        </div>
	<c:url value="categories.html" var="url_paging">
		<c:param name="action" value="paging" />
		<c:param name="keyname" value="${keyname}" />
		<c:param name="categoryid" value="${categoryid}" />
		<c:param name="trending" value="${trending}" />
	</c:url>
        <div class="row">
          <div class="col-lg-6">
            <ul class="custom-pagination list-unstyled">
              <li><a href="${url_paging}&currentpage=${previous}">${previouschar}</a></li>
              <c:forEach items="${listPaging}" var="Paging">
              <li <c:if test = "${currentpage == Paging}"> class="active"</c:if>><a href="${url_paging}&currentpage=${Paging}">${Paging}</a></li>
              </c:forEach>
              <li><a href="${url_paging}&currentpage=${next}">${nextchar}</a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>




 <jsp:include page="footer.jsp"></jsp:include>