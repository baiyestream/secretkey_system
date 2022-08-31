const LoginApp = Vue.createApp({
    data(){
        return{
            LoginForm:{
                username:"root",
                password:"root"
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
                        console.log("login accepted,code:" + res.data.code);
                        window.location.replace("/backend/main.html");
                    }else{
                        console.log("login failed,code:" + res.data.code);
                    }
                })
        }
    }
})