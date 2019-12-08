import java.util.*;

public class MainTest {
    public static void compA() {
        long startTime, startTime1, startTime2, startTime3, startTime4;

        List<Integer> arrayList = new ArrayList<>();
        startTime = System.nanoTime();
        for (int i = 0; i < 50000; i++) {
            arrayList.add(i);
        }
        System.out.println("arrayList.add(i) - execution time: " + (startTime1 = System.nanoTime() - startTime));

        startTime = System.nanoTime();
        arrayList.add(25000,243);
        System.out.println("arrayList.add(25000,243) - execution time: " + (startTime2 = System.nanoTime() - startTime));

        startTime = System.nanoTime();
        arrayList.set(25000, 123);
        System.out.println("arrayList.set(25000, 123) - execution time: " + (startTime3 = System.nanoTime() - startTime));

        startTime = System.nanoTime();
        arrayList.remove(25000);
        System.out.println("arrayList.remove(25000) - execution time: " + (startTime4 = System.nanoTime() - startTime));
        System.out.println("TOTAL EXECUTION TIME: " + (startTime1 + startTime2 + startTime3 + startTime4));
        System.out.println();


        List<Integer> linkedList = new LinkedList<>();
        startTime = System.nanoTime();
        for (int i = 0; i < 50000; i++) {
            linkedList.add(i);
        }
        System.out.println("linkedList.add(i) - execution time: " + (startTime1 = System.nanoTime() - startTime));

        startTime = System.nanoTime();
        linkedList.add(25000,243);
        System.out.println("linkedList.add(25000,243) - execution time: " + (startTime2 = System.nanoTime() - startTime));

        startTime = System.nanoTime();
        linkedList.set(25000, 123);
        System.out.println("linkedList.set(25000, 123) - execution time: " + (startTime3 = System.nanoTime() - startTime));

        startTime = System.nanoTime();
        linkedList.remove(25000);
        System.out.println("linkedList.remove(25000) - execution time: " + (startTime4 = System.nanoTime() - startTime));
        System.out.println("TOTAL EXECUTION TIME: " + (startTime1 + startTime2 + startTime3 + startTime4));
    }

    public static void compB() {
        long startTime, startTime1, startTime2;

        Set<Integer> hashSet = new HashSet<>();
        startTime = System.nanoTime();
        for (int i = 0; i < 50000; i++) {
            hashSet.add(i);
        }
        System.out.println("hashSet.add(i) - execution time: " + (startTime1 = System.nanoTime() - startTime));

        startTime = System.nanoTime();
        hashSet.remove(25000);
        System.out.println("hashSet.remove(25000) - execution time: " + (startTime2 = System.nanoTime() - startTime));
        System.out.println("TOTAL EXECUTION TIME: " + (startTime1 + startTime2));
        System.out.println();

        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        startTime = System.nanoTime();
        for (int i = 0; i < 50000; i++) {
            linkedHashSet.add(i);
        }
        System.out.println("linkedHashSet.add(i) - execution time: " + (startTime1 = System.nanoTime() - startTime));

        startTime = System.nanoTime();
        linkedHashSet.remove(25000);
        System.out.println("linkedHashSet.remove(25000) - execution time: " + (startTime2 = System.nanoTime() - startTime));
        System.out.println("TOTAL EXECUTION TIME: " + (startTime1 + startTime2));
        System.out.println();

        Set<Integer> treeSet = new TreeSet<>();
        startTime = System.nanoTime();
        for (int i = 0; i < 50000; i++) {
            treeSet.add(i);
        }
        System.out.println("treeSet.add(i) - execution time: " + (startTime1 = System.nanoTime() - startTime));

        startTime = System.nanoTime();
        treeSet.remove(25000);
        System.out.println("treeSet.remove(25000) - execution time: " + (startTime2 = System.nanoTime() - startTime));
        System.out.println("TOTAL EXECUTION TIME: " + (startTime1 + startTime2));
    }

    public static void compC() {
        long startTime, startTime1, startTime2, startTime3;

        Map<Integer, Integer> hashMap = new HashMap<>();
        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++)
            for (int j = 0; j < 10000; j++) {
                hashMap.put(i, j);
            }
        System.out.println("hashMap.put(i, j) - execution time: " + (startTime1 = System.nanoTime() - startTime));

        startTime = System.nanoTime();
        hashMap.put(5000, 123);
        System.out.println("hashMap.put(5000, 123) - execution time: " + (startTime2 = System.nanoTime() - startTime));

        startTime = System.nanoTime();
        hashMap.remove(5000);
        System.out.println("hashMap.remove(5000) - execution time: " + (startTime3 = System.nanoTime() - startTime));
        System.out.println("TOTAL EXECUTION TIME: " + (startTime1 + startTime2 + startTime3));
        System.out.println();


        Map<Integer,Integer> linkedHashMap = new LinkedHashMap<>();
        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++)
            for (int j = 0; j < 10000; j++) {
                linkedHashMap.put(i, j);
            }
        System.out.println("linkedHashMap.put(i, j) - execution time: " + (startTime1 = System.nanoTime() - startTime));

        startTime = System.nanoTime();
        linkedHashMap.put(5000, 123);
        System.out.println("linkedHashMap.put(5000, 123) - execution time: " + (startTime2 = System.nanoTime() - startTime));

        startTime = System.nanoTime();
        linkedHashMap.remove(5000);
        System.out.println("linkedHashMap.remove(5000) - execution time: " + (startTime3 = System.nanoTime() - startTime));
        System.out.println("TOTAL EXECUTION TIME: " + (startTime1 + startTime2 + startTime3));
        System.out.println();


        Map<Integer, Integer> treeMap = new TreeMap<>();
        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++)
            for (int j = 0; j < 10000; j++) {
                treeMap.put(i, j);
            }
        System.out.println("treeMap.put(i, j) - execution time: " + (startTime1 = System.nanoTime() - startTime));

        startTime = System.nanoTime();
        treeMap.put(5000, 123);
        System.out.println("treeMap.put(5000, 123) - execution time: " + (startTime2 = System.nanoTime() - startTime));

        startTime = System.nanoTime();
        treeMap.remove(5000);
        System.out.println("treeMap.remove(5000) - execution time: " + (startTime3 = System.nanoTime() - startTime));
        System.out.println("TOTAL EXECUTION TIME: " + (startTime1 + startTime2 + startTime3));
    }

    public static void main(String[] args) {
        System.out.println("----- A -----");
        compA();
        System.out.println();
        System.out.println("----- B -----");
        compB();
        System.out.println();
        System.out.println("----- C -----");
        compC();
    }
}