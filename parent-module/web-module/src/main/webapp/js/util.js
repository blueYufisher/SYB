var util = {
    init: function () {
        $("#navigation").load("navigation.html");
        this.render();
    },
    render: function () {
        this.bind();
        this.hoverNavSmenu();
    },
    bind: function () {
    },
    hoverNavSmenu: function () {
        var $nav = $("#navigation");
        $nav
            .on('mouseenter', '.p_menu', function () {
                $(this).find('.smenu').removeClass("disappear");
            })
            .on('mouseleave', '.p_menu', function () {
                $(this).find('.smenu').addClass("disappear");
            });
    },
    writeCookie: function (name, value, days) {
        //向cookie写入数据
        // 定义有效日期（cookie的有效时间）
        var expires = "";
        // 为有效日期赋值
        if (days) {
            var date = new Date();
            //设置有效期（当前时间+时间段）
            date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));//时间段为毫秒数
            expires = "; expires=" + date.toGMTString();
        }
        // 给cookie赋值 name, value和expiration date（有效期）
        document.cookie = name + "=" + value + expires + "; path=/";
    },
    readCookie: function (name) {
        //读取cookie数据
        var searchName = name + "=";
        var cookies = document.cookie.split(';');
        for (var i = 0; i < cookies.length; i++) {
            var c = cookies[i];
            while (c.charAt(0) == ' ')
                c = c.substring(1, c.length);
            if (c.indexOf(searchName) == 0)
                return c.substring(searchName.length, c.length);
        }
        return null;
    },
    eraseCookie: function (name) {
        this.writeCookie(name, "", -1);
    },
    writeCache: function (key, value) {
        //存储，IE6~7 cookie 其他浏览器HTML5本地存储
        if (window.sessionStorage) {
            sessionStorage.setItem(key, value);
            // util.writeCookie("WorkerData", JSON.stringify(self.WorkerData));
        } else {
            util.writeCookie(key, value);
        }
    },
    converDate: function (date) {
        if (date == null) {
            return ' '
        } else {
            //json的时间格式进行拼接
            var year = new Date(date).getFullYear();
            var month = "0" + (new Date(date).getMonth() + 1);
            var day = "0" + new Date(date).getDate();
            var hour = new Date(date).getHours();
            var minutes = new Date(date).getMinutes();
            var sec = new Date(date).getSeconds();
            return year + "-" + month.substring(month.length - 2) + "-" + day.substring(day.length - 2) + " " + hour + ":" + minutes + ":" + sec;
        }
    },
    convertDateToJsonDate: function (strDate) {
        //时间格式转换为Json的时间格式
        var t = new Date(strDate);
        return t.getTime();
    },
    formatDate: function (v, format) {
        /**
         格式化时间显示方式、用法:format="yyyy-MM-dd hh:mm:ss";
         */
        if (!v) return "";
        var d = new Date(v);
        if (typeof v === 'string') {
            if (v.indexOf("/Date(") > -1)
                d = new Date(parseInt(v.replace("/Date(", "").replace(")/", ""), 10));
            else
                d = new Date(Date.parse(v.replace(/-/g, "/").replace("T", " ").split(".")[0]));//.split(".")[0] 用来处理出现毫秒的情况，截取掉.xxx，否则会出错
        }
        var o = {
            "M+": d.getMonth() + 1,  //month
            "d+": d.getDate(),       //day
            "h+": d.getHours(),      //hour
            "m+": d.getMinutes(),    //minute
            "s+": d.getSeconds(),    //second
            "q+": Math.floor((d.getMonth() + 3) / 3),  //quarter
            "S": d.getMilliseconds() //millisecond
        };
        if (/(y+)/.test(format)) {
            format = format.replace(RegExp.$1, (d.getFullYear() + "").substr(4 - RegExp.$1.length));
        }
        for (var k in o) {
            if (new RegExp("(" + k + ")").test(format)) {
                format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
            }
        }
        return format;
    },
    typeByEnter: function (event, type, callback) {
        //通过回车输入
        var keyCode = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;       //处理兼容性问题
        $("input[name='" + type + "']").bind('input propertychange', function () {
            // $("input[name='sure']").attr("value", $(this).val());
        });
        if (keyCode == "13") {
            callback();
        }
    },
    typeByClick: function (callback) {
        //通过点击输入
        // $("input[name='"+type+"']").bind('input propertychange', function () {
        //     // $("input[name='sure']").attr("value", $(this).val());
        // });
        callback();
    },
    delHtmlTag: function (str) {
        return str.replace(/<[^>]+>/g, "");//去掉所有的html标记
    }
};

var Nav = {
    init: function () {
        this.render();
    },
    render: function () {
        this.bind();
        this.onClickNav();
    },
    bind: function () {
        $("#smoothmenu1 ul li")
            .on('click', function () {
                var index = $(this).index();
                util.writeCache('nav_index', index);
            })
    },
    onClickNav: function () {
        var index = window.sessionStorage ? sessionStorage.getItem("nav_index") : util.readCookie("nav_index");
        var nav1 = $("#smoothmenu1 ul li.p_menu>a");
        for (var i = 0; i < nav1.length; i++) {
            if (i.toString() === index) {
                $(nav1[i]).parent().addClass("sel");
                return;
            }
        }
        $(nav1[0]).parent().addClass("sel");
    }
};
