<template>
    <div class="content">
      <div class="form">
        <el-form ref="form" :model="Form" label-width="80px">
           <el-form-item label="商品名称">
            <el-input v-model="Form.name"></el-input>
          </el-form-item>
          <el-form-item label="商品价格">
            <el-input v-model="Form.price"></el-input>
          </el-form-item>
          <el-form-item label="商品描述">
            <el-input v-model="Form.description"></el-input>
          </el-form-item>
          <el-form-item>
           <el-upload action="/api/users/addProduct"
            list-type="picture-card"
            :on-preview="handlePictureCardPreview"
            :on-remove="handleRemove"
            :before-upload="beforeProductUpload">
            <i class="el-icon-plus"></i>
          </el-upload>
        <el-dialog :visible.sync="dialogVisible">
          <img width="100%" :src="dialogImageUrl" alt="">
        </el-dialog>
         </el-form-item>
         <el-form-item>
            <el-button type="primary" @click="submit">立即创建</el-button>
            <el-button>取消</el-button>
          </el-form-item>
        </el-form>
      </div>
       
    </div>
</template>