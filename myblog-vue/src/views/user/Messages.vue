<template>
  <div class="message">
    <!-- 评论输入框 -->
    <div class="message_input">
      <textarea v-model="input_textarea" class="input_textarea"> </textarea>
      <button @click="textareaSubmit" type="button" class="input_button">提交</button>
    </div>
    <!-- 评论列表 -->
    <div class="message_comments">
      <div class="message_head">
        <span class="number">{{ this.$store.state.paginate.messages }}</span>条留言
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
    }
  },
  created(){this.getLength()},
  methods: {
    // 获取数据总数
    getLength() {
      axios.get('/message/queryAllNumber').then(res => {
        this.$store.state.paginate.messages = res.data
        this.$store.state.paginate.pageNum = Math.ceil((res.data) / 10)
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
                    // 更新页面信息
                    this.$refs.message.queryMessageByLimit();
                    this.input_textarea = "";
                    this.$store.state.paginate.messages++
                  })
            }).catch(function (error) {
          console.log(error);
        });
      }
    },
  },
  watch: {
    "$store.state.paginate":{
      deep:true,//深度监听设置为 true
      handler:function(){
        this.getLength();
      }
    }
  }
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