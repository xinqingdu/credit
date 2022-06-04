function beforeSubmit(form) {
    if (form.loginAccount.value == '') {
        layer.msg("请输入登录账号！")
        form.loginAccount.focus();
        return false;
    }
    else if (form.userPassword.value == '') {
        layer.msg("请输入密码！")
        form.userpswd.focus();
        return false;
    }
    else if (form.userPasswordTemp.value == '') {
        layer.msg("请再次输入密码")
        form.userPasswordTemp.focus();
        return false;
    }
    else if (form.userName.value == '') {
        layer.msg("请输入用户名！")
        form.userName.focus();
        return false;
    }
    else if (form.email.value == '') {
        layer.msg("请输入邮箱地址！")
        form.email.focus();
        return false;
    }
    else if (form.telephone.value == '') {
        layer.msg("请输入手机号！")
        form.phoneNum.focus();
        return false;
    }
    else if (form.code.value == '') {
        layer.msg("请输入验证码！")
        form.code.focus();
        return false;
    }else{

    }
}