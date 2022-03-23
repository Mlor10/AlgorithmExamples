package project.controller;

import project.entity.MergeSort;

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
        urlPatterns = {"/result-servlet-merge"}
)

public class MergeSortResultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = req.getSession().getServletContext();
        HttpSession session = req.getSession();
        MergeSort mergeSort = (MergeSort)context.getAttribute("mergeSort");
        // resets the action list from the previous entry
        mergeSort.resetActionList();
        // grabs the user entry
        String entry = req.getParameter("entry");

        mergeSort.createArray(entry);
        mergeSort.sortArray();
        session.setAttribute("entryBefore", entry);
        session.setAttribute("entryListAfter", mergeSort.getArray());
        session.setAttribute("actionList", mergeSort.getActionList());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}