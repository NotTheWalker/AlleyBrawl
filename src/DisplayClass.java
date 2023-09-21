import java.util.ArrayList;
import java.util.Arrays;

public class DisplayClass {
    private static final int ROWS = 12;
    private static final int COLS = 3;


    private static final String CORNER_TL = "╔";
    private static final String CORNER_TR = "╗";
    private static final String CORNER_BL = "╚";
    private static final String CORNER_BR = "╝";
    private static final String HORI = "═";
    private static final String VERT = "║";
    private static final String INTER_T = "╦";
    private static final String INTER_B = "╩";
    private static final String INTER_L = "╠";
    private static final String INTER_R = "╣";
    private static final String INTER_C = "╬";
    private static final String EMPTY = " ";
    private static final String PLAYER = "P";
    private static final String THUG = "T";

    public DisplayClass() {
        throw new IllegalStateException("Utility class");
    }

    public static void display(int playerPosition, ArrayList<Integer> thugPositions) {
        boolean topRow = true;
        String[] rowContentRef = new String[COLS];
        Arrays.fill(rowContentRef, EMPTY);
        for (int i = 0; i < ROWS; i++) {
            String[] rowContent = rowContentRef.clone();
            if (topRow) {
                System.out.println(CORNER_TL + HORI + INTER_T + HORI + INTER_T + HORI + CORNER_TR);
            } else {
                System.out.println(INTER_L + HORI + INTER_C + HORI + INTER_C + HORI + INTER_R);
            }
            for (int j = 0; j < COLS; j++) {
                int[] currentPosition = new int[]{i, j};
                if(Arrays.equals(deriveRowAndColumn(playerPosition), currentPosition)) {
                    rowContent[j] = PLAYER;
                }
                for (Integer thugPosition : thugPositions) {
                    if (Arrays.equals(deriveRowAndColumn(thugPosition), currentPosition)) {
                        rowContent[j] = THUG;
                        break;
                    }
                }
            }
            System.out.println(VERT + rowContent[0] + VERT + rowContent[1] + VERT + rowContent[2] + VERT);
            topRow= false;
        }
        System.out.println(CORNER_BL + HORI + INTER_B + HORI + INTER_B + HORI + CORNER_BR);
    }

    private static int[] deriveRowAndColumn(int index) {//index ranges from 0 to 35
        int row = index / COLS;
        int column = index % COLS;
        return new int[]{row, column};
    }
}
