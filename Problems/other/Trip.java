import java.util.ArrayList;


public class Trip {
	private ArrayList<Flight> flights;
	
	public int getDuration(){
		if(flights.size() == 0){
			return 0;
		}
		return flights.get(0).getDepartureTime().minutesUntil(flights.get(flights.size() - 1).getArrivalTime());
	}
	public int getShortestLayover(){
		int time = Integer.MAX_VALUE;
		if(flights.size() < 2){
			return -1;
		}
		for(int i = 0; i < flights.size() - 1; ++i){
			Flight f1 = flights.get(i);
			Flight f2 = flights.get(i + 1);
			time = Math.min(time, f1.getArrivalTime().minutesUntil(f2.getDepartureTime()));
		}
		return time;
	}
}
