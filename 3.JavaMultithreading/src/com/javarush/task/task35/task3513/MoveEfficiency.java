package com.javarush.task.task35.task3513;

public class MoveEfficiency implements Comparable<MoveEfficiency> {
    private int numberOfEmptyTiles, score;
    private Move move;

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    public Move getMove() {
        return move;
    }

    @Override
    public int compareTo(MoveEfficiency o) {
        if (o.numberOfEmptyTiles == numberOfEmptyTiles) {
            return Integer.compare(score, o.score);
        } else if (o.numberOfEmptyTiles > numberOfEmptyTiles)
            return -1;
        else
            return 1;
    }
}
