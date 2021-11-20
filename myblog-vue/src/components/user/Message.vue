<template>
  <div v-for="(item,index) in messages" :key="index" class="sub_message">
    <!--头像-->
    <img class="message_img" src="@/assets/logo.png" alt="">
    <!--内容-->
    <div class="message_details">
      <div class="message_label">
        <span class="message_userName">用户名</span>
        <span class="message_userLabel">标签</span>
        <span class="message_time">{{item.messageCreateTime}}</span>
        <span class="message_restore">回复</span>
      </div>
      <div class="message_content">
        <div>{{item.messageContent}}</div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Message",
  data() {
    return {
      messages: [
        {
          messageId: '',
          messageUserId: '',
          messageCreateTime: '',
          messageContent: '',
        }
      ],
    }
  },
  created() {
    this.queryMessageByLimit();
  },
  methods: {
    queryMessageByLimit() {
      axios.get('/message/queryMessageByLimit', {params: {page: 1}}).then(successResponse => {
        this.messages=successResponse.data
      }).catch(function (error) {
        console.log(error);
      })
    }
  }
}
</script>

<style scoped>
/* 评论 */
.sub_message {
  display: flex;
  width: 100%;
  padding-top: 10px;
  margin-top: 10px;
  overflow: hidden;
}
.message_img {
  width: 50px;
  height: 50px;
  border-radius: 25px;
  margin-right: 10px;
  float: left;

}
.message_details {
  height: auto;
  flex-grow: 1;
}
.message_label {
  padding-top: 15px;
  padding-bottom: 15px;
}
/* 评论内容 */
.message_content {
  padding-top: 15px;
  padding-bottom: 15px;
}
</style>