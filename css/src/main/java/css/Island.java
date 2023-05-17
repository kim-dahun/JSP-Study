package css;

import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        int[] answer = {};
        int sum = 0;
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        boolean start = false;
        boolean end = false;
        for(int i = 0; i<maps.length; i++){
            
            for(int j = 0; j<maps[i].length() ; j++){
                String s1 = maps[i].split("")[j];
                if(start = true){
                    
                    if(s1.equals("X")){
                        
                    } else{
                        
                       sum+= Integer.parseInt(s1);  
                    }
                    
                } else {
                    
                    if(i==0 && j==0){
                        
                        if(!s1.equals("X")){
                            sum+= Integer.parseInt(s1);
                            start = true;
                            
                        }
                        
                    } else if(i==0 && j==maps[i].length()-1 ){
                        
                        
                        String s3 = maps[i].split("")[j-1];
                        
                        if(s3.equals("X")){
                            sum+= Integer.parseInt(s1);
                            start = true;
                        }
                        
                    } else if(i==maps.length-1 && j==0){
                        
                        String s2 = maps[i-1].split("")[j];
                        
                        
                        if(s2.equals("X")){
                            sum+= Integer.parseInt(s1);
                            start = true;
                        }
                        
                    } else if(i==maps.length-1 && j==maps[i].length()-1){
                        
                        String s2 = maps[i-1].split("")[j];
                        String s3 = maps[i].split("")[j-1];
                        
                        if(s2.equals("X") && s3.equals("X")){
                            sum+= Integer.parseInt(s1);
                            start = true;
                        }
                        
                    } else if(i==0){
                        
                        
                        String s3 = maps[i].split("")[j-1];
                        
                        if( s3.equals("X")){
                            sum+= Integer.parseInt(s1);
                            start = true;
                        }
                        
                    } else if(i==maps.length-1){
                        
                        String s2 = maps[i-1].split("")[j];
                        String s3 = maps[i].split("")[j-1];
                        
                        if(s2.equals("X") && s3.equals("X")){
                            sum+= Integer.parseInt(s1);
                            start = true;
                        }
                        
                    } else if(j==0){
                        
                        String s2 = maps[i-1].split("")[j];
                        
                        
                        if(s2.equals("X")){
                            sum+= Integer.parseInt(s1);
                            start = true;
                        }
                        
                    } else if(j==maps[i].length()-1){
                        
                        String s2 = maps[i-1].split("")[j];
                        String s3 = maps[i].split("")[j-1];
                        
                        if(s2.equals("X") && s3.equals("X")){
                            sum+= Integer.parseInt(s1);
                            start = true;
                        }
                        
                    } else {
                        
                        String s2 = maps[i-1].split("")[j];
                        String s3 = maps[i].split("")[j-1];
                        
                        if(s2.equals("X") && s3.equals("X")){
                            sum+= Integer.parseInt(s1);
                            start = true;
                        }
                        
                    }
                    
                }
                
                // 경로탐색 시작 조건 위까지
                if(j==maps[i].length()-1 && i==maps.length-1){
                    
                    start=false;
                    list.add(sum);
                    sum=0;
                    
                } else if(j==maps[i].length()-1){
                    String s2 = maps[i+1].split("")[j];
                    if(!s2.equals("X") && s1.equals("X")){
                        
                        start=false;
                        list.add(sum);
                        sum=0;
                        
                    } else if(s2.equals("X") && !s1.equals("X")){
                        start=false;
                        list.add(sum);
                        sum=0;
                    }
                    
                } else if(i==maps.length-1){
                    String s2 = maps[i].split("")[j+1];
                    if(s1.equals("X") && !s2.equals("X")){
                        
                        start=false;
                        list.add(sum);
                        sum=0;
                        
                    } else if(!s1.equals("X") && s2.equals("X")) {
                        
                        start=false;
                        list.add(sum);
                        sum=0;
                        
                    } else {
                        
                        start=false;
                        list.add(sum);
                        sum=0;
                        
                    }
                    
                } else {
                    String s2 = maps[i].split("")[j+1];
                    String s3 = maps[i+1].split("")[j];
                    
                    if(s1.equals("X")){
                        
                        
                        
                    } else {
                        
                        if(!s2.equals("X") && !s3.equals("X")){
                            
                            start=false;
                            list.add(sum);
                            sum=0;
                            
                        }
                        
                    }
                        
                        start=false;
                        list.add(sum);
                        sum=0;
                        
                    
                    
                }
                
                
            }
            
            
        }
        System.out.println(list.size());
         for(int x = 0; x<answer.length ; x++ ){
          
             answer[x]=list.get(x);
           
         } 
        
        return answer;
    }
}

public class Island {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution sol = new Solution();
        int[] a = sol.solution(new String[]{"X591X","X1X5X","X231X", "1XXX1"});
        System.out.println(a.length);
        for(int x : a) {
            System.out.println(x);
        }
        
    }

}
