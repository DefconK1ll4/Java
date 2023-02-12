let client = null;
let msgItem = null;
let msgList = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if(connected) {
        $("#msgContainer").show();
    } else {
        $("#msgContainer").hide();
    }
    $("#msgItem").html("");
}
function connect() {
    let sock = new SockJS("http://localhost:8080/ws");
    client = Stomp.over(sock);
    client.connect({}, frame => {
        setConnected(true);
        console.log('Connected: ' + frame);
        client.subscribe('/sub/channels', payload => {
            const msgList = document.querySelector('.message-list');
            const msgItem = document.createElement('li');
            msgItem.textContent = payload.body;
            msgList.appendChild(msgItem);
        });
    });
}

function disconnect() {
    if(client !== null) {
        client.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

$(function() {
    $("#connect").click(function () { connect();});
    $("#disconnect").click(function () { disconnect();});
});
