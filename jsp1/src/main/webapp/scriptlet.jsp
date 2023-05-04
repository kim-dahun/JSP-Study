<%@page import="com.itwill.jsp1.model.Contact"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSP</title>
        <style>
        .title{
        
            font-size: 200%;
            
        
        }
        
        .subt{
        
            font-weight: bold;
        
        }
        
        .cont{
        
            background: black;
            color: white;
        
        }
        
        
        </style>
	</head>
	<body>
		<h1>JSP scriptlet 활용</h1>
        <%-- scriptlet:
            JSP 안에서 Java 코드들을 작성하기 위한 태그
            지역 변수 선언, 객체 생성, 메서드 호출, 조건문, 반복문, ...
        
         --%>
         
         <% // 테이블을 작성할 더미 데이터 생성:
             ArrayList<Contact> data = new ArrayList<>(); // 빈 리스트 생성
             for(int i = 0 ; i<10 ; i++){
                 
                 Contact contact = new Contact(i,"김"+i,"010-1234-567"+i, i + "@" + i+1);
                 data.add(contact);
             }
         
         %>
         
         <table>
         <caption>연락처</caption>
         <thead>
            <tr>
                <th>No.</th>
                <th>이름</th>
                <th>전화번호</th>
                <th>이메일</th>
            
            </tr>
         </thead>
            <tbody>
              <%
              for(Contact x : data){
                  
                  out.print("<tr>");
                  out.print("<td>" + x.getId() + "</td>");
                  out.print("<td>" + x.getName() + "</td>");
                  out.print("<td>" + x.getPhone() + "</td>");
                  out.print("<td>" + x.getEmail() + "</td>");
                  out.print("</tr>");
              }
              %>  
            
            </tbody>
         </table>
         
         <hr />
         <h1>scriptlet, expression 활용</h1>
         
         <table>
            <caption>연락처</caption>
            <thead>
                <tr>
                    <th>NO.</th>
                    <th>이름</th>
                    <th>전화번호</th>
                    <th>이메일</th>
                    
                </tr>
            </thead>
            <tbody>
                <%for(Contact c : data){ %>
                 <tr>
                    <td><%= c.getId() %></td>
                    <td><%= c.getName() %></td>
                    <td><%= c.getPhone() %></td>
                    <td><%= c.getEmail() %></td>
                 </tr>
                    
                    
                <% }    
                    %>    
                
            </tbody>
         </table>
         
         <hr />
         
         <%-- ul 만들기 : li은 연락처 리스트의 이름 --%>
         <h2>Unordered List</h2>
         <ul>
            <% for (Contact x : data){ %>
                <li>
                    <%= x.getName() + " / " + x.getPhone() %>
                </li>
         
            <% } %>
         </ul>
         
         
         <hr />
         
         <h2>Descripton List</h2>
         
         <dl>
            <dt class = "title">연락처 ver 0.1</dt>
            <%for (Contact x : data){%>
                <dt class = "subt"><%= x.getId()  + " / " + x.getName() %></dt>
                <dd class = "cont"><%= x.getPhone() + " / " + x.getEmail() %></dd>
                
                
            <% } %>
         
         </dl>
         
	</body>
</html>