/**
 * Created by think on 2015/10/29.
 */
$(function(){
    if(checkIE9()){
        $("input[placeholder],textarea[placeholder]").not("input[type='password']").each(function(index, el) {
            $(this).val($(this).attr("placeholder"));
        });
        $("input[placeholder],textarea[placeholder]").not("input[type='password']").focus(function(event) {
            /* Act on the event */
            if($(this).val() == $(this).attr("placeholder"))
                $(this).val("");
        });
        $("input[placeholder],textarea[placeholder]").not("input[type='password']").blur(function(event) {
            /* Act on the event */
            if($(this).val() == ""){
                $(this).val($(this).attr("placeholder"))
            }
        });
    }

    function checkIE9(){
        if(navigator.userAgent.indexOf("MSIE")>0){
            if(navigator.userAgent.indexOf("MSIE 6.0")>0||navigator.userAgent.indexOf("MSIE 7.0")>0||(navigator.userAgent.indexOf("MSIE 9.0")>0 && !window.innerWidth)){
                return true;
            }
            return false;
        }
        return false;
    }
});