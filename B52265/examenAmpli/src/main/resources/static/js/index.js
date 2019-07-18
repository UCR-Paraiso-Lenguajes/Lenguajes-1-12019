var room = new Vue({
    el: '#room',
    data: {
        peliculas:[],
        video:''
    },
    mounted() {
       this.getPeliculas();
    },
    methods: {
        getPeliculas: function () {
            axios
                .get('http://localhost:8080/peliculas/')
                .then(response => (this.peliculas = response.data));
        },
        verPelicula: function (video) {
            this.video=video
            console.log(this.video)
          }
    }
})