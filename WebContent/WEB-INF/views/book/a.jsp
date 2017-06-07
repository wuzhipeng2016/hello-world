<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<canvas id="myCanvas" width="200" height="100"></canvas>
<p>
中文
bbb
<h1>从1到给定数值的求和示例</h1>
输入数值:<input type="text" id="num">
<button onclick="calculate()">计算</button>

<script type="text/javascript">
	var c=document.getElementById("myCanvas");
	var cxt=c.getContext("2d");
	cxt.fillStyle="#FF0000";
	cxt.fillRect(0,0,150,75);
</script>

<script type="text/javascript">
// 创建执行运算的线程
var worker = new Worker("js/app/book/SumCalculate.js");
//接收从线程中传出的计算结果
worker.onmessage = function(event) 
{
    //消息文本放置在data属性中,可以是任何JavaScript对象.
    alert("合计值为" + event.data + "。");
};
function calculate() 
{
    var num = parseInt(document.getElementById("num").value, 10);
    //将数值传给线程
    worker.postMessage(num);
}
</script>

</body>
</html>