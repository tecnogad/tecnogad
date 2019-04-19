<%@include file="includes/header.jsp"%>
 <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  
<h1>Unsplash Collections</h1>

<div class="container">

    <p class="message">${message}</p>
    <ul class="collection">
    <c:forEach items="${unplashcollections}" var="item">
    <li class="collection-item">
   ${item.title}
   <c:if test="${not item.additionalProperties.published}">
   <a href="/unplashPublishCollection?id=${item.id}">publish</a>
   </c:if></li>
  </c:forEach>
</ul>
</div>
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="js/materialize.js"></script>
  <script src="js/init.js"></script>
<%@include file="includes/footer.jsp"%>
