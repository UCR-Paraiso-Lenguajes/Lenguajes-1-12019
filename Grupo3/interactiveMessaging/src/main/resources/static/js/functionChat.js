$(".messages").animate({
	scrollTop : $(document).height()
}, "fast");
var idUserRoom = $("#userRoom");
var idGroup;
var nameGroup;
var previousTag;
var ulM = jQuery('.messages ul');
var pActual = document.getElementById("ActualGroupName");
var host = window.location.hostname;
function print(i) {

	if (previousTag != null) {
		if (previousTag.classList.contains('contact')
				&& previousTag.classList.contains('active')) {
			previousTag.classList.remove('active');
			i.classList.add('active');
		}
	} else {
		i.classList.add('active');
	}
	// console.log(i);
	idGroup = i.children[0].children[1].children[1];
	nameGroup = i.children[0].children[1].children[0].innerHTML;

	pActual.innerHTML = nameGroup;
	// jQuery('.messages ul').empty();

	upDateMessagesFrame();
	previousTag = i;

	startTimer();// /////////////////////hilo
};

function sendToServer() {
	var inputText = $("#text");

	if (inputText.val() != "") {
		console.log(inputText.val() + " " + idUserRoom.val() + " "
				+ idGroup.value);

		var obj = {

			"message" : inputText.val()

		};

		$.ajax({
			method : "PUT",
			data : JSON.stringify(obj),
			contentType : "application/json",
			url : "api/sendMessages/" + idGroup.value + "/" + idUserRoom.val()

		});
	}

};
$(".expand-button").click(function() {
	$("#profile").toggleClass("expanded");
	$("#contacts").toggleClass("expanded");
});

function newMessage() {
	sendToServer();
	message = $(".message-input input").val();
	if ($.trim(message) == '') {
		return false;
	}
	$(
			'<li class="sent"><img src="http://emilcarlsson.se/assets/mikeross.png" alt="" /><p>'
					+ message + '</p></li>').appendTo($('.messages ul'));
	$('.message-input input').val(null);
	$('.contact.active .preview').html('<span>You: </span>' + message);
	$(".messages").animate({
		scrollTop : $(document).height()
	}, "fast");
};

$('.submit').click(function() {
	newMessage();
});

$(window).on('keydown', function(e) {
	if (e.which == 13) {
		newMessage();
		return false;
	}
});

/*
 * //////////////////////////////////Acciones para Pop Up /////////////////////////////*/


var btnAbrirPopup = document.getElementById('btn-abrir-popup'), overlay = document
		.getElementById('overlay'), popup = document.getElementById('popup'), btnCerrarPopup = document
		.getElementById('btn-cerrar-popup');

btnAbrirPopup.addEventListener('click', function() {
	overlay.classList.add('active');
	popup.classList.add('active');

});

btnCerrarPopup.addEventListener('click', function(e) {
	e.preventDefault();
	overlay.classList.remove('active');
	popup.classList.remove('active');
});

/* Lenguaje */
$(document).ready(function() {
	$("#locales").change(function() {
		var selectedOption = $('#locales').val();
		if (selectedOption != '') {
			window.location.replace('?lang=' + selectedOption);
		}
	});
});