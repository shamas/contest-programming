import java.util.ArrayList;
import java.util.Scanner;

public class streetcar {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		ArrayList<Integer> big = new ArrayList<Integer>();
		ArrayList<Integer> small = new ArrayList<Integer>();
		for(int i = 0; i < n; ++i){
			int numPeople = scanner.nextInt();
			int perc = scanner.nextInt();
			if(i == 0){
				int temp = numPeople;
				while(temp > 251){
					big.add(temp);
					temp -= 251;
				}
				big.add(temp);
				temp = numPeople;
				while(temp > 132){
					small.add(temp);
					temp -= 132;
				}
				small.add(temp);
			}
			else{
				for(int j = 0; j < big.size(); ++j){
					big.set(j, big.get(j) - big.get(j) * perc / 100);
				}
				for(int j = 0; j < small.size(); ++j){
					small.set(j, small.get(j) - small.get(j) * perc / 100);
				}
				int tmp = numPeople;
				int currentPtr = 0;
				while(tmp > 251 - big.get(currentPtr)){
					if(currentPtr > big.size()){
						big.add(0);
					}
					int curr = big.get(currentPtr);
					big.set(currentPtr, Math.min(251, tmp));
					tmp -= 251 - curr;
					++currentPtr;
				}
				if(currentPtr > big.size()){
					big.add(0);
				}
				int curr1 = big.get(currentPtr);
				big.set(currentPtr, Math.min(251, tmp));
				tmp -= 251 - curr1;
				++currentPtr;

				
				tmp = numPeople;
				currentPtr = 0;
				while(tmp > 132 - small.get(currentPtr)){
					if(currentPtr > small.size()){
						small.add(0);
					}
					int curr = small.get(currentPtr);
					small.set(currentPtr, Math.min(132, tmp));
					tmp -= 132 - curr;
					++currentPtr;
				}
				if(currentPtr > small.size()){
					small.add(0);
				}
				int curr2 = small.get(currentPtr);
				small.set(currentPtr, Math.min(132, tmp));
				tmp -= 132 - curr2;
				++currentPtr;
				
				
			}
		}
		System.out.println(small + ", " + big);
	}
}
