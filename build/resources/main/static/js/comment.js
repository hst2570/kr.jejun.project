function getData(){
    var url = "http://localhost:8080/rest/comment/0";

    var xhr = new XMLHttpRequest();
      xhr.open('GET', url);
      xhr.onreadystatechange = function(){
          if(xhr.readyState === 4 && xhr.status === 200){
            var data = xhr.responseText;
            var comment = JSON.parse(data);
            console.log(comment);
            comment = comment.content
            var good = new Array();
            var bad = new Array();

            for(var i = 0; i < comment.length; i++){ // 좋아요 수 카운트 변수 초기화
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

                    for(var i = 0; i < action.length; i++){ // 카운트
                        if(action[i].type == 1){
                            var temp = action[i].commentId; // 해당되는 코멘트 id를 받아옴
                            good[temp] = good[temp] + 1;
                        }else{
                            var temp = action[i].commentId;
                            bad[temp] = bad[temp] + 1;
                        }
                    }

                    var comments = document.querySelector('#comments');
                    var user = document.querySelector('#user');

                    for(var i = 0; i < comment.length; i++){
                        if(comment[i].user.userId === user.value){
                            comments.innerHTML += "<tr><td><img src="+comment[i].user.image+" width=100 height=100></td>"+
                                                              "<td>"+comment[i].user.name+"</td>"+
                                                              "<td>"+comment[i].content+"</td>"+
                                                              "<td><a href=../action/1/"+user.value+"/"+comment[i].commentId+">좋아요("+good[comment[i].commentId]+")</a></td>"+
                                                              "<td><a href=../action/0/"+user.value+"/"+comment[i].commentId+">싫어요("+bad[comment[i].commentId]+")</a></td>"+
                                                              "<td><a href=../comment/delete/"+comment[i].commentId+">삭제</a></td>"+
                                                              "<td>"+DisplayTime(comment[i].date)+"</td>"+
                                                              "</tr>";
                        }else{
                            comments.innerHTML += "<tr><td><img src="+comment[i].user.image+" width=100 height=100></td>"+
                                                              "<td>"+comment[i].user.name+"</td>"+
                                                              "<td>"+comment[i].content+"</td>"+
                                                              "<td><a href=../action/1/"+user.value+"/"+comment[i].commentId+">좋아요("+good[comment[i].commentId]+")</a></td>"+
                                                              "<td><a href=../action/0/"+user.value+"/"+comment[i].commentId+">싫어요("+bad[comment[i].commentId]+")</a></td>"+
                                                              "<td></td>"+
                                                              "<td>"+DisplayTime(comment[i].date)+"</td>"+
                                                              "</tr>";
                        }

                    }

                    }
               }
               xhr2.send();
            }
        }
      xhr.send();
}

  function DisplayTime(nMSec)
  {
       var x = new Date() - nMSec;
       var second = 1000;

       var temp = ((x/1000)/60);
       if(temp > 1440){
        temp = parseInt((temp/60)/24)+"일 전";
       }else if(temp > 59 && temp < 1440){
        temp = parseInt(temp/60)+"시간 전";
       }else if(temp <= 59){
        temp = parseInt(temp)+"분 전";
       }

       return temp;
 }

getData();
var i = 1;
var pagingButton = document.getElementById('moreData');
pagingButton.addEventListener('click', function(){
  var url = "http://localhost:8080/rest/comment/"+i;
  i++;
  var xhr = new XMLHttpRequest();
    xhr.open('GET', url);
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
          var data = xhr.responseText;
          var commentData = JSON.parse(data);

          comment = commentData.content;

          var good = new Array();
          var bad = new Array();

          for(var i = 0; i < comment.length; i++){ // 좋아요 수 카운트 변수 초기화
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

                  for(var i = 0; i < action.length; i++){ // 카운트
                      if(action[i].type == 1){
                          var temp = action[i].commentId; // 해당되는 코멘트 id를 받아옴
                          good[temp] = good[temp] + 1;
                      }else{
                          var temp = action[i].commentId;
                          bad[temp] = bad[temp] + 1;
                      }
                  }

                  var comments = document.querySelector('#comments');
                  var user = document.querySelector('#user');

                  for(var i = 0; i < comment.length; i++){
                      if(comment[i].user.userId === user.value){
                        comments.innerHTML += "<tr><td><img src="+comment[i].user.image+" width=100 height=100></td>"+
                                                            "<td>"+comment[i].user.name+"</td>"+
                                                            "<td>"+comment[i].content+"</td>"+
                                                            "<td><a href=../action/1/"+user.value+"/"+comment[i].commentId+">좋아요("+good[comment[i].commentId]+")</a></td>"+
                                                            "<td><a href=../action/0/"+user.value+"/"+comment[i].commentId+">싫어요("+bad[comment[i].commentId]+")</a></td>"+
                                                            "<td><a href=../comment/delete/"+comment[i].commentId+">삭제</a></td>"+
                                                            "<td>"+DisplayTime(comment[i].date)+"</td>"+
                                                            "</tr>";
                      }else{
                          comments.innerHTML += "<tr><td><img src="+comment[i].user.image+" width=100 height=100></td>"+
                                                            "<td>"+comment[i].user.name+"</td>"+
                                                            "<td>"+comment[i].content+"</td>"+
                                                            "<td><a href=../action/1/"+user.value+"/"+comment[i].commentId+">좋아요("+good[comment[i].commentId]+")</a></td>"+
                                                            "<td><a href=../action/0/"+user.value+"/"+comment[i].commentId+">싫어요("+bad[comment[i].commentId]+")</a></td>"+
                                                            "<td></td>"+
                                                            "<td>"+DisplayTime(comment[i].date)+"</td>"+
                                                            "</tr>";
                      }

                  }
                  if(commentData.last === true){
                    var element = document.getElementById('moreData');
                    element.parentNode.removeChild(element);
                  }

                  }
             }
             xhr2.send();
          }
      }
    xhr.send();

});