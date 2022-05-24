<#import "/spring.ftl" as spring/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Main</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
<div id="nav-placeholder"></div>
<div style="margin-left: 150px; margin-right: 150px; margin-top: 86px; margin-bottom: 100px;">
    <div id="main_info" style="display: inline-flex">
        <div class="vertical-layout-manager">
            <span class="boldFont orange-color" style="font-size: 20pt">Короче рандом</span>
            <span class="boldFont font-size50" style="color: #FFFFFF; margin-top: 16px;">
            Imagine<br>
            Click<br>
            Random</span>
            <span class="normalFont font-size16" style="color: #FFFFFF; margin-top: 26px; line-height: 2;">Randomity - это огромная библиотека анимированных генераторов случайностей. Наша миссия - создать шоу для проведения розыгрышей, лотерей и тотализаторов.</span>
            <a href="/about" class="orange-button normalFont" style="margin-top: 50px; font-size: 16px">
                Get more details</a>
        </div>
        <img src="css/cubs.png" style="margin-right: -150px">
    </div>

    <span class="boldFont" style="font-size: 32px; color: white">Currently Trending Randomisers</span>

    <#--    List will be here-->
    <div id="list" style="margin-top: 57px; display: inline-flex; text-align: -webkit-center">
        <div id="item" style="margin-right: 47px">
            <img src="css/ex1.png" class="item-list"><br>
            <span id="title-item" class="normalFont"
                  style="color: white; font-size: 22px; text-align: -webkit-center;">
                <img src="css/fire_icon.png" style="padding-right: 8px;">40 Followers</span>
        </div>

        <div id="item" style="margin-right: 47px">
            <img src="css/ex1.png" class="item-list"><br>
            <span id="title-item" class="normalFont"
                  style="color: white; font-size: 22px; text-align: -webkit-center;">
                <img src="css/fire_icon.png" style="padding-right: 8px;">40 Followers</span>
        </div>

        <div id="item" style="margin-right: 47px">
            <img src="css/ex1.png" class="item-list"><br>
            <span id="title-item" class="normalFont"
                  style="color: white; font-size: 22px; text-align: -webkit-center;">
                <img src="css/fire_icon.png" style="padding-right: 8px;">40 Followers</span>
        </div>

        <div id="item" style="margin-right: 47px">
            <img src="css/ex1.png" class="item-list"><br>
            <span id="title-item" class="normalFont"
                  style="color: white; font-size: 22px; text-align: -webkit-center;">
                <img src="css/fire_icon.png" style="padding-right: 8px;">40 Followers</span>
        </div>
    </div>
    <#--    End of list is here-->
</div>
<footer style="background: black; padding-top: 73px; padding-bottom: 30px; color: white">

    <div style="display: inline-flex; padding-left: 100px; padding-right: 100px">
        <div style="width: 372px;">
            <span class="boldFont" style="font-size: 24pt">RANDOMITY</span><br><br>
            <span class="normalFont" style="color: white; font-size: 16px;">Lorem Ipsum is simply dummy text of the printing and typesetting industry.</span><br><br><br>
            <span class="normalFont" style="color: white; font-size: 16px; margin-top: 25px;">@Logo</span>
        </div>

        <div class="normalFont" style="margin-left: 78px; text-decoration: none; line-height: 2">
            <span style="font-weight: 600">About us</span><br><br>
            <a href="/">Zeux</a><br>
            <a href="/">Portfolio</a><br>
            <a href="/">Careers</a><br>
            <a href="/">Contact us</a>
        </div>

        <div class="normalFont" style="margin-left: 78px;
    color: white; line-height: 2">
            <span style="font-weight: 600">Contact us</span><br><br>
            <a href="/">Блабла</a><br>
            <span>+927 818 33 41</span>
        </div>

        <div style="margin-top: 150px; margin-left: 160px">
            <img src="css/facebook_icon.png">
            <img style="margin-left: -15px;" src="css/inst_icon.png">
            <img style="margin-left: -15px;" src="css/twitter_icon.png">
            <img style="margin-left: -15px;" src="css/in_icon.png">
        </div>

    </div>

    <hr style="color: white">

    <span class="normalFont" style="display:block; text-align: -webkit-center;">Copyright ® 2022 Lorem All rights Reserved</span>
</footer>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
    $(function () {
        <#if isGuest>
        $("#nav-placeholder").load("templates/guest_nav.html");
        <#else>
        $("#nav-placeholder").load("templates/user_nav.html");
        </#if>
    });
</script>
</html>