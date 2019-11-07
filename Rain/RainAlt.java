import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class RainAlt
{
	private static int beg;
	private static int end;
	private static int max;

	public static void main(String[] args)
	{
		Scanner in;

		try
		{
			in = new Scanner(new File("input"));
		}catch(FileNotFoundException e){System.out.println(e); return;}

		char[] data = in.next().toCharArray();

		beg = 0;
		end = 0;
		max = 0;

		int bseq = 0;
		int rseq = 0;
		int bbeg = 0;
		int rbeg = 0;

		boolean b_needs_new_origin = true;
		boolean r_needs_new_origin = true;

		for(int i=0; i<data.length; i++)
		{
			if(data[i] == 'B')
			{
				bseq++;

				if(b_needs_new_origin) 
				{
						bbeg = i;
						b_needs_new_origin = false;
				}

				if(rseq > 0) rseq--;
				else r_needs_new_origin = true;

				newRecord(bseq, bbeg, i);
			}
			else
			{
				rseq++;

				if(r_needs_new_origin) 
				{
					rbeg = i;
					r_needs_new_origin = false;
				}

				if(bseq > 0) bseq--;
				else b_needs_new_origin = true;

				newRecord(rseq, rbeg, i);
			}
		}

		System.out.println((beg+1) + " " + (end+1));
	}

	public static void newRecord(int a, int b, int i)
	{
		if(a > max)
				{
					max = a;
					beg = b;
					end = i;
				}
	}
}