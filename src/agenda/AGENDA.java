
package agenda;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.RandomAccessFile;
public class AGENDA {


    public static void main(String[] args) {
        long tamaño;
        Scanner t = new Scanner(System.in);
        String Nombre = new String();
        String Número = new String();
    try{
        RandomAccessFile fichero = new RandomAccessFile("C:\\Users\\xabier.barreiroalber\\Documents\\AGENDA.txt", "rw");
        int elec;
            System.out.println("1- MOSTRAR AGENDA \n"
                             + "2- AÑADIR CONTACTO A LA AGENDA \n"
                             + "3- MOSTRAR CONTACTO EN ESPECIFICO");
            elec = t.nextInt();

            switch(elec){
                case 1:
                    int contador = 0;
                    int alto = 0;
                    do{
                    fichero.seek(0+ (17 * contador));
                    
                    String agenda = fichero.readLine();
                    if(agenda == null){
                        alto = 1;
                    }
                    else{
                    System.out.println(agenda);
                    }
                    contador++;
                    }while(alto != 1);
                    
                    
                    break;
                case 2:
                    
                    tamaño = fichero.length();
                    fichero.seek(tamaño);
                    System.out.println("Nombre - 6 Dígitos");
                    Nombre = t.next();

                    System.out.println("Número de telefono - 9 Dígitos");
                    Número = t.next();

                    fichero.writeBytes(Nombre + " ");
                    fichero.writeBytes(Número + "\n");  
                    break;
                    

                case 3:
                    
                    System.out.println("Que contacto - Escribe el número");
                    int n = t.nextInt();
                    fichero.seek(0+(17 * (n-1)));
                    String contacto = fichero.readLine();
                    System.out.println("CONTACTO Nº "+n+":");
                    System.out.println(contacto);
                
                /*case 4:
                    long longitud = fichero.length();
                    System.out.println(longitud);
                */    
            }
                

        }catch(IOException e){
            System.out.println(e.getMessage());
    };
}
    
}
