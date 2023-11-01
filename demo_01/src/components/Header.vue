<template>
  <div>
    <span>郑嘉豪</span>
    <el-dropdown>
      <i class="el-icon-arrow-down"  style="margin-left: 1px"></i>
      <el-dropdown-menu slot="dropdown">
         <el-dropdown-item>个人中心</el-dropdown-item>
         <el-dropdown-item>退出登录</el-dropdown-item>
<!--         <el-dropdown-item>删除</el-dropdown-item>-->
      </el-dropdown-menu>
    </el-dropdown>
  </div>
</template>

<script>
export default {
  name: "Header"
}
</script>

<style scoped>

</style>
