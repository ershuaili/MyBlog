<template>
  <BlogLabel ref="child"/>
  <Paginate/>
  <UserBottom v-if="this.isShow"/>
</template>

<script>
import UserBottom from "@/components/user/UserBottom";
import Paginate from "@/components/common/Paginate";
import BlogLabel from "@/components/user/BlogLabel";
import axios from "axios";

export default {
  name: "BlogList",
  components: {BlogLabel, Paginate, UserBottom},
  created() {
    this.getBlogList();
  },

  data() {
    return {
      isShow: false
    }
  },
  methods: {
    // 获取博客分页信息
    getLength() {
      axios.get('/blog/queryCommonMessage').then(res => {
        // 五个标签为一页
        this.$store.dispatch('setPageNum', Math.ceil((res.data.BlogCount) / 5))
      }).catch(function (error) {
        console.log(error);
      })
    },

    // 分页查询博客信息
    getBlogList() {
      axios.get('/blog/queryBlogByLimit', {params: {page: this.$store.state.paginate.pageShow}}).then(res => {
        this.$refs.child.getBlogList(res.data);
        this.isShow = res.data.length >= 2;
        // 页面数据渲染后加载底部导航
        this.getLength()
      }).catch(function (error) {
        console.log(error);
      });
    },
  },
  // 监听页面数据发生变化 重新渲染博客列表 分页
  watch: {
    "$store.state.paginate": {
      deep: true,//深度监听设置为 true
      handler: function () {
        this.getBlogList();
      }
    }
  }
}
</script>