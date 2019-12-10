// pages/location/location.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
        markers: [],
        circles:[],
       
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        var target={
            title:'艾尔眼科',
            iconPath: "/imgs/location_r.png",
            id: 0,
            latitude: 32.0244900000,
            longitude: 118.7755530000,
            width: 50,
            height: 50
        };
        var that = this;
        
        wx.getLocation({
            success: function(res) {
                // console.log(res);
                var curr={latitude:res.latitude,
                         longitude:res.longitude,
                         id: 1,
                         iconPath:"/imgs/people.png",
                         width:50,
                         heigiht:50};
                var array = [target,curr];
                var circle={
                    latitude: 32.0244900000,
                    longitude: 118.7755530000,
                    color:"#0000FF",
                    radius:20,
                    strokeWidth:1,
                   
                }
                that.setData({ markers: array ,
                               circles:[circle]
                            });

            }
        });
    },

    /**
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady: function () {

    },

    /**
     * 生命周期函数--监听页面显示
     */
    onShow: function () {

    },

    /**
     * 生命周期函数--监听页面隐藏
     */
    onHide: function () {

    },

    /**
     * 生命周期函数--监听页面卸载
     */
    onUnload: function () {

    },

    /**
     * 页面相关事件处理函数--监听用户下拉动作
     */
    onPullDownRefresh: function () {

    },

    /**
     * 页面上拉触底事件的处理函数
     */
    onReachBottom: function () {

    },

    /**
     * 用户点击右上角分享
     */
    onShareAppMessage: function () {

    }
})