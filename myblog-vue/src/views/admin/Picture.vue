<template>
  <table>
    <thead>
    <tr>
      <td>照片地址</td>
      <td>照片描述</td>
      <td style="width: 200px">操作</td>
    </tr>
    </thead>
    <tbody>
    <tr v-for="(itemPicture,index) in pictures" :key="index">
      <td>{{ itemPicture.pictureAddress }}</td>
      <td>{{ itemPicture.pictureDescription }}</td>
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
  name: "Photo",
  data() {
    return {
      pictures: {
        pictureId: '',
        pictureAddress: '',
        pictureDescription: ''
      },
    }
  },

  created() {
    axios.get('/picture/selectAll').then(res => {
      this.pictures = res.data
    })
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

<style src="../../static/myTable.css"/>