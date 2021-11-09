package collections.arraylist;

import java.util.*;

public class Pr2 {
    public static void main(String[] args) {
        List<String> colors = new ArrayList<>();
        colors.add("red");
        colors.add("orange");
        colors.add("blue");
        colors.add("yellow");
        Collections.addAll(colors, "white", "grey", "black", "pink", "sky blue");
        colors.addAll(Arrays.asList("light blue", "brown", "green", "emerald green"));
        
        ListIterator<String> lItr = colors.listIterator();
        while (lItr.hasNext()) {
            System.out.print(lItr.next() + " ");
        }
        System.out.println();
        lItr = colors.listIterator(colors.size());
        while (lItr.hasPrevious()) {
            System.out.print(lItr.previous() + " ");
        }
        System.out.println();
    }
}
