import java.util.Scanner;
import com.companysebasth.ject_bank.models.*;

public class Main {
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

        switch (responseInt){
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
        }
        in.close();
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
        if (positionChoice == 1) {

            System.out.println("Nombre del empleado: " + employeeName);
            in.nextLine();

            System.out.println("Apellido del empleado: " + employeeLastName);
            in.nextLine();

            System.out.println("C.C del empleado: " + newEmployeeId);
            in.nextLine();

            System.out.println("Correo electrónico del empleado:" + employeeEmail);
            in.nextLine(); // Consume the newline character

            System.out.println("Número de teléfono del empleado:" + employeePhoneNumber);
            in.nextLine();

            System.out.println("por favor, ingrese la fecha de contratación del empleado (formato: dd/mm/yyyy):");
            String hireDate = in.nextLine();
            in.nextLine(); // Consume the newline character

            System.out.println("por favor, ingrese el salario del empleado:");
            double salary = in.nextDouble();

            System.out.println("por favor, ingrese el departamento del empleado:");
            in.nextLine(); // Consume the newline character
            String department = in.nextLine();


            //colocamos las variables de empleado a supervisor
            String supervisorName = employeeName;
            String supervisorLastName = employeeLastName;
            Long supervisorId = newEmployeeId;
            String supervisorEmail = employeeEmail;
            int supervisorPhoneNumber = employeePhoneNumber.intValue();
            String position = "Supervisor"; // Asignamos el cargo de Supervisor


            // Creamos un objeto Supervisor con los datos del empleado
            System.out.println("por favor, ingrese la ubicación de la oficina del empleado:");
            String officeLocation = in.nextLine();
            Supervisor supervisor = new Supervisor(
                    supervisorName,
                    supervisorLastName,
                    supervisorId,
                    supervisorEmail,
                    supervisorPhoneNumber,
                    position,
                    hireDate,
                    salary,
                    department,
                    officeLocation
            );
            System.out.println("¡Supervisor registrado exitosamente!");
            System.out.println("Nombre: " + supervisor.getName());
            System.out.println("Apellido: " + supervisor.getLastName());
            System.out.println("ID: " + supervisor.getIdEmployed());
            System.out.println("Correo electrónico: " + supervisor.getEmail());
            System.out.println("Número de teléfono: " + supervisor.getPhoneNumber());
            System.out.println("Cargo: " + supervisor.getPosition());
            System.out.println("Fecha de contratación: " + supervisor.getHireDate());
            System.out.println("Salario: " + supervisor.getSalary());


        } else if (positionChoice == 2) {

        } else if (positionChoice == 3) {

        }else {
            System.out.println("Opción no válida. Por favor, intente nuevamente.");
            return;
        }

        // Aquí podrías agregar lógica para guardar los datos del nuevo empleado
        System.out.println("¡Empleado registrado exitosamente!");
    }
}