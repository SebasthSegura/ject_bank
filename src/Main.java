import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.companysebasth.ject_bank.models.*;

public class Main {
    private static final List<Employed> registeredEmployed = new ArrayList<>();
    private static final List<Person> registeredUser = new ArrayList<>();
    private static Scanner in = new Scanner(System.in);

    // Main method to run the application
    public static void main(String[] args) {

        int responseInt;
        String responseText;

        System.out.println("************************************************");
        System.out.println("*Bienvenido a la app bancaria estimado cliente!*");
        System.out.println("************************************************");

        System.out.println("""
                Bienvenido estimado Usuario
                """);

        do {
            System.out.println("""
                    Opciones:
                    1. Registrarse
                    2. Iniciar sesión
                    3. Iniciar sesión como empleado
                    4. Registrar empleado
                    5. Salir
                    """);
            responseInt = in.nextInt();
            in.nextLine();

            switch (responseInt) {
                case 1:
                    registerPerson();
                    break;
                case 2:
                    loginPerson();
                    break;
                case 3:
                    loginEmployed();
                    break;
                case 4:
                    registerEmployed();
                    break;
                case 5:
                    System.out.println("Ha seleccionado la opción de salir.");
                    System.out.println("¡Gracias por usar nuestra aplicación bancaria! Hasta luego.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente nuevamente.");
                    break;

            }
        }while (responseInt != 5);
    }

    //create a method to register a person
    public static void registerPerson() {
        System.out.println("*****************************************************");
        System.out.println("Ha seleccionado la opción de registrarse.");

        System.out.println("Por favor, ingrese su nombre:");
        String name = in.nextLine();

        System.out.println("Por favor, ingrese su apellido:");
        String lastName = in.nextLine();

        System.out.println("Por favor, ingrese su Cc:");
        Long idUser = in.nextLong();
        in.nextLine();

        System.out.println("Por favor, ingrese su correo electrónico:");
        String email = in.nextLine();

        System.out.println("Por favor, ingrese su número de teléfono:");
        Long phoneNumber = in.nextLong();
        in.nextLine();

        // Create a Person object with the provided details
        Person person = new Person(name, lastName, idUser, email, phoneNumber);
        registeredUser.add(person);

        System.out.println("¡Gracias por registrarte, " + person.getName() + " " + person.getLastName() + "!");
        System.out.println("hemos creado tu cuenta con éxito.");
        int opcion;
        do {
            System.out.println("Por favor, ingrese el tipo de cuenta que desea crear:");
            System.out.println("Opciones:");
            System.out.println("1. Cuenta de Ahorros");
            System.out.println("2. Cuenta de Inversión");
            System.out.println("3. Salir");
            opcion = in.nextInt();
            in.nextLine();

            if (opcion == 1){
                System.out.println("porfavor ingrese el monto inicial que desea depositar en su cuenta de ahorros:");
                double initialDeposit = in.nextDouble();
                in.nextLine();

                int accountNumber = (int) (Math.random() * 900000) + 100000;
                String accountType = "Cuenta de Ahorros";
                double interestRate = 0.02;

                if (initialDeposit < 1000){
                    System.out.println("El monto mínimo para abrir una cuenta de ahorros es de $1,000.");
                } else {
                    SavingAccount savingAccount = new SavingAccount(interestRate, initialDeposit, accountType);
                    savingAccount.setAccountNumber(String.valueOf(accountNumber));
                    savingAccount.setBalance(initialDeposit);
                    person.addAccount(savingAccount);
                    System.out.println("¡Cuenta de Ahorros creada con éxito!");
                    System.out.println("Número de cuenta: " + savingAccount.getAccountNumber());
                    System.out.println("Tipo de cuenta: " + savingAccount.getAccountType());
                    System.out.println("Monto inicial: " + String.format("%.2f", savingAccount.getBalance()));
                }

            } else if (opcion == 2) {
                System.out.println("Por favor, ingrese el monto inicial que desea invertir: ");
                double investmentAmount = in.nextDouble();
                in.nextLine();

                if (investmentAmount < 25000) {
                    System.out.println("El monto mínimo para abrir una cuenta de inversión es de $25,000.");
                } else {
                    int accountNumber = (int) (Math.random() * 900000) + 100000;
                    System.out.println("Tipos de inversion: ");
                    System.out.println("Opciones: ");
                    System.out.println("1. Cuenta de Inversión a Corto Plazo");
                    System.out.println("2. Cuenta de Inversión a Largo Plazo");
                    int tipoInversion = in.nextInt();
                    in.nextLine();

                    String investmentTypeDescription = "";
                    int term = 0;
                    String riskLevel = "Medio";

                    switch (tipoInversion){
                        case 1:
                            investmentTypeDescription = "Cuenta de Inversión a Corto Plazo";
                            System.out.println("Por favor, ingrese el plazo de la inversión a corto plazo (en meses):");
                            term = in.nextInt();
                            in.nextLine();
                            break;
                        case 2:
                            investmentTypeDescription = "Cuenta de Inversión a Largo Plazo";
                            System.out.println("Por favor, ingrese el plazo de la inversión a largo plazo (en años):");
                            term = in.nextInt();
                            in.nextLine();
                            break;
                        default:
                            System.out.println("Tipo de inversión no válido.");
                            continue;
                    }

                    // Create investment account
                    InvestmentAccount investmentAccount = new InvestmentAccount(1.00, investmentAmount, investmentTypeDescription);
                    investmentAccount.setAccountNumber(String.valueOf(accountNumber));
                    investmentAccount.setBalance(investmentAmount);

                    person.addAccount(investmentAccount);
                    System.out.println("¡Cuenta de Inversión creada con éxito!");
                    System.out.println("Número de cuenta: " + investmentAccount.getAccountNumber());
                    System.out.println("Tipo de cuenta: " + investmentAccount.getInvestmentType());
                    System.out.println("Monto de inversión: " + String.format("%.2f", investmentAccount.getInvestmentAmount()));
                    if (term > 0) {
                        System.out.println("Plazo de inversión: " + term + (tipoInversion == 1 ? " meses" : " años"));
                    }

                }
            } else if (opcion != 3) {
                System.out.println("Opción no válida. Por favor, intente nuevamente.");
            }
        } while (opcion != 3);
    }

    //create a method to login as a person
    public static void loginPerson(){
        System.out.println("*****************************************************");
        System.out.println("Ha seleccionado la opción de iniciar sesión.");
        System.out.println("Por favor, ingrese su correo electrónico:");

        String loginEmail = in.nextLine();

        // validate if the email exists in the registered users
        Person foundPerson = null;
        for (Person p : registeredUser) {
            if (p.getEmail().equals(loginEmail)) {
                foundPerson = p;
                break;
            }
        }

        if (foundPerson != null) {
            System.out.println("¡Inicio de sesión exitoso! Bienvenido de nuevo, " + foundPerson.getName() + ".");
            personMenu(foundPerson);
        } else {
            System.out.println("Credenciales incorrectas. Usuario no encontrado. Por favor, verifique su correo electrónico.");
        }
    }

    //create a method to login as an employee
    public static void loginEmployed(){
        System.out.println("*****************************************************");
        System.out.println("Ha seleccionado la opción de iniciar sesión como empleado.");
        System.out.println("Por favor, ingrese su ID de empleado:");
        Long employeeId = in.nextLong();
        in.nextLine();

        Employed foundEmployed = null;
        for (Employed e : registeredEmployed) {
            if (e.getIdEmployed().equals(employeeId)) {
                foundEmployed = e;
                break;
            }
        }

        if (foundEmployed != null) {
            System.out.println("¡Inicio de sesión como empleado exitoso! Bienvenido, " + foundEmployed.getName() + " (" + foundEmployed.getPosition() + ").");
            employedMenu(foundEmployed);
        } else {
            System.out.println("Credenciales incorrectas. Empleado no encontrado. Por favor, verifique su ID.");
        }
    }

    //create a method to register an employee
    public static void registerEmployed(){
        System.out.println("*****************************************************");
        System.out.println("Ha seleccionado la opción de registrar un empleado.");

        System.out.println("Por favor, ingrese el nombre del empleado:");
        String employeeName = in.nextLine();

        System.out.println("Por favor, ingrese el apellido del empleado:");
        String employeeLastName = in.nextLine();

        System.out.println("Por favor, ingrese el C.c del empleado:");
        Long newEmployeeId = in.nextLong();
        in.nextLine();

        System.out.println("Por favor, ingrese el correo electrónico del empleado:");
        String employeeEmail = in.nextLine();

        System.out.println("Por favor, ingrese el número de teléfono del empleado:");
        Long employeePhoneNumber = in.nextLong();
        in.nextLine();

        System.out.println("""
                        Elija el cargo del empleado:
                        1. Supervisor
                        2. Cajero
                        3. Recepcionista
                        """);
        int positionChoice = in.nextInt();
        in.nextLine();

        Employed newEmployed = null;

        System.out.println("Por favor, ingrese la fecha de contratación del empleado (formato: YYYY-MM-DD):");
        String hireDate = in.nextLine();

        double baseSalary = 0.0;

        switch (positionChoice){
            case 1:
                baseSalary = 5000.00;
                System.out.println("Por favor, ingrese el departamento del supervisor:");
                String department = in.nextLine();

                System.out.println("Por favor, ingrese la ubicación de la oficina del supervisor:");
                String officeLocation = in.nextLine();

                newEmployed = new Supervisor(employeeName, employeeLastName, newEmployeeId, employeeEmail, employeePhoneNumber, "Supervisor", hireDate, baseSalary, department, officeLocation);
                break;
            case 2:
                baseSalary = 3000.00;
                System.out.println("Por favor, ingrese el turno del cajero (Mañana/Tarde/Noche): ");
                String cashierShift = in.nextLine();

                newEmployed = new Cashier(employeeName, employeeLastName, newEmployeeId, employeeEmail, employeePhoneNumber, "Cajero", hireDate, baseSalary, "Sucursal Principal", cashierShift);
                break;

            case 3:
                baseSalary = 2500.00;
                System.out.println("Por favor, ingrese el turno del recepcionista (Mañana/Tarde/Noche): ");
                String shift = in.nextLine();

                System.out.println("Por favor, ingrese la sucursal asignada al recepcionista: ");
                String assignedBranch = in.nextLine();

                newEmployed = new Receptionist(employeeName, employeeLastName, newEmployeeId, employeeEmail, employeePhoneNumber, "Recepcionista", hireDate, baseSalary, assignedBranch, shift);
                break;

            default:
                System.out.println("Opción no válida. Por favor, intente nuevamente.");
                return;
        }

        registeredEmployed.add(newEmployed); // Esto ya estaba bien
        System.out.println("¡Empleado registrado con éxito!");
        System.out.println("Nombre: " + newEmployed.getName());
        System.out.println("Apellido: " + newEmployed.getLastName());
        System.out.println("ID de empleado: " + newEmployed.getIdEmployed());
        System.out.println("Correo electrónico: " + newEmployed.getEmail());
        System.out.println("Número de teléfono: " + newEmployed.getPhoneNumber());
        System.out.println("Cargo: " + newEmployed.getPosition());
        System.out.println("Fecha de contratación: " + newEmployed.getHireDate());
        System.out.println("Salario: " + String.format("%.2f", newEmployed.getSalary()));
        System.out.println("Dias de Vacaciones al año: " + newEmployed.calculateVacationDays());
    }

    //create a method to display the employed menu
    private static void employedMenu(Employed employed){
        int option;

        do {
            System.out.println("*****************************************************");
            System.out.println("\n--- Menú de Empleado para " + employed.getName() + " (" + employed.getPosition() + ") ---");
            System.out.println("""
                Opciones:
                1. Ver información del empleado
                2. Actualizar información de contacto
                3. Calular días de vacaciones
                4. Ver lista de clientes registrados
                5. Cerrar sesión
                    """);
            System.out.println("Por favor, ingrese el número de la opción que desea seleccionar:");
            option = in.nextInt();
            in.nextLine();

            switch (option){
                case 1:
                    displayEmployeeInfo(employed);
                    break;
                case 2:
                    updateContactInfo(employed);
                    break;

                case 3:
                    System.out.println("Tus días de vacaciones disponibles son: " + employed.calculateVacationDays() + " días.");
                    break;

                case 4:
                    displayRegisteredUsers();
                    break;

                case 5:
                    System.out.println("Cerrando sesión...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente nuevamente.");
            }
        } while (option != 5);
    }

    //create a method to display employee information
    private static void displayEmployeeInfo(Employed employed){
        System.out.println("*****************************************************");
        System.out.println("\n--- Información del Empleado ---");
        System.out.println("Nombre: " + employed.getName());
        System.out.println("Apellido: " + employed.getLastName());
        System.out.println("ID de empleado: " + employed.getIdEmployed());
        System.out.println("Correo electrónico: " + employed.getEmail());
        System.out.println("Número de teléfono: " + employed.getPhoneNumber());
        System.out.println("Cargo: " + employed.getPosition());
        System.out.println("Fecha de contratación: " + employed.getHireDate());
        System.out.println("Salario: " + String.format("%.2f", employed.getSalary()));
        System.out.println("Días de vacaciones disponibles: " + employed.calculateVacationDays() + " días");

        // use instanceof to check the type of employed
        if (employed instanceof Supervisor){
            Supervisor supervisor = (Supervisor) employed;
            System.out.println("Departamento: " + supervisor.getDepartment());
            System.out.println("Ubicación de la oficina: " + supervisor.getOfficeLocation());
        } else if (employed instanceof Cashier) {
            Cashier cashier = (Cashier) employed;
            System.out.println("Sucursal asignada: " + cashier.getAssignedBranch());
            System.out.println("Turno: " + cashier.getShift());
        } else if (employed instanceof Receptionist) {
            Receptionist receptionist = (Receptionist) employed;
            System.out.println("Sucursal asignada: " + receptionist.getAssignedBranch());
            System.out.println("Turno: " + receptionist.getShift());
        }
    }

    //create a method to update contact information
    private static void updateContactInfo(Employed employed) {
        System.out.println("*****************************************************");
        System.out.println("\n--- Actualizar Información de Contacto ---");
        System.out.println("Correo electrónico actual: " + employed.getEmail());
        System.out.println("Por favor, ingrese el nuevo correo electrónico:");
        String newEmail = in.nextLine();


        System.out.println("Número de teléfono actual: " + employed.getPhoneNumber());
        System.out.println("Por favor, ingrese el nuevo número de teléfono:");
        Long newPhoneNumber = in.nextLong();
        in.nextLine();

        employed.updateContacInformation(newEmail, newPhoneNumber);
        System.out.println("Información de contacto actualizada con éxito.");

        if (employed instanceof Cashier) {
            System.out.println("¿Desea actualizar el turno del cajero? (s/n)");
            String updateShiftOption = in.nextLine().toLowerCase();
            if (updateShiftOption.equals("s")) {
                System.out.println("Por favor, ingrese el nuevo turno:");
                String newShift = in.nextLine();
                ((Cashier) employed).setShift(newShift);
                System.out.println("Turno de cajero actualizado con éxito.");
            } else if (!updateShiftOption.equals("n")) {
                System.out.println("Opción no válida. No se ha actualizado el turno del cajero.");
            }
        } else if (employed instanceof Receptionist) {
            System.out.println("¿Desea actualizar el turno del recepcionista? (s/n)");
            String updateShiftOption = in.nextLine().toLowerCase();
            if (updateShiftOption.equals("s")) {
                System.out.println("Por favor, ingrese el nuevo turno:");
                String newShift = in.nextLine();
                ((Receptionist) employed).setShift(newShift);
                System.out.println("Turno de recepcionista actualizado con éxito.");

                System.out.println("¿Desea actualizar la sucursal asignada? (s/n)");
                String updateBranchOption = in.nextLine().toLowerCase();
                if (updateBranchOption.equals("s")) {
                    System.out.println("Por favor, ingrese la nueva sucursal asignada:");
                    String newBranch = in.nextLine();
                    ((Receptionist) employed).setAssignedBranch(newBranch);
                    System.out.println("Sucursal asignada actualizada con éxito.");
                } else if (!updateBranchOption.equals("n")) {
                    System.out.println("Opción no válida. No se ha actualizado la sucursal asignada.");
                }
            } else if (!updateShiftOption.equals("n")) {
                System.out.println("Opción no válida. No se ha actualizado el turno del recepcionista.");
            }
        }
        System.out.println("Información de contacto (correo y teléfono) actualizada con éxito.");
    }


    //create a method to display registered users
    private static void displayRegisteredUsers(){
        if (registeredUser.isEmpty()){
            System.out.println("No hay usuarios registrados en el sistema.");
            return;
        }
        System.out.println("*****************************************************");
        System.out.println("\n--- Lista de Usuarios Registrados ---");
        for (Person p : registeredUser) {
            System.out.println("Nombre: " + p.getName());
            System.out.println("Apellido: " + p.getLastName());
            System.out.println("C.C: " + p.getIdUser());
            System.out.println("Correo electrónico: " + p.getEmail());
            System.out.println("Número de teléfono: " + p.getPhoneNumber());
            System.out.println("Número de cuentas: " + p.getAccounts().size());
            System.out.println("-----------------------------------");
            if (!p.getAccounts().isEmpty()){
                System.out.println("Cuentas asociadas: ");
                for (Account acc : p.getAccounts()){
                    System.out.println("  - " + acc.getAccountNumber() + " (" + acc.getAccountType() + ") - Saldo: " + String.format("%.2f", acc.getBalance()));
                }
            } else {
                System.out.println("No hay cuentas asociadas a este usuario.");
            }
            System.out.println("*****************************************************");
        }
    }

    //create a method to display the person menu
    private static void personMenu(Person user){
        int option;

        do {
            System.out.println("*****************************************************");
            System.out.println("\n--- Menú de Usuario para " + user.getName() + " ---");
            System.out.println("""
                Opciones:
                1. Ver información del usuario
                2. Actualizar información de contacto
                3. Ver cuentas asociadas
                4. Realizar transacciones
                5. Cerrar sesión
                    """);
            System.out.println("Por favor, ingrese el número de la opción que desea seleccionar:");
            option = in.nextInt();
            in.nextLine();

            switch (option) {
                case 1:
                    displayUserInfo(user);
                    break;
                case 2:
                    updateUserContactInfo(user);
                    break;
                case 3:
                    displayUserAccounts(user);
                    break;
                case 4:
                    performTransactions(user);
                    break;
                case 5:
                    System.out.println("Cerrando sesión...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente nuevamente.");
            }

        }while (option != 5);
    }


    //create a method to display user information to user
    private static void displayUserInfo(Person user) {
        System.out.println("*****************************************************");
        System.out.println("\n--- Información del Usuario ---");
        System.out.println("Nombre: " + user.getName());
        System.out.println("Apellido: " + user.getLastName());
        System.out.println("C.C: " + user.getIdUser());
        System.out.println("Correo electrónico: " + user.getEmail());
        System.out.println("Número de teléfono: " + user.getPhoneNumber());
        System.out.println("Número de cuentas: " + user.getAccounts().size());
        System.out.println("*****************************************************");

        if (!user.getAccounts().isEmpty()) {
            System.out.println("Cuentas asociadas:");
            for (Account acc : user.getAccounts()) {
                System.out.println("  - " + acc.getAccountNumber() + " (" + acc.getAccountType() + ") - Saldo: " + String.format("%.2f", acc.getBalance()));
            }
        } else {
            System.out.println("No hay cuentas asociadas a este usuario.");
        }
    }

    //create a method to update user contact information
    private static void updateUserContactInfo(Person user){
        System.out.println("*****************************************************");
        System.out.println("\n--- Actualizar Informacion de contacto ---");
        System.out.println("Correo electrónico actual: " + user.getEmail());
        System.out.println("Por favor, ingrese el nuevo correo electrónico:");
        String newEmail = in.nextLine();


        System.out.println("Número de teléfono actual: " + user.getPhoneNumber());
        System.out.println("Por favor, ingrese el nuevo número de teléfono:");
        Long newPhoneNumber = in.nextLong();
        in.nextLine();

        user.updateContacInformation(newEmail, newPhoneNumber);
        System.out.println("Información de contacto actualizada con éxito.");
        System.out.println("Nuevo correo electrónico: " + user.getEmail());
        System.out.println("Nuevo número de teléfono: " + user.getPhoneNumber());

    }

    //create a method to display user accounts
    private static void displayUserAccounts(Person user){
        System.out.println("*****************************************************");
        System.out.println("\n--- Cuentas Asociadas a " + user.getName() + " ---");

        if (user.getAccounts().isEmpty()) {
            System.out.println("No hay cuentas asociadas a este usuario.");
        } else {
            for (Account acc : user.getAccounts()) {
                System.out.println("  - " + acc.getAccountNumber() + " (" + acc.getAccountType() + ") - Saldo: " + String.format("%.2f", acc.getBalance()));
            }
        }
    }

    //create a method to perform transactions
    private static void performTransactions(Person user) {
        System.out.println("*****************************************************");
        System.out.println("\n--- Realizar Transacciones ---");

        if (user.getAccounts().isEmpty()) {
            System.out.println("No tienes cuentas asociadas. No puedes realizar transacciones.");
            return;
        }

        displayUserAccounts(user);
        System.out.println("Por favor, ingrese el número de cuenta sobre la que desea operar:");
        String accountNumber = in.nextLine();

        Account account = null;
        for (Account acc : user.getAccounts()) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                account = acc;
                break;
            }
        }

        if (account == null) {
            System.out.println("Cuenta no encontrada o no asociada a tu usuario. Por favor, intente nuevamente.");
            return;
        }

        int transactionOption;
        do {
            System.out.println("\nCuenta seleccionada: " + account.getAccountNumber() + " (Saldo actual: " + String.format("%.2f", account.getBalance()) + ")");
            System.out.println("""
                    Opciones de transacción:
                    1. Depositar
                    2. Retirar
                    3. Salir al menú principal de transacciones
                    """);
            transactionOption = in.nextInt();
            in.nextLine();

            switch (transactionOption) {
                case 1:
                    System.out.println("Ingrese el monto a depositar:");
                    double depositAmount = in.nextDouble();
                    in.nextLine();
                    account.depositAccount(depositAmount);
                    System.out.println("Depósito realizado. Nuevo saldo: " + String.format("%.2f", account.getBalance()));
                    break;
                case 2:
                    System.out.println("Ingrese el monto a retirar:");
                    double withdrawAmount = in.nextDouble();
                    in.nextLine();
                    account.withdrawAccount(withdrawAmount);
                    System.out.println("Retiro intentado. Nuevo saldo: " + String.format("%.2f", account.getBalance()));
                    break;
                case 3:
                    System.out.println("Saliendo del menú de transacciones de cuenta.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente nuevamente.");
            }
        } while (transactionOption != 3);
    }
}
