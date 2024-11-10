public class EmployeeBook {
    final Employee[] employees = {
            new Employee("Рыжиков Сергей Викторович", 1, 74003f),
            new Employee("Кукушкина Надежда Михайловна", 2, 77777f),
            new Employee("Калмыков Вячеслав Васильевич", 3, 99343f),
            new Employee("Панферов Игорь викторович", 4, 99343f),
            new Employee("Баязитов Евгений Александрович", 1, 83023f),
            new Employee("Позднякова Галина Михайловна", 2, 77777f),
            new Employee("Синицын Алексей Иванович", 2, 68432f),
            new Employee("", 1, 0),
            new Employee("Колосов Александр Игоревич", 3, 85000f),
            new Employee("", 1, 0)
    };

    void outputTheTable() {
        System.out.printf("%5s%35s%10s%20s\n", "id", "Фамилия имя отчество", "Отдел", "Зарплата");
        for (Employee variable : employees) {
            if (variable.getFulname() != null && !variable.getFulname().isBlank()) {
                System.out.println(variable);
            }
        }
    }

    void outputTheTable(int numberDepartament) {
        System.out.printf("%5s%35s%20s\n", "id", "Фамилия имя отчество", "Зарплата");
        for (Employee variable : employees) {
            if (variable.getFulname() != null && !variable.getFulname().isBlank()) {
                if (variable.getDepartament() == numberDepartament) {
                    System.out.printf("%5d%35s%20.2f%s\n", variable.getId(), variable.getFulname(), variable.getSalary(), " руб.");
                }
            }
        }
    }

    float calculateAmountExpenses() {
        float amount = 0;
        for (Employee variable : employees) {
            if (variable.getFulname() != null && !variable.getFulname().isBlank()) {
                amount = amount + variable.getSalary();
            }
        }
        return amount;
    }

    float calculateAmountExpenses(int numberDepartament) {
        float amount = 0;
        for (Employee variable : employees) {
            if (variable.getFulname() != null && !variable.getFulname().isBlank()) {
                if (variable.getDepartament() == numberDepartament) {
                    amount = amount + variable.getSalary();
                }
            }
        }
        return amount;
    }

    int countTheEmployees() {
        byte amount = 0;
        for (Employee variable : employees) {
            if (variable.getFulname() != null && !variable.getFulname().isBlank()) {
                amount++;
            }
        }
        return amount;
    }

    int countTheEmployees(int numberDepartament) {
        int amount = 0;
        for (Employee variable : employees) {
            if (variable.getFulname() != null && !variable.getFulname().isBlank()) {
                if (variable.getDepartament() == numberDepartament) {
                    amount++;
                }
            }
        }
        return amount;
    }

    void compareMoreLess(String moreLess) {
        float minimum = employees[0].getSalary();
        float maximum = employees[0].getSalary();
        System.out.printf("%5s%35s%10s%20s\n", "id", "Фамилия имя отчество", "Отдел", "Зарплата");
        for (Employee variable : employees) {
            if (variable.getFulname() != null && !variable.getFulname().isBlank()) {
                if (minimum > variable.getSalary()) {
                    minimum = variable.getSalary();
                }
                if (maximum <= variable.getSalary()) {
                    maximum = variable.getSalary();
                }
            }
        }
        int counter = 0;
        float minimumOrMaximum = minimum;
        String outputString = "Минимальная";
        if (moreLess.contains(">")) {
            minimumOrMaximum = maximum;
            outputString = "Максимальная";
        }
        for (Employee variable : employees) {
            if (variable.getFulname() != null && !variable.getFulname().isBlank()) {
                if (minimumOrMaximum == variable.getSalary()) {
                    counter++;
                    System.out.println(variable);
                }
            }
        }
        System.out.printf("\n%s%s", outputString, " зарплата сотрудника предприятия составляет: ");
        System.out.printf("%.2f%s%d%s\n", minimumOrMaximum, " руб. и её получает ", counter, " человек(а)");
    }

    void compareMoreLess(int numberDepartament, String moreLess) {
        float minimum = employees[0].getSalary();
        float maximum = employees[0].getSalary();
        System.out.printf("%5s%35s%20s\n", "id", "Фамилия имя отчество", "Зарплата");
        for (Employee variable : employees) {
            if (variable.getFulname() != null && !variable.getFulname().isBlank()) {
                if (variable.getDepartament() == numberDepartament) {
                    if (minimum > variable.getSalary()) {
                        minimum = variable.getSalary();
                    }
                    if (maximum <= variable.getSalary()) {
                        maximum = variable.getSalary();
                    }
                }
            }
        }
        int counter = 0;
        float minimumOrMaximum = minimum;
        String outputString = "Минимальная";
        if (moreLess.contains(">")) {
            minimumOrMaximum = maximum;
            outputString = "Максимальная";
        }
        for (Employee variable : employees) {
            if (variable.getFulname() != null && !variable.getFulname().isBlank()) {
                if (variable.getDepartament() == numberDepartament) {
                    if (minimumOrMaximum == variable.getSalary()) {
                        counter++;
                        System.out.printf("%5s%35s%20s\n", variable.getId(), variable.getFulname(), variable.getSalary());
                    }
                }
            }
        }
        System.out.printf("\n%s%s", outputString, " зарплата сотрудника предприятия составляет: ");
        System.out.printf("%.2f%s%d%s\n", minimumOrMaximum, " руб. и её получает ", counter, " человек(а)");
    }

    void displayListEmployees() {
        System.out.printf("%35s\n", "Фамилия имя отчество");
        for (Employee variable : employees) {
            if (variable.getFulname() != null && !variable.getFulname().isBlank()) {
                System.out.printf("%35s\n", variable.getFulname());
            }
        }
    }

    void indexesWages(int procent) {
        System.out.printf("%5s%35s%10s%20s%35s\n", "id", "Фамилия имя отчество", "Отдел", "Зарплата", "Зарплата после индексации");
        for (Employee variable : employees) {
            if (variable.getFulname() != null && !variable.getFulname().isBlank()) {
                System.out.print(variable);
                variable.setSalary((variable.getSalary() + (variable.getSalary() * procent / 100)));
                System.out.printf("%20.2f%5s\n", variable.getSalary(), "руб");
            }
        }
    }

    void indexesWages(int procent, int numberDepartament) {
        System.out.printf("%5s%35s%10s%20s%35s\n", "id", "Фамилия имя отчество", "Отдел", "Зарплата", "Зарплата после индексации");
        for (Employee variable : employees) {
            if (variable.getFulname() != null && !variable.getFulname().isBlank()) {
                if (variable.getDepartament() == numberDepartament) {
                    System.out.print(variable);
                    variable.setSalary((variable.getSalary() + (variable.getSalary() * procent / 100)));
                    System.out.printf("%20.2f%5s\n", variable.getSalary(), "руб");
                }
            }
        }
    }

    void displayTheSalaryBelow(float doorstep) {
        System.out.printf("%5s%35s%10s%20s\n", "id", "Фамилия имя отчество", "Отдел", "Зарплата");
        byte number = 0;
        for (Employee variable : employees) {
            if (variable.getFulname() != null && !variable.getFulname().isBlank()) {
                if (doorstep > variable.getSalary()) {
                    System.out.println(variable);
                    number++;
                }
            }
        }
        if (number == 0) {
            System.out.println("Зарплат ниже указанного порога нет");
        }
    }

    void displayTheSalaryBelow(float doorstep, int numberDepartament) {
        System.out.printf("%5s%35s%20s\n", "id", "Фамилия имя отчество", "Зарплата");
        byte number = 0;
        for (Employee variable : employees) {
            if (variable.getFulname() != null && !variable.getFulname().isBlank()) {
                if (variable.getDepartament() == numberDepartament) {
                    if (doorstep > variable.getSalary()) {
                        System.out.printf("%5d%35s%20.2f%s\n", variable.getId(), variable.getFulname(), variable.getSalary(), " руб.");
                        number++;
                    }
                }
            }
        }
        if (number == 0) {
            System.out.println("Зарплат ниже указанного порога  в отделе нет");
        }
    }

    void displayTheSalaryAbove(float doorstep) {
        System.out.printf("%5s%35s%10s%20s\n", "id", "Фамилия имя отчество", "Отдел", "Зарплата");
        byte number = 0;
        for (Employee variable : employees) {
            if (variable.getFulname() != null && !variable.getFulname().isBlank()) {
                if (doorstep <= variable.getSalary()) {
                    System.out.println(variable);
                    number++;
                }
            }
        }
        if (number == 0) {
            System.out.println("Зарплат выше указанного порога нет");
        }
    }

    void displayTheSalaryAbove(float doorstep, int numberDepartament) {
        System.out.printf("%5s%35s%20s\n", "id", "Фамилия имя отчество", "Зарплата");
        byte number = 0;
        for (Employee variable : employees) {
            if (variable.getFulname() != null && !variable.getFulname().isBlank()) {
                if (variable.getDepartament() == numberDepartament) {
                    if (doorstep <= variable.getSalary()) {
                        System.out.printf("%5d%35s%20.2f%s\n", variable.getId(), variable.getFulname(), variable.getSalary(), " руб.");
                        number++;
                    }
                }
            }
        }
        if (number == 0) {
            System.out.println("Зарплат выше указанного порога в отделе нет");
        }
    }

    boolean addNewEmployye(String surnameNamePatrnimic, float salary) {
        int emptyCell = 0;
        int numberOfEmptyCells = 0;
        for (Employee variable : employees) {
            if (variable.getFulname() == null || variable.getFulname().isBlank()) {
                numberOfEmptyCells++;
            }
        }
        if (numberOfEmptyCells == 0) {
            System.out.println("Вакантных должностей нет, сотрудник не трудоустроен");
            return false;
        }
        for (int cell = 0; cell < employees.length; cell++) {
            if (employees[cell].getFulname() == null || employees[cell].getFulname().isBlank()) {
                employees[cell].setFullName(surnameNamePatrnimic);
                employees[cell].setSalary(salary);
                emptyCell = cell;
                break;
            }
        }
        System.out.println("Данные занесены");
        System.out.printf("%5s%35s%10s%20s\n", "id", "Фамилия имя отчество", "Отдел", "Зарплата");
        System.out.println(employees[emptyCell]);
        if (numberOfEmptyCells == 1) {
            System.out.println("На предприятии, больше вакантных должностей нет");
            return true;
        } else {
            System.out.printf("\n%5s%35s%10s%20s\n", "id", "Фамилия имя отчество", "Отдел", "Зарплата");
            for (Employee variable : employees) {
                if (variable.getFulname() == null || variable.getFulname().isBlank()) {
                    System.out.println(variable);
                }
            }
            System.out.println("На предприятии остались вакантные должности");
            return true;
        }
    }

    boolean addNewEmployye(String surnameNamePatrnimic, int departament, float salary) {
        int emptyCell = 0;
        int numberOfEmptyCells = 0;
        for (Employee variable : employees) {
            if (variable.getFulname() == null || variable.getFulname().isBlank()) {
                numberOfEmptyCells++;
            }
        }
        if (numberOfEmptyCells == 0) {
            System.out.println("Вакантных должностей нет, сотрудник не трудоустроен");
            return false;
        }
        for (int cell = 0; cell < employees.length; cell++) {
            if (employees[cell].getFulname() == null || employees[cell].getFulname().isBlank()) {
                employees[cell].setFullName(surnameNamePatrnimic);
                employees[cell].setDepartament(departament);
                employees[cell].setSalary(salary);
                emptyCell = cell;
                break;
            }
        }
        System.out.println("Данные занесены, изменена штатная структура предприятия (заменен № отдела)");
        System.out.printf("%5s%35s%10s%20s\n", "id", "Фамилия имя отчество", "Отдел", "Зарплата");
        System.out.println(employees[emptyCell]);
        if (numberOfEmptyCells == 1) {
            System.out.println("На предприятии, больше вакантных должностей нет");
            return true;
        } else {
            System.out.printf("\n%5s%35s%10s%20s\n", "id", "Фамилия имя отчество", "Отдел", "Зарплата");
            for (Employee variable : employees) {
                if (variable.getFulname() == null || variable.getFulname().isBlank()) {
                    System.out.println(variable);
                }
            }
            System.out.println("На предприятии остались вакантные должности");
            return true;
        }
    }

    boolean deleteEmployye(int id) {
        for (int cell = 0; cell < employees.length; cell++) {
            if (employees[cell].getFulname() != null && !employees[cell].getFulname().isBlank() && (employees[cell].getId()) == id) {
                System.out.printf("%5s%35s%10s%20s\n", "id", "Фамилия имя отчество", "Отдел", "Зарплата");
                System.out.println(employees[cell]);
                employees[cell].setFullName("");
                employees[cell].setSalary(0);
                return true;
            }
        }
        return false;
    }

    void displayAnEmployeeId(int id) {
        boolean truth = false;
        int cell;
        for (cell = 0; cell < employees.length; cell++) {
            if (employees[cell].getFulname() != null && !employees[cell].getFulname().isBlank() && (employees[cell].getId()) == id) {
                truth = true;
                break;
            }
        }
        if (truth) {
            System.out.println("Сотрудник с указанным ID");
            System.out.printf("%5s%35s%10s%20s\n", "id", "Фамилия имя отчество", "Отдел", "Зарплата");
            System.out.println(employees[cell]);
        } else {
            System.out.println("Должность с указанным ID=" + id + " вакантна");
        }
    }
}
