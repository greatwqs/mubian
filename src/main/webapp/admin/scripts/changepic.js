
/**
 * 
 * greatwqs create on 2013-04-22
 * 
 */
$ = jQuery;
function changeAuthCode() {
	var num = 	new Date().getTime();
	var rand = Math.round(Math.random() * 10000);
	num = num + rand;
	document.getElementById("vdimgck").src = "/getValidateImage?tag=" + num;
	return false;	
}
