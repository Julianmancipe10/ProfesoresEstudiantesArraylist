
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ProfesoresEstudiantes {
     ArrayList<String> listaProfesores;
     ArrayList<String> listEstudiantes;
     ArrayList<ArrayList<String>> listaGeneralEstudiantes;

    public ProfesoresEstudiantes() {
        listaProfesores = new ArrayList<>();
        listaGeneralEstudiantes = new ArrayList<>();
    }

    public void iniciar() {

        boolean exit = false;
        while (!exit) {
            String opcion = JOptionPane.showInputDialog("Menú de opciones:\n" +
                    "1. Registrar profesores\n" +
                    "2. Registrar estudiantes\n" +
                    "3. Consultar lista de profesores y estudiantes\n" +
                    "4. Consultar un profesor y su lista de estudiantes\n" +
                    "5. Consultar cantidad de estudiantes por profesor\n" +
                    "6. Consultar director de grupo de un estudiante\n" +
                    "7. Salir");

            switch (opcion) {
                case "1":
                    registrarProfesores();
                    break;
                case "2":
                    registrarEstudiantes();
                    break;
                case "3":
                    if (listaProfesores.isEmpty() || listaGeneralEstudiantes.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Debe registrar profesores y estudiantes primero.");
                    } else {
                        consultarListaProfesoresYEstudiantes();
                    }
                    break;
                case "4":
                    if (listaProfesores.isEmpty() || listaGeneralEstudiantes.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Debe registrar profesores y estudiantes primero.");
                    } else {
                        consultaProfesorPorNombre();
                    }
                    break;
                case "5":
                    if (listaProfesores.isEmpty() || listaGeneralEstudiantes.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Debe registrar profesores y estudiantes primero.");
                    } else {
                        consultaCantidadEstudiantesPorProfesor();
                    }
                    break;
                case "6":
                    if (listaProfesores.isEmpty() || listaGeneralEstudiantes.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Debe registrar profesores y estudiantes primero.");
                    } else {
                        consultarEstudiante();
                    }
                    break;
                case "7":
                    exit = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    private void registrarProfesores() {
        System.out.print("Registro de profesores ");
        int cantidad =Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de profesores"));
        

        for (int i = 0; i < cantidad; i++) {
         
            String nombreProfesor=JOptionPane.showInputDialog("Nombre del Profesor" + (i+1));
            listaProfesores.add(nombreProfesor);
           
        }
        System.out.println("Regristro de profesores exitoso");
    }

    private void registrarEstudiantes() {
        
            System.out.println("Registro de ");
            for (int i = 0; i < listaProfesores.size(); i++) {
            
            JOptionPane.showMessageDialog(null, "Ingrese los estudiantes" + "para el profesor" + listaProfesores.get(i) );

            listEstudiantes = new ArrayList<String>();
            
            int cantidad=Integer.parseInt(JOptionPane.showInputDialog("Cantidad de estudiantes"));
            
            for(int j =0; j <cantidad ; j++) {
            
            	String nombreEst=JOptionPane.showInputDialog("nombre de estudiante" + (j+1));
            	listEstudiantes.add(nombreEst);
            }
            
            listaGeneralEstudiantes.add(listEstudiantes);
        }
        System.out.println("Registro estudiante exitoso");    
    }

    private void consultarListaProfesoresYEstudiantes() {
    
    	System.out.println("Lista de profesores  y estudiantes");
    	ArrayList<String> listaTemporal;
    	
    	for(int i=0; i < listaGeneralEstudiantes.size(); i++) {
    		
    		listaTemporal=listaGeneralEstudiantes.get(i);
    		System.out.print("Profesor: " + listaProfesores.get(i) + "=");
    		System.out.print("[");
    		
    		for(int j =0; j<listaTemporal.size();j++) {
    			System.out.print(listaTemporal.get(j));
    			
    			if(j<listaTemporal.size()-1) {
    				System.out.print(",");
    				
    			}
    		}
    		
    		System.out.print("]\n");
    		
    	}
    
    }
    

    private void consultaProfesorPorNombre() {
    
    	System.out.println("Consulta de Profesor");
    	String nombre=JOptionPane.showInputDialog("Ingrese el nombre del profesor");
    	
    	if (listaProfesores.contains(nombre)) {
    		int posicion=listaProfesores.indexOf(nombre);
    		ArrayList<String> listaEstudiantesTemporales=listaGeneralEstudiantes.get(posicion);
    		
    		System.out.print("Profesor: " +nombre+ "=" );
    		System.out.print("[");
    		for(int j=0; j<listaEstudiantesTemporales.size();j++){
    			System.out.print(listaEstudiantesTemporales.get(j));
    			if(j<listaEstudiantesTemporales.size()-1) {
    				System.out.print(",");
    			}
    		}
    			System.out.println("]\n");
    			
    		}else {
   			System.out.println("No se encuentra el profesor" +nombre+ "\n");
    			
    		}
    }
    	
    	

    private void consultaCantidadEstudiantesPorProfesor() {

    	System.out.println("COnsulta la cantidad de estudiantes de Profesores");
    	String nombre=JOptionPane.showInputDialog("Ingrese el nombre del profesor para saber" + "La cantidad de estudiantes asiciados");
    	
    	if(listaProfesores.contains(nombre)) {
    		int posiciones=listaProfesores.indexOf(nombre);
    		ArrayList<String> ListaEstudiantesTemporal=listaGeneralEstudiantes.get(posiciones);
    		System.out.println("La cantidad de estudiantes al profesor" +nombre+ "es" + ListaEstudiantesTemporal.size());
    	}else {
    		System.out.println("No se encuentra el Profesor" +nombre+ "\n");
    	}
    }
    

    private void consultarEstudiante() {
    	System.out.println("consulta el Estudiante");
    	ArrayList<String> listTemporal;
    	
    	String nombre=JOptionPane.showInputDialog("Ingrese el nombre del estudiante a consultar");
    	
    	for(int i = 0; i<listaGeneralEstudiantes.size();i++ ) {
    		
    		listTemporal=listaGeneralEstudiantes.get(i);
    		
    		if(listTemporal.contains(nombre)) {
    			
    			for(int j=0; j<listTemporal.size();j++) {
    				
    				if(listTemporal.get(j).equalsIgnoreCase(nombre)) {
    					
    					System.out.println("Encuentra al nombre: " + nombre+ "pertenece al "+ "grupo de" + listaProfesores.get(i));		
    				}
    			}
    		}else {
    			System.out.println("No se encuentra el nombre el en grupo de "+listaProfesores.get(i));
    		}
    		
    	}
    	
    }
}