package com.wildev.demo;

import com.wildev.demo.dao.UserDao;
import com.wildev.demo.model.User;

import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		UserDao dao = new UserDao();
		Scanner sc = new Scanner(System.in);

		int option;

		do {
			System.out.println("\n===== MENU CRUD =====");
			System.out.println("1. Crear usuario");
			System.out.println("2. Listar usuarios");
			System.out.println("3. Actualizar usuario");
			System.out.println("4. Eliminar usuario");
			System.out.println("0. Salir");
			System.out.print("Opción: ");

			option = sc.nextInt();
			sc.nextLine(); // limpiar buffer

			switch (option) {

				case 1:
					System.out.print("Nombre: ");
					String name = sc.nextLine();

					System.out.print("Email: ");
					String email = sc.nextLine();

					dao.createUser(new User(name, email));
					break;

				case 2:
					List<User> users = dao.getUsers();

					System.out.println("\nLISTA DE USUARIOS:");

					for (User u : users) {
						System.out.println(
								u.getId() + " | " +
										u.getName() + " | " +
										u.getEmail()
						);
					}
					break;

				case 3:
					System.out.print("ID a actualizar: ");
					int idUpdate = sc.nextInt();
					sc.nextLine();

					System.out.print("Nuevo nombre: ");
					String newName = sc.nextLine();

					System.out.print("Nuevo email: ");
					String newEmail = sc.nextLine();

					dao.updateUser(new User(idUpdate, newName, newEmail));
					break;

				case 4:
					System.out.print("ID a eliminar: ");
					int idDelete = sc.nextInt();

					dao.deleteUser(idDelete);
					break;

				case 0:
					System.out.println("Saliendo...");
					break;

				default:
					System.out.println("Opción inválida ❌");
			}

		} while (option != 0);

		sc.close();
	}
}