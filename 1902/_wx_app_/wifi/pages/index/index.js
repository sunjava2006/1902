//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    longitude:0,
    latitude:0,
    markers: null
  },

  onLoad: function () {
     var that= this;
     wx.getLocation({
       
       success: function(res) {
         var longitude = res.longitude; //经度
         var latitude = res.latitude; // 纬度
         that.setData({
           longitude: longitude,
           latitude: latitude,
           markers: [{
             iconPath: "/imgs/location.png",
             id: 0,
             latitude: latitude,
             longitude: longitude,
             width: 50,
             height: 50
           }]
         });
       },
     })
  }
})
