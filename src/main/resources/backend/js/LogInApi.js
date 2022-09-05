const LoginApp = Vue.createApp({
    data(){
        return{
            LoginForm:{
                username:"root",
                password:null
            },
            info:null
        }
    },
    methods:{
        LogIn(){
            let that = this;
            axios//vue使用axios进行ajax请求
                .post('/user/login',that.LoginForm)//post请求
                .then(function (res){//然后获取response就是res
                    if(res.data.code === 1){//如果code是1就是登陆成功
                        console.log(res);
                        console.log("login accepted,code: " + res.data.code);
                        console.log("userid: " + res.data.data.id);
                        //把res中传来的user的各类数据
                        window.sessionStorage.setItem("jurisdiction",res.data.data.jurisdiction);
                        window.sessionStorage.setItem("username",res.data.data.username);
                        window.sessionStorage.setItem("password",res.data.data.password);
                        window.sessionStorage.setItem("id",res.data.data.id);
                        window.sessionStorage.setItem("accountid",res.data.data.accountid);
                        window.sessionStorage.setItem("status",res.data.data.status);
                        console.log("jurisdiction: " + window.sessionStorage.getItem("jurisdiction"));
                        // window.location.replace("/backend/test.html");
                        window.alert("调试信息：登陆成功！点击跳转到主页");
                        window.location.replace("/backend/mainpage.html");
                        // window.location.replace("/backend/main_test.html");
                    }else{
                        console.log("login failed,code:" + res.data.code);
                        window.alert("登陆失败！");
                        window.location.replace("/backend/login.html");
                    }
                })
        }
    }
})