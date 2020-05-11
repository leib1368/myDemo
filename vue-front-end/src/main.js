// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
// main.js 是我们的入口文件，主要作用是初始化vue实例并使用需要的插件
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios';



Vue.prototype.$http=axios;//修改内部的$http为axios  $http.get("") .post()

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
