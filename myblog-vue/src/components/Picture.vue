<template>
  <div class="box">
    <div v-for="(item,index) in picture" :key="index" class="picture">
      <img alt="" height="200" v-bind:src="item.pictureAddress" width="300">
      <div class="mask">{{ item.pictureDescription }}</div>
    </div>
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

div.img img {
  width: 100%;
  height: auto;
}

* {
  box-sizing: border-box;
}

.picture {
  padding: 0 6px;
  float: left;
  width: 19.99999%;
  position: relative;
}

.mask {
  position: absolute;
  text-align: center;
  width: 300px;
  height: 100%;
  bottom: 0;
  background: rgba(101, 101, 101, 0.6);
  color: #ffffff;
  opacity: 0;
  line-height: 300px;
}

.picture:hover .mask {
  opacity: 1;
  cursor: default;
}

@media only screen and (max-width: 700px) {
  .picture {
    width: 49.99999%;
    margin: 6px 0;
  }
}

@media only screen and (max-width: 500px) {
  .picture {
    width: 100%;
  }

  .mask {
    position: absolute;
    left: 0;
    right: 0;
    width: 300px;
    margin-left: auto;
    margin-right: auto
  }
}
</style>