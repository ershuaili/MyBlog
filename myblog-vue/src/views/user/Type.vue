<template>
  <!-- 标签页-头部 -->
  <div class="types">
    <div class="message">
      <div class="message_left">分类</div>
      <div class="message_right">
        一共<span class="right_number">1234</span>个
      </div>
    </div>
    <div class="labels">
      <a class="label" href="#">Java</a>
      <a class="label" href="#">css</a>
      <a class="label" href="#">Docker</a>
      <a class="label" href="#">其他</a>
      <a class="label" href="#">生活</a>
      <a class="label" href="#">学习</a>
      <a class="label" href="#">Java</a>
    </div>
  </div>
  <!-- 标签页-主体 -->
  <blog-list></blog-list>
</template>

<script>
import BlogList from "@/views/user/blog/BlogList";

export default {
  name: "Types",
  components: {BlogList}
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