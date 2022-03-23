<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="template/head.jsp" />
<html>
<body>
    <div class="container">
        <div class="row">
            <c:import url="template/navigation.jsp" />
        </div>
        <h3 class="text-center">Results</h3>
        <c:if test="${chartHere != null}">
        <div class="text-center p-3">
            <img src="images/Breadth-First_chart.jpg" alt="graph chart">
        </div>
        </c:if>
        <c:if test="${entryBefore != null}">
            <h3>Entered Input</h3>
            <p>${entryBefore}</p>
        </c:if>
        <c:if test="${entryListAfter != null}">
            <h3>Sorted Input</h3>
            <p>
                <c:forEach var="entryAfter" items="${entryListAfter}" varStatus="entryLoop">
                    ${entryAfter}${entryLoop.last ? "" : ", "}
                </c:forEach>
            </p>
        </c:if>
        <c:if test="${actionList != null}">
            <p>
                <button class="btn btn-info" type="button" data-bs-toggle="collapse" data-bs-target="#actionData" aria-expanded="false" aria-controls="actionData">Show Steps</button>
                <a href ="#bottom" class="btn btn-primary" id="top">Go to end of steps</a>
            </p>
            <div class="collapse" id="actionData">
                <div class="card card-body">
                    <c:forEach var="action" items="${actionList}" varStatus="actionLoop">
                        <p>${action}</p>
                    </c:forEach>
                </div>
            </div>
            <p class="mt-3"><a href ="#top" class="btn btn-primary" id="bottom">Go to top of steps</a></p>
        </c:if>
        <c:import url="template/bs-js.jsp" />

        <c:remove var="chartHere" />
        <c:remove var="entryBefore" />
        <c:remove var="entryListAfter" />
        <c:remove var="actionList" />
</body>
</html>
