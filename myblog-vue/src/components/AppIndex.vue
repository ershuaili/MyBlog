<template>
  <div class="index">
    <blog-list/>
  </div>
</template>

<script>
import BlogList from "@/components/common/BlogList";

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
  padding-top: 1px;
  padding-bottom: 30px;
}
</style>