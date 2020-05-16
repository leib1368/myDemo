<template>
    <div>
      <h1>container</h1>
      <el-container>
      <!-- 子元素中有 el-header 或 el-footer 时为 vertical，否则为 horizontal-->
        <el-header height="80px"><div  ><h1>head</h1></div></el-header>

        <el-container>      <!--容器嵌套-->
          <el-aside width="200px"><div ><h1>菜单</h1></div></el-aside>
          <el-main><div>我是中心</div></el-main>
        </el-container>

        <el-footer>
          <div>底部</div>
        </el-footer>

      </el-container>
    </div>
</template>

<script>
    export default {
        name: "Container"
    }
</script>

<style scoped>
  .el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
  }

  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    line-height: 200px;
  }

  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 160px;
  }

  body > .el-container {
    margin-bottom: 40px;
  }

  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }

  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }
</style>
