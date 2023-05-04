package css;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindEquals {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] s = br.readLine().split(" ");
        String a = s[0];
        String b = s[1];
        int distance = 0;
        int distance2 = 0;
        int disres = 50;
        if(a.length()==b.length()) {
            
            for(int i = 0 ; i<a.length();i++) {
                
                if(a.charAt(i)==b.charAt(i)) {
                    
                } else {
                    
                    distance++;
                    
                }
                
                
            }
            
            System.out.println(distance);
            
        } else {
            int start = 0;
            int end = 0;
            for(int i = 0; i<b.length()-a.length()+1; i++) {
                
                for(int j = 0; j<a.length() ;j++) {
                    
                    if(a.charAt(j)==b.charAt(i+j)) {
                        
                    } else {
                        distance++;
                    }
                    
                }
               
                if(disres>distance) {
                    disres = distance;
                    
                    start = i;
                    end = i+a.length()-1;
                }
                distance = 0;
            }
            if(disres==0) {
                System.out.println(0);
                return;
            }
            disres = 0;
            distance =0;
            
            
            
            String a1 = a;
            for(int i = 1 ; i<=b.length()-a.length(); i++) {
                if(start-i>=0) {
                a1 = b.charAt(start-i) + a;
                for(int j = start-i,k=0 ; k<a1.length(); j++,k++ ) {
                    
                    if(a1.charAt(k)==b.charAt(j)) {
                        
                    } else {
                        
                        distance++;
                        
                    }
                    
                }
                }
                if(end+i<=b.length()-1) {
                a1 = a + b.charAt(end+i);
                for(int j = end+i,k=a1.length()-1 ; k>=0 ; j--,k--) {
                    
                    if(a1.charAt(k)==b.charAt(j)) {
                        
                    } else {
                        
                        
                        distance2++;
                    }
                    
                }
                }
                if(start-i>=0 && end+i>b.length()-1) {
                    
                    a = b.charAt(start-i) + a;
                    disres = distance;
                    
                } else if(end+i<=b.length()-1 && start-i<0) {
                    
                    a = a + b.charAt(end+i);
                    disres = distance2;
                    
                } else if(distance2>distance) {
                    
                    a = b.charAt(start-i) + a;
                    disres = distance;
                    
                } else {
                    a = a + b.charAt(end+i);
                    disres = distance2;
                }
                
                distance = 0;
                distance2 = 0;
                
            }
            
            System.out.println(disres);
            
            
        }
        
        
    }

}
