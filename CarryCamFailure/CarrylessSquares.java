import java.util.*;

public class CarrylessSquares
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        String num = in.next();


        int[] ret = square(num);

        for(int i=ret.length-1; i>-1; i--) System.out.print(ret[i]);
    }

    public static int[] square(int[] data)
    {
        int[] ret = new int[data.length*2 - 1];
        int buffer = data.length-1;
        int min;

        for(int i=0; i<ret.length; i++)
        {
            min = i<buffer ? 0:i-buffer;

            for(int j= i < buffer ? i : buffer, k=min; j>=min; j--, k++)
            {
                ret[i] += data[k]*data[j];
            }
            ret[i] %= 10;
        }

        return ret;
    }

    public static int[] square(String s)
    {
        int[] data = new int[s.length()];

        for(int i = 0; i<s.length(); i++) data[i] = Character.getNumericValue(s.charAt(s.length()-1-i));

        return square(data);
    }
}
