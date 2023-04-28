/**
 * switch.js
 * 03_switch.html 에 포함.
 */

// DOM : Document Object Model
// DOMContentLoaded: HTML 문서의 모든 요소(element)들이 만들어졌을때 발생하는 이벤트
//(Script를 보통 body 끝자락에 넣는데, 그렇지 않고 위쪽에 넣으려고 하는 경우 해당 리스너를 활용해서
// 모든 요소가 완성된 후 자바스크립트가 실행되도록 해서 오류 발생 억제 )
// 이벤트 처리 함수를 등록.

document.addEventListener('DOMContentLoaded', function() {
    // select#weekday element를 찾음.

    const weekday = document.getElementById('weekday');
    console.log(weekday);

    // div#result element를 찾음.

    const result = document.getElementById('result');
    console.log(result);

    //button 중에서 #btn element를 찾음.
    
    const btn = document.getElementById('btn');
    
    btn.addEventListener('click',printResult);

    function printResult() {

        const value = weekday.value; // select 에서 선택된 값을 읽음.
        switch (value) {


            case 'mon':

            case 'tue':

            case 'wed':

            case 'thu':

            case 'fri':
                result.innerHTML = '학원 출석';
                break;
            case 'sat':
                result.innerHTML = "캠핑";
                break;
            case 'sun':
                result.innerHTML = "휴식";
                break;
            default:
                result.innerHTML = "몰라요";     
           


        }
        
        // javaScript의 switch-case 에서 비교는 === 연산자 비교.
        // Type을 자동 변환하지 않고, Type과 value가 일치하는 case의 문장을 실행.

    }

});


