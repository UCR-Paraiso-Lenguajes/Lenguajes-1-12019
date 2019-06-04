var admin = new Vue({
    el: '#admin',
    data: {
        rooms: [],
        idRoom: '',
        users: [],
        metrics: [],
        userDetails: false,
        alert: false,
        metricDetails: true
    },
    mounted() {
        axios
            .get('http://localhost:8080/msn/admin/rooms')
            .then(response => (this.rooms = response.data));
        axios
            .get('http://localhost:8080/msn/admin/metrics')
            .then(response => (this.metrics = response.data));
        setInterval(() => {
            this.refreshUser();
        }, 3000);
    },
    methods: {
        userPerRoom: function (idRoom) {
            this.userDetails = true;
            this.metricDetails = false;
            this.idRoom = idRoom;
            axios
                .get('http://localhost:8080/msn/admin/rooms/' + this.idRoom)
                .then(response => (this.users = response.data));
        },
        promoveAdmin: function (idUser) {

        },
        banUser: function (idUser) {
            axios.delete(('http://localhost:8080/msn/admin/room/' + this.idRoom + '/' + idUser))
                .then(response => { })
                .catch(e => {
                    this.errors.push(e)
                })
            this.alert = true;
            setTimeout(() => {
                this.alert = false;
            }, 3000)
        },
        refreshUser: function () {
            axios
                .get('http://localhost:8080/msn/admin/rooms/' + this.idRoom)
                .then(response => (this.users = response.data));
        },
        metricsRefresh: function () {
            this.userDetails = false;
            this.metricDetails = true;
            axios
                .get('http://localhost:8080/msn/admin/metrics')
                .then(response => (this.metrics = response.data));
        }
    }
})