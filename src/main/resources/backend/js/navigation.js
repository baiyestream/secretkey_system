const navApp = Vue.createApp({
	data(){
		return{
			username:'',
			nickname:''
		}
	},
	computed:{
		adminView:function(){
			if(window.sessionStorage.getItem("jurisdiction") == 1){
				return true;
			}else{
				return false;
			}
		}
	},
	methods:{
		jump(location){
			switch(location){
				case 'MainPage':
				window.location.replace("MainPage.html");
				break;
				case 'FileManage':
				window.location.replace("FileManageIndex.html");
				break;
				case 'KeyGenerate':
				window.location.replace("KeyGenerate.html");
				break;
				case 'ActivationManage':
				window.location.replace("ActivationManage.html");
				break;
				case 'userManage':
				window.location.replace("userManage.html");
				break;
				case 'UserInfo':
				window.location.replace("UserInformation.html");
				break;
			}
		},
		init(){
			this.username = window.sessionStorage.getItem("username");
			this.nickname = window.sessionStorage.getItem("nickname");
		}
	}
})