/**
 * 系统配置
 */
var DEBUG_LEVEL = true,
    AJAX_ERR_MSG = "请求失败：";


/**
 * 工具类
 */
(function($){

    /**
     * 表单数据序列化为json
     */
    $.fn.serializeJson=function(){
        var serializeObj={};
        $(this.serializeArray()).each(function(){
            serializeObj[this.name]=this.value;
        });
        return serializeObj;
    };

    /**
     * bootstrap ajaxTab切换
     * tab中的a标签链接必须为tab-content的指向的页面路径
     * @param option
     */
    $.fn.ajaxTab=function(option){
        var _option = $.extend({
            modular:'',//请求模块名称
            cache:true//是否缓存tab-content
        },option);
        out(_option);

        $(this).on('shown.bs.tab', function (e) {
            var target = $(e.target).attr("href") // activated tab
            var _url = _option.modular==='' ? target.substr(1) : _option.modular + '/' + target.substr(1);
            if ( _option.cache ? $(target).is(':empty') : true) {
                $.ajax({
                    type: "GET",
                    url: _url,
                    error: function(data){
                        out(AJAX_ERR_MSG + data);
                    },
                    success: function(data){
                        $(target).html(data);
                    }
                })
            }
        });
    };
})(jQuery);

/**
 * 控制台输出日志
 * @param msg
 * @returns {boolean}
 */
function out(msg){
    if(!DEBUG_LEVEL)
        return false;
    //var object=event.srcElement;
    //console.warn('<'+object.title+'>'+new Date().Format("yyyy-MM-dd hh:mm:ss")+':');
    console.log('↓↓↓↓');
    console.log(msg);
}

/**
 * 日期格式化
 * @param fmt
 * @returns {*}
 * @constructor
 * // 例子：
 * (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
 * (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
 */
Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));

    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

$(function(){
    //工具提示
    $('[data-toggle="tooltip"]').tooltip().on('shown.bs.tooltip', function () {
        var $this = $(this);
        setTimeout(function(){
            $this.tooltip('hide')
        },1000)
    });

    //滚动条
    function initScrollBar(){
        console.log('initScrollBar');
        $('.sky-custom-container').slimScroll({
            color: '#00f',
            size: '10px',
            height: 'auto',
            alwaysVisible: false
        });
    }
    initScrollBar();
    window.onresize=initScrollBar;


    //ajax tab 切换
    $("#indexTabs").ajaxTab({
        modular:'',
        cache:false
    });
});