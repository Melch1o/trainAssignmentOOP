import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Train> trains = new ArrayList<Train>();
        Scanner scan = new Scanner(System.in);
        boolean active = true;

        while (active) {
            System.out.println("\nВыберите опцию:\n" +
                    "1. Добавить поезд\n" +
                    "2. Получить информацию о поезде\n" +
                    "3. Добавить пассажира\n" +
                    "4. Получить данные о пассажире\n" +
                    "5. Выход");
            int menu = scan.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("\nВведите ID поезда:");
                    int id = scan.nextInt();

                    boolean trainIdExist = false;
                    for (Train elem : trains) {
                        if (elem.getID() == id) {
                            System.out.println("Поезд с таким ID уже существует!");
                            trainIdExist = true;
                            break;
                        }
                    }
                    if (trainIdExist) {
                        break;
                    }

                    System.out.println("\nВведите вместимость поезда:");
                    int capacity = scan.nextInt();

                    System.out.println("\nВведите место отправления:");
                    String departure = scan.next();

                    System.out.println("\nВведите место прибытия");
                    String destination = scan.next();

                    trains.add(new Train(id, capacity, departure, destination));
                    System.out.println("\nПоезд успешно добавлен!");
                    break;

                case 2:
                    System.out.println("\nНайти поезд по ID или вывести список?\n" +
                                        "1. По ID\n" +
                                        "2. Вывести список\n");
                    int option2 = scan.nextInt();

                    if (option2 == 1) {
                        System.out.println("\nВведите ID поезда:");
                        int givenID2 = scan.nextInt();

                        boolean notFound2 = true;
                        for(Train elem : trains) {
                            if (elem.getID() == givenID2) {
                                System.out.println(elem.toString());
                                notFound2 = false;
                                break;
                            }
                        }
                        if (notFound2) {
                            System.out.println("\nПоезд с таким ID не найден");
                        }

                    }

                    else if (option2 == 2) {
                        for(Train elem : trains) {
                            System.out.println(elem.toString() + "\n");
                        }

                    }

                    else {
                        System.out.println("Выберите опцию из списка");
                    }
                    break;

                case 3:
                    System.out.println("\nВведите ID поезда");
                    int givenID3 = scan.nextInt();

                    boolean notFound3 = true;
                    for (Train elem : trains) {
                        if (elem.getID() == givenID3) {
                            System.out.println("\nВведите ID пассажира");
                            int idPassenger = scan.nextInt();
                            boolean idExist = false;
                            for (Passenger passenger : elem.getPassengers()) {
                                if (passenger.getID() == idPassenger) {
                                    System.out.println("Пассажир с таким ID уже существует!");
                                    idExist = true;
                                    break;
                                }
                            }
                            if (idExist) {
                                break;
                            }

                            System.out.println("\nВведите полное имя пассажира");
                            String firstName = scan.next();
                            String lastname = scan.next();
                            String fullName = firstName + " " + lastname;

                            System.out.println("\nВведите возраст:");
                            int age = scan.nextInt();

                            elem.setPassenger(idPassenger, fullName, age);
                            notFound3 = false;
                            break;
                        }
                    }
                    if (notFound3) {
                        System.out.println("\nПоезд с таким ID не найден");
                    }
                    break;

                case 4:
                    System.out.println("\nВведите ID поезда");
                    int givenTrainID4 = scan.nextInt();

                    boolean notFoundTrain4 = true;
                    for (Train elem : trains) {
                        if (elem.getID() == givenTrainID4) {
                            notFoundTrain4 = false;

                            System.out.println("\nНайти пассажира по ID или вывести список?\n" +
                                                "1. По ID\n" +
                                                "2. Вывести список");
                            int option4 = scan.nextInt();

                            if (option4 == 1) {
                                System.out.println("\nВведите ID пассажира:");
                                int givenID4 = scan.nextInt();

                                boolean notFound4 = true;
                                for(Passenger passenger : elem.getPassengers()) {
                                    if (passenger.getID() == givenID4) {
                                        System.out.println(elem.toString());
                                        notFound4 = false;
                                        break;
                                    }
                                }
                                if (notFound4) {
                                    System.out.println("\nПассажир с таким ID не найден");
                                }
                            }

                            else if (option4 == 2) {
                                System.out.println("\nСписок пассажиров:");
                                for(Passenger passenger : elem.getPassengers()) {
                                    System.out.println(passenger.toString() + "\n");
                                }
                            }

                            else {
                                System.out.println("\nВыберите опцию из списка");
                                break;
                            }
                        }
                    }
                    if (notFoundTrain4) {
                        System.out.println("\nПоезд с таким ID не найден");
                    }
                    break;

                case 5:
                    System.out.println("Спасибо за пользование, удачи!");
                    active = false;
                    break;

                default:
                    System.out.println("Выберите опцию из списка");
                    break;
            }
        }
    }
}