<%@page pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/5.3.3/css/bootstrap.min.css">
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

<!-- Loading wrapper start -->
<!-- <div id="loading-wrapper">
    <div class="spinner">
        <div class="line1"></div>
        <div class="line2"></div>
        <div class="line3"></div>
        <div class="line4"></div>
        <div class="line5"></div>
        <div class="line6"></div>
    </div>
</div> -->
<!-- Loading wrapper end -->

<!-- Page wrapper start -->
<div class="page-wrapper">

    <!-- Sidebar wrapper start -->
    <nav class="sidebar-wrapper">

        <!-- Sidebar brand starts -->
        <div class="sidebar-brand">
            <a href="index.html" class="logo">
                <img src="assetsAdmin/images/logo.svg" alt="Moonlight Admin Dashboard" />
            </a>
        </div>
        <!-- Sidebar brand starts -->

        <!-- Sidebar menu starts -->
        <div class="sidebar-menu">
            <div class="sidebarMenuScroll">
                <ul>
                    <li class="sidebar-dropdown">
                        <a href="#">
                            <i class="bi bi-house"></i>
                            <span class="menu-text">Dashboards</span>
                        </a>
                        <div class="sidebar-submenu">
                            <ul>
                                <li>
                                    <a href="index.html">eCommerce</a>
                                </li>
                                <li>
                                    <a href="analytics.html">Analytics</a>
                                </li>
                            </ul>
                        </div>
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
                        <div class="card">
                            <div class="card-header">
                                <div class="card-title">Customers</div>
                            </div>
                            <div class="card-body">

                                <div class="table-responsive">
                                    <table class="table v-middle m-0">
                                        <thead>
                                        <tr>
                                            <th>id</th>
                                            <th>Name</th>
                                            <th>Description</th>
                                            <th>Nbr of Articles</th>
                                            <th>Actions</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${cats_list}" var="category">
                                            <tr>
                                                <td>
                                                        ${category.id}
                                                </td>
                                                <td>
                                                    <div class="media-box">
                                                        <div class="media-box-body">
                                                            <p>${category.name}</p>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                  ${category.content}
                                                </td>
                                                <td></td>
                                                <td>
                                                    <div class="actions">
                                                        <a href="ShowCategory?id=${category.id}" class="viewRow">
                                                            <i class="bi bi-list text-green"></i>
                                                        </a>
                                                        <a onclick="return confirm('Are you sure to delete this Item?')" href="DeleteCategory?id=${category.id}" class="deleteRow">
                                                            <i class="bi bi-trash text-red"></i>
                                                        </a>
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>


                                        </tbody>
                                    </table>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
                <!-- Row end -->

            </div>
            <!-- Content wrapper end -->

            <!-- App Footer start -->
            <div class="app-footer">
                <span>© Bootstrap Gallery 2023</span>
            </div>
            <!-- App footer end -->

        </div>
        <!-- Content wrapper scroll end -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-success" data-bs-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>

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

<!-- Product Js -->
<script src="assetsAdmin/js/product.js"></script>

</body>

</html>