import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;

public class Hyphen
{
	public static void main(String[] args)
	{
		Scanner in;

		try
		{
			in = new Scanner(new File("input"));
		}catch(FileNotFoundException e){System.out.println(e); return;}

		String w = in.next();
		String x;
		LinkedList<Token> list;
		LinkedList<Token> buffer;
		Token t;

		int vowels;
		int cons;

		while(!w.equals(Token.EoF))
		{
			list = new LinkedList<Token>();
			x = "";

			while(!w.isEmpty())
			{
				if(Token.containedInSpecial(x + w.charAt(0))) x += w.charAt(0);

				else
				{
					if(!x.isEmpty()) list.add(new Token(Token.isVowel(x), x));
					x = "" + w.charAt(0);
				}
				w = w.substring(1);
			}

			if(!x.isEmpty()) list.add(new Token(Token.isVowel(x), x));

			vowels = 0;
			cons = 0;
			buffer = new LinkedList<Token>();
			

			while(list.size() > 0)
			{
				t = list.poll();

				if(t.getValue() == 'c') 
				{
					if(vowels == 0) System.out.print(t);

					else if(cons == 2)
					{
						for(Token u : buffer)
						{
							System.out.print(u);
						}
						System.out.print(t);
						cons = 0;
						vowels = 0;
						buffer.clear();
					}
					else
					{
						buffer.add(t);
						cons++;
					}
				}

				else 
				{
					if(vowels == 1)
					{
						if(cons == 2)
						{
							System.out.print(buffer.poll());
							System.out.print(buffer.poll());
							System.out.print("-");
							System.out.print(buffer.poll());
							buffer.add(t);
							cons = 0;
						}
						else if(cons == 1)
						{
							if(list.size() == 0 && t.toString().equals("e"))
							{
								for(Token u : buffer) System.out.print(u);

								System.out.print(t);
								buffer.clear();
							}
							else
							{
								System.out.print(buffer.poll());
								System.out.print("-");
								System.out.print(buffer.poll());
								buffer.add(t);
								cons = 0;
							}
						}
						else
						{
							System.out.print(buffer.poll());
							buffer.add(t);
						}
					}
					else
					{
						buffer.add(t);
						vowels++;
					}
				}
			}

			for(Token u : buffer)
			{
				System.out.print(u);
			}


			System.out.println();
			w = in.next();
		}
	}
}
