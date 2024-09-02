/**
/ UNIVERSIDAD DEL VALLE DE GUATEMALA
/ DEPARTAMENTO DE CIENCIA DE LA COMPUTACIÓN
/ CC2008 
/ AUTOR: Denil Parada
/ FECHA: 02/09/2024 
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class PlanificadorComidas {
    public static void main(String[] args) {
        // Definir los días de la semana y los tipos de comidas
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        String[] comidas = {"Desayuno", "Almuerzo", "Cena"};
        
        // Arreglo de 7x3 para almacenar las comidas
        String[][] planComidas = new String[7][3];
        
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            // Ingresar las comidas para cada día y cada tipo de comida
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.println("Escribe lo que comerás en " + comidas[j] + " del " + dias[i] + ": ");
                    planComidas[i][j] = bufer.readLine();
                }
            }
            
            // Menú de opciones
            int opcion;
            do {
                System.out.println("Elige una opción:");
                System.out.println("1. Ver los desayunos de la semana");
                System.out.println("2. Ver los almuerzos de la semana");
                System.out.println("3. Ver las cenas de la semana");
                System.out.println("4. Ver las 3 comidas de un día específico");
                System.out.println("5. Ver toda la tabla de comidas de la semana");
                System.out.println("6. Salir");
                
                opcion = Integer.parseInt(bufer.readLine());
                
                switch (opcion) {
                    case 1:
                        System.out.println("Desayunos de la semana:");
                        for (int i = 0; i < 7; i++) {
                            System.out.println(dias[i] + ": " + planComidas[i][0]);
                        }
                        break;
                    case 2:
                        System.out.println("Almuerzos de la semana:");
                        for (int i = 0; i < 7; i++) {
                            System.out.println(dias[i] + ": " + planComidas[i][1]);
                        }
                        break;
                    case 3:
                        System.out.println("Cenas de la semana:");
                        for (int i = 0; i < 7; i++) {
                            System.out.println(dias[i] + ": " + planComidas[i][2]);
                        }
                        break;
                    case 4:
                        System.out.println("Escribe el día (1 para Lunes, 7 para Domingo): ");
                        int dia = Integer.parseInt(bufer.readLine());
                        if (dia >= 1 && dia <= 7) {
                            System.out.println(dias[dia-1] + ": ");
                            System.out.println("Desayuno: " + planComidas[dia-1][0]);
                            System.out.println("Almuerzo: " + planComidas[dia-1][1]);
                            System.out.println("Cena: " + planComidas[dia-1][2]);
                        } else {
                            System.out.println("Día no válido.");
                        }
                        break;
                    case 5:
                        // Mostrar toda la tabla con los encabezados
                        System.out.println("Tabla completa de comidas de la semana:");
                        System.out.printf("%-12s %-20s %-20s %-20s%n", " ", "Desayuno", "Almuerzo", "Cena");
                        System.out.println("---------------------------------------------------------------------------------");
                        for (int i = 0; i < 7; i++) {
                            System.out.printf("%-12s %-20s %-20s %-20s%n", dias[i], planComidas[i][0], planComidas[i][1], planComidas[i][2]);
                        }
                        break;
                    case 6:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } while (opcion != 6);
            
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingresa un número válido.");
        }
    }
}
