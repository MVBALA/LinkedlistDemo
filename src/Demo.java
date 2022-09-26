import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<String>();
        addInOrder(placesToVisit, "Delhi");
        addInOrder(placesToVisit, "Mumbai");
        addInOrder(placesToVisit, "Chennai");
        addInOrder(placesToVisit, "Goa");

        addInOrder(placesToVisit, "Sydney");
        addInOrder(placesToVisit, "Melbourne");
        addInOrder(placesToVisit, "Brisbane");
        addInOrder(placesToVisit, "Perth");
        addInOrder(placesToVisit, "Canberra");
        addInOrder(placesToVisit, "Adelaide");
        addInOrder(placesToVisit, "Darwin");
        printList(placesToVisit);
        addInOrder(placesToVisit, "Goa");
        addInOrder(placesToVisit, "Coimbatore");
        addInOrder(placesToVisit, "Tirchy");
        printList(placesToVisit);
        visit(placesToVisit);


    }

    public static void printList(LinkedList<String> a) {
        Iterator<String> i = a.iterator();
        while (i.hasNext()) {
            System.out.println("Places to visit " + i.next());
        }
        System.out.println("=========================");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
        ListIterator<String> stringListIterator = linkedList.listIterator();
        while (stringListIterator.hasNext()) {
            int comparsion = stringListIterator.next().compareTo(newCity);
            if (comparsion == 0) {
                System.out.println(newCity + " is already included as a destination");
                return false;
            } else if (comparsion > 0) {
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            } else if (comparsion < 0) {

            }
        }
        stringListIterator.add(newCity);
        return true;
    }


    private static void visit(LinkedList cities) {
        Scanner input = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();
        if (cities.isEmpty()) {
            System.out.println("No cities in the itenerary");
            return;
        } else {
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }
        while (!quit) {
            int action = input.nextInt();
            input.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Hoiday (Vacation) over");
                    quit = true;
                    break;
                case 1:
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;

                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now visiting " + listIterator.next());
                    } else
                        System.out.println("Reached the end of the list ");
                    goingForward = false;
                    break;
                case 2:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;

                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now visiting " + listIterator.previous());
                    } else {
                        System.out.println("we are at the start of the list");
                        goingForward = true;
                        break;
                    }
                case 3:
                    printMenu();
                    ;
                    break;
            }


        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress ");
        System.out.println("0 - to quit\n" +
                "1 - go to next city\n" +
                "2 - go to previous city\n" +
                "3 - print menu options");
    }
}
