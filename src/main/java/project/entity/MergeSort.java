package project.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Demo code for merge sort
 */
public class MergeSort {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private int[] userArray;
    private ArrayList<String> actionList;

    /**
     * class constructor
     */
    public MergeSort(){
        actionList = new ArrayList<>();
    }

    /**
     *  Gets the array of integers
     * @return array of integers
     */
    public int[] getArray() {
        return this.userArray;
    }

    /**
     *  Sets the array of integers
     * @param newArray user-input array
     */
    public void setArray(int[] newArray) {
        this.userArray = newArray;
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
     * Creates an array of numbers from the entry
     * @param entry user entered string list of numbers
     */
    public void createArray(String entry) {
        String[] entryArray = entry.split("\\s");
        int[] newArray = new int[entryArray.length];
        int tempCount = 0;
        for(String element : entryArray) {
            newArray[tempCount] = (Integer.parseInt(element));
            tempCount++;
        }
        setArray(newArray);
    }

    /**
     * Sorts the entered array by calling the mergeSort method
     */
    public void sortArray() {
        int[] mergedArray = getArray();
        logger.info("-----NEW INPUT-----");
        mergeSort(mergedArray, mergedArray.length);
    }

    /**
     * Recursive method that splits the entered array into two
     * @param enteredArray array to be split
     * @param arrayLength length of the array to be split
     */
    public void mergeSort(int[] enteredArray, int arrayLength) {
        // exits the recursive call if the array length is less than 2
        if (arrayLength < 2) {
            return;
        }
        int halfWay = arrayLength / 2;
        // Java rounds down, so we need an exact length from the halfway to the end of the array length
        // in the case of odd numbered array lengths such as 7
        int beyondHalfWay = arrayLength - halfWay;
        int[] firstHalf = new int[halfWay];
        int[] secondHalf = new int[beyondHalfWay];

        System.arraycopy(enteredArray, 0, firstHalf, 0, halfWay);
        System.arraycopy(enteredArray, halfWay, secondHalf, 0, beyondHalfWay);
        logger.info("-----SPLITTING ARRAYS-----");
        addActionList("-----SPLITTING ARRAYS-----");
        logger.info("FirstHalf: " + Arrays.toString(firstHalf) + " | " + "SecondHalf: " + Arrays.toString(secondHalf));
        addActionList("FirstHalf: " + Arrays.toString(firstHalf) + " | " + "SecondHalf: " + Arrays.toString(secondHalf));
        // sorts through first half of the original array until only 1 element remains in each array
        mergeSort(firstHalf, halfWay);
        // then sorts through the second half of the original array until only 1 element remains in each array
        mergeSort(secondHalf, beyondHalfWay);
        logger.info("-----MERGING ARRAYS-----");
        addActionList("-----MERGING ARRAYS-----");
        // merges the first half and second half of the entered array
        mergeArray(enteredArray, firstHalf, secondHalf, halfWay, beyondHalfWay);
    }

    /**
     * Loops through the two arrays made from splitting the entered array
     * @param enteredArray the array that was split
     * @param firstHalf first half of the entered array
     * @param secondHalf second half of the entered array
     * @param firstInt length of the entered array from start to halfway
     * @param secondInt length of the entered array from halfway to end
     */
    public void mergeArray(int[] enteredArray, int[] firstHalf, int[] secondHalf, int firstInt, int secondInt) {
        logger.info("FirstHalf: " + Arrays.toString(firstHalf) + " | " + "SecondHalf: " + Arrays.toString(secondHalf));
        addActionList("FirstHalf: " + Arrays.toString(firstHalf) + " | " + "SecondHalf: " + Arrays.toString(secondHalf));
        // counters for the firstHalf, secondHalf, and enteredArray arrays
        int i = 0, j = 0, k = 0;
        // checks for the smallest number between firstHalf and secondHalf and then replaces the numbers in enteredArray
        while (i < firstInt && j < secondInt) {
            if (firstHalf[i] <= secondHalf[j]) {
                enteredArray[k++] = firstHalf[i++];
            }
            else {
                enteredArray[k++] = secondHalf[j++];
            }
        }
        // adds in the rest of the numbers of the firstHalf and secondHalf arrays to the enteredArray
        // counter catches up to the length of their halves
        while (i < firstInt) {
            enteredArray[k++] = firstHalf[i++];
        }
        while (j < secondInt) {
            enteredArray[k++] = secondHalf[j++];
        }
        logger.info("MergedArray: " + Arrays.toString(enteredArray));
        addActionList("MergedArray: " + Arrays.toString(enteredArray));
        setArray(enteredArray);
    }
}
