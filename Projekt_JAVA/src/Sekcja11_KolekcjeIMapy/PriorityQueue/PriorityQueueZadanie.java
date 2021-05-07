package Sekcja11_KolekcjeIMapy.PriorityQueue;

import java.util.*;

public class PriorityQueueZadanie {

    static class Order {
        final String orderId;
        final Integer numOfProducts;
        final Double value;

        Order(String orderId, Integer numOfProducts, Double value) {
            this.orderId = orderId;
            this.numOfProducts = numOfProducts;
            this.value = value;
        }

        @Override
        public String toString() {
            return "\nOrder{" +
                    "orderId='" + orderId + '\'' +
                    ", numOfProducts=" + numOfProducts +
                    ", value=" + value +
                    '}';
        }
    }

    static class OrderComparator implements Comparator<Order>
    {

        @Override
        public int compare(Order o1, Order o2) {

            //odwracamy obiekty, żeby było od największej do najmniejszej - można też zrobić rpzy wywołaniu reversed
            if(o2.value.compareTo(o1.value)!=0)
            {
                return o2.value.compareTo(o1.value);
            }
            return o2.numOfProducts.compareTo(o1.numOfProducts);
        }
    }

    @SuppressWarnings("SpellCheckingInspection")
    public static void main(String[] args) {
        /**
         * Napisz program, który dla listy zamówień, przeprocesuje je wg kolejności:
         * najpierw zamówienia o największej wartości, potem z największą ilością productów.
         * Napisz własny Comparator.
         */
        List<Order> orders = Arrays.asList(
                new Order("A", 5, 5000.0),
                new Order("B", 10, 4000.0),
                new Order("C", 1, 400.0),
                new Order("D", 1, 10000.0),
                new Order("E", 10, 5000.0)
        );
        printSolution(orders);


        // D,E,A,B,C
    }

    private static void printSolution(List<Order> orders) {
        Queue<Order> q=new PriorityQueue<Order>(orders.size(), new OrderComparator());
        q.addAll(orders);

        while (!q.isEmpty())
        {
           System.out.println(q.poll());
        }


    }
}
