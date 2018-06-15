package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;
    int score, maxTile;

    java.util.Stack previousStates = new Stack();
    java.util.Stack previousScores = new Stack();

    boolean isSaveNeeded = true;

    public Model() {
        resetGameTiles();
    }

    public void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        score = 0;
        maxTile = 2;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> tileList = new ArrayList<>();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].isEmpty()) {
                    tileList.add(gameTiles[i][j]);
                }
            }
        }
        return tileList;
    }

    private void addTile() {
        List<Tile> tileList = getEmptyTiles();
        if (tileList.size() > 0)
            tileList.get((int) ((tileList.size()) * Math.random())).value = (Math.random() < 0.9 ? 2 : 4);
    }

    private boolean compressTiles(Tile[] tiles) {
        int count = 0;
        boolean b = false;
        for (int j = 0; j < FIELD_WIDTH - 1; j++) {
            if (tiles[j].value == 0) {
                for (int k = j; k < FIELD_WIDTH - 1; k++) {
                    if (tiles[k].value != 0 || tiles[k + 1].value != 0)
                        b = true;
                    int buf = tiles[k].value;
                    tiles[k].value = tiles[k + 1].value;
                    tiles[k + 1].value = buf;
                }
//                b = true;
                j--;
                count++;
                if (count == FIELD_WIDTH)
                    break;
            }
        }
        return b;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean b = false;
        for (int i = 0; i < FIELD_WIDTH - 1; i++) {
            if (tiles[i].value == tiles[i + 1].value && tiles[i].value != 0) {
                tiles[i].value *= 2;
                score += tiles[i].value;
                if (tiles[i].value > maxTile)
                    maxTile = tiles[i].value;
                for (int j = i + 1; j < FIELD_WIDTH - 1; j++) {
                    tiles[j].value = tiles[j + 1].value;
                }
                tiles[FIELD_WIDTH - 1].value = 0;
                b = true;
            }
        }
        return b;
    }

    public void left() {
        if (isSaveNeeded)
            saveState(gameTiles);
        boolean b = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            b = b | compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i]);
        }
        if (b)
            addTile();
        isSaveNeeded = true;
    }

    public void up() {
        saveState(gameTiles);
        gameTiles = rotate();
        gameTiles = rotate();
        gameTiles = rotate();
        left();
        gameTiles = rotate();

    }

    public void down() {
        saveState(gameTiles);
        gameTiles = rotate();
        left();
        gameTiles = rotate();
        gameTiles = rotate();
        gameTiles = rotate();
    }

    public void right() {
        saveState(gameTiles);
        gameTiles = rotate();
        gameTiles = rotate();
        left();
        gameTiles = rotate();
        gameTiles = rotate();

    }

    private Tile[][] rotate() {
        Tile[][] ret = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int r = 0; r < FIELD_WIDTH; r++) {
            for (int c = 0; c < FIELD_WIDTH; c++) {
                ret[c][FIELD_WIDTH - 1 - r] = gameTiles[r][c];
            }
        }
        return ret;
    }

    public boolean canMove() {
        if (getEmptyTiles().size() > 0)
            return true;
        for (int i = 0; i < FIELD_WIDTH - 1; i++) {
            for (int j = 0; j < FIELD_WIDTH - 1; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j + 1].value || gameTiles[i][j].value == gameTiles[i + 1][j].value)
                    return true;
            }
        }
        return false;
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    private void saveState(Tile[][] tiles) {
        Tile[][] saveTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                saveTiles[i][j] = new Tile(tiles[i][j].value);
            }
        }
        previousStates.push(saveTiles);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (!previousScores.empty() && !previousStates.empty()) {
            gameTiles = (Tile[][]) previousStates.pop();
            score = (int) previousScores.pop();
        }
    }

    public void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n) {
            case 0:
                left();
                break;
            case 1:
                right();
                break;
            case 2:
                up();
                break;
            case 3:
                down();
        }
    }

    public boolean hasBoardChanged() {
        Tile[][] previous = (Tile[][]) previousStates.peek();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (previous[i][j].value != gameTiles[i][j].value)
                    return true;
            }
        }
        return false;
    }

    public MoveEfficiency getMoveEfficiency(Move move) {
        MoveEfficiency moveEfficiency;
        move.move();
        if (hasBoardChanged()) moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        else {
            moveEfficiency = new MoveEfficiency(-1, 0, move);
        }
        rollback();
        return moveEfficiency;
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> queue = new PriorityQueue<>(4, Collections.reverseOrder());
        queue.offer(getMoveEfficiency(this::left));
        queue.offer(getMoveEfficiency(this::down));
        queue.offer(getMoveEfficiency(this::up));
        queue.offer(getMoveEfficiency(this::right));
//        assert queue.peek() != null;
        queue.peek().getMove().move();
    }
}
