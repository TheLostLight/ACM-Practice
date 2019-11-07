import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Apples
{
    private static char[][] grid;
    private static int h;
    private static int w;

    public static void main(String[] args)
    {
        initGrid();

        int ns;

        for(int i=0; i<w; i++)
        {
            ns = h-1;
            for(int j=ns; j>=0; j--)
            {
                if(grid[j][i] == '#') ns = j-1;
                else if(grid[j][i] == 'o') {grid[j][i] = '.'; grid[ns][i] = 'o'; ns--;}
            }
        }

        drawGrid();
    }

    public static void initGrid()
    {
        Scanner in;

        try
        {
            in = new Scanner(new File("input"));
        }catch(FileNotFoundException e){return;}

        //initialize grid
        h = in.nextInt();
        w = in.nextInt();
        grid = new char[h][w];
        for (int i= 0; i<h; i++)
        {
            String s = in.next();
            for(int j=0; j<w; j++)
            {
                grid[i][j] = s.charAt(j);
            }
        }
    }

    public static void drawGrid()
    {
        for(char[] g : grid)
        {
            for(char c : g)
            {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
