package com.javarush.task.task20.task2027;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
//        System.out.println(crossword.length + " " + crossword[0].length);
        char[] a = "home".toCharArray();
//        System.out.println(a[0] == crossword[3][5]);
        detectAllWords(crossword, "home", "same");
//        System.out.println(new File("").getAbsolutePath());
//        System.out.println(new Date().getTime());
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> w = new ArrayList<>();
//        System.out.println(words);
//        System.out.println(words.length);
//        System.out.println(words[0]+words[1]);
        for (int i = 0; i < words.length; i++) {
//            System.out.println(words[i]);
            w.add(new Word(words[i]));
        }
        for (Word ww : w
                ) {
            char[] ch = ww.text.toCharArray();
            boolean b;
            for (int i = 0; i < crossword.length; i++)
                for (int j = 0; j < crossword[0].length; j++) {
                    if (ch[0] == crossword[i][j]) {
                        b = detect(crossword, i, j, ww);
                        if (b) {
                            i = crossword.length;
                            j = crossword[0].length;
                        }
                    }
                }
        }
        return w;
    }

    public static boolean detect(int[][] crossword, int x, int y, Word word) {
        char[] ch = word.text.toCharArray();
        int i = 0, j = 0;
        boolean left = true,
                right = true,
                up = true,
                down = true,
                leftup = true,//+
                leftdown = true,//+
                rightup = true, //+
                rightdown = true;//+
        for (char c : ch
                ) {
            if ((x + i) < crossword.length && (y + j) < crossword[0].length) {
                if (c != crossword[x + i][y + j]) {
                    rightdown = false;
                }
            } else rightdown = false;
            if ((x - i) >= 0 && (y - j) >= 0) {
                if (c != crossword[x - i][y - j]) {
                    leftup = false;
                }
            } else leftup = false;
            if ((x + i) < crossword.length && (y - j) >= 0) {
                if (c != crossword[x + i][y - j]) {
                    rightup = false;
                }
            } else rightup = false;
            if ((x - i) >= 0 && (y + j) < crossword[0].length) {
                if (c != crossword[x - i][y + j]) {
                    leftdown = false;
                }
            } else leftdown = false;
            if ((x - i) >= 0) {
                if (c != crossword[x - i][y]) {
                    left = false;
                }
            } else left = false;
            if ((x + i) < crossword.length) {
                if (c != crossword[x + i][y]) {
                    right = false;
                }
            } else right = false;
            if ((y - j) >= 0) {
                if (c != crossword[x][y - j]) {
                    up = false;
                }
            } else up = false;
            if ((y + j) < crossword[0].length) {
                if (c != crossword[x][y + j]) {
                    down = false;
                }
            } else down = false;
            i++;
            j++;
        }
//        System.out.println("left = " + left + ", right = " + right + ", up = "
//                + up + ", down = " + down + ", leftup = " + leftup + ", leftdown = " + leftdown + ", rightup = " + rightup +
//                ", rightdown = " + rightdown);
//        System.out.println();
        if (!left && !right && !up && !down && !leftdown && !leftup && !rightdown && !rightup)
            return false;
        else {
            i--;
            j--;
            if (left) {
                word.startX = y;
                word.startY = x;
                word.endX = y;
                word.endY = x - i;
//                System.out.println("(" + word.startX + ", " + word.startY + ") - (" + word.endX + ", " + word.endY + ")");
            }
            if (right) {
                word.startX = y;
                word.startY = x;
                word.endX = y;
                word.endY = x + i;
//                System.out.println("(" + word.startX + ", " + word.startY + ") - (" + word.endX + ", " + word.endY + ")");
            }
            if (up) {
                word.startX = y;
                word.startY = x;
                word.endX = y - j;
                word.endY = x;
//                System.out.println("(" + word.startX + ", " + word.startY + ") - (" + word.endX + ", " + word.endY + ")");
            }
            if (down) {
                word.startX = y;
                word.startY = x;
                word.endX = y + j;
                word.endY = x;
//                System.out.println("(" + word.startX + ", " + word.startY + ") - (" + word.endX + ", " + word.endY + ")");
            }
            if (leftdown) {
                word.startX = y;
                word.startY = x;
                word.endX = y + j;
                word.endY = x - i;
//                System.out.println("(" + word.startX + ", " + word.startY + ") - (" + word.endX + ", " + word.endY + ")");
            }
            if (leftup) {
                word.startX = y;
                word.startY = x;
                word.endX = y - j;
                word.endY = x - i;
//                System.out.println("(" + word.startX + ", " + word.startY + ") - (" + word.endX + ", " + word.endY + ")");
            }
            if (rightdown) {
                word.startX = y;
                word.startY = x;
                word.endX = y + i;
                word.endY = x + i;
//                System.out.println("(" + word.startX + ", " + word.startY + ") - (" + word.endX + ", " + word.endY + ")");
            }
            if (rightup) {
                word.startX = y;
                word.startY = x;
                word.endX = y - j;
                word.endY = x + i;
//                System.out.println("(" + word.startX + ", " + word.startY + ") - (" + word.endX + ", " + word.endY + ")");
            }
            return true;
        }
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
