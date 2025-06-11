# Ject Bank

## Descripción
Ject Bank es una aplicación bancaria diseñada para gestionar cuentas de inversión, cuentas de ahorro y empleados del banco. El proyecto está desarrollado en Java y utiliza una estructura orientada a objetos para modelar los diferentes componentes del sistema.

## Características
- **Gestión de personas**: Los clientes tienen atributos como nombre, apellido, identificación, correo electrónico, número de teléfono, cuentas de inversión y cuentas de ahorro.
- **Gestión de cuentas**: Las cuentas incluyen información como número de cuenta, tipo de cuenta, saldo, moneda, propietario, fecha de creación, última transacción y estado.
- **Jerarquía de empleados**: Los empleados están organizados en roles como recepcionistas y cajeros.
- **Extensibilidad**: Las clases están diseñadas para ser fácilmente ampliables.

## Estructura del Proyecto
El proyecto está organizado de la siguiente manera:
- `src/com/companysebasth/ject_bank/models/`: Contiene las clases principales del modelo, como `Person`, `Account`, `InvestmentAccount`, `SavingAccount`, `Employed`, `Receptionist` y `Cashier`.
- `src/Main.java`: Contiene el punto de entrada de la aplicación.
- `README.md`: Documentación del proyecto.

## Instalación
1. Clona el repositorio:
   ```bash
   git clone https://github.com/SebasthSegura/ject_bank.git
    ```
   
# Estructura del Proyecto
ject_bank/

├── src/

│   ├── com/companysebasth/ject_bank/models/

│   │   ├── Person.java

│   │   ├── Account.java

│   │   ├── InvestmentAccount.java

│   │   ├── SavingAccount.java

│   │   ├── Employed.java

│   │   ├── Receptionist.java

│   │   └── Cashier.java

│   └── Main.java

├── README.md