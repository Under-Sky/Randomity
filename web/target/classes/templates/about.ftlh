<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>About</title>
    <link rel="stylesheet" href="css/common.css">
    <link rel="icon" type="image/x-icon" href="css/cubs.png">
</head>
<body>
<div id="nav-placeholder"></div>

<main style="margin-bottom: 50px">
    <div id="nav-placeholder"></div>

    <div style="display: flex; justify-content: center;">
        <img src="css/left_cubs.png" style="width: 500px; height: 500px;">
        <div id="canvas-placeholder" style="width: 960px; height: 540px; margin-top: 160px; margin-left: 200px; margin-right: 200px">

            <div style="margin-left: 60px">
                <div style="display: inline-flex">
                    <span>
                        <img src="css/rinat.png">
                        <p class="normalFont" style="text-align: -webkit-center; color: white; font-size: 20px">Akhmetkhanov Rinat</p>
                    </span>
                    <span style="margin-left: 206px">
                        <img src="css/damir.png">
                        <p class="normalFont" style="text-align: -webkit-center; color: white; font-size: 20px">Davletshin Damir</p>
                    </span>
                    <span style="margin-left: 206px">
                        <img src="css/bulat.png">
                        <p class="normalFont" style="text-align: -webkit-center; color: white; font-size: 20px">Fakhrutdinov Bulat</p>
                    </span>
                </div>
                <div style="display: inline-flex; margin-left: 160px">
                    <span>
                        <img src="css/angelina.png">
                        <p class="normalFont" style="text-align: -webkit-center; color: white; font-size: 20px">Evsikova Angelina</p>
                    </span>
                    <span style="margin-left: 220px">
                        <img src="css/polina.png">
                        <p class="normalFont" style="text-align: -webkit-center; color: white; font-size: 20px">Mokeeva Polina</p>
                    </span>
                </div>
            </div>

        </div>
        <img src="css/right_cubs.png" style="width: 500px; height: 500px;">
    </div>

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
</html>