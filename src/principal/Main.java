package principal;

import servicio.BilleteraServicio;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        BilleteraServicio servicio = new BilleteraServicio();
        int opcion = 0;
        System.out.println("¡Bienvenido a tu Billetera Virtual!");

        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Registrar nuevo usuario");
            System.out.println("2. Consultar perfil de usuario");
            System.out.println("3. Depositar dinero");
            System.out.println("4. Consultar saldo");
            System.out.println("5. Transferir dinero");
            System.out.println("6. Ver historial de movimientos");
            System.out.println("7. Salir");
            System.out.print("Elegí una opción: ");

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("\n--- REGISTRO ---");
                    System.out.print("Ingresá el DNI: ");
                    String dni = teclado.nextLine();

                    System.out.print("Ingresá el Nombre: ");
                    String nombre = teclado.nextLine();

                    System.out.print("Ingresá el Apellido: ");
                    String apellido = teclado.nextLine();

                    System.out.print("Ingresá el Email: ");
                    String email = teclado.nextLine();

                    servicio.registrarUsuario(dni, nombre, apellido, email);
                    break;

                case 2:
                    System.out.println("\n--- CONSULTA DE PERFIL ---");
                    System.out.print("Ingresá el DNI: ");
                    String dniConsulta = teclado.nextLine();
                    servicio.consultarPerfilUsuario(dniConsulta);
                    break;

                case 3:
                    System.out.println("\n--- DEPOSITAR DINERO ---");
                    System.out.print("Ingresá el CVU de tu cuenta: ");
                    String cvuDeposito = teclado.nextLine();

                    System.out.print("Ingresá el monto a depositar: ");
                    BigDecimal montoDeposito = teclado.nextBigDecimal();
                    teclado.nextLine();

                    servicio.depositar(cvuDeposito, montoDeposito);
                    break;

                case 4:
                    System.out.println("\n--- CONSULTAR SALDO ---");
                    System.out.print("Ingresá el CVU de tu cuenta: ");
                    String cvuSaldo = teclado.nextLine();
                    servicio.consultarSaldo(cvuSaldo);
                    break;

                case 5:
                    System.out.println("\n--- TRANSFERIR DINERO ---");
                    System.out.print("Ingresá tu CVU: ");
                    String cvuOrigen = teclado.nextLine();

                    System.out.print("Ingresá el CVU a transferir: ");
                    String cvuDestino = teclado.nextLine();

                    System.out.print("Ingresá el monto a transferir: ");
                    BigDecimal montoTransferencia = teclado.nextBigDecimal();
                    teclado.nextLine();

                    servicio.transferir(cvuOrigen, cvuDestino, montoTransferencia);
                    break;

                case 6:
                    System.out.println("\n-- HISTORIAL DE MOVIMIENTOS --");
                    System.out.print("Ingresá el CVU de tu cuenta: ");
                    String cvuHistorial = teclado.nextLine();
                    servicio.consultarHistorial(cvuHistorial);
                    break;

                case 7:
                    System.out.println("¡Gracias por usar la Billetera Virtual! Cerrando sistema...");
                    break;

                default:
                    System.out.println("Opción incorrecta. Intentá de nuevo.");
            }
        } while (opcion != 7);

        teclado.close();
            }
        }
