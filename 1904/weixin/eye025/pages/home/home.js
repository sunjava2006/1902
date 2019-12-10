// pages/home/home.js

const inc = {
    latitude: 32.1565500000,
    longitude: 118.6975000000,
    iconPath: "/imgs/location_r.png",
    id: 0,
    width: 50,
    height: 50,
    zIndex:0,
    callout: {
        content: "智码堂软件技术培训中心",
        color: "#0000ff",
        display: "ALWAYS",
        padding: 10,
        borderRadius: 10,
        bgColor: "#f3e3a2",
        borderWidth: 1,
        borderColor: "#cccccc"
    }
};
Page({

    /**
     * 页面的初始数据
     */
    data: {
        markers: [inc], 
        polyline: [ ]
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        var that = this;
        wx.getLocation({
            success: function(res) {
               var latitude =  res.latitude;
               var longitude = res.longitude;

               var myLocation={
                   latitude: latitude,
                   longitude: longitude,
                   iconPath: "/imgs/people.png",
                   id: 1,
                   zIndex:1,
                   width: 50,
                   height: 50,
                   title: "我的位置"
               }
               that.setData(
                   {
                       markers:[inc,myLocation],
                       polyline:[
                           {
                               points: [{latitude: latitude,
                                         longitude: longitude},
                                        {latitude: inc.latitude,
                                         longitude: inc.longitude}                                       ],
                                color:"#0000ff",
                                width:2,
                                dottedLine:true
                           }
                       ]
                   }
               );
            }
        })
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