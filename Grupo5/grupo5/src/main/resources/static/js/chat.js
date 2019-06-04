var room = new Vue({
    el: '#room',
    data: {
        isChat: false,
        isRoom: false,
        message: '',
        messages: [],
        rooms: [],
        idUser: '',
        idRoom: '',
        sendMessage: []
    },
    mounted() {
        let url = 'url'+window.location;
        let user = url.split('=');
        this.idUser = user[1];
        axios
            .get('http://localhost:8080/getRoomPerUser?idUser='+this.idUser)
            .then(response => (this.rooms = response.data))
    },
    methods: {
        createRoom: function () {
            this.isRoom = !this.isRoom;
            this.isChat = false;
        },
        verChatPerRoom: function (idRoom) {
            this.idRoom = idRoom;
            this.isChat = !this.isChat;
            this.isRoom = false;
            alert(this.idRoom);
        },
        enviarMensaje: function () {
            this.messages.push({
                idUser: this.idUser,
                idRoom: this.idRoom,
                message: this.message
            }),
                this.message = '';
        }
    }
})