import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import router from './router'
import store from './store'
import axios from 'axios'
import * as echarts from 'echarts'

// 引入全局样式文件
import './assets/css/global.less'



// axios 配置接口默认路径
axios.defaults.baseURL = 'http://127.0.0.1:8181' // 使用接口数据 可把后端仓库拉下来

Vue.prototype.$http = axios

// 把echarts挂载到 Vue原型上，以便在全局访问
Vue.prototype.$echarts = echarts

// 是否启动生产消息
Vue.config.productionTip = false;
Vue.use(ElementUI);

new Vue({
    router,
    store,
    render: (h) => h(App),
}).$mount('#app')