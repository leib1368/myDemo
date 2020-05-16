<template>
  <div>
    <h1>radio</h1>
    <br>
    <el-radio v-model="label" label="男">男</el-radio>
    <el-radio v-model="label" border size="mini" label="女">女</el-radio>
    <br><br>
    <div>
      <el-checkbox v-model="checked1" label="备选项1" border></el-checkbox>
      <el-checkbox v-model="checked2" label="备选项2" border></el-checkbox>
    </div>
    <br><br>
    <el-input
      placeholder="请输入内容"
      v-model="input"
      clearable>
    </el-input>

  </div>
</template>

<script>
    export default {
        name: "Radio",
        data(){

            return{
                label:this.label,
                checked1: this.checked1,
                checked2: false,
                input: ''
            }
        }
    }
</script>

<style scoped>

</style>
