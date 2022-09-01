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
            axios
                .post('/user/login',that.LoginForm)
                .then(function (res){
                    if(res.data.code === 1){
                        console.log("login accepted,code: " + res.data.code);
                        let userid=JSON.parse(sessionStorage.getItem("user"));
                        console.log("userid: " + res.data.data.id);
                        window.sessionStorage.setItem("jurisdiction",res.data.data.jurisdiction);
                        window.sessionStorage.setItem("username",res.data.data.username);
                        window.sessionStorage.setItem("password",res.data.data.password);
                        window.sessionStorage.setItem("id",res.data.data.id);
                        window.sessionStorage.setItem("accountid",res.data.data.accountid);
                        window.sessionStorage.setItem("status",res.data.data.status);
                        console.log("jurisdiction: " + window.sessionStorage.getItem("jurisdiction"));
                        console.log(res);

                        // window.location.replace("/backend/test.html");
                        window.alert("调试信息：登陆成功！点击跳转到主页");
                        window.location.replace("/backend/main.html");
                    }else{
                        console.log("login failed,code:" + res.data.code);
                        window.alert("登陆失败！");
                        window.location.replace("/backend/login_sample.html");
                    }
                })
        }
    }
})