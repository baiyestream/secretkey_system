const userSearchApp = Vue.createApp({
	data(){
		return{
			userSearchForm:{
				current:1,
				size:10,
				accountid:null
			},
			userlist:{
				accountid:'',
				jurisdiction:'',
				nickname:'',
				password:'',
				status:'',
				username:''
			}
		}
	},
	methods:{
		UserSearch(){
			let that = this;
			let current = that.userSearchForm.current;
			let size = that.userSearchForm.size;
			// let str = null;
			// if(that.accountid === null){//全查询
			// 	axios
			// 		.get('/user/search',{params:{current: current,size:size}})
			// 		.then(function(res){
			// 			// console.log(res.data);
			// 			console.log(res);
			// 			// document.writeln(res.data.data);
			// 			that.userlist = res.data.data.records;
			// 			console.log(that.userlist);
			// 			for(var i = 0;i < that.userlist.length;i++){
			// 				var item = that.userlist[i];
			// 				console.log(item);
			// 			}
			//
			// 		});
			// }else{//按照id查询一条数据
			// 	axios
			// 		.get('/user/search',{params:that.userSearchForm})
			// 		.then(function(res){
			// 			// console.log(res.data);
			// 			console.log(res);
			// 			// document.writeln(res.data.data);
			// 			that.userlist = res.data.data.records;
			// 			console.log(that.userlist);
			// 		})
			// }
			axios
				.get('/user/search',{params:that.userSearchForm})
				.then(function(res){
					// console.log(res.data);
					console.log(res);
					// document.writeln(res.data.data);
					that.userlist = res.data.data.records;
					console.log(that.userlist);
					for(var i = 0;i < that.userlist.length;i++){
						var item = that.userlist[i];
						console.log(item);
					}

				});

		}
	}
})