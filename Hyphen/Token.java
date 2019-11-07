public class Token
{
	private static final char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};
	private static final String[] specials = {"qu", "tr", "br", "str", "st", "sl", "bl", "cr", "ph", "ch"};
	public static final String EoF = "===";

	private char value;
	private String content;

	public static boolean isVowel(String c)
	{
		if(c.length() != 1) return false;

		c = c.toLowerCase();

		for(int i=0; i<vowels.length; i++) if (c.charAt(0) == vowels[i]) return true;

		return false;
	}

	public static boolean isSpecial(String s)
	{
		s = s.toLowerCase();

		for(int i=0; i<specials.length; i++) if (s.equals(specials[i])) return true;

		return false;
	}

	public static boolean containedInSpecial(String w)
	{
		w = w.toLowerCase();

		for(int i=0; i<specials.length; i++) if (specials[i].contains(w)) return true;

		if(EoF.contains(w)) return true;
		
		return false;
	}

	public Token(char v, String c)
	{
		value = v;
		content = c;
	}

	public Token(boolean b, String c)
	{
		value = b ? 'v' : 'c';
		content = c;
	}

	public char getValue()
	{
		return value;
	}

	@Override
	public String toString()
	{
		return content;
	}
}