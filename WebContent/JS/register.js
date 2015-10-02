$(document)
		.ready(
				function() {

					$('form')
							.submit(
									function(e) {

										var password = $('#password').val();
										var password2 = $('#password2').val();

										if (password != password2) {
											alert("Passowrd are not identical!!");
											return false;
										}

										var email = $('#email').val();
										var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
										if (!re.test(email)) {
											alert("Email format invalid!");
											return false;
										}

										var creditcard = $('#creditcard').val();
										var re = /^\d{16}$/i;
										if (!re.test(creditcard)) {
											alert("credit card must be 16 digit number!");
											return false;
										}

									});

				});
