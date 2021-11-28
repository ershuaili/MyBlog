<template>
  <table>
    <thead>
    <tr>
      <td>留言用户名</td>
      <td>留言内容</td>
      <td style="width: 200px">操作</td>
    </tr>
    </thead>
    <tbody>
    <tr v-for="(item,index) in messages" :key="index">
      <td>{{ item.messageUserNickname }}</td>
      <td>{{ item.messageContent }}</td>
      <td>
        <button type="button" class="deleteButton" @click="deleteMessage">删除</button>
      </td>
    </tr>
    </tbody>
  </table>
</template>

<script>
import axios from "axios";

export default {
  name: "Comment",
  data() {
    return {
      messages: [
        {
          messageId: '',
          messageUserNickname: '',
          messageContent: '',
          messageCreateTime: ''
        }
      ],

    }
  },
  created() {
    axios.get('/message/queryAll').then(res => {
      this.messages = res.data
    }).catch(function (error) {
      console.log(error);
    });
  },
  methods:{
    deleteMessage(){
      alert("执行删除方法")
    }
  },
}
</script>

<style src="../../static/myTable.css"/>