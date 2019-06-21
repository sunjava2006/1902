//index.js
//获取应用实例
const app = getApp();

Page({
    data: {
        currId: 0,
        count:3,
        array:null,
        types: ["top","shehui"]
    },
    selectItem: function(e) {
        var curId = e.currentTarget.id;
        
        this.setData({currId: curId});
        this.list(this.data.types[curId]);
    },
    changeItem:function(e){
        var id = e.detail.currentItemId;
        this.setData({currId:id});
    },
    openNews:function(e){

        var url =  e.currentTarget.id;
        console.log(url);
        wx.navigateTo({
            url: '/pages/news/news?url='+url
        })
    },
    onShow: function() {
        console.log("--------onLoad--------------")
        this.list("top");
    },
    list:function(type){
        var that = this;
        console.log("----------list -----------");
        wx.request({
            url: 'http://v.juhe.cn/toutiao/index',
            data: {'type':type,
                'key':'082153265794dc7a4bdb119e272319ee'},
            header: {'content-type': 'application/json'},
            method: 'GET',
            dataType: 'json',
            responseType: 'text',
            success: function(res) {

                var list = res.data.result.data;
                that.setData({"array": list});
                console.log(list);

            },
            fail: function(res) {},
            complete: function(res) {},
        })
    }


});