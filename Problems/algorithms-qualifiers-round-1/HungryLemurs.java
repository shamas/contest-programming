import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Scanner;

//tle
public class HungryLemurs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        HashMap<Way, Boolean> waysCompleted = new HashMap<Way, Boolean>();
        ArrayDeque<Way> ways = new ArrayDeque<Way>();
        ways.addFirst(new Way(n, k, 0));
        while(!ways.isEmpty()) {
            Way way = ways.removeFirst();
            if(way.bananas < 0) {
                continue;
            }
            if(way.lemurs < 1) {
                continue;
            }
            if(waysCompleted.containsKey(way)) {
                continue;
            }
            waysCompleted.put(way, true);
            if(way.bananas % way.lemurs == 0) {
                System.out.println(way.minutes);
                return;
            }
            ways.addLast(new Way(way.bananas, way.lemurs + 1, way.minutes + 1));
            ways.addLast(new Way(way.bananas, way.lemurs - 1, way.minutes + 1));
            ways.addLast(new Way(way.bananas + 1, way.lemurs, way.minutes + 1));
            ways.addLast(new Way(way.bananas - 1, way.lemurs, way.minutes + 1));
        }
    }

    public static class Way {
        public int bananas;
        public int lemurs;
        public int minutes;
        public Way(int bananas, int lemurs, int minutes) {
            this.bananas = bananas;
            this.lemurs = lemurs;
            this.minutes = minutes;
        }
        public boolean equals(Object o) {
            Way way = (Way)o;
            return way.bananas == bananas && way.lemurs == lemurs;
        }
        public int hashCode() {
            return bananas * 100000 + minutes;
        }
    }

}
