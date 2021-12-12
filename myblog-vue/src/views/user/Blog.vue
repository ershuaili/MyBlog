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
      <textarea v-model="input_textarea" class="input_textarea" placeholder="来都来了讲点啥吧QWQ"/>
      <button @click="textareaSubmit" type="button" class="input_button">提交</button>
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
            <span class="reply" @click="reply($event)">回复</span>
          </div>
          <div class="message_content">
            <!--父评论内容-->
            <div>{{ item.commentContent }}</div>
            <!--子级评论输入框-->
            <div class="a">fdsa</div>
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
import router from "../../router";

export default {
  name: "Blog",
  components: {MdEditor},
  data() {
    return {
      reply_input: '',
      isShow: false,
      input_textarea: '',
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
    this.getComment();
  },

  methods: {
    // 根据博客id获取评论信息
    getComment() {
      axios.get('/comment/queryAllByBlogId', {params: {blogId: this.$route.query.id}}).then(res => {
        this.comment = res.data
      }).catch(function (error) {
        console.log(error)
      });
    },

    // 用户提交评论
    textareaSubmit() {
      if (localStorage.getItem("token") === null) {
        alert("您还没登录请先登录")
        router.push("/login");
      } else {
        let params = new URLSearchParams();
        params.append("token", localStorage.getItem("token"))
        // 校验登录状态和用户
        axios.post('/user/checkToken', params)
            .then(res => {
              // console.log("评论用id" + res.data.userId)
              // console.log("评论文章id" + this.$route.query.id.toString())
              // console.log("评论内容" + this.input_textarea)
              // console.log("评论父评论id" + 1)

              let params = new URLSearchParams();
              // 评论用户名
              params.append("commentUserId", res.data.userId)
              // 评论文章id
              params.append("commentArticleId", this.$route.query.id.toString())
              // 评论内容
              params.append("commentContent", this.input_textarea)
              // 评论父评论id
              params.append("parentCommentId", 1)
              // 判断用户输入是否为空
              if (this.input_textarea === '') {
                alert("请输入内容")
              } else {
                axios.post('/comment/insert', params).then(() => {
                  console.log(params)
                  // 清空输入框
                  this.input_textarea = "";
                  // 刷新消息列表
                  this.getComment();
                })
              }
            }).catch(function (error) {
          alert("登录信息错误,返回登录");
          router.push("/login");
          console.log(error);
        });
      }
    },

    // 用户回复
    reply(e) {
      console.log("回复")
      console.log(e.currentTarget.parentElement.nextElementSibling.getElementsByClassName('a').innerHTML)
    }
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

/*回复*/
.reply {
  float: right;
  color: rgb(64, 158, 255);
  cursor: pointer;
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