package project.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Demo code for depth first search
 */
public class DepthFirst {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private ArrayList<String> actionList;
    private Map<Integer, List<Integer>> adjacentVertices;

    /**
     * class constructor
     */
    public DepthFirst(){
        actionList = new ArrayList<>();
        this.adjacentVertices = new HashMap<Integer, List<Integer>>();
    }

    /**
     * Gets action list.
     * @return the action list
     */
    public ArrayList<String> getActionList() {
        return actionList;
    }

    /**
     * Sets action list.
     * @param actionList the action list
     */
    public void setActionList(ArrayList<String> actionList) {
        this.actionList = actionList;
    }

    /**
     * Resets the action list for displaying
     */
    public void resetActionList() {
        this.actionList.clear();
    }

    /**
     * Adds a string action to the action list
     * @param action the string action
     */
    public void addActionList(String action) {
        this.actionList.add(action);
    }

    /**
     * Adds a vertex value to the vertex hash map
     * @param vertex vertex number to be added
     */
    public void addVertex(int vertex) {
        adjacentVertices.putIfAbsent(vertex, new ArrayList<>());
    }

    /**
     * Connects a pathway/edge between two points
     * @param pointOne starting point of edge
     * @param pointTwo ending point of edge
     */
    public void addEdge(int pointOne, int pointTwo) {
        adjacentVertices.get(pointOne).add(pointTwo);
        adjacentVertices.get(pointTwo).add(pointOne);
    }

    /**
     * Starts the search with a starting vertex
     * @param startingPoint starting point of search
     * @param endingPoint ending point of search
     */
    public void startSearch(int startingPoint, int endingPoint) {
        boolean[] isVisited = new boolean[adjacentVertices.size()];
        searchingVertex(startingPoint, isVisited, endingPoint);
    }

    /**
     * Recursive method that checks off current vertex as visited
     * and checks other pathways if they have been visited from the current vertex
     * if not then sets that vertex as the current vertex and repeat until it reaches the destination
     * @param current current vertex
     * @param isVisited visited vertex
     */
    public void searchingVertex(int current, boolean[] isVisited, int endingPoint) {
        // sets every possible isVisited to true to break out of the recursive calls
        if (current == endingPoint) {
            for (Map.Entry<Integer, List<Integer>> point : adjacentVertices.entrySet()) {
                for (int pathway : point.getValue()) {
                    isVisited[pathway] = true;
                }
            }
        }
        isVisited[current] = true;
        logger.info("Visited location with value: {}", current);
        addActionList("Visited vertex with value: " + (current + 1));
        // for each loop that checks each vertex connected to the current vertex
        for (int pathway : adjacentVertices.get(current)) {
            // not true then calls itself and inputs the pathways that have not been visited
            if (!isVisited[pathway]) {
                searchingVertex(pathway, isVisited, endingPoint);
            }
        }
    }

}
