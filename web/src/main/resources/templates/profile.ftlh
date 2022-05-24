<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List</title>
    <link rel="stylesheet" href="css/common.css">
</head>
<body style="overflow-x: hidden">

<main style="margin-bottom: 50px">
    <div id="nav-placeholder"></div>
    <div style="display: flex; justify-content: center; flex-direction: row;">
        <img src="css/cubs.png" style="width: 200px;">
        <div style="display: flex;flex-direction: column;align-items: flex-start;justify-content: center;">
            <div class="boldFont font-size25" style="color: white">Name: ${userProfile.username}</div>
            <div class="boldFont font-size25" style="color: white">Email:${userProfile.email}</div>
            <div class="boldFont font-size25" style="color: white">Role: ${userProfile.role}</div>
        </div>
    </div>
</main>

<footer style="background: black; padding: 30px;">
    <span class="normalFont" style="display:block; text-align: -webkit-center; color: white">Copyright ® 2022 Строители мемасистем</span>
</footer>

</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
    $(function () {
        $("#nav-placeholder").load("templates/user_nav.html");
    });
</script>
</html>