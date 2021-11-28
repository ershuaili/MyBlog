<template>
  <table>
    <thead>
    <tr>
      <td>用户昵称</td>
      <td>用户邮箱</td>
      <td>用户头像</td>
      <td style="width: 200px">操作</td>
    </tr>
    </thead>
    <tbody>
    <tr v-for="(item,index) in users" :key="index">
      <td>{{ item.userNickname }}</td>
      <td>{{ item.userEmail }}</td>
      <td>{{ item.userHeadPortrait }}</td>
      <td>
        <button type="button" class="reviseButton" @click="reviseUser">修改</button>
        <button type="button" class="deleteButton" @click="deleteUser">删除</button>
      </td>
    </tr>
    </tbody>
  </table>
</template>

<script>
import axios from "axios";

export default {
  name: "Users",
  data() {
    return {
      users: [
        {
          userId: '',
          userNickname: '',
          userEmail: '',
          userHeadPortrait: '',
          userCreateTime: '',
          authorities: [
            {
              authority: '',
            }
          ],
        }
      ]
    }
  },
  created() {
    axios.get('/user/queryAll').then(res => {
      this.users = res.data;
    }).catch(function (error) {
      console.log(error);
    });
  },
  methods: {
    reviseUser() {
      alert("修改用户信息")
    },
    deleteUser() {
      alert("删除用户信息")
    },
  },
}
</script>

<style src="../../static/myTable.css"/>