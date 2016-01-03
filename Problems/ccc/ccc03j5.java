import java.awt.Point;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class ccc03j5 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int total = Integer.parseInt(scanner.nextLine());
		int h = Integer.parseInt(scanner.nextLine());
		int w = Integer.parseInt(scanner.nextLine());
		boolean[][] visited = new boolean[w][h];
		boolean[][] tiles = new boolean[w][h];
		for(int j = 0; j < h; ++j){
			String line = scanner.nextLine();
			for(int i = 0; i < w; ++i){
				visited[i][j] = line.charAt(i) == 'I';
			}
		}
		ArrayList<Integer> rooms = new ArrayList<Integer>();
		for(int i = 0; i < w; ++i){
			for(int j = 0; j < h; ++j){
				if(!visited[i][j]){
					ArrayDeque<Point> points = new ArrayDeque<Point>();
					points.addLast(new Point(i, j));
					int count = 0;
					while(!points.isEmpty()){
						Point p = points.removeLast();
						if(p.x < 0 || p.y < 0 || p.x >= w || p.y >= h || visited[p.x][p.y]){
							continue;
						}
						++count;
						visited[p.x][p.y] = true; 
						points.addLast(new Point(p.x + 1, p.y));
						points.addLast(new Point(p.x - 1, p.y));
						points.addLast(new Point(p.x, p.y + 1));
						points.addLast(new Point(p.x, p.y - 1));
					}
					rooms.add(count);
				}
			}
		}
		Collections.sort(rooms);
		Collections.reverse(rooms);
		int totalRooms = 0;
		for(int i = 0; i < rooms.size(); ++i){
			int count = rooms.get(i);
			if(total >= count){
				totalRooms += 1;
				total -= count;
			}
			else{
				break;
			}
		}
		System.out.println(totalRooms + (totalRooms != 1 ? " rooms, " : " room, ") + total + " square metre(s) left over");
	}
}
