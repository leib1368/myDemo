<template>
    <div>
      <h1>学生列表</h1>
      <table border="1">
        <tr>
          <td>编号</td>
          <td>姓名</td>
          <td>年龄</td>
          <td>生日</td>
          <td>操作</td>
        </tr>
        <tr v-for="user in users">
          <td>{{ user.id }}</td>
          <td>{{ user.name }}</td>
          <td>{{ user.age }}</td>
          <td>{{ user.bir }}</td>
          <td><a href="javascript:;" @click="delRow(user.id)">删除</a> <a :href="'#/user/edit?id='+user.id">修改</a></td>
        </tr>
      </table>

      {{ message }}
    </div>
</template>

<script>
    export default {

        name: "Student",
      data() {
        return {
          message: 'Hello Vue!',
          users: [],
          u1:{
            id: 1,
            name: 'aaa',
            age: 13,
            bir: '19660808'
          },
          u2:{
            id: 2,
            name: 'aaa',
            age: 13,
            bir: '19660808'
          },

        }
      },
    }
</script>

<style scoped>

</style>
