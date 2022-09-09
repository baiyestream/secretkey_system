const fileUploadApp = Vue.createApp({
	data(){
		return{
			file: []
		}
	},
	methods:{
		upload(e){
			let that = this;
			let event = window.event || e;
			console.log(that.$refs.file.value);
			console.log(that.$refs.file);
			console.log(event.target.files[0]);
			that.file = event.target.files[0];
			console.log(that.file);
			axios
			    .post('/common/upload',that.file)
                .then(function(res){
                    console.log(res);
                })
		}
	}
})