window.onload = function() {
	let resStr = "";
	let res = 0;
	let op = "+";
	updateResStr();

	document.getElementById("btn1").onclick = function() {
		resStr +="1";
		updateResStr();
	}
	document.getElementById("btn0").onclick = function() {
		resStr +="0";
		updateResStr();
	}
	document.getElementById("btnSum").onclick = function() {
		resStr +="+";
		op = "+";
		updateResStr();
	}
	document.getElementById("btnSub").onclick = function() {
		resStr +="-";
		op = "-";
		updateResStr();
	}
	document.getElementById("btnMul").onclick = function() {
		resStr +="*";
		op = "*";
		updateResStr();
	}
	document.getElementById("btnDiv").onclick = function() {
		resStr +="/";
		op = "/";
		updateResStr();
	}
	document.getElementById("btnEql").onclick = function() {
		resStr = calc(resStr);
		op = "+";
		updateResStr();
	}
	document.getElementById("btnClr").onclick = function() {
		resStr ="";
		op = "+";
		updateResStr();
	}
	function updateResStr() {
		document.getElementById("res").innerHTML = resStr;
	}
	function calc(resStr) {
		let RE = /^([01]+)([+|\-|*|/])([01]+)$/g;
		console.log("RE=" + RE);
		let match = RE.exec(resStr);
		let operand1 = parseInt(match[1], 2);
		let operand2 = parseInt(match[3], 2);
		let res = 0;
		switch (match[2]) {
			case "+":
				console.log("+");
				res = operand1 + operand2;
				break;
			case "-":
				console.log("-");
				res = operand1 - operand2;
				break;
			case "*":
				console.log("*");
				res = operand1 * operand2;
				break;
			case "/":
				console.log("/");
				if (operand2 !== 0) {
					res = operand1 / operand2;
				} else {
					res = 0;
				}
				break;
			default:
				break;								
		}
		console.log("result = " + res);
		return res.toString(2);
	}
}