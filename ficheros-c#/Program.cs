/* 1. Leer el contenido del fichero y almacenar los datos en una lista de objetos.
2. Mostrar por consola todos los empleados con su información formateada.
3. Calcular y mostrar el salario promedio de todos los empleados.
4. Filtrar y mostrar los empleados cuyo salario sea mayor al promedio. */

using System;
using System.IO;

class Program {
    static void Main(string[] args) {

        // Ruta del fichero
        string rutaFichero="empleados.txt";

        try { // Control de excepciones
            if (!File.Exists(rutaFichero)) { // Verificamos que el fichero existe
                Console.WriteLine("El archivo no existe.");
                return;
            }
        // Declaración de variables
        int contadorEmpleados=0;
        double totalSalarios=0;
        double salarioMedio=0;
            
            Console.WriteLine("--- Lista de empleados ---");

            foreach (string linea in File.ReadLines(rutaFichero)) {
                string[] empleados=linea.Split(':');
                if (empleados.Length==5) {
                    int id = int.Parse(empleados[0]);
                    string nombre = empleados[1];
                    int edad = int.Parse(empleados[2]);
                    string departamento = empleados[3];
                    double salario = double.Parse(empleados[4]);

                    Console.WriteLine($"ID: {id}, Nombre: {nombre}, Edad: {edad}, Departamento: {departamento}, Salario: {salario}.");

                    totalSalarios+=salario;
                    contadorEmpleados++;
                }
        }

            if (contadorEmpleados>0) {
                    salarioMedio=totalSalarios/contadorEmpleados;
                    Console.WriteLine("El salario medio es: "+salarioMedio+".");
                }

            Console.WriteLine("--- Lista de empleados con salario superior a la media---");

            foreach (string linea in File.ReadLines(rutaFichero)) {
                string[] empleados=linea.Split(':');
                if (empleados.Length==5) {
                    int id = int.Parse(empleados[0]);
                    string nombre = empleados[1];
                    int edad = int.Parse(empleados[2]);
                    string departamento = empleados[3];
                    double salario = double.Parse(empleados[4]);
                    
                    if (salario>salarioMedio) {
                        Console.WriteLine($"ID: {id}, Nombre: {nombre}, Edad: {edad}, Departamento: {departamento}, Salario: {salario}.");
                    }
                }
        }
        } // Excepciones controladas
        catch (FileNotFoundException)
        {
            Console.WriteLine("No se encuentra el archivo.");
        }
        catch (FormatException)
        {
            Console.WriteLine("El archivo contiene datos inválidos.");
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Ocurrió un error: {ex.Message}");
        }
    }
}
