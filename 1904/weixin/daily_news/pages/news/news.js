// pages/news/news.js
Page({

    /**
     * 页面的初始数据
     */
    data: {
        "url":"http:\/\/mini.eastday.com\/mobile\/191125103444448.html",
        "id":100
    },

    /**
     * 生命周期函数--监听页面加载,
     * options 中包含传递的参数。
     */
    onLoad: function (options) {
        var id = options.id;
        console.log(options);
        console.log("-----------1----------");
        // this.setData({
        //     "id":id
        // });
    },

    /**
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady: function () {
        console.log("-----------2----------");
    },

    /**
     * 生命周期函数--监听页面显示
     */
    onShow: function () {
        console.log("-----------3----------");
    },

    /**
     * 生命周期函数--监听页面隐藏
     */
    onHide: function () {
        console.log("-----------4----------");
    },

    /**
     * 生命周期函数--监听页面卸载
     */
    onUnload: function () {
        console.log("-----------5----------");
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