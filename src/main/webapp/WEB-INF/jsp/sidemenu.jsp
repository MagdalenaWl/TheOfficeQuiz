<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<section class="dashboard-section">
    <div class="row dashboard-nowrap">
        <ul class="nav flex-column long-bg">
            <li class="nav-item">
                <a class="nav-link" href="/quiz/quotes">
                    <span>Who said that?</span>
                    <i class="fas fa-angle-right"></i>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/quiz/writers">
                    <span>Who wrote it?</span>
                    <i class="fas fa-angle-right"></i>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/quiz/directors">
                    <span>Who directed it?</span>
                    <i class="fas fa-angle-right"></i>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/quiz/question">
                    <span>Users questions</span>
                    <i class="fas fa-angle-right"></i>
                </a>
            </li>
            <sec:authorize access="hasAuthority('USER')">
                <li class="nav-item">
                    <a class="nav-link" href="/add/quote">
                        <span>Add quote</span>
                        <i class="fas fa-angle-right"></i>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/add/question">
                        <span>Add question</span>
                        <i class="fas fa-angle-right"></i>
                    </a>
                </li>
            </sec:authorize>

            <sec:authorize access="hasAuthority('MODERATOR')">
            <li class="nav-item">
                <a class="nav-link" href="/add/approve">
                    <span>For approval</span>
                    <i class="fas fa-angle-right"></i>
                </a>
            </li>
        </sec:authorize>
        </ul>