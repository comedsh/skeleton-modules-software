(function() {

    function changeTab() {
        var children = $('.header-item-box').children();
        children.click(function() {
            //var type = $(this).attr('class');
            children.removeClass('select-item');
            $(this).addClass('select-item');
        });
        children.eq(0).addClass('select-item');
    }

    function bindEvent() {

        inputComponent('#p_userName', function() {
            return /^[\u4E00-\u9FA5\uf900-\ufa2d\w]{1,20}$/.test($('#p_userName').val());
        });
        inputComponent('#p_password', function() {
            return /^[a-zA-Z]\w{6,20}$/.test($('#p_password').val());
        });
        inputComponent('#p_repeat_password', function() {
            var pwd = $('#p_repeat_password').val();
            return /^[a-zA-Z]\w{6,20}$/.test(pwd) && $('#p_password').val() == pwd;
        });
        inputComponent('#p_email', function () {
            if($('#p_email').val() == '') {
                return 'email';
            } else {
                return /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/.test($('#p_email').val());
            }
        });
        inputComponent('#p_msg_code', function() {
            return /^(13[0-9]|14[0-9]|15[0-9]|18[0-9])\d{8}$/.test($('#p_msg_code').val());
        });
        bindGetPhoneNumber();
        checkPhoneNumber();
        checkPicCode();

        function inputComponent(idStr, check) {
            var children = $(idStr).parent().next().children();
            children
                .find('.icon-dark_grey_circle_fail')
                .click(function() {
                    $(idStr).val('');
                    $(idStr).focus();
                });
            $(idStr).on('focus', function() {
                $(this).removeClass().addClass('foucs-input');
                children.css('display', 'none');
                children.eq(0).css('display', 'block');
            }).on('blur', function() {
                if(check() == 'email') {
                    $(this).removeClass().addClass('normal-input');
                    children.css('display', 'none');
                }
                else if(check()) {
                    $(this).removeClass().addClass('success-input');
                    children.css('display', 'none');
                    children.eq(2).css('display', 'block');
                } else {
                    $(this).removeClass().addClass('error-input');
                    children.css('display', 'none');
                    children.eq(1).css('display', 'block');
                }
            });
        }

        function bindGetPhoneNumber() {
            $('#p_get_phone_number').click(function() {
                if (!/^(13[0-9]|15[0|3|6|7|8|9]|18[8|9])\d{8}$/.test($('#p_phone').val())) {
                    $('#p_phone').blur();
                    return ;
                }
                var self = this;
                $(this).attr('disabled', 'disabled');
                var seconds = 5;
                $(self).val(seconds+'秒后获取手机验证码');
                $(self).removeClass().addClass('disable-phone-number-btn');
                var timer = setInterval(function() {
                    seconds--;
                    if(seconds < 1) {
                        clearInterval(timer);
                        $(self).val('获取手机验证码');
                        $(self).removeAttr('disabled');
                        $(self).removeClass().addClass('normal-phone-number-btn');
                    } else {
                        $(self).val(seconds+'秒后获取手机验证码');
                    }
                }, 1000);
            });
        }

        function checkPhoneNumber() {
            $('#p_phone').on('focus', function() {
                $(this).removeClass().addClass('foucs-input');
            }).on('blur', function() {
                var reg = /^(13[0-9]|15[0|3|6|7|8|9]|18[8|9])\d{8}$/;
                if(reg.test($('#p_phone').val())) {
                    $(this).removeClass().addClass('success-input');
                    $('#p_phone').next().removeClass().addClass('success-alert-info');
                    $('#p_phone').next().html('输入正确');
                } else {
                    $(this).removeClass().addClass('error-input');
                    $('#p_phone').next().removeClass().addClass('error-alert-info');
                    $('#p_phone').next().html('请检查输入错误的电话号码');
                }
            });
        }

        function checkPicCode() {
            $('#p_pic_code').on('focus', function() {
                $(this).removeClass().addClass('foucs-input');
            }).on('blur', function() {
                var reg = /^[0-9a-zA-Z]{8}$/;
                if(reg.test($('#p_pic_code').val())) {
                    $(this).removeClass().addClass('success-input');
                    $('#p_pic_code').next().next().removeClass().addClass('success-alert-info');
                    $('#p_pic_code').next().next().html('输入正确');
                } else {
                    $(this).removeClass().addClass('error-input');
                    $('#p_pic_code').next().next().removeClass().addClass('error-alert-info');
                    $('#p_pic_code').next().next().html('验证码的位数不对');
                }
            });
        }
    }

    function validate() {

    }


    changeTab();
    bindEvent();
})();