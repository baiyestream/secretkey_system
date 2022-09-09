const userLoginApp = Vue.createApp({
    data(){
        return{
            LoginForm:{
                username:'testname',
                password:'testpassword'
            },
            info: '调试信息：尚未登陆！',
            keepStatus :false,
            isActive : false,
            PwInputType: 'password'
        }
    },
	computed:{
		usernameCaution:{
			set:function(){
				return false;
			},
			get:function(){
				if(this.LoginForm.username != ''){
					return false;
				}
				return true;
			}
		},
		passwordCaution:{
			set:function(){
				return false;
			},
			get:function(){
				if(this.LoginForm.password != ''){
					return false;
				}
				return true;
			}
		}
	},
    methods:{
        LogIn(){
            let that = this;
            axios//vue使用axios进行ajax请求
                .post('/user/login',that.LoginForm)//post请求
                .then(function (res){//然后获取response就是res
                    if(res.data.code === 1){//如果code是1就是登陆成功
                        that.keep();
                        console.log(res);
                        console.log("login accepted,code: " + res.data.code);
                        console.log("userid: " + res.data.data.accountid);
                        //把res中传来的user的各类数据
                        window.sessionStorage.setItem("jurisdiction",res.data.data.jurisdiction);
                        window.sessionStorage.setItem("username",res.data.data.username);
                        window.sessionStorage.setItem("password",res.data.data.password);
                        window.sessionStorage.setItem("nickname",res.data.data.nickname);
                        window.sessionStorage.setItem("accountid",res.data.data.accountid);
                        window.sessionStorage.setItem("status",res.data.data.status);
                        console.log("jurisdiction: " + window.sessionStorage.getItem("jurisdiction"));
                        // window.alert("调试信息：登陆成功！点击跳转到主页");
                        window.location.replace("MainPage.html");
                        // window.location.replace("/backend/main_test.html");
						that.info = '调试信息：登陆成功！点击跳转到主页';
                        console.log(that.info);
                    }else{
                        console.log("login failed,code:" + res.data.code);
                        that.info = '调试信息：登陆失败！'
                        window.alert("登陆失败！");
                        // window.location.replace("/backend/login.html");

                    }
                })
        },
        keep(){
            if(this.keepStatus == true){
                window.localStorage.setItem("username",this.LoginForm.username);
                window.localStorage.setItem("password",this.LoginForm.password);
                window.localStorage.setItem("keepStatus","true");
            }else{
                window.localStorage.setItem("username","");
                window.localStorage.setItem("password","");
                window.localStorage.setItem("keepStatus","false");
            }
        },
        init(){
            if(window.localStorage.getItem("keepStatus") == "true"){
                console.log("status is true")
                this.LoginForm.username = window.localStorage.getItem("username");
                this.LoginForm.password = window.localStorage.getItem("password");
                this.keepStatus = true;
            }else{
                window.localStorage.setItem("username","");
                window.localStorage.setItem("password","");
                window.localStorage.setItem("keepStatus","false");
            }
        },
   //      userInput(){
			// if(this.LoginForm.username != ''){
			// 	this.usernameCaution = false;
			// }else{
			// 	this.usernameCaution = true;
			// }
   //          console.log(this.usernameCaution);
			// if(this.LoginForm.password != ''){
			// 	this.passwordCaution = false;
			// }else{
			// 	this.passwordCaution = true;
			// }
   //          console.log(this.passwordCaution);
   //      }
        showPassword(){
            if(this.isActive == true){
                this.isActive = false;
                this.PwInputType = 'password';
            }else{
                this.isActive = true;
                this.PwInputType = 'text';
            }
        }
    }
})
