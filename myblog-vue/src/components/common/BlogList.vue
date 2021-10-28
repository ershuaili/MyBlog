<template>
  <div v-for="(item,index) in blogs" :key="index" class="blog-list">
    <div class="blogs-left">
      <h1>{{ item.articleTitle }}</h1>
      <p>博客id是:{{ item.articleId }}</p>
      <p>{{ item.articleDescription }}</p>
      <div class="blogs-left-icon">
        <p>这里是一些图标</p>
      </div>
    </div>
    <div class="blogs-right">
      <a @click="toAbout">
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
    this.getBlogs();
  },
  methods: {
    toAbout() {
      this.$router.push({
        name: 'About',
      })
    },

    getBlogs() {
      axios.get('/blog/selectAll').then(successResponse => {
        this.blogs = successResponse.data;
      }).catch(function (error) {
        console.log(error);
      });
    }
  }
}
</script>

<style scoped>
.blog-list {
  background-color: rgb(255, 255, 255, 0.5);
  width: 70%;
  height: 200px;
  margin: 30px auto 0;
  border-radius: 5px;
}

.blogs-left {
  float: left;
  width: 70%;
  height: 200px;
}

.blogs-right {
  float: left;
  width: 30%;
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