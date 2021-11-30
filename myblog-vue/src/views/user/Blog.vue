<template>
  <md-editor v-model="blog.articleContent" class="md-editor" previewOnly/>
  <!--评论-->
  <div class="comment">
    <!--标识-->
    <div class="end">
      <span>END</span>
    </div>
    <!-- 评论输入框 -->
    <div class="message_input">
      <textarea class="input_textarea" placeholder="来都来了讲点啥吧QWQ"/>
      <button type="button" class="input_button">提交</button>
    </div>
    <!--评论展示框-->
    <div>
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
    </div>
  </div>
</template>

<script>
import axios from "axios";
import MdEditor from 'md-editor-v3';
import 'md-editor-v3/lib/style.css';
import Message from "@/components/user/Message";

export default {
  name: "Blog",
  components: {Message, MdEditor},
  data() {
    return {
      blog: [
        {
          articleId: '',
          articleTitle: '',
          articleFirstPicture: '',
          articleDescription: '',
          articleContent: '',
          articleCreateTime: '',
          articleUpdateTime: '',
          articleVisitsCount: '',
          articleCommentCount: '',
          articleLikeCount: '',
        }
      ]
    }
  },

  created() {
    axios.get('/blog/selectOne?id=' + this.$route.query.id).then(res => {

      this.blog = res.data;
      document.title = res.data.articleTitle
    }).catch(function (error) {
      console.log(error);
    });
  },
}
</script>

<style scoped>
.md-editor {
  width: 1300px;
  margin: 0 auto;
  background: rgba(210, 206, 206, 0.7);
  padding-right: 50px;
  padding-left: 50px;
  z-index: -2;
}

.comment {
  width: 1200px;
  margin: 0 auto;
  background: rgba(210, 206, 206, 0.7);
  padding-right: 50px;
  padding-left: 50px;
}

/*文章结束标志*/
.end span {
  display: flex;
  justify-content: center;
  align-items: center;
  padding-top: 50px;
  padding-bottom: 50px;
}

.end span:after, .end span:before {
  background: #555;
  content: "";
  height: 2px;
  width: 500px;
}

.end span:after {
  margin: 0 0 0 10px;
}

.end span:before {
  margin: 0 10px 0 0;
}

/* 评论输入 */
.message_input {
  height: 300px;
  padding: 5px;
  border-style: solid;
  border-color: rgb(154, 149, 149);
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
  background: url("../../assets/comment_bg.png") 100% 100% no-repeat;
}

.input_button {
  float: right;
  background-color: antiquewhite;
}

@media screen and (max-width: 768px) {
  .md-editor {
    width: 100%;
    margin: 0 auto;
    background: rgba(210, 206, 206, 0.9);
    padding-left: 5px;
    padding-right: 5px;
    z-index: -2;
  }
}
</style>