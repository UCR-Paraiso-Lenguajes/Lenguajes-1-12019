var metrics = new Vue({
    el: '#metrics',
    data: {
            metrics: []
    },
    mounted() {
        axios
            .get('http://localhost:8080/api/metrics')
            .then(response => (this.metrics = response.data))
    }
})