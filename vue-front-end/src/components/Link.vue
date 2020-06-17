<template>
  <div>
    <h1>参数跳转测试</h1>
    {{this.$route.params.id}}
    -------------
    {{id}}
  </div>
</template>

<script>
    export default {
        name: "Link",
        props: ['id']
    }
</script>

<style scoped>

</style>
