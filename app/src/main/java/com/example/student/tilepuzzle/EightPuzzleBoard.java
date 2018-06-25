package com.example.student.tilepuzzle;

/**
 * @author John Berkley
 * CPP Class: CS420
 * Date Created: Feb 7, 2018
 */

public class EightPuzzleBoard {
    private int[][] puzzle;
    private EightPuzzleBoard originalPuzzle;
    private int aStar;
    private int cost;
    private boolean isGoalState;

    /**
     * Construct puzzle board
     *
     * @param puzzle current puzzle state
     * @param originalPuzzle original puzzle state
     * @param cost current cost to get to state
     * @param heuristicType heuristic being used to reach state
     */
    public EightPuzzleBoard(int[][] puzzle, EightPuzzleBoard originalPuzzle, int cost, int heuristicType) {
        this.puzzle = puzzle;
        this.originalPuzzle = originalPuzzle;
        this.cost = cost;
        this.isGoalState = false;
        if (heuristicType == 0) {
            //Mismatched tiles heuristic
            int misplacedTiles = misplacedTiles();
            if(misplacedTiles == 0)
                this.isGoalState = true;
            this.aStar = cost + misplacedTiles();
        }
        else if(heuristicType == 1)
        {
            //Manhattan dist heuristic
            int manhattanDistance = manhattanDistance();
            if(manhattanDistance == 0)
            {
                this.isGoalState = true;
            }
            this.aStar = cost + manhattanDistance;
        }
    }

    /**
     *  Get current puzzle state
     *
     * @return puzzle state
     */
    public int[][] getPuzzle() {
        return puzzle;
    }

    /**
     * Get original puzzle state
     *
     * @return original puzzle state
     */
    public EightPuzzleBoard getOriginalPuzzle() {
        return originalPuzzle;
    }

    /**
     * A* value (cost + heuristic)
     *
     * @return A* value
     */
    public int getaStar() {
        return aStar;
    }

    /**
     * Basic cost for current state
     *
     * @return cost
     */
    public int getCost() {
        return cost;
    }

    /**
     * Returns if current state is goal state
     *
     * @return true if current state is goal state, false otherwise
     */
    public boolean isGoalState() {
        return isGoalState;
    }

    /**
     * Hash function for current puzzle state
     * (Sums each square raised to the power of its location)
     *
     * @return hash value
     */
    @Override
    public int hashCode() {
        int hashValue = 0;
        int index = 1;
        for(int i = 0; i < puzzle.length; i++)
        {
            for (int j = 0; j < puzzle[i].length; j++)
            {
                hashValue += Math.pow(-1.0, index)*Math.pow(((puzzle[i][j])), index);
                index++;
            }
        }
        return hashValue;
    }

    /**
     * Gets total number of misplaced tiles for heuristic 1
     *
     * @return tiles misplaced
     */
    private int misplacedTiles() {
        int [][]puzzleConfig = this.puzzle;
        int index = 0;
        int misplacedTiles = 0;
        for(int i = 0; i < puzzleConfig.length; i++)
        {
            for (int j = 0; j < puzzleConfig[i].length; j++)
            {
                if(index != puzzleConfig[i][j])
                {
                    misplacedTiles++;
                }
                index++;
            }
        }
        return misplacedTiles;
    }

    /**
     * Gets manhattan distance for heuristic 2
     *
     * @return manhattan distance
     */
    private int manhattanDistance() {
        int manhattanDistance = 0;
        for (int x = 0; x < puzzle.length; x++)
        {
            for(int y = 0; y < puzzle[x].length; y++)
            {
                int value = puzzle[x][y];
                if(value != 0)
                {
                    int expectedX = (value) / puzzle.length;
                    int expectedY = (value) % puzzle.length;
                    int dx = x - expectedX;
                    int dy = y - expectedY;
                    manhattanDistance += Math.abs(dx) + Math.abs(dy);
                }
            }
        }
        return manhattanDistance;
    }

    /**
     * Checks if board is solvable given current state
     *
     * @return true if solvable, false if not
     */
    public boolean isSolvable() {
        //Keep track of invertedTiles
        int []arrayTransform = new int [9];
        int index = 0;
        for(int i = 0; i < puzzle.length; i++)
        {
            for(int j = 0; j < puzzle[i].length; j++)
            {
                arrayTransform[index] = puzzle[i][j];

            }
        }
        //if invertedTiles is not even then unsolvable
        return (findInvertedTiles(arrayTransform) % 2) != 0;
    }

    /**
     * finds the number of inverted tiles in current row for isSolvable
     *
     * @param array to be checked
     * @return number of inverted tiles
     */
    private int findInvertedTiles(int []array) {
        int invertedTiles = 0;
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            if (value != 0) {
                for(int j = i; j < array.length; j++) {
                    if(value > array[j] && array[j] != 0) {
                        invertedTiles++;
                    }
                }
            }
        }
        return invertedTiles;
    }
}
