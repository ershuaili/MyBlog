<template>
  <table>
    <thead>
    <tr>
      <td>标题</td>
      <td>描述</td>
      <td>博客标题</td>
      <td style="width: 200px">操作</td>
    </tr>
    </thead>
    <tbody>
    <tr v-for="(itemTypes,index) in types" :key="index">
      <td>{{ itemTypes.typeName }}</td>
      <td>{{ itemTypes.typeContent }}</td>
      <td>
        <span v-for="(item,index) in itemTypes.blogs" :key="index" class="tableType">
          {{ item.articleTitle }}
        </span>
      </td>
      <td>
        <button type="button" class="reviseButton" @click="reviseType">修改</button>
        <button type="button" class="deleteButton" @click="deleteType">删除</button>
      </td>
    </tr>
    </tbody>
  </table>
</template>

<script>
import axios from "axios";

export default {
  name: "Types",
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
    }
  },

  created() {
    // 获取分类所有信息
    axios.get('/type/queryAll').then(res => {
      this.types = res.data;
    }).catch(function (error) {
      console.log(error);
    });
  },
  methods:{
    reviseType(){
      alert("修改分类")
    },
    deleteType(){
      alert("删除分类")
    }
  }
}
</script>

<style src="../../static/myTable.css"/>