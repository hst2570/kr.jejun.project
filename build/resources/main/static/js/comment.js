console.log("hello")

var url = "http://localhost:8080/rest/comment";

var xhr = new XMLHttpRequest();
  xhr.open('GET', url);
  xhr.onreadystatechange = function(){
      if(xhr.readyState === 4 && xhr.status === 200){
        var data = xhr.responseText;
        var comment = JSON.parse(data);
        console.log(comment);
        var comments = document.querySelector('#comments');

        for(var i=0; i < 10; i++){
            comments.innerHTML += "<tr><td>"+comment[i].user.image+"</td>"+
                                  "<td>"+comment[i].user.userId+"</td>"+
                                  "<td>"+comment[i].content+"</td>"+
                                  "<td>좋아요! 싫어요!</td>"+
                                  "<td>"+comment[i].date+"</td>"+
                                  "</tr>";
        }
    }
  }
  xhr.send();