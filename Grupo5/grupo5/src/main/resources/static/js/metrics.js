var metrics = new Vue({
    el: '#metrics',
    data: {
        metrics: []
    },
    mounted() {
        axios
            .get('http://localhost:8080/admin/metrics')
            .then(response => (this.metrics = response.data))
    }
});
var rooms = new Vue({
    el: '#rooms',
    data: {
        rooms: []
    },
    mounted() {
        axios
            .get('http://localhost:8080/admin/getRooms')
            .then(response => (this.rooms = response.data))
    }
})