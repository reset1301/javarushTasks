package com.javarush.task.task35.task3513;

import javax.swing.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
        JFrame game = new JFrame();
        game.setTitle("2048");
        game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game.setSize(450, 500);
        game.setResizable(false);

        game.add(controller.getView());


        game.setLocationRelativeTo(null);
        game.setVisible(true);
//        int[][] mat = {{0, 11, 1, 3}, {0, 0, 0, 0}, {0, 0, 7, 8}, {0, 0, 0, 9}};
//        final int M = mat.length;
//        final int N = mat[0].length;
//        int[][] ret = new int[N][M];
//        for (int r = 0; r < M; r++) {
//            for (int c = 0; c < N; c++) {
//                ret[c][M-1-r] = mat[r][c];
//            }
//        }
//        System.out.println("mat");
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                System.out.print(mat[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println(System.lineSeparator()+"After rotate:");
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                System.out.print(ret[i][j] + " ");
//            }
//            System.out.println();
//        }


//        return ret;
//        int[] tiles = {4, 4, 4, 4};
//        for (int i = 0; i < 3; i++) {
//            if (tiles[i] == tiles[i + 1]) {
//                tiles[i] *= 2;
//                for (int j = i + 1; j < 3; j++) {
//                    tiles[j] = tiles[j + 1];
//                }
//                tiles[3] = 0;
//            }
//        }
//        System.out.println();
//        for (int i = 0; i < 4; i++) {
//            System.out.print(tiles[i] + " ");
//        }
//        System.out.println();
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                System.out.print(a[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//        int count = 0;
//        for (int j = 0; j < 3; j++) {
//            if (tiles[j] == 0) {
//                for (int k = j; k < 3; k++) {
//                    int buf = tiles[k];
//                    tiles[k] = tiles[k + 1];
//                    tiles[k + 1] = buf;
//                }
//                j--;
//                count++;
//                if (count == 4)
//                    break;
//            }
//        }
//        for (int i = 0; i < 4; i++) {
//            int count = 0;
//            for (int j = 0; j < 3; j++) {
//                if (a[i][j] == 0) {
//                    for (int k = j; k < 3; k++) {
//                        int buf = a[i][k];
//                        a[i][k] = a[i][k + 1];
//                        a[i][k + 1] = buf;
//                    }
//                    j--;
//                    count++;
//                    if (count == 4)
//                        break;
//                }
//            }
//        }

//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                System.out.print(a[i][j] + " ");
//            }
//            System.out.println();
//        }
    }
}
