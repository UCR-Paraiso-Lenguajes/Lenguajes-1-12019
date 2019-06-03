var metrics = new Vue({
    el: '#metrics',
    data: {
            metrics: null
    },
    mounted() {
        axios
            .get('http://localhost:8080/api/metrics')
            .then(response => (this.metrics = response.data))
    }
})