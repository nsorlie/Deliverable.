import java.util.Scanner;
import java.lang.Math;
//imports scanner for user input & Math for math.random to get random values.
public class Mine{

    public static void main(String[] args){   
        char input = 'a';
        printBoard(coordGen(3), coordGen(3), coordGen(3), coordGen(3), input);
        //calls the method (Also all comments refer to the code above it)
    }
    

        public static void printBoard(int treasurex, int treasurey, int minex, int miney, char input){
            //not very useful variables that determin how the player moves.
            int w = -1;
            int s = 1;
            int a = -1;
            int d = 1;
            //The player coords (starts at 3,3 which is the center)
            int playerY = 3;
            int playerX = 3;

            //intructions
            System.out.println("input w to move up, d for right, a for left and s for down then hit enter");
            //Prints the origional board.
            System.out.println("* * * * * \n* * * * * \n* * x * * \n* * * * * \n* * * * * ");
            //The loop that runs the game.
            while(true){
                //Gets the user input
                Scanner scan = new Scanner(System.in);
                input = scan.next().charAt(0); 
                    //Adds to the player coord (moving the character)
                    if (input == 'w'){
                        playerY = playerY+w;
                    }

                    if (input == 's'){
                        playerY = playerY+s;
                    }

                    if (input == 'a'){
                        playerX = playerX+a;
                    }

                    if (input == 'd'){
                        playerX = playerX+d;
                    }  

                    //Runs the method for winning the game if you found the treasure.
                    if (playerX == treasurex && playerY == treasurey){
                        winState(treasurex, treasurey, input);
                        break;
                        }
                    //Runs the method for loosing the game if you found the mine
                    else if (playerX == minex && playerY == miney){
                        looseState(minex, miney, input);
                        break;
                        }
                    else{
                        //bulk of the code
                        for (int yValue = 0; yValue < 5; yValue++){ 
                            //this basicaly reverses the change to the player door if the 
                            //player is on the edge of the board
                            if (input == 'w' && playerY == 0){
                                playerY = playerY+1;
                            }
        
                            if (input == 's' && playerY == 6){
                                playerY = playerY-1;
                            } 
                            //When the yValue on the board is equal to the players coord it starts printing 
                            //the row individually.
                            if (yValue == playerY-1){
                                for (int xValue = 0; xValue < 5; xValue++){
                                    //This code yet again stop you from going off of the board.
                                    if (input == 'a' && playerX == 0){
                                        playerX = playerX+1;
                                    }
                
                                    if (input == 'd' && playerX == 6){
                                        playerX = playerX-1;
                                    }
                                //If the place the player where the board is at it prints an x
                                    if (xValue == playerX-1){
                                
                                    System.out.print("x ");
                        
                                    }
                                    // This prints the rest of the line.
                                    else {
                                        System.out.print("* ");
                                    }  
                                    if (xValue == 4){
                                        yValue++;
                                        System.out.println();
                                    }

                         
                                }
                            }    
                //Prints the line if it is not the line that the cursor is on.
                            if (yValue < 5){
                                System.out.println("* * * * *");
                            }
                } 
            } 
            }
        
        }
        //picks a random coord for the treasure and mine that is not equal to the starts coord.
        public static int coordGen(int exeption){
            int Goal = ((int)(Math.random() * 5))+1;
            while(true){
                if (exeption == Goal){
                    Goal = ((int)(Math.random() * 5))+1;
                }
                else{
                    break;
                }

            

            }
            return Goal;
        }
        //This method prints the board state if the user won.
        public static void winState(int treasurex, int treasurey, char input){
            //prints baord state.
            System.out.println("$ $ $ $ $ \n$ $ $ $ $\n$ $ $ $ $ \n$ $ $ $ $\n$ $ $ $ $ ");
            System.out.println("You found the treasure!");
            //asks the user if they would like to play again.
            System.out.println("If you want to play again press y if not press any other key");
            Scanner secondScan = new Scanner(System.in);
            input = secondScan.next().charAt(0); 
            if (input == 'y'){
                printBoard(coordGen(3), coordGen(3), coordGen(3), coordGen(3), input);
            } 
            secondScan.close();
            
            System.out.println("Exit successful!");
        }
        //the method bellow prints the board state if the user lost.
        public static void looseState(int minex, int miney, char input){
            //prints the board state
            System.out.println("X X X X X \nX X X X X \nX X X X X \nX X X X X \nX X X X X");
            //Asks if the user would like to play again.
            System.out.println("Oops you ran into a mine would you like to try again?");
            System.out.println("Press y to try again or any other key too quit");
            Scanner thirdScan = new Scanner(System.in);
            input = thirdScan.next().charAt(0); 
            if (input == 'y'){
                printBoard(coordGen(3), coordGen(3), coordGen(3), coordGen(3), input);
                thirdScan.close();
            } 
            //if the user did not input y to play again it exits.
            System.out.println("Exit successful!");
        }      
}