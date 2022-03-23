<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="template/head.jsp" />
<html>
<body>
<div class="container">

    <div class="row">
        <c:import url="template/navigation.jsp" />
    </div>

    <div class="row">
        <h2 class="text-center">Merge Sort</h2>
        <p class="text-danger">Enter only whole numbers separated by a space!</p>
        <form action="result-servlet-merge" method="GET">
            <div class="form-group">
                <label for="mergesort" class="fw-bold fs-6 mb-2">Numbers Entry</label>
                <input type="text" class="form-control" id="mergesort" name="entry" value="" pattern="[0-9-]+( [0-9-]+)+" required>
            </div>
            <button type="submit" class="bg-success text-white m-3">Submit</button>
            <button type="reset" class="m-3">Clear</button>
        </form>
    </div>
</div>

<c:import url="template/bs-js.jsp" />
</body>
</html>
