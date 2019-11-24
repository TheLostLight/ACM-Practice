import java.util.*;

public class CarryCamFailure
{
    private static int[][] multiply;
    private static int[] data;

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        String number = in.next();

        if(number.length()%2 == 0)
        {
            System.out.println(-1);
            return;
        }

        initArray();

        data = new int[number.length()];

        for(int i=0; i<number.length(); i++) data[i] = valueAt(number, i);

        boolean exists = false; //Check if there exists a number that squares to give the least significant digit.
        int lsd = data[data.length-1]; //Least significant digit of the given number. Not to be confused with the hallucinatory drug.

        for(int i=0; i<10; i++)
        {
            if(multiply[i][i] == lsd)
            {
                exists = true;
                break;
            }
        }

        if(!exists)
        {
            System.out.println(-1);
            return;
        }

        findAnswer(lsd);
    }

    public static void initArray()
    {
        multiply = new int[10][10];

        for(int i=0; i<10; i++)
        {
            for(int j=0; j<10; j++) multiply[i][j] = (i*j)%10;
        }
    }

    public static void findAnswer(int lsd)
    {
        int length = (data.length+1)/2;

        ArrayList<String> answers = new ArrayList<String>();

        int temp;

        for(int i=0; i<10; i++)
        {
            temp = multiply[i][i];
            if(temp == lsd) answers.add(Integer.toString(i));
        }

        if(answers.size() < 1)
        {
            System.out.println(-1);
            return;
        }

        ArrayList<String> store = new ArrayList<String>();
        int buffer = data.length-1;

        for(int i=1; answers.size() > 0 && i<length; i++)
        {
            for(String s : answers)
            {
                temp = data[buffer-i];

                for (int j = i - 1, k = 1; j > 0 && k < i; j--, k++)
                {
                    temp = (10 + temp - multiply[valueAt(s, i-1-j)][valueAt(s, i-1-k)])%10;
                }

                for(int j=0; j<10; j++)
                {
                    if(multiply[2][multiply[j][valueAt(s, i-1)]] == temp)
                    {
                        if(i == length-1 && multiply[j][j] != data[0]) continue;
                        store.add(Integer.toString(j)+ s);
                    }
                }
            }

            answers = new ArrayList<String>(store);
            store.clear();
        }

        if(answers.size() < 1)
        {
            System.out.println(-1);
            return;
        }

        int index = 0;
        int[] test;
        boolean stay = true;

        for(; index<answers.size(); index++)
        {
            test = CarrylessSquares.square(answers.get(index));

            for(int j=0; j<data.length; j++)
            {
                if(data[j] != test[test.length-1-j])
                {
                    stay = true;
                    break;
                }
                else stay = false;
            }

            if(!stay) break;
        }

        System.out.println(answers.get(index));
    }

    public static int valueAt(String s, int i)
    {
        return Character.getNumericValue(s.charAt(i));
    }
}