var IndexApp = {
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
        var self = this;
        Infos.selectInfoByNumAndType(5, 1, function (obj) {
            self.fillList(obj, "activities");
        });
        Infos.selectInfoByNumAndType(5, 2, function (obj) {
            self.fillList(obj, "news");
        });
        Infos.selectInfoByNumAndType(5, 8, function (obj) {
            self.fillList(obj, "policies");
        });
        Infos.selectInfoByNumAndType(5, 3, function (obj) {
            self.fillList(obj, "knowledge");
        });
        Infos.selectInfoByNumAndType(5, 5, function (obj) {
            self.fillList(obj, "alumnus");
        });
        Infos.selectInfoByNumAndType(5, 9, function (obj) {
            self.fillList(obj, "funds");
        });
        Projects.selectProjectsByNum(5, function (obj) {
            if (obj.status) {
                $.each(obj.data, function (i, item) {
                    $('#projects ul')
                        .append("<li><span>" + util.formatDate(item.enterTime, "yyyy-MM-dd") + "</span><a target='_blank' href='"+item.projUrl+"'>" + item.projName + "</a></li>")
                })
            }
        });
        Infos.selectInfoByNumAndType(5, 14, function (obj) {
            // if (obj.status) {
            //     $.each(obj.data.resultList, function (i, item) {
            //         $('#bases ul')
            //             .append("<li class='fl'><a target='_blank' href='"+util.delHtmlTag(item.content)+"'><img src='images\\"+item.picUrl+"' alt='"+item.title+"' width=210 height=45></a></li>")
            //     })
            // }
            self.fillList(obj, "bases");
        });
    },
    bind: function () {
    },
    fillList: function (obj, idName) {
        if (obj.status) {
            $.each(obj.data.resultList, function (i, item) {
                $('#' + idName + ' ul')
                    .append("<li><span>" + util.formatDate(item.releaseTime, "yyyy-MM-dd") + "</span><a target='_blank' href='" + item.url + "'>" + item.title + "</a></li>")
            })
        }
    }
};

