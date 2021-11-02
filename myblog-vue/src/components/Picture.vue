<template>
  <div id="box" class="box">
    <img v-for="(item,index) in picture" :key="index" alt="" class="pic" v-bind:src="item.pictureAddress">
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Picture",
  data() {
    return {
      picture: [
        {
          pictureId: '',
          pictureAddress: '',
          pictureDescription: '',
        }
      ]
    }
  },

  created() {
    axios.get('/picture/selectAll').then(successResponse => {
      this.picture = successResponse.data;
    }).catch(function (error) {
      console.log(error);
    });
  },
  methods: {},
}
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
}

.box {
  width: 90%;
  height: 100%;
  margin: 60px auto;
  position: relative;
}

.box img {
  padding: 10px 10px 15px;
  background: white;
  border: 1px solid #ddd;
  box-shadow: 1px 1px 2px rgba(50, 50, 50, 0.4);
}

.pic {
  width: 230px;
  margin-right: 1%;
}

.box > img:hover {
  opacity: 0.6;
}
</style>