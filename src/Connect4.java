//imports
import java.util.Scanner;

public class Connect4{
    //global variables
    final static int WIDTH = 6;
    final static int HEIGHT = 6;
    final static int BOTTOM_ROW = WIDTH - 1;

    //game board
    static char[][] board = new char[WIDTH][HEIGHT];

    //creates scanner
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        //creates board
        CreateBoard();

        //tells player how to play
        System.out.println("Use 0-5 to choose what column you want");

        //displays board
        PrintBoard();

        //creates boolean to determine status of game
        boolean flag = true;

        //main game loop
        while(flag){
            //activates player 1s turn, then prints board
            DropX();
            PrintBoard();

            //determines if player 1 has won
            if(!CheckX()){
                flag = false; //sets flag to false so loop is not repeated if player 1 won
                break; //break to skip player 2s turn if won
            }

            //activates player 2s turn, then prints board
            DropO();
            PrintBoard();

            //determines if player 1 has won
            if(!CheckO()){
                flag = false; //sets flag to false so loop is not repeated if player 2 won
                break; // break for consistency
            }
        }
    }
    public static void CreateBoard() {
        //fills board with '.' for the width and height
        for (int w = 0; WIDTH > w; w += 1) {
            for (int h = 0; HEIGHT > h; h += 1) {
                board[w][h] = '.';
            }
        }
    }

    public static void PrintBoard() {
        //prints the board
        for (int w = 0; WIDTH > w; w += 1) {
            for (int h = 0; HEIGHT > h; h += 1) {
                System.out.print(board[w][h]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void DropX(){
        //creates a counter
        int counter = 1;

        //shows whos turn
        System.out.println("Player 1 turn");

        //gets input
        int column = scanner.nextInt();

        while(true){
            if(column > WIDTH){
                System.out.println("That's not a valid column");
                break;
            }

            if (board[BOTTOM_ROW][column] == '.') { //checks to see if space is blank, puts X there if it is
                board[BOTTOM_ROW][column] = 'X';
                break; //breaks loop after placing
            }else if(board[BOTTOM_ROW][column] == 'X' || board[BOTTOM_ROW][column] == 'O'){ //if space isn't blank, checks to see if one above is
                if(board[BOTTOM_ROW - counter][column] == '.'){ //puts X if blank
                    board[BOTTOM_ROW - counter][column] = 'X';
                    break; //breaks loop after placing
                }
            }
            counter += 1; //adds one to counter if the space wasn't blank, then loops again
            if(counter == WIDTH){ //checks to see if at end of column
                System.out.println("That column is full");
                break;
            }
        }
    }


    public static void DropO(){
        //creates a counter
        int counter = 1;

        //shows whos turn
        System.out.println("Player 2 turn");

        //gets input
        int column = scanner.nextInt();

        while(true){
            if(column > WIDTH){
                System.out.println("That's not a valid column");
                break;
            }

            if (board[BOTTOM_ROW][column] == '.') { //checks to see if space is blank, puts O there if it is
                board[BOTTOM_ROW][column] = 'O';
                break; //breaks loop after placing
            }else if(board[BOTTOM_ROW][column] == 'X' || board[BOTTOM_ROW][column] == 'O'){ //if space isn't blank, checks to see if one above is
                if(board[BOTTOM_ROW - counter][column] == '.'){ //puts O if blank
                    board[BOTTOM_ROW - counter][column] = 'O';
                    break; //breaks loop after placing
                }
            }
            counter += 1; //adds one to counter if the space wasn't blank, then loops again
            if(counter == WIDTH){ //checks to see if at end of column
                System.out.println("That column is full");
                break;
            }
        }
    }

    public static boolean CheckXHorizontal(){
        //creates boolean to act as flag
        boolean flag = true;

        //creates counter
        int counter = 0;
        while(flag){

            //goes through board horizontally
            for(int w = 0; WIDTH > w; w += 1){
                for(int h = 0; HEIGHT > h; h += 1){
                    if(board[w][h] == 'X'){ //if it finds an X, add 1 to counter
                        counter += 1;
                    }else{
                        counter = 0; // if next piece is not an X, set counter to 0
                    }
                    if(counter >= 4){
                        System.out.println("Player 1 wins"); //if counter is greater or equal to 4, player wins
                        flag = false;
                    }
                }
            }
            break;
        }
        return flag;
    }

    public static boolean CheckXVertical(){
        //creates boolean to act as flag
        boolean flag = true;

        //creates counter
        int counter = 0;
        while(flag){

            //goes through board vertically
            for(int h = 0; HEIGHT > h; h += 1){
                for(int w = 0; WIDTH > w; w += 1){
                    if(board[w][h] == 'X'){ //if it finds an X, add 1 to counter
                        counter += 1;
                    }else{
                        counter = 0; // if next piece is not an X, set counter to 0
                    }
                    if(counter >= 4){
                        System.out.println("Player 1 wins"); //if counter is greater or equal to 4, player wins
                        flag = false;
                    }
                }
            }
            break;
        }
        return flag;
    }

    public static boolean CheckOVertical(){
        //creates boolean to act as flag
        boolean flag = true;

        //creates counter
        int counter = 0;
        while(flag){

            //goes through board vertically
            for(int h = 0; HEIGHT > h; h += 1){
                for(int w = 0; WIDTH > w; w += 1){
                    if(board[w][h] == 'O'){ //if it finds an O, add 1 to counter
                        counter += 1;
                    }else{
                        counter = 0; // if next piece is not an O, set counter to 0
                    }
                    if(counter >= 4){
                        System.out.println("Player 2 wins"); //if counter is greater or equal to 4, player wins
                        flag = false;
                    }
                }
            }
            break;
        }
        return flag;
    }

    public static boolean CheckOHorizontal(){
        //creates boolean to act as flag
        boolean flag = true;

        //creates counter
        int counter = 0;
        while(flag){

            //goes through board vertically
            for(int w = 0; WIDTH > w; w += 1){
                for(int h = 0; HEIGHT > h; h += 1){
                    if(board[w][h] == 'O'){ //if it finds an O, add 1 to counter
                        counter += 1;
                    }else{
                        counter = 0; // if next piece is not an O, set counter to 0
                    }
                    if(counter >= 4){
                        System.out.println("Player 2 wins"); //if counter is greater or equal to 4, player wins
                        flag = false;
                    }
                }
            }
            break;
        }
        return flag;
    }

    public static boolean CheckXDiagonalForward(){
        //flag
        boolean flag = true;

        //counter
        int counter = 0;

        //check boolean
        Boolean check = false;

        //checkers
        int checkColumn = 1;
        int checkRow = 1;

        while(flag){ //goes through until an X is found
            for(int w = 0; WIDTH > w; w += 1){
                for(int h = 0; HEIGHT > h; h += 1){
                    if(board[w][h] == 'X'){ //if X is found, add one to counter and go into loop
                        counter += 1;
                        check = true;
                        while(check){ //goes through diagonally looking for Xs
                            if(checkColumn + w <= WIDTH - 1&& checkRow + h <= HEIGHT - 1){
                                if(board[w + checkColumn][h + checkRow] == 'X'){ //if X is found, add 1 to counter
                                    counter += 1;
                                }
                            }

                            //adds 1 to checkers
                            checkColumn += 1;
                            checkRow += 1;

                            if(checkColumn == WIDTH -1 || checkRow == HEIGHT -1){ //if outside of board, break
                                check = false;
                                break;
                            }

                            if(counter >= 4){
                                System.out.println("Player 1 wins"); //if counter is greater or equal to 4, player wins
                                check = false;
                                flag = false;
                                break;
                            }
                        }
                    }
                    if(counter >= 4){
                        flag = false;
                        break;
                    }

                    //resets counter and checkers
                    counter = 0;
                    checkColumn = 1;
                    checkRow = 1;
                }
            }
            break;
        }
        return flag;
    }

    public static boolean CheckODiagonalForward(){
        //flag
        boolean flag = true;

        //counter
        int counter = 0;

        //check boolean
        Boolean check = false;

        //checkers
        int checkColumn = 1;
        int checkRow = 1;

        while(flag){ //goes through until an O is found
            for(int w = 0; WIDTH > w; w += 1){
                for(int h = 0; HEIGHT > h; h += 1){
                    if(board[w][h] == 'O'){ //if O is found, add one to counter and go into loop
                        counter += 1;
                        check = true;
                        while(check){ //goes through diagonally looking for Os
                            if(checkColumn + w <= WIDTH - 1&& checkRow + h <= HEIGHT - 1){
                                if(board[w + checkColumn][h + checkRow] == 'O'){ //if O is found, add 1 to counter
                                    counter += 1;
                                }
                            }

                            //adds 1 to checkers
                            checkColumn += 1;
                            checkRow += 1;

                            if(checkColumn == WIDTH -1 || checkRow == HEIGHT -1){ //if outside of board, break
                                check = false;
                                break;
                            }

                            if(counter >= 4){
                                System.out.println("Player 2 wins"); //if counter is greater or equal to 4, player wins
                                check = false;
                                flag = false;
                                break;
                            }
                        }
                    }
                    if(counter >= 4){
                        flag = false;
                        break;
                    }

                    //resets counter and checkers
                    counter = 0;
                    checkColumn = 1;
                    checkRow = 1;
                }
            }
            break;
        }
        return flag;
    }

    public static boolean CheckXDiagonalBack(){
        //flag
        boolean flag = true;

        //counter
        int counter = 0;

        //check boolean
        Boolean check = false;

        //checkers
        int checkColumn = 1;
        int checkRow = 1;

        while(flag){ //goes through until an X is found
            for(int w = 0; WIDTH > w; w += 1){
                for(int h = 0; HEIGHT > h; h += 1){
                    if(board[w][h] == 'X'){ //if X is found, add one to counter and go into loop
                        counter += 1;
                        check = true;
                        while(check){ //goes through diagonally looking for Xs
                            if(w - checkColumn >= 0 && h - checkRow >= 0){
                                if(board[w - checkColumn][h - checkRow] == 'X'){
                                    counter += 1; //if X is found, add 1 to counter
                                }
                            }

                            //adds 1 to checkers
                            checkColumn += 1;
                            checkRow += 1;

                            if(checkColumn == 0 || checkRow == HEIGHT -1){ //if outside of board, break
                                check = false;
                                break;
                            }

                            if(counter >= 4){
                                System.out.println("Player 1 wins"); //if counter is greater or equal to 4, player wins
                                check = false;
                                flag = false;
                                break;
                            }
                        }
                    }
                    if(counter >= 4){
                        flag = false;
                        break;
                    }

                    //resets counter and checkers
                    counter = 0;
                    checkColumn = 1;
                    checkRow = 1;
                }
            }
            break;
        }
        return flag;
    }

    public static boolean CheckODiagonalBack(){
        //flag
        boolean flag = true;

        //counter
        int counter = 0;

        //check boolean
        Boolean check = false;

        //checkers
        int checkColumn = 1;
        int checkRow = 1;

        while(flag){

            //goes through until an O is found
            for(int w = 0; WIDTH > w; w += 1){
                for(int h = 0; HEIGHT > h; h += 1){
                    if(board[w][h] == 'O'){ //if O is found, add one to counter and go into loop
                        counter += 1;
                        check = true;
                        while(check){ //goes through diagonally looking for Os
                            if(w - checkColumn >= 0 && h - checkRow >= 0){
                                if(board[w - checkColumn][h - checkRow] == 'O'){
                                    counter += 1; //if O is found, add 1 to counter
                                }
                            }

                            //adds 1 to checkers
                            checkColumn += 1;
                            checkRow += 1;

                            if(checkColumn == 0 || checkRow == HEIGHT -1){ //if outside of board, break
                                check = false;
                                break;
                            }

                            if(counter >= 4){
                                System.out.println("Player 2 wins"); //if counter is greater or equal to 4, player wins
                                check = false;
                                flag = false;
                                break;
                            }
                        }
                    }
                    if(counter >= 4){
                        flag = false;
                        break;
                    }

                    //resets counter and checkers
                    counter = 0;
                    checkColumn = 1;
                    checkRow = 1;
                }
            }
            break;
        }
        return flag;
    }

    public static boolean CheckX(){
        //creates flag
        boolean flag = true;

        //checks all Xs at once, for main 
        if(!CheckXVertical() || !CheckXHorizontal()|| !CheckXDiagonalBack()|| !CheckXDiagonalForward()){
            flag = false;
        }
        return flag;
    }

    public static boolean CheckO(){
        //creates flag
        boolean flag = true;

        //checks all Os at once, for main loop
        if(!CheckOVertical() || !CheckOHorizontal() || !CheckODiagonalBack() || !CheckODiagonalForward()){
            flag = false;
        }
        return flag;
    }
}