Page({
  data: {
     typelist:["头条"," 社会","国内","国际","娱乐","体育","军事","科技","财经","时尚"],
     type:0
  },
  onLoad() {},
  selected(e){
      var id = e.currentTarget.id;
      this.setData({
          type:id
      });
  },
  slide(e){
      var id = e.detail.current;
       this.setData({
          type:id
      });
  },
  show(e){
      my.navigateTo({
          "url":"/pages/news/news"
      });
  }
});
