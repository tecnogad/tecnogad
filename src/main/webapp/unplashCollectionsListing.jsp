<%@include file="includes/header.jsp"%>

<h1>Unplash Colllections</h1>

<div class="container">

    <p class="message">${message}</p>
    <c:forEach items="${unplashcollections}" var="item">
   ${item.title}
  </c:forEach>

</div>
<%@include file="includes/footer.jsp"%>
