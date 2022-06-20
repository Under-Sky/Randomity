<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Randomity Wheel</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="icon" type="image/x-icon" href="css/cubs.png">
</head>
<body>
<div id="nav-placeholder"></div>
Wheel
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