var url = "http://localhost:8080/rest/comment";

var xhr = new XMLHttpRequest();
  xhr.open('GET', url);
  xhr.onreadystatechange = function(){
      if(xhr.readyState === 4 && xhr.status === 200){
        var data = xhr.responseText;
        var comment = JSON.parse(data);
        console.log(comment);

        var comments = document.querySelector('#comments');
        var user = document.querySelector('#user');

        for(var i=0; i < 10; i++){

            console.log("usre : "+ user.value);
            console.log("comment : "+ comment[i].userId);
            if(comment[i].user.userId === user.value){
            comments.innerHTML += "<tr><td>"+comment[i].user.image+"</td>"+
                                                  "<td>"+comment[i].user.userId+"</td>"+
                                                  "<td>"+comment[i].content+"</td>"+
                                                  "<td>좋아요! 싫어요!삭제!</td>"+
                                                  "<td><a href=../comment/delete/"+comment[i].id+">삭제</a></td>"+
                                                  "<td>"+comment[i].date+"</td>"+
                                                  "</tr>";
            }else{
                comments.innerHTML += "<tr><td>"+comment[i].user.image+"</td>"+
                                                  "<td>"+comment[i].user.userId+"</td>"+
                                                  "<td>"+comment[i].content+"</td>"+
                                                  "<td>좋아요! 싫어요!</td>"+
                                                  "<td>"+comment[i].date+"</td>"+
                                                  "<td></td>"+
                                                  "</tr>";
            }

        }
        }
    }
  xhr.send();