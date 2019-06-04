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
        nombreRoom: '',
        createdRoom: {},
        createdUser: {}
    },
    mounted() {
        let url = 'url' + window.location;
        let user = url.split('=');
        this.idUser = user[1];
        axios
            .get('http://localhost:8080/msn/getRoomPerUser?idUser=' + this.idUser)
            .then(response => (this.rooms = response.data));
    },
    methods: {
        createRoom: function () {
            this.isRoom = !this.isRoom;
            this.isChat = false;
            this.createdRoom = {
                roomName: this.nombreRoom,
            }
            this.createUser = {
                idUser: this.idUser
            }
            axios.post(`http://localhost:8080/msn/createRoom`, this.createdRoom, this.createUser)
                .then(response => { })
                .catch(e => {
                    //this.errors.push(e)
                });
            this.nombreRoom = '';
        },
        verChatPerRoom: function (idRoom) {
            this.idRoom = idRoom;
            this.isChat = !this.isChat;
            this.isRoom = false;
            this.getMessagePerRoom();
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
            }, 3000);


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
        }
    }
})