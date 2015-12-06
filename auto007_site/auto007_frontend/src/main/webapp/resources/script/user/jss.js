/**
 * Created by think on 2015/11/1.
 */
$(document).ready(function(){
    $(".widtha_xg_ul li").click(function(){
        $(this).addClass("hover").siblings().removeClass("hover");
    });
    $("#mobile").blur(function(event) {
        if($(this).val() == ""){
            $("#errormobile").html("手机号码不能为空");
            return false;
        }
        var re = /^1{1}[34578]{1}[0-9]{9}$/;
        if(!re.test($(this).val())){
            $("#errormobile").html("手机号码格式不正确");
            return false;
        }else{
            $("#errormobile").html("");
        }
    });
    $("#code").blur(function(event) {
        if($(this).val() == ""){
            $("#codeerror").html("验证码不能为空");
            return false;
        }
        var re = /^[0-9]{4}$/;
        if(!re.test($(this).val())){
            $("#codeerror").html("验证码格式不正确");
            return false;
        }else{
            $("#codeerror").html("");
            return false;
        }
    });
    $("#btnMobile").bind('click',function(event) {
        var mobileobj = $("#mobile");
        var codeobj = $("#code");
        var re = /^1{1}[34578]{1}[0-9]{9}$/;
        if(codeobj.val() == ""){
            $("#codeerror").html("验证码不能为空");
            return false;
        }
        if(!re.test(mobileobj.val())){
            $("#errormobile").html("手机号码格式不正确");
            return false;
        }
        var re = /^[0-9]{4}$/;
        if(!re.test(codeobj.val())){
            $("#codeerror").html("验证码格式不正确");
            return false;
        }
        $.ajax({
            url: siteurl + 'passport/forget_pwd/mobile',
            type: 'POST',
            dataType: 'json',
            data: {regPhone:mobileobj.val(),phoneCode:codeobj.val()}
        })
            .done(function(data) {
                if(data.meta.code == "0"){
                    if(data.meta.error == " 手机不存在 "){
                        showMsg("对不起，该手机尚未注册,<br />现在 <a href='"+siteurl+"passport/register'>注册</a>",0);
                        return false;
                    }else{
                        showMsg(data.meta.error,0);
                        return false;
                    }
                }else{
                    window.location.href = siteurl + 'passport/forget_pwd/reset?type=1&token='+data.meta.token;
                    return false;
                }
            })
    });
    getMobileCode(60);
});
function onEmailBlur(obj)
{
    if(obj.val() == ""){
        $("#emailError").html("邮箱地址不能为空");
        $('#btnEmail').attr('disabled','disabled');
        return false;
    }
    var re = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if(!re.test(obj.val()))
    {
        $('#emailError').html('邮箱格式不正确');
        $('#btnEmail').attr('disabled','disabled');
    }
    else
    {
        $('#emailError').html('');
        $('#btnEmail').removeAttr('disabled');
    }
}
function onEmailClick()
{
    var obj = $("#email");
    var re = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if(!re.test(obj.val()))
    {
        $('#emailError').html('邮箱格式不正确');
        $('#btnEmail').attr('disabled','disabled');
    }
    else
    {
        $.ajax({
            url:siteurl + 'passport/forget_pwd/email',
            type:'post',
            async:true,
            data:{email:obj.val()},
            dataType:'json',
            error:function(){/*alert("Error loading PHP document");*/},
            success:function(data){
                if(data.meta.code == "0"){
                    if(data.meta.error == " 邮箱不存在 "){
                        showMsg("对不起，该帐号不存在,<br />现在 <a href='"+siteurl+"passport/register'>注册</a>",0);
                        return false;
                    }else{
                        showMsg(data.meta.error,0);
                        return false;
                    }
                    // showMsg($("#userName"),2,"对不起，该帐号不存在,现在 <a href='registration'>注册</a>")
                }else{
                    window.location.href = siteurl + 'passport/forget_pwd/send_email?email='+data.meta.email;
                }
            }
        })
    }
}
function getMobileCode (setNum) {
    var mobileobj = $("#mobile");
    $("#getMobile").bind('click', function(event) {
        var re = /^1{1}[34578]{1}[0-9]{9}$/;
        if(!re.test(mobileobj.val())){
            $("#errormobile").html("手机号码格式不正确");
            return false;
        }
        $.ajax({
            url:siteurl+"passport/forget_pwd/x_sms",
            type:'get',
            async:true,
            data:{mobile:mobileobj.val()},
            dataType:'html',
            error:function(){/*alert("Error loading PHP document");*/},
            success:function(data){
                if(data == "0"){
                    showMsg("验证码发送成功,请注意查收");
                    $("#getMobile").unbind('click');
                    setBUTinfo(setNum);
                }else{
                    showMsg("验证码发送失败，请稍后重试","0");
                }
            }
        })
    });
}

//设置发送手机验证码按钮状态
function setBUTinfo(s){
    var but = $("#getMobile");
    but.css({"background-color":"#a7a9a9","width":"90px"});
    s = parseInt(s);
    if(s > 0){
        but.html(s+"秒可重新发送");
        setTimeout("setBUTinfo("+(s-1)+")",1000);
    }else{
        but.html("获取验证码");
        but.css("background-color","#ffbb53");
        getMobileCode(60)
    }
}
