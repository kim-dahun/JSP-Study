/**
 * function.js
 * 07_function.html에 포함
 */

/*
    JavaScript에서 함수를 선언(정의)하는 방법:
    
    function 함수 이름 ([파라미터 ...]) {
        
        실행 코드;
        
        [return 리턴 값;]
        
    }
    
    - 함수의 리턴타입 선언하지 않음
    - 파리미터를 선언할 때 var, const, let 키워드를 사용하지 않음.
    
    
    
*/
 let number1 = document.getElementById('num1').value;
 let number2 = document.getElementById('num2').value;
 const resultHTML = document.getElementById('result');
 
 function add(num1, num2){
     
     
     return num1 + num2;
     
 }
 
function resmake(num1, num2){
    
    sum = add(parseInt(num1),parseInt(num2));
    resultHTML.innerHTML = sum;
    
}

 
 let result = add(1,2);
 console.log('result = ' + result);
 
 
 
 console.log('hello');
 // argument: 함수를 호출할 때 함수에 전달하는 값
 // parameter : 전달받은 argument를 저장하기 위한 지역 변수. 함수 선언부에서 선언.
 
 
 // 자바스크립트 함수는 파라미터 타입을 검사하지 않음.
 result = add('안녕하세요','HELLO');
 console.log(result);
 
 result = add(10,20,30); // 자바 스크립트 함수는 파라미터 갯수를 검사하지 않음.
 console.log(result);
 
 // 파라미터 선언보다 더 적은 갯수로 argument를 전달하면 전달하지 않는 파라미터값은
 // undefined가 됨.
 result = add(10);
 console.log(result);
 
 // 자바스크립트 함수는 argument 이름의 프로퍼티를 가지고 있음
 // 함수 호출에서 전달하는 모든 값들을 저장하는(배열과 비슷한) 객체.
 
 function test(){
     
     console.log(arguments);
     
 }
 
 test(1);
 test(1, 'hello');
 
 
 /*
    JavaScript 함수의 특징 : 함수는 객체.
    1. 함수는 프로퍼티(property - 자바의 필드) 를 가질 수 있음(예) arguments
    2. 함수는 변수에 저장할 수 있음.
    3. 함수의 argument로 다른 함수를 전달할 수 있음
    4. 함수 내부에서 다른 함수를 선언(정의)할 수 있음.
    5. 함수는 다른 함수를 return 할 수 있음.
    
    
 */

 const plus = add; // 함수는 변수에 저장할 수 있다.
 
 result = plus(100,200); // 변수 plus는 함수가 됨.
 console.log(result);
 
 // 익명 함수 : 이름이 없는 함수.

const minus = function(x,y){
    return x-y;
};
 
 console.log('minus = ', minus(1,2));
 
 // 익명 함수를 선언과 동시에 호출
 result = (function(x,y){
     
     return x/y;
     
 })(1,2);
 
 console.log(result);
 
 // 함수를 arguement로 갖는 함수:
 
 function calculate(x,y,operator){
     
     return operator(x,y);
     
 } 
 
 result = calculate(1,2,add);
 
 console.log(result);
 
 result = calculate(1,2, function(x,y){
     
     return x-y;
     
 })
 
 console.log(result);
 
 
 function increase(n){
     
     function addN(x){
         
         return x+n;
         
     }
     
     return addN; // 함수를 함수 내부에서 만들고 해당 함수를 리턴;
     
 }
 
 const IncreaseTen = increase(10); // increse(n) => return 값은 addN(x) 라는 함수를 리턴함. 해당 함수가 변수에 저장
 console.log(IncreaseTen(100)); // addN 함수의 인수로 100을 전달하여 x+n 리턴값에 따라 (100+10) 이 리턴;
 
 const increaseOne = increase(1);
 console.log(increaseOne(159));
 
 // 화살표 함수(arrow function)
 // (파라미터, ...) => { 실행 코드 ; ...}
 // (파라미터, ...) => 리턴값
 
 const fnAdd = (x, y) => x + y;
 console.log(fnAdd(3,4));
 
 const fnSubtract = (x, y) => {return x-y;}
 console.log(fnSubtract(5,100));
 
 const res = add(add(1,2),add(2,3));
 
 console.log(res);
 
 
 