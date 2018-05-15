<link rel="icon" href="images/favicon.ico">
<link rel="shortcut icon" href="images/favicon.ico" />

<link rel="stylesheet" href="css/camera.css">
<link rel="stylesheet" href="css/owl.carousel.css">
<link rel="stylesheet" href="css/style.css">
<script src="js/jquery.js"></script>
<script src="js/jquery-migrate-1.2.1.js"></script>
<script src="js/script.js"></script>
<script src="js/superfish.js"></script>
<script src="js/jquery.ui.totop.js"></script>
<script src="js/jquery.equalheights.js"></script>
<script src="js/jquery.mobilemenu.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script src="js/owl.carousel.js"></script>
<script src="js/camera.js"></script>
<!--[if (gt IE 9)|!(IE)]><!-->
<script src="js/jquery.mobile.customized.min.js"></script>
<!--<![endif]-->

<script>
    $(document).ready(function(){
        jQuery('#camera_wrap').camera({
            loader: false,
            pagination: false ,
            minHeight: '444',
            thumbnails: false,
            height: '28.28125%',
            caption: true,
            navigation: true,
            fx: 'mosaic'
        });
        $().UItoTop({ easingType: 'easeOutQuart' });
    });
</script>