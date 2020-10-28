function drawOnCanvas() {
    let canvas = document.getElementById('canvas');
    let context = canvas.getContext('2d');
    context.strokeRect(0,0, canvas.width, canvas.height);

    let radiusClock = canvas.width/2 - 10;
    let xCenterClock = canvas.width/2;
    let yCenterClock = canvas.height/2;

    //Очистка экрана.
    context.globalAlpha = 0.77;
    context.fillStyle = "#ffffff";
    context.globalAlpha = 1;
    context.fillRect(0,0,canvas.width,canvas.height);

    //Рисуем контур часов
    context.strokeStyle =  "#000000";
    context.lineWidth = 2;
    context.beginPath();
    context.arc(xCenterClock, yCenterClock, radiusClock, 0, 2*Math.PI, true);
    context.moveTo(xCenterClock, yCenterClock);
    context.stroke();
    context.closePath();

    //Рисуем рисочки часов
    var radiusNum = radiusClock - 10; //Радиус расположения рисочек
    var radiusPoint;
    for(var tm = 0; tm < 60; tm++){
        context.beginPath();
        if(tm % 5 == 0){context.fillStyle = "#FFEFD5"; radiusPoint = 5;}else{radiusPoint = 2;} //для выделения часовых рисочек
        var xPointM = xCenterClock + radiusNum * Math.cos(-6*tm*(Math.PI/180) + Math.PI/2);
        var yPointM = yCenterClock - radiusNum * Math.sin(-6*tm*(Math.PI/180) + Math.PI/2);
        context.arc(xPointM, yPointM, radiusPoint, 0, 2*Math.PI, true);
        context.fill();
        context.stroke();
        context.closePath();
    }

    //Оцифровка циферблата часов
    for(var th = 1; th <= 12; th++){
        context.beginPath();
        context.font = 'bold 33px sans-serif';
        var xText = xCenterClock + (radiusNum - 30) * Math.cos(-30*th*(Math.PI/180) + Math.PI/2);
        var yText = yCenterClock - (radiusNum - 30) * Math.sin(-30*th*(Math.PI/180) + Math.PI/2);
        if(th <= 9){
            context.strokeText(th, xText - 5 , yText + 10);
            context.fillStyle = "#B0C4DE";
            context.fillText(th, xText-5, yText +10);
        }else{
            context.strokeText(th, xText - 15 , yText + 10);
            context.fillStyle = "#B0C4DE";
            context.fillText(th, xText - 15 , yText + 10);
        }
        context.stroke();
        context.closePath();
    }


    //Рисуем стрелки
    var lengthSeconds = radiusNum - 10;
    var lengthMinutes = radiusNum - 15;
    var lengthHour = lengthMinutes / 1.5;
    var d = new Date();                //Получаем экземпляр даты
    var t_sec = 6*d.getSeconds();                           //Определяем угол для секунд
    var t_min = 6*(d.getMinutes() + (1/60)*d.getSeconds()); //Определяем угол для минут
    var t_hour = 30*(d.getHours() + (1/60)*d.getMinutes()); //Определяем угол для часов

    //Рисуем секунды
    context.beginPath();
    context.strokeStyle =  "#FF0000";
    context.moveTo(xCenterClock, yCenterClock);
    context.lineTo(xCenterClock + lengthSeconds*Math.cos(Math.PI/2 - t_sec*(Math.PI/180)),
        yCenterClock - lengthSeconds*Math.sin(Math.PI/2 - t_sec*(Math.PI/180)));
    context.stroke();
    context.closePath();

    //Рисуем минуты
    context.beginPath();
    context.strokeStyle =  "#000000";
    context.lineWidth = 3;
    context.moveTo(xCenterClock, yCenterClock);
    context.lineTo(xCenterClock + lengthMinutes*Math.cos(Math.PI/2 - t_min*(Math.PI/180)),
        yCenterClock - lengthMinutes*Math.sin(Math.PI/2 - t_min*(Math.PI/180)));
    context.stroke();
    context.closePath();

    //Рисуем часы
    context.beginPath();
    context.lineWidth = 5;
    context.moveTo(xCenterClock, yCenterClock);
    context.lineTo(xCenterClock + lengthHour*Math.cos(Math.PI/2 - t_hour*(Math.PI/180)),
        yCenterClock - lengthHour*Math.sin(Math.PI/2 - t_hour*(Math.PI/180)));
    context.stroke();
    context.closePath();

    //Рисуем центр часов
    context.beginPath();
    context.strokeStyle =  "#000000";
    context.fillStyle = "#ffffff";
    context.lineWidth = 3;
    context.arc(xCenterClock, yCenterClock, 5, 0, 2*Math.PI, true);
    context.stroke();
    context.fill();
    context.closePath();

    return;
}

window.onload = function () {
    let date = new Date();
    document.getElementById("date").innerHTML = date.toLocaleDateString();
    drawOnCanvas();

    window.setInterval(
        function() {
            let date = new Date();
            document.getElementById("date").innerHTML = date.toLocaleDateString();
            drawOnCanvas();
        }, 10000);

}