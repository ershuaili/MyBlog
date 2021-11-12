<template>
  <div class="index">
    <blog-list/>
  </div>
</template>

<script>
import BlogList from "@/views/user/blog/BlogList";

export default {
  name: "Index",
  components: {BlogList},
  data() {
    return {}
  },
  methods: {}
}
</script>

<style>
.index {
  padding-bottom: 30px;
}
</style>