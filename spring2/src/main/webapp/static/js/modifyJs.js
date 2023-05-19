/**
 * modify.jsp
 */

 document.addEventListener('DOMContentLoaded',function(){
    
    const updatebtn = document.querySelector('#btn_Update');
    const deletebtn = document.querySelector('#btn_Delete');
    const id = document.querySelector('#id');
    const title = document.querySelector('#title');
    const content = document.querySelector('#content');
    const form = document.querySelector('#modifyform');
    
    deletebtn.addEventListener('click',(e)=>{
      console.log('삭제');
      e.preventDefault(); 
        
      const inputid= id.value;  
      
      const result = confirm(`No${inputid} 포스트를 삭제하시겠습니까?`);
      
      if(result){
            
            alert('삭제가 완료되었습니다.');
            form.action='delete';
            form.method='post';
            form.submit();    
        }
        
    })
    
    updatebtn.addEventListener('click',(e) => {
        
        e.preventDefault();
        console.log("들어왔다");
        const inputid = id.value;
        const inputtitle = title.value;
        const inputcontent = content.value;
        
        
        if(inputtitle==='' || inputcontent===''){
            
            alert("제목과 내용은 반드시 입력되어야 합니다.");
            return;
        }
        
        const result = confirm(`No${inputid} 포스트를 수정하시겠습니까?`);
        
        if(result){
            
            alert('수정이 완료되었습니다.');
            form.action='update';
            form.method='post';
            form.submit();    
        }
        
    })
  
     
})