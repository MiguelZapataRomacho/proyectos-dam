package CuentasRedSocial;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionFicheros { 

		// MÉTODOS USUARIOS
	protected void guardarCuenta(CuentaUsuario cuenta) {
		Path path=Paths.get("src", "Usuarios.txt"); // Ruta relativa
		
		try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) { 
            // Create y append crean el fichero si no existen y evitan que se sobreescriba, respectivamente
			if (cuenta instanceof CuentaBasica basica) {
                writer.write("BASICA|" + basica.getNombreUsuario() + "|" + basica.getEmail() + "|" + basica.getTelefono() + "|" + basica.getEdad() + "|" + basica.getPublicacionesRestantes());
            } else if (cuenta instanceof CuentaPremium premium) {
                writer.write("PREMIUM|" + premium.getNombreUsuario() + "|" + premium.getEmail() + "|" + premium.getTelefono() + "|" + premium.getEdad() + "|" + premium.getTipoSuscripcion());
            }
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error al guardar la cuenta: " + e.getMessage());
        }
    }
	
	protected CuentaUsuario buscarCuenta(String nombreUsuario) {
        Path path = Paths.get("src", "Usuarios.txt");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split("\\|");
                if (datos.length >= 6 && datos[1].equals(nombreUsuario)) {
                    String tipo = datos[0];
                    String email = datos[2];
                    int telefono = Integer.parseInt(datos[3]);
                    int edad = Integer.parseInt(datos[4]);

                    if ("BASICA".equals(tipo)) {
                        int publicacionesRestantes = Integer.parseInt(datos[5]);
                        return new CuentaBasica(nombreUsuario, email, telefono, edad, publicacionesRestantes);
                    } else if ("PREMIUM".equals(tipo)) {
                        String tipoSuscripcion = datos[5];
                        return new CuentaPremium(nombreUsuario, email, telefono, edad, tipoSuscripcion);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al buscar la cuenta: " + e.getMessage());
        }
        return null;
    }
	
	protected void actualizarCuenta(CuentaUsuario cuenta) {
        Path path = Paths.get("src", "Usuarios.txt");
        List<String> lineas = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split("\\|");
                if (datos.length >= 6 && datos[1].equals(cuenta.getNombreUsuario())) {
                    if (cuenta instanceof CuentaBasica basica) {
                        linea = "BASICA|" + basica.getNombreUsuario() + "|" + basica.getEmail() + "|" + basica.getTelefono() + "|" + basica.getEdad() + "|" + basica.getPublicacionesRestantes();
                    } else if (cuenta instanceof CuentaPremium premium) {
                        linea = "PREMIUM|" + premium.getNombreUsuario() + "|" + premium.getEmail() + "|" + premium.getTelefono() + "|" + premium.getEdad() + "|" + premium.getTipoSuscripcion();
                    }
                }
                lineas.add(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo para actualizar: " + e.getMessage());
            return;
        }
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.TRUNCATE_EXISTING)) {
            for (String l : lineas) {
                writer.write(l);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo actualizado: " + e.getMessage());
        }
    }
		// MÉTODOS PUBLICACIONES
	protected void guardarPublicacion(String nombreUsuario, String mensaje) {
        Path path = Paths.get("src", "Publicaciones.txt");
        
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.write(nombreUsuario + ": " + mensaje);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error al guardar publicación: " + e.getMessage());
        }
    }

    protected void mostrarPublicaciones() {
        Path path = Paths.get("src", "Publicaciones.txt");

        if (!Files.exists(path)) {
            System.out.println("Aún no hay publicaciones.");
            return;
        }

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String linea;
            System.out.println("Publicaciones: ");
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer publicaciones: " + e.getMessage());
        }
    }
}
