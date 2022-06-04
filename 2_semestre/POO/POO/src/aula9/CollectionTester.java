package aula9;
import java.util.*;

public class CollectionTester {
    public static void main(String[] args) {
        int [] DIM = {1000,5000,10000,20000,40000,100000};
        String [] types = {"Add", "Search", "Remove"};
        ArrayList<ArrayList<Double>> times = new ArrayList<>();

        System.out.println("---------------------------------------");
        System.out.println("Collection\t1000\t\t5000\t\t10000\t\t20000\t\t40000\t\t100000");

        //Arrylist
        times.clear();
        Collection<Integer> col = new ArrayList<>();
        System.out.println(col.getClass().getSimpleName());
        for (int i = 0; i < 6; i++) {
            times.add(checkPerformance(col, DIM[i]));
        }
        for (int i = 0; i < types.length; i++) {
            System.out.print(types[i] + "\t");
            for (int j = 0; j < DIM.length; j++) {
                System.out.print("\t" + times.get(j).get(i));
            }
            System.out.println();
        }

        //LinkedList
        times.clear();
        col = new LinkedList<>();
        System.out.println(col.getClass().getSimpleName());
        for (int i = 0; i < 6; i++) {
            times.add(checkPerformance(col, DIM[i]));
        }
        for (int i = 0; i < types.length; i++) {
            System.out.print(types[i] + "\t");
            for (int j = 0; j < DIM.length; j++) {
                System.out.print("\t" + times.get(j).get(i));
            }
            System.out.println();
        }

        //HashSet
        times.clear();
        col = new HashSet<>();
        System.out.println(col.getClass().getSimpleName());
        for (int i = 0; i < 6; i++) {
            times.add(checkPerformance(col, DIM[i]));
        }
        for (int i = 0; i < types.length; i++) {
            System.out.print(types[i] + "\t");
            for (int j = 0; j < DIM.length; j++) {
                System.out.print("\t" + times.get(j).get(i));
            }
            System.out.println();
        }

        //TreeSet
        times.clear();
        col = new TreeSet<>();
        System.out.println(col.getClass().getSimpleName());
        for (int i = 0; i < 6; i++) {
            times.add(checkPerformance(col, DIM[i]));
        }
        for (int i = 0; i < types.length; i++) {
            System.out.print(types[i] + "\t");
            for (int j = 0; j < DIM.length; j++) {
                System.out.printf("\t %f", times.get(j).get(i));
            }
            System.out.println();
        }




    }
        
    private static ArrayList<Double> checkPerformance(Collection<Integer> col, int DIM) {
        double start, stop, delta;
        ArrayList<Double> times = new ArrayList<>();
        // Add
        start = System.nanoTime(); // clock snapshot before
        for(int i=0; i<DIM; i++ )
            col.add( i );
        stop = System.nanoTime(); // clock snapshot after
        delta = (stop-start)/1e6; // convert to milliseconds
        times.add(delta);

        // Search
        start = System.nanoTime(); // clock snapshot before
        for(int i=0; i<DIM; i++ ) {
            int n = (int) (Math.random()*DIM);
            if (!col.contains(n))
                System.out.println("Not found???"+n);
        }
        stop = System.nanoTime(); // clock snapshot after
        delta = (stop-start)/1e6; // convert nanoseconds to milliseconds
        times.add(delta);

        // Remove
        start = System.nanoTime(); // clock snapshot before
        Iterator<Integer> iterator = col.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        stop = System.nanoTime(); // clock snapshot after
        delta = (stop-start)/1e6; // convert nanoseconds to milliseconds
        times.add(delta);
        return times;
    }
}