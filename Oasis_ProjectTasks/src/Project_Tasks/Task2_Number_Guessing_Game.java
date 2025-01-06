package Project_Tasks;
import java.util.Random;
import java.util.Scanner;

public class Task2_Number_Guessing_Game 
{
	
	public static int MIN_RANGE = 1;
	public static int MAX_RANGE = 100;
	public static int MAX_ATTEMPTS = 10;
	public static int MAX_ROUNDS = 3;
	
	public static void main(String[] args)
	{
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		int totalscore = 0;
		
		System.out.println("-----Welcome to Number Guessing Game-----\n");
		System.out.println("Total Number of Rounds = 3");
		System.out.println("Number of Attempts For a Round = 10\n");
		
		for(int i = 1;i<=MAX_ROUNDS;i++) 
		{
			int number = random.nextInt(MAX_RANGE) + MIN_RANGE;
			int current_attempts = 0;
			
			System.out.printf("\nRound Number: %d: Guess the Number between %d to %d in %d attempts.\n",i,MIN_RANGE,MAX_RANGE,MAX_ATTEMPTS);
			
			while(current_attempts < MAX_ATTEMPTS) 
			{
				System.out.println("\nEnter Your Guess: ");
				int guess_number = sc.nextInt();
				current_attempts = current_attempts + 1;
				
				
				if(guess_number == number) 
				{
					int score = MAX_ATTEMPTS - current_attempts;
					totalscore =+ score;
					System.out.println("Bravooo!!! You Successfully guessed the Number");
					
					
					System.out.printf("Attempts taken: %d. Round score: %d\n",current_attempts,score);
					break;
				}
				else if(guess_number<number)
				{
					System.out.printf("The number is greater than %d. Attempts Left = %d\n",guess_number,MAX_ATTEMPTS - current_attempts);
					
				}
				else if(guess_number>number)
				{
					System.out.printf("The number is Lesser than %d. Attempts Left = %d\n",guess_number,MAX_ATTEMPTS - current_attempts);				
				}
				
			}
			if(current_attempts == MAX_ATTEMPTS) 
			{
				System.out.printf("You Lost In The Round = %d. Attempts = 0",i);
				System.out.printf("The Random Number is %d\n",number);
			}
			
		}
		System.out.printf("Game Over..Total Score = %d\n",totalscore);
		sc.close();
	}

}
