<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>


<%--<form action="/file/upload" method="post" enctype="multipart/form-data">--%>
<%--    <input type="file"  name="file"/>--%>
<%--    <input type="submit" value="提交"/>--%>
<%--</form>--%>

<%--    websocket Demo---- user000 <br/>--%>
<%--    <input id="text" type="text"/>--%>
<%--    <button onclick="sen+d()"> Send</button>--%>
<%--    <button onclick="closeWebSocket()"> Close</button>--%>
<%--    <div id="message"></div>--%>


<%--<script type="text/javascript">--%>
<%--    //判断当前浏览器是否支持WebSocket--%>
<%--    if ('WebSocket' in window) {--%>
<%--        websocket = new WebSocket("ws://localhost:8080/lieying/websocket/1");--%>
<%--        console.log("link success")--%>
<%--    } else {--%>
<%--        alert('Not support websocket')--%>
<%--    }--%>

<%--    //连接发生错误的回调方法--%>
<%--    websocket.onerror = function () {--%>
<%--        setMessageInnerHTML("error");--%>
<%--    };--%>

<%--    //连接成功建立的回调方法--%>
<%--    websocket.onopen = function (event) {--%>
<%--        setMessageInnerHTML("open");--%>
<%--    }--%>
<%--    console.log("-----")--%>
<%--    //接收到消息的回调方法--%>
<%--    websocket.onmessage = function (event) {--%>
<%--        setMessageInnerHTML(event.data);--%>
<%--    }--%>

<%--    //连接关闭的回调方法--%>
<%--    websocket.onclose = function () {--%>
<%--        setMessageInnerHTML("close");--%>
<%--    }--%>

<%--    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。--%>
<%--    window.onbeforeunload = function () {--%>
<%--        websocket.close();--%>
<%--    }--%>

<%--    //将消息显示在网页上--%>
<%--    function setMessageInnerHTML(innerHTML) {--%>
<%--        document.getElementById('message').innerHTML += innerHTML + '<br/>';--%>
<%--    }--%>

<%--    //关闭连接--%>
<%--    function closeWebSocket() {--%>
<%--        websocket.close();--%>
<%--    }--%>

<%--    //发送消息--%>
<%--    function send() {--%>
<%--        var message = document.getElementById('text').value;--%>
<%--        websocket.send(message);--%>
<%--    }--%>
<%--</script>--%>

</body>
</html>
