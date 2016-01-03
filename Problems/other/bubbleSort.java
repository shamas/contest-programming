import java.util.Scanner;


public class bubbleSort {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] list = new int[n];
		for(int i = 0; i < n; ++i){
			list[i] = scanner.nextInt();
		}
		printList(list);
		for(int i = list.length - 1; i >= 0; --i){
			for(int j = 0; j < list.length - 1; ++j){
				if(list[j] > list[j + 1]){
					swap(list, j, j + 1);
				}
			}
		}
	}
	public static void swap(int[] list, int a, int b){
		int temp = list[a];
		list[a] = list[b];
		list[b] = temp;
		printList(list);
	}
	public static void printList(int[] list){
		for(int i = 0; i < list.length; ++i){
			System.out.print(list[i] + (i == list.length - 1 ? "" : " "));
		}
		System.out.println();
	}
}
