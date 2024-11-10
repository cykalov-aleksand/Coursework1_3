public class Main {
    static void printTitle(String title) {
        int lineLength = 100;
        int headerLength = title.length();
        int numberOfCharacters = (lineLength - headerLength) / 2;
        String completion = "-";
        System.out.println("\n" + completion.repeat(numberOfCharacters) + title + completion.repeat(numberOfCharacters));
    }
    public static void main(String[] args) {
        EmployeeBook book = new EmployeeBook();
        printTitle("КУРСОВОЕ ЗАДАНИЕ");
        printTitle("КНИГА СОТРУДНИКОВ");
        printTitle("БАЗОВАЯ СЛОЖНОСТЬ");
        printTitle("a) список всех сотрудников");
        book.outputTheTable();
        printTitle("b) сумму затрат на ЗП в месяц");
        if (book.calculateAmountExpenses() == 0 && book.countTheEmployees() != 0) {
            System.out.println("Руководитель не платит работникам зарплату");
        } else if (book.countTheEmployees() == 0) {
            System.out.println("Штат пуст, трудоустраиваите людей на вакантные должности");
        } else {
            System.out.printf("%s%.2f%s\n", "Сумма затрат на зарплату сотрудникам составляет: ", book.calculateAmountExpenses(), " руб.");
            printTitle("c) сотрудники предприятия с минимальной ЗП");
            book.compareMoreLess("<");
            printTitle("d) сотрудники предприятия с максимальной ЗП");
            book.compareMoreLess(">");
           printTitle("e) среднее значение зарплат на предприятии");
            System.out.printf("%s%.2f%s\n", "Среднее значение зарплат сотрудников предприятия составляет: ",
                    book.calculateAmountExpenses() / book.countTheEmployees(), " руб.");
            printTitle("f) список ФИО всех сотрудников предприятия");
            book.displayListEmployees();
            printTitle("ПОВЫШЕННАЯ СЛОЖНОСТЬ");
            int procent = 10;
            int numberDepartament = 2;
            int procentDeportament = -10;
            float doorstep = 80000.23f;
            System.out.println("Ввели данные: \n1. procent = " + procent + " - значения для пункта 1.\n2. numberdepartament = " + numberDepartament +
                    " - значения для пункта 2.\n3. procentDeportament = " + procentDeportament + " -значения для пункта 2.е\n4. doorstep = "
                    + doorstep + " - значение для пункта 3.");
            System.out.println("\n 1. Проиндексировать зарплату, (вызвать изменение зп у всех сотрудников на величину \"" + procent + " %\"):");
            book.indexesWages(procent);
            printTitle("2. Получили в качестве параметра номер отдела " + numberDepartament);
            final int constantMinimumDepartment = 1;
            final int constantMaximumDepartament = 5;
            if (numberDepartament < constantMinimumDepartment || numberDepartament > constantMaximumDepartament) {
                String error = "Неверно введён отдел";
                throw new IllegalArgumentException(error);
            } else if (book.countTheEmployees(numberDepartament) == 0) {
                System.out.println("Отдел пуст, проведите работу по трудоустройству специалистов");
            } else {
                printTitle("a.Сотрудники отдела " + numberDepartament + " с минимальной зп");
                book.compareMoreLess(numberDepartament, "<");
                printTitle("b.Сотрудники отдела " + numberDepartament + " с максимальной зп");
                book.compareMoreLess(numberDepartament, ">");
                printTitle("c.Сумма затрат на зп по отделу " + numberDepartament);
                System.out.printf("%s%.2f%s\n", "Сумма затрат на зарплату сотрудникам составляет: ", book.calculateAmountExpenses(numberDepartament), " руб.");
                printTitle("d. Среднее значение зарплат в отделе " + numberDepartament);
                System.out.printf("%s%.2f%s\n", "Среднее значение зарплат сотрудников предприятия составляет: ",
                        book.calculateAmountExpenses(numberDepartament) / book.countTheEmployees(numberDepartament), " руб.");
                printTitle("e. Проиндексировали зарплату всех сотрудников отдела " + numberDepartament + " на \"" + procentDeportament + " %\"");
                book.indexesWages(procentDeportament, numberDepartament);
                printTitle("f. Напечатали всех сотрудников отдела № " + numberDepartament + " (все данные, кроме отдела)");
                book.outputTheTable(numberDepartament);
                printTitle("3. Получили в качестве параметра порог зарплаты в отделе " + doorstep);
                printTitle("a.1. Вывели на консоль всех сотрудников отдела \"" + numberDepartament + "\" с зп меньше \" + doorstep");
                book.displayTheSalaryBelow(doorstep, numberDepartament);
                printTitle("b.1. Вывели на консоль всех сотрудников отдела " + numberDepartament + " с зп больше (или равно) " + doorstep);
                book.displayTheSalaryAbove(doorstep, numberDepartament);
            }
            printTitle("3. Получили в качестве параметра порог зарплаты на предприятии " + doorstep);
            printTitle("a.2. Вывели на консоль всех сотрудников предприятия с зп меньше " + doorstep);
            book.displayTheSalaryBelow(doorstep);
            printTitle("b.2. Вывели на консоль всех сотрудников предприятия с зп больше (или равно)  " + doorstep);
            book.displayTheSalaryAbove(doorstep);
        }
        printTitle("ДЕМОНСТРАЦИЯ РАБОТЫ МЕТОДОВ ПОД НАЗВАНИЕМ ОЧЕНЬ СЛОЖНО");
        String surnameNamePatrnimic1 = "Бганцов Сергей Александрович";
        String surnameNamePatrnimic2 = "Иванов Иван Иванович";
        int deportament = 4;
        float salary1 = 70000f;
        float salary2 = 88000f;
        int idEmployee1 = 4;
        int idEmployee2 = 7;
        System.out.println("Ввели данные: \n1. surnameNamePatrnimic1 = " + surnameNamePatrnimic1 +
                " - значения для пункта a.\n2. surnameNamePatrnimic1 = "+surnameNamePatrnimic2+
                " - значение для пункта а.1\n3. salary1 = " + salary1 +" - значения для пункта a.\n4. salary2 = "+ salary2 +
                " - значение для пункта а.1\n5. idEmployee1 = " +idEmployee1 + " - значения для пункта b.\n6. idEmployee2 = "
                + idEmployee2 + " - значение для пункта 5.");
        printTitle("a. Добавить нового сотрудника в вакантную должность");
        System.out.println("Метод вернул - " + book.addNewEmployye(surnameNamePatrnimic1, salary1));
        printTitle("a.1 Добавить нового сотрудника в вакантную должность (с изменением номера отдела)");
        System.out.println("Метод вернул - " + book.addNewEmployye(surnameNamePatrnimic2, deportament, salary2));
        printTitle("b. Удалить сотрудника по указанному ID " + idEmployee1);
        if (book.deleteEmployye(idEmployee1)) {
            System.out.println("Сотрудник с ID= " + idEmployee1 + " Удален");
        } else {
            System.out.println("Должность с указанным ID вакантна ");
        }
        System.out.println("\nПроводим проверку удаления сотрудника по указанному ID");
        book.displayAnEmployeeId(idEmployee1);
        printTitle("5. Получили информацию о сотруднике по указанному  ID " + idEmployee2);
        book.displayAnEmployeeId(idEmployee2);
    }
}