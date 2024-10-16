<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/notice_list.css">
</head>
<body>
<div class="notice-container">
    <h1>공지사항</h1>

    <!-- 검색 필터 -->
    <div class="filter-section">
        <select id="categoryFilter">
            <option value="전체">전체</option>
            <option value="일반">일반</option>
            <option value="오픈소식">오픈소식</option>
            <option value="서비스">서비스</option>
            <option value="당첨자발표">당첨자발표</option>
        </select>
        <input type="text" id="searchInput" placeholder="검색어를 입력해 주세요.">
        <button id="searchButton">검색</button>
    </div>

    <!-- 탭 메뉴 -->
    <div class="tabs">
        <button class="tab active" data-category="전체">전체</button>
        <button class="tab" data-category="일반">일반</button>
        <button class="tab" data-category="오픈소식">오픈소식</button>
        <button class="tab" data-category="서비스">서비스</button>
        <button class="tab" data-category="당첨자발표">당첨자발표</button>
    </div>

    <!-- 공지사항 목록 테이블 -->
    <table class="notice-table">
        <thead>
        <tr>
            <th>번호</th>
            <th>구분</th>
            <th>제목</th>
            <th>등록일</th>
        </tr>
        </thead>
        <tbody>
        <!-- 공지사항 데이터 반복 출력 -->
        <c:forEach var="notice" items="${noticeList}">
            <tr>
                <td>${notice.n_idx}</td>
                <td>${notice.n_category}</td>
                <td>${notice.n_title}</td>
                <td>${notice.n_regdate}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <button class="register-button">공지사항 등록</button>
</div>
</body>
</html>