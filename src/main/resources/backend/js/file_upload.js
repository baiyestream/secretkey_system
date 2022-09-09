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
			let formData = new FormData();
			formData.append('file', event.target.files[0]);
			console.log(event.target.files[0]);
			console.log(formData);
			axios
			    .post('/common/upload',formData)
                .then(function(res){
                    console.log(res);
                })
		}
	}
})