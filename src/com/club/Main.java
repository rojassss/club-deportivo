package com.club;

import com.club.model.Socio;
import com.club.service.SocioService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SocioService socioService = new SocioService();
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;

        do {
            System.out.println("\n------ GESTION DEL CLUB DEPORTIVO ------");
            System.out.println("1. Registrar un nuevo socio");
            System.out.println("2. Listar todos los socios");
            System.out.println("3. Buscar socio por DNI");
            System.out.println("4. Cambiar estado de socio (Activo/Inactivo)");
            System.out.println("5. Salir");
            System.out.println("Seleccione una de las siguientes opciones: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese una opcion valida, por favor");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.println("Ingrese DNI: ");
                    String dni = scanner.nextLine();

                    Socio socio = new Socio(0, nombre, apellido, dni, true);
                    if (socioService.registrarSocio(socio)) {
                        System.out.println("Socio registrado exitosamente!");
                    } else {
                        System.out.println("Error: Ya existe un socio registrado con ese DNI.");
                    }
                    break;

                case 2:
                    System.out.println("--- LISTA DE SOCIOS ---");
                    for (Socio s : socioService.listarSocio()) {
                        System.out.println(s);
                    }
                    break;

                case 3:
                    System.out.println("Ingrese el DNI del socio que desea buscar: ");
                    String dniBuscar = scanner.nextLine();
                    Socio socioEncontrado = socioService.buscarPorDni(dniBuscar);
                    if (socioEncontrado != null) {
                        System.out.println(socioEncontrado);
                    } else {
                        System.out.println("No se encontro un socio con el DNI ingresado.");
                    }
                    break;

                case 4:
                    System.out.println("Ingrese el id del socio: ");
                    int idEstado = Integer.parseInt(scanner.nextLine());
                    System.out.println("Ingrese el nuevo estado del socio (true para Activo / false para Inactivo): ");
                    boolean nuevoEstado = Boolean.parseBoolean(scanner.nextLine());

                    if (socioService.cambiarEstado(idEstado, nuevoEstado)) {
                        System.out.println("Estado del socio modificado exitosamente!");
                    } else {
                        System.out.println("No se encontró el usuario");
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("La opcion ingresada no es correcta.");
                    break;
            }

        } while (opcion != 5);

        scanner.close();
    }
}