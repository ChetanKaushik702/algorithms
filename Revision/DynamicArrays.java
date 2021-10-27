package Revision;

import java.util.Scanner;

public class DynamicArrays {
    private int[] list;
    private int len;

    DynamicArrays() {
        list = new int[2];
        len = -1;
    }

    void add(int value) {
        if (len == list.length - 1) {
            // array is full
            int[] newList = new int[2 * list.length];
            for (int i = 0; i <= len; i++)   newList[i] = list[i];
            len++;
            newList[len] = value;
            list = newList;
        } else {
            len++;
            list[len] = value;
        }
    }

    public String toString() {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i <= len; i++)    {
            int val = list[i];
            out.append(val).append(" ");
        }
        return out.toString();
    }

    public static void main(String[] args) {
        DynamicArrays dArray = new DynamicArrays();
        Scanner sc = new Scanner(System.in);
        int value;
        do {
            value = sc.nextInt();
            dArray.add(value);
            System.out.println(dArray);
        } while (value != -1);
        sc.close();
    }
}
