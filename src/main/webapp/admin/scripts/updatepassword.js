
/**
 * checkPassword is ok.
 * @return
 */
function checkPassword(){
    var errorPsdStr = "";
    //设置密码的错误的信息
    var password1 = document.getElementsByName("newpassword_1")[0].value;
    var password2 = document.getElementsByName("newpassword_2")[0].value;
    if(password1 == ""){
        errorPsdStr += "密码不能为空! \n";
    }
    if(password1 != ""){
        if(password1.length < 6 || password1.length >16){
            errorPsdStr += "密码长度不在6-16之间! \n";
        }
    }
    if(password1 != ""){
        if(password1.length >= 6 || password1.length <= 16){
            if(password1 != password2){
                errorPsdStr += "两次输入的密码不一致! \n";
            }
        }
    }

    return errorPsdStr;
}

/***
 * greatwqs check password input.
 * @return
 */
function checkInputForm(){
    var errorTotalStr = "";
    errorTotalStr = checkPassword();
    if(errorTotalStr == ""){
        return true;
    }else{
        //弹出错误信息,提交设置为false..
        alert(errorTotalStr);
        return false;
    }
}