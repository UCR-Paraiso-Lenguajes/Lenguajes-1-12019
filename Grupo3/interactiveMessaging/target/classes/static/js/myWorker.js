function startTimer() {
    var start = Date.now(),
        diff,
        seconds;
    function timer() {
        // get the number of seconds that have elapsed since 
        // startTimer() was called
        diff = 1 - (((Date.now() - start) / 1000) | 0);

        // does the same job as parseInt truncates the float
        
        seconds = (diff % 60) | 0;

       
        //seconds = seconds < 10 ? "0" + seconds : seconds;

        
        if(diff===0){
        	//console.log(0);
        	upDateNEWMessagesFrame();
        }
        if (diff <= 0) {
            // add one second so that the count down starts at the full duration
            // example 05:00 not 04:59
            start = Date.now() + 1000;
        }
    };
    // we don't want to wait a full second before the timer starts
    timer();
    setInterval(timer, 1000);
    interv = setInterval(timer, 1000);
}
function upDateMessagesFrame(){
	ulM.empty();
	$
	.getJSON(
			"http://"+host+":8080/msn/api/messages/?idGroup="
					+ idGroup.value + "&idUserRoom="
					+ idUserRoom.val(),
			{
				name : 'messages'
			},
			function(data, textStatus, jqXHR) {

				var msclass;
				var mstext;

				var size = 0;
				for (key in data) {
					if (data.hasOwnProperty(key))
						msclass = data[size].type;
					mstext = data[size].message;
					$(
							'<li class='+msclass+'><img src="http://emilcarlsson.se/assets/mikeross.png" alt="" /><p>'
									+ mstext + '</p></li>')
							.appendTo($('.messages ul'));
					size++;
				}
				;

			});
}
function upDateNEWMessagesFrame(){
	$
	.getJSON(
			"http://"+host+":8080/msn/api/newmessages/?idGroup="
					+ idGroup.value + "&idUserRoom="
					+ idUserRoom.val(),
			{
				name : 'messages'
			},
			function(data, textStatus, jqXHR) {

				var msclass;
				var mstext;

				var size = 0;
				for (key in data) {
					if (data.hasOwnProperty(key))
						msclass = data[size].type;
						console.log(msclass);
					mstext = data[size].message.message;
					$(
							'<li class='+msclass+'><img src="http://emilcarlsson.se/assets/mikeross.png" alt="" /><p>'
									+ mstext + '</p></li>')
							.appendTo($('.messages ul'));
					size++;
				}
				;

			});
}

