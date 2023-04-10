<template>
  <div class="screen-container" :style="containerStyle">
    <div class="screen-body">
      <section class="screen-left">
        <div id="left-top" :class="{ fullscreen: fullScreenStatus.trend }" >
          <!-- 设备信息图表 -->
          <!--          <Trend ref="trend"></Trend>-->
          <DeviceInfoTable></DeviceInfoTable>
          <!--          放大按钮-->
          <!--          <div class="resize">-->
          <!--            <span @click="changeSize('trend')" :class="['iconfont', fullScreenStatus.trend ? 'icon-compress-alt' : 'icon-expand-alt']"></span>-->
          <!--          </div>-->
        </div>
      </section>
      <section class="screen-middle">
        <div id="middle-top" :class="{ fullscreen: fullScreenStatus.map }">
          <!-- 销量分布图表 -->
          <areaMap ref="map"></areaMap>
          <!--          <NewMap></NewMap>-->
          <!--          <div class="resize">-->
          <!--            <span @click="changeSize('map')" :class="['iconfont', fullScreenStatus.map ? 'icon-compress-alt' : 'icon-expand-alt']"></span>-->
          <!--          </div>-->
        </div>
      </section>
    </div>
  </div>
</template>

<script>



import { mapState } from 'vuex';
import { getThemeValue } from '../utils/theme_utils';

import DeviceInfoTable from "@/components/DeviceInfoTable";
import areaMap from "@/components/Area";

export default {
  name: "homePage",
  components:{
    DeviceInfoTable,
    areaMap,
  },
  data() {
    return {
      // 各组件是否全屏状态
      fullScreenStatus: {
        trend: false,
        seller: false,
        map: false,
        rank: false,
        hot: false,
        stock: false,
      },
    }
  },
  created() {

  },
  computed: {
    ...mapState(['theme']),
    containerStyle() {
      return {
        backgroundColor: getThemeValue(this.theme).backgroundColor,
        color: getThemeValue(this.theme).titleColor,
      }
    },
  },
  unmounted() {},
  methods: {},
}
</script>

<style lang="less" scoped>
// 全屏样式的定义
.fullscreen {
  position: fixed !important;
  top: 0 !important;
  left: 0 !important;
  width: 100% !important;
  height: 100% !important;
  margin: 0 !important;
  z-index: 9999;
}

.screen-container {
  width: 100%;
  height: 100%;
  padding: 0 20px;
  //background-color: #161522;
  background: url("../assets/images/map_bg.jpg") no-repeat center;
  color: #fff;
  box-sizing: border-box;
}
.screen-header {
  width: 100%;
  height: 64px;
  font-size: 20px;
  position: relative;
  > div {
    img {
      width: 100%;
    }
  }
  .title {
    position: absolute;
    left: 50%;
    top: 50%;
    font-size: 30px;
    transform: translate(-50%, -50%);
  }
  .title-right {
    display: flex;
    align-items: center;
    position: absolute;
    right: 0px;
    top: 50%;
    transform: translateY(-80%);
  }
  .qiehuan {
    width: 28px;
    height: 21px;
    cursor: pointer;
  }
  .datetime {
    font-size: 15px;
    margin-left: 10px;
  }
  .logo {
    position: absolute;
    left: 0px;
    top: 50%;
    transform: translateY(-80%);
    a {
      text-decoration: none;
    }
  }
}
.screen-body {
  width: 100%;
  height: 100%;
  display: flex;
  margin-top: 10px;
  .screen-left {
    height: 100%;
    width: 30%;
    #left-top {
      height: 53%;
      position: relative;
    }
    #left-bottom {
      height: 31%;
      margin-top: 25px;
      position: relative;
    }
  }
  .screen-middle {
    height: 100%;
    width: 47.5%;
    margin-left: 1.6%;
    margin-right: 1.6%;
    #middle-top {
      width: 100%;
      height: 56%;
      position: relative;
    }
    #middle-bottom {
      margin-top: 25px;
      width: 100%;
      height: 28%;
      position: relative;
    }
  }
  .screen-right {
    height: 100%;
    width: 27.6%;
    #right-top {
      height: 56%;
      position: relative;
    }
    #right-bottom {
      height: 28%;
      margin-top: 25px;
      position: relative;
    }
  }
}
.resize {
  position: absolute;
  right: 20px;
  top: 20px;
  cursor: pointer;
}
</style>