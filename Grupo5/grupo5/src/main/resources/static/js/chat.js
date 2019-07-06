var room = new Vue({
    el: '#room',
    data: {
        isChat: false,
        isRoom: false,
        message: '',
        messages: [],
        rooms: [],
        idUser: '',
        idRoom: 0,
        sendMessage: {},
        roomName: '',
        users: [],
        admin: 'Administrador',
        member: 'Member',
        alert: false,
        invitar: false,
        emails: ''

    },
    mounted() {
        let url = 'url' + window.location;
        let user = url.split('=');
        this.idUser = user[1];
        setInterval(() => {
            this.getRoomsPerUser(), 10000
        })
    },
    methods: {
        createRoom: function () {
            this.isRoom = true;
            this.isChat = false;
            this.createUser = {
                idUser: this.idUser
            }
            axios.post('http://localhost:8080/msn/createRoom/' + this.roomName + '/' + this.idUser)
                .then(response => { })
                .catch(e => {
                    this.errors.push(e)
                });
            this.alert = true;
            setTimeout(() => {
                this.alert = false;
            }, 10000);
            this.roomName = '';
        },
        verChatPerRoom: function (idRoom) {
            this.isRoom = false;
            this.isChat = true;
            this.idRoom = idRoom;
            this.getMessagePerRoom();
            this.info();
        },
        enviarMensaje: function () {
            this.sendMessage = {
                contenido: this.message,
                userSendThatMessage: this.idUser,
                idRoom: this.idRoom
            }
            this.message = '';
            this.insertMessage();
            setInterval(() => {
                this.getMessagePerRoom();
            }, 30000);
        },
        getMessagePerRoom: function () {
            axios
                .get('http://localhost:8080/msn/getMessages?idRoom=' + this.idRoom)
                .then(response => (this.messages = response.data));
        },
        insertMessage: function () {
            axios.post(`http://localhost:8080/msn/insertMessage`, this.sendMessage)
                .then(response => { })
                .catch(e => {
                    this.errors.push(e)
                });
        },
        getRoomsPerUser: function () {
            axios
                .get('http://localhost:8080/msn/getRoomPerUser?idUser=' + this.idUser)
                .then(response => (this.rooms = response.data));
        },
        info: function () {
            axios
                .get('http://localhost:8080/msn/admin/rooms/userRole/' + this.idRoom)
                .then(response => (this.users = response.data));
        },
        invitarGente: function () {
            this.invitar = true;
        },
        sendInvitation: function () {

            axios.post('http://localhost:8080/msn/invite/' + this.idRoom + '/' + this.emails)
                .then(response => { })
                .catch(e => {
                    this.errors.push(e)
                });
            this.invitar = false;
        }
    }
})