import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class EggDrop
{
	public static void main(String[] args)
	{
		Scanner in;

		try
		{
			in = new Scanner(new File("input"));
		}catch(FileNotFoundException e){System.out.println(e); return;}

		int eggs   = in.nextInt();
		int height = in.nextInt();

		int b = height;
		int s = 1;
		int c = 0;

		String result;

		for(int i=0; i<eggs; i++)
		{
			c = in.nextInt();

			result = in.next();

			if(result.equals("SAFE"))
			{
				if(c == height-1) 
				{
					s=c;
					b=height;
					break;
				}
				else if(c > s ) s = c;
			}
			if(result.equals("BROKEN"))
			{
				if(c == 2)
				{
					b = c;
					s = 1;
					break;
				}
				else if(c < b) b = c;
			}
		}

		System.out.println((s+1) + " " + (b-1));
	}
}