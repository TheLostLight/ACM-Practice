import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Rain
{
	public static void main(String[] args)
	{
		Scanner in;

		try
		{
			in = new Scanner(new File("input"));
		}catch(FileNotFoundException e){System.out.println(e); return;}

		char[] data = in.next().toCharArray();

		int start = 0; //start of subsequence with highest count
		int end = 0; //end of subsequence with highest count

		int acc = 1; //greater sum of like characters in current sequence
		int dec = 0; //number of opposite characters in current sequence
		int max = 0; //Largest total so far
		
		int origin = 0; //position of beginning of current sequence
		int pivot = 0; //position of first opposite char in current sequence

		char maj = data[0]; //char with greater number in current sequence
		char prv = maj;		//previous character to have had the greatest sequence

		for(int i=1; i<data.length; i++)
		{
			if(data[i] == maj)
			{
				if(++acc - dec > max)
				{
					max = acc-dec;
					end = i;
					if(maj != prv) start = origin; //only update if the previous largest sequence was of a different character. 
				} 
			}
			else
			{
				if(dec++ < 1) pivot = i; //if this is the first opposite char in the sequence, mark this position as a possible pivot point

				if(dec == acc)			//once an equal number of chars has been reached, no greater sum will be found in the sequence, so pivot
				{
					maj = data[i];
					origin = pivot; 
					acc = 1;
					dec = 0;
					i = pivot; //reset and start counting from the beginning of the opposite characters
				}
			}
		}

		System.out.println((start+1) + " " + (end+1)); //array starts from 0, output starts from 1, so add 1 to outputs.
	}
}