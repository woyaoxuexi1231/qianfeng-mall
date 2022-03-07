// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import router from './router'
import store from './store'
import axios from 'axios'
import VCharts from 'v-charts'

Vue.use(ElementUI)
Vue.config.productionTip = false
Vue.prototype.$axios = axios
Vue.use(VCharts)
// router.beforeEach((to, from, next) => {
//     // to 将要访问的的路径
//     // from 代表从哪个路径跳转
//     // next 是一个函数 表示放行 next() 放行 next('/login') 强制跳转
//     //如果用户访问的登录页面，直接放行
//     if (to.path === '/') return next()
//     // 从sessionStorage中获取到保存的 token值
//     const tokenStr = window.sessionStorage.getItem('user')
//     //没有token 强制跳转到登录页
//     if (!tokenStr) return next('/')
//     next()
//   })
/* eslint-disable no-new */
axios.defaults.baseURL="/api";
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
