<%@include file="includes/header.jsp"%>

<h1>Unplash Colllections</h1>

<div class="container">

    <p class="message">${message}</p>
    <c:forEach items="${unplashcollections}" var="item">
   ${item.title}
   <a href="/unplashPublishCollection?id=${item.id}">publish</a>
  </c:forEach>

</div>
<%@include file="includes/footer.jsp"%>
