package project.controller;

import project.entity.BreadthFirst;
import project.entity.Location;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet to the results jsp page
 */

@WebServlet(
        urlPatterns = {"/result-servlet-breadth"}
)

public class BreadthFirstResultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = req.getSession().getServletContext();
        HttpSession session = req.getSession();
        BreadthFirst breadthFirst = (BreadthFirst)context.getAttribute("breadthFirst");
        // clears the action list of previous searches
        breadthFirst.resetActionList();
        // grabs the user inputs
        int endingPoint = Integer.parseInt(req.getParameter("end"));
        int startingPoint = Integer.parseInt(req.getParameter("start"));
        String entry = "Starting point= " + startingPoint + " : Ending point= " + endingPoint;

        ArrayList<Location<Integer>> locationList = new ArrayList<>();

        // hard coded location values
        Location<Integer> firstPoint = new Location<>(1);

        Location<Integer> secondPoint = new Location<>(2);
        firstPoint.connectLocation(secondPoint);

        Location<Integer> thirdPoint = new Location<>(3);
        secondPoint.connectLocation(thirdPoint);
        thirdPoint.connectLocation(firstPoint);

        Location<Integer> fourthPoint = new Location<>(4);
        thirdPoint.connectLocation(fourthPoint);

        Location<Integer> fifthPoint = new Location<>(5);
        firstPoint.connectLocation(fifthPoint);

        locationList.add(firstPoint);
        locationList.add(secondPoint);
        locationList.add(thirdPoint);
        locationList.add(fourthPoint);
        locationList.add(fifthPoint);

        // loops through the location list and compares user input for the starting input
        for (Location<Integer> location : locationList) {
            if (location.getValue() == startingPoint) {
                breadthFirst.searchLocation(endingPoint, location);
            }
        }
        session.setAttribute("actionList", breadthFirst.getActionList());
        session.setAttribute("entryBefore", entry);
        session.setAttribute("chartHere", 1);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}
