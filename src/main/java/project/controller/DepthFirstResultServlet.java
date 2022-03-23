package project.controller;

import project.entity.DepthFirst;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet to the results jsp page
 */

@WebServlet(
        urlPatterns = {"/result-servlet-depth"}
)

public class DepthFirstResultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = req.getSession().getServletContext();
        HttpSession session = req.getSession();
        DepthFirst depthFirst = (DepthFirst)context.getAttribute("depthFirst");
        int endingPoint = Integer.parseInt(req.getParameter("end"));
        int startingPoint = Integer.parseInt(req.getParameter("start"));
        String entry = "Starting point= " + startingPoint + " : Ending point= " + endingPoint;
        // clears the action list of previous searches
        depthFirst.resetActionList();

        // hard coded vertex location values
        depthFirst.addVertex(0);
        depthFirst.addVertex(1);
        depthFirst.addVertex(2);
        depthFirst.addVertex(3);
        depthFirst.addVertex(4);

        depthFirst.addEdge(0, 1);
        depthFirst.addEdge(1, 2);
        depthFirst.addEdge(2, 3);
        depthFirst.addEdge(0, 2);
        depthFirst.addEdge(0, 4);

        depthFirst.startSearch(startingPoint - 1, endingPoint - 1);
        session.setAttribute("actionList", depthFirst.getActionList());
        session.setAttribute("entryBefore", entry);
        session.setAttribute("chartHere", 1);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}
