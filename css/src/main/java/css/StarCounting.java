package css;

public class StarCounting {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        for(int i = 1; i<5; i++) {
            
            int star = 2*i-1;
            
            for(int j = 10; j>star ; j-=2) {
                
                System.out.print(" ");
                
            }
            
            for(int j = 0 ; j<star ; j++) {
                
                System.out.print("*");
                
            }
            
            System.out.println();
            
        }
        
    }

}
