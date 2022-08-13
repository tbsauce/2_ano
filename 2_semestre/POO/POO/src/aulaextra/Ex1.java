package aula12;

import java.io.*;
import java.util.*;

public class Ex1 {
    public static void main(String[] args) throws IOException {

        TreeSet<Movie> movies = new TreeSet<Movie>();
        // TreeSet<Movie> movies = new TreeSet<>((m1, m2) -> {return m1.getName().toLowerCase().compareTo(m2.getName().toLowerCase());});
        
        String line;
        String[] splt;
        try {
            Scanner scf = new Scanner(new File("movies.txt"));
            scf.nextLine();
            
            while(scf.hasNextLine()) {
                line = scf.nextLine();
                splt = line.split("\\t");

                movies.add(new Movie(splt[0], Double.parseDouble(splt[1]), splt[2], splt[3], Integer.parseInt(splt[4])));
            }

            scf.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(-1);
        }

        movies.forEach(System.out::println);

        System.out.print("\n\n\nDecrescente por Score\n");
        printByScore(movies);
        
        System.out.print("\n\n\nCrescente por Running Time:\n");
        printByRunningTime(movies);

        printGenres(movies);

        writeMySelection(movies);
    }

    public static void printByScore(TreeSet<Movie> s) {        
        
        List<Movie> l = new ArrayList<Movie>(s);

        l.sort((m1, m2) -> Double.compare(m1.getScore(), m2.getScore()));
        Collections.reverse(l);
        
        // l.forEach(System.out::println);
        for(int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }
    }

    public static void printByRunningTime(Collection<Movie> c) {
        c.stream()
        .sorted((m1, m2) -> Integer.compare(m1.getR_time(), m2.getR_time()))
        .forEach(System.out::println);
    }

    public static void printGenres(Set<Movie> s) {
        Set<String> tmp = new HashSet<String>();

        for(Movie m : s) {
            tmp.add(m.getGenre());
        }
        tmp.forEach(System.out::println);
    }

    public static void writeMySelection(Set<Movie> s) throws IOException {
        PrintWriter pwd = new PrintWriter(new File("myselection.txt"));

        // s.stream()
        // .filter(m -> m.getScore() > 60)
        // .filter(m -> m.getGenre().equals("comedy"))
        // .forEach(m -> pwd.println(m.toString()));
        for(Movie m : s) {
            if (m.getScore() > 60 && m.getGenre().equals("comedy")) {
                pwd.println(m.toString());
            }
        }

        pwd.close();
    }
}

