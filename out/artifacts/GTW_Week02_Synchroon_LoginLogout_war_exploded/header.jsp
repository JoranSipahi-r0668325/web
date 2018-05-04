<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header role="banner">
<img alt="Books" src="images/books.jpg">
<h1><span>Library</span></h1>
<nav>
<ul>
<c:choose>
<c:when test="${param.title=='Home'}">
<li  id="actual"><a href="Controller">Home</a></li>
</c:when>
<c:otherwise>
<li><a href="Controller">Home</a></li>
</c:otherwise>
</c:choose>


</ul>
</nav>
<h2>
${param.title}
</h2>
    <c:if test="${sessionScope.user != null}">
        <%--<script src="../js/Status.js"> </script>--%>
        <p id="status"></p>
            <select id="state" name="state">
                <option value="online">online</option>
                <option value="away">away</option>
                <option value="offline" >offline</option>
            </select>
            <input type="text" name="buttonfield" id="buttonfield">
            <input type="button" value="addStatus" id="button"/>
    </c:if>
</header>