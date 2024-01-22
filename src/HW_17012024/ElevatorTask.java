package HW_17012024;

public class ElevatorTask {
    /*
    * Задача: вызов лифта
    В доме два лифта. Реализовать алгоритм отправки наиближайшего на
    * вызывающий этаж. Алгоритм будет применяться в домах разной этажности.

    Пример:
    в доме 19 этажей
    работают лифт А и лифт В
    лифт А находиться на 0 этаже
    лифт В находиться на 8 этаже
    вызов: 1 этаж
    отправляем лифт А*/

    public static void main(String[] args) {
        Elevator a = new Elevator("A");
        a.setFloor(8);
        Elevator b = new Elevator("B");
        b.setFloor(8);

        int floor = 1;

        System.out.println(findNearestElevator(floor, a, b));
    }
    private static class Elevator{
        private final String name;
        private int floor;
        public Elevator(String name) {
            this.name = name;
        }
        public void setFloor(int floor) {
            this.floor = floor;
        }

        public String getName() {
            return name;
        }

        public int getFloor() {
            return floor;
        }

        @Override
        public String toString() {
            return "Elevator{" +
                    "name='" + name + '\'' +
                    ", floor=" + floor +
                    '}';
        }
    }

    private static Elevator findNearestElevator(int floor, Elevator elevatorA, Elevator elevatorB){

        int diffA = Math.abs(floor - elevatorA.getFloor());
        int diffB = Math.abs(floor - elevatorB.getFloor());

        return diffA <= diffB ? elevatorA : elevatorB;
    }
}
