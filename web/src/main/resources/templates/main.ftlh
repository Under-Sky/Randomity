<#import "/spring.ftl" as spring/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Main</title>
    <link rel="stylesheet" href="css/common.css">
</head>
<body>
<div id="nav-placeholder"></div>
<div id="main_info" style="display: table">
    <div class="vertical-layout-manager">
        <p class="boldFont orange-color">Короче рандом</p>
        <p class="boldFont font-size50" style="color: #FFFFFF">Bla
            bla
            blaaaaaaa</p>
        <p class="normalFont font-size16" style="color: #FFFFFF">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard.</p>
    </div>
    <img src="css/cubs.png">
</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<#if isGuest>
    <script>
        $(function () {
            $("#nav-placeholder").load("templates/guest_nav.html");
        });
    </script>
<#else>
    <script>
        $(function () {
            $("#nav-placeholder").load("templates/user_nav.html");
        });
    </script>
</#if>
</html>