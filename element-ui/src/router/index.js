import Vue from 'vue'
import Router from 'vue-router'
import Button from "../components/Button";
import Layout from "../components/Layout";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/button',component:Button
    },
    {
      path: '/layout',component:Layout
    }
  ]
})
