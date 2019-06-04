var admin = new Vue({
    el: '#admin',
    data: {
        rooms: [],
        idRoom: '',
        users: [],
        metrics: [],
        userDetails: false,
        alert: false,
        metricDetails: true,
        sendMessage: {}
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
        getUsers: function () {
            axios
                .get('http://localhost:8080/msn/admin/rooms/userRole/' + this.idRoom)
                .then(response => (this.users = response.data));
        },
        userPerRoom: function (idRoom) {
            this.userDetails = true;
            this.metricDetails = false;
            this.idRoom = idRoom;
            this.getUsers();

        },
        promoveAdmin: function (idUser) {
            axios.put(('http://localhost:8080/msn/admin/room/' + this.idRoom + '/' + idUser))
                .then(response => { })
                .catch(e => {
                    //this.errors.push(e)
                })
            this.getUsers();
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
            }, 3000);
            this.enviarMensaje(idUser);
        },
        refreshUser: function () {
            axios
                .get('http://localhost:8080/msn/admin/rooms/userRole/' + this.idRoom)
                .then(response => (this.users = response.data));
        },
        metricsRefresh: function () {
            this.userDetails = false;
            this.metricDetails = true;
            axios
                .get('http://localhost:8080/msn/admin/metrics')
                .then(response => (this.metrics = response.data));
        },
        enviarMensaje: function (idUser) {
            this.sendMessage = {
                contenido: 'El usuario' + idUser + 'a sido baneado',
                userSendThatMessage: idUser,
                idRoom: this.idRoom
            }
            this.insertMessage();
        },
        insertMessage: function () {
            axios.post(`http://localhost:8080/msn/insertMessage`, this.sendMessage)
                .then(response => { })
                .catch(e => {
                    this.errors.push(e)
                });
        }
    }
})