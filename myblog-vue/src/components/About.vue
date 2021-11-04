<template>
  <div class="main">
    <!--左侧图片-->
    <div class="picture">
      <div class="img">
        <img alt="" src="../assets/background.jpg">
      </div>
    </div>
    <!--右侧简介-->
    <div class="comment">
      <div class="details">
        <!--头部标签-->
        <div class="head" style="text-align: center;">
          <h1>关于我</h1>
        </div>
        <hr/>
        <!--文字描述-->
        <div class="introduce">
          <p>一些测试文字发放大 发仨发发呆sa法法师防守打法发发发电房a</p>
          <br/>
          <p>一些测试文字发放大 发仨发发呆sa法法师防守打法发发发电房a</p>
        </div>
        <hr/>
        <!--个人标签-->
        <div class="label_personal">
          <div class="tag">标签1</div>
          <div class="tag">标签2</div>
          <div class="tag">标签3</div>
        </div>
        <hr/>
        <!--技术标签-->
        <div class="label_technology">
          <div class="tag tag_right">标签1</div>
        </div>
        <hr/>
        <!--链接-->
        <div class="link"></div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'About',
  components: {},
  methods: {
    toIndex() {
      this.$router.push({
        name: 'AppIndex',
      })
    },
  }
}
</script>

<style>
.picture {
  width: 70%;
  height: 100%;
  display: inline-block;
  float: left;
}

.img {
  background-color: #FFFFFF;
  width: 960px;
  height: 550px;
  padding: 20px;
  margin: 10px 30px 30px;
  border-radius: 15px;
}

.img > img {
  height: 100%;
  width: 100%;
  background-size: 100%;
  background-position: top left;
  border-radius: 10px;
}

.comment {
  width: 30%;
  float: left;
  display: inline-block;
}

.details {
  background-color: #FFFFFF;
  margin: 10PX;
  padding: 10px;
  height: 630px;
  width: auto;
  border-radius: 15px;
}

/* 空心气泡标签 */
.tag {
  width: auto;
  height: 25px;
  line-height: 25px;
  text-align: center;
  position: relative;
  border-radius: 5px;
  border: 2px solid teal;
  display: inline-block;
  margin: 20px auto 20px 10px;
  padding: 5px;
}

.tag::before {
  content: '';
  position: absolute;
  width: 0;
  height: 0;
  top: 7px;
  left: -15px;
  border-top: 5px solid transparent;
  border-bottom: 5px solid transparent;
  border-right: 15px solid teal;
}

.tag::after {
  content: '';
  position: absolute;
  width: 0;
  height: 0;
  top: 7px;
  left: -13px;
  border-top: 5px solid transparent;
  border-bottom: 5px solid transparent;
  border-right: 15px solid #fff;
}

/***** 移动端配适 *****/
@media screen and (max-width: 768px) {
  .picture {
    width: 100%;
    height: 100vh;
    background-color: #FFE4C4;
    display: inline-block;
    float: left;
  }

  .comment {
    width: 100%;
    height: 100vh;
    background-color: #ffaaff;
    display: inline-block;
    float: left;
  }
}
</style>