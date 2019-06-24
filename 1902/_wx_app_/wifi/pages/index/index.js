//index.js
//获取应用实例
const app = getApp()

Page({
    data: {
        longitude: 0,
        latitude: 0,
        markers: null
    },

    onLoad: function() {
        console.log("appKey:" + app.globalData.appKey);

        var that = this;
        wx.getLocation({

            success: function(res) {
                // 获取当前的地理位置
                var longitude = res.longitude; //经度
                var latitude = res.latitude; // 纬度

                // 取周边wifi信息
                wx.request({
                    url: 'http://apis.juhe.cn/wifi/local',
                    header: {
                        'content-type': 'application/json' // 默认值
                    },
                    data: {
                        key: app.globalData.appKey,
                        lon: longitude,
                        lat: latitude,
                        r: 3000,
                        type: 3
                    },
                    success(res) {
                        console.log('返回数据：');
                        console.log(res);
                        var wifiList = res.data.result.data;
                        // 写数据
                        var markers = [{
                            iconPath: "/imgs/location.png",
                            id: 0,
                            latitude: latitude,
                            longitude: longitude,
                            width: 50,
                            height: 50
                        }];
                        for(var i in wifiList){
                            var o = {
                                iconPath: "/imgs/wifi.png",
                                id: i+1,
                                latitude: wifiList[i].google_lat,
                                longitude: wifiList[i].google_lon,
                                width: 50,
                                height: 50
                            };
                            markers.push(o);
                        }
                        that.setData({
                            longitude: longitude,
                            latitude: latitude,
                            markers: markers
                        });


                    }
                })
            }
        })
    }
})