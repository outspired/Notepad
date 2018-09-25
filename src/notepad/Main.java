package notepad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Person> personList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter command (create/del/list/exit):");
            String cmd = scanner.next();
            switch (cmd) {
                case "create":
                    create();
                    break;
                case "del":
                    delete();
                    break;
                case "list":
                    list();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Unknown command");
            }
        }
    }

    private static void delete() {
        System.out.println("ID to delete:");
        int idToDelete = scanner.nextInt();
        for (int i = 0; i < personList.size(); i++) {


            if (personList.get(i).getId() == idToDelete) {
                personList.remove(i);
                break;
            }
        }
    }

    private static void list() {
        for (Person p : personList) {
            System.out.println(p);
            //System.out.printf("%s %s %s \n", p.getName(), p.getSurname(), p.getPhone());
        }
    }


    private static void create() {

        System.out.println("Enter new name:");
        String name = scanner.next();

        System.out.println("Enter new surname:");
        String surname = scanner.next();

        System.out.println("Enter new phone:");
        String phone = scanner.next();

        Person p = new Person();
        p.setName(name);
        p.setSurname(surname);
        p.setPhone(phone);

        personList.add(p);
        System.out.println(p);
    }
}
