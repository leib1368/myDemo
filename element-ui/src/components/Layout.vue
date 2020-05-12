<template>
    <div>
        <h1>layout使用</h1>

        <el-row>
          <el-col :span="12" style="border: 1px red solid;">12份 占（1/2）</el-col>
          <el-col :span="12" style="border: 1px red solid">12份 占（1/2）</el-col>
        </el-row>
      <el-header></el-header>
      <el-header></el-header>

    </div>
</template>

<script>
    export default {
        name: "Layout.vue"
    }
</script>

<style scoped>

</style>
