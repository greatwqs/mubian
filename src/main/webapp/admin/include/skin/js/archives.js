function viewArc(aid) {
	if (aid == 0)
		aid = getOneItem();
	window.open("archives.asp?aid=" + aid + "&action=viewArchives");
}
function editArc(aid) {
	if (aid == 0)
		aid = getOneItem();
	location = "archives.asp?aid=" + aid + "&action=editArchives";
}
function updateArc(aid) {
	var qstr = getCheckboxItem();
	if (aid == 0)
		aid = getOneItem();
	location = "archives.asp?aid=" + aid + "&action=makeArchives&qstr=" + qstr
			+ "";
}
function checkArc(aid) {
	var qstr = getCheckboxItem();
	if (aid == 0)
		aid = getOneItem();
	location = "archives.asp?aid=" + aid + "&action=checkArchives&qstr=" + qstr
			+ "";
}
function moveArc(aid) {
	var qstr = getCheckboxItem();
	if (aid == 0)
		aid = getOneItem();
	location = "archives.asp?aid=" + aid + "&action=moveArchives&qstr=" + qstr
			+ "";
}
function adArc(aid) {
	var qstr = getCheckboxItem();
	if (aid == 0)
		aid = getOneItem();
	location = "archives.asp?aid=" + aid + "&action=commendArchives&qstr="
			+ qstr + "";
}

/***
 * admin/action.html?action=deletenewss&ids=4-5-3-2
 * add by greatwqs on 2013-05-01
 * @param aid
 * @return
 */
function deleteNewss(aid) {
	var qstr = getCheckboxItem();
	if (aid == 0){
		aid = getOneItem();
	}
	location = "admin/action.html?action=deletenewss&ids="+qstr;
}

/***
 * admin/action.html?action=deleteproducts&ids=4-5-3-2
 * add by greatwqs on 2013-05-01
 * @param aid
 * @return
 */
function deleteProducts(aid) {
	var qstr = getCheckboxItem();
	if (aid == 0){
		aid = getOneItem();
	}
	location = "admin/action.html?action=deleteproducts&ids="+qstr;
}

// 获得选中文件的文件名
function getCheckboxItem() {
	var allSel = "";
	if (document.form2.id.value)
		return document.form2.id.value;
	for (i = 0; i < document.form2.id.length; i++) {
		if (document.form2.id[i].checked) {
			if (allSel == "")
				allSel = document.form2.id[i].value;
			else
				allSel = allSel + "-" + document.form2.id[i].value;
		}
	}
	alert(allSel);
	return allSel;
}

// 获得选中其中一个的id
function getOneItem() {
	var allSel = "";
	if (document.form2.id.value)
		return document.form2.id.value;
	for (i = 0; i < document.form2.id.length; i++) {
		if (document.form2.id[i].checked) {
			allSel = document.form2.id[i].value;
			break;
		}
	}
	return allSel;
}
function selAll() {
	for (i = 0; i < document.form2.id.length; i++) {
		if (!document.form2.id[i].checked) {
			document.form2.id[i].checked = true;
		}
	}
}
function noSelAll() {
	for (i = 0; i < document.form2.id.length; i++) {
		if (document.form2.id[i].checked) {
			document.form2.id[i].checked = false;
		}
	}
}