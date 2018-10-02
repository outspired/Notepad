package notepad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Record> recordList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter command (create/del/list/exit):");
            String cmd = askString();
            switch (cmd) {
                case "createperson":
                case "cp":
                    createPerson();
                    break;
                case "createnote":
                case "cn":
                    createNote();
                    break;
                case "find":
                    find();
                    break;
                case "c":
                    createTurbo();
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

    private static void find() {
        System.out.println("Find what:");
        String str = askString();
        for (Record r : recordList) {
            if (r.hasSubString(str)) {
                System.out.println(r);
            }
        }
    }


    private static String askString() {
        var result = new ArrayList<String>();
        var word = scanner.next();
        if (word.startsWith("\"")) {
            do {
                result.add(word);
                if (word.endsWith("\"")) {
                    return String.join(" ", result).replace("\"", "");
                }
                word = scanner.next();
            } while (true);
        } else {
            return word;
        }
    }

    private static void delete() {
        System.out.println("ID to delete:");
        int idToDelete = scanner.nextInt();
        for (int i = 0; i < recordList.size(); i++) {


            if (recordList.get(i).getId() == idToDelete) {
                recordList.remove(i);
                break;
            }
        }
    }

//    private static void delete() {
//        System.out.println("ID to delete:");
//        int idToDelete = scanner.nextInt();
//        for (Person p : recordList) {
//            if (idToDelete == p.getId()) {
//                recordList.remove(p);
//                break;
//            }
//        }
//    }

    private static void list() {
        for (Record p : recordList) {
            System.out.println(p);
            //System.out.printf("%s %s %s \n", p.getName(), p.getSurname(), p.getPhone());
        }
    }


    private static void createPerson() {

        System.out.println("Enter new name:");
        String name = askString();

        System.out.println("Enter new surname:");
        String surname = askString();

        System.out.println("Enter new phone:");
        String phone = askString();

        System.out.println("Enter new e-mail:");
        String email = askString();

        Person p = new Person();
        p.setName(name);
        p.setSurname(surname);
        p.setPhone(phone);
        p.setEmail(email);

        recordList.add(p);
        System.out.println(p);
    }

    private static void createNote() {
        System.out.println("Enter new subject:");
        String subject = askString();

        System.out.println("Enter new note body:");
        String body = askString();

        Note n = new Note();
        n.setNoteSubject(subject);
        n.setNoteBody(body);
        recordList.add(n);
        System.out.println(n);

    }

    private static void createTurbo() {
        for (int i = 0; i < 5; i++) {
            String name = "name" + i;
            String surname = "surname" + i;
            String phone = "phone" + i;
            String email = "email" + i;
            Person p = new Person();
            p.setName(name);
            p.setSurname(surname);
            p.setPhone(phone);
            p.setEmail(email);
            recordList.add(p);
        }
    }
}
