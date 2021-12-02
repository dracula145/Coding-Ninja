import java.util.*;

public class TicTacToe {
    static Player player1, player2;
    static Board board;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        t.startGame();
    }
    private void startGame(){
        // take player input
        player1 = takeInput(1);
        player2 = takeInput(2);

        // until symbols are different
        while(player1.getSymbol() == player2.getSymbol()){
            System.out.println("Re-enter " + player2.getName() + "'s symbol : ");
            player2.setSymbol(sc.next().charAt(0));
        }

        // create board
        System.out.println("Enter board dimension NxN : ");
        int size = sc.nextInt();
        board = new Board(size, player1.getSymbol(), player2.getSymbol());

        //play the game
        boolean p1_turn = true;
        int status = Board.INCOMPLETE;
        while(status == Board.INCOMPLETE || status == Board.INVALID){
            if(p1_turn){
                System.out.println("Player-1 " + player1.getName() + "'s move");
                System.out.println("Enter x and y: ");
                int x = sc.nextInt();
				int y = sc.nextInt();

				status =  board.move(player1.getSymbol(), x, y);
                if(status == Board.INVALID){
                    System.out.println("Invalid move ! Enter a valid move again !");
                    continue;
                }
            }
            else{
                System.out.println("Player-2 " + player2.getName() + "'s move");
                System.out.println("Enter x and y: ");
                int x = sc.nextInt();
				int y = sc.nextInt();

				status =  board.move(player2.getSymbol(), x, y);
                if(status == Board.INVALID){
                    System.out.println("Invalid move ! Enter a valid move again !");
                    continue;
                }
            }
            p1_turn = !p1_turn;
            board.print();
        }   
        if(status == Board.PLAYER_1_WINS) System.out.println(player1.getName() + " WINS !!");
        else if(status == Board.PLAYER_2_WINS) System.out.println(player2.getName() + " WINS !!");
        else if(status == Board.DRAW) System.out.println("Math Draw !");
    }
    private static Player takeInput(int number) {
        System.out.println("Enter player " + number + " name : ");
        String name = sc.nextLine();
		System.out.println("Enter Player " + number + " symbol : ");
		char symbol = sc.nextLine().charAt(0);
        System.out.println();
		Player p = new Player(name, symbol);
		return p;
    }
}
