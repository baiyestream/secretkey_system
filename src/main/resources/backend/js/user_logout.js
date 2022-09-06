const userLogoutApp = Vue.createApp({
    methods:{
        LogOut(){
            axios
                .post('/user/logout')
                .then(function(res){
                    console.log(res);
                });
            window.sessionStorage.clear();
            // window.location.replace("/backend/login.html");
            // this.info = '调试信息：尚未登陆！';
        }
    }
})