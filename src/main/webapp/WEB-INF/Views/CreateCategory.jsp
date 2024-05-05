<!doctype html>
<html lang="en">

	<head>
		<!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

		<!-- Meta -->
		<meta name="description" content="Moonlight - Responsive Bootstrap 5 Dashboard Template">
		<meta name="author" content="Bootstrap Gallery" />
		<link rel="canonical" href="https://www.bootstrap.gallery/">
		<meta property="og:url" content="https://www.bootstrap.gallery">
		<meta property="og:title" content="Admin Templates - Dashboard Templates | Bootstrap Gallery">
		<meta property="og:description" content="Marketplace for Bootstrap Admin Dashboards">
		<meta property="og:type" content="Website">
		<meta property="og:site_name" content="Bootstrap Gallery">
		<link rel="shortcut icon" href="assetsAdmin/images/favicon.svg">

		<!-- Title -->
		<title>Modern Admin Dashboards</title>


		<!-- *************
			************ Common Css Files *************
		************ -->

		<!-- Animated css -->
		<link rel="stylesheet" href="assetsAdmin/css/animate.css">

		<!-- Bootstrap font icons css -->
		<link rel="stylesheet" href="assetsAdmin/fonts/bootstrap/bootstrap-icons.css">

		<!-- Main css -->
		<link rel="stylesheet" href="assetsAdmin/css/main.min.css">


		<!-- *************
			************ Vendor Css Files *************
		************ -->

		<!-- Scrollbar CSS -->
		<link rel="stylesheet" href="assetsAdmin/vendor/overlay-scroll/OverlayScrollbars.min.css">

	</head>

	<body>

		<!-- Page wrapper start -->
		<div class="page-wrapper">

			<!-- Sidebar wrapper start -->
			<nav class="sidebar-wrapper">

				<!-- Sidebar brand starts -->
				<div class="sidebar-brand">
					<a href="index.html" class="logo">
						<img src="Images/blog_logoo.png" alt="Moonlight Admin Dashboard" />
					</a>
				</div>
				<!-- Sidebar brand starts -->

				<!-- Sidebar menu starts -->
				<div class="sidebar-menu">
					<div class="sidebarMenuScroll">
						<ul>
							<li class="sidebar">
								<a href="#">
									<i class="bi bi-file-earmark-plus"></i>
									<span class="menu-text">Articles</span>
								</a>
							</li>
							<li class="sidebar">
								<a href="#">
									<i class="bi bi-person"></i>
									<span class="menu-text">Users</span>
								</a>
							</li>

						</ul>
					</div>
				</div>
				<!-- Sidebar menu ends -->

			</nav>
			<!-- Sidebar wrapper end -->

			<!-- *************
				************ Main container start *************
			************* -->
			<div class="main-container">

				<!-- Page header starts -->
				<div class="page-header">

					<div class="toggle-sidebar" id="toggle-sidebar"><i class="bi bi-list"></i></div>

					<!-- Breadcrumb start -->
					<ol class="breadcrumb">
						<li class="breadcrumb-item">
							<i class="bi bi-house"></i>
							<a href="/Admin">Dashboard</a>
						</li>
					</ol>
					<!-- Breadcrumb end -->

					<!-- Header actions ccontainer start -->
					<div class="header-actions-container">

						<!-- Search container start -->
						<div class="search-container">
						</div>
						<!-- Header actions start -->
						<ul class="header-actions">
							<li class="dropdown">
								<a href="#" id="userSettings" class="user-settings" data-toggle="dropdown" aria-haspopup="true">
									<span class="user-name d-none d-md-block">Abigale Heaney</span>
									<span class="avatar">
										<img src="assetsAdmin/images/user.png" alt="Admin Templates">
										<span class="status online"></span>
									</span>
								</a>
								<div class="dropdown-menu dropdown-menu-end" aria-labelledby="userSettings">
									<div class="header-profile-actions">
										<a href="#">Profile</a>
										<a href="#">Logout</a>
									</div>
								</div>
							</li>
						</ul>
						<!-- Header actions end -->

					</div>
					<!-- Header actions ccontainer end -->

				</div>
				<!-- Page header ends -->

				<!-- Content wrapper scroll start -->
				<div class="content-wrapper-scroll">

					<!-- Content wrapper start -->
					<div class="content-wrapper">

						<!-- Row start -->
						<div class="row">
							<div class="col-sm-12 col-12">

								<!-- Card start -->
								<div class="card">
									<div class="card-header">
										<div class="card-title">Create A New Category</div>
									</div>
									<div class="card-body">

										<!-- Row start -->
										<form action="SaveCategory" method="post">
											<div class="row mb-3">
												<label class="col-sm-2 col-form-label">Name:</label>
												<div class="col-sm-3">
													<input type="text" class="form-control" id="Name" placeholder="Enter name" name="Name">
												</div>
											</div>

											<div class="row mb-3">
												<label class="col-sm-2 col-form-label">Description:</label>
												<div class="col-sm-3">
													<textarea id="Content" name="Content" rows="4" cols="50"></textarea>
												</div>
											</div>
											<!-- Form actions footer start -->
											<div class="form-actions-footer">
												<button class="btn btn-light" >Cancel</button>
												<button class="btn btn-success" type="submit">Submit</button>
											</div>
										</form>
										<!-- Row end -->


										<!-- Form actions footer end -->

									</div>
								</div>
								<!-- Card end -->

							</div>

						</div>
						<!-- Row end -->
					</div>
					<!-- Content wrapper end -->

					<!-- App Footer start -->
					<div class="app-footer">
						<span>© Emsi Maarif 2024</span>
					</div>
					<!-- App footer end -->

				</div>
				<!-- Content wrapper scroll end -->

			</div>
			<!-- *************
				************ Main container end *************
			************* -->

		</div>
		<!-- Page wrapper end -->

		<!-- *************
			************ Required JavaScript Files *************
		************* -->
		<!-- Required jQuery first, then Bootstrap Bundle JS -->
		<script src="assetsAdmin/js/jquery.min.js"></script>
		<script src="assetsAdmin/js/bootstrap.bundle.min.js"></script>
		<script src="assetsAdmin/js/modernizr.js"></script>
		<script src="assetsAdmin/js/moment.js"></script>

		<!-- *************
			************ Vendor Js Files *************
		************* -->

		<!-- Overlay Scroll JS -->
		<script src="assetsAdmin/vendor/overlay-scroll/jquery.overlayScrollbars.min.js"></script>
		<script src="assetsAdmin/vendor/overlay-scroll/custom-scrollbar.js"></script>

		<!-- Main Js Required -->
		<script src="assetsAdmin/js/main.js"></script>

	</body>

</html>