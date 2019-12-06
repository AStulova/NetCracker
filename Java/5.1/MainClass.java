import java.util.LinkedList;

public class MainClass {
    public static void creation() {
        MyLinkedList<Integer> intList = new MyLinkedList<>();
        for(int i= 0; i < 10; i++)
            intList.add(i);

        System.out.println(intList);
        System.out.println("Size of intList: " + intList.size());
        System.out.println("Index of 7 in intList: " + intList.indexOf(7));
        System.out.println("Second element is: " + intList.get(1));

        intList.remove(2);
        System.out.println("Size of intList after removing third element: " + intList.size());

        intList.add(2,22);
        System.out.println("Added 22 in second position:");
        intList.forEach(System.out::println);

        intList.set(4, 77);
        System.out.println("Changed 77 in fourth position: ");
        intList.forEach(System.out::println);

        Integer[] intArr = new Integer[5];
        System.out.println("Result of intList.toArray(E[] array): ");
        for (Integer i : intList.toArray(intArr))
            System.out.println(i);
        System.out.println();

        System.out.println("Result of intList.toArray(): ");
        for (Object o : intList.toArray())
            System.out.println(o);
        System.out.println();

        System.out.println("Clearing intList...");
        intList.clear();
        System.out.println("Now its size is " + intList.size());
    }

    public static void comparison() {
        long startTime, startTime1, startTime2, startTime3, startTime4, startTime5, startTime6;

        MyLinkedList<Integer> myList = new MyLinkedList<>();
        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            myList.add(i);
        }
        System.out.println("myList.add(i) - execution time: " + (startTime1 = System.nanoTime() - startTime));

        startTime = System.nanoTime();
        myList.add(500, 200);
        System.out.println("myList.add(500, 200) - execution time: " + (startTime2 = System.nanoTime() - startTime));

        startTime = System.nanoTime();
        myList.get(1050);
        System.out.println("myList.get(1050) - execution time: " + (startTime3 = System.nanoTime() - startTime));

        startTime = System.nanoTime();
        myList.remove(8000);
        System.out.println("myList.remove(8000) - execution time: " + (startTime4 = System.nanoTime() - startTime));

        startTime = System.nanoTime();
        myList.indexOf(6700);
        System.out.println("myList.indexOf(6700) - execution time: " + (startTime5 = System.nanoTime() - startTime));

        startTime = System.nanoTime();
        myList.set(2000, 203);
        System.out.println("myList.set(2000, 203) - execution time: " + (startTime6 = System.nanoTime() - startTime));

        startTime = startTime1 + startTime2 + startTime3 + startTime4 + startTime5 + startTime6;
        System.out.println("TOTAL EXECUTION TIME: " + startTime);
        System.out.println();


        LinkedList<Integer> jList = new LinkedList<>();
        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            jList.add(i);
        }
        System.out.println("jList.add(i) - execution time: " + (startTime1 = System.nanoTime() - startTime));

        startTime = System.nanoTime();
        jList.add(500, 200);
        System.out.println("jList.add(500, 200) - execution time: " + (startTime2 = System.nanoTime() - startTime));

        startTime = System.nanoTime();
        jList.get(1050);
        System.out.println("jList.get(1050) - execution time: " + (startTime3 = System.nanoTime() - startTime));

        startTime = System.nanoTime();
        jList.remove(8000);
        System.out.println("jList.remove(8000) - execution time: " + (startTime4 = System.nanoTime() - startTime));

        startTime = System.nanoTime();
        jList.indexOf(6700);
        System.out.println("jList.indexOf(6700) - execution time: " + (startTime5 = System.nanoTime() - startTime));

        startTime = System.nanoTime();
        jList.set(2000, 203);
        System.out.println("jList.set(2000, 203) - execution time: " + (startTime6 = System.nanoTime() - startTime));

        startTime = startTime1 + startTime2 + startTime3 + startTime4 + startTime5 + startTime6;
        System.out.println("TOTAL EXECUTION TIME: " + startTime);
    }

    public static void main(String[] args) {
        System.out.println("----- PART 1 -----");
        creation();
        System.out.println();
        System.out.println("----- PART 2 -----");
        comparison();
    }
}
