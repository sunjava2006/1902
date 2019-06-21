Page({
    data: {
        currID:0,
        kinds:["头条","社会","国内","国际","娱乐","体育","军事","科技","财经","时尚"]

    },
    selectKind(e){
        var id = e.target.id;
        this.setData({"currID": id});
    },
    onLoad(query) {
        // 页面加载
        console.info(`Page onLoad with query: ${JSON.stringify(query)}`);
    },
    onReady() {
        // 页面加载完成
    },
    onShow() {
        // 页面显示
    },
    onHide() {
        // 页面隐藏
    },
    onUnload() {
        // 页面被关闭
    },
    onTitleClick() {
        // 标题被点击
    },
    onPullDownRefresh() {
        // 页面被下拉
    },
    onReachBottom() {
        // 页面被拉到底部
    },
    onShareAppMessage() {
        // 返回自定义分享信息
        return {
            title: 'My App',
            desc: 'My App description',
            path: 'pages/index/index',
        };
    },
});
