<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Green's Blog</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel = "stylesheet" href = "css/main.css">
<style>
	
	<% String menu = (String) request.getAttribute("menu"); %>
	
	<% if ("1".equals(menu)) { %>
		.main-container nav ul li:nth-of-type(1) a {
			color: black !important;
		}	
		
		.main-bottom ul li:nth-of-type(1) a {
			color: #5ae4cc !important;
		}
	<% } else if ("2".equals(menu)) { %>
		.main-container nav ul li:nth-of-type(2) a {
			color: black !important;
		}	
		
		.main-bottom ul li:nth-of-type(1) a {
			color: #5ae4cc !important;
		}
	<% } else if ("3".equals(menu)) { %>
		.main-container nav ul li:nth-of-type(3) a {
			color: black !important;
		}	
		
		.main-bottom ul li:nth-of-type(1) a {
			color: #5ae4cc !important;
		}
	<% } else if ("4".equals(menu)) { %>
		.main-container nav ul li:nth-of-type(4) a {
			color: black !important;
		}	
		
		.main-bottom ul li:nth-of-type(1) a {
			color: #5ae4cc !important;
		}
	<% } else if ("5".equals(menu)) { %>
		.main-container nav ul li:nth-of-type(5) a {
			color: black !important;
		}	
		
		.main-bottom ul li:nth-of-type(1) a {
			color: #5ae4cc !important;
		}
	<% } else if ("6".equals(menu)) { %>
		.main-container nav ul li:nth-of-type(6) a {
			color: black !important;
		}	
		
		.main-bottom ul li:nth-of-type(1) a {
			color: #5ae4cc !important;
		}
	<% } else if ("7".equals(menu)) { %>
		.main-container nav ul li:nth-of-type(7) a {
			color: black !important;
		}	
		
		.main-bottom ul li:nth-of-type(1) a {
			color: #5ae4cc !important;
		}
	<% } else if ("8".equals(menu)) { %>
		.main-container nav ul li:nth-of-type(8) a {
			color: black !important;
		}	
		
		.main-bottom ul li:nth-of-type(1) a {
			color: #5ae4cc !important;
		}
	<% } else if ("9".equals(menu)) { %>
		.main-container nav ul li:nth-of-type(9) a {
			color: black !important;
		}	
		
		.main-bottom ul li:nth-of-type(1) a {
			color: #5ae4cc !important;
		}
	<% } else if ("10".equals(menu)) { %>
		.main-container nav ul li:nth-of-type(10) a {
			color: black !important;
		}	
		
		.main-bottom ul li:nth-of-type(1) a {
			color: #5ae4cc !important;
		}
	<% } else if ("0".equals(menu)) { %>
		.nav-top h4 a {
			color: black !important;
		}	
		
		.main-bottom ul li:nth-of-type(1) a {
			color: #5ae4cc !important;
		}
	<% }  %>
	
	
</style>
</head>
<body>
	<div class = "page-container">
		<header>
			<h1>Green's Blog</h1>
		</header>
		<div class = "main-container">
			<nav>
				<div class = "nav-top">
					<h4><a href="?menu=0">전체보기</a></h4>
					<a href="#"><span class="material-symbols-outlined" style="color:gray;">settings</span></a>
				</div>
				<ul>
					<li> <a href="?menu=1">Python (12)</a>
					<li> <a href="?menu=2">Java (2)</a>	
					<li> <a href="?menu=3">los (8)</a>		
					<li> <a href="?menu=4">소프트웨어 자료 (26)</a>			
					<li> <a href="?menu=5">자료구조 (8)</a>
					<li> <a href="?menu=6">리눅스 (8)</a>
					<li> <a href="?menu=7">Git (4)</a>
					<li> <a href="?menu=8">자기계발 (3)</a>
					<li> <a href="?menu=9">경영전략 (20)</a>
					<li> <a href="?menu=10">리더쉽 (7)</a>
				</ul>
			</nav>
			<main>
				<div class = "main-top">
					<h4>${menuName}<span style="color:#5ae4cc; margin-left: 6px">${postCount}</span></h4>
					<a href="#"><span class="material-symbols-outlined" style="color:black;">edit_square</span></a>
				</div>
				
				<div class = "main-content">
					<c:choose>
						<%-- 행 수가 4개 이하라면 --%>
						<c:when test="${rowCount <= 4}">
							<c:forEach var="j" begin="0" end="${rowCount - 1}" step="1" >
								<div class = "content-row">
									<c:choose>
										<%-- 포스트 개수가 4의 배수라면 --%>
										<c:when test="${colCount == 0}">
											<c:forEach var="i" begin="1" end="4" step="1" >
												<div class="post">
													<img src="images/${j * 4 + i}.jpg">	
													<p class="post-title">제목 ${j * 4 + i}</p>
													<p class="post-date">2023.04.12.</p>			
												</div>												
											</c:forEach>
										</c:when>
										<%-- 포스트 개수가 남는다면 --%>
										<c:otherwise>
											<c:choose>
												<%-- 마지막 행이 아니라면 --%>
												<c:when test="${j < rowCount - 1}">
													<c:forEach var="i" begin="1" end="4" step="1" >
														<div class="post">
															<img src="images/${j * 4 + i}.jpg">	
															<p class="post-title">제목 ${j * 4 + i}</p>
															<p class="post-date">2023.04.12.</p>			
														</div>												
													</c:forEach>
												</c:when>
												<%-- 마지막 행이라면 --%>
												<c:otherwise>
													<c:forEach var="i" begin="1" end="${colCount}" step="1" >
														<div class="post">
															<img src="images/${j * 4 + i}.jpg">	
															<p class="post-title">제목 ${j * 4 + i}</p>
															<p class="post-date">2023.04.12.</p>			
														</div>												
													</c:forEach>
												</c:otherwise>
											</c:choose>
										</c:otherwise>
									
									</c:choose>
								</div>
							</c:forEach>
						</c:when>
						<%-- 행 수가 4개보다 많다면 --%>
						<c:otherwise>
							<c:forEach var="j" begin="0" end="3" step="1" >
								<div class = "content-row">
									<c:forEach var="i" begin="1" end="4" step="1" >
										<div class="post">
											<img src="images/${j * 4 + i}.jpg">	
											<p class="post-title">제목 ${j * 4 + i}</p>
											<p class="post-date">2023.04.12.</p>			
										</div>												
									</c:forEach>
								</div>
							</c:forEach>
						</c:otherwise>
					</c:choose>

				</div>
				<div class = "main-bottom">
					<%-- 페이지 번호 --%>
					<ul>
						<c:choose>
							<%-- 페이지 수가 10 이하라면 --%>
							<c:when test="${pageCount <= 10}">
								<c:forEach var="i" begin="1" end="${pageCount}" step="1">
									<li><a href="#">${i}</a>						
								</c:forEach>							
							</c:when>
							<%-- 페이지 수가 11 이상이라면 --%>
							<c:otherwise>															
								<c:forEach var="i" begin="1" end="10" step="1">
									<li><a href="#">${i}</a>						
								</c:forEach>							
								<li><a href="#">다음 ></a>						
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</main>
		</div>
	</div>
</body>
</html>