package project.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

/**
 * Demo code for breadth first search
 */
public class BreadthFirst {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private ArrayList<String> actionList;

    /**
     * class constructor
     */
    public BreadthFirst(){
        actionList = new ArrayList<>();
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
     * For processing a collection of the locations and marking locations already visited
     * Collection of optional values instead of null pointer exceptions
     * So it either has a value, or it is empty instead of null
     * @param value value to search
     * @param start starting location
     * @param <T> collection of optional locations
     * @return
     */
    public <T>Optional<Location<T>> searchLocation(T value, Location<T> start) {
        // arraydeque has double the capacity of arraylists
        // and performs better when removing the first element of the list
        Queue<Location<T>> queue = new ArrayDeque<>();
        queue.add(start);

        Location<T> currentLocation;
        // set that holds the already visited locations
        Set<Location<T>> alreadyVisited = new HashSet<>();
        while (!queue.isEmpty()) {
            currentLocation = queue.remove();
            logger.info("Visited location with value: {}", currentLocation.getValue());
            addActionList("Visited location with value: " + currentLocation.getValue());
            // if location is new
            if (currentLocation.getValue().equals(value)) {
                // creates an optional object of the location
                return Optional.of(currentLocation);
            } else {
                alreadyVisited.add(currentLocation);
                // add neighbors of the location to the queue
                queue.addAll(currentLocation.getNeighbors());
                // removes already visited locations of the current location from the queue
                queue.removeAll(alreadyVisited);
            }
        }
        // returns an empty optional value
        return Optional.empty();
    }
}
