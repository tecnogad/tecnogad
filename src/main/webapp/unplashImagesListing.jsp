<%@include file="includes/header.jsp"%>

<h1>Unplash</h1>

<div class="container">

    <p class="message">${message}</p>
    <c:forEach items="${images}" var="item">
   <img src=" ${item.small}"><br>
</c:forEach>
              <a class="btn btn-default" href="/unplashCreateCollection">
              Create collection
            </a>

</div>
<%@include file="includes/footer.jsp"%>
