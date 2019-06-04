$(document).ready(function() {
	$("#locales").change(function() {
		var selectedOption = $('#locales').val();
		if (selectedOption != '') {
			window.location.replace('?lang=' + selectedOption);
		}
	});
});

$(function() {
	$("form[name='login']").validate({
		rules : {

			email : {
				required : true,
				email : true
			},
			password : {
				required : true,

			}
		},
		messages : {
			email : "Please enter a valid email address",

			password : {
				required : "Please enter password",

			}

		},
		submitHandler : function(form) {
			form.submit();
		}
	});
});