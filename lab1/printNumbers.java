public class ClassNameHere {
    public static void drawTriangle(int N){
       int col = 1;
       while (col <= N){
          int star = 1;
          while(star <= col){
              System.out.print("*");
              star = star + 1;
           }
          System.out.println(" ");
          col = col + 1;         
       }
    }
    
    public static void main(String[] args) {
       drawTriangle(10);     
    }
}

public class printNumbers {
   public static void main(String[] args) {
       int x = 0;
       String sum = "10";
       System.out.println(sum);
       /* while(x < 10){
           System.out.println(sum);
           x = x + 1;
           sum = sum + x;
       }   */
   }
}

public class ClassNameHere {
   public static int max(int[] m) {
       int index = 0;
       int maxNumber = m[index];
       while(index < m.length-1){
          if(m[index] < m[index+1]){
              maxNumber = m[index+1];
          }
          index = index + 1;               
       }
       return maxNumber;             
   }
   public static void main(String[] args) {
      int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
      System.out.print(max(numbers));
   }
}

public class BreakContinue {
   public static void windowPosSum(int[] a, int n) {
       for (int i = 0; i < a.length; i += 1){
           if (a[i] < 0){
               continue;
           }
           int sum = 0;
           for (int j = i; j <= i+n; j += 1){
               if (j == a.length){
                   break;
               }               
               sum = sum + a[j];              
           }
           a[i] = sum;
       }     
 
     
   }
 
   public static void main(String[] args) {
     int[] a = {1, -1, -1, 10, 5, -1};
     int n = 2;
     windowPosSum(a, n);
     // Should print 4, 8, -3, 13, 9, 4
     System.out.println(java.util.Arrays.toString(a));
   }
 }
