var url = "http://localhost:8080/rest/comment";

var xhr = new XMLHttpRequest();
  xhr.open('GET', url);
  xhr.onreadystatechange = function(){
      if(xhr.readyState === 4 && xhr.status === 200){
        var data = xhr.responseText;
        var comment = JSON.parse(data);


        var url2 = "http://localhost:8080/rest/action";
        var xhr2 = new XMLHttpRequest();
          xhr2.open('GET', url2);
          xhr2.onreadystatechange = function(){
              if(xhr2.readyState === 4 && xhr2.status === 200){
                var data2 = xhr2.responseText;
                var action = JSON.parse(data2);
                var good = new Array();
                var bad = new Array();
                console.log(action);
                for(var i = 0; i < action.length; i++){
                    if(action[i].type == 1){
                        var temp = action[i].comment.commentId;
                        if(good[temp]==null) good[temp]=0;
                        good[temp] = good[temp] + 1;
                        console.log(action[i].comment.commentId);
                        console.log(good[temp]);
                    }else{
                        var temp = action[i].comment.commentId;
                        if(bad[temp]==null) bad[temp]=0;
                        bad[temp] = bad[temp] + 1;
                        console.log(action[i].comment.commentId);
                        console.log(bad[temp]);
                    }
                }
                //---------------------------- 좋아요 반대 갯수---------------------------


                var comments = document.querySelector('#comments');
                var user = document.querySelector('#user');

                for(var i=0; i < 10; i++){
                    if(comment[i].user.userId === user.value){
                    comments.innerHTML += "<tr><td>"+comment[i].user.image+"</td>"+
                                                          "<td>"+comment[i].user.userId+"</td>"+
                                                          "<td>"+comment[i].content+"</td>"+
                                                          "<td>좋아요("+good[comment[i].commentId]+")</td>"+
                                                          "<td>싫어요("+bad[comment[i].commentId]+")</td>"+
                                                          "<td><a href=../comment/delete/"+comment[i].commentId+">삭제</a></td>"+
                                                          "<td>"+comment[i].date+"</td>"+
                                                          "</tr>";
                    }else{
                        comments.innerHTML += "<tr><td>"+comment[i].user.image+"</td>"+
                                                          "<td>"+comment[i].user.userId+"</td>"+
                                                          "<td>"+comment[i].content+"</td>"+
                                                          "<td>좋아요("+good[comment[i].commentId]+")</td>"+
                                                          "<td>싫어요("+bad[comment[i].commentId]+")</td>"+
                                                          "<td></td>"+
                                                          "<td>"+comment[i].date+"</td>"+
                                                          "</tr>";
                    }

                }

                }
           }
           xhr2.send();







        }
    }
  xhr.send();