package com.company;
import java.util.*;
import static java.lang.Integer.parseInt;

public class Main {
    //function to check if input is number
    public static boolean checkNumber(String input) {
        try {
            parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    //function to check if input is char
    public static boolean checkChar(String input) {
        if(input.length()!=1)
            return false;
        try {
            return Character.isLetter(input.charAt(0));
        } catch (NumberFormatException e) {
            return false;
        }
    }
    //function to add an element to an array
    public static String[] addElement(int n, String array[], String element){
        int i;
        String newArray[] = new String[n+1];
        //copy original array into new array
        for (i = 0; i < n; i++)
        newArray[i] = array[i];

        //add element to the new array
        newArray[n] = element;

        return newArray;
    }
    //function to check if 2 strings have common letters
    static boolean compareTwoStrings(String s1, String s2) {
        boolean result=false;
        Set<Character> set1 = new HashSet<Character>();

        for (char s : s1.toCharArray()){
            set1.add(s);
        }

        for(int i=0;i<s2.length();i++){
            if(set1.contains(s2.charAt(i))){
                result = true;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        //declare the timer
        long startTime = System.nanoTime();
        System.out.println();

        //validate the input
        if(checkNumber(args[0]) == false){
            System.out.println("Invalid input for n!!!");
            return;
        }
        else
            System.out.println("You entered a valid input for n :)");

        //validate the input
        if(checkNumber(args[1]) == false){
            System.out.println("Invalid input for p!!!");
            return;
        }
        else
            System.out.println("You entered a valid input for p :)");

        Integer n = parseInt(args[0]);
        Integer p = parseInt(args[1]);

        //create a string to store the alphabet
        //read the args for the alphabet
        //validate the input and store it in the created string
        String alphabet = new String();
        for ( int i = 2; i < args.length; i++ ){
            if(checkChar(args[i]) == false){
                System.out.println("Invalid input for alphabet!!!");
                return;
            }
            alphabet = alphabet + args[i];
        }
        System.out.println("You entered a valid input for the alphabet :)");

        //create the string words containing random-created word
        //with the given alphabet
        String[] words = new String[n];
        for (int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            Random random = new Random();
            for (int j = 0; j < p; j++){
                int index = random.nextInt(alphabet.length());
                char randomChar = alphabet.charAt(index);
                sb.append(randomChar);
            }
            String randomString = sb.toString();
            words = addElement(i,words,randomString);
        }
        System.out.println();
        System.out.print("The words array will be: ");
        System.out.println(Arrays.toString(words));
        System.out.println();

        //start to build the matrix by using arraylists of arraylists
        boolean[][] matrix = new boolean[n][n];
        ArrayList<ArrayList<String> > list = new ArrayList<ArrayList<String> >(n);

        //by default, the matrix will be false
        for( int i = 0; i < n; i++ )
            Arrays.fill(matrix[i],false);

        for( int i = 0; i < n; i++ ) {
            ArrayList<String> a1 = new ArrayList<String>();
            for (int j = 0; j < n; j++)
                if (compareTwoStrings(words[i], words[j])) {
                    matrix[i][j] = true;
                    if(i != j)
                    a1.add(words[j]);
                }
            list.add(a1);
        }

        //print the neighbors lists
        for (int i = 0; i < list.size(); i++) {
            System.out.print("The neighbors of the word '" + words[i] + "' are: ");
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println();

        //print the matrix
        System.out.println("The nxn matrix could be seen below:");
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }

        //get the time variable
        long endTime = System.nanoTime();
        long timeDifference = endTime - startTime;

        //if n > 30000, we will print the time
        if( n > 30000 ){
            System.out.println();
            System.out.println(timeDifference+" nanoseconds.");
        }
    }
}
