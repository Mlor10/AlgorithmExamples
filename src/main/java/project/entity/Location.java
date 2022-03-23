package project.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Location<T> {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private T value;
    private Set<Location<T>> neighbors;

    /**
     * empty constructor
     */
    public Location() {
    }

    /**
     * constructor with a parameter for value
     * @param value location value
     */
    public Location(T value) {
        this();
        this.value = value;
        this.neighbors = new HashSet<>();
    }

    /**
     * Gets the value
     * @return location value
     */
    public T getValue() {
        return value;
    }

    /**
     * Returns a read-only set of the neighbor locations
     * @return
     */
    public Set<Location<T>> getNeighbors() {
        return Collections.unmodifiableSet(neighbors);
    }

    /**
     * connects each location of the graph
     * @param location location of the point
     */
    public void connectLocation(Location<T> location) {
        if (this == location) throw new IllegalArgumentException("Can't connect to itself");
        this.neighbors.add(location);
        // allows for an undirected graph
        location.neighbors.add(this);
    }
}
