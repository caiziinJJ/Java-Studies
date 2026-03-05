import java.util.Scanner;
public class Tentando
{
   public static void main(String[] args)
   {
      Scanner valor = new Scanner(System.in);

      int v1 = 0;
      int v2 = 0;
      int soma = 0;
      System.out.println("Insira o primeiro valor:");
      v1 = valor.nextInt();
      System.out.println("Insira o segundo valor:");
      v2 = valor.nextInt();
      soma = v1+v2;
      System.out.printf("%s%d%n", "O resultado da soma é: ", soma);




   } // end method main

} // end class Welcome1


/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/