import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Wormhole
{
	public static void main(String[] args)
	{
		Scanner in;

		try
		{
			in = new Scanner(new File("input"));
		}catch(FileNotFoundException e){System.out.println(e); return;}

		int cases = in.nextInt();
	}
}
