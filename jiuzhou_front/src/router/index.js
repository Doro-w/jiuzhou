import Vue from 'vue'
import VueRouter from 'vue-router'

// 懒加载路由
// const Home = () => import( /* webpackChunkName: "data-views" */ "views/Home")
// const SellerPage = () => import( /* webpackChunkName: "data-views" */ "views/SellerPage")
// const TrendPage = () => import( /* webpackChunkName: "data-views" */ "views/TrendPage")
// const MapPage = () => import( /* webpackChunkName: "data-views" */ "views/MapPage")
// const RankPage = () => import( /* webpackChunkName: "data-views" */ "views/RankPage")
// const HotPage = () => import( /* webpackChunkName: "data-views" */ "views/HotPage")
// const StockPage = () => import( /* webpackChunkName: "data-views" */ "views/StockPage")

// 普通方式
import Home from "@/views/Home.vue"


Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        redirect: '/home'
    },
    {
        path: '/home',
        component: Home
    }
]

const router = new VueRouter({
    routes,
    mode: "history"
})

export default router
