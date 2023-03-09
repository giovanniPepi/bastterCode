// Leet Code problem 36, Valid Sudoku
// problem description found on following link:
// https://leetcode.com/problems/valid-sudoku/description/

class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {

        // my board is an instance of Sudoku class
        val myboard = Sudoku(board)
        // mycharlist receives several lists for checking if
        // line, column or square is false.
        var mycharlist = listOf<Char>()

        // loop from 1st to 9th...
        for (i in 0..8){
            // ... line
            mycharlist = myboard.getLine(i).sorted()
            //(sorted because during check number should always increase
            // and never repeat
            if (!listcheck(mycharlist)) return false

            // ... column
            mycharlist = myboard.getColumn(i).sorted()
            if (!listcheck(mycharlist)) return false

            // ... and square
            mycharlist = myboard.getSquare(i).sorted()
            if (!listcheck(mycharlist)) return false
        }

        return true
        
    }

    // this function receives a list of 9 sorted chars.
    // an empty char is represented by a ".", which when converted to int becomes 46.
    // a valid char is converted to a number that should always increase and never repeat.
    // if it repeats, return false
    fun listcheck(list: List<Char>): Boolean{
        // num stores the last known number
        var num = 0
        for (i in list.indices){
            // if empty (".") goes to next iteration
            if (list[i].toInt() == 46) continue
            // if a number repeats it's false
            if (num == list[i].toInt()) return false
            // stores present number in num
            else num = list[i].toInt()
        }
        return true
    }
}

// class for receiveing a Sudoku board and performing some board functions
class Sudoku(val board: Array<CharArray>) {

    // gets a line in a board
    fun getLine (line: Int): CharArray {
        return board[line]
    }

    // gets a column in a board
    fun getColumn (column: Int): CharArray{
        var columnArray = CharArray(9)
        // loop around every line in same column
        for (i in 0..8){
            columnArray[i] = board[i][column]
        }
        return columnArray
    }

    // gets a 3 by 3 square from a board
    fun getSquare (square: Int): CharArray{
        var squareArray = CharArray(9)
        // adopting that 3x3 squares are indexed from 0 to 8.
        // square 0 has starting line 0 and starting column 0
        // square 1 has starting line 0 and starting column 3
        // and so on until...
        // square 8 has starting line 6 and starting column 6
        // the following equations perform that calculation
        val startLine = (square / 3) * 3
        val startCol = (square % 3) * 3
        var k = 0
        // double loop from starting position up to the following 2 positions
        for (i in startLine..(startLine + 2)){
            for (j in startCol..(startCol + 2)){
                squareArray[k] = board[i][j]
                k++
            }
        }
        return squareArray
    }

}
