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
        <button type="button" class="reviseButton">修改</button>
        <button type="button" class="deleteButton">删除</button>
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
      console.log(res.data)
      this.types = res.data;
    }).catch(function (error) {
      console.log(error);
    });
  }
}
</script>

<style scoped>
table {
  width: 100%;
  height: 100%;
  border-collapse: collapse;
}

table, tr, td {
  padding-left: 10px;
  border: 1px solid #E3E3E3FF;
}

thead {
  background-color: rgb(223, 240, 216);
  font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-weight: bold;
  font-size: 18px;
  height: 40px;
}

tbody {
  font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-weight: bold;
  font-size: 15px;
  height: 100px;
}

tbody tr {
  height: 50px;
}

.tableType {
  margin: 5px;
  padding: 5px;
  border-radius: 30px;
  background-color: #69b469;
}

.reviseButton {
  background-color: rgb(133, 206, 97);
}

.deleteButton {
  background-color: rgb(247, 137, 137);
}

.reviseButton, .deleteButton { /* 按钮美化 */
  margin-left: 10px;
  width: 70px; /* 宽度 */
  height: 30px; /* 高度 */
  border-width: 0; /* 边框宽度 */
  border-radius: 5px; /* 边框半径 */
  cursor: pointer; /* 鼠标移入按钮范围时出现手势 */
  outline: none; /* 不显示轮廓线 */
  color: white; /* 字体颜色 */
  font-size: 17px; /* 字体大小 */
}
</style>