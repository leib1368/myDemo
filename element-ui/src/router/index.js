import Vue from 'vue'
import Router from 'vue-router'
import Button from "../components/Button";
import Layout from "../components/Layout";
import Container from "../components/Container";
import Radio from "../components/Radio";

Vue.use(Router)

export default new Router({
  routes: [
    {path: '/button',component:Button},
    {path: '/layout',component:Layout},
    {path: '/container',component:Container},
    {path: '/radio',component:Radio},
  ]
})
