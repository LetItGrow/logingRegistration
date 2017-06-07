<template>
  <el-row class="tac">
    <el-col :span="8">
      <h1>注册页面</h1>
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="账号" prop="name">
          <el-input type="text" v-model="ruleForm.name" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="pass">
          <el-input type="password" v-model="ruleForm.pass" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="确认密码" prop="repass">
          <el-input type="password" v-model="ruleForm.repass" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </el-col>
  </el-row>
</template>

<script>
  export default {
    data () {
      let validateAccount = (rule, value, callback) => {
        this.$ajax.post('/list/user/findByName.action', this.ruleForm)
          .then((response) => {
            // console.log(response.data.num)
            if (response.data.num === 1) {
              callback(new Error('用户名已存在'))
            } else if (response.data.num === 0) {
              callback(new Error('通过'))
            } else {
              callback(new Error('错误'))
            }
          })
      }
      let validatePass = (rule, value, callback) => {
        let regExp = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$/
        if (value === '') {
          callback(new Error('请输入密码'))
        } else if (regExp.test(value) === false) {
          callback(new Error('8-16字母和数字组成，不能是纯数字或纯英文'))
        } else {
          if (this.ruleForm.repass !== '') {
            this.$refs.ruleForm.validateField('repass')
          }
          callback()
        }
      }
      let validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'))
        } else if (value !== this.ruleForm.pass) {
          callback(new Error('两次输入密码不一致!'))
        } else {
          callback()
        }
      }
      return {
        url: '/user/insert.action',
        ruleForm: {
          name: '',
          pass: '',
          repass: ''
        },
        rules: {
          name: [
            { required: true, message: '请输入用户名称', trigger: 'blur' },
            { min: 3, max: 13, message: '长度在 3 到 13 个字符', trigger: 'blur' },
            { validator: validateAccount, trigger: 'blur' }
          ],
          pass: [
            { validator: validatePass, trigger: 'blur' }
          ],
          repass: [
            { validator: validatePass2, trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      //  提交按钮事件
      submitForm (formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            let _this = this
            this.$ajax.post(this.rootUrl + _this.url, _this.ruleForm)
              .then((response) => {
                this.$message.success('注册成功！')
                this.$refs[formName].resetFields()
                //  跳转到登录页
                this.$router.push({path: '/'})
              })
          } else {
            console.log('error submit!!')
            return false
          }
        })
      },
      // 重置按钮事件
      resetForm (formName) {
        this.$refs[formName].resetFields()
      }
    }
  }
</script>

<style>

</style>
