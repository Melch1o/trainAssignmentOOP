import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Создаем ArrayList с поездами
        ArrayList<Train> trains = new ArrayList<Train>();
        Scanner scan = new Scanner(System.in);

        // Условие выхода с программы
        boolean active = true;

        // Главый цикл программы
        while (active) {

            // Меню
            System.out.println("\nВыберите опцию:\n" +
                    "1. Добавить поезд\n" +
                    "2. Получить информацию о поезде\n" +
                    "3. Добавить пассажира\n" +
                    "4. Получить данные о пассажире\n" +
                    "5. Выход");
            int menu = scan.nextInt();

            // Логика меню
            switch (menu) {
                case 1: // Добавить поезд

                    // Вводим ID поезда
                    System.out.println("\nВведите ID поезда:");
                    int id = scan.nextInt();

                    // Проверяем, существует ли уже поезд с указанным ID
                    boolean trainIdExist = false;
                    
                    // Проходимся по всем поездам
                    for (Train elem : trains) {

                        // Если указанный ID совпадает с ID какого-то поезда
                        if (elem.getID() == id) {
                            System.out.println("Поезд с таким ID уже существует!");
                            trainIdExist = true;
                            break;
                        }
                    }

                    // Останавливаем кэйс
                    if (trainIdExist) {
                        break;
                    }

                    // Вводим вместимость поезда
                    System.out.println("\nВведите вместимость поезда:");
                    int capacity = scan.nextInt();

                    // Вводим место отправления поезда
                    System.out.println("\nВведите место отправления:");
                    String departure = scan.next();

                    // Вводим место прибытия поезда
                    System.out.println("\nВведите место прибытия");
                    String destination = scan.next();

                    // Добавляем поезд в массив
                    trains.add(new Train(id, capacity, departure, destination));
                    System.out.println("\nПоезд успешно добавлен!");
                    break;

                case 2: // Получить информацию о поезде

                    // Выбор способа получения информации 
                    System.out.println("\nНайти поезд по ID или вывести список?\n" +
                                        "1. По ID\n" +
                                        "2. Вывести список\n");
                    int option2 = scan.nextInt();

                    if (option2 == 1) { // По ID

                        // Вводим ID поезда
                        System.out.println("\nВведите ID поезда:");
                        int givenID2 = scan.nextInt();

                        // Проверка на случай, если поезда с таким ID не существует 
                        boolean notFound2 = true;

                        // Проходимся по поездам
                        for(Train elem : trains) {

                            // Если указанный ID совпадает с ID какого-то поезда
                            if (elem.getID() == givenID2) {

                                // С помощью метода toString() выводим всю информацию о нём 
                                System.out.println(elem.toString());
                                notFound2 = false;
                                break;
                            }
                        }

                        // Если поезд с указанным ID не нашёлся 
                        if (notFound2) {
                            System.out.println("\nПоезд с таким ID не найден");
                        }
                    }

                    else if (option2 == 2) { // Вывести список
            
                        // Проходимся по поездам 
                        for(Train elem : trains) {

                            // И выводим информацию о каждом из них
                            System.out.println(elem.toString() + "\n");
                        }
                    }

                   
                    else { // Default вариант
                        System.out.println("Выберите опцию из списка");
                    }
                    break;

                case 3: // Добавить пассажира

                    // Вводим ID поезда
                    System.out.println("\nВведите ID поезда");
                    int givenID3 = scan.nextInt();

                    // Проверка на случай, если поезда с указанным ID нет
                    boolean notFound3 = true;

                    // Проходимся по поездам
                    for (Train elem : trains) {

                        // Если указанный ID совпадает с ID какого-то поезда
                        if (elem.getID() == givenID3) {

                            // Вводим ID пассажира
                            System.out.println("\nВведите ID пассажира");
                            int idPassenger = scan.nextInt();

                            // Проверка, на совпадающие ID
                            boolean idExist = false;

                            // Проходимся по пассажирам
                            for (Passenger passenger : elem.getPassengers()) {

                                // Если указанный ID совпадает с ID какого-то пассажира
                                if (passenger.getID() == idPassenger) {
                                    System.out.println("Пассажир с таким ID уже существует!");
                                    idExist = true;
                                    break;
                                }
                            }

                            // Останавливаем кэйс
                            if (idExist) {
                                break;
                            }

                            // Вводим полное имя пассажира
                            System.out.println("\nВведите полное имя пассажира");
                            String firstName = scan.next();
                            String lastname = scan.next();
                            String fullName = firstName + " " + lastname;

                            // Вводим возраст пассажира 
                            System.out.println("\nВведите возраст:");
                            int age = scan.nextInt();

                            // Создаем пассажира с указанными данными
                            elem.setPassenger(idPassenger, fullName, age);
                            notFound3 = false;
                            break;
                        }
                    }

                    // Если поезд не нашёлся 
                    if (notFound3) {
                        System.out.println("\nПоезд с таким ID не найден");
                    }
                    break;

                case 4: // Получить данные о пассажире

                    // Вводим ID поезда
                    System.out.println("\nВведите ID поезда");
                    int givenTrainID4 = scan.nextInt();

                    // Проверка на случай, если поезда с указанным ID нет
                    boolean notFoundTrain4 = true;

                    // Проходимся по поездам
                    for (Train elem : trains) {

                        // Если указанный ID совпадает с ID какого-то поезда
                        if (elem.getID() == givenTrainID4) {
                            notFoundTrain4 = false;

                            // Выбор способа получения информации 
                            System.out.println("\nНайти пассажира по ID или вывести список?\n" +
                                                "1. По ID\n" +
                                                "2. Вывести список");
                            int option4 = scan.nextInt();

                            if (option4 == 1) { // По ID

                                // Вводим ID пассажира
                                System.out.println("\nВведите ID пассажира:");
                                int givenID4 = scan.nextInt();

                                // Проверка на случай, если пассажира с указанным ID нет
                                boolean notFound4 = true;

                                // Проходимся по пассажирам
                                for(Passenger passenger : elem.getPassengers()) {

                                    // Если указанный ID совпадает с ID какого-то пассажира 
                                    if (passenger.getID() == givenID4) {

                                        // Используя метод toString() выводим всю информацию о нем
                                        System.out.println(elem.toString());
                                        notFound4 = false;
                                        break;
                                    }
                                }

                                // Если пассажир с указанным ID не нашёлся 
                                if (notFound4) {
                                    System.out.println("\nПассажир с таким ID не найден");
                                }
                            }

                            else if (option4 == 2) { // Вывести список

                                System.out.println("\nСписок пассажиров:");

                                // Проходимся по пассажирам 
                                for(Passenger passenger : elem.getPassengers()) {

                                    // И выводим всю информацию о них
                                    System.out.println(passenger.toString() + "\n");
                                }
                            }

                            else { // Default вариант 
                                System.out.println("\nВыберите опцию из списка");
                                break;
                            }
                        }
                    }

                    // Если поезд с указанным ID не нашёлся 
                    if (notFoundTrain4) {
                        System.out.println("\nПоезд с таким ID не найден");
                    }
                    break;

                case 5: // Выход
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
