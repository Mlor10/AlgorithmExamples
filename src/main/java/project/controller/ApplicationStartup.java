package project.controller;

import project.entity.BreadthFirst;
import project.entity.DepthFirst;
import project.entity.MergeSort;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet that starts up with the application
 */

@WebServlet(
        urlPatterns = {"/applicationStartup"},
        loadOnStartup = 1
)

public class ApplicationStartup extends HttpServlet {
    /**
     * init method that starts with servlet
     */
    public void init() {
        MergeSort mergeSort = new MergeSort();
        BreadthFirst breadthFirst = new BreadthFirst();
        DepthFirst depthFirst = new DepthFirst();
        getServletContext().setAttribute("mergeSort", mergeSort);
        getServletContext().setAttribute("breadthFirst", breadthFirst);
        getServletContext().setAttribute("depthFirst", depthFirst);
    }
}
