<template>
  <div v-for="(item,index) in messages" :key="index" class="sub_message">
    <!--头像-->
    <img class="message_img" v-bind:src="item.user.userHeadPortrait" alt="">
    <!--内容-->
    <div class="message_details">
      <div class="message_label">
        <span class="message_userName">{{ item.user.userNickname }}</span>
        <span class="message_userLabel_admin" v-if="item.user.userRights==='ADMIN'">管理员</span>
        <span class="message_userLabel" v-if="item.user.userRights==='USER'">游客</span>
        <span class="message_time">{{ item.messageCreateTime }}</span>
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
          user: {
            userNickname: '',
            userHeadPortrait: '',
            userRights: ''
          },
        }
      ],
    }
  },
  created() {this.queryMessageByLimit()},
  methods: {
    // 分页查询评论数据
    queryMessageByLimit() {
      axios.get('/message/queryMessageByLimit', {params: {page: this.$store.state.paginate.pageShow}}).then(res => {
        this.messages = res.data
      }).catch(function (error) {
        console.log(error);
      })
    },
  },

  // 监听页面数据发生变化 重新渲染博客列表
  watch: {
    "$store.state.paginate": {
      deep: true,//深度监听设置为 true
      handler: function () {
        this.queryMessageByLimit();
      }
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

/*用户标签*/
.message_userName {
  margin: 0 10px;
  width: 20px;
  font-family: "Lucida Calligraphy", cursive, serif, sans-serif;
  font-weight: bold;
}

.message_userLabel {
  font-size: 15px;
  background: rgba(130,130,130);
  color: #FFFFFF;
  margin: 3px;
  padding: 1px 10px;
  border-radius: 5px;
  font-family: "Times New Roman", Times, serif;
}

.message_userLabel_admin {
  font-size: 15px;
  background: rgba(255, 165, 30);
  color: #FFFFFF;
  margin: 3px;
  padding: 1px 10px;
  border-radius: 5px;
  font-family: "Times New Roman", Times, serif;
}

.message_time {
  padding: 0 10px;
  color: #919191;
}

/* 评论内容 */
.message_content {
  padding-top: 15px;
  padding-bottom: 15px;
}
</style>