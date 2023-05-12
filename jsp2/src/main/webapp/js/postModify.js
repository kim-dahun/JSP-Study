/**
 * Post-Modify.js
 * WEB-INF/post/postModify.jsp
 */

document.addEventListener('DOMContentLoaded',function(){
    
    // id 로 form element 찾기
    const form = document.querySelector('#postModifyForm')
    const id = document.querySelector('input#id')
    const title = document.querySelector('input#title')
    const content = document.querySelector('textarea#content')
    const btnDelete = document.querySelector('#btnDelete')
    
    const btnUpdate = document.querySelector('#btnUpdate')
    
    btnDelete.addEventListener('click',(e)=>
    {
        // -> form 안에 있는 버튼 또는 input(type=submit) 의 기본 동작은
        // 폼의 내용을 서버로 제출(서버로 요청을 보냄)
        // 버튼의 기본동작이 가능하지 않도록 함.
        e.preventDefault();
        
        const inputid = id.value;
        const result = confirm(`NO. ${inputid} 글을 정말 삭제할까요?`);
        console.log(`삭제확인 결과 = ${result}`);
        
        //사용자가 Confirm 창에서 확인을 클릭했을 때
        if(result){
            form.action = 'delete'; // 폼 제출(요청) 주소
            form.method = 'post'; // 요청 방식
            form.submit(); // 폼 제출(요청 보내기)
            alert("삭제되었습니다");
        } 
        
        
        
    })
    
    btnUpdate.addEventListener('click',(e)=>{
            
            e.preventDefault(); // 기본 동작인 form 제출 기능을 막음.
            
            const inputid = id.value;
            const inputtitle = title.value;
            const inputcontent = content.value;
            
            if(inputtitle === '' || inputcontent === ''){
                // 제목 또는 내용이 비어있으면.
                alert('제목과 내용은 반드시 입력해야 합니다.');
                
                return;
            }
            
            const result = confirm(`No${inputid} 포스트를 수정하시겠습니까?`);
            
            if(result){
                
                form.action = 'update'; // 업데이트 요청 주소
                form.method = 'post'; // 요청 방식
                form.submit();
                alert('수정이 완료되었습니다'); // form 제출                
            }
            
        })
    
})

