import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Connect4Project{
	public static void main(String args[]) {
		boolean continuePlay = true;
		int player1Score = 0;
		int player2Score = 0;
		
		JFrame game = new Connect4();
		
	}
}
class Connect4 extends JFrame{
	final static int WIDTH = 10;
	final static int HEIGHT = 10;
	final int empty = 0;
	static int currentPlayer = 0;
	int playerNumber = 1;
	static int[][] gameboard = new int[WIDTH][HEIGHT];
	int x;
	private JFrame board;
	private JLabel[][] grid;

	
	public Connect4() {
		
		for(int y = 0; y < HEIGHT; y++) {
			for(int x = 0; x < WIDTH; x++) {
				gameboard[x][y] = empty;
			}
		}
		board = new JFrame("Connect 4");
		JPanel panel = (JPanel) board.getContentPane();
		board.setContentPane(panel);
		
		board.setSize(750, 750);
		board.setVisible(true);
		panel.setLayout(new GridLayout((WIDTH+1),HEIGHT));
		grid = new JLabel[WIDTH][HEIGHT];
		
		for(int y = 0; y < HEIGHT; y++) {
			for(int x = 0; x < WIDTH; x++) {
				grid[x][y] = new JLabel();
			}
		}
		
		JButton jbtcol0 = new JButton("Column 1");
		JButton jbtcol1 = new JButton("Column 2");
		JButton jbtcol2 = new JButton("Column 3");
		JButton jbtcol3 = new JButton("Column 4");
		JButton jbtcol4 = new JButton("Column 5");
		JButton jbtcol5 = new JButton("Column 6");
		JButton jbtcol6 = new JButton("Column 7");
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(jbtcol0);
		buttonPanel.add(jbtcol1);
		buttonPanel.add(jbtcol2);
		buttonPanel.add(jbtcol3);
		buttonPanel.add(jbtcol4);
		buttonPanel.add(jbtcol5);
		buttonPanel.add(jbtcol6);
		
		board.add(buttonPanel);
		
		Column_1ListenerClass listener0 = new Column_1ListenerClass();
		Column_2ListenerClass listener1 = new Column_2ListenerClass();
		Column_3ListenerClass listener2 = new Column_3ListenerClass();
		Column_4ListenerClass listener3 = new Column_4ListenerClass();
		Column_5ListenerClass listener4 = new Column_5ListenerClass();
		Column_6ListenerClass listener5 = new Column_6ListenerClass();
		Column_7ListenerClass listener6 = new Column_7ListenerClass();
		jbtcol0.addActionListener(listener0);
		jbtcol1.addActionListener(listener1);
		jbtcol2.addActionListener(listener2);
		jbtcol3.addActionListener(listener3);
		jbtcol4.addActionListener(listener4);
		jbtcol5.addActionListener(listener5);
		jbtcol6.addActionListener(listener6);
	}
	
	public void reset() {
		for(int y = 0; y < WIDTH; y++) {
			for(int x = 0; x < HEIGHT; x++) {
				gameboard[x][y] = empty;
			}
		}
	}
	
	public static void changePlayer() {
		if(currentPlayer == 0) {
			currentPlayer = 1;
		}
		else if (currentPlayer == 1) {
			currentPlayer = 2;
		}
		else { 
			currentPlayer = 1;
		}
	}
	
	public static boolean canDropDisk(int x) {
		if(gameboard[x][0] == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int diskLands(int x) {
		for(int y = WIDTH; y <= 0; y--) {
			if(gameboard[y][x] == 0) {
				return y;
			}
		}
		return 0;
	}
	
	public static void dropDisk(int x) {
		for(int y = WIDTH; y <= 0; y--) {
			if(gameboard[y][x] == 0) {
				gameboard[y][x] = currentPlayer;
			}
		}
		changePlayer();
	}
	public boolean victorious() {
		int numMatches;
		//horizontal
		for(int y = 0; y < WIDTH; y++) {
			numMatches = 0;
			for(int x = 0; x + 1 < HEIGHT; x++) {
				if((gameboard[y][x] == gameboard[y][x+1]) && (gameboard[y][x] > 0)) numMatches++;
				if(numMatches == 4) {
					return true;
				}
			}
		}
		//vertical
		for(int x = 0; x < HEIGHT; x++) {
			numMatches = 0;
			for(int y = 0; y+1 < WIDTH; y++) {
				if((gameboard[y][x] == gameboard[y+1][x]) && (gameboard[y][x] > 0)) numMatches++;
				if(numMatches == 4) {
					return true;
				}
			}
		}
		//right diagonal
		for(int y = 3; y < WIDTH; y++) {
			numMatches = 0;
			for(int x = 0; x < 4; x++) {
				if((gameboard[y][x] == gameboard[y+1][x+1]) && (gameboard[y][x] == gameboard[y+2][x+2]) && (gameboard[y][x] == gameboard[y+3][y+3]) && (gameboard[y][x] > 0)) {
					return true;
				}
			}	
		}
		//left diagonal
		for(int y = 3; y < WIDTH; y++) {
			numMatches = 0;
			for(int x = 0; x < HEIGHT; x++) {
				if((gameboard[y][x] == gameboard[y-1][x-1]) && (gameboard[y][x] == gameboard[y-2][x-2]) && (gameboard[y][x] == gameboard[y-3][y-3]) && (gameboard[y][x] > 0)) {
					return true;
				}
			}
		}
		return false;
		}
		public int winner() {
			int numMatches;
			   int matchingNumber = 0;
			 
			   // check horizontally
			   for ( int y = 0 ; y < WIDTH ; y++)
			   {
			    numMatches = 0;
			    for ( int x = 0 ; x + 1 < HEIGHT ; x++){
			     if ( ( gameboard[y][x] == gameboard[y][x+1]) && (gameboard[y][x] > 0) )
			     {
			      numMatches++;
			      matchingNumber = gameboard[y][x];
			     }
			     if (numMatches == 4) return matchingNumber;
			    }
			   }
			 
			   //check vertically
			   for ( int x = 0 ; x < HEIGHT ; x++)
			   {
			    numMatches = 0;
			    for ( int y = 0 ; y + 1 < WIDTH ; y++)
			    {
			    if ( ( gameboard[y][x] == gameboard[y+1][x]) && (gameboard[y][x] > 0 )) 
			    {
			     numMatches++;
			     matchingNumber = gameboard[y][x];
			    }
			    if ( numMatches == 4) {
			    	return matchingNumber;
			    }
			    }
			   }
			 
			   //check right slanted diagonal
			   for ( int y = 3 ; y < WIDTH ; y++)
			   {
			    numMatches = 0;
			    for ( int x = 0 ; x < 4 ; x++){
			     if ((gameboard[y][x] == gameboard[y+1][x+1]) && (gameboard [y][x] == gameboard[y+2][x+2]) && (gameboard[y][x] == gameboard[y+3][x+3]) && (gameboard[y][x] > 0)) 
			       return (gameboard[y][x]);
			    }
			   }
			 
			   //check left slanted diagonal
			   for ( int y = 3 ; y < WIDTH ; y ++)
			   {
			    numMatches = 0;
			    for ( int x = 3 ; x < HEIGHT ; x++)
			    {
			     if ((gameboard[y][x] == gameboard[y-1][x-1]) && (gameboard [y][x] == gameboard[y-2][x-2]) && (gameboard[y][x] == gameboard[y-3][x-3]) && (gameboard[y][x] > 0)) 
			       return (gameboard[y][x]);
			    }
			   }
			 
			   return matchingNumber;
			  }
			 
			}
class Winner extends JLabel{
	class Column_1ListenerClass implements ActionListener{
	 public void actionPerformed(ActionEvent e){
	  if (Connect4.canDropDisk(0) ){
	   Connect4.dropDisk(0);
	  }
	 }
	}
	 
	class Column_2ListenerClass implements ActionListener{
	 public void actionPerformed(ActionEvent e){
	  if (Connect4.canDropDisk(1) ){
	   Connect4.dropDisk(1);
	  }
	 }
	}
	 
	class Column_3ListenerClass implements ActionListener{
	 public void actionPerformed(ActionEvent e){
	  if (Connect4.canDropDisk(2) ){
	  Connect4.dropDisk(2); 
	  }
	 }
	}
	 
	class Column_4ListenerClass implements ActionListener{
	 public void actionPerformed(ActionEvent e){
	  if (Connect4.canDropDisk(3) ){
	   Connect4.dropDisk(3);
	  }
	 }
	}
	 
	class Column_5ListenerClass implements ActionListener{
	 public void actionPerformed(ActionEvent e){
	  if (Connect4.canDropDisk(4) ){
	   Connect4.dropDisk(4);
	  }
	 }
	}
	 
	class Column_6ListenerClass implements ActionListener{
	 public void actionPerformed(ActionEvent e){
	  if (Connect4.canDropDisk(5) ){
	   Connect4.dropDisk(5);
	  }
	 }
	}

	 
	class Column_7ListenerClass implements ActionListener{
	 public void actionPerformed(ActionEvent e){
	  if (Connect4.canDropDisk(6) ){
	   Connect4.dropDisk(6);
	  }
	 }
	}
	}

