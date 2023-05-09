package css;

import java.io.*;
import java.util.*;


public class BackJoons {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        
        LinkedList<Integer> que = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] b = new String[Integer.parseInt(line)];
        
        line.toUpperCase();
        
        
        for(int i = 0; i<b.length; i++) {
            
            b[i]=br.readLine();
            
            if(b[i].contains("push")) {
                String[] word = b[i].split(" ");
                que.add(Integer.parseInt(word[1]));
            } else if (b[i].contains("front")) {
                if(que.size()>=1) {
                    System.out.println(que.getFirst());
                } else {
                    System.out.println(-1);
                }
                
                
            } else if (b[i].contains("back")) {
                
                if(que.size()>=1) {
                    System.out.println(que.getLast());
                } else {
                    System.out.println(-1);
                }
                
                
            } else if (b[i].contains("pop")) {
                if(que.size()>=1) {
                    System.out.println(que.getFirst());
                    que.removeFirst();
                } else {
                    System.out.println(-1);
                }
                
                
            } else if (b[i].contains("empty")) {
                
                if(que.size()>=1) {
                    System.out.println(0);
                } else {
                    System.out.println(1);
                }
                
            } else if (b[i].contains("size")) {
                System.out.println(que.size());
            }
            
            
        }
        
        
        
        
        
    }

}
