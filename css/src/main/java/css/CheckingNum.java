package css;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckingNum {

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int maxLength = Integer.parseInt(br.readLine()); 
        String[] a = br.readLine().split(" ");
        
        int maxLength2 = Integer.parseInt(br.readLine());
        String[] b = br.readLine().split(" ");
        boolean check = false;
        for(long i = 0; i<b.length; i++) {
            
            for(long j = 0; j<a.length ; j++) {
                
                if(b[(int)i].equals(a[(int)j])) {
                    System.out.println(1);
                    check =true;
                    break;
                }
                
            }
            if(check==true) {
                
                check=false;
                
            } else {
                System.out.println(0);
            }
        }
    }

}
