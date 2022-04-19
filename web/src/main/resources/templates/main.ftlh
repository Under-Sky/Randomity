<#import "/spring.ftl" as spring/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Main</title>
</head>
<body>
<div id="nav-placeholder"></div>
Main Page
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