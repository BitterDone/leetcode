import java.util.HashSet;
class Solution {
    public static void main(String[] args) {
        String[][] s = new String[][]{
        {"5","3",".",".","7",".",".",".","."},
        {"6",".",".","1","9","5",".",".","."},
        {".","9","8",".",".",".",".","6","."},
        {"8",".",".",".","6",".",".",".","3"},
        {"4",".",".","8",".","3",".",".","1"},
        {"7",".",".",".","2",".",".",".","6"},
        {".","6",".",".",".",".","2","8","."},
        {".",".",".","4","1","9",".",".","5"},
        {".",".",".",".","8",".",".","7","9"}};

        char[][] b = new char[9][9];
        for(int _y=0;_y<s.length;_y++) {
            for(int _x=0;_x<s.length;_x++) {
                b[_y][_x] = convertString(s[_y][_x]);
            }
        }
        solveSudoku(b);
    }
    public static void solveSudoku(char[][] b) {
        _solveSudoku(b);
    }
    public static boolean _solveSudoku(char[][] b) {
        pBoard(b);
        // given a board, find the next open space
        // save its coords
        int[] currSpace = findNextSpace(b);
        // pArrI(currSpace, "is next space");
        if (currSpace[0] == 9) {
            p("The board is solved!");
            return true;
        }

        // insert a minimum starting value
        // 49 50 51 52 53 54 55 56 57
        // 1  2  3  4  5  6  7  8  9
        char currVal = 49;

        // check for duplicates
        // if duplicate
        //      go back - by recursion, return false
        //      increment the starting value
        //      check for duplicates again
        boolean moveToNextSq = false;
        while (!moveToNextSq && currVal < 58) {
            b[currSpace[0]][currSpace[1]] = currVal; // or here?
            // p("---" + currSpace[0] + ", " + currSpace[1] + ": " + currVal + " Attempting for space " );
            // check the row, column, sq for duplicates
            boolean isDuplicated = duplicatesExist(b, currSpace);

            // if no duplicate
            if (!isDuplicated) {
                p(currSpace[0] + ", " + currSpace[1] + ": " + currVal + " inserted");

                // recurse for next loop (find the next open space)
                // repeat until no open spaces remain
                moveToNextSq = _solveSudoku(b);
            }
            
            if (currVal < 58) {
                currVal++;
            }
        }

        // need to back up one level
        if (!moveToNextSq && currVal == 58) { 
            p(currSpace[0] + ", " + currSpace[1] + ": " + currVal + " ERROR -------------- dead end at space ");
            b[currSpace[0]][currSpace[1]] = '.';

            moveToNextSq = false;
        }

        return moveToNextSq;
    }

    static char convertString(String i) { return i.charAt(0); }
    static char convertInt(int i) { return (char)(i + 48); }
    static int convertChar(char c) { return (int)(c - 48); }

    static boolean duplicatesExist(char[][] b, int[] coords) {
        char[] tRow = getRowFor(b, coords[0]);
        if (hasDuplicates(tRow)) { return true; }
        char[] tCol = getColFor(b, coords[1]);
        if (hasDuplicates(tCol)) { return true; }
        char[] tSq = getSqFor(b, coords[0],
         coords[1]);
        if (hasDuplicates(tSq)) { return true; }
        return false;
    }

    static boolean hasDuplicates(char[] test) {
        HashSet<Character> chars = new HashSet<Character>();
        for(char c: test) {
            if (c == '.') { continue; }
            if (!chars.add(c)) { return true; }
        }
        return false;
    }

    static int[] findNextSpace(char[][] board) {
        int[] coords = new int[]{9,9};
        for(int _y=0;_y<board.length;_y++) {
            for(int _x=0;_x<board.length;_x++) {
                if (board[_y][_x] == '.') {
                    coords[0] = _y;
                    coords[1] = _x;
                    return coords;
                }
            }   
        }
        return coords;
    }

    static char[] getRowFor(char[][] board, int y) {
        char[] row = new char[9];
        for (int col=0;col<9;col++) {
            row[col] = board[y][col];
        }
        return row;
    }
    static char[] getColFor(char[][] board, int x) {
        char[] col = new char[9];
        for (int row=0;row<9;row++) {
            col[row] = board[row][x];
        }
        return col;
    }
    static char[] getSqFor(char[][]board, int _y, int _x) {
        char[] sq = new char[9];

        int lowY = (int)_y/3;
        int lowX = (int)_x/3;
        if (2 < lowY) { lowY = 2; }
        if (2 < lowX) { lowX = 2; }

        for (int y=0;y<3;y++) {
            for (int x=0;x<3;x++) {
                sq[(3*y) + x] = board[lowY*3 + y][lowX*3 + x];
            }
        }
        return sq;
    }
    static void pArrC(char[] c) { 
        String s = "";
        for(int i=0;i<c.length;i++) { 
            s = s + " " + c[i];
        }
        p(s);
    }
    static void pArrI(int[] c) { pArrI(c); }
    static void pArrI(int[] c, String m) { 
        String s = "";
        for(int i=0;i<c.length;i++) { 
            s = s + " " + c[i];
        }
        p(s + " - " + m);
    }
    static void pBoard(char[][] b) {
        for (int y=0;y<3;y++) {
            pArrC(b[y]);
        }
    }
    static void p(char m) { System.out.println(m); }
    static void p(String m) { System.out.println(m); }
}