import java.util.Scanner;
public class snake {
//Eren Akgül 150119028. Purpose of this program is to create a snake game. The goal is collecting stars with less moves as possible.
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("WELCOME TO GRID GAME");        //Getting inputs from the user.
		System.out.print("Please enter the grid size: ");
		int number = input.nextInt();
		if(number <= 0) {									//Checking the validty of the inputs.
			System.out.println("Grid size must be bigger than 0.");
			System.exit(0);
		}
		String[][] size = new String [number][number];	//Creating a new array to hold the size of grid.
		int moves = (int) (2.5 * number);				//Declaring a value to hold maximum numbers of movement.
		int count = 0;									//This value counts the number of stars.
		boolean loss = false;							//This checks the validity of moves in the game. Default value is false.
		int a = 0;  int x;								//a and b holds the default position of X.
		int b = 0;  int y;								//x and y is for assigning stars in the array.
		size[a][b] = "X";
		
		for(int k = 0; k < number / 2; k++) {
			x = (int)(Math.random() * number);
			y = (int)(Math.random() * number);
			if (size[x][y] == null)			//If the given part of array is empty then we put a star in that part.
				size[x][y] = "*";
			else
				k--;
		}
		for (int i = 0; i < number; i++) {		
			for(int j = 0; j < size.length; j++) {	//We count the stars in this part.
				if(size[i][j] == "*")
					count++;
			}
		}
		while(moves >= 0) {	
			for (int i = 0; i < number; i++) {		//We print the walls and the array in this part.
				System.out.print("|");
					for(int j = 0; j < size.length; j++) {
						if(size[i][j] == null)
							size[i][j] = " ";		//We change the null values with a blank space.
						System.out.print(size[i][j]);  //Print the array on the screen one by one.
					}
			System.out.print("|");		
			System.out.println();	
			}
			if(moves == 0) loss = true;		//If there is no moves left we change the loss with true.		
			System.out.println("Moves: " + moves + "    " + "Current cell: (" + a + ", " + b + ")"); //Printing the number of moves and current cell.
			if(count == 0) {		//If there is no stars left in the grid we print "You Won" on the screen.
				System.out.println("You won!");
				System.exit(0);
			}
			if(loss) {						//If loss is true we print "You Lost" on the screen.
				System.out.println("You Lost.");
				System.exit(0);
			}
			System.out.print("Choose your direction (R,L,U,D): ");		//Getting the direction input from the user.
			String direction = input.next();					
			char dr = direction.toUpperCase().charAt(0);			
			if(dr != 'R' && dr != 'L' && dr != 'U' && dr != 'D') {		//We check if the direction input is valid. 
				System.out.println("Invalid move.");
				System.exit(0);
			}
			moves--; 													//We decrement the number of moves left.
			switch(dr) {
				case 'R':
					size[a][b] = "+";			//If we want to go right we put a "+" in current cell before movement.
					b++;						//Increment the value of column to move right.
					if(b == number) {			//In this part we check if the next cell is out of grid or not.
						System.out.println("You lost");
						loss = true;
						break;
					}
					if(size[a][b] == "*") count--;	//If there is a star we decrement the numbers of stars.
					if(size[a][b] == "+" || size[a][b] == "|") {	//If the next cell has star or wall.
						loss = true;
					}
					size[a][b] = "X";		//Assigning the X to the current cell.
					break;
				case 'L':
					size[a][b] = "+";		//If we want to go left we put a "+" in current cell before movement.
					b--;					//Decrement the value of columns to go left.
					if(b == -1) {			//If we try to go out of index we get an error message.
						System.out.println("You lost");
						loss = true;
						break;
					}
					if(size[a][b] == "*") count--;		//Count the number of stars.
					if(size[a][b] == "+" || size[a][b] == "|") {	//If the next cell has a wall or "+" the game is over.
						loss = true;
					}
					size[a][b] = "X";		//Assign the X to the current cell.
					break;
				case 'U':
					size[a][b] = "+";	//If we want to go up we put a "+" in current cell before movement.
					a--;				//Decrement the value of a to go up.
					if(a == -1) {		//If we are out of bounds we lose the game.
						System.out.println("Out of grid. You lost!");
						System.exit(0);
					}	
					if(size[a][b] == "*") count--;		//Count the stars.
					if(size[a][b] == "+" || size[a][b] == "|") {	//If the next cell has a wall or "+" the game is over.
						loss = true;
					}
					size[a][b] = "X";		//Assign the X to the current cell.
					break;
				case 'D':
					size[a][b] = "+";	//If we want to go down we put a "+" in current cell before movement.
					a++;
					if(a == number) {	//We check if we are out of grid or not.
						System.out.println("Out of grid. You lost!");	
						System.exit(0);
					}	
					if(size[a][b] == "*") count--;		//Count the stars.
					if(size[a][b] == "+" || size[a][b] == "|") {	//If the next cell has a wall or "+" the game is over.
						loss = true;
					}
					size[a][b] = "X";	//Assign X to current cell.
					break;
			}
		}	
		input.close();
	}
}
