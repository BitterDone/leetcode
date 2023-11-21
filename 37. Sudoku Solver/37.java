import java.util.HashSet;
class Solution {
    public void solveSudoku(char[][] b) {
        _solveSudoku(b);
    }
    public boolean _solveSudoku(char[][] b) {
        // given a board, find the next open space
        // save its coords
        int[] currSpace = findNextSpace(b);
        pArrI(currSpace, "is next space");
        if (currSpace[0] == 9) {
            // the board is solved
            p("The board is solved!");
            pBoard(b);
            return true;
        }

        // insert a minimum starting value
        // 49 50 51 52 53 54 55 56 57
        // 1  2  3  4  5  6  7  8  9
        char currVal = 49;
        // b[currSpace[0]][currSpace[1]] = currVal; // here?

        // if duplicate
        //      go back - by recursion, return false
        //      go back - by loops, change y/x to last open space
        //      increment the starting value
        //      check for duplicates again
        boolean haveDuplicates = true;
        while (haveDuplicates && currVal < 58) {
            b[currSpace[0]][currSpace[1]] = currVal; // or here?
            p("---" + currSpace[0] + ", " + currSpace[1] + "Attempting " + currVal + " for space " );
            // check the row, column, sq for duplicates
            haveDuplicates = duplicatesExist(b, currSpace);
            currVal++;

            if (currVal == 58) { // need to back up one level
                p("ERROR -------------- something went wrong with duplicate detection at space " + currSpace[0] + ", " + currSpace[1]);
                pBoard(b);
                b[currSpace[0]][currSpace[1]] = '.';
                return false;
            }

            p("Inserted " + (int)(currVal-1) + " at space " + currSpace[0] + ", " + currSpace[1]);
            // if no duplicate
            //      find the next open space
            // repeat until no open spaces remain
            
            return _solveSudoku(b);
        }




    }

    char convertInt(int i) { return (char)(i + 48); }
    int convertChar(char c) { return (int)(c - 48); }

    boolean duplicatesExist(char[][] b, int[] coords) {
        char[] tRow = getRowFor(b, coords[0]);
        pArrC(tRow);
        if (hasDuplicates(tRow)) { return true; }
        char[] tCol = getColFor(b, coords[1]);
        pArrC(tCol);
        if (hasDuplicates(tCol)) { return true; }
        char[] tSq = getSqFor(b, coords[0], coords[1]);
        pArrC(tSq);
        if (hasDuplicates(tSq)) { return true; }
        return false;
    }

    boolean hasDuplicates(char[] test) {
        HashSet<Character> chars = new HashSet<Character>();
        for(char c: test) {
            if (c == '.') { continue; }
            if (!chars.add(c)) { return true; }
        }
        return false;
    }

    int[] findNextSpace(char[][] board) {
        int[] coords = new int[]{9,9};
        for(int _y=0;_y<board.length;_y++) {
            for(int _x=0;_x<board.length;_x++) {
                if (board[_y][_x] == '.') {
                    coords[0] = _y;
                    coords[1] = _x;
                }
            }   
        }
        return coords;
    }

    char[] getRowFor(char[][] board, int y) {
        char[] row = new char[9];
        for (int col=0;col<9;col++) {
            row[col] = board[y][col];
        }
        return row;
    }
    char[] getColFor(char[][] board, int x) {
        char[] col = new char[9];
        for (int row=0;row<9;row++) {
            col[row] = board[row][x];
        }
        return col;
    }
    char[] getSqFor(char[][]board, int _y, int _x) {
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
    void pArrC(char[] c) { 
        String s = "";
        for(int i=0;i<c.length;i++) { 
            s = s + " " + c[i];
        }
        p(s);
    }
    void pArrI(int[] c) { pArrI(c); }
    void pArrI(int[] c, String m) { 
        String s = "";
        for(int i=0;i<c.length;i++) { 
            s = s + " " + c[i];
        }
        p(s + " - " + m);
    }
    void pBoard(char[][] b) {
        for (int y=0;y<3;y++) {
            pArrC(b[y]);
        }
    }
    void p(char m) { System.out.println(m); }
    void p(String m) { System.out.println(m); }
}