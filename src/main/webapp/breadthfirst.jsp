<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="template/head.jsp" />
<html>
<body>
<div class="container">

    <div class="row">
        <c:import url="template/navigation.jsp" />
    </div>

    <div class="text-center p-3">
        <img src="images/Breadth-First_chart.jpg" alt="graph chart">
    </div>

    <div class="row">
        <h2 class="text-center">Breadth First Search</h2>
        <p class="text-danger">Enter only whole numbers from 1 to 5!</p>
        <form action="result-servlet-breadth" method="GET">
            <div class="form-group">
            <label for="starting-point" class="fw-bold fs-6 mb-2">Start Point</label>
            <input type="text" class="form-control" id="starting-point" name="start" value="" pattern="[1-5]{1}" required>
            </div>

            <div class="form-group">
                <label for="ending-point" class="fw-bold fs-6 mb-2">Destination Point</label>
                <input type="text" class="form-control" id="ending-point" name="end" value="" pattern="[1-5]{1}" required>
            </div>
        <button type="submit" class="bg-success text-white m-3">Submit</button>
        <button type="reset" class="m-3">Clear</button>
        </form>
    </div>
</div>
</div>

<c:import url="template/bs-js.jsp" />
</body>
</html>
