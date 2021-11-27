<template>
  <!-- 标签页-头部 -->
  <div class="types">
    <div class="message">
      <div class="message_left">分类</div>
      <div class="message_right">
        一共<span class="right_number">{{ types.length }}</span>个
      </div>
    </div>

    <div class="labels">
      <a v-for="(item,index) in types" :key="index" class="label" @click="getBlogsByType">{{ item.typeName }}</a>
    </div>
  </div>
  <!-- 标签页-主体 -->
  <BlogLabel ref="child"/>
  <UserBottom v-if="this.isShow"/>
</template>

<script>
import axios from "axios";
import BlogLabel from "@/components/user/BlogLabel";
import UserBottom from "@/components/user/UserBottom";

export default {
  name: "Types",
  components: {UserBottom, BlogLabel},
  data() {
    return {
      types: [
        {
          typeId: '',
          typeName: '',
          typeContent: '',
          typeCreateTime: '',
          blogs: [
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
              types: '',
            }
          ]
        }
      ],
      isShow: false,
    }
  },
  created() {
    // 获取分类所有信息
    axios.get('/type/queryAll').then(res => {
      this.types = res.data;
    }).catch(function (error) {
      console.log(error);
    });
    // 进入页面显示列表
    axios.get('/type/queryByTypeName', {params: {typeName: 'Java'}}).then(res => {
      this.$refs.child.getBlogListByType(res.data.blogs);
      this.isShow = res.data.blogs.length >= 2;
    }).catch(function (error) {
      console.log(error);
    });
  },

  methods: {
    // 根据标签获取博客信息
    getBlogsByType(e) {
      axios.get('/type/queryByTypeName', {params: {typeName: e.target.innerHTML}}).then(res => {
        this.$refs.child.getBlogListByType(res.data.blogs);
        this.isShow = res.data.blogs.length >= 2;
      }).catch(function (error) {
        console.log(error);
      });
    }
  }
}
</script>

<style scoped>

.types {
  background-color: rgb(255, 255, 255, 0.7);
  width: 60%;
  margin: 10px auto 0;
  height: 150px;
}

.message {
  height: 20%;
  width: 100%;
  border-bottom-style: solid;
  border-bottom-width: 2px;
}

.message_left {
  float: left;
  margin: 5px;
  font-size: 20px;
  font-weight: bold;
  font-family: "Lucida Calligraphy", cursive, serif, sans-serif;
}

.message_right {
  float: right;
  margin: 4px;
}

.right_number {
  font-size: 20px;
  color: #ffaa7f;
}

.labels {
  clear: both;
}

.label {
  display: inline-block;
  float: left;
  border-style: solid;
  border-width: 2px;
  border-radius: 10px;
  width: fit-content;
  height: 30px;
  margin: 10px;
  padding-left: 10px;
  padding-right: 10px;
  line-height: 30px;
  text-decoration: none;
}

</style>