<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Generator</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="icon" type="image/x-icon" href="css/cubs.png">
</head>
<body style="overflow-x: hidden">

<main style="margin-bottom: 50px">
    <div id="nav-placeholder"></div>

    <div style="display: flex; justify-content: center;">
        <img src="css/left_cubs.png" style="width: 500px; height: 500px">
        <div id="canvas-placeholder" style="background: blueviolet; width: 960px; height: 540px;"></div>
        <img src="css/right_cubs.png" style="width: 500px; height: 500px">
    </div>

    <button id="activate_btn">Activate</button>
</main>

<footer style="background: black; padding: 30px;">
    <span class="normalFont" style="display:block; text-align: -webkit-center; color: white">Copyright ® 2022 Строители мемасистем</span>
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
<script>
    $(function () {
        $("#canvas-placeholder").load("${genPath}", function () {
            $("#activate_btn").click(function () {
                // console.log(unityInstance);
                // unityInstance.SendMessage('PirateCoin (Brass)', 'AddForce', true);
                unityInstance.then((uI) => {
                    uI.SendMessage('PirateCoin (Brass)', 'AddForce', 'true');
                });
            });
        });
    });
    console.log(unityInstance);
</script>
</html>