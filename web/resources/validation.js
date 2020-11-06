let buttons = [];
let hiddenInputR = document.getElementById("newPointForm:hiddenR");


let decision = 0;


function cancelButton(button) {
    decision = button.value;
    hiddenInputR.value = decision;
    if (!buttons.includes(button)) buttons.push(button);
    for (var i = 0; i < buttons.length; i++) {
        if (buttons[i].value != decision) buttons[i].disabled = false;
    }
}

window.onload = function () {
    hiddenInputR.value = null;
};

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






