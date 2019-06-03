$(document).ready(function() {
	$("#locales").change(function() {
		var selectedOption = $('#locales').val();
		if (selectedOption != '') {
			window.location.replace('?lang=' + selectedOption);
		}
	});
});

$(function() {
	$("form[name='loginUser']").validate({
		rules : {

			email : {
				required : true,
				email : true
			},
		},
		messages : {
			email : "Please enter a valid email address",

		},
		submitHandler : function(form) {
			form.submit();
		}
	});
});