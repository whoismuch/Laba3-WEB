let buttons = [];
let hiddenInputR = document.getElementById("newPointForm:hiddenR");
let frame = document.getElementById("frame");
let inputXGraphic = document.getElementById("pointFromGraphic:hiddenXForGraphic");
let inputYGraphic = document.getElementById("pointFromGraphic:hiddenYForGraphic");
let inputRGraphic = document.getElementById("pointFromGraphic:hiddenRForGraphic")
let chooseRTitle = document.getElementById("newPointForm:chooseRTitle");
let decision = 0;
let form = document.getElementById("pointFromGraphic");

let titleStyle = chooseRTitle.style;

function cancelButton(button) {
    decision = button.value;
    hiddenInputR.value = decision;
    inputRGraphic.value = decision;
    if (!buttons.includes(button)) buttons.push(button);
    for (var i = 0; i < buttons.length; i++) {
        if (buttons[i].value != decision) buttons[i].disabled = false;
    }
}

window.onload = function () {
    hiddenInputR.value = "";
    inputRGraphic.value = "";
};

// Обработчик события тыка на график
frame.addEventListener("click", function (event) {

    if (decision == 0) chooseRTitle.style.color = 'red';

    else {
        chooseRTitle.style = titleStyle;
        let x0 = frame.getBoundingClientRect().x;
        let y0 = frame.getBoundingClientRect().y;

        let centerX = x0 + 150;
        let centerY = y0 + 150;

        let currentX = (event.pageX - centerX)/100 * inputRGraphic.value;
        let currentY = (centerY - event.pageY)/100 * inputRGraphic.value;

        inputYGraphic.value = currentY;
        inputXGraphic.value = currentX;

        jsf.ajax.request('pointFromGraphic:send', null, {'javax.faces.behavior.event': 'action', 'execute': '@form', 'render': 'pointsTable'});
    }
});

function drawPoint(x, y, r, result) {

    console.log(x);
    console.log(y);
    console.log(r);
    console.log(result);

    const xmlns = "http://www.w3.org/2000/svg";

    let svg = document.getElementById("svg");
    let circle = document.createElementNS(xmlns, "circle");
    circle.setAttribute('cx', 150 + x / r * 100);
    circle.setAttribute('cy', 150 - y / r * 100);
    circle.setAttribute('r', 3);


    if (result) circle.style.fill = 'green';
    else circle.style.fill = 'red';

    svg.appendChild(circle)


}






