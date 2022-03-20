import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static <set> void main(String[] args) {

        var nodes = IntStream.rangeClosed(1, 9)
                .mapToObj(i -> new Intersection("v" + i) )
                .toArray(Intersection[]::new);

        List<Intersection> intersectionsList = new ArrayList<>();

        Collections.addAll(intersectionsList, nodes);

        System.out.println(intersectionsList);

        LinkedList<Street> streetsList = new LinkedList<>();

        Street s12 = new Street("s12",2,intersectionsList.get(0),intersectionsList.get(1));
        streetsList.add(s12);
        Street s13 = new Street("s13",2,intersectionsList.get(0),intersectionsList.get(2));
        streetsList.add(s13);
        Street s14 = new Street("s14",2,intersectionsList.get(0),intersectionsList.get(3));
        streetsList.add(s14);
        Street s23 = new Street("s23",2,intersectionsList.get(1),intersectionsList.get(2));
        streetsList.add(s23);
        Street s25 = new Street("s25",3,intersectionsList.get(1),intersectionsList.get(4));
        streetsList.add(s25);
        Street s34 = new Street("s34",1,intersectionsList.get(2),intersectionsList.get(3));
        streetsList.add(s34);
        Street s36 = new Street("s36",2,intersectionsList.get(2),intersectionsList.get(5));
        streetsList.add(s36);
        Street s37 = new Street("s37",2,intersectionsList.get(2),intersectionsList.get(6));
        streetsList.add(s37);
        Street s46 = new Street("s46",2,intersectionsList.get(3),intersectionsList.get(5));
        streetsList.add(s46);
        Street s56 = new Street("s56",1,intersectionsList.get(4),intersectionsList.get(5));
        streetsList.add(s56);
        Street s58 = new Street("s58",1,intersectionsList.get(4),intersectionsList.get(7));
        streetsList.add(s58);
        Street s59 = new Street("s59",2,intersectionsList.get(4),intersectionsList.get(8));
        streetsList.add(s59);
        Street s69 = new Street("s69",3,intersectionsList.get(5),intersectionsList.get(8));
        streetsList.add(s69);
        Street s78 = new Street("s78",1,intersectionsList.get(6),intersectionsList.get(7));
        streetsList.add(s78);
        Street s79 = new Street("s79",1,intersectionsList.get(6),intersectionsList.get(8));
        streetsList.add(s79);
        Street s89 = new Street("s89",1,intersectionsList.get(7),intersectionsList.get(8));
        streetsList.add(s89);

        System.out.println("The streets are:");
        for (Street s : streetsList)
            System.out.println(s.getName());

        streetsList.sort(Comparator.comparing(Street::getLenght));

        System.out.println();
        System.out.println("The streets ordered by lengths:");
        for (Street s : streetsList)
            System.out.println(s.getName());

        Set<Intersection> intersectionSet = new HashSet<Intersection>();

        System.out.println(intersectionSet);

        intersectionSet.addAll(intersectionsList);
        System.out.println(intersectionSet);

        intersectionSet.addAll(intersectionsList);
        System.out.println(intersectionSet);

    }
}
