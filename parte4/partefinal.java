import java.util.Scanner;

 public class fim {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         String input;

         while (true) {
             System.out.println("Digite 'sair' caso queira:");
             input = scanner.nextLine();

             if (input.equalsIgnoreCase("sair")) {
                 System.out.println("Encerrando o programa.");
                 break;
             }

         }
     }
 }
