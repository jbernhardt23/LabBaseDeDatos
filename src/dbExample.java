import java.sql.*;
import java.util.Scanner;

public class dbExample {

	// Query objects
	static Statement statement;
	static ResultSet result;

	public static void main(String[] args) {

		try {

			// Setting database connection
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection connection = DriverManager
					.getConnection("jdbc:odbc:login_DSN");
			statement = connection.createStatement();

			Scanner sc = new Scanner(System.in);

			int temp;
			String tempString;

			

			do {
				System.out.println("-------------Interfaz SQL------------");
				System.out.println("---> Elegir el numero de la opcion deseada: ");
				System.out.println("1.Crear Database" + "\n" + "3.Crear tabla"
						+ "\n" + "4.Drop tabla" + "\n" + "5.Insertar records"
						+ "\n" + "6.Seleccionar records" + "\n"
						+ "7.Actualizar records" + "\n" + "8.Borrar records" + "\n"
						+ "-------Inserte 0 para salir del programa-------" + "\n");

				temp = sc.nextInt();
				sc.nextLine();

				switch (temp) {

				case 1:
					System.out
							.println("Inserte su comando SQL para crear Database: "
									+ "\n");
					tempString = "";
					tempString = sc.nextLine();
					// executeUpdate(tempString,statement);
					break;

				case 3:
					System.out
							.println("Inserte su comando SQL para crear Tabla: "
									+ "\n");
					tempString = "";
					tempString = sc.nextLine();
					executeUpdate(tempString, statement);
					connection.commit();
					break;

				case 4:
					System.out
							.println("Inserte su comando SQL para eliminar Tabla: "
									+ "\n");
					tempString = "";
					tempString = sc.nextLine();
					executeUpdate(tempString, statement);
					connection.commit();
					break;

				case 5:
					System.out
							.println("Inserte su comando SQL para insertar record: "
									+ "\n");
					tempString = "";
					tempString = sc.nextLine();
					executeUpdate(tempString, statement);
					connection.commit();
					break;

				case 6:

					System.out
							.println("Inserte su comando SQL para selecionar record: "
									+ "\n");
					tempString = "";
					tempString = sc.nextLine();
					selectInfo(tempString, result, statement);
					break;

				case 7:
					System.out
							.println("Inserte su comando SQL para actualizar record: "
									+ "\n");
					tempString = "";
					tempString = sc.nextLine();
					executeUpdate(tempString, statement);
					connection.commit();
					break;

				case 8:

					System.out
							.println("Inserte su comando SQL para borrar record: "
									+ "\n");
					tempString = "";
					tempString = sc.nextLine();
					executeUpdate(tempString, statement);
					connection.commit();
					break;
					
				default:
					System.out.println("Opccion no valida!");
				}

			} while (temp != 0);

			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Method that executes any changes on database
	 * 
	 * @param data String with SQL statement
	 * @param statement current object
	 * @throws SQLException
	 */
	public static void executeUpdate(String data, Statement statement) {
		try {
			statement.executeUpdate(data);
			System.out.println("Listo!");
		} catch (SQLException e) {
			System.out.println("---> Error executing you query: "
					+ e.getMessage());
			

		}
	}

	/**
	 * Method that select from Database and prints back results
	 * 
	 * @param data SQL select string statement
	 * @param statement
	 */
	public static void selectInfo(String data, ResultSet result,
			Statement statement) {
		int count = 1;

		try {
			result = statement.executeQuery(data);

			while (result.next()) {

				System.out.print(result.getString(count) + " " + "\n");
				count++;
			}
		} catch (SQLException e) {
			System.out.println("---> Error executing you query: "
					+ e.getMessage());

		}

	}

}
