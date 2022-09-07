const platformsearchApp = Vue.createApp({
    data(){
        return{
            platformList:{
                appplatformid:'',
                appplatform:''
            }
        }
    },
    methods:{
        platformSearch(){
            axios
                .get('/platform/list')
        }
    }
})