/**
 * Created by BlueFisher on 2017/7/23 0023.
 */

//  var serverURL = window.location.pathname;


/*父接口*/
var Interface = {
    init: function () {
        this.render();
    },
    render: function () {
        this.bind();
    },
    bind: function () {

    },
    /**
     *
     * @param url
     * @param callback
     */
    gainJSON: function (url, callback) {
        $.getJSON(url, function (obj) {
            callback(obj);
        });
    },
    /**
     *
     * @param url
     * @param jsonData
     * @param b_callback
     * @param s_callback
     * @param c_callback
     */
    sentJSON: function (url, jsonData, b_callback, s_callback, c_callback) {
        $.ajax({
            type: 'POST',
            contentType: "application/json",
            url: url,
            data: jsonData,
            beforeSend: b_callback,
            success: s_callback,
            complete: c_callback
        });
    },
    voidFun: function () {

    }
};

/*咨询相关*/
var Infos = {
    init: function () {
        this.render();
    },
    render: function () {
        this.bind();
    },
    bind: function () {

    },
    selectInfoById: function (id, callback) {
        var act_url = 'selectInfoById?id=' + id;
        Interface.gainJSON(act_url, callback);
    },
    selectInfoByIdAndType: function (id, type, callback) {
        var act_url = 'selectInfoByIdAndType?id=' + id + '&type=' + type;
        Interface.gainJSON(act_url, callback);
    },
    selectInfoByNumAndType: function (num, type, callback) {
        var act_url = 'selectInfoByNumAndType?num=' + num + '&type=' + type;
        Interface.gainJSON(act_url, callback);
    },
    limitInfosByTypeAndCurrentPageAndPageSize: function (type, currentPage, pageSize, callback) {
        var act_url = 'limitInfosByTypeAndCurrentPageAndPageSize?type=' + type + '&currentPage=' + currentPage + '&pageSize=' + pageSize;
        Interface.gainJSON(act_url, callback);
    },
    searchInfosByTitleOrNote: function (jsonData, type, currentPage, pageSize, callback) {
        var act_url = 'searchInfosTypeByTitleOrNote?type=' + type + '&currentPage=' + currentPage + '&pageSize=' + pageSize;
        Interface.sentJSON(act_url, jsonData, Interface.voidFun, callback, Interface.voidFun);
    },
    modifyInfoVisit: function (id, callback) {
        var act_url = 'modifyInfoVisit?id=' + id;
        Interface.gainJSON(act_url, callback);
    },
    findInfoNumByVisit: function (num, type, callback) {
        var act_url = 'findInfoNumByVisit?num=' + num + '&type=' + type;
        Interface.gainJSON(act_url, callback);
    }
};

/*活动相关*/
var Activities = {
    init: function () {
        this.render();
    },
    render: function () {
        this.bind();
    },
    bind: function () {

    },
    selectActivityById: function (id, callback) {
        var act_url = '/selectActivityById?id=' + id;
        Interface.gainJSON(act_url, callback);
    },
    selectActivitiesByNum: function (num, callback) {
        var act_url = '/selectActivitiesByNum?num=' + num;
        Interface.gainJSON(act_url, callback);
    },
    limitActivitiesByCurrentPageAndPageSize: function (currentPage, pageSize, callback) {
        var act_url = '/limitActivitiesByCurrentPageAndPageSize?currentPage=' + currentPage + '&pageSize=' + pageSize;
        Interface.gainJSON(act_url, callback);
    }
};

/*政策相关*/
var Policies = {
    init: function () {
        this.render();
    },
    render: function () {
        this.bind();
    },
    bind: function () {

    },
    selectPolicyById: function (id, callback) {
        var act_url = '/selectPolicyById?id=' + id;
        Interface.gainJSON(act_url, callback);
    },
    selectPoliciesByNum: function (num, callback) {
        var act_url = '/selectPoliciesByNum?num=' + num;
        Interface.gainJSON(act_url, callback);
    },
    limitPoliciesByCurrentPageAndPageSize: function (currentPage, pageSize, callback) {
        var act_url = '/limitPoliciesByCurrentPageAndPageSize?currentPage=' + currentPage + '&pageSize=' + pageSize;
        Interface.gainJSON(act_url, callback);
    }
};

/*校友相关*/
var Alumnus = {
    init: function () {
        this.render();
    },
    render: function () {
        this.bind();
    },
    bind: function () {

    },
    selectAlumniById: function (id, callback) {
        var act_url = '/selectAlumniById?id=' + id;
        Interface.gainJSON(act_url, callback);
    },
    selectAlumnusByNum: function (num, callback) {
        var act_url = '/selectAlumnusByNum?num=' + num;
        Interface.gainJSON(act_url, callback);
    },
    limitAlumnusByCurrentPageAndPageSize: function (currentPage, pageSize, callback) {
        var act_url = '/limitAlumnusByCurrentPageAndPageSize?currentPage=' + currentPage + '&pageSize=' + pageSize;
        Interface.gainJSON(act_url, callback);
    }
};

/*知识相关*/
var Knowledge = {
    init: function () {
        this.render();
    },
    render: function () {
        this.bind();
    },
    bind: function () {

    },
    selectKnowledgeById: function (id, callback) {
        var act_url = '/selectKnowledgeById?id=' + id;
        Interface.gainJSON(act_url, callback);
    },
    selectKnowledgesByNum: function (num, callback) {
        var act_url = '/selectKnowledgesByNum?num=' + num;
        Interface.gainJSON(act_url, callback);
    },
    limitKnowledgesByCurrentPageAndPageSize: function (currentPage, pageSize, callback) {
        var act_url = '/limitKnowledgesByCurrentPageAndPageSize?currentPage=' + currentPage + '&pageSize=' + pageSize;
        Interface.gainJSON(act_url, callback);
    }
};

/*导师相关*/
var Tutors = {
    init: function () {
        this.render();
    },
    render: function () {
        this.bind();
    },
    bind: function () {

    },
    selectTutorById: function (id, callback) {
        var act_url = '/selectTutorById?id=' + id;
        Interface.gainJSON(act_url, callback);
    },
    selectTutorsByNum: function (num, callback) {
        var act_url = '/selectTutorsByNum?num=' + num;
        Interface.gainJSON(act_url, callback);
    },
    limitTutorsByCurrentPageAndPageSize: function (currentPage, pageSize, callback) {
        var act_url = '/limitTutorsByCurrentPageAndPageSize?currentPage=' + currentPage + '&pageSize=' + pageSize;
        Interface.gainJSON(act_url, callback);
    }
};

/*新闻相关*/
var News = {
    init: function () {
        this.render();
    },
    render: function () {
        this.bind();
    },
    bind: function () {

    },
    selectNewById: function (id, callback) {
        var act_url = '/selectNewById?id=' + id;
        Interface.gainJSON(act_url, callback);
    },
    selectNewsByNum: function (num, callback) {
        var act_url = '/selectNewsByNum?num=' + num;
        Interface.gainJSON(act_url, callback);
    },
    limitNewsByCurrentPageAndPageSize: function (currentPage, pageSize, callback) {
        var act_url = '/limitNewsByCurrentPageAndPageSize?currentPage=' + currentPage + '&pageSize=' + pageSize;
        Interface.gainJSON(act_url, callback);
    }
};

/*培训相关*/
var Trains = {
    init: function () {
        this.render();
    },
    render: function () {
        this.bind();
    },
    bind: function () {

    },
    selectTrainById: function (id, callback) {
        var act_url = '/selectTrainById?id=' + id;
        Interface.gainJSON(act_url, callback);
    },
    selectTrainsByNum: function (num, callback) {
        var act_url = '/selectTrainsByNum?num=' + num;
        Interface.gainJSON(act_url, callback);
    },
    limitTrainsByCurrentPageAndPageSize: function (currentPage, pageSize, callback) {
        var act_url = '/limitTrainsByCurrentPageAndPageSize?currentPage=' + currentPage + '&pageSize=' + pageSize;
        Interface.gainJSON(act_url, callback);
    }
};

/*团队项目相关*/
var Projects = {
    init: function () {
        this.render();
    },
    render: function () {
        this.bind();
    },
    bind: function () {

    },
    selectProjectById: function (id, callback) {
        var act_url = 'selectProjectById?id=' + id;
        Interface.gainJSON(act_url, callback);
    },
    selectProjectsByNum: function (num, callback) {
        var act_url = 'selectProjectsByNum?num=' + num;
        Interface.gainJSON(act_url, callback);
    },
    limitProjectsByCurrentPageAndPageSize: function (currentPage, pageSize, callback) {
        var act_url = 'limitProjectsByCurrentPageAndPageSize?currentPage=' + currentPage + '&pageSize=' + pageSize;
        Interface.gainJSON(act_url, callback);
    },
    getProjectByIdReturnPreNextProj: function (id, callback) {
        var act_url = 'getProjectByIdReturnPreNextProj?id=' + id;
        Interface.gainJSON(act_url, callback);
    },
    searchProjectByProjNameOrCompanyName: function (jsonData, currentPage, pageSize, callback) {
        var act_url = 'searchProjectByProjNameOrCompanyName?currentPage=' + currentPage + '&pageSize=' + pageSize;
        Interface.sentJSON(act_url, jsonData, Interface.voidFun, callback, Interface.voidFun);
    },
    modifyProjectVisit: function (id, callback) {
        var act_url = 'modifyProjectVisit?id=' + id;
        Interface.gainJSON(act_url, callback);
    },
    findProjectNumByVisit:function (num, callback) {
        var act_url = 'findProjectNumByVisit?num=' + num;
        Interface.gainJSON(act_url, callback);
    }
};

/*服务相关*/
var Guides = {
    init: function () {
        this.render();
    },
    render: function () {
        this.bind();
    },
    bind: function () {

    },
    selectGuideById: function (id, callback) {
        var act_url = '/selectGuideById?id=' + id;
        Interface.gainJSON(act_url, callback);
    },
    selectGuideByIdAndType: function (id, type, callback) {
        var act_url = '/selectGuideByIdAndType?id=' + id + '&type=' + type;
        Interface.gainJSON(act_url, callback);
    },
    limitGuidesByTypeAndCurrentPageAndPageSize: function (type, currentPage, pageSize, callback) {
        var act_url = '/limitGuidesByTypeAndCurrentPageAndPageSize?type=' + type + '&currentPage=' + currentPage + '&pageSize=' + pageSize;
        Interface.gainJSON(act_url, callback);
    }
};

/*基金相关*/
var Funds = {
    init: function () {
        this.render();
    },
    render: function () {
        this.bind();
    },
    bind: function () {

    },
    selectFundById: function (id, callback) {
        var act_url = '/selectFundById?id=' + id;
        Interface.gainJSON(act_url, callback);
    },
    selectFundsByNum: function (num, callback) {
        var act_url = '/selectFundsByNum?num=' + num;
        Interface.gainJSON(act_url, callback);
    },
    limitFundsByCurrentPageAndPageSize: function (currentPage, pageSize, callback) {
        var act_url = '/limitFundsByCurrentPageAndPageSize?currentPage=' + currentPage + '&pageSize=' + pageSize;
        Interface.gainJSON(act_url, callback);
    }
};

/*图片相关*/
var Pictures = {
    init: function () {
        this.render();
    },
    render: function () {
        this.bind();
    },
    bind: function () {

    },
    selectPictureById: function (id, callback) {
        var act_url = 'selectPictureById?id=' + id;
        Interface.gainJSON(act_url, callback);
    }
};