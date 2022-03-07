<template>
    <div class="login">
        <el-form
            :model="loginForm"
            :rules="rules"
            class="login-form"
            ref="loginForm"
            v-show="isLoginForm"
        >
            <h3 class="title">
               Mall
            </h3>
            <el-form-item prop="username">
                <el-input
                    v-model="loginForm.username"
                    type="text"
                    auto-complete="off"
                    placeholder="请输入您的用户名"
                >
                    <svg-icon
                        slot="prefix"
                        icon-class="user"
                        class="iconfont icon-user-solid el-input__icon input-icon"
                    />
                </el-input>
            </el-form-item>
            <el-form-item prop="password">
                <el-input
                    v-model="loginForm.password"
                    type="password"
                    auto-complete="off"
                    placeholder="请输入您的密码"
                    @keyup.enter.native="handleLogin"
                >
                    <svg-icon
                        slot="prefix"
                        icon-class="password"
                        class="iconfont icon-lock el-input__icon input-icon"
                    />
                </el-input>
            </el-form-item>
            <el-checkbox v-model="rememberMe" style="margin:0px 0px 25px 0px;">记住密码</el-checkbox>
            <el-form-item style="width:100%;" class="lands">
                <!-- :loading="loading" -->
                <el-button
                    size="medium"
                    type="primary"
                    style="width:40%;"
                    @click.native.prevent="handleLogin"
                >
                    <span v-if="!loading">登 录</span>
                    <span v-else>登 录 中...</span>
                </el-button>
                <el-button
                    size="medium"
                    type="primary"
                    style="width:40%;"
                    @click.native.prevent="toSign"
                >
                    <span>注 册</span>
                </el-button>
            </el-form-item>
        </el-form>

        <el-form
            :model="signForm"
            :rules="rules"
            class="login-form"
            v-show="isSignForm"
            ref="signForm"
        >
            <h3 class="title">
                用户注册
            </h3>
            <el-form-item prop="username">
                <el-input v-model="signForm.username" type="text" placeholder="请输入您的用户名">
                    <svg-icon
                        slot="prefix"
                        icon-class="user"
                        class="iconfont icon-user-solid el-input__icon input-icon"
                    />
                </el-input>
            </el-form-item>
            <el-form-item prop="password">
                <el-input v-model="signForm.password" type="password" placeholder="请输入您的密码">
                    <svg-icon
                        slot="prefix"
                        icon-class="password"
                        class="iconfont icon-lock el-input__icon input-icon"
                    />
                </el-input>
            </el-form-item>
            <el-form-item prop="surePassword">
                <el-input v-model="signForm.surePassword" type="password" placeholder="请确认您的密码">
                    <svg-icon
                        slot="prefix"
                        icon-class="password"
                        class="iconfont icon-lock el-input__icon input-icon"
                    />
                </el-input>
            </el-form-item>
            <el-form-item prop="regMail">
                <el-input v-model="signForm.regMail" type="text" placeholder="请输入您的邮箱">
                    <svg-icon
                        slot="prefix"
                        icon-class="user"
                        class="iconfont icon-message el-input__icon input-icon"
                    />
                </el-input>
            </el-form-item>
            <el-form-item style="width:100%;" class="lands">
                <!-- :loading="loading" -->
                <el-button
                    size="medium"
                    type="primary"
                    style="width:40%;"
                    @click="handleRegister"
                >
                    <span v-if="!loading">注 册</span>
                    <span v-else>注 册 中...</span>
                </el-button>
                <el-button
                    size="medium"
                    type="primary"
                    style="width:40%;"
                    @click="toLogin()"
                >
                    <span>返回</span>
                </el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
export default {
    name: "Login",
    data() {
        return {
            isSignForm: false,
            loading: false,
            isLoginForm: true,
            cookiePassword: "",
            loginForm: {
                username: "",
                password: "",
            },
            rememberMe: false,
            signForm: {
                username: "",
                password: "",
                surePassword: "",
                regMail: "",
            },
            rules: {
                username: [
                    {
                        required: true,
                        trigger: "blur",
                        message: "用户名不能为空",
                    },
                ],
                password: [
                    {
                        required: true,
                        trigger: "blur",
                        message: "密码不能为空",
                    },
                ],
                surePassword: [
                    {
                        validator: (rule, value, callback) => {
                            if (value != this.signForm.password) {
                                callback(new Error("两次输入的密码不一致"));
                            } else {
                                callback(); //必须要有回调，要不然表单无法提交
                            }
                        },
                        trigger: "blur",
                    },
                ],
                regMail: [
                    {
                        required: true,
                        message: "邮箱不能为空",
                        trigger: "blur",
                    },
                    {
                        type: "email",
                        message: "请输入正确的邮箱格式",
                        trigger: "blur",
                    },
                ],
            },
        };
    },
    watch: {
        rememberMe(newVal) {
            console.log(newVal);
            if (newVal == true) {
                localStorage.setItem("username", this.loginForm.username);
                localStorage.setItem("password", this.loginForm.password);
            } else {
                localStorage.clear();
            }
        },
        immediate: true,
    },
    methods: {
        handleLogin(){
            this.$axios.get("login?username="+this.loginForm.username+"&password="+this.loginForm.password)
            .then(res => {
                this.$axios.get("jump?username="+this.loginForm.username)
                .then(res => {
                    if(res.data.message==="admin"){
                        sessionStorage.setItem("userId", res.data.data.id);
                        sessionStorage.setItem("username", res.data.data.username);
                        this.toLogin2()
                    }
                    else if(res.data.message==="customer"){
                        sessionStorage.setItem("userId", res.data.data.id);
                        sessionStorage.setItem("username", res.data.data.username);
                        this.toLogin1()
                    }
                    else{
                    this.$message({
                    message: "账号密码不匹配",
                    type: "warning",
                    duration: 1000,
                    });
                }
                })
            })
            .catch(err => {
            
            })
        },
        handleRegister(){
            if(this.signForm.password === "" || this.signForm.username === "" || this.signForm.regMail === ""){
                this.$message({
                    message: "请填写完整表单",
                    type: "warning",
                    duration: 1000,
                    });
                    return;
            }
            if(this.signForm.password === this.signForm.surePassword){
                this.$axios.get("login?username=haruna&password=password")
                .then(res => {
                this.$axios.get("register?username="+this.signForm.username+"&password="+this.signForm.password+"&email="+this.signForm.regMail)
                .then(res => {
                    if(res.data.count==1){
                        this.$message({
                        message: "用户名已存在",
                        type: "warning",
                        duration: 1000,
                        });
                    }
                    else {
                        this.$message({
                        message: "注册成功",
                        type: "success",
                        duration: 1000,
                        });
                    }
                    this.signForm={};
                    this.$axios.get("logout");
                    this.toLogin();
                })
                })
            }
            else{
                this.$message({
                    message: "密码输入不一致",
                    type: "warning",
                    duration: 1000,
                });
            }
        },
        toSign() {
            this.isLoginForm = false;
            this.isSignForm = true;
            this.$refs.loginForm.resetFields();
        },
        toLogin() {
            this.isSignForm = false;
            this.isLoginForm = true;
        },
      toLogin1() {
        this.$router.push("/displayGoods")
      },
      toLogin2() {
        this.$router.push("/home")
      },
    },
};
</script>

<style rel="stylesheet/css">
.login {
    position: absolute;
    width: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100%;
    background-image: url("../../static/image/login-background.jpg");
    background-size: cover;
}
.title {
    margin: 0px auto 30px auto;
    text-align: center;
    color: #707070;
}
.facelogin-form {
    border-radius: 6px;
    background: #ffffff;
    width: 400px;
    padding: 25px 25px 25px 25px;
}
.login-form {
    border-radius: 6px;
    background: #ffffff;
    width: 400px;
    padding: 25px 25px 25px 25px;
}
.login-form .el-input {
    height: 38px;
}
.login-form .el-input input {
    height: 38px;
}
.login-form .input-icon {
    height: 39px;
    width: 14px;
    margin-left: 2px;
}
.el-select .el-input--suffix .el-input__inner {
    padding-left: 30px;
    width: 100%;
}
.el-select {
    width: 100%;
}
.login-tip {
    font-size: 13px;
    text-align: center;
    color: #bfbfbf;
}
.el-login-footer {
    height: 40px;
    line-height: 40px;
    position: fixed;
    bottom: 0;
    width: 100%;
    text-align: center;
    color: #fff;
    font-family: Arial;
    font-size: 12px;
    letter-spacing: 1px;
}
.lands {
    margin-bottom: 0px;
}
.lands .el-form-item__content {
    width: 100%;
}
.lands .el-form-item__content {
    display: flex;
    justify-content: space-between;
}
.facelogin-form {
    text-align: center;
}
</style>
