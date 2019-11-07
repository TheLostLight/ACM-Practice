import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Stream
{
    public static void main(String[] args)
    {
        Scanner in;

        try
        {
            in = new Scanner(new File("input"));
        }catch(FileNotFoundException e){return;}

	int h = in.nextInt();
        int[][] streams = new int[h][15];
	int[] ans = new int[h];

        int r,n,k,d;
        
	for(int i=0; i<h; i++)
        {
            d=in.nextInt();
            r=0;
            n=0;
            for(int j=0; j<15; j++)
            {
                k=in.nextInt();
                if(k>n){r++;}
                n=k;
            }
            
            System.out.println(d + " " + r);
        }

    }
}

