<template>
  <table>
    <thead>
    <tr>
      <td>标题</td>
      <td>创建日期</td>
      <td>分类</td>
      <td style="width: 200px">操作</td>
    </tr>
    </thead>
    <tbody>
    <tr v-for="(itemBlogs,index) in blogs" :key="index">
      <td>{{ itemBlogs.articleTitle }}</td>
      <td>{{ itemBlogs.articleCreateTime }}</td>
      <td>
        <span v-for="(item,index) in itemBlogs.types" :key="index" class="tableType">
          {{ item.typeName }}
        </span>
      </td>
      <td>
        <button type="button" class="reviseButton" @click="reviseBlog">修改</button>
        <button type="button" class="deleteButton" @click="deleteBlog">删除</button>
      </td>
    </tr>
    </tbody>
  </table>
</template>

<script>
import axios from "axios";

export default {
  name: "Blogs",
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
          types: [
            {
              typeId: '',
              typeName: '',
              typeContent: '',
              typeCreateTime: '',
            }
          ]
        }
      ],
    }
  },

  created() {
    axios.get('/blog/queryAll').then(res => {
      this.blogs = res.data
    }).catch(function (error) {
      console.log(error);
    });
  },

  methods: {
    reviseBlog() {
      alert("修改博客")
    },
    deleteBlog() {
      alert("删除博客")
    }
  }
}
</script>

<style src="../../../static/myTable.css"/>