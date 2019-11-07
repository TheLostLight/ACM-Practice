public class Wave
{
	private int start;
	private int end;
	private int points;

	public Wave(int start, int points, int duration)
	{
		this.start = start;
		this.end = start + duration;
		this.points = points;
	}

	public Wave(Wave w)
	{
		this.start = w.start;
		this.end = w.end;
		this.points = w.points;
	}

	public boolean overlap(Wave w)
	{
		if( (this.start > w.start ? this.start : w.start) < (this.end < w.end ? this.end : w.end)) return true;

		return false;
	}

	public int getPoints()
	{
		return points;
	}
}