package ru.skypro;

import java.util.Scanner;

public class Main {
    private static final Employee[] employees = new Employee[10];

    public static void getAllEmployees(){
        for(int i=0; i<employees.length; i++){
            System.out.println((i+1) + ") " + employees[i]);
        }
    }

    public static int countMonthlySalary(){
        int salary = 0;
        for(int i=0; i<employees.length; i++){
            salary += employees[i].getSalary();
        }
        return salary;
    }

    public static Employee findLowestSalaryEmployee(){
        int min = 0;
        for(int i=1; i<employees.length; i++){
            if(employees[min].getSalary() > employees[i].getSalary()){
                min = i;
            }
        }
        return employees[min];
    }

    public static Employee findHighestSalaryEmployee(){
        int max = 0;
        for(int i=1; i<employees.length; i++){
            if(employees[max].getSalary() < employees[i].getSalary()){
                max = i;
            }
        }
        return employees[max];
    }

    public static double averageMonthlySalary(){
        double salary = countMonthlySalary();
        return salary / employees.length;
    }

    public static void getAllFullNames(){
        for(int i=0; i<employees.length; i++){
            System.out.println((i+1) + ") "
                    + employees[i].getLastname() + " " + employees[i].getFirstname() + " " + employees[i].getPatronymic());
        }
    }

    private static void fillEmployees(){
        employees[0] = new Employee("Вася", "Васильев", "Васильевич", 1, 2000);
        employees[1] = new Employee("Петр", "Петров", "Петрович", 2, 3000);
        employees[2] = new Employee("Иван", "Иванов", "Иванович", 3, 4000);
        employees[3] = new Employee("Карл", "Карлов", "Карлович", 4, 1500);
        employees[4] = new Employee("Игорь", "Игорев", "Игоревич", 5, 5000);
        employees[5] = new Employee("Катя", "Петров", "Петровна", 1, 2500);
        employees[6] = new Employee("Светалана", "Светова", "Ивановка", 2, 4000);
        employees[7] = new Employee("Майкл", "Майков", "Артурович", 3, 900);
        employees[8] = new Employee("Александр", "Александров", "Александрович", 4, 3500);
        employees[9] = new Employee("Алексей", "Алексеев", "Алексеевич", 5, 8000);
    }

    public static void main(String[] args) {
        fillEmployees();

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println(
                    """
                    
                    1. Список всех сотрудников.
                    2. Сумма затрат на зарплаты в месяц.
                    3. Сотрудник с минимальное зарплатой.
                    4. Сотрудник с максимальной зарплатой.
                    5. Среднее значение зарплат.
                    6. ФИО всех сотрудников.
                    0. Завершить программу.
                    """
            );
            String choice = scanner.next();
            if(!choice.matches("[0-6]")){
                System.out.println("Введите число от 0 до 6!");
                continue;
            }

            if(choice.equals("0")){
                break;
            }

            switch (choice){
                case "1" -> getAllEmployees();
                case "2" -> System.out.println(countMonthlySalary());
                case "3" -> System.out.println(findLowestSalaryEmployee());
                case "4" -> System.out.println(findHighestSalaryEmployee());
                case "5" -> System.out.println(averageMonthlySalary());
                case "6" -> getAllFullNames();
            }
        }
    }
}