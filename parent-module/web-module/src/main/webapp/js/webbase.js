var BaseApp = {
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
        this.pageSwitch(1, 10);
    },
    renderPage: function () {
        var self = this;
    },
    bind: function () {
    },
    pageSwitch: function (currentPage, pageSize) {
        var num = window.location.search;
        switch (num) {
            case "?num=1":
                $("#crumbs_active")
                    .text("创业沙龙")
                    .attr("href", window.location.href);
                $('#lmenu li').eq(1).attr("id", "active");
                Infos.limitInfosByTypeAndCurrentPageAndPageSize(1, currentPage, pageSize, function (obj) {
                    if (obj.status) {
                        var totalPage = obj.data.totalPage;
                        BaseApp.fillList(obj, "activity");
                        BaseApp.pagePlugin(totalPage ,function (page) {
                            Infos.limitInfosByTypeAndCurrentPageAndPageSize(1,page,pageSize,function (obj) {
                                if (obj.status){
                                    BaseApp.fillList(obj, "activity");
                                }
                            });
                        });
                    }
                });
                break;

            case "?num=2":
                $("#crumbs_active")
                    .text("通知新闻")
                    .attr("href", window.location.href);
                $('#lmenu li').eq(2).attr("id", "active");
                Infos.limitInfosByTypeAndCurrentPageAndPageSize(2, currentPage, pageSize, function (obj) {
                    if (obj.status) {
                        var totalPage = obj.data.totalPage;
                        BaseApp.fillList(obj, "news");
                        BaseApp.pagePlugin(totalPage ,function (page) {
                            Infos.limitInfosByTypeAndCurrentPageAndPageSize(2,page,pageSize,function (obj) {
                                if (obj.status) {
                                    BaseApp.fillList(obj, "news");
                                }
                            });
                        });
                        // BaseApp.pagePlugin(totalPage);
                    }
                });
                // getProjectByPage(1, 10, 2, projectJSON);
                break;

            case "?num=3":
                $("#crumbs_active")
                    .text("创业知识")
                    .attr("href", window.location.href);
                $('#lmenu li').eq(3).attr("id", "active");
                Infos.limitInfosByTypeAndCurrentPageAndPageSize(3, currentPage, pageSize, function (obj) {
                    if (obj.status) {
                        var totalPage = obj.data.totalPage;
                        BaseApp.fillList(obj, "knowledge");
                        // BaseApp.pagePlugin(totalPage);
                        BaseApp.pagePlugin(totalPage ,function (page) {
                            Infos.limitInfosByTypeAndCurrentPageAndPageSize(3,page,pageSize,function (obj) {
                                if (obj.status){
                                    BaseApp.fillList(obj, "knowledge");
                                }
                            });
                        });
                    }
                });
                // getProjectByPage(1, 10, 3, projectJSON);
                break;
        }
    },
    fillList: function (obj, type) {
        $(".news-list ul").html("");
        $.each(obj.data.resultList, function (i, item) {
            $(".news-list ul").append('<li>' +
                '<p class="icon ' + type + '"></p>' +
                '<div class="cnt">' +
                '<h4><a target="_blank" href="' + item.url + '"><b>' + item.title + '</b></a>' +
                '</h4>' +
                // '<p class="source">来源:' + item.origin + '&#160;&#160;日期：' + util.formatDate(item.releaseTime, "yyyy-MM-dd hh:mm:ss") + '&#160;&#160;点击：</small>' + item.visit + '</p>' +
                '<p class="source">日期：' + util.formatDate(item.releaseTime, "yyyy-MM-dd") + '&#160;&#160;点击：</small>' + item.visit + '</p>' +
                '<p class="summary">' + item.note + '</p>' +
                ' <a class="news_more" href="' + item.url + '">详情</a></div>' +
                '</li>');
        });
    },
    pagePlugin: function (totalPage, callback) {
        // $("#paginate").paginate({
        //     count: totalPage,      //totalPage
        //     start: 1,
        //     display: 10,
        //     border: false,
        //     text_color: '#666',
        //     background_color: 'none',
        //     text_hover_color: '#FF6600',
        //     background_hover_color: 'none',
        //     images: false,
        //     mouse: 'press',
        //     onChange: function (page) {
        //         BaseApp.pageSwitch(page, 10);
        //     }
        // });
        $('#paginate').paging({
            initPageNo: 1, // 初始页码
            totalPages: totalPage, //总页数
            // totalCount: '合计' + totalPage + '条数据', // 条目总数
            // slideSpeed: 600, // 缓动速度。单位毫秒
            jump: false, //是否支持跳转
            callback: function (page) { // 回调函数
                callback(page);
                // BaseApp.pageSwitch(page, 1);
            }
        })
    }
};

