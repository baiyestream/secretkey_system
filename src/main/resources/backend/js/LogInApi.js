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
                        // console.log("userid: " + localStorage.getItem("user"));
                        console.log("userid: " + userid);
                        console.log(res);

                        // window.location.replace("/backend/test.html");
                        // window.location.replace("/backend/main.html");
                    }else{
                        console.log("login failed,code:" + res.data.code);
                        window.alert("登陆失败！");
                        window.location.replace("/backend/login_sample.html");
                    }
                })
        }
    }
})