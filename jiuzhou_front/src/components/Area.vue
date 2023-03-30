<template>
  <div class="com-container" @dblclick="chinaMap">
    <div class="com-chart" ref="mapRef"></div>
  </div>
</template>

<script>

import { getProvinceMapInfo } from '@/utils/map_utils'
import { mapState } from 'vuex'

export default {
  name: "Area",
  data() {
    return {

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
      this.updateChart()
    }
  },
  created() {
    this.getData();
  },
  mounted() {
    this.initChart();

    window.addEventListener('resize', this.screenAdapter);
    // 主动触发 响应式配置
    this.screenAdapter()
  },
  destroyed() {
    window.removeEventListener('resize', this.screenAdapter)
  },
  methods: {
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
        const { data: res } = await this.$http.get('/map/china')
        this.chinaMapData = res
      }
      // 注册地图数据
      this.$echarts.registerMap('china', this.chinaMapData)

      // 初始化配置项
      const initOption = {
        title: {
          text: '▎销售分布',
          left: 20,
          top: 20,
        },
        geo: {
          type: 'map',
          map: 'china',
          top: '5%',
          bottom: '5%',
          //允许拖动及缩放
          roam: true,
          // zoom: 1.1, //默认缩放比例
          itemStyle: {
            // 地图的填充色
            areaColor: 'rgb(62,170,253)',
            // 省份的边框色
            borderColor: '#ffffff',
          },
          label: {
            show: true,
            // 省份名称颜色
            color: '',
            formatter: `{a}`,
          },
        },
      }
      this.chartInstance.setOption(initOption)

      // 进入省份事件函数
      this.chartInstance.on('click', async e => {
        // 通过工具函数拿到点击的地图对应的中文拼音(key),和拼接出需要的文件路径(path)
        const ProvinceInfo = getProvinceMapInfo(e.name)

        // 先判断是否已经存在需要请求的数据
        if (!this.cityMapData[ProvinceInfo.key]) {
          // 不存在： 发送请求,获取点击的地图的矢量数据
          const { data: res } = await this.$http.get(ProvinceInfo.path)
          // 把请求到的数据保存下来
          this.cityMapData[ProvinceInfo.key] = res
          // 注册点击的地图
          this.$echarts.registerMap(ProvinceInfo.key, res)
        }

        // 设置最新的配置项
        const changeOption = {
          geo: {
            map: ProvinceInfo.key,
          },
        }
        // 赋值给 echarts实例
        this.chartInstance.setOption(changeOption)
      })
    },
  }
}
</script>

<style scoped>

</style>