<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="用户名" prop="username">
        <el-input
          v-model="queryParams.username"
          placeholder="请输入用户名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户密码" prop="password">
        <el-input
          v-model="queryParams.password"
          placeholder="请输入用户密码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="昵称" prop="nickname">
        <el-input
          v-model="queryParams.nickname"
          placeholder="请输入昵称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="真实姓名" prop="relename">
        <el-input
          v-model="queryParams.relename"
          placeholder="请输入真实姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="身份证" prop="cardid">
        <el-input
          v-model="queryParams.cardid"
          placeholder="请输入身份证"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="性别" prop="gender">
        <el-input
          v-model="queryParams.gender"
          placeholder="请输入性别"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="生日" prop="birthday">
        <el-date-picker clearable
                        v-model="queryParams.birthday"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="请选择生日"
        >
        </el-date-picker>
      </el-form-item>
      <el-form-item label="手机号码" prop="mobile">
        <el-input
          v-model="queryParams.mobile"
          placeholder="请输入手机号码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="邮箱地址" prop="email">
        <el-input
          v-model="queryParams.email"
          placeholder="请输入邮箱地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="更改中的邮箱" prop="modifiedEmail">
        <el-input
          v-model="queryParams.modifiedEmail"
          placeholder="请输入更改中的邮箱"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="校验码" prop="checkCode">
        <el-input
          v-model="queryParams.checkCode"
          placeholder="请输入校验码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="省" prop="province">
        <el-input
          v-model="queryParams.province"
          placeholder="请输入省"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="市" prop="city">
        <el-input
          v-model="queryParams.city"
          placeholder="请输入市"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="区" prop="county">
        <el-input
          v-model="queryParams.county"
          placeholder="请输入区"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="最近登陆时间" prop="lastLoginTime">
        <el-date-picker clearable
                        v-model="queryParams.lastLoginTime"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="请选择最近登陆时间"
        >
        </el-date-picker>
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
          v-hasPermi="['system:member:add']"
        >新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:member:edit']"
        >修改
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:member:remove']"
        >删除
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:member:export']"
        >导出
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="info"
          plain
          icon="el-icon-upload2"
          size="mini"
          @click="handleImport"
          v-hasPermi="['system:member:import']"
        >导入
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="memberList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="主键id" align="center" prop="id"/>
      <el-table-column label="用户名" align="center" prop="username"/>
      <el-table-column label="用户密码" align="center" prop="password"/>
      <el-table-column label="昵称" align="center" prop="nickname"/>
      <el-table-column label="头像地址" align="center" prop="image" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.image" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="真实姓名" align="center" prop="relename"/>
      <el-table-column label="身份证" align="center" prop="cardid"/>
      <el-table-column label="性别  0 保密 1男 2女 默认0" align="center" prop="gender"/>
      <el-table-column label="生日" align="center" prop="birthday" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.birthday, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="月收入  0 无收入 1 2000以下 2 2000-3999 3 4000-5999 4 6000－7999  5 8000以上" align="center" prop="monthlyIncome"
      />
      <el-table-column label="婚姻状况  0 保密 1未婚 2 已婚 默认0 保姆" align="center" prop="marriageStatus"/>
      <el-table-column label="手机号码" align="center" prop="mobile"/>
      <el-table-column label="邮箱地址" align="center" prop="email"/>
      <el-table-column label="更改中的邮箱" align="center" prop="modifiedEmail"/>
      <el-table-column label="校验码" align="center" prop="checkCode"/>
      <el-table-column label="省" align="center" prop="province"/>
      <el-table-column label="市" align="center" prop="city"/>
      <el-table-column label="区" align="center" prop="county"/>
      <el-table-column label="详细地址" align="center" prop="detailaddress"/>
      <el-table-column label="兴趣爱好" align="center" prop="interest"/>
      <el-table-column label="用户注册来源 1 pc  2app  3 手机h5 4 管理员后台新增" align="center" prop="source"
      />
      <el-table-column label="用户状态 1 正常 2 冻结  3 未启用 默认1 " align="center" prop="status"/>
      <el-table-column label="会员签到次数" align="center" prop="signNum"/>
      <el-table-column label="手机是否验证  0 否 1 验证 默认0 " align="center" prop="isMobileVerification"/>
      <el-table-column label="邮箱是否验证   0 否 1 验证  默认0  " align="center" prop="isEmailVerification"/>
      <el-table-column label="错误登录的次数" align="center" prop="loginErrorCount"/>
      <el-table-column label="修改时间" align="center" prop="modifyTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.modifyTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="删除时间" align="center" prop="delTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.delTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="锁定时间" align="center" prop="lockTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.lockTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="最近登陆时间" align="center" prop="lastLoginTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.lastLoginTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="会员自己的推荐码" align="center" prop="selfRecommendCode"/>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            type="text"
            size="small"
            icon="el-icon-view"
            @click="handleView(scope.row)"
            v-hasPermi="['system:member:list']"
          >查看
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:member:edit']"
          >修改
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:member:remove']"
          >删除
          </el-button>
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

    <!-- 添加或修改会员对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px" :disabled="openView">
        <el-form-item label="用户名" prop="username">
          <el-input v-model="form.username" placeholder="请输入用户名"/>
        </el-form-item>
        <el-form-item label="用户密码" prop="password">
          <el-input v-model="form.password" placeholder="请输入用户密码"/>
        </el-form-item>
        <el-form-item label="昵称" prop="nickname">
          <el-input v-model="form.nickname" placeholder="请输入昵称"/>
        </el-form-item>
        <el-form-item label="头像地址">
          <image-upload v-model="form.image" :disabled="openView"/>
        </el-form-item>
        <el-form-item label="真实姓名" prop="relename">
          <el-input v-model="form.relename" placeholder="请输入真实姓名"/>
        </el-form-item>
        <el-form-item label="身份证" prop="cardid">
          <el-input v-model="form.cardid" placeholder="请输入身份证"/>
        </el-form-item>
        <el-form-item label="性别  0 保密 1男 2女 默认0" prop="gender">
          <el-input v-model="form.gender" placeholder="请输入性别  0 保密 1男 2女 默认0"/>
        </el-form-item>
        <el-form-item label="生日" prop="birthday">
          <el-date-picker clearable
                          v-model="form.birthday"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="请选择生日"
          >
          </el-date-picker>
        </el-form-item>
        <el-form-item label="月收入  0 无收入 1 2000以下 2 2000-3999 3 4000-5999 4 6000－7999  5 8000以上" prop="monthlyIncome"
        >
          <el-input v-model="form.monthlyIncome" placeholder="请输入月收入  0 无收入 1 2000以下 2 2000-3999 3 4000-5999 4 6000－7999  5 8000以上"
          />
        </el-form-item>
        <el-form-item label="手机号码" prop="mobile">
          <el-input v-model="form.mobile" placeholder="请输入手机号码"/>
        </el-form-item>
        <el-form-item label="邮箱地址" prop="email">
          <el-input v-model="form.email" placeholder="请输入邮箱地址"/>
        </el-form-item>
        <el-form-item label="更改中的邮箱" prop="modifiedEmail">
          <el-input v-model="form.modifiedEmail" placeholder="请输入更改中的邮箱"/>
        </el-form-item>
        <el-form-item label="校验码" prop="checkCode">
          <el-input v-model="form.checkCode" placeholder="请输入校验码"/>
        </el-form-item>
        <el-form-item label="省" prop="province">
          <el-input v-model="form.province" placeholder="请输入省"/>
        </el-form-item>
        <el-form-item label="市" prop="city">
          <el-input v-model="form.city" placeholder="请输入市"/>
        </el-form-item>
        <el-form-item label="区" prop="county">
          <el-input v-model="form.county" placeholder="请输入区"/>
        </el-form-item>
        <el-form-item label="详细地址" prop="detailaddress">
          <el-input v-model="form.detailaddress" placeholder="请输入详细地址"/>
        </el-form-item>
        <el-form-item label="兴趣爱好" prop="interest">
          <el-input v-model="form.interest" type="textarea" placeholder="请输入内容"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm" v-if="!openView">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
    <!-- 导入对话框 -->
    <el-dialog :title="upload.title" :visible.sync="upload.open" width="400px" append-to-body>
      <el-upload
        ref="upload"
        :limit="1"
        accept=".xlsx, .xls"
        :headers="upload.headers"
        :action="upload.url"
        :disabled="upload.isUploading"
        :on-progress="handleFileUploadProgress"
        :on-success="handleFileSuccess"
        :auto-upload="false"
        drag
      >
        <i class="el-icon-upload" />
        <div class="el-upload__text">
          将文件拖到此处，或
          <em>点击上传</em>
        </div>
        <div slot="tip" class="el-upload__tip">
          <el-link type="info" style="font-size:14px;color:green" @click="importTemplate">点击下载模板</el-link>
        </div>
        <div slot="tip" class="el-upload__tip" style="color:red">提示：仅允许导入“xls”或“xlsx”格式文件！</div>
      </el-upload>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitFileForm">确 定</el-button>
        <el-button @click="upload.open = false">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listMember, getMember, delMember, addMember, updateMember, exportMember } from '@/api/member'
import { getToken } from '@/utils/auth';
export default {
  name: 'Member',
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
      // 会员表格数据
      memberList: [],
      // 弹出层标题
      title: '',
      // 是否显示弹出层
      open: false,
      // 弹出层是否只读
      openView: false,
      // 导入参数
      upload: {
        // 是否显示弹出层
        open: false,
        // 弹出层标题
        title: '',
        // 是否禁用上传
        isUploading: false,
        // 设置上传的请求头部
        headers: { Authorization: 'Bearer ' + getToken() },
        // 上传的地址
        url: process.env.VUE_APP_BASE_API + '/system/member/import'
      },
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        username: null,
        password: null,
        nickname: null,
        image: null,
        relename: null,
        cardid: null,
        gender: null,
        birthday: null,
        monthlyIncome: null,
        marriageStatus: null,
        mobile: null,
        email: null,
        modifiedEmail: null,
        checkCode: null,
        province: null,
        city: null,
        county: null,
        detailaddress: null,
        interest: null,
        source: null,
        status: null,
        signNum: null,
        isMobileVerification: null,
        isEmailVerification: null,
        loginErrorCount: null,
        modifyTime: null,
        delTime: null,
        lockTime: null,
        lastLoginTime: null,
        selfRecommendCode: null,
        appletOpenId: null,
        appOpenId: null,
        h5OpenId: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        password: [
          { required: true, message: '用户密码不能为空', trigger: 'blur' }
        ],
        gender: [
          { required: true, message: '性别  0 保密 1男 2女 默认0不能为空', trigger: 'blur' }
        ],
        marriageStatus: [
          { required: true, message: '婚姻状况  0 保密 1未婚 2 已婚 默认0 保姆不能为空', trigger: 'blur' }
        ]
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    /** 查询会员列表 */
    getList() {
      this.loading = true
      listMember(this.queryParams).then(response => {
        this.memberList = response.rows
        this.total = response.total
        this.loading = false
      })
    },
    // 取消按钮
    cancel() {
      this.open = false
      this.openView = false
      this.reset()
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        username: null,
        password: null,
        nickname: null,
        image: null,
        relename: null,
        cardid: null,
        gender: null,
        birthday: null,
        monthlyIncome: null,
        marriageStatus: '0',
        mobile: null,
        email: null,
        modifiedEmail: null,
        checkCode: null,
        province: null,
        city: null,
        county: null,
        detailaddress: null,
        interest: null,
        source: null,
        status: '0',
        signNum: null,
        isMobileVerification: null,
        isEmailVerification: null,
        loginErrorCount: null,
        delFlag: null,
        createTime: null,
        modifyTime: null,
        delTime: null,
        lockTime: null,
        lastLoginTime: null,
        selfRecommendCode: null,
        appletOpenId: null,
        appOpenId: null,
        h5OpenId: null
      }
      this.resetForm('form')
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1
      this.getList()
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm('queryForm')
      this.handleQuery()
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.openView = false
      this.open = true
      this.title = '添加会员'
    },
    /** 查看按钮操作 */
    handleView(row) {
      this.loading = true
      this.reset()
      this.openView = true
      const id = row.id
      getMember(id).then(response => {
        this.loading = false
        this.form = response.data
        this.open = true
        this.title = '查看会员'
      })
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      this.openView = false
      const id = row.id || this.ids
      getMember(id).then(response => {
        this.form = response.data
        this.open = true
        this.title = '修改会员'
      })
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs['form'].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateMember(this.form).then(response => {
              this.$modal.msgSuccess('修改成功')
              this.open = false
              this.openView = false
              this.getList()
            })
          } else {
            addMember(this.form).then(response => {
              this.$modal.msgSuccess('新增成功')
              this.open = false
              this.openView = false
              this.getList()
            })
          }
        }
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids
      this.$modal.confirm('是否确认删除会员编号为"' + ids + '"的数据项？').then(function() {
        return delMember(ids)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess('删除成功')
      }).catch(() => {
      })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams
      this.$confirm('是否确认导出所有会员数据项?', '警告', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.exportLoading = true
        return exportMember(queryParams)
      }).then(response => {
        this.download(response.msg)
        this.exportLoading = false
      }).catch(() => {
      })
    },
    /** 导入按钮操作 */
    handleImport() {
      this.upload.title = '会员导入'
      this.upload.open = true
    },
    /** 下载模板操作 */
    importTemplate() {
      importTemplate().then(response => {
        this.download(response.msg)
      })
    },
    /** 文件上传中处理*/
    handleFileUploadProgress(event, file, fileList) {
      this.upload.isUploading = true
    },
    /** 文件上传成功处理*/
    handleFileSuccess(response, file, fileList) {
      this.upload.open = false
      this.upload.isUploading = false
      this.$refs.upload.clearFiles()
      this.$alert(response.msg, '导入结果', { dangerouslyUseHTMLString: true })
      this.getList()
    },
    /** 提交上传文件*/
    submitFileForm() {
      this.$refs.upload.submit()
    }

  }
}
</script>
