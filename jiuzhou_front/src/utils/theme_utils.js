const theme = {
  chalk: {
    // 背景颜色
    backgroundColor: 'rgb(0,0,0)',
    // 标题文字颜色
    titleColor: '#FFFFFF',
    // 切换主题按钮的图片路径
    themeSrc: 'qiehuan_dark.png',
    // 头部的线条
    headerBorderSrc: 'header_border_dark.png',
    sellerAxisPointerColor: 'rgba(255,255,255,0.35)',
  },
  // 该主题未启用
  vintage: {
    backgroundColor: '#dddddd',
    titleColor: "#000000",
    themeSrc: 'qiehuan_light.png',
    headerBorderSrc: 'header_border_light.png',
    sellerAxisPointerColor: '#f1f2f6',
  },
  westeros: {
    backgroundColor: '#dedede',
    titleColor: "#000000",
    themeSrc: 'qiehuan_light.png',
    headerBorderSrc: 'header_border_light.png',
    sellerAxisPointerColor: '#f1f2f6',
  },
}


export function getThemeValue(themeName) {
  return theme[themeName]
}