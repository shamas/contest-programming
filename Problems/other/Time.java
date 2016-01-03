public class Time{
	public long unixEpoch;
	public Time(long unixEpoch){
		this.unixEpoch = unixEpoch;
	}
	public int minutesUntil(Time t){
		return (int)((t.unixEpoch - unixEpoch) / 60000);
	}
}