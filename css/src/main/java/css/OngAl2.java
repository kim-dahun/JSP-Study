package css;

class Solution23 {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] bab = {"aya","ye","woo","ma"};
        int count = 0;
        for(int i = 0; i<babbling.length ; i++){
            String[] minibab = babbling[i].split("");
            
            for(int k = 0 ; k<bab.length ; k++){
            
            String check = bab[k];
            int len = check.length();
            String recheck = "";
            if(len==2){
                for(int j = 0 ; j<minibab.length-len+1 ; j++){
                
                recheck = ""+minibab[j]+minibab[j+1];
                if(recheck.equals(check)){
                    
                    minibab[j]=" ";
                    minibab[j+1]=" ";
                    
                    break;
                }
                    
                    
                }
            } else {
                for(int j = 0 ; j<minibab.length-len+1 ; j++){
                
                recheck = ""+minibab[j]+minibab[j+1]+minibab[j+2];
                if(recheck.equals(check)){
                    
                    minibab[j]=" ";
                    minibab[j+1]=" ";
                    minibab[j+2]=" ";
                    break;
                }
                    
                    
                }
            }
            babbling[i]="";
            for(int j = 0 ; j<minibab.length; j++){
                
                babbling[i] += minibab[j];
                
            }
            
            recheck="";
            
            }
            
        }
        int cnum = 0;
        
        for(int i = 0; i<babbling.length ; i++){
            
            if(babbling[i].isBlank()){
                
                answer++;
                
            }
            
        }
        
        
        return answer;
    }
}

class sol2 {
    
    public int sol2(String[] babblings) {
        int answer = 0;
        String[] bab = {"aya","ye","woo","ma"};
        
        int count = -1;
        
        for(int i = 0 ; i<babblings.length ; i++) {
            
            String[] minibabling = babblings[i].split("");
            
            for(int j = 0; j<bab.length ; j++) {
                
                if(count==j) {
                    
                } else {
                    int len = bab[j].length();
                    String check = bab[j];
                    if(bab[j].length()==2) {
                        
                        for(int k = 0; k<minibabling.length-len+1 ;k++ ) {
                            String recheck = ""+minibabling[k]+minibabling[k+1];
                            if(check.equals(recheck)) {
                                minibabling[k]="";
                                minibabling[k+1]="";
                                count = j;
                                j = -1;
                                break;
                                
                                
                            }
                            
                        }
                        
                    } else {
                        
                        for(int k = 0; k<minibabling.length-len+1 ;k++ ) {
                            String recheck = ""+minibabling[k]+minibabling[k+1]+minibabling[k+2];
                            if(check.equals(recheck)) {
                                minibabling[k]="";
                                minibabling[k+1]="";
                                minibabling[k+2]="";
                                count = j;
                                j = -1;
                                break;
                                
                                
                            }
                            
                        }
                        
                    }
                    
                }
                
                
                
            }
            babblings[i]="";
            for(int j = 0; j<minibabling.length ;j++) {
                
                babblings[i]+=minibabling[j];
                
            }
            
            
        }
        
        for(int i = 0; i<babblings.length;i++) {
            
            if(babblings[i].isBlank()) {
                answer++;
            }
            
        }
        
        
        return answer;
    }
    
}

public class OngAl2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        sol2 sol2 = new sol2();
        
        int a = sol2.sol2(new String[]{"aya", "yee", "u", "maa"});
        System.out.println(a);
    }

}
