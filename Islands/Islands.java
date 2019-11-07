import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Islands
{
    private static char[][] grid;
    private static int h;
    private static int w;

    public static void main(String[] args)
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

        int r = 0;
        char next;

        for(int i=0; i<h; i++)
        {
            for(int j=0; j<w; j++)
            {
                next = grid[i][j];

                switch(next)
                {
                    case 'L' : if(isNew(i, j)) r++; grid[i][j] = 'E'; break;
                    case 'C' : if(isNew(i, j) && sweep(i, j)) r++; else sweep(i, j); break;
                    default  : break;
                }
            }

        }

        System.out.println(r);
    }

    public static boolean isNew(int a, int b)
    {
        if(check('E', a, b-1)) return false;
        if(check('E', a-1, b)) return false;
        if(check('E', a, b+1)) return false;
        if(check('E', a+1, b)) return false;
        return true;
    }

    public static boolean sweep(int a, int b)
    {
        boolean isLand = false;

        if(check('C', a, b+1))
        {
            grid[a][b] = 'U';
            isLand = sweep(a, b+1);
            if(isLand)
            {
                grid[a][b] = 'E';
                terraForm(a, b);
            }
        }

        if(check('C', a+1, b) && !isLand)
        {
            grid[a][b] = 'U';
            isLand = sweep(a+1, b);
            if(isLand)
            {
                grid[a][b] = 'E';
                terraForm(a, b);
            }
        }

        if(check('C', a-1, b) && !isLand)
        {
            grid[a][b] = 'U';
            isLand = sweep(a-1, b);
            if(isLand)
            {
                grid[a][b] = 'E';
                terraForm(a, b);
            }
        }

        if(check('C', a, b-1) && !isLand)
        {
            grid[a][b] = 'U';
            isLand = sweep(a, b-1);
            if(isLand)
            {
                grid[a][b] = 'E';
                terraForm(a, b);
            }
        }

        if(!isLand)
        {
            if(check('L', a, b+1))
            {
                grid[a][b] = 'E';
                isLand = true;
                terraForm(a, b);
            }
            if(!isLand && check('L', a+1, b))
            {
                grid[a][b] = 'E';
                isLand = true;
                terraForm(a, b);
            }
        }

        return isLand;

    }

    public static void terraForm(int a, int b)
    {
        if(check('C', a, b+1) || check('U', a, b+1))
        {
            grid[a][b+1] = 'E';
            terraForm(a, b+1);
        }
        if(check('C', a+1, b) || check('U', a+1, b))
        {
            grid[a+1][b] = 'E';
            terraForm(a+1, b);
        }
        if(check('C', a, b-1) || check('U', a, b-1))
        {
            grid[a][b-1] = 'E';
            terraForm(a, b-1);
        }
        if(check('C', a-1, b) || check('U', a-1, b))
        {
            grid[a][b+1] = 'E';
            terraForm(a-1, b);
        }
    }

    public static boolean check(char c, int a, int b)
    {
        return (a >= 0 && a < h) && (b >= 0 && b < w) && grid[a][b] == c;
    }
}
