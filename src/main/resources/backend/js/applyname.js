const applynameApp = Vue.createApp({
	data(){
		return{
			applynameList:{
				applynameID:'',
				applyname:''
			}
		}
	},
	methods:{
		applynameSearch(){
			let that = this;
			axios
				.get('/file/list1',{params:{applyname:null}})
				.then(function(res){
					that.applynameList = res.data.data;
					console.log(res.data);
				})
		}
	}
})