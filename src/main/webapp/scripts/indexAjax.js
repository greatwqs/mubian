/*!
 * greatwqs create on 2013-05-03
 * for index.jsp images tab.
 */

/***
 * XMLHttpRequest对象
 */
var xmlHttpRequestObj;

/***
 * 第一次访问, 相当于刷新首页.
 * @return
 */
function index_ajax_first_visit() {
	/**
	 * 加个random,AJAX调用第一次正常，第二次不执行BUG:
	 * http://wenwen.soso.com/z/q282318228.htm
	 */
	var randomt = new Date().getTime();
	var url = "indexAjax.html?page=1&random="+randomt;
	if (window.XMLHttpRequest != null) {
		xmlHttpRequestObj = new XMLHttpRequest();
	} else {
		if (window.ActiveXObject) {
			// 针对IE浏览器
			try {
				for ( var i = 5; i; i--) {
					if (i == 2) {
						xmlHttpRequestObj = new ActiveXObject("Microsoft.XMLHTTP");
					} else {
						xmlHttpRequestObj = new ActiveXObject("Msxml2.XMLHTTP." + i + ".0");
					}
				}
			} catch (e) {
			}
		}
	}
	if (xmlHttpRequestObj) {
		xmlHttpRequestObj.onreadystatechange = showContents;
		xmlHttpRequestObj.open("GET", url, true);
		xmlHttpRequestObj.send(null);
	} else {
		document.getElementById("message").innerHTML = "sorry ! but your pc coundn't create a xhr object !";
	}
}

/***
 * 上一页
 * @return
 */
function previouspage() {
	var indexPage = document.getElementById("pre_ajax_page").value;
	var url = "indexAjax.html?page=" + indexPage;
	if (window.XMLHttpRequest != null) {
		xmlHttpRequestObj = new XMLHttpRequest();
	} else {
		if (window.ActiveXObject) {
			// 针对IE浏览器
			try {
				for ( var i = 5; i; i--) {
					if (i == 2) {
						xmlHttpRequestObj = new ActiveXObject("Microsoft.XMLHTTP");
					} else {
						xmlHttpRequestObj = new ActiveXObject("Msxml2.XMLHTTP." + i + ".0");
					}
				}
			} catch (e) {
			}
		}
	}
	if (xmlHttpRequestObj) {
		xmlHttpRequestObj.onreadystatechange = showContents;
		xmlHttpRequestObj.open("GET", url, true);
		xmlHttpRequestObj.send(null);
	} else {
		document.getElementById("message").innerHTML = "sorry ! but your pc coundn't create a xhr object !";
	}
}

/**
 * 下一页
 * @return
 */
function nextpage() {
	var indexPage = document.getElementById("next_ajax_page").value;
	var url = "indexAjax.html?page=" + indexPage;
	if (window.XMLHttpRequest != null) {
		xmlHttpRequestObj = new XMLHttpRequest();
	} else {
		if (window.ActiveXObject) {
			// 针对IE浏览器
			try {
				for ( var i = 5; i; i--) {
					if (i == 2) {
						xmlHttpRequestObj = new ActiveXObject("Microsoft.XMLHTTP");
					} else {
						xmlHttpRequestObj = new ActiveXObject("Msxml2.XMLHTTP." + i + ".0");
					}
				}
			} catch (e) {
			}
		}
	}
	if (xmlHttpRequestObj) {
		xmlHttpRequestObj.onreadystatechange = showContents;
		xmlHttpRequestObj.open("GET", url, true);
		xmlHttpRequestObj.send(null);
	} else {
		alert("sorry ! but your pc coundn't create a xhr object !");
	}
}

/**
 * 响应结果.
 * @return
 */
function showContents() {
	if (xmlHttpRequestObj.readyState == 4) {
		if (xmlHttpRequestObj.status == 200) {
			var returnHtml = null;
			try {
				returnHtml = xmlHttpRequestObj.responseText;
			} catch (e) {
			}
			if (returnHtml == "NONE") {
				document.getElementById("product_img_list").innerHTML = "<font color=green><strong>网络错误! </strong></font>";
			} else {
				document.getElementById("product_img_list").innerHTML = returnHtml;
			}
		} else {
			var outMsg = "there was a problem on your server : status = " + status;
		}
	}
}