import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Squawks
{
	public static void main(String[] args)
	{
		Scanner in;

		try
		{
			in = new Scanner(new File("input"));
		}catch(FileNotFoundException e){System.out.println(e); return;}

		while (in.hasNext()) findSquawks(in);
	}

	public static void findSquawks(Scanner in)
	{
		int n = in.nextInt(); //number of nodes
		int m = in.nextInt(); //connections
		int s = in.nextInt(); //infected node
		int t = in.nextInt(); //target time

		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(n); //list has arraylist containing all indices of nodes connected to x.

		for(int i=0; i<n; i++) list.add(new ArrayList<Integer>());

		int[] presquawks = new int[n];						   //presquawks[x] has the number of all squawks receieved by node x at time t-1.
		int[] postsquawks = new int[n];						   //postsquawks[x] has the number of squawks x has received from other nodes at time t.

		int a,b;

		for(int i=0; i<m; i++) //create connections between nodes
		{
			a = in.nextInt();
			b = in.nextInt();

			list.get(a).add(b);
			list.get(b).add(a);
		}

		presquawks[s] = 1; //The initially infected node will begin with 1 squawk to pass along its connections.

		for(int i=0; i<t; i++)
		{
			for(int j=0; j<n; j++)
			{
				if(presquawks[j] > 0) //if in the previous minute node j receieved squawks
				{
					for(int k : list.get(j)) postsquawks[k] += presquawks[j]; //add those squawks to all nodes k, which are connected to j.
				}
			}

			presquawks = postsquawks;
			postsquawks = new int[n];
		}

		int result = 0;

		for(int i : presquawks) result += i;

		System.out.println(result);
	}
}