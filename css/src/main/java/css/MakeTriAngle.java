package css;

import java.io.*;

import java.util.*;

public class MakeTriAngle {

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int length = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i<length; i++) {
            
            list.add(Integer.parseInt(br.readLine()));
            
        }
        
        list.sort(null);
        
        int answer = 0;
        
        for(int i = 0; i<length-2 ; i++) {
            int maxi = list.get(i+2);
            int hal1 = list.get(i);
            int hal2 = list.get(i+1);
            if(maxi<hal1+hal2) {
                
                answer = maxi+hal1+hal2;
                
            }
            
        }
        
        if(answer==0) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
        
    }

}
