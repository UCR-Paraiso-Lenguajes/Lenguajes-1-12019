var admin = new Vue({
    el: '#admin',
    data: {
        rooms: [],
        idRoom: '',
        users: [],
        metrics: [],
        userDetails: false
    },
    mounted() {
        axios
            .get('http://localhost:8080/msn/admin/rooms')
            .then(response => (this.rooms = response.data));
        axios
            .get('http://localhost:8080/msn/admin/metrics')
            .then(response => (this.metrics = response.data));
    },
    methods: {
        userPerRoom: function (idRoom) {
            this.idRoom = idRoom;
            this.userDetails = !this.userDetails;
            axios
                .get('http://localhost:8080/msn/admin/rooms/' + this.idRoom)
                .then(response => (this.users = response.data));
                console.log('http://localhost:8080/msn/admin/rooms/' + this.idRoom);
        }
    }
})