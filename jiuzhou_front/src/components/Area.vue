<template>
  <div class="com-container" @dblclick="chinaMap" style="width: 100vh;height: 100vh">

    <div class="com-chart" ref="mapRef"></div>
  </div>
</template>

<script>

import { getProvinceMapInfo } from '@/utils/map_utils'
import { mapState } from 'vuex'

export default {
  name: 'areaMap',
  data() {
    return {
      // axios实例对象
      axiosInstance: null,
      // 图表的实例对象
      chartInstance: null,
      // 中国地图数据
      chinaMapData: null,
      // 从服务器中获取的所有数据
      allData: null,
      // 获取省份矢量地图数据缓存
      cityMapData: {},
      cityValue:[],
      cityPos: {
        海门: [121.15, 31.89],
        鄂尔多斯: [109.781327, 39.608266],
        招远: [120.38, 37.35],
        舟山: [122.207216, 29.985295],
        齐齐哈尔: [123.97, 47.33],
        盐城: [120.13, 33.38],
        赤峰: [118.87, 42.28],
        青岛: [120.33, 36.07],
        乳山: [121.52, 36.89],
        金昌: [102.188043, 38.520089],
        泉州: [118.58, 24.93],
        莱西: [120.53, 36.86],
        日照: [119.46, 35.42],
        胶南: [119.97, 35.88],
        南通: [121.05, 32.08],
        拉萨: [91.11, 29.97],
        云浮: [112.02, 22.93],
        梅州: [116.1, 24.55],
        文登: [122.05, 37.2],
        上海: [121.48, 31.22],
        攀枝花: [101.718637, 26.582347],
        威海: [122.1, 37.5],
        承德: [117.93, 40.97],
        厦门: [118.1, 24.46],
        汕尾: [115.375279, 22.786211],
        潮州: [116.63, 23.68],
        丹东: [124.37, 40.13],
        太仓: [121.1, 31.45],
        曲靖: [103.79, 25.51],
        烟台: [121.39, 37.52],
        福州: [119.3, 26.08],
        瓦房店: [121.979603, 39.627114],
        即墨: [120.45, 36.38],
        抚顺: [123.97, 41.97],
        玉溪: [102.52, 24.35],
        张家口: [114.87, 40.82],
        阳泉: [113.57, 37.85],
        莱州: [119.942327, 37.177017],
        湖州: [120.1, 30.86],
        汕头: [116.69, 23.39],
        昆山: [120.95, 31.39],
        宁波: [121.56, 29.86],
        湛江: [110.359377, 21.270708],
        揭阳: [116.35, 23.55],
        荣成: [122.41, 37.16],
        连云港: [119.16, 34.59],
        葫芦岛: [120.836932, 40.711052],
        常熟: [120.74, 31.64],
        东莞: [113.75, 23.04],
        河源: [114.68, 23.73],
        淮安: [119.15, 33.5],
        泰州: [119.9, 32.49],
        南宁: [108.33, 22.84],
        营口: [122.18, 40.65],
        惠州: [114.4, 23.09],
        江阴: [120.26, 31.91],
        蓬莱: [120.75, 37.8],
        韶关: [113.62, 24.84],
        嘉峪关: [98.289152, 39.77313],
        广州: [113.23, 23.16],
        延安: [109.47, 36.6],
        太原: [112.53, 37.87],
        清远: [113.01, 23.7],
        中山: [113.38, 22.52],
        昆明: [102.73, 25.04],
        寿光: [118.73, 36.86],
        盘锦: [122.070714, 41.119997],
        长治: [113.08, 36.18],
        深圳: [114.07, 22.62],
        珠海: [113.52, 22.3],
        宿迁: [118.3, 33.96],
        咸阳: [108.72, 34.36],
        铜川: [109.11, 35.09],
        平度: [119.97, 36.77],
        佛山: [113.11, 23.05],
        海口: [110.35, 20.02],
        江门: [113.06, 22.61],
        章丘: [117.53, 36.72],
        肇庆: [112.44, 23.05],
        大连: [121.62, 38.92],
        临汾: [111.5, 36.08],
        吴江: [120.63, 31.16],
        石嘴山: [106.39, 39.04],
        沈阳: [123.38, 41.8],
        苏州: [120.62, 31.32],
        茂名: [110.88, 21.68],
        嘉兴: [120.76, 30.77],
        长春: [125.35, 43.88],
        胶州: [120.03336, 36.264622],
        银川: [106.27, 38.47],
        张家港: [120.555821, 31.875428],
        三门峡: [111.19, 34.76],
        锦州: [121.15, 41.13],
        南昌: [115.89, 28.68],
        柳州: [109.4, 24.33],
        三亚: [109.511909, 18.252847],
        自贡: [104.778442, 29.33903],
        吉林: [126.57, 43.87],
        阳江: [111.95, 21.85],
        泸州: [105.39, 28.91],
        西宁: [101.74, 36.56],
        宜宾: [104.56, 29.77],
        呼和浩特: [111.65, 40.82],
        成都: [104.06, 30.67],
        大同: [113.3, 40.12],
        镇江: [119.44, 32.2],
        桂林: [110.28, 25.29],
        张家界: [110.479191, 29.117096],
        宜兴: [119.82, 31.36],
        北海: [109.12, 21.49],
        西安: [108.95, 34.27],
        金坛: [119.56, 31.74],
        东营: [118.49, 37.46],
        牡丹江: [129.58, 44.6],
        遵义: [106.9, 27.7],
        绍兴: [120.58, 30.01],
        扬州: [119.42, 32.39],
        常州: [119.95, 31.79],
        潍坊: [119.1, 36.62],
        重庆: [106.54, 29.59],
        台州: [121.420757, 28.656386],
        南京: [118.78, 32.04],
        滨州: [118.03, 37.36],
        贵阳: [106.71, 26.57],
        无锡: [120.29, 31.59],
        本溪: [123.73, 41.3],
        克拉玛依: [84.77, 45.59],
        渭南: [109.5, 34.52],
        马鞍山: [118.48, 31.56],
        宝鸡: [107.15, 34.38],
        焦作: [113.21, 35.24],
        句容: [119.16, 31.95],
        北京: [116.46, 39.92],
        徐州: [117.2, 34.26],
        衡水: [115.72, 37.72],
        包头: [110, 40.58],
        绵阳: [104.73, 31.48],
        乌鲁木齐: [87.68, 43.77],
        枣庄: [117.57, 34.86],
        杭州: [120.19, 30.26],
        淄博: [118.05, 36.78],
        鞍山: [122.85, 41.12],
        溧阳: [119.48, 31.43],
        库尔勒: [86.06, 41.68],
        安阳: [114.35, 36.1],
        开封: [114.35, 34.79],
        济南: [117, 36.65],
        德阳: [104.37, 31.13],
        温州: [120.65, 28.01],
        九江: [115.97, 29.71],
        邯郸: [114.47, 36.6],
        临安: [119.72, 30.23],
        兰州: [103.73, 36.03],
        沧州: [116.83, 38.33],
        临沂: [118.35, 35.05],
        南充: [106.110698, 30.837793],
        天津: [117.2, 39.13],
        富阳: [119.95, 30.07],
        泰安: [117.13, 36.18],
        诸暨: [120.23, 29.71],
        郑州: [113.65, 34.76],
        哈尔滨: [126.63, 45.75],
        聊城: [115.97, 36.45],
        芜湖: [118.38, 31.33],
        唐山: [118.02, 39.63],
        平顶山: [113.29, 33.75],
        邢台: [114.48, 37.05],
        德州: [116.29, 37.45],
        济宁: [116.59, 35.38],
        荆州: [112.239741, 30.335165],
        宜昌: [111.3, 30.7],
        义乌: [120.06, 29.32],
        丽水: [119.92, 28.45],
        洛阳: [112.44, 34.7],
        秦皇岛: [119.57, 39.95],
        株洲: [113.16, 27.83],
        石家庄: [114.48, 38.03],
        莱芜: [117.67, 36.19],
        常德: [111.69, 29.05],
        保定: [115.48, 38.85],
        湘潭: [112.91, 27.87],
        金华: [119.64, 29.12],
        岳阳: [113.09, 29.37],
        长沙: [113, 28.21],
        衢州: [118.88, 28.97],
        廊坊: [116.7, 39.53],
        菏泽: [115.480656, 35.23375],
        合肥: [117.27, 31.86],
        武汉: [114.31, 30.52],
        大庆: [125.03, 46.58]
      },
      provinceSaleData:[],
      citySaleData: {},
      // 初始化配置项
      initOption: {
        title: {
          left: 20,
          top: 20,
          text: '中国各省销售分布',
          textStyle: {
            color: '#FFFFFF'
          }
        },
        tooltip: {
          trigger:'item',
          label: true,
          showDelay: 0,
          confine: true,
          // formatter: '{b}<br/>{c}'
          formatter: function (params) {
            if(params.value){
              return params.seriesName + '<br/>' + params.name + ' : ' + params.value;
            }else{
              return params.seriesName + '<br/>' + params.name + ' : ' + '0'; }
          }
        },
        visualMap: {
          right: '10%',                               //组件离容器右侧的距离,'20%'
          bottom: '20%',                              //组件离容器下侧的距离,'20%'
          padding:5,                                   //图例内边距，单位px  5  [5, 10]  [5,10,5,10]
          min: 100,
          max: 1000,
          inRange: {
            color: ['#37a2da', '#32c5e9', '#67e0e3', '#9fe6b8', '#ffdb5c', '#ff9f7f', '#fb7293']
          },
          text: ['High', 'Low'],
          textStyle: {
            color: '#FFFFFF'
          },
          calculable: true
        },
        toolbox: {
          show: true,
          left: 'left',
          top: 'top',
          feature: {
            dataView: { readOnly: false },
            restore: {},
            saveAsImage: {}
          }
        },
        series: [
          {
            name: '',
            type: 'map',
            roam: false, // 禁止拖拽
            map: 'China',
            center: '',
            layoutCenter: ['50%','50%'],
            layoutSize: '90%',
            label:{
              show:true
            },
            emphasis: {
              label: {
                show: true
              },
            },
            data: this.provinceSaleData,
          }
        ]
      }
      }
  },
  computed: {
    ...mapState(['theme']),
  },
  watch: {
    theme() {
      // 销毁当前的图表
      this.chartInstance.dispose()
      // 以最新主题初始化图表对象
      this.initChart()
      // 屏幕适配
      this.screenAdapter()
      // 渲染数据

    },
  },
  async created() {
    await this.getSaleData()
    await this.initChart()
  },
  mounted() {
    this.initChart()
    window.addEventListener('resize', this.screenAdapter)
  },
  unmounted() {
    window.removeEventListener('resize', this.screenAdapter)
  },
  methods: {
    getSaleData() {
      this.$http.get('/provinceSales/queryAllProvinceSales').then((response)=> {
        if(response.data.code === '1') {
          this.provinceSaleData = response.data.result;
          this.initOption.series[0].data = this.provinceSaleData;
        }else {
          console.log('获取省份销量数据失败！')
        }
      })
    },

    // getSaleDataByProvince(province) {
    //   if(!this.citySaleData[province]){
    //     this.$http.get('/')
    //   }
    //
    // }

    // 转换数据
    convertData(data) {
      var res = [];
      for (var i = 0; i < data.length; i++) {
        var geoCoord = this.cityPos[data[i].name];
        if (geoCoord) {
          res.push({
            name: data[i].name,
            value: geoCoord.concat(data[i].value)
          });
        }
      }
      return res;
    },

    // 初始化图表的方法
    async initChart() {
      this.chartInstance = this.$echarts.init(this.$refs.mapRef, this.theme)
      // 获取中国地图的矢量数据： 可以通过发送网络请求获取,static/map/china.json 的数据
      // 由于配置了基础路径，所以不能直接 this.$http.get 来请求 static下的资源
      if (!this.chinaMapData) {
        const { data: res } = await this.$http({
          method:'get',
          url:'https://www.bookbook.cc/api/data-view/map/china'
        })
        this.chinaMapData = res;
      }
      // 注册地图数据
      this.$echarts.registerMap('China', this.chinaMapData)

      this.chartInstance.clear();
      await this.chartInstance.setOption(this.initOption, true);

      // 点击进入省份，查看城市销量事件函数
      this.chartInstance.on('click', async e => {
        // 通过工具函数拿到点击的地图对应的中文拼音(key),和拼接出需要的文件路径(path)
        const ProvinceInfo = getProvinceMapInfo(e.name)
        // 先判断是否已经存在需要请求的数据
        if (!this.cityMapData[ProvinceInfo.key]) {
          // 不存在： 发送请求,获取点击的地图的矢量数据
          const { data: res } = await this.$http.get('/citySales/queryCitySalesByProvince?province=' + e.name);
          const { data: response} = await this.$http({
            method:'get',
            url:'https://www.bookbook.cc/api/data-view/' + ProvinceInfo.path
          })
          console.log('cityMap:', res.result)
          // 把请求到的数据保存下来
          this.cityMapData[ProvinceInfo.key] = response
          // 注册点击的地图
          this.$echarts.registerMap(ProvinceInfo.key, response)
          this.citySaleData = res.result;

          console.log(e.name)
        }

        // 设置最新的配置项
        const changeOption = {
          series: [
            {
              name:'',
              map:ProvinceInfo.key,
              data: this.citySaleData,
            }
          ],
          visualMap: {
            min: 0,
            max: 100,
          },
        }
        // 对海南地图进行偏移放大
        if(e.name === '海南' || e.name === 'hainan') {
          changeOption.series[0].center = [109.844902, 19.0392];
          changeOption.series[0].layoutCenter = ['30%', '30%'];
          changeOption.series[0].layoutSize = "400%";
        }
        // 赋值给 echarts实例
        this.chartInstance.setOption(changeOption)
      })

      // this.chartInstance.on('mouseover',async e =>{
      //   this.getSaleNumberByProvince(e.name);
      // })
    },

    // 不同分辨率的响应式
    screenAdapter() {
      // 当前比较合适的字体大小
      const titleFontSize = (this.$refs.mapRef.offsetWidth / 100) * 3.6

      // 响应式的配置项
      const adapterOption = {
        title: {
          textStyle: {
            fontSize: titleFontSize,
          },
        },
        legend: {
          // 图例宽度
          itemWidth: titleFontSize / 2,
          // 图例高度
          itemHeight: titleFontSize / 2,
          // 间隔
          itemGap: titleFontSize / 2,
          textStyle: {
            fontSize: titleFontSize / 2,
          },
        },
      }

      this.chartInstance.setOption(adapterOption)
      this.chartInstance.resize()
    },

    // 回到中国地图
    chinaMap() {
      this.chartInstance.setOption(this.initOption);
    },
  }
}
</script>

<style lang="less"  scoped>


</style>