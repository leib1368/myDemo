import Vue from 'vue'
import Router from 'vue-router'
import Home from "../components/Home";
import User from "../components/User";
import Student from "../components/Student";
import UserAdd from "../components/UserAdd";
import UserEdit from "../components/UserEdit";

Vue.use(Router)

export default new Router({
  routes: [
    {path: '/', redirect: '/home'},
    {path: '/home', component: Home},
    {
      path: '/user', component: User,
      children:[
        {path:'add',component:UserAdd}, //用户添加路由
        {path:'edit',component:UserEdit}, //用户添加路由
      ]
    },
    {path: '/student', component: Student},
  ]
})
