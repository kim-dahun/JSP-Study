package css;

public class ReplaceJkens {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = " 3pop chicken  CkiLen ";
        boolean check = true;
        boolean all = false;
        String answer ="";
        char[] c1 = s.toCharArray();
        
        for(int i = 0; i<c1.length ; i++) {
            String ans = c1[i] + "";
            if(ans.equals(" ")) {
                
                check=true;
                all = false;
                
            } else {
                
                if(check==true) {
                    
                    if(ans.matches(".*[0-9].*")) {
                        
                        all = true;
                        
                    } else {
                        
                        if(all==false) {
                            
                            ans = ans.toUpperCase();
                            all = true;
                            
                        } else {
                            
                            ans = ans.toLowerCase();
                            
                        }
                        
                    }
                    
                } 
                
                
            }
            answer += ans;
        }
        System.out.println(answer);
        
    }

}
