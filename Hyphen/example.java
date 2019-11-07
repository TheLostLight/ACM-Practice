import java.util.LinkedList;

public class example
{
	public static void main(String[] args)
	{
		LinkedList<Integer> list = new LinkedList<Integer>();

		list.add(1);
		list.add(2);
		list.add(3);

		for(int i : list)
		{
			System.out.println(list.size());
		}
	}
}