import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ccc04s2 {
    public static boolean isSorting = true;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        Yodeller[] totalRanks = new Yodeller[n];
        ArrayList<Yodeller>[] scores = new ArrayList[r];
        for(int x = 0; x < r; ++x) {
            scores[x] = new ArrayList<Yodeller>();
            for(int i = 0; i < n; ++i) {
                int a = scanner.nextInt();
                if(totalRanks[i] == null) {
                    totalRanks[i] = new Yodeller(i, 0);
                }
                totalRanks[i].score += a;
                scores[x].add(new Yodeller(i, totalRanks[i].score));
            }
        }
        for(int x = 0; x < r; ++x) {
            Collections.sort(scores[x]);
        }
        Arrays.sort(totalRanks);
        isSorting = false;
        Yodeller topRank = totalRanks[0];
        for(int i = 0; i < n; ++i) {
            if(totalRanks[i].score == topRank.score) {
                int minRank = Integer.MIN_VALUE;
                for(int j = 0; j < r; ++j) {
                    int rank = scores[j].indexOf(new Yodeller(totalRanks[i].num, 0));
                    int score = scores[j].get(rank).score;
                    boolean completed = false;
                    for(int a = rank; a >= 0; --a) {
                        if(scores[j].get(a).score != score) {
                            rank = a + 1;
                            completed = true;
                            break;
                        }
                    }
                    if(!completed) {
                        rank = 0;
                    }
                    minRank = Math.max(rank, minRank);
                }
                System.out.println("Yodeller " + (totalRanks[i].num + 1) + " is the TopYodeller: score " + totalRanks[i].score + ", worst rank " + (minRank + 1));
            }
        }
    }
    public static class Yodeller implements Comparable<Yodeller> {
        public int num;
        public int score;
        public Yodeller(int num, int score){
            this.num = num;
            this.score = score;
        }

        public boolean equals(Object y) {
            if(isSorting) {
                return ((Yodeller)y).score == score;
            }
            return ((Yodeller)y).num == num;
        }

        public int compareTo(Yodeller yodeller) {
            return (yodeller.score - score);
        }
    }
}
