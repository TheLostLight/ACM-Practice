public class Planet
{
	private int x;
	private int y;
	private int z;

	public Planet(int x, int y, int z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int distance(Planet p)
	{
		return Math.round(Math.sqrt(Math.pow(p.x - this.x, 2), Math.pow(p.y - this.y, 2), Math.pow(p.z - this.z, 2)));
	}
}