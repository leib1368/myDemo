<template>
  <div>
    <a href="#/home">主页</a>
    <a href="#/user">用户管理</a>
    <a href="#/student">学生管理</a>
    <a href="#/link">Link</a>

    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>

</style>
<!--App.vue是我们的主组件，所有页面都是在App.vue下进行切换的。
其实你也可以理解为所有的路由也是App.vue的子组件。
所以我将router标示为App.vue的子组件。-->
