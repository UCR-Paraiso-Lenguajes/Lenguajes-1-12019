var room = new Vue({
    el: '#room',
    data: {
        isChat: false,
        isRoom: false,
        message: '',
        messages: [],
        rooms: []
    },
    mounted() {
        axios
            .get('http://localhost:8080/api/rooms')
            .then(response => (this.rooms = response.data))
    },
    methods: {
        createRoom: function () {
            this.isRoom = !this.isRoom;
        },
        verChatPerRoom: function () {
            this.isChat = !this.isChat;
        },
        enviarMensaje: function () {
            this.messages.push({
                message: this.message
            }),
                this.message = '';
        }
    }
})