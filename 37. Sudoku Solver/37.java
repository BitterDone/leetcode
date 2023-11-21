class Solution {
    public void solveSudoku(char[][] board) {
        // for(int _x=0;_x<board.length;_x++) {

        //     for(int _y=0;_y<board.length;_y++) {
        //         if (board[x][y])
        //     }

        // }

        // char[][] b = {
        //     //0    1    2    3    4    5    6    7    8
        //     {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'},      // 0
        //     {'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r'},      // 1
        //     {'s', 't', 'u', 'v', 'w', 'x', 'y', 'z', '1'},      // 2
        //     {'2', '3', '4', '5', '6', '7', '8', '9', '10'},     // 3
        //     {'11','12','13','14','15','16','17','18','19'},     // 4
        //     {'20','21','22','23','24','25','26','27','28'},     // 5
        //     {'29','30','31','32','33','34','35','36','37'},     // 6
        //     {'38','39','40','41','42','43','44','45','46'},     // 7
        //     {'47','48','49','50','51','52','53','54','55'}      // 8
        //     };
        String[][] s = {
            //0    1    2    3    4    5    6    7    8
            {"a", "b", "c",    "d", "e", "f",    "g", "h", "i"},      // 0
            {"j", "k", "l",    "m", "n", "o",    "p", "q", "r"},      // 1
            {"s", "t", "u",    "v", "w", "x",    "y", "z", "1"},      // 2
            
            {"2", "3", "4",    "5", "6", "7",    "8", "9", "10"},     // 3
            {"11","12","13",   "14","15","16",   "17","18","19"},     // 4
            {"20","21","22",   "23","24","25",   "26","27","28"},     // 5
            
            {"29","30","31",   "32","33","34",   "35","36","37"},     // 6
            {"38","39","40",   "41","42","43",   "44","45","46"},     // 7
            {"47","48","49",   "50","51","52",   "53","54","55"}      // 8
            };
        // pArr(getRowFor(s, 0));
        // pArr(getColFor(s, 0));
        pArr(getSqFor(s, 0,0));
        pArr(getSqFor(s, 2,2));
        pArr(getSqFor(s, 9,9));

    }

    String[] getRowFor(String[][] board, int y) {
        String[] row = new String[9];
        for (int col=0;col<9;col++) {
            row[col] = board[y][col];
        }
        return row;
    }
    String[] getColFor(String[][] board, int x) {
        String[] col = new String[9];
        for (int row=0;row<9;row++) {
            col[row] = board[row][x];
        }
        return col;
    }
    String[] getSqFor(String[][]board, int _y, int _x) {
        String[] sq = new String[9];

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
    void pArr(String[] c) { 
        String s = "";
        for(int i=0;i<c.length;i++) { 
            s = s + " " + c[i];
        }
        p(s);
    }
    void p(char m) { System.out.println(m); }
    void p(String m) { System.out.println(m); }
}