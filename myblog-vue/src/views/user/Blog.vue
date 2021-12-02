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
      <div v-for="(item,index) in comment" :key="index" class="sub_message father_message">
        <!--头像-->
        <img class="message_img" v-bind:src="item.user.userHeadPortrait" alt="">
        <!--内容-->
        <div class="message_details">
          <div class="message_label">
            <span class="message_userName">{{ item.user.userNickname }}</span>
            <span class="message_userLabel_admin" v-if="item.user.userRights==='ADMIN'">管理员</span>
            <span class="message_userLabel" v-if="item.user.userRights==='USER'">游客</span>
            <span class="message_time">{{ item.commentCreateTime }}</span>
          </div>
          <div class="message_content">
            <!--父评论内容-->
            <div>{{ item.commentContent }}</div>
            <!--子评论内容-->
            <div v-for="(childItem,index) in item.childComments" :key="index" class="sub_message">
              <!--头像-->
              <img class="message_img" v-bind:src="childItem.user.userHeadPortrait" alt="">
              <!--内容-->
              <div class="message_details">
                <div class="message_label">
                  <span class="message_userName">{{ childItem.user.userNickname }}</span>
                  <span class="message_userLabel_admin" v-if="childItem.user.userRights==='ADMIN'">管理员</span>
                  <span class="message_userLabel" v-if="childItem.user.userRights==='USER'">游客</span>
                  <span class="message_time">{{ childItem.commentCreateTime }}</span>
                </div>
                <div class="message_content">
                  <div>{{ childItem.commentContent }}</div>
                </div>
              </div>
            </div>
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

export default {
  name: "Blog",
  components: {MdEditor},
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
      ],

      comment: [
        {
          commentArticleId: '',
          commentContent: '',
          commentCreateTime: '',
          commentId: '',
          commentUserId: '',
          parentCommentId: '',
          user: {
            userNickname: '',
            userHeadPortrait: '',
            userRights: ''
          },
          // 子评论
          childComments: [
            {
              commentArticleId: '',
              commentContent: '',
              commentCreateTime: '',
              commentId: '',
              commentUserId: '',
              parentCommentId: '',
              user: {
                userNickname: '',
                userHeadPortrait: '',
                userRights: ''
              },
            }
          ],
        }
      ],
    }
  },

  created() {
    // 获取博客信息
    axios.get('/blog/selectOne?id=' + this.$route.query.id).then(res => {
      this.blog = res.data;
      document.title = res.data.articleTitle
    }).catch(function (error) {
      console.log(error);
    });

    // 根据博客id获取评论信息
    axios.get('/comment/queryAllByBlogId', {params: {blogId: this.$route.query.id}}).then(res => {
      this.comment = res.data
      console.log(this.comment)
    }).catch(function (error) {
      console.log(error)
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
  margin: 0 auto 40px;
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

/* 评论 */
.sub_message {
  display: flex;
  width: 100%;
  padding-top: 10px;
  margin-top: 10px;
  overflow: hidden;
}

.father_message {
  border-bottom-style: solid;
  border-width: 1px;
  border-color: #9a9595;
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
  background: rgba(130, 130, 130);
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