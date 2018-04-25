var ProjectsApp = {
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
        Projects.limitProjectsByCurrentPageAndPageSize(1, 10, function (obj) {
            if (obj.status) {
                var totalPage = obj.data.totalPage;
                ProjectsApp.fillList(obj);
                ProjectsApp.pagePlugin(totalPage, function (page) {
                    Projects.limitProjectsByCurrentPageAndPageSize(page, 10, ProjectsApp.fillList);
                });
            }
        });
        Projects.findProjectNumByVisit(10, function (obj) {
            if (obj.status) {
                $('.hot_news_list').html("");
                $.each(obj.data,  function (i, item) {
                    $('.hot_news_list').append("<li><a href='"+item.projUrl+"'>"+item.projName+"</a></li>");
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
            // var note = util.delHtmlTag(item.note);
            // note = note.substring(0,100);
            $(".news-list ul").append('<li>' +
                '<p class="img">' +
                '<a href="'+item.projUrl+'" target="_blank" class="subCaseImg">' +
                '<img src="images\\' + item.picUrl + '" alt="' + item.projName + '" width=120 height=120 />' +
                '</a></p>' +
                '<div class="cnt">' +
                '<h4><a target="_blank" href="'+item.projUrl+'"><b>' + item.projName + '</b></a></h4>' +
                // '<p class="source">浏览次数：' + item.visit + ' &nbsp;|&nbsp;' + util.formatDate(item.enterTime, "yyyy-MM-dd hh:mm:ss") + '</p>' +
                '<p class="source">日期：' + util.formatDate(item.enterTime, "yyyy-MM-dd") + '&#160;&#160;点击：</small>' + item.visit + '</p>' +
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
        postObj.projName = searchText;
        postObj.companyName = searchText;
        // arr.push(obj);
        console.log(JSON.stringify(postObj));
        Projects.searchProjectByProjNameOrCompanyName(JSON.stringify(postObj), 1, 10, function (obj) {
            if (obj.status) {
                var totalPage = obj.data.totalPage;
                ProjectsApp.fillList(obj);
                ProjectsApp.pagePlugin(totalPage, function (page) {
                    Projects.searchProjectByProjNameOrCompanyName(JSON.stringify(postObj), page, 10, ProjectsApp.fillList);
                });
            }
        })
    }
    // pagePlugin: function (totalPage) {
    //     $("#paginate").paginate({
    //         count: totalPage,      //totalPage
    //         start: 1,
    //         display: 10,
    //         border: false,
    //         text_color: '#666',
    //         background_color: 'none',
    //         text_hover_color: '#FF6600',
    //         background_hover_color: 'none',
    //         images: false,
    //         mouse: 'press',
    //         onChange: function (page) {
    //             Projects.limitProjectsByCurrentPageAndPageSize(page, 10, ProjectsApp.fillList);
    //         }
    //     });
    // }
};