/**
 * 
 */

document.addEventListener('DOMContentLoaded', function() {

    // Json(JavaScript Object Notation): 자바스크립트에서 객체 표기법.

    // { property : value, ...}

    const person = {

        name: '오쌤',
        age: 16,
        phone: ['010-0000-0000', '02-0000-0000']

        
        
    };
    
    console.log(person); 
    
    // 객체의 property 접근(사용) : (1) 참조 연산자(자바처럼) (2) 인덱스 연산자
    
    console.log(person.name); // person 객체의 name property 값 읽음
    console.log(person['age']); // person 객체의 age property 값 읽음
    console.log(person.phone);
    console.log(person.phone[0]);
    console.log(person['phone'][1]);
    
    // 자바 스크립트 객체는 프로퍼티를 추가할 수 있음.
    
    person.company = 'itwill'; // 기존에 person 객체에 없던 company property 및 값을 등록
    
    console.log(person);
    
    person.name = '홍길동'; // person 객체의 name property 값을 변경.
    
    console.log(person);
    
    // 객체(Object)에서 for-in 구문:
    
    for(let i in person){
        
        console.log(i);
        console.log(person[i]);
        
    }
    
    // 메서드를 갖는 객체:
    const score = {
        
        korean: 100,
        english: 90,
        math:70,
        sum: function(){
            
            return this.korean + this.english + this.math;
            
        },
        mean : function(){
            
            return this.sum()/3;
            
        } 
        
        
    }
    console.log(score);
    console.log(score.sum());
    console.log(score.mean());
    
    // 생성자 함수 : 
    
    function Score(korean, english, math){
        // 필드
        this.korean = korean;
        this.english = english;
        this.math = math;
        
        // 메서드
        this.sum = function () {
            
            return this.korean + this.english + this.math;
            
        };
        
        
        this.mean = function () {
            
            return this.sum() / 3;
            
        };
        
        this.grade = function() {
            
            if(this.mean()>60){
                
                return '합격';
                
            } else {
                
                return '불합격';
            }
            
        };
        
    }
    
    // 생성자 함수 호출 :
    
    const score1 = new Score(77,67,38); // 객체 생성
    
    
    
    console.log(score1); 
    
    console.log('점수가 ' ,score1.mean(),'점이기 때문에',  score1.grade()); // 객체의 메서드 호출
    
    const score2 = new Score(100,78,1);
    
    console.log(score2);
})
