import java.util.Scanner;
public class SecretMessages 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a message to encode or decode");
		String message = scan.nextLine();
		String output = "";
		char key = 13;
		for (int x = 0; x < message.length(); x++) 
		{ 
			char input = message.charAt(x);
				if(input >= 'A' && input <= 'Z')
				{
					input += key;
					if(input > 'Z')
						input -= 26;
				}
				output += input;
		}
		System.out.println(output);
			scan.close();
	}
}
