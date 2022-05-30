
$(document).ready(function() {
	//1.hide error
	$("#specCodeError").hide();
	$("#specNameError").hide();
	$("#specNoteError").hide();
	//2.declare variables
	var specCodeError = false;
	var specNameError = false;
	var specNoteError = false;
	//3.validate function
	function validate_specCode() {
		var val = $("#specCode").val();
		var exp = /^[A-Z0-9\@\#\!\-]{4,8}$/;
		if (val == '') {
			$("#specCodeError").show();
			$("#specCodeError").html("*Code Cannot be empty");
			$("#specCodeError").css("color", "red");
			specCodeError = false;
		} else if (!exp.test(val)) {
			$("#specCodeError").show();
			$("#specCodeError").html("*Code must be (4-8,A-Z0-9\@\#\!\-) characters");
			$("#specCodeError").css("color", "red");
			specCodeError = false;
		} else {
/*		$.ajax({
				url : '/spec/checkCode',
				data : {"code" : val},
				success : function(respText){
				alert("enter into ajax")
					if(respText != ''){
						$("#specCodeError").show();
						$("#specCodeError").html(respText);
						$("#specCodeError").css("color", "red");
						specCodeError = false;
					}else {
						$("#specCodeError").hide();
						specCodeError = true;
					}
				}
			});
			alert(val)
			$.ajax({		       
		     url: '/spec/checkCode',
		     type: 'GET',
		        data: {'code':val},
		        dataType: "json",
		        success: function(respText) {
		        	alert("hujh90")
		        },
		        error: function(errormessage) {
		        	//$(".apploader-base").css("display", "none");
		            alert(errormessage.respText);
		        }
		    });*/
			$("#specCodeError").hide();
			specCodeError = true;
		}
		return specCodeError;
	}
	function validate_specName() {
		var val = $("#specName").val();
		var exp = /[A-Za-z0-9\s\.]{4,25}$/;
		if (val == "") {
			$("#specNameError").show();
			$("#specNameError").html("*Please Enter Name");
			$("#specNameError").css("color", "red");
			specNameError = false;
		} else if (!exp.test(val)) {
			$("#specNameError").show();
			$("#specNameError").html("*name Must be in this (A-Za-z0-9\s\.,4-25) order");
			$("#specNameError").css("color", "red");
			specNameError = false;
		}
		else {
			$("#specNameError").hide();
			specNameError = true;
		}
		return specNameError;
	}
	function validate_specNote() {
		var val = $("#specNote").val();
		var exp = /[A-Za-z0-9\s\'']{5,50}$/;
		if (val == "") {
			$("#specNoteError").show();
			$("#specNoteError").html("*Note Cannot be empty");
			$("#specNoteError").css("color", "red");
			specNoteError = false;
		} else if (!exp.test(val)) {
			$("#specNoteError").show();
			$("#specNoteError").html("*Note must be in (A-Za-z0-9\s 5,50 )");
			$("#specNoteError").css("color", "red");
			specNoteError = false;
		} else {
			$("#specNoteError").hide();
			specNoteError = true;
		}
		return specNoteError;
	}
	//4.link action event
	$("#specCode").keyup(function() {
		$(this).val($(this).val().toUpperCase());
		validate_specCode();
	});
	$("#specName").keyup(function()  {
		(this).val($(this).val().toUpperCase());
		validate_specName();
	});
	$("#specNote").keyup(function() {
		validate_specNote();
	})
	//5.Submit form
	$("#registerForm").submit(function() {
		validate_specCode();
		validate_specName();
		validate_specNote();
		if (specCodeError && specNameError && specNoteError)
			return true;
		else return false;
	});
});