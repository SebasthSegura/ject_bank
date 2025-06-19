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
        Scanner in = new Scanner(System.in);


        System.out.println("************************************************");
        System.out.println("*Bienvenido a la app bancaria estimado cliente!*");
        System.out.println("************************************************");

        System.out.println("""
                Bienvenido estimado Usuario
                """);
        System.out.println("");

        do {
            System.out.println("""
                    Opciones: 
                    1. Registrarse
                    2. Iniciar sesión
                    3. Iniciar sesión como empleado
                    4. registrar empleado
                    5. Salir
                    """);
            responseInt = in.nextInt();
            System.out.println("");

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
        Scanner in = new Scanner(System.in);
        System.out.println("*****************************************************");
        // Option to register
        System.out.println("Ha seleccionado la opción de registrarse.");
        in.nextLine();
        System.out.println("Por favor, ingrese su nombre:");
        String name = in.nextLine();
        in.nextLine();

        System.out.println("Por favor, ingrese su apellido:");
        String lastName = in.nextLine();

        System.out.println("Por favor, ingrese su Cc:");
        Long idUser = in.nextLong();

        System.out.println("Por favor, ingrese su correo electrónico:");
        in.nextLine(); // Consume the newline character
        String email = in.nextLine();

        System.out.println("Por favor, ingrese su número de teléfono:");
        Long phoneNumber = in.nextLong();

        // Create a Person object with the provided details
        Person person = new Person(name, lastName, idUser, email, phoneNumber);
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

            if (opcion == 1){
                System.out.println("porfavor ingrese el monto inicial que desea depositar en su cuenta de ahorros:");
                double initialDeposit = in.nextDouble();

                int accountNumber = (int) (Math.random() * 1000000); // Generar número de cuenta aleatorio

                String accountType = "Cuenta de Ahorros";
                double interestRate = 0.02;

                if (initialDeposit < 1000){
                    System.out.println("El monto mínimo para abrir una cuenta de ahorros es de 500.");
                } else if (initialDeposit >= 1000) {
                    // Crear la cuenta de ahorros
                    SavingAccount savingAccount = new SavingAccount(interestRate, initialDeposit, accountType);
                    savingAccount.setAccountNumber(String.valueOf(accountNumber));
                    person.addAccount(savingAccount);
                    System.out.println("¡Cuenta de Ahorros creada con éxito!");
                    System.out.println("Número de cuenta: " + savingAccount.getAccountNumber());
                    System.out.println("Tipo de cuenta: " + savingAccount.getAccountType());
                    System.out.println("Monto inicial: " + savingAccount.getInitialDeposit());
                }else {
                    System.out.println("Monto de depósito inválido. Por favor, intente nuevamente.");
                }

            } else if (opcion == 2) {
                System.out.println("Por favor, ingrese el monto inicial que desea invertir: ");
                double investmentAmount = in.nextDouble();
                if (investmentAmount < 25000) {
                    System.out.println("El monto mínimo para abrir una cuenta de inversión es de $25,000.");

                } else if (investmentAmount >= 25000) {
                    int accountNumber = (int) (Math.random() * 1000000);
                    System.out.println("Tipos de inversion: ");
                    System.out.println("Opciones: ");
                    System.out.println("1. Cuenta de Inversión a Corto Plazo");
                    System.out.println("2. Cuenta de Inversión a Largo Plazo");
                    int tipoInversion = in.nextInt();
                    switch (tipoInversion){
                        case 1:
                            System.out.println("Por favor, ingrese el plazo de la inversión a corto plazo (en meses):");
                            int shortTermMonths = in.nextInt();
                            System.out.println("Cuenta de Inversión a Corto Plazo creada con éxito.");
                            System.out.println("Número de cuenta: " + accountNumber);
                            System.out.println("Monto de inversión: " + investmentAmount);
                            System.out.println("Plazo de inversión: " + shortTermMonths + " meses");
                            break;
                        case 2:
                            System.out.println("Por favor, ingrese el plazo de la inversión a largo plazo (en años):");
                            int longTermYears = in.nextInt();
                            System.out.println("Cuenta de Inversión a Largo Plazo creada con éxito.");
                            System.out.println("Número de cuenta: " + accountNumber);
                            System.out.println("Monto de inversión: " + investmentAmount);
                            System.out.println("Plazo de inversión: " + longTermYears + " años");
                            break;
                        default:
                            System.out.println("Tipo de inversión no válido.");
                    }

                    String accountType = "Cuenta de Inversión";
                    double interestRate = 1.00; // tasa de interés anual
                    InvestmentAccount investmentAccount = new InvestmentAccount(interestRate, investmentAmount, accountType);
                    investmentAccount.setAccountNumber(String.valueOf(accountNumber));
                    person.addAccount(investmentAccount);
                    System.out.println("¡Cuenta de Inversión creada con éxito!");
                    System.out.println("Número de cuenta: " + investmentAccount.getAccountNumber());
                    System.out.println("Tipo de cuenta: " + investmentAccount.getInvestmentType());
                    System.out.println("Monto de inversión: " + investmentAccount.getInvestmentAmount());

                } else if (opcion != 3) {
                    System.out.println("Opción no válida. Por favor, intente nuevamente.");
                }
            }
        } while (opcion != 3);
    }

    //create a method to login as a person
    public static void loginPerson(){
        Scanner in = new Scanner(System.in);
        System.out.println("*****************************************************");
        // Option to login
        System.out.println("Ha seleccionado la opción de iniciar sesión.");
        System.out.println("Por favor, ingrese su correo electrónico:");
        in.nextLine(); // Consume the newline character
        String loginEmail = in.nextLine();

        System.out.println("Por favor, ingrese su contraseña:");
        String password = in.nextLine();

        // Aquí podrías agregar lógica para verificar las credenciales del usuario
        System.out.println("¡Inicio de sesión exitoso! Bienvenido de nuevo.");
    }

    //create a method to login as an employee
    public static void loginEmployed(){
        Scanner in = new Scanner(System.in);
        System.out.println("*****************************************************");
        // Option to login as an employee
        System.out.println("Ha seleccionado la opción de iniciar sesión como empleado.");
        System.out.println("Por favor, ingrese su ID de empleado:");
        Long employeeId = in.nextLong();

        System.out.println("Por favor, ingrese su contraseña:");
        in.nextLine(); // Consume the newline character
        String employeePassword = in.nextLine();

        // Aquí podrías agregar lógica para verificar las credenciales del empleado
        System.out.println("¡Inicio de sesión como empleado exitoso! Bienvenido.");
    }

    //create a method to register an employee
    public static void registerEmployed(){
        Scanner in = new Scanner(System.in);
        System.out.println("*****************************************************");
        // Options to register an employee
        System.out.println("Ha seleccionado la opción de registrar un empleado.");
        in.nextLine();

        System.out.println("Por favor, ingrese el nombre del empleado:");
        String employeeName = in.nextLine();
        in.nextLine();

        System.out.println("Por favor, ingrese el apellido del empleado:");
        String employeeLastName = in.nextLine();

        System.out.println("Por favor, ingrese el C.c del empleado:");
        Long newEmployeeId = in.nextLong();

        System.out.println("Por favor, ingrese el correo electrónico del empleado:");
        in.nextLine(); // Consume the newline character
        String employeeEmail = in.nextLine();

        System.out.println("Por favor, ingrese el número de teléfono del empleado:");
        Long employeePhoneNumber = in.nextLong();

        System.out.println("""
                        Elija el cargo del empleado:
                        1. Supervisor
                        2. Cajero
                        3. Recepcionista
                        """);
        int positionChoice = in.nextInt();
        in.nextLine();

        Employed newEmployed = null;

        switch (positionChoice){
            case 1:
                System.out.println("Por favor, ingrese el departamento del supervisor:");
                String department = in.nextLine();

                System.out.println("Por favor, ingrese la ubicación de la oficina del supervisor:");
                String officeLocation = in.nextLine();

                newEmployed = new Supervisor(employeeName, employeeLastName, newEmployeeId, employeeEmail, employeePhoneNumber, "Supervisor", "2023-10-01", 5000.00, department, officeLocation);
                break;
            case 2:
                System.out.println("Por favor, ingrese el turno del cajero: ");
                String cashierShift = in.nextLine();

                newEmployed = new Cashier(employeeName, employeeLastName, newEmployeeId, employeeEmail, employeePhoneNumber, "Cajero", "2023-10-01", 3000.00, "Sucursal Principal", cashierShift);
                break;

            case 3:
                System.out.println("Por favor, ingrese el turno del recepcionista: ");
                String shift = in.nextLine();

                System.out.println("Por favor, ingrese la sucursal asignada al recepcionista: ");
                String assignedBranch = in.nextLine();

                newEmployed = new Receptionist(employeeName, employeeLastName, newEmployeeId, employeeEmail, employeePhoneNumber, "Recepcionista", "2023-10-01", 2500.00, assignedBranch, shift);
                break;

            default:
                System.out.println("Opción no válida. Por favor, intente nuevamente.");
                return;
        }

        registeredEmployed.add(newEmployed);
        System.out.println("¡Empleado registrado con éxito!");
        System.out.println("Nombre: " + newEmployed.getName());
        System.out.println("Apellido: " + newEmployed.getLastName());
        System.out.println("ID de empleado: " + newEmployed.getIdEmployed());
        System.out.println("Correo electrónico: " + newEmployed.getEmail());
        System.out.println("Número de teléfono: " + newEmployed.getPhoneNumber());
        System.out.println("Cargo: " + newEmployed.getPosition());
        System.out.println("Fecha de contratación: " + newEmployed.getHireDate());
        System.out.println("Salario: " + newEmployed.getSalary());
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
        Scanner in = new Scanner(System.in);
        System.out.println("*****************************************************");
        System.out.println("\n--- Actualizar Información de Contacto ---");
        System.out.println("Por favor, ingrese el nuevo correo electrónico:");
        String newEmail = in.nextLine();
        in.nextLine();

        System.out.println("Por favor, ingrese el nuevo número de teléfono:");
        Long newPhoneNumber = in.nextLong();

        employed.updateContacInformation(newEmail, newPhoneNumber);
        System.out.println("Información de contacto actualizada con éxito.");

        if (employed instanceof Cashier) {
            System.out.println("Desdea actualizar su turno? (s/n)");
            String updateShift = in.nextLine().toLowerCase();
            if (updateShift == "n") {
                System.out.println("No se ha actualizado el turno.");
            } else if (updateShift == "s") {
                System.out.println("Por favor, ingrese el nuevo turno:");
                String newShift = in.nextLine();
                ((Cashier) employed).setShift(newShift);
                System.out.println("Turno actualizado con éxito.");
            } else {
                System.out.println("Opción no válida. No se ha actualizado el turno.");
                employed.updateContacInformation(newEmail, newPhoneNumber);
            }
        }else {
                employed.updateContacInformation(newEmail, newPhoneNumber);
            }
        System.out.println("Información de contacto actualizada con éxito.");
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
                System.out.println("cuentas asociadas: ");
                for (Account acc : p.getAccounts()){
                    System.out.println("  - " + acc.getAccountNumber() + " (" + acc.getAccountType() + ") - Saldo:" + String.format("%.2f", acc.getBalance()));
                }
            } else {
                System.out.println("No hay cuentas asociadas a este usuario.");
            }
            System.out.println("*****************************************************");
        }
    }
}
