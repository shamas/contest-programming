
public class Test01 {

	public static void main(String[] args) {
		
		int[] trees = {1,7,2,9,150};
		int[] sum = new int [5];
		int add = 0;
		int answer = 0;
		int right_index = 1;
		int left_index = 0;
		
		for(int i = 0; i < 5; i++){
			add += trees[i];
			sum[i] = add;
		}
		
		System.out.println(answer = sum[right_index] - sum[left_index - 1]); 
		
		
		

	}

}
