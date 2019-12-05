<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>



<div class="header-top">
	<div class="container">
		<div class="row align-items-center">
			<div class="col-12 col-lg-6 d-flex">
				<a href="index.html" class="site-logo"> Meranda </a> <a href="#"
					class="ml-auto d-inline-block d-lg-none site-menu-toggle js-menu-toggle text-black"><span
					class="icon-menu h3"></span></a>

			</div>
			<div class="col-12 col-lg-6 ml-auto d-flex">
				<div class="ml-md-auto top-social d-none d-lg-inline-block">
					<a href="#" class="d-inline-block p-3"><span
						class="icon-facebook"></span></a> <a href="#"
						class="d-inline-block p-3"><span class="icon-twitter"></span></a>
					<a href="#" class="d-inline-block p-3"><span
						class="icon-instagram"></span></a>
				</div>
				<form action="#" class="search-form d-inline-block">

					<div class="d-flex">
						<input type="email" class="form-control" placeholder="Search...">
						<button type="submit" class="btn btn-secondary">
							<span class="icon-search"></span>
						</button>
					</div>
				</form>


			</div>
			<div class="col-6 d-block d-lg-none text-right"></div>
		</div>
	</div>




	<div
		class="site-navbar py-2 js-sticky-header site-navbar-target d-none pl-0 d-lg-block"
		role="banner">

		<div class="container">
			<div class="d-flex align-items-center">

				<div class="mr-auto">
					<nav class="site-navigation position-relative text-right"
						role="navigation">
						<ul
							class="site-menu main-menu js-clone-nav mr-auto d-none pl-0 d-lg-block">
							<li class="active"><a
								href="${pageContext.request.contextPath}/index.html"
								class="nav-link text-left">Home</a></li>
							<c:forEach items="${listcategory}" var="category">
								<li><a href="categories.html" class="nav-link text-left"><c:out
											value="${category.categoryName}" /></a></li>
							</c:forEach>
							<li><a href="contact.html" class="nav-link text-left">Contact</a></li>
						</ul>
					</nav>

				</div>

			</div>
		</div>

	</div>

</div>