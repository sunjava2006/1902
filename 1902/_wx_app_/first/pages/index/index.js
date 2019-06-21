Page({
    lowerAction:function(e){
        console.log('to lower..........');
    },
    toLog:function(e){
        wx.navigateTo({
            url: "/pages/logs/logs"
        });
       
    }
});