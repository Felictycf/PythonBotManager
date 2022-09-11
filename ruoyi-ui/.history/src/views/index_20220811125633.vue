<template>
  <div>
    <el-form :model="indexForm" :rules="indexRules" >
      <h3>输入a账号和a密码</h3>

      <el-form-item prop="username">
        <el-input
          v-model="indexForm.username"
          type="text"
          auto-complete="off"
          placeholder="账号"
        >
          <svg-icon slot="prefix" icon-class="user" class="el-input__icon input-icon" />
        </el-input>
      </el-form-item>


      <el-form-item prop="password">
        <el-input
          v-model="indexForm.password"
          type="password"
          auto-complete="off"
          placeholder="密码"

          >
        </el-input>
      </el-form-item>

      <h3>输入b账号和b密码</h3>
      <el-form-item prop="username">
        <el-input
          v-model="indexForm.username"
          type="text"
          auto-complete="off"
          placeholder="账号"
        >
          <svg-icon slot="prefix" icon-class="user" class="el-input__icon input-icon" />
        </el-input>
      </el-form-item>


      <el-form-item prop="password">
        <el-input
          v-model="indexForm.password"
          type="password"
          auto-complete="off"
          placeholder="密码"
        >
        </el-input>
      </el-form-item>

      <el-form-item style="width:100%;">
        <el-button
          :loading = "loading"
          size="medium"
          type="primary"
          style="width:100%;"
          @click.native.prevent="handleLogin"
        >
          <span v-if="!loading">加载</span>
          <span v-else>加载中...</span>
        </el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import axios from "axios";
import log from "@/views/monitor/job/log";

export default {
  name :"index",
  data(){
    return{
      codeUrl : "",
      indexForm:{
        username : "",
        password:""
      },
      indexRules:{
        username: [
          {require:true,trigger : "blur"  ,message:"请输账入号"}
        ],
        password: [
          {require:true,trigger : "blur"  ,message:"请输入密码"}
        ],
      },
      loading: false,
      handleLogin(){
        console.log("ook")
        console.log(this.indexForm.username)
        console.log(this.indexForm.password)
        axios.post("http://localhost:8000/data",this.indexForm).then(
          function (res){
            alert(res.data)
          }
        )
      }
    }
  }
}
</script>
