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
    },
    mounted() {
        let url = 'url' + window.location;
        let user = url.split('=');
        this.idUser = user[1];
        console.log(this.idUser);
        axios
            .get('http://localhost:8080/msn/getRoomPerUser?idUser=' + this.idUser)
            .then(response => (this.rooms = response.data));
        setInterval(() => {
            this.getRoomsPerUser(), 1000
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
                    //this.errors.push(e)
                });
            this.roomName = '';
        },
        verChatPerRoom: function (idRoom) {
            this.isRoom = false;
            this.isChat = true;
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
        },
        getRoomsPerUser: function () {
            axios
                .get('http://localhost:8080/msn/getRoomPerUser?idUser=' + this.idUser)
                .then(response => (this.rooms = response.data));
        }
    }
})