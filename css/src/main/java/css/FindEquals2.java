package css;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindEquals2 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] s = br.readLine().split(" ");
        String a = s[0];
        String b = s[1];
        int dis1 = 0;
        int disres = 51;
        for(int i = 0; i<=b.length()-a.length() ; i++) {
            
            for(int j = 0; j<a.length();j++) {
                
                if(a.charAt(j)==b.charAt(j+i)) {
                    
                } else {
                    
                    dis1++;
                    
                }
                
            }
            
            if(disres>dis1) {
                
                disres = dis1;
                
            }
            dis1=0;
        }
        
        System.out.println(disres);
        
        
        
    }

}
