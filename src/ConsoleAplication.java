import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class ConsoleAplication {

    private Connection connection;
    private final Scanner consoleReader;


    public ConsoleAplication()
    {
        consoleReader = new Scanner(System.in);
    }






    public void StartWork()
    {
        try
        {
            connection = DbConnector.connectToDb();
            System.out.println("Успешное подключение к бд");

            boolean continueWork = true;
            PrintMenu();

            while (continueWork)
            {
                int action = GetActionInMainMenu();

                switch (action) {

                    case 0 -> continueWork = false;
                    case 22 -> PrintMenu();

                    case 1 -> System.out.println("Hello");
                    default -> System.out.println("Введен неправильный аргумент!");
                }

                connection.close();

            }
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("Ошибка при подключении к бд");
        }
    }

    private void PrintMenu()
    {
        System.out.print(
                """
                        Выберите действие для Домашней библиотеки
                        1. Добавить новое место для книг.
                        2. Добавить новую книгу.
                        4. Посмотреть все места для книг.
                        5. Посмотреть все книги.
                        6. Изменить место по id.
                        7. Изменить книгу по id
                        8. Удалить место по id
                        9. Удалить книгу по id
                        10 Показать 2 поле во всех книгах
                        11 Показать 2 поле во всех книгах в лексикографическом порядке
                        12 Вернуть данные по умолчанию из файла
                        13 Вывести авторов в указанном шкафу в лексикографическом порядке
                        14 вывести суммарный вес изданий в указанном шкафу

                        22 вывести меню
                        0. Выйти.
                        >>\s""");
    }


    private int GetActionInMainMenu() {
        try {
            System.out.println("\nВведите команду: ");

            return Integer.parseInt(consoleReader.nextLine());
        } catch (Exception e) {
            System.out.println("Ошибка ввода, попробуйте еще раз!");
            return GetActionInMainMenu();
        }
    }




}
