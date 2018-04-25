var GuideApp = {
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
                    .text("团队入驻")
                    .attr("href", window.location.href);
                $('#lmenu li').eq(1).attr("id", "active");
                Infos.limitInfosByTypeAndCurrentPageAndPageSize(10, currentPage, pageSize, function (obj) {
                    if (obj.status) {
                        var totalPage = obj.data.totalPage;
                        GuideApp.fillList(obj, "enter");
                        GuideApp.pagePlugin(totalPage ,function (page) {
                            Infos.limitInfosByTypeAndCurrentPageAndPageSize(10,page,pageSize,function (obj) {
                                if (obj.status){
                                    GuideApp.fillList(obj, "enter");
                                }
                            });
                        });
                    }
                });
                // getProjectByPage(1, 10, 1, projectJSON);
                break;

            case "?num=2":
                $("#crumbs_active")
                    .text("工商财税")
                    .attr("href", window.location.href);
                $('#lmenu li').eq(2).attr("id", "active");
                Infos.limitInfosByTypeAndCurrentPageAndPageSize(12, currentPage, pageSize, function (obj) {
                    if (obj.status) {
                        var totalPage = obj.data.totalPage;
                        GuideApp.fillList(obj, "assess");
                        GuideApp.pagePlugin(totalPage ,function (page) {
                            Infos.limitInfosByTypeAndCurrentPageAndPageSize(12,page,pageSize,function (obj) {
                                if (obj.status){
                                    GuideApp.fillList(obj, "assess");
                                }
                            });
                        });
                    }
                });
                // getProjectByPage(1, 10, 2, projectJSON);
                break;

            case "?num=3":
                $("#crumbs_active")
                    .text("团队管理")
                    .attr("href", window.location.href);
                $('#lmenu li').eq(3).attr("id", "active");
                Infos.limitInfosByTypeAndCurrentPageAndPageSize(11, currentPage, pageSize, function (obj) {
                    if (obj.status) {
                        var totalPage = obj.data.totalPage;
                        GuideApp.fillList(obj, "manage");
                        GuideApp.pagePlugin(totalPage ,function (page) {
                            Infos.limitInfosByTypeAndCurrentPageAndPageSize(11,page,pageSize,function (obj) {
                                if (obj.status){
                                    GuideApp.fillList(obj, "manage");
                                }
                            });
                        });
                    }
                });
                // getProjectByPage(1, 10, 3, projectJSON);
                break;

            case "?num=4":
                $("#crumbs_active")
                    .text("出孵追踪")
                    .attr("href", window.location.href);
                $('#lmenu li').eq(4).attr("id", "active");
                Infos.limitInfosByTypeAndCurrentPageAndPageSize(13, currentPage, pageSize, function (obj) {
                    if (obj.status) {
                        var totalPage = obj.data.totalPage;
                        GuideApp.fillList(obj, "hatch");
                        GuideApp.pagePlugin(totalPage ,function (page) {
                            Infos.limitInfosByTypeAndCurrentPageAndPageSize(11,page,pageSize,function (obj) {
                                if (obj.status){
                                    GuideApp.fillList(obj, "hatch");
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
        //         GuideApp.pageSwitch(page, 10);
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
                // GuideApp.pageSwitch(page, 1);
            }
        })
    }
};

