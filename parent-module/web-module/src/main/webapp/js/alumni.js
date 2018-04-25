var AlumnusApp = {
    init: function () {
        $("#headerbg").load("header.html");
        $("#navigation").load("navigation.html");
        $("#footerbg").load("footer.html");
        this.render();
    },
    render: function () {
        util.hoverNavSmenu();
        this.getData();
        this.bind();
    },
    getData: function () {
        var self = this;
        Infos.limitInfosByTypeAndCurrentPageAndPageSize(5, 1, 10, function (obj) {
            if (obj.status) {
                var totalPage = obj.data.totalPage;
                AlumnusApp.fillList(obj);
                AlumnusApp.pagePlugin(totalPage, function (page) {
                    Infos.limitInfosByTypeAndCurrentPageAndPageSize(5, page, 10, AlumnusApp.fillList)
                });
            }
        });
        Infos.findInfoNumByVisit(10, 5, function (obj) {
            if (obj.status) {
                $('.hot_news_list').html("");
                $.each(obj.data.resultList, function (i, item) {
                    $('.hot_news_list').append("<li><a href='" + item.url + "'>" + item.title + "</a></li>");
                })
            }
        })
    },
    renderPage: function () {
        var self = this;
    },
    bind: function () {
    },
    fillList: function (obj) {
        $(".news-list ul").html("");
        $.each(obj.data.resultList, function (i, item) {
            $(".news-list ul").append('<li>' +
                '<p class="img">' +
                '<a href="' + item.url + '" target="_blank" class="subCaseImg">' +
                '<img src="images\\' + item.picUrl + '" alt="' + item.title + '" width=120 height=120 />' +
                '</a></p>' +
                '<div class="cnt">' +
                '<h4><a target="_blank" href="' + item.url + '"><b>' + item.title + '</b></a></h4>' +
                '<p class="source">日期：' + util.formatDate(item.releaseTime, "yyyy-MM-dd") + '&#160;&#160;点击：</small>' + item.visit + '</p>' +
                // '<p class="source">浏览次数：' + item.visit + ' &nbsp;|&nbsp;' + util.formatDate(item.releaseTime, "yyyy-MM-dd hh:mm:ss") + '</p>' +
                '<p class="summary">' + item.note + '</p>' +
                '</div>' +
                '</li>');
        });
    },
    pagePlugin: function (totalPage, callback) {
        $('#paginate').paging({
            initPageNo: 1, // 初始页码
            totalPages: totalPage, //总页数
            // totalCount: '合计' + totalPage + '条数据', // 条目总数
            slideSpeed: 600, // 缓动速度。单位毫秒
            jump: false, //是否支持跳转
            callback: function (page) { // 回调函数
                callback(page);
            }
        })
    },
    sureSearch: function () {
        var searchText = $('.form-control').val();
        var postObj = {},
            arr = [];
        postObj.title = searchText;
        postObj.note = searchText;
        // arr.push(obj);
        console.log(JSON.stringify(postObj));
        Infos.searchInfosByTitleOrNote(JSON.stringify(postObj), 5, 1, 10, function (obj) {
            if (obj.status) {
                var totalPage = obj.data.totalPage;
                AlumnusApp.fillList(obj);
                AlumnusApp.pagePlugin(totalPage, function (page) {
                    Infos.searchInfosByTitleOrNote(JSON.stringify(postObj), 5, page, 10, AlumnusApp.fillList);
                });
            }
        })
    }
};