var room = new Vue({
    el: '#room',
    data: {
        isChat: false,
        isRoom: false,
        message: '',
        messages:[]
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