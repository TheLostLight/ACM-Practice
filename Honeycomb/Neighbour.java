import java.util.Scanner;

public class Neighbour
{
	public static void main(String[] args)
	{
		int r = Integer.parseInt(args[0]);
		int c = Integer.parseInt(args[1]);

		System.out.println( (c+r+(c/(r+1))) );
	}
}