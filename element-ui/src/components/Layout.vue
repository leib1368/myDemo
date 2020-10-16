<template>
    <div>
        <h1>layout使用</h1>

        <el-row>
          <el-col :span="12" style="border: 1px red solid;">12份 占（1/2）</el-col>
          <el-col :span="12" style="border: 1px red solid">12份 占（1/2）</el-col>
        </el-row>

      <el-button type="text" @click="dialogVisible = true">点击打开 Dialog</el-button>

      <el-dialog
        title="提示"
        :visible.sync="dialogVisible"
        width="30%"
        :before-close="handleClose">
        <span>这是一段信息</span>
        <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
         </span>
      </el-dialog>

    </div>
</template>

<script>
    export default {
        name: "Layout.vue",
      data() {
        return {
          dialogVisible: false
        };
      },
      methods: {
        handleClose(done) {
          this.$confirm('确认关闭？')
            .then(_ => {
              done();
            })
            .catch(_ => {});
        }
      }
    }
</script>

<style scoped>

</style>
