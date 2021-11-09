package collections.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Pr1 {
    public static void main(String[] args) {
        List<String> colors = new ArrayList<>();
        colors.add("red");
        colors.add("orange");
        colors.add("blue");
        colors.add("yellow");
        // System.out.println(colors);
        Collections.addAll(colors, "white", "grey", "black", "pink", "sky blue");
        // System.out.println(colors);
        colors.addAll(Arrays.asList("light blue", "brown", "green", "emerald green"));
        // System.out.println(colors);

        // adding element at 0th index
        colors.add(0, "Added at 0th index");
        // System.out.println(colors);

        // adding element at a specific index in arraylist
        Random rand = new Random();
        int idx = rand.nextInt(colors.size());
        colors.add(idx, "Added at a random index");
        // System.out.println(colors);

        // update the value at a specific index
        colors.set(1, "Updated the value at index 1");
        // System.out.println(colors);

        // remove the element at the 0th index
        colors.remove(0);
        // -------------OR---------------
        // colors.remove({value})
        // System.out.println(colors);

        // search for an element
        // System.out.println(colors.indexOf("yellow"));

        // sorting the arraylist
        // Collections.sort(colors);
        // in reverse order
        // Collections.sort(colors, Collections.reverseOrder());
        // System.out.println(colors);

        // copy one list to another
        // List<String> copy = new ArrayList<>(colors);
        // System.out.println(colors);
        // System.out.println(copy);

        // shuffling the elements of array
        // Collections.shuffle(colors);
        // System.out.println(colors);

        // reverse an arraylist
        // System.out.println(colors);
        // Collections.reverse(colors);
        // System.out.println(colors);

        // subset of an arraylist
        List<String> subSet = colors.subList(1, 4);
        System.out.println(colors);
        System.out.println(subSet);
    }
}
