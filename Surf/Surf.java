import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Surf
{
	public static void main(String[] args)
	{
		Scanner in;

		try
		{
			in = new Scanner(new File("input"));
		}catch(FileNotFoundException e){System.out.println(e); return;}

		int waves = in.nextInt();
		ArrayList<ArrayList<Wave>> groups = new ArrayList<ArrayList<Wave>>();
		ArrayList<ArrayList<Wave>> clone;
		ArrayList<Wave> temp = new ArrayList<Wave>();
		Wave next = new Wave(in.nextInt(), in.nextInt(), in.nextInt());
		temp.add(next);
		groups.add(temp);
		boolean fits = true;

		groups.add(temp);

		for(int i=1; i<waves; i++)
		{
			next = new Wave(in.nextInt(), in.nextInt(), in.nextInt());
			clone = new ArrayList<ArrayList<Wave>>();

			for(ArrayList<Wave> ls : groups)
			{
				fits = true;

				for(Wave w : ls)
				{
					if (next.overlap(w)) fits = false;
				}

				if (fits) ls.add(next);
				else
				{
					temp =  new ArrayList<Wave>();
					temp.add(next);

					for(Wave w : ls)
					{
						if (!next.overlap(w)) temp.add(w);
					}

					clone.add(temp);
				}
			}

			if(!clone.isEmpty()) groups.addAll(clone);
		}

		int max = 0;
		int acc;

		for(ArrayList<Wave> ls : groups)
		{
			acc = 0;

			for(Wave w : ls)
			{
				acc += w.getPoints();
			}

			if (acc > max) max = acc;
		}

		System.out.println(max);
	}
}

