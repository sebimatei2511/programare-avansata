import com.github.javafaker.Faker;
import org.jgrapht.Graph;
import org.jgrapht.alg.spanning.KruskalMinimumSpanningTree;
import org.jgrapht.graph.DefaultUndirectedWeightedGraph;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        var nodes = IntStream.rangeClosed(1, 9)
                .mapToObj(i -> new Intersection("v" + i))
                .toArray(Intersection[]::new);

        Faker faker = new Faker();

        List<Intersection> intersectionsList = new ArrayList<>();
        Collections.addAll(intersectionsList, nodes);
        System.out.println(intersectionsList);

        LinkedList<Street> streetsList = new LinkedList<>();

        Street s12 = new Street("s12", 2, intersectionsList.get(0), intersectionsList.get(1));
        streetsList.add(s12);
        Street s13 = new Street("s13", 2, intersectionsList.get(0), intersectionsList.get(2));
        streetsList.add(s13);
        Street s14 = new Street("s14", 2, intersectionsList.get(0), intersectionsList.get(3));
        streetsList.add(s14);
        Street s23 = new Street("s23", 2, intersectionsList.get(1), intersectionsList.get(2));
        streetsList.add(s23);
        Street s25 = new Street("s25", 3, intersectionsList.get(1), intersectionsList.get(4));
        streetsList.add(s25);
        Street s34 = new Street("s34", 1, intersectionsList.get(2), intersectionsList.get(3));
        streetsList.add(s34);
        Street s36 = new Street("s36", 2, intersectionsList.get(2), intersectionsList.get(5));
        streetsList.add(s36);
        Street s37 = new Street("s37", 2, intersectionsList.get(2), intersectionsList.get(6));
        streetsList.add(s37);
        Street s46 = new Street("s46", 3, intersectionsList.get(3), intersectionsList.get(5));
        streetsList.add(s46);
        Street s56 = new Street("s56", 1, intersectionsList.get(4), intersectionsList.get(5));
        streetsList.add(s56);
        Street s58 = new Street("s58", 1, intersectionsList.get(4), intersectionsList.get(7));
        streetsList.add(s58);
        Street s59 = new Street("s59", 2, intersectionsList.get(4), intersectionsList.get(8));
        streetsList.add(s59);
        Street s69 = new Street("s69", 3, intersectionsList.get(5), intersectionsList.get(8));
        streetsList.add(s69);
        Street s78 = new Street("s78", 1, intersectionsList.get(6), intersectionsList.get(7));
        streetsList.add(s78);
        Street s79 = new Street("s79", 1, intersectionsList.get(6), intersectionsList.get(8));
        streetsList.add(s79);
        Street s89 = new Street("s89", 1, intersectionsList.get(7), intersectionsList.get(8));
        streetsList.add(s89);

        Set<Intersection> intersectionSet = new HashSet<Intersection>(intersectionsList);

        //Create a class that describes the city.

        City city = new City(intersectionsList, streetsList, intersectionSet);

        //Using Java Stream API,
        // write a query that display all the streets that are
        // longer than a specified value and join at least 3 streets.

        for (Street i : streetsList) {
            int numberOfJoins = -1;
            for (Street j : streetsList) {
                if (i.getNode1() == j.getNode2() ||
                        i.getNode1() == j.getNode1() ||
                        i.getNode2() == j.getNode1() ||
                        i.getNode2() == j.getNode2()) {
                    numberOfJoins++;
                }
            }
            //numberOfJoins--;
            i.setNumberOfJoins(numberOfJoins);
        }

        List<Street> result = streetsList.stream().filter(s -> s.lenght > 1 && s.getNumberOfJoins() > 5).toList();

        System.out.println("The roads longer than 1 that have at least 5 joins are: ");
        for (Street i : result)
            System.out.println(i.getName() + " with " + i.getNumberOfJoins()+" joined streets");
        System.out.println();

        //Use a third-party library in order to generate
        // random fake names for intersections and streets.

        System.out.println("Tha fake names for the intersections are:");
        for (Intersection i : intersectionSet) {
            i.setName(faker.address().streetName());
            System.out.println(i.getName()+" Square");
        }
        System.out.println();

        System.out.println("The fake names for the streets are:");
        for (Street s : streetsList) {
            s.setName(faker.address().streetName());
            System.out.println(s.getName()+" St.");
        }
    }
}
