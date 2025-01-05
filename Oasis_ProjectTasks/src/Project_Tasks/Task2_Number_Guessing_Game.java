package Project_Tasks;
import java.util.Random;
import java.util.Scanner;

public class Task2_Number_Guessing_Game 
{
	
	public static int MIN_RANGE = 1;
	public static int MAX_RANGE = 100;
	public static int MAX_ATTEMPTS = 6;
	public static int MAX_ROUNDS = 3;
	
	public static void main(String[] args)
	{
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		int totalscore = 0;
		
		System.out.println("-----Welcome to Number Guessing Game-----\n");
		System.out.println("Total Number of Rounds = 3");
		System.out.println("Number of Attempts For Round = 6\n");
		
		for(int i = 1;i<MAX_ROUNDS;i++) 
		{
			int number = random.nextInt(MAX_RANGE) + MIN_RANGE;
			int current_attempts = 0;
			
			System.out.printf("Current Round: %d: Guess the Number between %d and %d in %d attempts.\n",i,MIN_RANGE,MAX_RANGE,MAX_ATTEMPTS);
			
			while(current_attempts < MAX_ATTEMPTS) 
			{
				System.out.println("Enter Your Guess: ");
				int guess_number = sc.nextInt();
				current_attempts = current_attempts + 1;
				
				
				if(guess_number == number) 
				{
					int score = MAX_ATTEMPTS - current_attempts;
					totalscore =+ score;
					System.out.println("Bravooo!!! You Successfully guessed the Number");
					System.out.printf("Attempts: %d. Round score: %d",current_attempts,score);
					break;
				}
			}
		}
	}

}
