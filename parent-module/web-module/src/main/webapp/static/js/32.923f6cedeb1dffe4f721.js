webpackJsonp([32],{214:function(t,n,a){function e(t){a(396)}var i=a(118)(a(307),a(444),e,"data-v-48206918",null);t.exports=i.exports},307:function(t,n,a){"use strict";Object.defineProperty(n,"__esModule",{value:!0});var e=a(34);n.default={data:function(){return{img:"/static/images/IMG_2407.JPG",banner:{},bgOpt:{px:0,py:0,w:0,h:0},projects:[],infos:[1,2,3],floors:[],hot:[],loading:!1,notify:"1",dialogVisible:!1}},methods:{bgOver:function(t){this.bgOpt.px=t.offsetLeft,this.bgOpt.py=t.offsetTop,this.bgOpt.w=t.offsetWidth,this.bgOpt.h=t.offsetHeight},bgMove:function(t,n){var a=this.bgOpt,e=void 0,i=void 0,o=n.pageX-a.px,r=n.pageY-a.py;e=(a.w,o-a.w/2),i=(a.h,a.h/2-r),t.style["-webkit-transform"]="rotateY("+e/50+"deg) rotateX("+i/50+"deg)",t.style.transform="rotateY("+e/50+"deg) rotateX("+i/50+"deg)"},bgOut:function(t){t.style["-webkit-transform"]="rotateY(0deg) rotateX(0deg)",t.style.transform="rotateY(0deg) rotateX(0deg)"},showNotify:function(){var t=a.i(e.a)("notify");this.notify!==t&&(this.dialogVisible=!0,a.i(e.b)("notify",this.notify))}},mounted:function(){this.loading=!1,this.showNotify()},components:{}}},357:function(t,n,a){n=t.exports=a(208)(!0),n.push([t.i,".bread_crumbs[data-v-48206918]{border-bottom:1px solid #dbdbdb;height:37px;width:1220px;margin:0 auto;margin-top:10px}ul#crumbs[data-v-48206918]{overflow:hidden;line-height:35px}ul#crumbs li[data-v-48206918]{float:left;list-style:none}ul#crumbs li span[data-v-48206918]{font-size:12px}ul#crumbs li a[data-v-48206918]:link,ul#crumbs li a[data-v-48206918]:visited{text-decoration:none;font-size:12px}.crumbs_index[data-v-48206918]:link,.crumbs_index[data-v-48206918]:visited,.crumbs_paper[data-v-48206918]:link,.crumbs_paper[data-v-48206918]:visited{color:#666}.crumbs_index[data-v-48206918]:hover,.crumbs_paper[data-v-48206918]:hover{color:#f60}.home[data-v-48206918]{display:-webkit-box;display:-ms-flexbox;display:flex;-webkit-box-orient:vertical;-webkit-box-direction:normal;-ms-flex-direction:column;flex-direction:column}.mt30[data-v-48206918]{margin-top:15px}.contentwrap[data-v-48206918]{width:100%;display:block;padding:20px 0;background:#fff}.contentwrap .content[data-v-48206918]{width:1220px;margin:0 auto;padding:0}.contentwrap .content .area[data-v-48206918]{width:100%;padding:0;overflow:hidden}.contentwrap .content .area .pagetitle[data-v-48206918]{height:35px;line-height:35px;text-align:center}.contentwrap .content .area .pagetitle span[data-v-48206918]{font-size:25px;font-weight:700;color:#333}.contentwrap .content .area .article-toolbar[data-v-48206918]{text-align:center;color:#989898;font-size:12px;font-family:arial;height:28px;line-height:28px}.contentwrap .content .area .article-toolbar .time[data-v-48206918]{padding:0 15px 0 12px;color:#989898}.contentwrap .content .area .mt10[data-v-48206918]{margin-top:10px}.contentwrap .content .area .mt10 img[data-v-48206918]{vertical-align:middle;border:none}.contentwrap .content .area .contentbox[data-v-48206918]{padding:10px 0;overflow:hidden;font-size:14px;line-height:25px}.contentwrap .content .havemenu[data-v-48206918]{overflow:hidden;width:100%;padding:0}.contentwrap .homeCenterNav[data-v-48206918]{margin:0 auto;width:1220px;border-top:2px solid #f60}.contentwrap .homeCenterNav ul[data-v-48206918]{height:127px;margin:0 auto}.contentwrap .homeCenterNav ul li[data-v-48206918]{float:left;width:406px;padding:15px 0 0 150px}.contentwrap .homeCenterNav ul li p[data-v-48206918]{line-height:20px;width:185px}.contentwrap .homeCenterNav ul .homeCenterNavImg01[data-v-48206918]{background:url(/static/images/home_nav_img01.png) no-repeat scroll 0 0 transparent;height:112px;border-left:1px solid #ccc}.contentwrap .homeCenterNav ul .homeCenterNavImg02[data-v-48206918]{background:url(/static/images/home_nav_img02.png) no-repeat scroll 0 0 transparent;height:112px;border-left:1px solid #ccc}.contentwrap .homeCenterNav ul .homeCenterNavImg03[data-v-48206918]{background:url(/static/images/home_nav_img03.png) no-repeat scroll 0 0 transparent;height:112px;border-right:1px solid #ccc}","",{version:3,sources:["E:/BLUE/Postgraduate/06 Assistant/02 信息化建设/02 开发/syb/index/src/page/About/contact.vue"],names:[],mappings:"AAGA,+BAEE,gCAAiC,AACjC,YAAa,AACb,aAAc,AACd,cAAe,AACf,eAAiB,CAClB,AACD,2BACE,gBAAiB,AACjB,gBAAkB,CACnB,AACD,8BACE,WAAY,AACZ,eAAiB,CAClB,AACD,mCACE,cAAgB,CACjB,AACD,6EACE,qBAAsB,AACtB,cAAgB,CACjB,AAID,sJACE,UAAY,CACb,AACD,0EACE,UAAY,CACb,AACD,uBACE,oBAAqB,AACrB,oBAAqB,AACrB,aAAc,AACd,4BAA6B,AAC7B,6BAA8B,AAC1B,0BAA2B,AACvB,qBAAuB,CAChC,AACD,uBACE,eAAiB,CAClB,AACD,8BACE,WAAY,AACZ,cAAe,AACf,eAAgB,AAChB,eAAiB,CAClB,AACD,uCACI,aAAc,AACd,cAAe,AACf,SAAW,CACd,AACD,6CACM,WAAY,AACZ,UAAW,AACX,eAAiB,CACtB,AACD,wDACQ,YAAa,AACb,iBAAkB,AAClB,iBAAmB,CAC1B,AACD,6DACU,eAAgB,AAChB,gBAAiB,AACjB,UAAY,CACrB,AACD,8DACQ,kBAAmB,AACnB,cAAe,AACf,eAAgB,AAChB,kBAAmB,AACnB,YAAa,AACb,gBAAkB,CACzB,AACD,oEACU,sBAAuB,AACvB,aAAe,CACxB,AACD,mDACQ,eAAiB,CACxB,AACD,uDACU,sBAAuB,AACvB,WAAa,CACtB,AACD,yDACQ,eAAgB,AAChB,gBAAiB,AACjB,eAAgB,AAChB,gBAAkB,CACzB,AACD,iDACM,gBAAiB,AACjB,WAAY,AACZ,SAAW,CAEhB,AACD,6CACI,cAAe,AACf,aAAc,AACd,yBAA2B,CAC9B,AACD,gDACM,aAAc,AACd,aAAe,CACpB,AACD,mDACQ,WAAY,AACZ,YAAa,AACb,sBAAwB,CAC/B,AACD,qDACU,iBAAkB,AAClB,WAAa,CACtB,AACD,oEACQ,mFAAoF,AACpF,aAAc,AACd,0BAA4B,CAGnC,AACD,oEACQ,mFAAoF,AACpF,aAAc,AACd,0BAA4B,CAGnC,AACD,oEACQ,mFAAoF,AACpF,aAAc,AACd,2BAA6B,CAGpC",file:"contact.vue",sourcesContent:['\n@charset "UTF-8";\n/*面包屑*/\n.bread_crumbs[data-v-48206918] {\n  /*border-top:1px solid #dbdbdb;*/\n  border-bottom: 1px solid #dbdbdb;\n  height: 37px;\n  width: 1220px;\n  margin: 0 auto;\n  margin-top: 10px;\n}\nul#crumbs[data-v-48206918] {\n  overflow: hidden;\n  line-height: 35px;\n}\nul#crumbs li[data-v-48206918] {\n  float: left;\n  list-style: none;\n}\nul#crumbs li span[data-v-48206918] {\n  font-size: 12px;\n}\nul#crumbs li a[data-v-48206918]:link, ul#crumbs li a[data-v-48206918]:visited {\n  text-decoration: none;\n  font-size: 12px;\n}\n.crumbs_index[data-v-48206918]:link, .crumbs_index[data-v-48206918]:visited {\n  color: #666;\n}\n.crumbs_paper[data-v-48206918]:link, .crumbs_paper[data-v-48206918]:visited {\n  color: #666;\n}\n.crumbs_index[data-v-48206918]:hover, .crumbs_paper[data-v-48206918]:hover {\n  color: #F60;\n}\n.home[data-v-48206918] {\n  display: -webkit-box;\n  display: -ms-flexbox;\n  display: flex;\n  -webkit-box-orient: vertical;\n  -webkit-box-direction: normal;\n      -ms-flex-direction: column;\n          flex-direction: column;\n}\n.mt30[data-v-48206918] {\n  margin-top: 15px;\n}\n.contentwrap[data-v-48206918] {\n  width: 100%;\n  display: block;\n  padding: 20px 0;\n  background: #FFF;\n}\n.contentwrap .content[data-v-48206918] {\n    width: 1220px;\n    margin: 0 auto;\n    padding: 0;\n}\n.contentwrap .content .area[data-v-48206918] {\n      width: 100%;\n      padding: 0;\n      overflow: hidden;\n}\n.contentwrap .content .area .pagetitle[data-v-48206918] {\n        height: 35px;\n        line-height: 35px;\n        text-align: center;\n}\n.contentwrap .content .area .pagetitle span[data-v-48206918] {\n          font-size: 25px;\n          font-weight: 700;\n          color: #333;\n}\n.contentwrap .content .area .article-toolbar[data-v-48206918] {\n        text-align: center;\n        color: #989898;\n        font-size: 12px;\n        font-family: arial;\n        height: 28px;\n        line-height: 28px;\n}\n.contentwrap .content .area .article-toolbar .time[data-v-48206918] {\n          padding: 0 15px 0 12px;\n          color: #989898;\n}\n.contentwrap .content .area .mt10[data-v-48206918] {\n        margin-top: 10px;\n}\n.contentwrap .content .area .mt10 img[data-v-48206918] {\n          vertical-align: middle;\n          border: none;\n}\n.contentwrap .content .area .contentbox[data-v-48206918] {\n        padding: 10px 0;\n        overflow: hidden;\n        font-size: 14px;\n        line-height: 25px;\n}\n.contentwrap .content .havemenu[data-v-48206918] {\n      overflow: hidden;\n      width: 100%;\n      padding: 0;\n      /* background: url(../images/bg_menu.jpg) repeat-y; */\n}\n.contentwrap .homeCenterNav[data-v-48206918] {\n    margin: 0 auto;\n    width: 1220px;\n    border-top: #F60 2px solid;\n}\n.contentwrap .homeCenterNav ul[data-v-48206918] {\n      height: 127px;\n      margin: 0 auto;\n}\n.contentwrap .homeCenterNav ul li[data-v-48206918] {\n        float: left;\n        width: 406px;\n        padding: 15px 0 0 150px;\n}\n.contentwrap .homeCenterNav ul li p[data-v-48206918] {\n          line-height: 20px;\n          width: 185px;\n}\n.contentwrap .homeCenterNav ul .homeCenterNavImg01[data-v-48206918] {\n        background: url(/static/images/home_nav_img01.png) no-repeat scroll 0 0 transparent;\n        height: 112px;\n        border-left: 1px solid #ccc;\n        /*padding: 15px 0 0 110px;*/\n        /*width: 406px;*/\n}\n.contentwrap .homeCenterNav ul .homeCenterNavImg02[data-v-48206918] {\n        background: url(/static/images/home_nav_img02.png) no-repeat scroll 0 0 transparent;\n        height: 112px;\n        border-left: 1px solid #ccc;\n        /*padding: 15px 0 0 110px;*/\n        /*width: 406px;*/\n}\n.contentwrap .homeCenterNav ul .homeCenterNavImg03[data-v-48206918] {\n        background: url(/static/images/home_nav_img03.png) no-repeat scroll 0 0 transparent;\n        height: 112px;\n        border-right: 1px solid #ccc;\n        /*padding: 15px 0 0 110px;*/\n        /*width: 406px;*/\n}\n'],sourceRoot:""}])},396:function(t,n,a){var e=a(357);"string"==typeof e&&(e=[[t.i,e,""]]),e.locals&&(t.exports=e.locals);a(209)("2383f73b",e,!0,{})},444:function(t,n){t.exports={render:function(){var t=this,n=t.$createElement,a=t._self._c||n;return a("div",{staticClass:"home"},[t._m(0),t._v(" "),a("div",{directives:[{name:"loading",rawName:"v-loading",value:t.loading,expression:"loading"}],attrs:{"element-loading-text":"加载中..."}},[t._m(1)])])},staticRenderFns:[function(){var t=this,n=t.$createElement,a=t._self._c||n;return a("div",{staticClass:"bread_crumbs"},[a("ul",{attrs:{id:"crumbs"}},[a("li",[a("span",[t._v("当前位置：")])]),t._v(" "),a("li",[a("a",{staticClass:"crumbs_index",attrs:{href:"index.html"}},[t._v("网站首页")])]),t._v(" "),a("li",[a("span",[t._v(" / ")])]),t._v(" "),a("li",[a("a",{staticClass:"crumbs_paper",attrs:{href:"about.html"}},[t._v("联系我们")])])])])},function(){var t=this,n=t.$createElement,a=t._self._c||n;return a("section",{staticClass:"w mt30 clearfix"},[a("div",{staticClass:"contentwrap"},[a("div",{staticClass:"content"},[a("div",{staticClass:"area havemenu"},[a("div",{staticClass:"pagetitle"},[a("span",[t._v("联系我们")])]),t._v(" "),a("div",{staticClass:"article-toolbar"},[a("span",{staticClass:"article-assist"},[a("span",{staticClass:"author"},[t._v("发布时间：")]),a("span",{staticClass:"time"},[t._v("2017-09-01")])]),t._v(" "),a("span",{staticClass:"article-statist"})]),t._v(" "),a("div",{staticClass:"contentbox",staticStyle:{"border-top":"1px solid #e3e3e3"}},[a("div",{staticClass:"article-main"},[a("table",{staticStyle:{"border-collapse":"collapse",width:"554px","margin-left":"150px"}},[a("tbody",[a("tr",[a("td",{staticStyle:{width:"138px",padding:"10px 0 10px 15px"},attrs:{width:"138",valign:"top"}},[a("p",{staticStyle:{"margin-top":"5px","line-height":"200%"}},[a("span",{staticStyle:{"font-family":"宋体","letter-spacing":"0","font-size":"13px",background:"rgb(255, 255, 255)"}},[t._v("办公地址：")])])]),t._v(" "),a("td",{staticStyle:{width:"416px",padding:"10px 0 10px 15px"},attrs:{width:"415",valign:"top"}},[a("p",{staticStyle:{"margin-top":"5px"}},[a("span",{staticStyle:{"font-family":"宋体","letter-spacing":"0","font-size":"13px",background:"rgb(255, 255, 255)"}},[t._v("大学城外环西路100号广东工业大学教学6号楼209-2")])])])]),t._v(" "),a("tr",[a("td",{staticStyle:{width:"138px",padding:"10px 0 10px 15px"},attrs:{width:"138",valign:"top"}},[a("p",{staticStyle:{"margin-top":"5px","line-height":"18px"}},[a("span",{staticStyle:{"font-family":"宋体","letter-spacing":"0","font-size":"13px",background:"rgb(255, 255, 255)"}},[t._v("邮政编码：")])])]),t._v(" "),a("td",{staticStyle:{width:"416px",padding:"10px 0 10px 15px"},attrs:{width:"415",valign:"top"}},[a("p",{staticStyle:{"margin-top":"5px","line-height":"18px"}},[a("span",{staticStyle:{"font-family":"宋体","letter-spacing":"0","font-size":"13px",background:"rgb(255, 255, 255)"}},[t._v("510006")])])])]),t._v(" "),a("tr",[a("td",{staticStyle:{width:"138px",padding:"10px 0 10px 15px"},attrs:{width:"138",valign:"top"}},[a("p",{staticStyle:{"margin-top":"5px","line-height":"18px"}},[a("span",{staticStyle:{"font-family":"宋体","letter-spacing":"0","font-size":"13px",background:"rgb(255, 255, 255)"}},[t._v("办公时间：")])])]),t._v(" "),a("td",{staticStyle:{width:"416px",padding:"10px 0 10px 15px"},attrs:{width:"415",valign:"top"}},[a("p",{staticStyle:{"margin-top":"5px","line-height":"18px"}},[a("span",{staticStyle:{"font-family":"宋体","letter-spacing":"0","font-size":"13px",background:"rgb(255, 255, 255)"}},[t._v("周一至周五上午9：00--下午5：00（国定节假日除外）")])])])]),t._v(" "),a("tr",[a("td",{staticStyle:{width:"138px",padding:"10px 0 10px 15px"},attrs:{width:"138",valign:"top"}},[a("p",{staticStyle:{"margin-top":"5px","line-height":"18px"}},[a("span",{staticStyle:{"font-family":"宋体","letter-spacing":"0","font-size":"13px",background:"rgb(255, 255, 255)"}},[t._v("联系电话：")])])]),t._v(" "),a("td",{staticStyle:{width:"416px",padding:"10px 0 10px 15px"},attrs:{width:"415",valign:"top"}},[a("p",{staticStyle:{"margin-top":"5px","line-height":"18px"}},[a("span",{staticStyle:{"font-family":"宋体","letter-spacing":"0","font-size":"13px",background:"rgb(255, 255, 255)"}},[t._v("020-39322612")])])])]),t._v(" "),a("tr",[a("td",{staticStyle:{width:"554px",padding:"10px 0 10px 15px"},attrs:{width:"554",valign:"top",colspan:"2"}},[a("p",{staticStyle:{"margin-top":"5px","text-align":"center","line-height":"18px"}},[a("span",{staticStyle:{"font-family":"#39",color:"rgb(134,134,134)","font-size":"16px"}})]),t._v(" "),a("p",{staticStyle:{"text-align":"center"}},[a("img",{staticClass:"image",staticStyle:{float:"none"},attrs:{imageid:"1343",src:"/static/images/map.png"}})]),t._v(" "),a("p",{staticStyle:{"margin-top":"5px","text-align":"center","line-height":"18px"}},[a("span",{staticStyle:{"font-family":"#39",color:"rgb(134,134,134)","font-size":"16px"}}),a("br")])])])])]),t._v(" "),a("p",[a("br")])])])])])])])}]}}});
//# sourceMappingURL=32.923f6cedeb1dffe4f721.js.map