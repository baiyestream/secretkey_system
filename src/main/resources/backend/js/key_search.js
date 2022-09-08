const keySearchApp = Vue.createApp({
	data(){
		return{
			applynameList:{
				applynameid:'',
				applyname:''
			},
			platformList:{
				appplatform:'',
				appplatformid:''
			},
			current :1,
			size :10,
		}
	}
})