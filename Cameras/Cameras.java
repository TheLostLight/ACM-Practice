import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Cameras
{
    private static boolean[] cams;
    private static int num;
    private static int frame;
    private static final int req = 2;

    public static void main(String[] args)
    {
        Scanner in;

        try
        {
            in = new Scanner(new File("input"));
        }catch(FileNotFoundException e){return;}

        cams = new boolean[in.nextInt()];
        num = in.nextInt();
        frame = in.nextInt();

        for(int i=0; i<num; i++)
        {
            cams[in.nextInt()] = true;
        }

        int r = 0;
        int n;

        for(int i=0; i<=cams.length-frame; i++)
        {
           n = 0;

            for(int j=i; j<i+frame; j++)
            {
                if(cams[j]) n++;
            }

            if(n < req)
            {
                if(cams[i+frame-1]) cams[i+frame-2] = true;
                else cams[i+frame-1] = true;
                r++;
            }
        }

        System.out.println(r);
    }
}
