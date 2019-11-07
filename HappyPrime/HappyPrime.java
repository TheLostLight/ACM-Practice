import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class HappyPrime
{
	public static void main(String[] args)
	{
		Scanner in;

		try
		{
			in = new Scanner(new File("input"));
		}catch(FileNotFoundException e){System.out.println(e); return;}

		int sets = in.nextInt();

		for(int i=0; i<sets; i++)
		{
			System.out.print(in.nextInt() + " ");

			isHP(in.nextInt());
		}
	}

	public static void isHP(int a)
	{
		System.out.print(a + " ");

		if(isNotPrime(a)) a = 0;

		int digits;
		int pow;
		int pow2;

		while(a>6)
		{
			pow = 10;
			pow2 = 1;
			digits=0;

			for(int i = a; i > 0; i /= 10)
			{
				//System.out.print("==now calculating " + a + " with mod " + pow + "==");
				digits += ((a%pow)/pow2)*((a%pow)/pow2);
				pow *= 10;
				pow2 *= 10;
			}

			a = digits;

			if(a == 1)
			{
				System.out.println("YES");
				return;
			}
		}

		System.out.println("NO");
	}

	public static boolean isNotPrime(int a)
	{
		if(a < 2) return true;
		if(a == 2 || a == 3) return false;

		for(int i=5; i*i<=a; i += 2) if (a%i == 0) return true;

		return false;
	}

}
