<template>
  <div class="message">
    <!-- 评论输入框 -->
    <div class="message_input">
      <textarea v-model="input_textarea" class="input_textarea" placeholder="来都来了讲点啥吧QWQ"/>
      <button @click="textareaSubmit" type="button" class="input_button">提交</button>
    </div>
    <!-- 评论列表 -->
    <div class="message_comments">
      <div class="message_head">
        <span class="number">{{ this.messages }}</span>条留言
      </div>
      <!-- 留言 -->
      <Message ref="message"/>
    </div>
    <!-- 分页查询 -->
    <Paginate/>
  </div>
</template>

<script>
import Paginate from "@/components/common/Paginate";
import Message from "@/components/user/Message";
import axios from "axios";
import router from "@/router";

export default {
  name: "Messages",
  components: {Message, Paginate},
  data() {
    return {
      input_textarea: '',
      nickname: '',
      messages: '',
    }
  },

  created() {
    this.queryAllNumber();
  },
  methods: {
    // 获取评论分页信息
    queryAllNumber() {
      axios.get('/message/queryAllNumber').then(res => {
        this.$store.dispatch('setPageNum', Math.ceil((res.data) / 5))
        this.messages = res.data;
      }).catch(function (error) {
        console.log(error);
      })
    },

    // 用户评论提交
    textareaSubmit() {
      if (localStorage.getItem("token") === null) {
        alert("您还没登录请先登录")
        router.push("/login");
      } else {
        let params = new URLSearchParams();
        params.append("token", localStorage.getItem("token"))
        axios.post('/user/checkToken', params)
            .then(res => {
              let params = new URLSearchParams();
              params.append("messageUserNickname", res.data.nickname)
              params.append("messageContent", this.input_textarea)
              axios.post('/message/insert', params)
                  .then(res => {
                    // 清空输入框
                    this.input_textarea = "";
                    // 消息数加一
                    this.messages++;
                    // 刷新消息列表
                    this.$refs.message.queryMessageByLimit();
                    // 刷新分页信息
                    this.$store.dispatch('setPageNum', Math.ceil((this.messages) / 5))
                  })
            }).catch(function (error) {
          alert("登录信息错误,返回登录");
          router.push("/login");
          console.log(error);
        });
      }
    },
  },
}
</script>

<style scoped>
.message {
  margin: 10px auto;
  padding: 20px;
  width: 70%;
  height: auto;
  background-color: rgb(255, 255, 255, 0.7);
  border-radius: 10px;
}

/* 评论输入 */
.message_input {
  height: 300px;
  padding: 5px;
  border-style: solid;
  border-color: rgb(182, 182, 182);
  border-width: 1px;
  border-radius: 5px;
}

.input_textarea {
  width: 100%;
  height: 270px;
  box-sizing: border-box;
  resize: none;
  border: 0;
  outline: none;
  font-size: 17px;
  font-family: 'Mulish', -apple-system, 'Noto Serif SC', "PingFang SC", "Microsoft Yahei UI", "Microsoft Yahei", sans-serif;
  background: url(../../assets/comment_bg.png) 100% 100% no-repeat;
}

.input_button {
  float: right;
  background-color: antiquewhite;
}
.number{
  color: #ffaaff;
  margin: 0 15px;
}
/* 评论列表 */
.message_comments {
  width: 100%;
}

.message_head {
  font-size: 30px;
}

</style>