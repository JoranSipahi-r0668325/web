//window.onload = function(){ //dit zorgt gewoon dat de functies pas opgeroepen worden als de pagina volledig geladen is
    var selector = document.getElementById("state");
    selector.onchange=function(){
        veranderStatus(selector.value);
    }
    var button = document.getElementById("button");
    button.onclick=function(){
        var text = document.getElementById("buttonfield").value;
        veranderStatus(text);
    }
//}


function updateStatus() {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "Controller?action=ChangeStatus", true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            if (xhr.status == 200) {
                console.log(xhr.responseText)
                var status = JSON.parse(xhr.responseText).status;
                document.getElementById("status").innerHTML = status;
            }
        }
    };
    xhr.send();
}

updateStatus();

function veranderStatus(value){
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "Controller?action=VeranderStatus",true);
    document.getElementById("status").innerHTML = status;
    var info = "userstatus="+encodeURIComponent(value);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(info);
    updateStatus();
    console.log(value);
}