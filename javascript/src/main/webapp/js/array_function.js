/**
 * 08_function.html
 * 
 * 
 */

 
 document.addEventListener('DOMContentLoaded', function(){
     
     const numbers = [1,2,3,4,5,6,7];
     
     
     
     const result = document.getElementById('result');
     const result1 = document.getElementById('first');
     const result2 = document.getElementById('second');
     const result3 = document.getElementById('third');
     // 1. 배열 numbers의 원소들 중에서 홀수들만 원소로 갖는 배열을 만들고 출력(콘솔).
     result1.addEventListener('click',function(){
         let html = '';
         let numbers2 = [];
         for(let i = 0 ; i<numbers.length ; i++){
             
             if(numbers[i]%2==1){
                 
                 numbers2 = numbers2.concat(numbers[i]);
                 html = numbers2 + ' ';
                 
             }
             
         }
         
         result.innerHTML += html + '<hr />';
         console.log(numbers2);
         
     });
     
     let numbers2 = numbers.filter((x)=>x%2);
     console.log(numbers2);
     
     // 2. 배열 numbers의 원소들을 제곱한 숫자들을 원소로 갖는 배열을 만들고 출력(콘솔).
     
     result2.addEventListener('click',function(){
         html = '';
         let numbers2 = [];
         for(let i in numbers){
             
             ;
             numbers2 = numbers2.concat(numbers[i]*numbers[i]);
             // numbers2 = numbers2.concat(numbers[i]**2); => ** 거듭제곱 연산자
                 html = numbers2 + ' ';
         }
         result.innerHTML += html + '<hr />';
         console.log(numbers2);
     });
     
     
     let squares = numbers.map((x)=>x ** 2);
     console.log(squares);
     
     
     // 3. 배열 numbers의 원소들 중에서 홀수의 제곱을 원소로 갖는 배열을 만들고 출력. 
     result3.addEventListener('click',function(){
         html='';
         let numbers2 = [];
         for(let i of numbers){
             if(i%2==1){
             numbers2 = numbers2.concat(i*i);
              html = numbers2;
             }
             
         }
         result.innerHTML += html + '<hr />';
         console.log(html);
         
     });
     
     let squaresNum = numbers.filter((x)=>x%2).map((x)=>x**2);
     console.log(squaresNum);
     
     
     // 배열 concat() : 배열에 새로운 원소를 끝에 추가. 원소가 추가된 새로운 배열을 리턴.
     // 배열 push() : 기존 배열의 끝에 원소를 추가. 리턴값은 없음.
       
 });