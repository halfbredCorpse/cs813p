<%-- 
    Document   : payment
    Created on : 06 19, 18, 5:36:42 PM
    Author     : Aristan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Book-O Shack</title>
<!--/tags -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--//tags -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/font-awesome.css" rel="stylesheet"> 
<link href="css/easy-responsive-tabs.css" rel="stylesheet" type="text/css"/>
<!-- //for bootstrap working -->
<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,900,900italic,700italic" rel="stylesheet" type="text/css">
</head>
<body>
<!-- header -->
<div class="header" id="home" style ="background-color: #472C00">
	<div class="container">
		<ul>
		    <li> <a href="#" data-toggle="modal" data-target="#myModal"><i class="fa fa-unlock-alt" aria-hidden="true"></i> Sign In </a></li>
			<li> <a href="#" data-toggle="modal" data-target="#myModal2"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Sign Up </a></li>
			<li><i class="fa fa-phone" aria-hidden="true"></i> Call : +63(2) 891-0837</li>
			<li><i class="fa fa-envelope-o" aria-hidden="true"></i> <a href="mailto:bshack@gmail.com">bshack@gmail.com</a></li>
		</ul>
	</div>
</div>
<!-- //header -->
<!-- header-bot -->
<div class="header-bot" style="background-color: saddlebrown">
	<div class="header-bot_inner_wthreeinfo_header_mid">
		<div class="col-md-4 header-middle">
			<form action="#" method="post">
					<input type="search" name="search" placeholder="Search here..." required="">
					<input type="submit" class="search-button" value=" ">
				<div class="clearfix"></div>
			</form>
		</div>
		<!-- header-bot -->
			<div class="col-md-4 logo_agile">
				<h1><a href="index.jsp"><img src="images/logo.png" alt=""/></a></h1> <!-- LOGO-->
			</div>
        <!-- header-bot -->
		<div class="clearfix"></div>
	</div>
</div>
<!-- //header-bot -->
<!-- banner -->
<div class="ban-top">
	<div class="container">
		<div class="top_nav_left">
			<nav class="navbar navbar-default">
			  <div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
				  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				  </button>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse menu--shylock" id="bs-example-navbar-collapse-1">
				  <ul class="nav navbar-nav menu__list">
					<li class=" menu__item"><a class="menu__link" href="index.jsp">Home</a></li>				  
					<li class="active menu__item menu__item"><a class="menu__link" href="about.jsp">About <span class="sr-only">(current)</span></a></li>
					<li class="dropdown menu__item">
						<a href="#" class="dropdown-toggle menu__link" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Categories <span class="caret"></span></a>
							<ul class="dropdown-menu multi-column columns-3">
								<div class="agile_inner_drop_nav_info">
									<div class="col-sm-6 multi-gd-img1 multi-gd-text ">
										<a href="bestseller.jsp"><img src="images/categories.jpg" alt=" "/></a>
									</div>								
									<div class="col-sm-3 multi-gd-img">
										<ul class="multi-column-dropdown">
											<li><a href="bestseller.jsp">Best Sellers</a></li>
											<li><a href="childrens.jsp">Children's Books</a></li>
											<li><a href="classics.jsp">Classics & Poetry</a></li>
											<li><a href="cookbooks.jsp">Cookbooks</a></li>
											<li><a href="graphic.jsp">Graphic Novels</a></li>
										</ul>
									</div>
									<div class="clearfix"></div>
								</div>
							</ul>
					</li>
					<li class=" menu__item"><a class="menu__link" href="contact.jsp">Contact</a></li>
					<li class=" menu__item--current"><a class="menu__link" href="checkout.jsp">Checkout</a></li>
				  </ul>
				</div>
			  </div>
			</nav>	
		</div>
		<div class="top_nav_right">
			<div class="wthreecartaits wthreecartaits2 cart cart box_1"> 
						<form action="#" method="post" class="last"> 
						<input type="hidden" name="cmd" value="_cart">
						<input type="hidden" name="display" value="1">
						<button class="w3view-cart" type="submit" name="submit" value=""><i class="fa fa-cart-arrow-down" aria-hidden="true"></i></button>
					</form>  
  
		  </div>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
<!-- //banner-top -->
<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
						<div class="modal-body modal-body-sub_agile">
						<div class="col-md-8 modal_body_left modal_body_left1">
						<h3 class="agileinfo_sign">Sign In <span>Now</span></h3>
									<form action="#" method="post">
							<div class="styled-input agile-styled-input-top">
								<input type="text" name="Email" required="">
								<label>Email</label>
								<span></span>
							</div>
							<div class="styled-input">
								<input type="email" name="Password" required=""> 
								<label>Password</label>
								<span></span>
							</div> 
							<input type="submit" value="Sign In">
						</form>
							<div class="clearfix"></div>
							<p><a href="#" data-toggle="modal" data-target="#myModal2" > Don't have an account?</a></p>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
				<!-- //Modal content-->
			</div>
		</div>
<!-- //Modal1 -->
<!-- Modal2 -->
		<div class="modal fade" id="myModal2" tabindex="-1" role="dialog">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
						<div class="modal-body modal-body-sub_agile">
						<div class="col-md-8 modal_body_left modal_body_left1">
						<h3 class="agileinfo_sign">Sign Up <span>Now</span></h3>
						 <form action="#" method="post">
							<div class="styled-input agile-styled-input-top">
								<input type="text" name="Username" required="">
								<label>Username</label>
								<span></span>
							</div>
							<div class="styled-input">
								<input type="email" name="Email" required=""> 
								<label>Email</label>
								<span></span>
							</div> 
							<div class="styled-input">
								<input type="password" name="password" required=""> 
								<label>Password</label>
								<span></span>
							</div> 
							<div class="styled-input">
								<input type="text" name="First Name" required="">
								<label>First name</label>
								<span></span>
							</div>            
							<div class="styled-input">
								<input type="text" name="Last Name" required="">
								<label>Last name</label>
								<span></span>
							</div>        
							<div class="styled-input">
								<input type="text" name="Street" required="">
								<label>Street</label>
								<span></span>
							</div>   
							<div class="styled-input">
								<input type="text" name="City" required="">
								<label>City</label>
								<span></span>
							</div> 
							<div class="styled-input">
								<input type="text" name="Province" required="">
								<label>Province</label>
								<span></span>
							</div>      
							<div class="styled-input">
								<input type="text" name="Zip" required="">
								<label>Zip</label>
								<span></span>
							</div> 
							<div class="styled-input">
								<input type="text" name="Longtitude" required="">
								<label>Longitude</label>
								<span></span>
							</div>      
							<div class="styled-input">
								<input type="text" name="Latitude" required="">
								<label>Latitude</label>
								<span></span>
							</div>      
							<div class="styled-input">
								<input type="text" name="Credit Card" required="">
								<label>Credit Card</label>
								<span></span>
							</div>    
							<div class="styled-input">
								<input type="text" name="CV" required="">
								<label>CV</label>
								<span></span>
							</div>   
							<input type="submit" value="Sign Up">
						</form>
							<div class="clearfix"></div>
							<p><a href="#">By clicking register, you agree to our terms</a></p>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
				<!-- //Modal content-->
			</div>
		</div>
<!-- //Modal2 -->
<!--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!-->
<div class="page-head_agile_info_w3l">
		<div class="container">
			<h3>Pay<span>ment </span></h3>
			<!--/w3_short-->
				 <div class="services-breadcrumb">
						<div class="agile_inner_breadcrumb">

						   <ul class="w3_short">
								<li><a href="index.jsp">Home</a><i>|</i></li>
								<li>Payment</li>
							</ul>
						 </div>
				</div>
	   <!--//w3_short-->
	</div>
</div>

<!-- payment -->
		<div class="privacy about">
	         <div class="checkout-right">
				<!--Horizontal Tab-->
        <div id="parentHorizontalTab">
            <div class="resp-tabs-container hor_1">
                <div>
                    <form action="#" method="post" class="creditly-card-form agileinfo_form">
									<section class="creditly-wrapper wthree, w3_agileits_wrapper">
										<div class="credit-card-wrapper">
											<div class="first-row form-group">
												<div class="controls">
													<label class="control-label">Cardholder Name</label>
													<input class="billing-address-name form-control" type="text" name="name" placeholder="John Smith">
												</div>
												<div class="w3_agileits_card_number_grids">
													<div class="w3_agileits_card_number_grid_left">
														<div class="controls">
															<label class="control-label">Card Number</label>
															<input class="number credit-card-number form-control" type="text" name="number"
																		  inputmode="numeric" autocomplete="cc-number" autocompletetype="cc-number" x-autocompletetype="cc-number"
																		  placeholder="&#149;&#149;&#149;&#149; &#149;&#149;&#149;&#149; &#149;&#149;&#149;&#149; &#149;&#149;&#149;&#149;">
														</div>
													</div>
													<div class="w3_agileits_card_number_grid_right">
														<div class="controls">
															<label class="control-label">CVV</label>
															<input class="security-code form-control" inputmode="numeric" type="text" name="security-code" placeholder="&#149;&#149;&#149;">
														</div>
													</div>
													<div class="clear"> </div>
												</div>
												<div class="controls">
													<label class="control-label">Expiration Date</label>
													<input class="expiration-month-and-year form-control" type="text" name="expiration-month-and-year" placeholder="MM / YY">
												</div>
											</div>
											 <input class="btn btn-primary submit" type="submit" value="Submit Payment">
										</div>
									</section>
								</form>

                </div>
                <div>
                </div>
                
            </div>
        </div>
	
	<!--Plug-in Initialisation-->

	<!-- // Pay -->
	
			 </div>

		</div>
<!-- //payment -->
<!--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!->
<!-- footer -->
<div class="footer">
	<div class="footer_agile_inner_info_w3l">
		<div class="col-md-3 footer-left">
			<h2><a href="index.jsp"><span>Book-O Shack</span></a></h2>
			<p>Book-O Shack is your one-stop shop for all your academic needs.</p>
		</div>
		<div class="col-md-9 footer-right">
			<div class="sign-grds">
				<div class="col-md-4 sign-gd">
					<h4>Quick <span>Links</span> </h4>
					<ul>
						<li><a href="index.jsp">Home</a></li>
						<li><a href="about.jsp">About Us</a></li>
						<li><a href="bestseller.jsp">Best Sellers</a></li>
						<li><a href="childrens.jsp">Children's Books</a></li>						
						<li><a href="classics.jsp">Classics & Poetry</a></li>
						<li><a href="cookbooks.jsp">Cookbooks</a></li>
						<li><a href="graphic.jsp">Graphic Novels</a></li>
						<li><a href="contact.jsp">Contact</a></li>
					</ul>
				</div>
				
				<div class="col-md-5 sign-gd-two">
					<h4>Store <span>Information</span></h4>
					<div class="w3-address">
						<div class="w3-address-grid">
							<div class="w3-address-left">
								<i class="fa fa-phone" aria-hidden="true"></i>
							</div>
							<div class="w3-address-right">
								<h6>Phone Number</h6>
								<p>+63(2) 891-0837</p>
							</div>
							<div class="clearfix"> </div>
						</div>
						<div class="w3-address-grid">
							<div class="w3-address-left">
								<i class="fa fa-envelope" aria-hidden="true"></i>
							</div>
							<div class="w3-address-right">
								<h6>Email Address</h6>
								<p>Email :<a href="mailto:bshack@gmail.com"> <br>bshack@gmail.com</a></p>
							</div>
							<div class="clearfix"> </div>
						</div>
						<div class="w3-address-grid">
							<div class="w3-address-left">
								<i class="fa fa-map-marker" aria-hidden="true"></i>
							</div>
							<div class="w3-address-right">
								<h6>Location</h6>
								<p>333 Sen. Gil Puyat Ave., Makati City 1200, Philippines
								
								</p>
							</div>
							<div class="clearfix"> </div>
						</div>
					</div>
				</div>
				<div class="col-md-3 sign-gd flickr-post">
				<h4>The <span>Team</span></h4>
					<div class="w3-address">
						<div class="w3-address-grid">
							<div class="w3-address-right">												
								<h6>A CS183P Project</h6>
								<h6>CC2</h6>
								<p>AGUAS, Nathanael Jhonn</p>
								<p>FRADEJAS, <br>Aristan Noelle P.</p>
								<p>LIM, <br>Jasmin Rose G.</p>
								<p>PELIPAS, <br>Mary Tricia Ann</p>									
							</div>
							<div class="clearfix"> </div>
						</div>					
					</div>	
				</div>						
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="clearfix"></div>
<!--
		<p class="copy-right">&copy 2017 Elite shoppy. All rights reserved | Design by <a href="http://w3layouts.com/">W3layouts</a></p>-->
	</div>
</div>
<!-- //footer -->

<!-- login -->
			<div class="modal fade" id="myModal4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content modal-info">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>						
						</div>
						<div class="modal-body modal-spa">
							<div class="login-grids">
								<div class="login">
									<div class="login-bottom">
										<h3>Sign up for free</h3>
										<form>
											<div class="sign-up">
                                                    <h4>Username :</h4>
                                                    <input type="text" value="Type here" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Type here';}" required="">	
                                            </div>
                                            <div class="sign-up">
                                                    <h4>Email :</h4>
                                                    <input type="text" value="Type here" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Type here';}" required="">
                                            </div>
                                            <div class="sign-up">
                                                    <h4>Password :</h4>
                                                    <input type="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}" required="">
                                            </div>                                                            
                                            <div class="sign-up">
                                                    <h4>First Name :</h4>
                                                    <input type="text" value="Type here" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Type here';}" required="">	
                                            </div>
                                            <div class="sign-up">
                                                    <h4>Last Name :</h4>
                                                    <input type="text" value="Type here" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Type here';}" required="">	
                                            </div>      
                                            <div class="sign-up">
                                                    <h4>Address 1 :</h4>
                                                    <input type="text" value="Type here" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Type here';}" required="">	
                                            </div>
                                            <div class="sign-up">
                                                    <h4>Address 2 :</h4>
                                                    <input type="text" value="Type here" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Type here';}" required="">	
                                            </div>       
                                            <div class="sign-up">
                                                    <h4>Longitude :</h4>
                                                    <input type="text" value="Type here" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Type here';}" required="">	
                                            </div>                                                                            
                                            <div class="sign-up">
                                                    <h4>Latitude :</h4>
                                                    <input type="text" value="Type here" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Type here';}" required="">	
                                            </div>
                                            <div class="sign-up">
                                                    <h4>Credit Card :</h4>
                                                    <input type="text" value="Type here" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Type here';}" required="">	
                                            </div>
                                            <div class="sign-up">
                                                    <h4>CV :</h4>
                                                    <input type="text" value="Type here" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Type here';}" required="">		
                                            </div>
                                        <div class="sign-up">
                                            <input type="submit" value="REGISTER NOW" >
                                        </div>
											
										</form>
									</div>
									<div class="login-right">
										<h3>Sign in with your account</h3>
										<form>
											<div class="sign-in">
												<h4>Email :</h4>
												<input type="text" value="Type here" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Type here';}" required="">	
											</div>
											<div class="sign-in">
												<h4>Password :</h4>
												<input type="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}" required="">
												<a href="#">Forgot password?</a>
											</div>
											<div class="single-bottom">
												<input type="checkbox"  id="brand" value="">
												<label for="brand"><span></span>Remember Me</label>
											</div>
											<div class="sign-in">
												<input type="submit" value="SIGNIN" >
											</div>
										</form>
									</div>
									<div class="clearfix"></div>
								</div>
								<p>By logging in you agree to our <a href="#">Terms and Conditions</a> and <a href="#">Privacy Policy</a></p>
							</div>
						</div>
					</div>
				</div>
			</div>
<!-- //login -->
<a href="#home" class="scroll" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>

<!-- js -->
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<!-- //js -->
	<!-- cart-js -->
<script src="js/minicart.min.js"></script>
<script>
	// Mini Cart
	paypal.minicart.render({
		action: 'checkout.jsp'
                strings: {
                    button: "Checkout"
                }
	});

	if (~window.location.search.indexOf('reset=true')) {
		paypal.minicart.reset();
	}
</script>

	<!-- //cart-js --> 	
<!-- stats -->
<script src="js/jquery.waypoints.min.js"></script>
<script src="js/jquery.countup.js"></script>
<script>
		$('.counter').countUp();
	</script>
<!-- //stats -->
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/jquery.easing.min.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<!-- here stars scrolling icon -->
<script type="text/javascript">
		$(document).ready(function() {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			*/
								
			$().UItoTop({ easingType: 'easeOutQuart' });
								
			});
	</script>
<!-- //here ends scrolling icon -->


<!-- for bootstrap working -->
<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>
