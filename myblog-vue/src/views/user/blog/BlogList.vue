<template>
  <div v-for="(item,index) in blogs" :key="index" class="blog-list" @click="toBlog(item.articleId)">
    <div class="blogs-left">
      <!--博客标题-->
      <h2>{{ item.articleTitle }}</h2>
      <!--博客描述-->
      <p>{{ item.articleDescription }}</p>
      <!--图标-->
      <div class="blogs-left-icon">
        <img alt="" src="@/assets/svg/calendar.svg">{{ item.articleCreateTime }}&nbsp;
        <img alt="" src="@/assets/svg/eye.svg">{{ item.articleVisitsCount }}&nbsp;
        <img alt="" src="@/assets/svg/comment.svg">{{ item.articleCommentCount }}
      </div>
    </div>
    <div class="blogs-right">
        <img alt="" v-bind:src="item.articleFirstPicture">
    </div>
  </div>
</template>

<script>

import axios from "axios";

export default {
  name: "BlogList",
  data() {
    return {
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
        }
      ]
    }
  },
  // 获取博客列表
  created() {
    axios.get('/blog/selectAll').then(successResponse => {
      this.blogs = successResponse.data;
    }).catch(function (error) {
      console.log(error);
    });
  },

  methods: {
    toBlog(id) {
      console.log(id);
      let routeUrl = this.$router.resolve({
        path: "/blog",
        query: {id: id}
      });
      window.open(routeUrl.href, '_blank');
    },
  }
}
</script>

<style scoped>
.blog-list {
  background-color: rgb(255, 255, 255, 0.7);
  width: 60%;
  height: 200px;
  margin: 30px auto 0;
  border-radius: 5px;
  clear: both;
}

.blogs-left {
  float: left;
  width: 70%;
  height: 200px;
  margin-left: 20px;
}

.blogs-left-icon {
  height: 140px;
}

.blogs-left-icon > img {
  width: 20px;
}

.blogs-right {
  float: left;
  width: 27%;
  height: 200px;
  border-radius: 5px;
  line-height: 200px;
}

img {
  width: 95%;
  height: 80%;
  z-index: 1;
  vertical-align: middle;
  border-radius: 5px;
}

</style>