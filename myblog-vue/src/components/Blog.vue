<template>
  <md-editor v-model="blog.articleContent" class="md-editor" previewOnly/>
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
      ]
    }
  },

  created() {
    axios.get('/blog/selectOne?id=' + this.$route.params.id).then(successResponse => {
      this.blog = successResponse.data;
      document.title = successResponse.data.articleTitle
    }).catch(function (error) {
      console.log(error);
    });
  },
}
</script>

<style scoped>
.md-editor {
  width: 80%;
  margin: 0 auto;
  background: rgba(210, 206, 206, 0.7);
  padding-right: 50px;
  padding-left: 50px;
  z-index: -2;
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