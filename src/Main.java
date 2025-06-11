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

        System.out.println("Por favor, ingrese su nombre:");
        String name = in.nextLine();

        System.out.println("Por favor, ingrese su apellido:");
        String lastName = in.nextLine();

        System.out.println("Por favor, ingrese su ID:");
        Long idUser = in.nextLong();

        System.out.println("Por favor, ingrese su correo electrónico:");
        in.nextLine(); // Consume the newline character
        String email = in.nextLine();

        System.out.println("Por favor, ingrese su número de teléfono:");
        Long phoneNumber = in.nextLong();

        // Create a Person object with the provided details
        Person person = new Person(name, lastName, idUser, email, phoneNumber, null, null);
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
                SavingAccount savingAccount = new SavingAccount(interestRate, initialDeposit, accountType);
                savingAccount.setAccountNumber(String.valueOf(accountNumber));
                System.out.println("¡Cuenta de Ahorros creada con éxito!");
                System.out.println("Número de cuenta: " + savingAccount.getAccountNumber());
                System.out.println("Tipo de cuenta: " + savingAccount.getAccountType());
                System.out.println("Saldo inicial: " + savingAccount.getInitialDeposit());
            } else if (opcion == 2) {
                System.out.println("Por favor, ingrese el monto inicial que desea invertir: ");
                double investmentAmount = in.nextDouble();
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
                System.out.println("¡Cuenta de Inversión creada con éxito!");
                System.out.println("Número de cuenta: " + investmentAccount.getAccountNumber());
                System.out.println("Tipo de cuenta: " + investmentAccount.getInvestmentType());
                System.out.println("Monto de inversión: " + investmentAccount.getInvestmentAmount());

            } else if (opcion != 3) {
                System.out.println("Opción no válida. Por favor, intente nuevamente.");
            }
        } while (opcion != 3);
    }
}