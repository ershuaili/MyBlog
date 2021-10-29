<template>
  <div v-for="(item,index) in blogs" :key="index" class="blog-list">
    <div class="blogs-left">
      <!--博客标题-->
      <h1>{{ item.articleTitle }}</h1>
      <!--博客描述-->
      <p>{{ item.articleDescription }}</p>
      <!--图标-->
      <div class="blogs-left-icon">
        <img alt="" src="../../assets/svg/calendar.svg">{{ item.articleCreateTime }}&nbsp;
        <img alt="" src="../../assets/svg/eye.svg">{{ item.articleVisitsCount }}&nbsp;
        <img alt="" src="../../assets/svg/message.svg">{{ item.articleCommentCount }}
      </div>
    </div>
    <div class="blogs-right">
      <a @click="toAbout(item.articleId)">
        <img alt="" v-bind:src="item.articleFirstPicture">
      </a>
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
  created() {
    axios.get('/blog/selectAll').then(successResponse => {
      this.blogs = successResponse.data;
    }).catch(function (error) {
      console.log(error);
    });
  },

  methods: {
    toAbout(id) {
      console.log(id);
      this.$router.push({path: `/blog/${id}`});
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