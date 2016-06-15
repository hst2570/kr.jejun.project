var url = "http://localhost:8080/rest/comment";
console.log("hello");
var xhr = new XMLHttpRequest();
  xhr.open('GET', url);
  xhr.onreadystatechange = function(){
      if(xhr.readyState === 4 && xhr.status === 200){
        var data = xhr.responseText;
        var comment = JSON.parse(data);

        var good = new Array();
        var bad = new Array();
        for(var i = 0; i < comment.length; i++){
            good[comment[i].commentId] = 0;
            bad[comment[i].commentId] = 0;
        }

        var url2 = "http://localhost:8080/rest/action";
        var xhr2 = new XMLHttpRequest();
          xhr2.open('GET', url2);
          xhr2.onreadystatechange = function(){
              if(xhr2.readyState === 4 && xhr2.status === 200){
                var data2 = xhr2.responseText;
                var action = JSON.parse(data2);

                for(var i = 0; i < action.length; i++){
                    if(action[i].type == 1){
                        var temp = action[i].commentId; // 해당되는 코멘트 id를 받아옴
//                        if(good[temp]==null) good[temp]=0; // 초기화부분
                        good[temp] = good[temp] + 1; // 카운트
                    }else{
                        var temp = action[i].commentId;
//                        if(bad[temp]==null) bad[temp]=0;
                        bad[temp] = bad[temp] + 1;
                    }
                }
                //---------------------------- 좋아요 반대 갯수---------------------------


                var comments = document.querySelector('#comments');
                var user = document.querySelector('#user');

                for(var i=0; i < 10; i++){
                    if(comment[i].user.userId === user.value){
                    comments.innerHTML += "<tr><td><img src="+comment[i].user.image+" width=100 height=100></td>"+
                                                          "<td>"+comment[i].user.userId+"</td>"+
                                                          "<td>"+comment[i].content+"</td>"+
                                                          "<td><a href=../action/1/"+user.value+"/"+comment[i].commentId+">좋아요("+good[comment[i].commentId]+")</a></td>"+
                                                          "<td><a href=../action/0/"+user.value+"/"+comment[i].commentId+">싫어요("+bad[comment[i].commentId]+")</a></td>"+
                                                          "<td><a href=../comment/delete/"+comment[i].commentId+">삭제</a></td>"+
                                                          "<td>"+comment[i].date+"</td>"+
                                                          "</tr>";
                    }else{
                        comments.innerHTML += "<tr><td><img src="+comment[i].user.image+" width=100 height=100></td>"+
                                                          "<td>"+comment[i].user.userId+"</td>"+
                                                          "<td>"+comment[i].content+"</td>"+
                                                          "<td><a href=../action/1/"+user.value+"/"+comment[i].commentId+">좋아요("+good[comment[i].commentId]+")</a></td>"+
                                                          "<td><a href=../action/0/"+user.value+"/"+comment[i].commentId+">싫어요("+bad[comment[i].commentId]+")</a></td>"+
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