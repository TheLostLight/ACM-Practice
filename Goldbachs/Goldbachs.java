import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Goldbachs
{
	public static void main(String[] args)
	{
		Scanner in;

		try
		{
			in = new Scanner(new File("input"));
		}catch(FileNotFoundException e){System.out.println(e); return;}

		int value = in.nextInt();

		boolean[] primes = new boolean[value+1];

		primes[2] = true;

		for(int i=3; i<=value; i+=2)
		{
			if(isPrime(i)) primes[i] = true;
		}

		int steps   = 0;
		int upper;
		int lower;

		for(int current = value; current > 3; steps++)
		{
			upper = current-1;
			lower = 2;

			while(!primes[upper]) upper -= 2;

			while(upper+lower != current)
			{
				//System.out.println("Here");
				if(upper+lower > current)
				{
					do upper -= upper==3 ? 1 : 2;
					while(!primes[upper]); 
				}
				else
				{
					do lower += lower==2 ? 1 : 2;
					while(!primes[lower]); 
				}
			}

			current = upper-lower;
		}

		System.out.println(steps);
	}

	public static boolean isPrime(int k)
	{
		if(k%2 == 0) return false;
		for(int i=3; i*i<=k; i+=2)
		{
			if(k%i == 0) return false;
		}

		return true;
	}
}