<template>
  <div>
    <el-form :model="indexForm" :rules="indexRules" >
      <h3>输入a账号和a密码</h3>

      <el-form-item prop="aUsername">
        <el-input
          v-model="indexForm.aUsername"
          type="text"
          auto-complete="off"
          placeholder="账号"
        >
          <svg-icon slot="prefix" icon-class="user" class="el-input__icon input-icon" />
        </el-input>
      </el-form-item>



      <el-form-item prop="aPassword">
        <el-input
          v-model="indexForm.aPassword"
          type="password"
          auto-complete="off"
          placeholder="密码"

          >
        </el-input>
      </el-form-item>

      <h3>输入b账号和b密码</h3>
      <el-form-item prop="bUsername">
        <el-input
          v-model="indexForm.bUsername"
          type="text"
          auto-complete="off"
          placeholder="账号"
        >
          <svg-icon slot="prefix" icon-class="user" class="el-input__icon input-icon" />
        </el-input>
      </el-form-item>


      <el-form-item prop="bPassword">
        <el-input
          v-model="indexForm.bPassword"
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
        aUsername : "",
        aPassword : "",
        bUsername : "",
        bPassword:"",
      },
      indexRules:{
        aUsername: [
          {require:true,trigger : "blur"  ,message:"请输账入号"}
        ],
        aPassword: [
          {require:true,trigger : "blur"  ,message:"请输入密码"}
        ],
      },
      loading: false,
      handleLogin(){
        console.log("ook")
        console.log("a =>>>>>>"+this.indexForm.aUsername)
        console.log("a =>>>>>>"+this.indexForm.aPassword)
        console.log("b =>>>>>>"+this.indexForm.bUsername)
        console.log("b =>>>>>>"+this.indexForm.bPassword)
        axios.post("http://129.226.28.6:8881/data",this.indexForm).then(
          function (res){
            alert(res.data)
          }
        )
      }
    }
  }
}
</script>
