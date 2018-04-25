var DetailApp = {
    init: function () {
        $("#headerbg").load("header.html");
        $("#navigation").load("navigation.html");
        $("#footerbg").load("footer.html");
        this.render();
    },
    render: function () {
        util.hoverNavSmenu();
        this.renderPage();
        this.bind();
    },
    renderPage: function () {
        var url = window.location.search;
        var type = url.split("&")[0].split("=")[1];
        var id = url.split("&")[1].split("=")[1];
        Infos.selectInfoByIdAndType(id, type, function (obj) {
            if (obj.status) {
                var item = obj.data.resultList[0];
                var pre = obj.data.preText[0];
                var next = obj.data.nextText[0];
                $("head title").text(item.title);
                $("head meta[name='keywords']").attr('content', item.keyword);
                $("head meta[name='description']").attr('content', item.note);
                $('.articleCntTitle h1').text(item.title);
                // $('.articleCopyright .origin').text("发布者：" + item.origin);
                $('.articleCopyright .updateTime').text("更新时间：" + util.formatDate(item.updateTime, "yyyy-MM-dd hh:mm:ss"));
                $('.articleDetail').text('【内容提要】' + item.note);
                if(item.coverPic !== null){
                    Pictures.selectPictureById(item.coverPic,function (obj) {
                        $('.articleCoverPic').append('<img alt="" src="images\\'+obj.data.url+'" style="margin: 10px auto; padding: 5px; list-style: none; vertical-align: middle; border: 1px solid rgb(221, 221, 221); border-radius: 3px; box-shadow: rgba(0, 0, 0, 0.15) 0px 0px 8px; background: rgb(251, 251, 251); color: rgb(51, 51, 51); font-family: &quot;Microsoft Yahei&quot;, verdana; font-size: 14px; white-space: normal; width: 266px; height: 266px;">')
                    });
                }
                $('.articleContent').html(item.content);

                if (pre !== undefined) {
                    $('.pre a').attr('href', pre.url).text(pre.title);
                }
                else {
                    $('.pre a').attr('href', "javascript:void(0)").text("没有了");
                }
                if (next !== undefined){
                    $('.next a').attr('href', next.url).text(next.title);
                }else{
                    $('.next a').attr('href', "javascript:void(0)").text("没有了");
                }
            }
        });
        Infos.findInfoNumByVisit(10, type, function (obj) {
            if (obj.status) {
                $('.marketingArticle').html("");
                $.each(obj.data.resultList, function (i, item) {
                    $('.marketingArticle').append("<li><a href='" + item.url + "'>" + item.title + "</a></li>");
                })
            }
        });
        Infos.modifyInfoVisit(id,function (obj) {
            $('.visit').text("浏览次数：" + obj.data);
        })
    },
    bind: function () {
    }
};

var DetailTeamAPP = {
    init: function () {
        $("#headerbg").load("header.html");
        $("#navigation").load("navigation.html");
        $("#footerbg").load("footer.html");
        this.render();
    },
    render: function () {
        util.hoverNavSmenu();
        this.renderPage();
        this.bind();
    },
    renderPage: function () {
        var url = window.location.search;
        var id = url.split("=")[1];
        Projects.getProjectByIdReturnPreNextProj(id, function (obj) {
            if (obj.status) {
                var item = obj.data.resultList[0];
                var pre = obj.data.preText[0];
                var next = obj.data.nextText[0];
                // var note = util.delHtmlTag(item.note);
                // note = note.substring(0,100);
                $("head title").text(item.projName);
                $("head meta[name='keywords']").attr('content',item.keyword);
                $("head meta[name='description']").attr('content', item.note);
                $('.articleCntTitle h1').text(item.projName);
                // $('.articleCopyright .origin').text("发布者：" + item.origin);
                $('.articleCopyright .updateTime').text("更新时间：" + util.formatDate(item.updateTime, "yyyy-MM-dd hh:mm:ss"));
                $('.articleDetail').text('【内容提要】' + item.note);
                if(item.logo !== 119){
                    Pictures.selectPictureById(item.logo,function (obj) {
                        $('.articleCoverPic').append('<img alt="" src="images\\'+obj.data.url+'" style="margin: 10px auto; padding: 5px; list-style: none; vertical-align: middle; border: 1px solid rgb(221, 221, 221); border-radius: 3px; box-shadow: rgba(0, 0, 0, 0.15) 0px 0px 8px; background: rgb(251, 251, 251); color: rgb(51, 51, 51); font-family: &quot;Microsoft Yahei&quot;, verdana; font-size: 14px; white-space: normal;height: 150px;">')
                    });
                }
                $('.articleContent').html(item.content);
                if (pre !== undefined) {
                    $('.pre a').attr('href', pre.projUrl).text(pre.projName);
                }
                else {
                    $('.pre a').attr('href', "javascript:void(0)").text("没有了");
                }
                if (next !== undefined){
                    $('.next a').attr('href', next.projUrl).text(next.projName);
                }else{
                    $('.next a').attr('href', "javascript:void(0)").text("没有了");
                }

            }
        });
        Projects.findProjectNumByVisit(10, function (obj) {
            if (obj.status) {
                $('.marketingArticle').html("");
                $.each(obj.data, function (i, item) {
                    $('.marketingArticle').append("<li><a href='" + item.projUrl + "'>" + item.projName  + "</a></li>");
                })
            }
        });
        Projects.modifyProjectVisit(id, function (obj) {
            $('.visit').text("浏览次数：" + obj.data);
        })
    },
    bind: function () {
    }
};