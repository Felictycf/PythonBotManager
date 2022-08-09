<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="修改前a用户邮箱" prop="aBeforeUser">
        <el-input
          v-model="queryParams.aBeforeUser"
          placeholder="请输入修改前a用户邮箱"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="修改前a用户密码" prop="aBeforePassword">
        <el-input
          v-model="queryParams.aBeforePassword"
          placeholder="请输入修改前a用户密码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="修改前b用户邮箱" prop="bBeforeUser">
        <el-input
          v-model="queryParams.bBeforeUser"
          placeholder="请输入修改前b用户邮箱"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="修改前b用户密码" prop="bBeforePassword">
        <el-input
          v-model="queryParams.bBeforePassword"
          placeholder="请输入修改前b用户密码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="事件触发时间" prop="evenDate">
        <el-input
          v-model="queryParams.evenDate"
          placeholder="请输入事件触发时间"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="修改后a用户邮箱" prop="aAfterUser">
        <el-input
          v-model="queryParams.aAfterUser"
          placeholder="请输入修改后a用户邮箱"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="修改后a用户密码" prop="aAfterPassword">
        <el-input
          v-model="queryParams.aAfterPassword"
          placeholder="请输入修改后a用户密码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="修改后b用户邮箱" prop="bAfterUser">
        <el-input
          v-model="queryParams.bAfterUser"
          placeholder="请输入修改后b用户邮箱"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="修改后b用户密码" prop="bAfterPassword">
        <el-input
          v-model="queryParams.bAfterPassword"
          placeholder="请输入修改后b用户密码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="事件状态" prop="status">
        <el-input
          v-model="queryParams.status"
          placeholder="请输入事件状态"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:even:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:even:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:even:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:even:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="evenList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="修改事件编号" align="center" prop="id" />
      <el-table-column label="修改前a用户邮箱" align="center" prop="aBeforeUser" />
      <el-table-column label="修改前a用户密码" align="center" prop="aBeforePassword" />
      <el-table-column label="修改前b用户邮箱" align="center" prop="bBeforeUser" />
      <el-table-column label="修改前b用户密码" align="center" prop="bBeforePassword" />
      <el-table-column label="事件触发时间" align="center" prop="evenDate" />
      <el-table-column label="修改后a用户邮箱" align="center" prop="aAfterUser" />
      <el-table-column label="修改后a用户密码" align="center" prop="aAfterPassword" />
      <el-table-column label="修改后b用户邮箱" align="center" prop="bAfterUser" />
      <el-table-column label="修改后b用户密码" align="center" prop="bAfterPassword" />
      <el-table-column label="事件状态" align="center" prop="status" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:even:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:even:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改自动化记录对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="修改前a用户邮箱" prop="aBeforeUser">
          <el-input v-model="form.aBeforeUser" placeholder="请输入修改前a用户邮箱" />
        </el-form-item>
        <el-form-item label="修改前a用户密码" prop="aBeforePassword">
          <el-input v-model="form.aBeforePassword" placeholder="请输入修改前a用户密码" />
        </el-form-item>
        <el-form-item label="修改前b用户邮箱" prop="bBeforeUser">
          <el-input v-model="form.bBeforeUser" placeholder="请输入修改前b用户邮箱" />
        </el-form-item>
        <el-form-item label="修改前b用户密码" prop="bBeforePassword">
          <el-input v-model="form.bBeforePassword" placeholder="请输入修改前b用户密码" />
        </el-form-item>
        <el-form-item label="事件触发时间" prop="evenDate">
          <el-input v-model="form.evenDate" placeholder="请输入事件触发时间" />
        </el-form-item>
        <el-form-item label="修改后a用户邮箱" prop="aAfterUser">
          <el-input v-model="form.aAfterUser" placeholder="请输入修改后a用户邮箱" />
        </el-form-item>
        <el-form-item label="修改后a用户密码" prop="aAfterPassword">
          <el-input v-model="form.aAfterPassword" placeholder="请输入修改后a用户密码" />
        </el-form-item>
        <el-form-item label="修改后b用户邮箱" prop="bAfterUser">
          <el-input v-model="form.bAfterUser" placeholder="请输入修改后b用户邮箱" />
        </el-form-item>
        <el-form-item label="修改后b用户密码" prop="bAfterPassword">
          <el-input v-model="form.bAfterPassword" placeholder="请输入修改后b用户密码" />
        </el-form-item>
        <el-form-item label="事件状态" prop="status">
          <el-input v-model="form.status" placeholder="请输入事件状态" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listEven, getEven, delEven, addEven, updateEven } from "@/api/system/even";

export default {
  name: "Even",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 自动化记录表格数据
      evenList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        aBeforeUser: null,
        aBeforePassword: null,
        bBeforeUser: null,
        bBeforePassword: null,
        evenDate: null,
        aAfterUser: null,
        aAfterPassword: null,
        bAfterUser: null,
        bAfterPassword: null,
        status: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询自动化记录列表 */
    getList() {
      this.loading = true;
      listEven(this.queryParams).then(response => {
        this.evenList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        aBeforeUser: null,
        aBeforePassword: null,
        bBeforeUser: null,
        bBeforePassword: null,
        evenDate: null,
        aAfterUser: null,
        aAfterPassword: null,
        bAfterUser: null,
        bAfterPassword: null,
        status: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加自动化记录";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getEven(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改自动化记录";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateEven(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addEven(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除自动化记录编号为"' + ids + '"的数据项？').then(function() {
        return delEven(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/even/export', {
        ...this.queryParams
      }, `even_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
