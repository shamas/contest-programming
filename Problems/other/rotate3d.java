import java.text.DecimalFormat;
import java.util.Scanner;


public class rotate3d {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		DecimalFormat format = new DecimalFormat("0.000000");
		for(int i = 0; i < n; ++i){
			Vector3 coord = new Vector3(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
			Vector3 rot = new Vector3(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble()).normalize();
			double rotation = -scanner.nextDouble();
			Vector3 p1 = coord.scale(Math.cos(rotation));
			Vector3 p2 = coord.cross(rot).scale(Math.sin(rotation));
			Vector3 p3 = rot.scale(rot.dot(coord)).scale(1 - Math.cos(rotation));
			Vector3 f = p1.add(p2).add(p3);
			System.out.println(format.format(f.x) + " " + format.format(f.y) + " " + format.format(f.z));
		}
	}
	public static class Vector3{
		public final double x;
		public final double y;
		public final double z;
		public Vector3(double x, double y, double z){
			this.x = x;
			this.y = y;
			this.z = z;
		}
		public double length(){
			return Math.sqrt(x * x + y * y + z * z);
		}
		public Vector3 normalize(){
			double length = length();
			return new Vector3(x / length, y / length, z / length);
		}
		public Vector3 add(Vector3 a){
			return new Vector3(x + a.x, y + a.y, z + a.z);
		}
		public Vector3 scale(double a){
			return new Vector3(x * a, y * a, z * a);
		}
		public Vector3 cross(Vector3 a){
			return new Vector3(y * a.z - z * a.y, z * a.x - x * a.z, x * a.y - y * a.x);
		}
		public double dot(Vector3 a){
			return x * a.x + y * a.y + z * a.z;
		}
	}
}
