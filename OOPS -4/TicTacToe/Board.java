public class Board {
    private char[][] board;
    private int size;
    private char p1_sym, p2_sym;
    private int count; // how many elements filled till now
    public final static int PLAYER_1_WINS = 1;
	public final static int PLAYER_2_WINS = 2;
	public final static int DRAW = 3;
	public final static int INCOMPLETE = 4;
	public final static int INVALID = 5;


    public Board(int dimension, char p1_sym, char p2_sym) {
        this.size = dimension;
        this.p1_sym = p1_sym;
        this.p2_sym = p2_sym;
        count = 0;
        board = new char[size][size];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++) board[i][j] = ' ';
        }
    }

    public int move(char symbol, int x, int y){
        if(x>=size || y>=size || board[x][y]!=' ') return INVALID;
        board[x][y] = symbol; // this.board not necessary because only one board in one game
        count++;

        // Check row
        boolean flag = true;
        for(int i=1; i<size; i++){
            if(board[x][i] != board[x][i-1]){
                flag = false;
                break;
            } 
        }
        if(flag) return symbol == p1_sym ? PLAYER_1_WINS : PLAYER_2_WINS;

        // check column
        for(int i=1; i<size; i++){
            if(board[i][y] != board[i-1][y]){
                flag = false;
                break;
            } 
        }
        if(flag) return symbol == p1_sym ? PLAYER_1_WINS : PLAYER_2_WINS;

        //check left diagonal
        if(board[0][0] != ' '){
        for(int i=1; i<size; i++){
             if(board[i][i] != board[i-1][i-1]){
                flag = false;
                break;
            } 
        }
        }
        if(flag) return symbol == p1_sym ? PLAYER_1_WINS : PLAYER_2_WINS;

        //check right diagonal
        if(board[0][size-1] != ' '){
        for(int i=1; i<size; i++){
             if(board[i][size-i-1] != board[i-1][size-i]){
                flag = false;
                break;
            } 
        }
        }
        if(flag) return symbol == p1_sym ? PLAYER_1_WINS : PLAYER_2_WINS;

        if(count == size*size) return DRAW;

        return INCOMPLETE;
    }

    // Prints current configuration of calling board object
    public void print(){
        System.out.println("---------------");
		for(int i =0; i < size; i++){
			for(int j =0; j < size; j++){
				System.out.print("| " + board[i][j] + " |");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("---------------");
    }
}
