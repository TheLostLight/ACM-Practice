import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ThreeSquare
{
    private static Rectangle r1,r2,r3;
    private static int g;

    public static void main(String[] args)
    {
        Scanner in;

        try
        {
            in = new Scanner(new File("input"));
        }catch(FileNotFoundException e){return;}

        r1 = new Rectangle(in.nextInt(), in.nextInt());
        r2 = new Rectangle(in.nextInt(), in.nextInt());
        r3 = new Rectangle(in.nextInt(), in.nextInt());

        g = max(r1.greater(), r2.greater(), r3.greater());

        if(check()) System.out.println("YES");
        else System.out.println("NO");
    }

    public static int max(int ... a)
    {
        int m = 0;
        for (int i : a) m = i > m ? i : m;
        return m;
    }

    public static boolean check()
    {
        if(g*g == r1.area() + r2.area() + r3.area()) return true;

        else return false;

    }
}

class Rectangle
{
    public int h;
    public int w;

    public Rectangle(int a, int b)
    {
        h = a;
        w = b;
    }

    public int greater()
    {
        return h > w ? h : w;
    }

    public int lesser()
    {
        return h < w ? h : w;
    }

    public int area()
    {
        return h*w;
    }
}
