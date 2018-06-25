package com.example.student.tilepuzzle;

import java.util.*;

/**
 * @author John Berkley
 * CPP Class: CS420
 * Date Created: Feb 7, 2018
 */

public class EightPuzzle {
    /**
     * Inner Comparator class for priority queue
     */
    public class PuzzleComparator implements Comparator<EightPuzzleBoard> {
        @Override
        public int compare(EightPuzzleBoard p0, EightPuzzleBoard p1) {
            return Integer.compare(p0.getaStar(), p1.getaStar());
        }

    }

    /**
     * A* Search logic
     *
     * @param puzzle current 8-puzzle
     * @param heuristicFunction given heuristic (1 or 2)
     * @return stack with moves
     */
    public Stack<EightPuzzleBoard> aStarSearch(int [][] puzzle, int heuristicFunction) {
        //Set initial state
        EightPuzzleBoard node = new EightPuzzleBoard(puzzle, null, 0, heuristicFunction);
        if(node.isSolvable())
        {
            System.out.println("Puzzle not solvable");
            return new Stack<>();
        }
        //Create frontier & add states
        PriorityQueue<EightPuzzleBoard> frontier = new PriorityQueue<>(10, new PuzzleComparator());
        HashSet<Integer> visited = new HashSet<>();
        frontier.add(node);
        ArrayList<int [][]> possibleMoves;
        EightPuzzleBoard leaf = null;
        while(!frontier.isEmpty())
        {
            //get closest leaf
            leaf = frontier.poll();
            if(leaf.isGoalState())
            {
                if(heuristicFunction == 0)
                {
                    System.out.println("Heuristic: Misplaced Tiles");
                }
                else
                {
                    System.out.println("Heuristic: Manhattan Distance");
                }
                System.out.println("Depth: " + leaf.getCost());
                System.out.println("Search Cost: " + (frontier.size() + visited.size()));
                break;
            }

            visited.add(leaf.hashCode());

            //get next set of possible moves
            possibleMoves = possiblePuzzleMoves(leaf.getPuzzle());
            EightPuzzleBoard puzzleConfig = null;
            for (int[][] puzzleMove : possibleMoves) {
                puzzleConfig = new EightPuzzleBoard(puzzleMove, leaf, leaf.getCost() + 1, heuristicFunction);
                if (!visited.contains(puzzleConfig.hashCode())) {
                    frontier.add(puzzleConfig);
                }
            }

        }
        Stack<EightPuzzleBoard> puzzleMoves = new Stack<>();
        while(leaf != null)
        {
            puzzleMoves.push(leaf);
            leaf = leaf.getOriginalPuzzle();
        }
        return puzzleMoves;
    }

    /**
     * Generate possible moves from current state
     *
     * @param currentPuzzle to be analyzed
     * @return possible moves
     */
    private ArrayList<int[][]> possiblePuzzleMoves(int[][] currentPuzzle) {
        ArrayList<int [][]> possibleMoves = new ArrayList<>();
        //find zero
        int zeroRow = 0;
        int zeroCol = 0;
        for(int i = 0; i < currentPuzzle.length; i++) {
            for (int j = 0; j < currentPuzzle[i].length; j++) {
                if(currentPuzzle[i][j] == 0) {
                    zeroRow = i;
                    zeroCol = j;
                    break;
                }
            }
        }

        //check if zero isn't in top row
        if(zeroRow > 0) {
            int [][]newPuzzleConfig = copy(currentPuzzle);
            int tileAbove = newPuzzleConfig[zeroRow - 1][zeroCol];
            newPuzzleConfig[zeroRow - 1][zeroCol] = 0;
            newPuzzleConfig[zeroRow][zeroCol] = tileAbove;
            possibleMoves.add(newPuzzleConfig);
        }

        //check if zero isn't in bottom row
        if(zeroRow < 2) {
            int [][]newPuzzleConfig = copy(currentPuzzle);
            int tileBelow = newPuzzleConfig[zeroRow + 1][zeroCol];
            newPuzzleConfig[zeroRow + 1][zeroCol] = 0;
            newPuzzleConfig[zeroRow][zeroCol] = tileBelow;
            possibleMoves.add(newPuzzleConfig);

        }

        //check if zero isn't in left col
        if(zeroCol > 0) {
            int [][]newPuzzleConfig = copy(currentPuzzle);
            int tileToLeft = newPuzzleConfig[zeroRow][zeroCol-1];
            newPuzzleConfig[zeroRow][zeroCol-1] = 0;
            newPuzzleConfig[zeroRow][zeroCol] = tileToLeft;
            possibleMoves.add(newPuzzleConfig);
        }

        //check if zero isn't in right col
        if(zeroCol < 2) {
            int [][]newPuzzleConfig = copy(currentPuzzle);
            int tileToRight = newPuzzleConfig[zeroRow][zeroCol+1];
            newPuzzleConfig[zeroRow][zeroCol+1] = 0;
            newPuzzleConfig[zeroRow][zeroCol] = tileToRight;
            possibleMoves.add(newPuzzleConfig);
        }
        return possibleMoves;
    }

    /**
     * Create a copy of a current board state
     *
     * @param original to be copied
     * @return copy as 2D array
     */
    private int[][] copy(int[][] original) {
        int [][] newChild = new int[original.length][];
        for(int i = 0; i < original.length; i++)
            newChild[i] = Arrays.copyOf(original[i],original.length);
        return newChild;
    }

    /**
     * Generates random board state by shuffling 100 times, if state is not
     * valid, reshuffle
     *
     * @param puzzle to be shuffled
     * @param numShuffles how many times to be shuffled
     * @return shuffled board
     */
    public int[][] generateRandomPuzzles(int [][]puzzle, int numShuffles) {
        ArrayList<int [][]> puzzleBoards;
        Random random = new Random();
        for(int i = 0; i < numShuffles; i++)
        {
            puzzleBoards = this.possiblePuzzleMoves(puzzle);
            puzzle = puzzleBoards.get(random.nextInt(puzzleBoards.size()));
        }
        EightPuzzleBoard puzzleBoard = new EightPuzzleBoard(puzzle, null, 0, 0);
        if(puzzleBoard.isSolvable())
            return generateRandomPuzzles(puzzle, 100);
        return puzzle;
    }

    /**
     *Display moves to solve board
     *
     * @param moves stack of moves to perform in order
     */
    public void printMoves(Stack<EightPuzzleBoard> moves) {
        int counter = 0;
        while(!moves.isEmpty())
        {
            int [][]puzzleConfig = moves.pop().getPuzzle();
            System.out.println("Move: " + counter);
            for (int[] aPuzzleConfig : puzzleConfig) {
                for (int anAPuzzleConfig : aPuzzleConfig) {
                    System.out.print(anAPuzzleConfig);
                }
                System.out.println();
            }
            counter++;
            System.out.println();

        }
    }
}
