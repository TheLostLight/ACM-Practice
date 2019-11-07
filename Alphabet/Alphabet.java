import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class Alphabet
{
	private static char[] alpha = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

	public static void main(String[] args)
	{
		Scanner in; 

		try
		{
			in = new Scanner(new File("input"));
		}catch(FileNotFoundException e){System.out.println(e); return;}

		char[] beta = in.next().toCharArray();

		int[][] graph = new int[alpha.length+1][beta.length+1];

		int result = 0;

		for(int i=0; i<alpha.length; i++)
		{
			for(int j=0; j<beta.length; j++)
			{
				if(beta[j] == alpha[i]) 
				{
					graph[i+1][j+1] = graph[i][j] + 1;
				}
				else graph[i+1][j+1] = max(graph[i][j+1], graph[i+1][j]);
			}
		}

		System.out.println(max(26-graph[graph.length-1][graph[graph.length-1].length-1], 0));
	}

	public static int max(int a, int b)
	{
		return a > b ? a : b;
	}
}